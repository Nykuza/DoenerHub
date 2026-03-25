# Hauptmarschplan: DoenerHub Projekt

**Gesamtdauer:** 7-8 Wochen  
**Phasen:** 5  
**Status:** Aktiv seit März 2026

---

## 📈 Projekt-Übersicht

```
Woche 1-2          |  Woche 3-4      |  Woche 5-6      |  Woche 7-8
Setup & Basics     |  Features       |  Quality        |  Abschluss
════════════════════════════════════════════════════════════════
    │                  │               │                  │
    └──────────────────┴───────────────┴──────────────────┘
            Kontinuierlich: Doku, Code Review, Testing
```

---

## 🎯 Phase 1: Grundlagen & Setup (Wochen 1-2)

### Ziele
- MVC-Architektur verstehen & umsetzen
- Basis-Klassen schreiben
- Erstes Menü implementieren
- Doku-Struktur kennenlernen

### Milestones

#### Milestone 1.1: Projekt-Initalisierung
**Woche 1, Tag 1-2**
- [ ] Repository clonen/forken
- [ ] Projekt im IDE öffnen
- [ ] README & ARCHITEKTUR durchlesen
- [ ] Erste Notizen machen

**Deliverable:** Verständnis der Struktur  
**Reviewer:** Lehrender

#### Milestone 1.2: Model-Layer aufbauen
**Woche 1, Tag 3-5**
- [ ] Klasse `Laeden.java` schreiben
  - Attribute: name, adresse
  - Getters/Setters
  - toString() Methode
- [ ] Klasse `Speisen.java` schreiben
  - Attribute: name, preis, kategorie
  - Validierung (Preis > 0)
- [ ] Klasse `Getraenke.java` schreiben
  - Attribute: name, preis, groesse

**Akzeptanzkriterien:**
- ✅ Alle Klassen compilieren
- ✅ Getter/Setter funktionieren
- ✅ Validierung greift ein
- ✅ Tests für Model (optional in Phase 1)

**Reviewer:** Peer oder Lehrender

#### Milestone 1.3: Controller-Layer
**Woche 2, Tag 1-3**
- [ ] Klasse `Orte.java` schreiben
  - ArrayList<Laeden>
  - ArrayList<Speisen>
  - ArrayList<Getraenke>
  - Methoden: add(), remove(), getAll(), find()

**Akzeptanzkriterien:**
- ✅ CRUD-Operationen funktionieren
- ✅ Keine Duplikate in Code
- ✅ Fehlerbehandlung vorhanden

#### Milestone 1.4: Basis-Menü
**Woche 2, Tag 4-5**
- [ ] Main.java Anfangsversion
  - Menü mit Optionen (Add, Remove, List)
  - Scanner für Input
  - Einfache Validierung

**Deliverable:** Funktionales Konsolen-Menü

---

## 🔧 Phase 2: Feature-Development (Wochen 3-4)

### Ziele
- Umfangreiche CRUD-Operationen
- Filterung & Sortierung
- Mehr Menü-Optionen
- Erstes Code Review durchführen

### Milestones

#### Milestone 2.1: Erweiterte Repository-Methoden
**Woche 3, Tag 1-3**
- [ ] `findByName(String name)` implementieren
- [ ] `filterByCategory(String cat)` für Speisen
- [ ] `sortByPrice()` für Getränke
- [ ] Tests schreiben

**Reviewer:** Peer Review (2 Personen min.)

#### Milestone 2.2: Rich Menü-System
**Woche 3, Tag 4-5**
- [ ] Submenu für Läden-Verwaltung
- [ ] Submenu für Speisen-Verwaltung
- [ ] Submenu für Getränke-Verwaltung
- [ ] Rückkehr zum Hauptmenü

**Deliverable:** Navigierbares Menü-System

#### Milestone 2.3: Eingabe-Validierung
**Woche 4, Tag 1-3**
- [ ] Zentralisierte Input-Handling-Methode
- [ ] Fehlerbehandlung mit Try-Catch
- [ ] Benutzerfreundliche Fehlermeldungen

**Akzeptanzkriterien:**
- ✅ Keine Crashes durch ungültige Eingabe
- ✅ Klare Fehlermeldungen
- ✅ DRY-Prinzip angewendet

#### Milestone 2.4: Dokumentation Update
**Woche 4, Tag 4-5**
- [ ] Code-Kommentare hinzufügen
- [ ] ARCHITEKTUR.md aktualisieren
- [ ] User-Dokumentation schreiben

---

## 🧪 Phase 3: Quality Assurance (Woche 5-6)

### Ziele
- Testing & Code Coverage
- Redundanzen abbauen
- Code Review Standards
- Dokumentation vollständig

### Milestones

