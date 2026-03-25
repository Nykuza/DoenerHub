package Klassen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Objekt deiner eigenen Klasse "Laden"
        Laeden myLaedenObject = new Laeden();

        // Eingabefelder für Laden erstellen
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField anschriftField = new JTextField();
        JTextField hausnummerField = new JTextField();
        JTextField telefonField = new JTextField();
        JTextField teuerstesProduktField = new JTextField();
        JTextField guenstigstesProduktField = new JTextField();
        JTextField zahlungsartField = new JTextField();
        JTextField bestellenField = new JTextField();

        // Inhalte des Dialogfensters für Laden
        Object[] message = {
            "Laden ID:", idField,
            "Laden Name:", nameField,
            "Anschrift:", anschriftField,
            "Hausnummer:", hausnummerField,
            "Telefonnummer:", telefonField,
            "Teuerstes Produkt:", teuerstesProduktField,
            "Günstigstes Produkt:", guenstigstesProduktField,
            "Zahlungsart: ", zahlungsartField,
            "Bestellen:", bestellenField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ladendaten eingeben", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            // Daten auslesen und ins Objekt speichern
            myLaedenObject.setLadenId(Integer.parseInt(idField.getText()));
            myLaedenObject.setLadenName(nameField.getText());
            myLaedenObject.setAnschrift(anschriftField.getText());
            myLaedenObject.setHausnummer(Integer.parseInt(hausnummerField.getText()));
            myLaedenObject.setTelefonnummer(telefonField.getText());
            myLaedenObject.setTeuerstesProdukt(Double.parseDouble(teuerstesProduktField.getText()));
            myLaedenObject.setGuenstigstesProdukt(Double.parseDouble(guenstigstesProduktField.getText()));
            myLaedenObject.setZahlungsart(zahlungsartField.getText());
            myLaedenObject.setBestellen(bestellenField.getText());

            // Ausgabe in Konsole
            System.out.println("=== LADEN ===");
            System.out.println(myLaedenObject.toString());

            // Jetzt Fenster für Getränke öffnen
            Getraenke myGetraenkeObject = new Getraenke();

            JTextField gIdField = new JTextField();
            JTextField gNameField = new JTextField();
            JTextField gPreisField = new JTextField();
            JTextField gFormField = new JTextField();
            JTextField gFuellmengeField = new JTextField();

            Object[] drinkMessage = {
                "Getränke ID:", gIdField,
                "Name:", gNameField,
                "Preis:", gPreisField,
                "Form (z.B. Flasche/Dose):", gFormField,
                "Füllmenge (in Liter):", gFuellmengeField
            };

            int drinkOption = JOptionPane.showConfirmDialog(null, drinkMessage, "Getränkedaten eingeben", JOptionPane.OK_CANCEL_OPTION);

            if (drinkOption == JOptionPane.OK_OPTION) {
                myGetraenkeObject.setGetraenkeId(Integer.parseInt(gIdField.getText()));
                myGetraenkeObject.setGName(gNameField.getText());
                myGetraenkeObject.setGPreis(Double.parseDouble(gPreisField.getText()));
                myGetraenkeObject.setGForm(gFormField.getText());
                myGetraenkeObject.setGFuellmenge(Double.parseDouble(gFuellmengeField.getText()));

                // Getränke-Objekt anzeigen
                System.out.println("\n=== GETRÄNKE ===");
                System.out.println(myGetraenkeObject.toString());
            } else {
                System.out.println("Getränkeeingabe abgebrochen.");
            }

        } else {
            System.out.println("Eingabe abgebrochen.");
        }
    }
}