package Klassen;

/**
 * Klasse für Döner-Laden.
 * Model Layer: Datendarstellung und Validierung.
 */
public class Laeden {
    private String name;
    private String adresse;

    /**
     * Konstruktor für Laaden.
     *
     * @param name Der Name des Ladens (nicht leer)
     * @param adresse Die Adresse des Ladens (nicht leer)
     * @throws IllegalArgumentException wenn name oder adresse leer sind
     */
    public Laeden(String name, String adresse) {
        this.setName(name);
        this.setAdresse(adresse);
    }

    /**
     * Getter für Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für Name mit Validierung.
     *
     * @param name Der neue Name (nicht leer)
     * @throws IllegalArgumentException wenn name leer ist
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Laden-Name darf nicht leer sein");
        }
        this.name = name.trim();
    }

    /**
     * Getter für Adresse.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter für Adresse mit Validierung.
     *
     * @param adresse Die neue Adresse (nicht leer)
     * @throws IllegalArgumentException wenn adresse leer ist
     */
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
	
	public String getZahlungsart(){
		return this.zahlungsart;
	}
	
	public String getBestellen(){
		return this.bestellen;
	}
	
	public String toString(){
		return "LadenID:" + this.ladenId +"\n" + "LadenName:" + this.ladenName + "\n" + "Anschrift:" + this.anschrift + "\n" + "Hausnummer:" + this.hausnummer + "\n" + "Telefonnummer:" + this.telefonnummer + "\n" + "TeuerstesProdukt:" + this.teuerstesProdukt + "\n" + "GuenstigstesProdukt:" + this.guenstigstesProdukt + "\n" + "Zahlungsart:" + this.zahlungsart + "\n" + "Bestellen:" + this.bestellen + "\n";
	}
	
}

