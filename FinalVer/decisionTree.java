import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class decisionTree {
	private int attributes;//number of attributes tree considers
	protected String attribute[];//attributes tree considers (no repeated attribute within single tree)
	protected wine dataset[];//dataset used (only root can see entire set)
	protected treeNode root;
	private int maxDepth;//max depth tree will reach
	
	private float [] interval;//determine possible threshold values for each continuous variable	
	private float [] min;//min value of each continuous variable
	private float [] max;//max
	
	decisionTree(int m, String [] at, wine [] data){
		maxDepth = m;
		attribute = at;
		dataset = data;
		if(attribute != null) {
			attributes = attribute.length;
			interval = new float[attributes];
			min = new float[attributes];
			max = new float[attributes];
		}
	}
	
	void buildTree() {
		calculateInterval();
		root = buildingTree(0, dataset);//root is always depth 0, root has entire data set to look through
	}
	
	//find good threshold values for each continuous variable independently
	//also finds min and max value for each continuous variable
	public void calculateInterval() {
		float avg = 0;
		float v;
		int i = 0;
		if(attribute[0].equals("color"))//skip categorical attribute
			i = 1;
		
		while(i<interval.length) {//find interval for each attribute
			min[i] = 9999;
			max[i] = 0;
			avg = 0;
			
			for(int j = 0; j<dataset.length; j++) {
				v = (float) dataset[j].getByName(attribute[i]);
				avg += v;
				
				if(v>max[i])
					max[i] = v;
				else if(v<min[i])
					min[i] = v;
			}
			avg /= (float)dataset.length;
			interval[i] = (float) (avg-min[i]/10.0);//calculate interval
			i++;
		}
	}
	
	
	//needs pass subset of dataset applicable to current branch
	treeNode buildingTree(int depth, wine [] set) {
		if(depth == maxDepth-1) {//max depth reached, return majority classification
			decisionNode n = new decisionNode();
			int l = 0, r = 0;
			for(int i = 0; i<set.length; i++) {
				if(set[i].getQuality() > 0)
					r++;//good
				else
					l++;//bad
			}
			if(l>r)
				n.setDecision("bad quality");
			else
				n.setDecision("good quality");
			return n;
		}
		
		float giniNoSplit = calculateGini(null,null,set);//current gini index of subset
		if(giniNoSplit == 0) {//current set contains 1 class
			decisionNode n = new decisionNode();
			if(set[0].getQuality() == 0)
				n.setDecision("bad quality");
			else
				n.setDecision("good quality");
			
			return n;
		}
		
		float gain = (float) 0.0;//store maximum gini gain
		String chooseSplit = "";//best split attribute for gini gain
		Object splitValue = null;//best split value for gini gain
		float giniSplit;//gini index for splitting
		int find = 0;
		if(attribute[0].equals("color")) {
			find = 1;
			giniSplit = calculateGini(attribute[0], "white", set);
			if(gain < giniNoSplit - giniSplit) {
				gain = giniNoSplit - giniSplit;
				chooseSplit = "color";
				splitValue = "white";
			}
			if(gain == giniNoSplit) {//perfect split, stop checking
				find = attributes;
			}
		}
		
		while(find < attributes) {//find best split from continuous variable
			//possible threshold is interval added to min
			//keep adding interval to possible interval until is greater than max(attribute cannot be split anymore)
			for(float thresHold = min[find] + interval[find]; thresHold<max[find]; thresHold += interval[find]) {
				giniSplit = calculateGini(attribute[find], thresHold, set);
				if(gain < giniNoSplit - giniSplit) {
					gain = giniNoSplit - giniSplit;
					chooseSplit =  attribute[find];
					splitValue = thresHold;
				}
				if(gain == giniNoSplit)//perfect split, stop searching 
					break;
			}
			find++;
		}
		
		if(gain == 0.0) {//no better split found return decision node with majority classification
			decisionNode d = new decisionNode();
			int l = 0, r = 0;
			for(int i = 0; i<set.length; i++) {
				if(set[i].getQuality() > 0)
					r++;//good
				else
					l++;//bad
			}
			if(l>r)
				d.setDecision("bad quality");
			else
				d.setDecision("good quality");
			return d;
		}
		
		//a better split is found
		branchNode m = new branchNode();//create branch node needed for maximum gain
		m.setComparisonAttribute(chooseSplit);
		m.setComparisonValue(splitValue);
		wine [] left;
		wine [] right;
		int side = 0;//amount in left branch
		//create subset for each child
		for(int check = 0; check<set.length; check++) {//count wines in left and right branch
			if(chooseSplit.equals("color")){
				if(set[check].getType().equals("red"))
					side++;
			}
			else {
				if((float) set[check].getByName(chooseSplit) < (float) splitValue)
					side++;
			}
		}
		left = new wine[side];
		right = new wine[set.length - side];
		
		int l = 0, r = 0;
		for(int check = 0; check<set.length; check++) {//assign wines to correct branch
			if(chooseSplit.equals("color")){
				if(set[check].getType().equals("red"))
					left[l++] = set[check]; 
				else
					right[r++] = set[check];
			}
			else {
				if((float) set[check].getByName(chooseSplit) < (float) splitValue)
					left[l++] = set[check];
				else
					right[r++] = set[check];
			}
		}
		
		m.left = buildingTree(depth+1, left);//recursive call to create left child subtree
		m.right = buildingTree(depth+1, right);//recursive call to create right child subtree
		
		return m;//return branch node(current subtree)
	}
	
	//calculate gini value of splitting set using attribute and value
	//if attribute is null calculate without split
	public float calculateGini(String atr, Object value, wine [] set) {
		if(atr == null) {
			int s = set.length;
			int good = 0;
			int bad = 0;
			for(int c = 0; c<s; c++) {//count each good and bad quality wine
				if(set[c].getQuality() == 1)
					good++;
				else
					bad++;
			}
			
			float p1 = (float)good/(float)s;
			float p2 = (float)bad/(float)s;
			//simplify for 2 classifications 
			float g = (float)((p1 *(1.00 - p1) ) + (p2 * (1.00-p2)));
			return g;
		}
		
		int leftGood = 0, leftBad = 0, rightGood = 0, rightBad = 0;
		for(int i = 0; i<set.length; i++) {
			if(atr.equals("color")) {
				if(set[i].getType().compareTo((String) value) < 0) {
					if(set[i].getQuality() == 0)
						leftBad++;
					else
						leftGood++;
				}
				else {
					if(set[i].getQuality() == 0)
						rightBad++;
					else
						rightGood++;
				}
			}
			else {
				float getV = (float) set[i].getByName(atr);
				float cV = (float) value;
				if(getV < cV) {
					if(set[i].getQuality() == 0)
						leftBad++;
					else
						leftGood++;
				}
				else {
					if(set[i].getQuality() == 0)
						rightBad++;
					else
						rightGood++;
				}
			}
		}
		
		float tL = (leftBad + leftGood);
		float p1L = (float)leftBad/tL;
		float p2L = (float)leftGood/tL;
		
		float tR = (rightBad + rightGood);
		float p1R = (float)rightBad/tR;
		float p2R = (float)rightGood/tR;
		
		float gL = (float) ((p1L * (1.0 - p1L)) + (p2L * (1.0 - p2L)));
		float gR = (float) ((p1R * (1.0 - p1R)) + (p2R * (1.0 - p2R)));
		return (((tL/set.length) * gL) + ((tR/set.length) * gR));
	}
	
	public String test(wine w) {//test wine through tree
		treeNode p = root;
		
		while(p instanceof branchNode) {//loop until p becomes a leaf node
			p = ((branchNode) p).compare(w);
		}
		
		return ((decisionNode)p).getDecision();//return leaf nodes decision
	}
	
	
	//write tree to file
	public void printTree(BufferedWriter writeF) throws IOException {
		printTreeR(root,writeF);
		writeF.write("\n");
	}
	
	//write tree to file in preorder traversal
	private void printTreeR(treeNode r, BufferedWriter writeF) throws IOException {
		if(r == null)
			return;
		
		//write correct node info
		if(r instanceof branchNode) {
			((branchNode)r).printNode(writeF);
			printTreeR(((branchNode)r).left, writeF);
			printTreeR(((branchNode)r).right, writeF);
		}
		else if(r instanceof decisionNode) {
			((decisionNode)r).printNode(writeF);
		}
		
		writeF.flush();
	}
	
	//read file and construct tree in preorder traversal
	public void readTree(Scanner read) {
		root = readingTree(read);
	}
	
	private treeNode readingTree(Scanner read) {
		String s = read.nextLine();
		
		if(s.equals("branch node")) {//create branch node
			branchNode b = new branchNode();
			s = read.nextLine();
			b.setComparisonAttribute(s);
			if(s.equals("color"))
				b.setComparisonValue(read.nextLine());
			else {
				s = read.nextLine();
				Float f = Float.parseFloat(s);
				b.setComparisonValue(f);
			}
			
			//recursive call for preorder traversal
			b.left = readingTree(read);
			b.right = readingTree(read);
			return b;
		}
		
		//if branch node not created decision node created
		decisionNode d = new decisionNode();
		d.setDecision(read.nextLine());
		return d;//decision nodes have no children, no recursive call required
	}
}
 