package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class DuplicateRemover {

    private static ArrayList<String> uniqueWords = new ArrayList<>();

    static void remove(File dataFile) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0, j, k, f;
        try (Scanner s = new Scanner(new FileReader(dataFile))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        f = result.size();
        String compare1 = result.get(i);
        // compares string values and uses a counter to determine if string is a unique string
        for (i = 0; i < f; i++) {
            k = 0;
            for (j = 0; j < f; j++) {
                if (!(compare1.equals(result.get(j)))) {
                    k++;
                }
            }
            if (k == 0 && j == f) {
                uniqueWords.add(compare1);
            }
        }
    }

    static void write(File outFile) throws IOException {
        FileOutputStream fileByteStream; // File output stream
        int i;

        // Try to open file
        fileByteStream = new FileOutputStream(outFile);
        // Output stream
        PrintWriter outFS;
        outFS = new PrintWriter(fileByteStream);

        // need to print unique words
        for (i = 0; i < uniqueWords.size(); i++)
            outFS.print(uniqueWords.get(i) + " ");
        outFS.println();
        outFS.flush();

        // Done with file, so try to close it
        fileByteStream.close(); // close() may throw IOException if fails
    }
}
class Application{
    public static void main(String[]args) throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        /*File problem1 = new File(args[0]);
        File unique_words = new File(args[1]);
        try {
            file(problem1, unique_words);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        FileInputStream fileByteStream; // File input stream
        Scanner inFS;                   // Scanner object

        System.out.println("Opening dataFile.txt.");
       // List<String> lines = Files.readAllLines(Paths.get("problem1.txt"));

        fileByteStream = new FileInputStream("problem1.txt");
        inFS = new Scanner(fileByteStream);

        duplicateRemover.remove(new File(inFS.next()));

        fileByteStream = new FileInputStream("unique_words.txt");
        inFS = new Scanner(fileByteStream);

        duplicateRemover.write(new File(inFS.next()));

        fileByteStream.close();

    }
}
  /*  private static void file(File problem1, File unique_words) throws IOException {
            FileInputStream fileByteStream; // File input stream
            Scanner inFS;                   // Scanner object

            System.out.println("Opening dataFile.txt.");
            fileByteStream = new FileInputStream(problem1);
            inFS = new Scanner(fileByteStream);

            DuplicateRemover.remove(new File(inFS.next()));

            fileByteStream = new FileInputStream(unique_words);
            inFS = new Scanner(fileByteStream);

            DuplicateRemover.write(new File(inFS.next()));

            fileByteStream.close();
        }
    }*/
