package Klassen;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hauptfenster-Klasse: UI-Logik und Benutzerinteraktion.
 * View Layer: Konsolen-basierte Benutzeroberfläche.
 */
public class MainWindow {
    private final OrteController orte;
    private final BestellRechner bestellRechner;
    private final Scanner scanner;

    /**
     * Konstruktor: Initialisiert Controller und Scanner.
     */
    public MainWindow() {
        this.orte = new OrteController();
        this.bestellRechner = new BestellRechner();
        this.scanner = new Scanner(System.in);
        initializeExampleData();
    }

    /**
     * Startet die Hauptmenü-Schleife.
     */
    public void start() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readIntInput("Wähle eine Option: ");
            running = processChoice(choice);
        }
        System.out.println("\n✅ Auf Wiedersehen!");
        scanner.close();
    }

    private boolean processChoice(int choice) {
        return switch (choice) {
            case 1 -> { manageLaeden(); yield true; }
            case 2 -> { manageSpeisen(); yield true; }
            case 3 -> { manageGetraenke(); yield true; }
            case 4 -> { runBestellRechner(); yield true; }
            case 5 -> { printSummary(); yield true; }
            case 6 -> false;
            default -> { System.out.println("❌ Ungültige Option!"); yield true; }
        };
    }

    // ===== MAIN MENU =====

    private void printMainMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("🍖 DoenerHub Verwaltungssystem");
        System.out.println("=".repeat(40));
        System.out.println("1. 🏪 Läden verwalten");
        System.out.println("2. 🥙 Speisen verwalten");
        System.out.println("3. 🥤 Getränke verwalten");
        System.out.println("4. 🧮 Bestellpreis berechnen");
        System.out.println("5. 📊 Übersicht");
        System.out.println("6. ❌ Beenden");
        System.out.println("=".repeat(40));
    }

    // ===== LÄDEN VERWALTUNG =====

    private void manageLaeden() {
        boolean back = false;
        while (!back) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("🏪 Läden-Verwaltung");
            System.out.println("-".repeat(40));
            System.out.println("1. 📝 Neuer Laden");
            System.out.println("2. 📋 Alle Läden anzeigen");
            System.out.println("3. 🗑️ Laden löschen");
            System.out.println("4. ⬅️ Zurück");

            int choice = readIntInput("Option: ");
            switch (choice) {
                case 1 -> addNewLaden();
                case 2 -> listAllLaeden();
                case 3 -> deleteLaden();
                case 4 -> back = true;
                default -> System.out.println("❌ Ungültig!");
            }
        }
    }

    private void addNewLaden() {
        System.out.println("\n📝 Neuen Laden hinzufügen");
        String name = readStringInput("Laden-Name: ");
        String adresse = readStringInput("Adresse: ");

        try {
            Laeden laden = new Laeden(name, adresse);
            orte.addLaden(laden);
            System.out.println("✅ Laden hinzugefügt");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }

    private void listAllLaeden() {
        System.out.println("\n📋 Alle Läden:");
        if (orte.getLadenCount() == 0) {
            System.out.println("(Keine Läden vorhanden)");
        } else {
            for (int i = 0; i < orte.getAllLaeden().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, orte.getAllLaeden().get(i));
            }
        }
    }

    private void deleteLaden() {
        if (orte.getLadenCount() == 0) {
            System.out.println("❌ Keine Läden zum Löschen!");
            return;
        }

        listAllLaeden();
        int index = readIntInput("Welcher Laden? (Nummer): ") - 1;

        if (index < 0 || index >= orte.getAllLaeden().size()) {
            System.out.println("❌ Ungültige Nummer!");
            return;
        }

        Laeden laden = orte.getAllLaeden().get(index);
        orte.removeLaden(laden);
        System.out.println("✅ Laden gelöscht");
    }

    // ===== SPEISEN VERWALTUNG =====

    private void manageSpeisen() {
        boolean back = false;
        while (!back) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("🥙 Speisen-Verwaltung");
            System.out.println("-".repeat(40));
            System.out.println("1. 📝 Neue Speise");
            System.out.println("2. 📋 Alle Speisen");
            System.out.println("3. 🔍 Nach Kategorie filtern");
            System.out.println("4. 🗑️ Speise löschen");
            System.out.println("5. ⬅️ Zurück");

            int choice = readIntInput("Option: ");
            switch (choice) {
                case 1 -> addNewSpeise();
                case 2 -> listAllSpeisen();
                case 3 -> filterSpeiseByKategorie();
                case 4 -> deleteSpeise();
                case 5 -> back = true;
                default -> System.out.println("❌ Ungültig!");
            }
        }
    }

    private void addNewSpeise() {
        System.out.println("\n📝 Neue Speise hinzufügen");
        String name = readStringInput("Speisen-Name: ");
        double preis = readDoubleInput("Preis (€): ");
        String kategorie = readStringInput("Kategorie (z.B. Döner, Salat): ");

        try {
            Speisen speise = new Speisen(name, preis, kategorie);
            orte.addSpeise(speise);
            System.out.println("✅ Speise hinzugefügt");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }

    private void listAllSpeisen() {
        System.out.println("\n📋 Alle Speisen:");
        if (orte.getSpeiseCount() == 0) {
            System.out.println("(Keine Speisen vorhanden)");
        } else {
            for (int i = 0; i < orte.getAllSpeisen().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, orte.getAllSpeisen().get(i));
            }
        }
    }

    private void filterSpeiseByKategorie() {
        String kategorie = readStringInput("Kategorie: ");
        var filtered = orte.getSpeiseByKategorie(kategorie);

        System.out.println("\n🔍 Speisen in Kategorie \"" + kategorie + "\":");
        if (filtered.isEmpty()) {
            System.out.println("(Keine Speisen gefunden)");
        } else {
            for (int i = 0; i < filtered.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, filtered.get(i));
            }
        }
    }

    private void deleteSpeise() {
        if (orte.getSpeiseCount() == 0) {
            System.out.println("❌ Keine Speisen zum Löschen!");
            return;
        }

        listAllSpeisen();
        int index = readIntInput("Welche Speise? (Nummer): ") - 1;

        if (index < 0 || index >= orte.getAllSpeisen().size()) {
            System.out.println("❌ Ungültige Nummer!");
            return;
        }

        Speisen speise = orte.getAllSpeisen().get(index);
        orte.removeSpeise(speise);
        System.out.println("✅ Speise gelöscht");
    }

    // ===== GETRÄNKE VERWALTUNG =====

    private void manageGetraenke() {
        boolean back = false;
        while (!back) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("🥤 Getränke-Verwaltung");
            System.out.println("-".repeat(40));
            System.out.println("1. 📝 Neues Getränk");
            System.out.println("2. 📋 Alle Getränke");
            System.out.println("3. 🗑️ Getränk löschen");
            System.out.println("4. ⬅️ Zurück");

            int choice = readIntInput("Option: ");
            switch (choice) {
                case 1 -> addNewGetraenk();
                case 2 -> listAllGetraenke();
                case 3 -> deleteGetraenk();
                case 4 -> back = true;
                default -> System.out.println("❌ Ungültig!");
            }
        }
    }

    private void addNewGetraenk() {
        System.out.println("\n📝 Neues Getränk hinzufügen");
        String name = readStringInput("Getränk-Name: ");
        double preis = readDoubleInput("Preis (€): ");
        String groesse = readStringInput("Größe (klein/mittel/groß): ");

        try {
            Getraenke getraenk = new Getraenke(name, preis, groesse);
            orte.addGetraenk(getraenk);
            System.out.println("✅ Getränk hinzugefügt");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }

    private void listAllGetraenke() {
        System.out.println("\n📋 Alle Getränke:");
        if (orte.getGetraenkCount() == 0) {
            System.out.println("(Keine Getränke vorhanden)");
        } else {
            for (int i = 0; i < orte.getAllGetraenke().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, orte.getAllGetraenke().get(i));
            }
        }
    }

    private void deleteGetraenk() {
        if (orte.getGetraenkCount() == 0) {
            System.out.println("❌ Keine Getränke zum Löschen!");
            return;
        }

        listAllGetraenke();
        int index = readIntInput("Welches Getränk? (Nummer): ") - 1;

        if (index < 0 || index >= orte.getAllGetraenke().size()) {
            System.out.println("❌ Ungültige Nummer!");
            return;
        }

        Getraenke getraenk = orte.getAllGetraenke().get(index);
        orte.removeGetraenk(getraenk);
        System.out.println("✅ Getränk gelöscht");
    }

    // ===== BESTELLRECHNER =====

    private void runBestellRechner() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("🧮 Bestellpreis-Rechner");
        System.out.println("-".repeat(40));

        if (orte.getSpeiseCount() == 0 && orte.getGetraenkCount() == 0) {
            System.out.println("❌ Keine Speisen oder Getränke vorhanden, zuerst Artikel anlegen!");
            return;
        }

        System.out.println("📌 Bitte wähle Speisen (Nummern, mit Komma):");
        listAllSpeisen();
        String speisenInput = readStringInput("Auswahl Speisen: ");
        System.out.println("📌 Bitte wähle Getränke (Nummern, mit Komma):");
        listAllGetraenke();
        String getraenkeInput = readStringInput("Auswahl Getränke: ");

        List<Speisen> ausgewählteSpeisen = getSelectedSpeisen(speisenInput);
        List<Getraenke> ausgewählteGetraenke = getSelectedGetraenke(getraenkeInput);

        if (ausgewählteSpeisen.isEmpty() && ausgewählteGetraenke.isEmpty()) {
            System.out.println("❌ Keine Artikel gewählt.");
            return;
        }

        boolean mitLieferung = readStringInput("Lieferung? (j/n): ").equalsIgnoreCase("j");
        double entfernung = 0;
        if (mitLieferung) {
            entfernung = Math.max(0, readDoubleInput("Entfernung in km: "));
        }

        double warenwert = bestellRechner.berechneWarenwert(ausgewählteSpeisen, ausgewählteGetraenke);
        double rabatt = bestellRechner.berechneRabatt(warenwert);
        double lieferkosten = mitLieferung ? bestellRechner.berechneLieferkosten(entfernung) : 0;
        double gesamt = bestellRechner.berechneTotalpreis(ausgewählteSpeisen, ausgewählteGetraenke, entfernung, mitLieferung);

        System.out.println("\n✅ Bestellübersicht:");
        System.out.printf("- Warenwert: €%.2f%n", warenwert);
        System.out.printf("- Rabatt: -€%.2f%n", rabatt);
        if (mitLieferung) {
            System.out.printf("- Lieferkosten: €%.2f%n", lieferkosten);
        }
        System.out.printf("- Gesamtpreis: €%.2f%n", gesamt);
    }

    private List<Speisen> getSelectedSpeisen(String input) {
        List<Speisen> selected = new ArrayList<>();
        if (input.isBlank()) {
            return selected;
        }
        for (String part : input.split(",")) {
            try {
                int idx = Integer.parseInt(part.trim()) - 1;
                if (idx >= 0 && idx < orte.getAllSpeisen().size()) {
                    selected.add(orte.getAllSpeisen().get(idx));
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return selected;
    }

    private List<Getraenke> getSelectedGetraenke(String input) {
        List<Getraenke> selected = new ArrayList<>();
        if (input.isBlank()) {
            return selected;
        }
        for (String part : input.split(",")) {
            try {
                int idx = Integer.parseInt(part.trim()) - 1;
                if (idx >= 0 && idx < orte.getAllGetraenke().size()) {
                    selected.add(orte.getAllGetraenke().get(idx));
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return selected;
    }

    // ===== ÜBERSICHT =====

    private void printSummary() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📊 Übersicht");
        System.out.println("=".repeat(40));
        System.out.printf("🏪 Läden: %d%n", orte.getLadenCount());
        System.out.printf("🥙 Speisen: %d%n", orte.getSpeiseCount());
        System.out.printf("🥤 Getränke: %d%n", orte.getGetraenkCount());
        System.out.println("=".repeat(40));
    }

    // ===== HELPER INPUT-METHODEN =====

    private String readStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("❌ Eingabe darf nicht leer sein!");
        }
    }

    private int readIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Bitte geben Sie eine ganze Zahl ein!");
            }
        }
    }

    private double readDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Bitte geben Sie eine Dezimalzahl ein!");
            }
        }
    }

    // ===== BEISPIELDATEN =====

    private void initializeExampleData() {
        try {
            // Läden
            orte.addLaden(new Laeden("Döner Palace", "Main Str. 5"));
            orte.addLaden(new Laeden("Kebab King", "Station Platz 12"));

            // Speisen
            orte.addSpeise(new Speisen("Döner", 7.50, "Döner"));
            orte.addSpeise(new Speisen("Salad", 5.50, "Salat"));
            orte.addSpeise(new Speisen("Wrap", 6.50, "Döner"));

            // Getränke
            orte.addGetraenk(new Getraenke("Cola", 2.50, "klein"));
            orte.addGetraenk(new Getraenke("Wasser", 1.50, "groß"));

            System.out.println("✅ Beispieldaten geladen\n");
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Fehler beim Laden von Beispieldaten: " + e.getMessage());
        }
    }
}