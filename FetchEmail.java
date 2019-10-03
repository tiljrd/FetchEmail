import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class FetchEmail {

    public static void main(String[] args) {

        System.out.print("Please type in the Email ID: ");
        Scanner scanner = new Scanner(System.in);

        //read the email id from user input
        String id = scanner.next();

        //create full web address with the id provided by the user
        String webAddress = "https://www.ecs.soton.ac.uk/people/" + id;
        try {
            URL url = new URL(webAddress);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String name = "";
            //the name is found in the 8th line
            for(int i = 0; i < 8; i++){
                name = bufferedReader.readLine();
            }
            //extract only the name from the 8th line
            name = name.substring(11,name.indexOf('|') - 1);
            //if the email id does not exist instead of a name there is "People" written
            if(name.equals("People")) {
                System.out.println("No person with the specified Email ID found!");
            }else {
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
