package Klassen;

/**
 * Klasse für Döner-Laden.
 * Model Layer: Datendarstellung und Validierung.
 */
public class Laeden {
    private String name;
    private String adresse;

    public Laeden(String name, String adresse) {
        this.setName(name);
        this.setAdresse(adresse);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Laden-Name darf nicht leer sein");
        }
        this.name = name.trim();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        if (adresse == null || adresse.trim().isEmpty()) {
            throw new IllegalArgumentException("Laden-Adresse darf nicht leer sein");
        }
        this.adresse = adresse.trim();
    }

    @Override
    public String toString() {
        return String.format("Laden: %s (%s)", name, adresse);
    }
}
