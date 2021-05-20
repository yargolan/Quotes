package com.ygsoft.quotes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*;
import com.google.gson.Gson;



public class AESaidOnce {

    HashMap<?, ?> map;



    public AESaidOnce(){}



    public static void main(String[] args) {

        // Set LNF.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println("Cannot set LNF.");
        }

        AESaidOnce aeSaidOnce = new AESaidOnce();
        try {
            aeSaidOnce.runIt();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }



    private void runIt() throws IOException{

        // Read the quotes from the JSON file.
        parseQuotes();

        // Get the index from the user.
        int index = getUserIndex();

        // Show th quote.
        showIt(index);
    }



    private void parseQuotes() throws IOException {

        // Set the path of the DB file.
        File here = new File("..").getCanonicalFile().getAbsoluteFile();
        String dbFile = here.getAbsolutePath() + "/db.json";

        // create Gson instance
        Gson gson = new Gson();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(dbFile));

        // convert JSON file to map
        map = gson.fromJson(reader, HashMap.class);

        // close reader
        reader.close();
    }



    private int getUserIndex() {

        int size = map.size();
        int userIndex = 0;
        boolean validUserChoice = false;


        Scanner scan = new Scanner(System.in);

        while (! validUserChoice) {
            System.out.print("Enter quote index: ");
            userIndex = scan.nextInt();

            if (userIndex > 0 && userIndex < size) {
                validUserChoice = true;
            }
            else {
                JOptionPane.showMessageDialog(
                        null,
                        "Please pick a number between 1 and " + size,
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        scan.close();
        return userIndex;
    }



    private void showIt(int userIndex) {
        JOptionPane.showMessageDialog(
                null,
                map.get(String.valueOf(userIndex)),
                "A. Einstein once said ...",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}