#### Milestone 3.1: Unit Tests
**Woche 5, Tag 1-3**
- [ ] JUnit 5 Setup
- [ ] Tests für Model-Klassen
- [ ] Tests für Validierung
- [ ] Tests für Edge-Cases

**Target:** ≥ 70% Code Coverage

#### Milestone 3.2: Code Review Prozess
**Woche 5, Tag 4-5**
- [ ] Review-Prozess dokumentieren
- [ ] Code Review für alle Klassen
- [ ] Feedback-Runden

**Reviewer:** Lehrender + mindestens 1 Peer

#### Milestone 3.3: Redundanz-Elimination
**Woche 6, Tag 1-3**
- [ ] Code-Duplikate identifizieren
- [ ] Refactoring durchführen
- [ ] Tests aktualisieren

**Ziel:** < 5% Duplikation

#### Milestone 3.4: Doku-Vollständigkeit
**Woche 6, Tag 4-5**
- [ ] README aktualisiert
- [ ] Alle API dokumentiert
- [ ] User-Guide fertig
- [ ] README.md im Code prüfen

---

## 🚀 Phase 4: Optimierung & Erweiterungen (Woche 7)

### Ziele (Abhängig von Fortschritt)
- Performance-Optimierungen
- Zusatz-Features
- Persistierung (optional)
- Advanced Topics

### Wahlmöglichkeiten

**Option A: Persistierung**
- [ ] Speichern zu Datei (CSV/JSON)
- [ ] Laden aus Datei
- [ ] Automat. Speichern beim Beenden

**Option B: Datenbank**
- [ ] SQLite Integration
- [ ] Migrations-Skripte
- [ ] Daten-Abfragen

**Option C: Erweiterte Features**
- [ ] Sortierung nach mehreren Feldern
- [ ] Such-Funktionen
- [ ] Statistiken/Reports

**Option D: Testing & Performance**
- [ ] Integration Tests
- [ ] Performance-Messungen
- [ ] Refactoring

---

## 🎓 Phase 5: Abschluss (Woche 7-8)

### Ziele
- Projekt polieren
- Präsentation vorbereiten
- Reflexion & Feedback
- Lessons Learned dokumentieren

### Milestones

#### Milestone 5.1: Final Code Review
- [ ] Security Check
- [ ] Performance Check
- [ ] Doku-Finale

#### Milestone 5.2: Präsentation vorbereiten
- [ ] Demo-Szenario schreiben
- [ ] Präsentations-Folien
- [ ] Architektur-Dia vorbereiten

#### Milestone 5.3: Reflexion & Dokumentation
- [ ] Lessons Learned schreiben
- [ ] Zeitbilanz
- [ ] Kompetenzen-Selbsteinschätzung

#### Milestone 5.4: Projekt-Demo & Abnahme
- [ ] Live-Demo
- [ ] Q&A Session
- [ ] Feedback-Runde

---

## 🔄 Kontinuierliche Aktivitäten (jede Woche)

### Täglich
- [ ] Code schreiben & testen
- [ ] Mit Team synchronisieren
- [ ] Fragen stellen bei Blockern

### Wöchentlich
- [ ] Code Review durchführen (24h Max)
- [ ] Doku aktualisieren
- [ ] Fortschritt im Tracking updaten
- [ ] 1:1 mit Lehrendem/Mentor (15-30 min)

### Regelmäßig
- [ ] Redundanz-Check (Woche 3, 5, 7)
- [ ] Architektur-Review (Woche 2, 4, 6)
- [ ] Doku-Prüfung (Woche 2, 4, 6, 8)

---

## 📊 Status-Tracking

### Wöchentliche Statusvorlage

```
WOCHE: <n>
================

✅ Fertig diese Woche:
- Milestone X.Y
- Feature Z

🚧 In Arbeit:
- Task A (90% done)
- Task B (40% done)

⚠️ Blocker:
- Frage zu Methode X
- Fehler in Klasse Y

📈 Nächste Woche:
- Milestone X.(Y+1)
- Feature Z+1
```

---

## 🎯 Erfolgs-Metriken

| Metrik | Ziel | Messung |
|--------|------|---------|
| Code Coverage | ≥ 70% | JUnit / Coverage Tools |
| Review-Cycle | < 24h | Timestamp-Check |
| Doku-Aktualität | 100% | Last-Modified Dates |
| Test-Pass-Rate | 100% | CI/Test Report |
| Duplizierung | < 5% | Code Duplication Tools |

---

## 💾 Archivierung & Übergabe

Nach Abschluss:
1. Final-Commit mit Tag: `v1.0-final`
2. Release Notes schreiben
3. Doku-Snapshot erstellen
4. Feedback für nächste Kohorten sammeln

---

**Letzte Aktualisierung:** März 2026

*Fragen zum Plan? → Projektleitung oder [README.md](../README.md)*
