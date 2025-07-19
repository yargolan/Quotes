package com.ygsoft.quotes;

import java.io.IOException;
import java.util.Scanner;


public class AESaidOnce {


    public AESaidOnce() {
    }


    public static void main(String[] args) {

        AESaidOnce aeSaidOnce = new AESaidOnce();


        // Create an instance of the DbWrapper class.
        DbWrapper dbWrapper = new DbWrapper();

        // Create an instance of the UI class.
        QuotesUiOnly quotesUiOnly = new QuotesUiOnly();


        // Get user index and show the quote.
        int index = aeSaidOnce.getUserIndex();


        // Get the necessary quote from the database.
        String chosenQuote = "Internal error occurred";
        try {
            chosenQuote = dbWrapper.getQuote(index);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        // Show the chosen quote.
        quotesUiOnly.showIt(chosenQuote);
    }


    private int getUserIndex() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter quote index: ");
        int userIndex = scan.nextInt();
        scan.close();
        return userIndex;
    }
}
