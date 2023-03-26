import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите юзернейм: ");
        String name = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String pass = scanner.nextLine();

        UserData userData = new UserData(name, pass);

        String finalResult = "Пользователь не найден";

        if (userData.createUrlRequest().equalsIgnoreCase("success")){
            finalResult = "Успешный вход";
        }

        System.out.println(finalResult);

    }

}
