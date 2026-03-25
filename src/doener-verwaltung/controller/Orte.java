package doener_verwaltung.controller;

import doener_verwaltung.model.Laeden;
import doener_verwaltung.model.Speisen;
import doener_verwaltung.model.Getraenke;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse für Orte (Locations) - verwaltung aller Läden, Speisen, Getränke.
 * Controller Layer: Business-Logik und Datenverwaltung.
 */
public class Orte {
    private List<Laeden> laeden;
    private List<Speisen> speisen;
    private List<Getraenke> getraenke;
    
    /**
     * Konstruktor initialisiert leere Listen.
     */
    public Orte() {
        this.laeden = new ArrayList<>();
        this.speisen = new ArrayList<>();
        this.getraenke = new ArrayList<>();
    }
    
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
     * 
     * @param kategorie Die gesuchte Kategorie
     * @return Liste der Speisen in dieser Kategorie
     */
    public List<Speisen> getSpeiseByKategorie(String kategorie) {
        List<Speisen> result = new ArrayList<>();
        for (Speisen speise : speisen) {
            if (speise.getKategorie().equalsIgnoreCase(kategorie)) {
                result.add(speise);
            }
        }
        return result;
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
