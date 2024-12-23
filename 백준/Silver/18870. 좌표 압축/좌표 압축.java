
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nodeNum = Integer.parseInt(br.readLine());
        int[] nodeList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        /*
        노드 개수가 백만개가 제한이므로, for 문 한번밖에 돌리지 못한다.
        가장 작은 노드가 0, 그다음이 1 .. 이런식으로 좌표를 압축해야 한다.
        그렇다면 노드의 순서를 알아야되는데 .. 그냥 sort 하고 인덱스 찾으면 되는거아님? 근데 오래 걸릴듯 .. 하나에 백만번을 돈다고 하면?
         */

        Set<Integer> deleteDuplicateSet = new HashSet<>();
        for (int i: nodeList)
            deleteDuplicateSet.add(i);

        int[] sortedNodeList = deleteDuplicateSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sortedNodeList);

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sortedNodeList.length; i++) {
            indexMap.put(sortedNodeList[i], i);
        }

        for (int i = 0; i < nodeNum; i++) {
            bw.write(indexMap.get(nodeList[i]) + " ");
        }
        bw.flush();
    }
}