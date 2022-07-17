package com.example.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileHelper {
    private static final Logger logger = LogManager.getLogger(FileHelper.class);

    public static void writeToFile(String file, String content) {
        try {
            FileHelper.createDirectoryIfNotExists(file);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(content);
            printWriter.close();
        } catch (IOException e) {
            logger.error("Could not write to file " + file);
            e.printStackTrace();
        }
    }

    private static void createDirectoryIfNotExists(String fullFilePath) {
        String[] paths = fullFilePath.split("/");
        String filename = paths[paths.length - 1];
        String directoryName = paths.length > 1 ? String.join("/", Arrays.copyOfRange(paths, 0, paths.length - 1)) : "generated_output";

        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdirs();
        }
    }
}
