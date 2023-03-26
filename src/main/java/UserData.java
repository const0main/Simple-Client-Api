import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UserData {

    private String login;
    private String password;

    public UserData(String login, String password){
        this.login = login;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String createUrlRequest() throws IOException, ParseException {

        URL url = new URL("http://localhost/backend/api.php?login=" + getLogin() + "&password=" + getPassword());
        String requestData;
        Scanner scanner = new Scanner(url.openStream());
        JSONParser parser = new JSONParser();
        requestData = scanner.nextLine();

        JSONObject root = (JSONObject) parser.parse(requestData);

        String status = (String) root.get("status");

        return status;

    }

}
