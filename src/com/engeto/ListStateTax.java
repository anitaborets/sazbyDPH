package com.engeto;

import java.io.*;
import java.rmi.server.ExportException;
import java.util.*;
import java.util.List;

//seznam statov a DPH
public class ListStateTax  {
    ArrayList<StateTax> listState = new ArrayList<>();
    public static final String DELIMITER = ";";;

//metody

//pridat stat do seznamu
    public void addListState(StateTax newState){
        listState.add(newState);
    }

//nacitat zo suboru
    public static ListStateTax importFromFile (String fileName) throws TaxException {
        ListStateTax listStateTax = new ListStateTax();

        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] items = input.split(DELIMITER);
                StateTax stateTax = new StateTax();
                stateTax.setState(items[0]);
                stateTax.setStateFullName(items[1]);
                stateTax.setBasicVAT(Integer.parseInt(items[2]));
                stateTax.setReducedVAT(Double.parseDouble(items[3]));
                stateTax.setParkingVAT(Boolean.parseBoolean(items[4]));
                listStateTax.addListState(stateTax);
            }
        } catch (FileNotFoundException e) {
            throw new TaxException("Soubor nenalezen: ");
        }
        catch (IndexOutOfBoundsException e){
            throw new TaxException("Problem vo vstupnom subore: ");}

        return listStateTax;
            }

//Seradeni: státy, které mají základní sazbu DPH vyšší než 20 % + nepoužívají speciální sazbu daně.
// Dalej: státy, které ve výpisu nefigurují.
        public List getBasicTax (ListStateTax listStateTax) {
        List<StateTax> stateTaxes = new ArrayList<>();
        for (StateTax stateTax : listStateTax.listState) {

            if ((stateTax.basicVAT > 20) && (stateTax.parkingVAT == false)) {
                stateTaxes.add(stateTax);
            }
        }
        Comparator tax = new StateTaxComparator();
        Collections.sort(stateTaxes, tax);


        //vypis na obrazovku - volame metod
        printConsole(stateTaxes, listStateTax);

        //ulozit do suboru - volame metod
            try {
                exportToFile("vat-over-20.txt", stateTaxes, listStateTax);
            } catch (TaxException e) {
                e.printStackTrace();
            }

            return stateTaxes;
    }

    //vypis na obrazovku
    public void printConsole(List stateTaxes, ListStateTax listStateTax) {
        System.out.println("Státy, které mají základní sazbu DPH vyšší než 20 % a nepoužívají speciální sazbu daně");
        System.out.println(stateTaxes);

        System.out.println("===========================");
        System.out.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");

        for (StateTax stateTax : listStateTax.listState) {
            if ((stateTax.basicVAT < 20) || (stateTax.parkingVAT == true)) {
                System.out.print(stateTax.state + ", ");
                            }
                    }
        System.out.println(" ");
    }

    //ulozit do suboru
    public void exportToFile(String fileName, List stateTaxes, ListStateTax listStateTax) throws TaxException{
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))){
                writer.println("Státy, které mají základní sazbu DPH vyšší než 20 % a nepoužívají speciální sazbu daně:");
                List<StateTax> stateTaxes1 = new ArrayList<>();
                stateTaxes1 = List.copyOf(stateTaxes);
                for (StateTax stateTax : stateTaxes1) {
                    writer.println(stateTax.stateFullName + " (" + stateTax.state + "): "
                            + stateTax.basicVAT +  " %");
                }
                
                writer.println("===========================");
                writer.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
                for (StateTax stateTax : listStateTax.listState) {
                     if ((stateTax.basicVAT < 20) || (stateTax.parkingVAT == true)) {
                        writer.print(stateTax.state+ ", ");
                    }
                }

                } catch (FileNotFoundException e) {
                throw new TaxException("Soubor " + fileName + " nenalezen: " + e.getLocalizedMessage());
            }
            }

    //uživatel zadava sazbu DPH, podla ktorej filtrujeme. Pokud zmáčkne Enter, výchozí hodnota je 20 %.
    public void getTaxFromUser(ListStateTax listStateTax) throws TaxException{
        int taxe;
        String line;
        System.out.println("===========================");
        System.out.println("Zadajte zakladni sadzbu VAT:");
        Scanner console = new Scanner(System.in);

    try {
        line = console.nextLine();
        taxe = Integer.parseInt(line, 10);
    }
    catch (Exception e){
        taxe = 20;
        System.out.println("Nezadali ste sadzbu, preto pripravili sme pre vas");
    }

    System.out.println("Státy se základní sazbou vyšší než: " + taxe);
    for (StateTax stateTax : listStateTax.listState) {
        if (stateTax.basicVAT > taxe) {
            System.out.println(stateTax.stateFullName + " (" + stateTax.state + "): " + stateTax.basicVAT + " %");
        }
    }
//ulozit do suboru - volame metod
    exportToFileForUser(taxe,listStateTax);
}

//ulozit do suboru podla parametrov uzivatela
    public void exportToFileForUser(int taxe, ListStateTax listStateTax) throws TaxException{
        String fileName;
        fileName = "vat-over-" + taxe + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))){
            writer.println("Státy se základní sazbou vyšší než: " + taxe);
            for (StateTax stateTax : listStateTax.listState) {
                if (stateTax.basicVAT > taxe) {
                    writer.println(stateTax.stateFullName + " (" + stateTax.state + "): " + stateTax.basicVAT + " %");
                }
            }
        } catch (FileNotFoundException e) {
            throw new TaxException("Soubor " + fileName + " nenalezen: " + e.getLocalizedMessage());
        }
    }

   @Override
   public String toString() {
        return "Zakladné sadzby DPH:" + '\n' + listState;
    }
}
