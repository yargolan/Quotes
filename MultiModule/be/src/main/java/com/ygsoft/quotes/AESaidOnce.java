package com.ygsoft.quotes;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;




public class AESaidOnce {


    public AESaidOnce() {
    }


    public static void main(String[] args) {

        // Set LNF.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Cannot set the needed Look-and-feel");
        }

        AESaidOnce aeSaidOnce = new AESaidOnce();


        // Create an instance of the DbWrapper class.
        DbWrapper dbWrapper = new DbWrapper();


        // Get user index and show the quote.
        int index = aeSaidOnce.getUserIndex();


        // Get the necessary quote from the database.
        try {
            String chosenQuote = dbWrapper.getQuote(index);

            // Show the quote in a dialog.
            aeSaidOnce.showIt(chosenQuote);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    private int getUserIndex() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter quote index: ");
        int userIndex = scan.nextInt();
        scan.close();
        return userIndex;
    }


    private void showIt(String theQuote) {
        if (theQuote != null) {
            JOptionPane.showMessageDialog(
                null,
                theQuote,
                "A. Einstein once said ...",
                JOptionPane.PLAIN_MESSAGE
            );
        }
    }
}
