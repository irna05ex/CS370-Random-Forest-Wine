import java.io.BufferedWriter;
import java.io.IOException;

public class branchNode implements treeNode{//internal node
	private String comparisonAttribute;
	private Object comparisonValue;
	//since only 1 categorical attribute with 2 options all nodes only need 2 children
	protected treeNode left;
	protected treeNode right;
	
	treeNode compare(wine w) {		
		int c = 0;
		if(comparisonAttribute.equals("color")) {
			c = (w.getType().compareTo((String) comparisonValue));
		}
		else if(comparisonAttribute.equals("fixed acidity")) {
			if(w.getFixedAcidity() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("volatile acidity")) {
			if(w.getVolatileAcidity() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("citric acid")) {
			if(w.getCitricAcid() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("chlorides")) {
			if(w.getChlorides() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		
		else if(comparisonAttribute.equals("free sulfer")) {
			if(w.getFreeSulfer() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("total sulfer")) {
			if(w.getTotalSulfer() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("density")) {
			if(w.getDensity() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("pH")) {
			if(w.getpH() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("sulfates")) {
			if(w.getSulfates() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		else if(comparisonAttribute.equals("alcohal")) {
			if(w.getAlcohal() < (float) comparisonValue)
				c = -1;
			else
				c = 1;
		}
		
		//if w.attribute is less than comparisonValue return left
		if(c < 0)
			return left;
		
		return right;//else return right
	}
	
	public void printNode(BufferedWriter writeF) throws IOException {//writes all info of specific node(do not write left or right nodes)
		writeF.write("branch node\n" + comparisonAttribute + "\n" + comparisonValue.toString() +"\n");
	}

	public String getComparisonAttribute() {
		return comparisonAttribute;
	}

	public void setComparisonAttribute(String comparisonAttribute) {
		this.comparisonAttribute = comparisonAttribute;
	}

	public Object getComparisonValue() {
		return comparisonValue;
	}

	public void setComparisonValue(Object comparisonValue) {
		this.comparisonValue = comparisonValue;
	}
	
}
