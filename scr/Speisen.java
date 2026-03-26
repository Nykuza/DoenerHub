package Klassen;

/**
 * Klasse für Speisen (Menu-Items).
 * Model Layer: Datendarstellung und Validierung.
 */
public class Speisen {
    private String name;
    private double preis;
    private String kategorie;

    /**
     * Konstruktor für Speisen.
     *
     * @param name Der Name der Speise (nicht leer)
     * @param preis Der Preis (muss > 0 sein)
     * @param kategorie Die Kategorie z.B. "Döner", "Salat" (nicht leer)
     * @throws IllegalArgumentException bei ungültigen Eingaben
     */
    public Speisen(String name, double preis, String kategorie) {
        this.setName(name);
        this.setPreis(preis);
        this.setKategorie(kategorie);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Speisen-Name darf nicht leer sein");
        }
        this.name = name.trim();
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        if (preis <= 0) {
            throw new IllegalArgumentException("Preis muss > 0 sein");
        }
        this.preis = preis;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        if (kategorie == null || kategorie.trim().isEmpty()) {
            throw new IllegalArgumentException("Kategorie darf nicht leer sein");
        }
        this.kategorie = kategorie.trim();
    }

    @Override
    public String toString() {
        return String.format("%s (€%.2f) [%s]", name, preis, kategorie);
    }
}
