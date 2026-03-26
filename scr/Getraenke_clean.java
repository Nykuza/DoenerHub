package Klassen;

/**
 * Klasse für Getränke.
 * Model Layer: Datendarstellung und Validierung.
 */
public class Getraenke {
    private String name;
    private double preis;
    private String groesse;

    public Getraenke(String name, double preis, String groesse) {
        this.setName(name);
        this.setPreis(preis);
        this.setGroesse(groesse);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Getränk-Name darf nicht leer sein");
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

    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
        if (groesse == null || groesse.trim().isEmpty()) {
            throw new IllegalArgumentException("Größe darf nicht leer sein");
        }
        this.groesse = groesse.trim();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - €%.2f", name, groesse, preis);
    }
}
