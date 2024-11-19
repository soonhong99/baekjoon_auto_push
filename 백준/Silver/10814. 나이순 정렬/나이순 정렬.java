import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberParticipants = Integer.parseInt(br.readLine());

        String[][] participantsInfo= seekInformationSubscribedUsers(numberParticipants, br);

        Arrays.sort(participantsInfo, ((o1, o2) -> {
            int intO1 = Integer.parseInt(o1[0]);
            int intO2 = Integer.parseInt(o2[0]);
            return intO1 - intO2;
        }));

        for (int i = 0; i < numberParticipants; i++) {
            System.out.println(participantsInfo[i][0] + " " + participantsInfo[i][1]);
        }
        // System.out.println(Arrays.deepToString(participantsInfo));
        // int[][] ranking = calculateRanking(participantsSizes);

//        for (int i = 0; i < numberParticipants; i++) {
//            System.out.print(ranking[i][2] + " ");
//        }
    }

    private static String[][] seekInformationSubscribedUsers(int numberParticipants, BufferedReader br) throws Exception{
        String[][] participantsInfo = new String[numberParticipants][2];
        String[] participantInfo;
        for (int i = 0; i < numberParticipants; i++) {
            participantInfo = br.readLine().split(" ");
            participantsInfo[i][0] = participantInfo[0];
            participantsInfo[i][1] = participantInfo[1];
        }

        return participantsInfo;
    }

//    private static int[][] calculateRanking(int[][] participantsSizes) {
//        /*
//        체중과 키를 비교하면서 두개다 큰 사람이 다른 사람보다 등수가 높아야 한다.
//        겹치는 사람의 문제를 어떻게?
//        다른 사람들하고 다 비교하고 자신의 등수를 파악하기
//         */
//        int maxSize = participantsSizes.length;
//
//        for (int j = 0; j < maxSize; j++) {
//            int myRank = 1;
//            int myKg = participantsSizes[j][0];
//            int myCm = participantsSizes[j][1];
//            for (int i = 0; i < maxSize; i++) {
//                if (participantsSizes[i][0] > myKg && participantsSizes[i][1] > myCm) {
//                    myRank ++;
//                }
//            }
//            participantsSizes[j][2] = myRank;
//        }
//        return participantsSizes;
//    }
}
