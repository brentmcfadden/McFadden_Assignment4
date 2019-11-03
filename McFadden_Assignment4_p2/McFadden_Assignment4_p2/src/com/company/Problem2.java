package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class DuplicateCounter {

    private static Map<String, String> map = (new HashMap<>());
    private static int wordCounter;

    DuplicateCounter(int wordCounter) {
        DuplicateCounter.wordCounter = wordCounter;
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
            wordCounter = 0;
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
        outFS.println("using entrySet and toString");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            outFS.println(entry);
        }
        outFS.println();
    }
}

class Application{
    public static void main(String[] args){
        File problem2 = new File(args[0]);
        File unique_word_counts = new File(args[1]);
        try {
            Application.Call(problem2, unique_word_counts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Call(File problem2, File unique_word_counts) throws IOException {

        System.out.println("Opening dataFile.txt.");
        // File input stream
        FileInputStream fileByteStream = new FileInputStream(problem2);
        // Scanner object
        Scanner inFS = new Scanner(fileByteStream);

        DuplicateCounter.counter(new File(inFS.next()));

        fileByteStream = new FileInputStream(unique_word_counts);
        inFS = new Scanner(fileByteStream);

        DuplicateCounter.write(new File(inFS.next()));

        fileByteStream.close();
    }
}