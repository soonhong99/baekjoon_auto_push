import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberParticipants = Integer.parseInt(br.readLine());

        int[][] participantsInfo= seekInformationSubscribedUsers(numberParticipants, br);

        Arrays.sort(participantsInfo, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        Arrays.sort(participantsInfo, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return 0;
        }));

        for (int i = 0; i < numberParticipants; i++) {
            System.out.println(participantsInfo[i][0] + " " + participantsInfo[i][1]);
        }
    }

    private static int[][] seekInformationSubscribedUsers(int numberParticipants, BufferedReader br) throws Exception{
        int[][] participantsInfo = new int[numberParticipants][2];
        int[] participantInfo;
        for (int i = 0; i < numberParticipants; i++) {
            participantInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            participantsInfo[i][0] = participantInfo[0];
            participantsInfo[i][1] = participantInfo[1];
        }

        return participantsInfo;
    }
}
