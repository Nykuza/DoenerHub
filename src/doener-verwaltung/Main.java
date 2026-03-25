package doener_verwaltung;

import doener_verwaltung.controller.Orte;
import doener_verwaltung.model.Laeden;
import doener_verwaltung.model.Speisen;
import doener_verwaltung.model.Getraenke;

import java.util.Scanner;

/**
 * Main-Klasse: Einstiegspunkt und UI-Loop.
 * View/Controller Layer: Benutzerinteraktion.
 */
public class Main {
    
    private static Orte orte;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        orte = new Orte();
        scanner = new Scanner(System.in);
        
        // Beispieldaten laden
        initializeExampleData();
        
        // Hauptmenü-Loop
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readIntInput("Wähle eine Option: ");
            
            switch (choice) {
                case 1 -> manageLaeden();
                case 2 -> manageSpeisen();
                case 3 -> manageGetraenke();
                case 4 -> printSummary();
                case 5 -> running = false;
                default -> System.out.println("❌ Ungültige Option!");
            }
        }
        
        System.out.println("\n✅ Auf Wiedersehen!");
        scanner.close();
    }
    
    // ===== MAIN MENU =====
    
    private static void printMainMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("🍖 DoenerHub Verwaltungssystem");
        System.out.println("=".repeat(40));
        System.out.println("1. 🏪 Läden verwalten");
        System.out.println("2. 🥙 Speisen verwalten");
        System.out.println("3. 🥤 Getränke verwalten");
        System.out.println("4. 📊 Übersicht");
        System.out.println("5. ❌ Beenden");
        System.out.println("=".repeat(40));
    }
    
    // ===== LÄDEN VERWALTUNG =====
    
    private static void manageLaeden() {
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
    
    private static void addNewLaden() {
        System.out.println("\n📝 Neuen Laden hinzufügen");
        String name = readStringInput("Laden-Name: ");
        String adresse = readStringInput("Adresse: ");
        
        try {
            Laeden laden = new Laeden(name, adresse);
            orte.addLaden(laden);
            System.out.println("✅ Laden hinzugefügt: " + laden);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }
    
    private static void listAllLaeden() {
        System.out.println("\n📋 Alle Läden:");
        if (orte.getLadenCount() == 0) {
            System.out.println("(Keine Läden vorhanden)");
        } else {
            for (int i = 0; i < orte.getAllLaeden().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, orte.getAllLaeden().get(i));
            }
        }
    }
    
    private static void deleteLaden() {
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
        System.out.println("✅ Laden gelöscht: " + laden);
    }
    
    // ===== SPEISEN VERWALTUNG =====
    
    private static void manageSpeisen() {
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
    
    private static void addNewSpeise() {
        System.out.println("\n📝 Neue Speise hinzufügen");
        String name = readStringInput("Speisen-Name: ");
        double preis = readDoubleInput("Preis (€): ");
        String kategorie = readStringInput("Kategorie (z.B. Döner, Salat): ");
        
        try {
            Speisen speise = new Speisen(name, preis, kategorie);
            orte.addSpeise(speise);
            System.out.println("✅ Speise hinzugefügt: " + speise);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }
    
    private static void listAllSpeisen() {
        System.out.println("\n📋 Alle Speisen:");
        if (orte.getSpeiseCount() == 0) {
            System.out.println("(Keine Speisen vorhanden)");
        } else {
            for (int i = 0; i < orte.getAllSpeisen().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, orte.getAllSpeisen().get(i));
            }
        }
    }
    
    private static void filterSpeiseByKategorie() {
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
    
    private static void deleteSpeise() {
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
        System.out.println("✅ Speise gelöscht: " + speise);
    }
    
    // ===== GETRÄNKE VERWALTUNG =====
    
    private static void manageGetraenke() {
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
    
    private static void addNewGetraenk() {
        System.out.println("\n📝 Neues Getränk hinzufügen");
        String name = readStringInput("Getränk-Name: ");
        double preis = readDoubleInput("Preis (€): ");
        String groesse = readStringInput("Größe (klein/mittel/groß): ");
        
        try {
            Getraenke getraenk = new Getraenke(name, preis, groesse);
            orte.addGetraenk(getraenk);
            System.out.println("✅ Getränk hinzugefügt: " + getraenk);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }
    }
    
    private static void listAllGetraenke() {
        System.out.println("\n📋 Alle Getränke:");
        if (orte.getGetraenkCount() == 0) {
            System.out.println("(Keine Getränke vorhanden)");
        } else {
            for (int i = 0; i < orte.getAllGetraenke().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, orte.getAllGetraenke().get(i));
            }
        }
    }
    
    private static void deleteGetraenk() {
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
        System.out.println("✅ Getränk gelöscht: " + getraenk);
    }
    
    // ===== ÜBERSICHT =====
    
    private static void printSummary() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📊 Übersicht");
        System.out.println("=".repeat(40));
        System.out.printf("🏪 Läden: %d%n", orte.getLadenCount());
        System.out.printf("🥙 Speisen: %d%n", orte.getSpeiseCount());
        System.out.printf("🥤 Getränke: %d%n", orte.getGetraenkCount());
        System.out.println("=".repeat(40));
    }
    
    // ===== HELPER INPUT-METHODEN =====
    
    /**
     * Zentrale Methode für String-Input mit Validierung.
     */
    private static String readStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("❌ Eingabe darf nicht leer sein!");
        }
    }
    
    /**
     * Zentrale Methode für Integer-Input mit Validierung.
     */
    private static int readIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Bitte geben Sie eine ganze Zahl ein!");
            }
        }
    }
    
    /**
     * Zentrale Methode für Double-Input mit Validierung.
     */
    private static double readDoubleInput(String prompt) {
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
    
    private static void initializeExampleData() {
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
