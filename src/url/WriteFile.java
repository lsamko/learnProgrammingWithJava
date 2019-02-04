package url;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {
        String urlString = UserInput.askForUrl();
        try {
            URLConnection myURLConnection = RemoteContent.connectFromURL(urlString);
            List<String> content = RemoteContent.getContent(myURLConnection);
            writeToFile(content, "output.txt");

        } catch (MalformedURLException e) {
            System.err.println("Malformed URL - " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.err.println("Cannot establish -" + e.toString());
        }
    }

    private static void writeToFile(List<String> content, String fileName) {
        Path pathToFile = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile)) {
            for (String line : content) {
                writer.write(line);
            }
            System.out.println("Content written to " + pathToFile);
        } catch (IOException e) {
            System.out.println("Could not find file " + pathToFile);
            e.printStackTrace();
        }

    }

}
