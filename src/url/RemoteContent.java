package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class RemoteContent {
    public static void main(String[] args) {
        String urlString = UserInput.askForUrl();
        try {
            URLConnection myURLConnection = connectFromURL(urlString);
            System.out.println("Retrieved a resource of type" + myURLConnection.getContentType() + "from" +
                    myURLConnection.getURL());
            System.out.println(getContent(myURLConnection));
        } catch (MalformedURLException e) {
            System.err.println("MalformedURL - " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Cannot establish connection - " + e.toString());
        }
    }

    public static URLConnection connectFromURL(String urlString) throws IOException {
        URL mySite = new URL(urlString);
        URLConnection myURLConnection = mySite.openConnection();
        myURLConnection.connect();
        return myURLConnection;
    }

    public static List<String> getContent(URLConnection resource) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            lines.add(line);
        }
        return lines;

    }

}
