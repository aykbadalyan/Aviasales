package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    String FILE_PATH = null;

    public FileReader(String fileName) {
        FILE_PATH = fileName;

    }

    public List getLines() {

        List<String> fileLines = new ArrayList<>();

        try {
            InputStream inputStream = getClass().getResourceAsStream(FILE_PATH);
            if (inputStream != null) {
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

                String line = null;
                while ((line = in.readLine()) != null) {
                    fileLines.add(line);
                }
            } else {
                System.out.println("Input stream is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < fileLines.size(); i++) {
            System.out.println(fileLines.get(i));
        }

        return fileLines;
    }


}
