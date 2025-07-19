package com.ygsoft.quotes;

import javax.swing.*;


public class QuotesUiOnly {


    public QuotesUiOnly() {}


    public void showIt(String theQuote) {
        // Set LNF.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Cannot set the needed Look-and-feel");
        }

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
