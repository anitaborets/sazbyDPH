package com.engeto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import static com.engeto.ListStateTax.*;

public class Main {
    public static final String FILENAME = "vat_eu.txt";

    public static void main(String[] args) {

        ListStateTax listStateTax = new ListStateTax();

        try {
           listStateTax = listStateTax.importFromFile(FILENAME);
        } catch (TaxException e) {
           System.err.println("Nepodařilo se načíst data ze souboru "+FILENAME+": "+e.getMessage());
        }

       System.out.println(listStateTax);

       listStateTax.getBasicTax(listStateTax);

        try {
            listStateTax.getTaxFromUser(listStateTax);
        } catch (TaxException e) {
            e.printStackTrace();
        }

    }

}
