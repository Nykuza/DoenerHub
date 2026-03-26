package Klassen;

/**
 * Haupt-Einstiegspunkt der Anwendung.
 * Startet das Hauptfenster (MainWindow).
 */
public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.start();
    }
}

            // Jetzt Fenster f�r Getr�nke �ffnen
            Getraenke myGetraenkeObject = new Getraenke();

            JTextField gIdField = new JTextField();
            JTextField gNameField = new JTextField();
            JTextField gPreisField = new JTextField();
            JTextField gFormField = new JTextField();
            JTextField gFuellmengeField = new JTextField();

            Object[] drinkMessage = {
                "Getr�nke ID:", gIdField,
                "Name:", gNameField,
                "Preis:", gPreisField,
                "Form (z.B. Flasche/Dose):", gFormField,
                "F�llmenge (in Liter):", gFuellmengeField
            };

            int drinkOption = JOptionPane.showConfirmDialog(null, drinkMessage, "Getr�nkedaten eingeben", JOptionPane.OK_CANCEL_OPTION);

            if (drinkOption == JOptionPane.OK_OPTION) {
                myGetraenkeObject.setGetraenkeId(Integer.parseInt(gIdField.getText()));
                myGetraenkeObject.setGName(gNameField.getText());
                myGetraenkeObject.setGPreis(Double.parseDouble(gPreisField.getText()));
                myGetraenkeObject.setGForm(gFormField.getText());
                myGetraenkeObject.setGFuellmenge(Double.parseDouble(gFuellmengeField.getText()));

                // Getr�nke-Objekt anzeigen
                System.out.println("\n=== GETR�NKE ===");
                System.out.println(myGetraenkeObject.toString());
            } else {
                System.out.println("Getr�nkeeingabe abgebrochen.");
            }

        } else {
            System.out.println("Eingabe abgebrochen.");
        }
    }
}