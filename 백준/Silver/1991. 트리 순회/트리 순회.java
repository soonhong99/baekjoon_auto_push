
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static String preCircuitResult = "";
    static String middleCircuitResult = "";
    static String lastCircuitResult = "";
    static HashMap<String, ArrayList<String>> tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        for (int i = 0; i < nodeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parentNode = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();
            ArrayList<String> childNodes = new ArrayList<>();
            childNodes.add(leftNode);
            childNodes.add(rightNode);
            tree.put(parentNode, childNodes);
        }

        preCircuit("A");
        middleCircuit("A");
        lastCircuit("A");

        System.out.println(preCircuitResult);
        System.out.println(middleCircuitResult);
        System.out.println(lastCircuitResult);
    }

    private static void preCircuit(String startNode) {
        ArrayList<String> childNodes = tree.get(startNode);
        String leftChild = childNodes.get(0);
        String rightChild = childNodes.get(1);
        if (leftChild.equals(".") && rightChild.equals(".")) {
            preCircuitResult += startNode;
            return;
        }
        preCircuitResult += startNode;
        if (!leftChild.equals("."))
            preCircuit(leftChild);
        if (!rightChild.equals("."))
            preCircuit(rightChild);
    }

    private static void middleCircuit(String startNode) {
        ArrayList<String> childNodes = tree.get(startNode);
        String leftChild = childNodes.get(0);
        String rightChild = childNodes.get(1);
        boolean leftVisited = false;
        if (leftChild.equals(".") && rightChild.equals(".")) {
            middleCircuitResult += startNode;
            return;
        }
        if (!leftChild.equals(".")) {
            middleCircuit(leftChild);
            middleCircuitResult += startNode;
            leftVisited = true;
        }
        if (!rightChild.equals(".")) {
            if (!leftVisited)
                middleCircuitResult += startNode;
            middleCircuit(rightChild);
        }
    }

    private static void lastCircuit(String startNode) {
        ArrayList<String> childNodes = tree.get(startNode);
        String leftChild = childNodes.get(0);
        String rightChild = childNodes.get(1);
        if (leftChild.equals(".") && rightChild.equals(".")) {
            lastCircuitResult += startNode;
            return;
        }
        if (!leftChild.equals(".")) {
            lastCircuit(leftChild);
        }
        if (!rightChild.equals(".")) {
            lastCircuit(rightChild);
        }
        lastCircuitResult += startNode;
    }
}