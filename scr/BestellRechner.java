package Klassen;

import java.util.List;

/**
 * Rechner für Bestellungen: Gesamtkosten, Rabatt und Lieferung.
 * Controller Layer: Business-Logik / Preisberechnung.
 */
public class BestellRechner {

    private static final double BASIS_LIEFERKOSTEN = 2.50;
    private static final double LIEFERKOSTEN_PRO_KM = 0.60;
    private static final double RABATT_SCHWELLE_1 = 20.0;
    private static final double RABATT_SCHWELLE_2 = 40.0;
    private static final double RABATT_PROZENT_1 = 0.05;
    private static final double RABATT_PROZENT_2 = 0.10;

    /**
     * Berechnet den Warenwert aller ausgewählten Artikel.
     */
    public double berechneWarenwert(List<Speisen> speisen, List<Getraenke> getraenke) {
        return speisen.stream().mapToDouble(Speisen::getPreis).sum() +
               getraenke.stream().mapToDouble(Getraenke::getPreis).sum();
    }

    /**
     * Berechnet Versandkosten anhand der Entfernung.
     */
    public double berechneLieferkosten(double entfernungKm) {
        if (entfernungKm < 0) {
            throw new IllegalArgumentException("Entfernung darf nicht negativ sein");
        }
        return BASIS_LIEFERKOSTEN + (LIEFERKOSTEN_PRO_KM * entfernungKm);
    }

    /**
     * Rabatt 5% ab 20€, 10% ab 40€.
     */
    public double berechneRabatt(double warenwert) {
        if (warenwert >= RABATT_SCHWELLE_2) {
            return warenwert * RABATT_PROZENT_2;
        } else if (warenwert >= RABATT_SCHWELLE_1) {
            return warenwert * RABATT_PROZENT_1;
        }
        return 0;
    }

    /**
     * Gesamtpreis inklusive Rabatt und optionaler Lieferung.
     */
    public double berechneTotalpreis(List<Speisen> speisen, List<Getraenke> getraenke, double entfernungKm, boolean mitLieferung) {
        double warenwert = berechneWarenwert(speisen, getraenke);
        double rabatt = berechneRabatt(warenwert);
        double total = warenwert - rabatt;
        if (mitLieferung) {
            total += berechneLieferkosten(entfernungKm);
        }
        return total;
    }
}