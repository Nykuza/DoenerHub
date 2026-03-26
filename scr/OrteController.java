package Klassen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasse für Orte (Locations) - verwaltung aller Läden, Speisen, Getränke.
 * Controller Layer: Business-Logik und Datenverwaltung.
 */
public class OrteController {
    private final List<Laeden> laeden = new ArrayList<>();
    private final List<Speisen> speisen = new ArrayList<>();
    private final List<Getraenke> getraenke = new ArrayList<>();
    // ===== LÄDEN =====

    public void addLaden(Laeden laden) {
        if (laden == null) {
            throw new IllegalArgumentException("Laden darf nicht null sein");
        }
        laeden.add(laden);
    }

    public void removeLaden(Laeden laden) {
        laeden.remove(laden);
    }

    public List<Laeden> getAllLaeden() {
        return new ArrayList<>(laeden);
    }

    public int getLadenCount() {
        return laeden.size();
    }

    // ===== SPEISEN =====

    public void addSpeise(Speisen speise) {
        if (speise == null) {
            throw new IllegalArgumentException("Speise darf nicht null sein");
        }
        speisen.add(speise);
    }

    public void removeSpeise(Speisen speise) {
        speisen.remove(speise);
    }

    public List<Speisen> getAllSpeisen() {
        return new ArrayList<>(speisen);
    }

    public int getSpeiseCount() {
        return speisen.size();
    }

    /**
     * Filtert Speisen nach Kategorie.
     */
    public List<Speisen> getSpeiseByKategorie(String kategorie) {
        return speisen.stream()
                .filter(s -> s.getKategorie().equalsIgnoreCase(kategorie))
                .collect(Collectors.toList());
    }

    // ===== GETRÄNKE =====

    public void addGetraenk(Getraenke getraenk) {
        if (getraenk == null) {
            throw new IllegalArgumentException("Getränk darf nicht null sein");
        }
        getraenke.add(getraenk);
    }

    public void removeGetraenk(Getraenke getraenk) {
        getraenke.remove(getraenk);
    }

    public List<Getraenke> getAllGetraenke() {
        return new ArrayList<>(getraenke);
    }

    public int getGetraenkCount() {
        return getraenke.size();
    }
}