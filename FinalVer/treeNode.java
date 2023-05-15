import java.io.BufferedWriter;
import java.io.IOException;

//no further changes needed for interface
//merge internal node and leaf node in a unified interface
public interface treeNode {
	public void printNode(BufferedWriter writeF) throws IOException;//defined in classes decisionNode, branchNode
}
