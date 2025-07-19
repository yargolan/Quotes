package com.ygsoft.quotes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class DbWrapper {

    public DbWrapper(){}


    String getQuote(int quoteIndex) throws IOException {
        String data = IOUtils.resourceToString("/db.json", StandardCharsets.UTF_8);
        JsonObject joData = new Gson().fromJson(data, JsonObject.class);
        String quote = null;
        try {
            quote = joData.get(String.valueOf(quoteIndex)).getAsString();
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select an index between 1 .. 25",
                    "Error !!!",
                    JOptionPane.PLAIN_MESSAGE
            );
        }
        return quote;
    }
}
