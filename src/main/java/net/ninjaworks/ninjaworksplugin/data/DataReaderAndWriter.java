package net.ninjaworks.ninjaworksplugin.data;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

// Main clas
public class DataReaderAndWriter {

    // Main driver method
    public void write(String filepath, String filename, String text)
            throws FileNotFoundException {
        // Creating an instance of file
        File path = new File(filepath + "\\" + filename + ".txt");

        // Declaring the print writer with path
        PrintWriter pw = new PrintWriter(path);

        // Now calling writer() method with string
        pw.write(text);

        // Flushing the print writer
        pw.flush();

        // Lastly closing the print writer
        // using the close() method
        pw.close();
    }

    public String read(String filepath, String filename) {
        try {
            String contents = new String(Files.readAllBytes(Path.of(filepath + "\\" + filename)), StandardCharsets.UTF_8);
            return contents;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String remove(String filepath, String filename, String toRemove) throws Exception {
        String result = fileToString(filepath + "\\" + filename);
        result = result.replaceAll(toRemove, "");
        //Rewriting the contents of the file
        PrintWriter writer = new PrintWriter(new File(filepath));
        writer.append(result);
        writer.flush();
        return fileToString(filepath);
    }

    public static String fileToString(String filepath) throws Exception {
        String input = null;
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }
}