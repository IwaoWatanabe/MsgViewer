package net.sourceforge.MSGViewer.rtfparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static net.sourceforge.MSGViewer.R8.readString;

/**
 * This program reads a text file line by line and print to the console. It uses
 * FileOutputStream to read the file.
 */
public class ReadFile {

    public static String read_file(String file_name) {
        try {
            return readString(Paths.get(file_name));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}