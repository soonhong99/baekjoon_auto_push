import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        // TODO: 프로그램 구현
        /*
        N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
        만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
        이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.

        이름	(몸무게, 키)	덩치 등수
        A	(55, 185)	2
        B	(58, 183)	2
        C	(88, 186)	1
        D	(60, 175)	2
        E	(46, 155)	5
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberParticipants = Integer.parseInt(br.readLine());

        int[][] participantsSizes = measureParticipantsSize(numberParticipants, br);

        int[][] ranking = calculateRanking(participantsSizes);

        for (int i = 0; i < numberParticipants; i++) {
            System.out.print(ranking[i][2] + " ");
        }
    }

    private static int[][] measureParticipantsSize(int numberParticipants, BufferedReader br) throws Exception{
        int[][] participantsSizes = new int[numberParticipants][3];
        int[] participantSizes;
        for (int i = 0; i < numberParticipants; i++) {
            participantSizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            participantsSizes[i][0] = participantSizes[0];
            participantsSizes[i][1] = participantSizes[1];
            participantsSizes[i][2] = -1;
        }

        return participantsSizes;
    }

    private static int[][] calculateRanking(int[][] participantsSizes) {
        /*
        체중과 키를 비교하면서 두개다 큰 사람이 다른 사람보다 등수가 높아야 한다.
        겹치는 사람의 문제를 어떻게?
        다른 사람들하고 다 비교하고 자신의 등수를 파악하기
         */
        int maxSize = participantsSizes.length;

        for (int j = 0; j < maxSize; j++) {
            int myRank = 1;
            int myKg = participantsSizes[j][0];
            int myCm = participantsSizes[j][1];
            for (int i = 0; i < maxSize; i++) {
                if (participantsSizes[i][0] > myKg && participantsSizes[i][1] > myCm) {
                    myRank ++;
                }
            }
            participantsSizes[j][2] = myRank;
        }
        return participantsSizes;
    }
}
