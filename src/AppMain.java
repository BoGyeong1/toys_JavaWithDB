import java.sql.*;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) throws Exception {
        // 설문 분기 여부
        System.out.println("설문을 참여 하시겠습니까?");

        Commons commens = new Commons();
        Statement statement = commens.getStatement();

        String flag = "T"; // Do WHILE은 좋지 않은 방법임
        Scanner scanner = new Scanner(System.in);

        while (!flag.equals("Q")) { // 종료 flag 사용
            System.out.println("P.설문시작 | S.통계 | Q.종료");
            flag = scanner.nextLine();
            if (flag.equals("P")) {
                Surveys surveys = new Surveys();
                surveys.survey(statement);

            } else if (flag.equals("X")) { // 통계
                Statistics statistics = new Statistics();
                statistics.statistic(statement);

            }

        }
        System.out.println("종료");
        // 종료
    }
}
