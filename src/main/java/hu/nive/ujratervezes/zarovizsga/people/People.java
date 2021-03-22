package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        Path file = Path.of(path);
        try (BufferedReader br = Files.newBufferedReader(file)) {

            return getMales(br);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private int getMales(BufferedReader br) throws IOException {
        skipHeader(br);
        int numberOfMales = 0;
        String line;

        while((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            if (temp[4].equals("Male")) {
                numberOfMales++;
            }
        }
        return numberOfMales;
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }
}
