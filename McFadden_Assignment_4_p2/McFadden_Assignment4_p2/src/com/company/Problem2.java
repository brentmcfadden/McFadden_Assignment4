package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class DuplicateCounter {

    private static Map<String, String> map = (new HashMap<>());

    DuplicateCounter() {
    }

    // uses entry to create map
    static void counter(File dataFile){
        ArrayList<String> result = new ArrayList<>();
        int i = 0, j,f;
        try (Scanner s = new Scanner(new FileReader(dataFile))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        f = result.size();
        String compare1 = result.get(i);
        // compares string values and uses a counter to determine if string is a unique string
        for(i = 0; i < f; i++) {
            int wordCounter = 0;
            for (j = 0; j < f; j++) {
                if (!(compare1.equals(result.get(j)))) {
                    wordCounter++;
                }
            }
            if (wordCounter == 0 && j == f) {
                map.put("Word Count: " + wordCounter,compare1);
            }
            else{
                map.put("Word Count: " + wordCounter, compare1);
            }
        }



    }
    // prints mapped entries/ the map values
    static void write(File outputFile) throws FileNotFoundException {
        FileOutputStream fileByteStream; // File output stream
        fileByteStream = new FileOutputStream(outputFile);
        // Output stream
        PrintWriter outFS;
        outFS = new PrintWriter(fileByteStream);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            outFS.println(entry);
        }
        outFS.println();
    }
}

class Application{
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        System.out.println("Opening dataFile.txt.");
        // File input stream
        FileInputStream fileByteStream = new FileInputStream("problem2.txt");
        // Scanner object
        Scanner inFS = new Scanner(fileByteStream);

        duplicateCounter.counter(new File(inFS.next()));

        fileByteStream = new FileInputStream("unique_word_counts.txt");
        inFS = new Scanner(fileByteStream);

        duplicateCounter.write(new File(inFS.next()));

        fileByteStream.close();
    }
}