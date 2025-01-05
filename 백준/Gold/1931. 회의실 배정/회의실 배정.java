
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int conferenceNum = Integer.parseInt(br.readLine());
        ArrayList<int[]> conferenceList = new ArrayList<>();
        for (int i = 0; i < conferenceNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            conferenceList.add(new int[] {startTime, endTime});
        }
        Collections.sort(conferenceList, (con1, con2) -> {
            if (con2[1] == con1[1])
                return con1[0] - con2[0];
            return con1[1] - con2[1];
        });
        int totalConference = 1;
        int endTime = conferenceList.get(0)[1];
        for (int i = 1; i < conferenceNum; i++) {
            int nextStartTime = conferenceList.get(i)[0];
            if (endTime <= nextStartTime) {
                totalConference++;
                endTime = conferenceList.get(i)[1];
            }
        }
        System.out.println(totalConference);
    }
}