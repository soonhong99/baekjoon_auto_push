
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int conferenceNum = Integer.parseInt(br.readLine());

        /*
        첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
        둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
        시작 시간과 끝나는 시간은 2 ** 31 - 1 보다 작거나 같은 자연수 또는 0이다.
        첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

        최대값? dp? 하나의 선택을 했을 때, 해당 선택이 뒤에 있는 결과에 영향을 미친다. -> 이게 sort가 되어 있어야 하는데, sort를 시키기 애매하네?
        정렬의 필요성? -> 길이가 짧은 것 부터 이용한다? -> 정렬을 한 다음에 어떻게 선별할거야? -> 첫 시작점을 기준으로 정렬?
        하나를 선택하고, 그 다음 선택지가 바로 바로 보일 수 있어야 한다.
         */
        List<int[]> conferenceSchedule = new ArrayList<>();

        for (int i = 0; i < conferenceNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());
            conferenceSchedule.add(new int[] {startNum, endNum});
        }

        Collections.sort(conferenceSchedule, (sc1, sc2) -> {
            if (sc1[1] == sc2[1])
                return sc1[0] - sc2[0];
            return sc1[1] - sc2[1];
        });

        int totalConferenceNum = 1;
        int endTime = conferenceSchedule.get(0)[1];

        for (int i = 1; i < conferenceNum; i++) {
            int nextStartTime = conferenceSchedule.get(i)[0];
            if (nextStartTime >= endTime) {
                totalConferenceNum++;
                endTime = conferenceSchedule.get(i)[1];
            }
        }

        System.out.println(totalConferenceNum);
    }
}