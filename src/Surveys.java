import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

;

public class Surveys {
    public void survey(Statement statement) {
        // 설문시작
        System.out.println("설문시작");

        // 이름과 휴대폰 입력
        System.out.print("이름 : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.print("휴대폰 번호 : ");
        String phone_number = scanner.next();

        // 유니크아이디는 그때그때 새로만들어내야한다.
        // 날짜별로 새롭게 만드는 유니크아이디
        Commens commens = new Commens();
        String strDate = commens.getGenerateID();

        String query = " INSERT INTO users_list(USERS_UID,PHONE,NAME)" +
                "VALUES ('" + strDate + "', '" + phone_number + "', '" + name + "')";// ''주의 빼면 동작하지 않음
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 설문과 답항 내용 출력

        query = "SELECT * FROM questions_list " +
                "ORDER BY ORDERS";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("ORDERS" + ". "));
                System.out.println(resultSet.getString("QUSETIONS"));
                String uid = resultSet.getString("QUESTION_UID");
                // 설문 문항에 맞는 설문 답항 출력
                query = "SELECT example_list.EXAMPLE_UID, example_list.EXAMPLE, example_list.ORDERS " +
                        "FROM answers inner Join example_list " +
                        "on answers.EXAMPLE_UID = example_list.EXAMPLE_UID " +
                        "WHERE QUESTIONS_UID = '" + uid + "' " +
                        "ORDER BY ORDERS";
                ResultSet resultSet2 = statement.executeQuery(query);
                ArrayList arrayList = new ArrayList<>();
                while(resultSet2.next()){
                    System.out.print(resultSet2.getInt("ORDERS"+". "));
                    System.out.println(resultSet2.getString("EXAMPLE"));
                    arrayList.add();

                }
                // 설문자 답 받기
                System.out.print("응답 번호: ");
                String answer = scanner.next();


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
