package url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        String urlString = "";
        switch (args.length) {
            case 0:
                urlString = askForUrl();
            case 1:
                urlString = args[0];
                break;
            default:
                System.out.println("Please run the program with the desired URL or no argument at all");
                System.exit(-1);
        }
        System.out.println("Checking url" + urlString);
        if (isValidURL(urlString)) {
            System.out.println(urlString + "is well formed");
        } else {
            System.out.println(urlString + "is bad formed");
        }
    }


    private static boolean isValidURL(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String askForUrl() {
        Scanner readInput = new Scanner(System.in);
        System.out.println("Please enter a valid URL");
        String url = readInput.nextLine();
        readInput.close();
        return url;
    }

}


