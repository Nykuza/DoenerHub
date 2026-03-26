package doener_verwaltung.controller;

import doener_verwaltung.model.Getraenke;
import doener_verwaltung.model.Speisen;

import java.util.List;

/**
 * Rechner für Bestellungen: Gesamtkosten, Rabatt und Lieferung.
 * Controller Layer: Business-Logik / Preisberechnung.
 */
public class BestellRechner {

    /**
     * Berechnet den Warenwert aller ausgewählten Artikel.
     */
    public double berechneWarenwert(List<Speisen> speisen, List<Getraenke> getraenke) {
        double gesamt = 0;
        for (Speisen s : speisen) {
            gesamt += s.getPreis();
        }
        for (Getraenke g : getraenke) {
            gesamt += g.getPreis();
        }
        return gesamt;
    }

    /**
     * Berechnet Versandkosten anhand der Entfernung.
     */
    public double berechneLieferkosten(double entfernungKm) {
        if (entfernungKm < 0) {
            throw new IllegalArgumentException("Entfernung darf nicht negativ sein");
        }
        double basis = 2.50;
        double proKm = 0.60;
        return basis + (proKm * entfernungKm);
    }

    /**
     * Rabatt 5% ab 20€, 10% ab 40€.
     */
    public double berechneRabatt(double warenwert) {
        if (warenwert >= 40) {
            return warenwert * 0.10;
        } else if (warenwert >= 20) {
            return warenwert * 0.05;
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
