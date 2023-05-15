import java.io.BufferedWriter;
import java.io.IOException;

public class decisionNode implements treeNode{//leaf node
	protected String decision;//only stores decision(classification)	
	
	public String getDecision() {
		return decision;
	}


	public void setDecision(String decision) {
		this.decision = decision;
	}

	//writes decision
	public void printNode(BufferedWriter writeF) throws IOException {
		writeF.write("decision node\n"+decision+"\n");
	}
}
