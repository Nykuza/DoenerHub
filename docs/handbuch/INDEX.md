# Inhaltsverzeichnis & Navigationshilfe

## 📖 Vollständiges Inhaltsverzeichnis

### Kerndokumentation
- [README.md](README.md) – Einstieg & Quick-Start
- [ARCHITEKTUR.md](ARCHITEKTUR.md) – Systemdesign & Komponenten
- [PFLICHTENHEFT.md](PFLICHTENHEFT.md) – Ziele, Scope, Qualität
- [INDEX.md](INDEX.md) – Diese Datei

### Prozesse & Workflows
- [Hauptmarschplan](marschplaene/HAUPTMARSCHPLAN.md) – Phasen & Milestones
- [Neue Routine erstellen](prozesse/neue-routine-erstellen.md)
- [Routine aktualisieren](prozesse/routine-aktualisieren.md)
- [Review-Prozess](prozesse/review-prozess.md) – Code-Review Standards
- [Redundanz-Management](prozesse/redundanz-management.md) – DRY & SSOT

### Templates
- [ROUTINE-TEMPLATE.md](templates/ROUTINE-TEMPLATE.md) – Vorlage für neue Routinen
- [beispiel-routine.md](templates/beispiel-routine.md) – Beispiel einer ausgefüllten Routine

### Routinen nach Zeitrahmen
- **Kurzfristig** (1-2 Tage): [routinen/kurzfristig/](routinen/kurzfristig)
- **Mittelfristig** (1-2 Wochen): [routinen/mittelfristig/](routinen/mittelfristig)
- **Langfristig** (1+ Monat): [routinen/langfristig/](routinen/langfristig)

---

## 🆘 "Ich möchte..." – Einstiege

### Ich möchte das Projekt verstehen
1. Start: [README.md](README.md) (5 Min)
2. Dann: [ARCHITEKTUR.md](ARCHITEKTUR.md) (15 Min)
3. Optional: [PFLICHTENHEFT.md](PFLICHTENHEFT.md) für Details

### Ich möchte eine neue Funktion implementieren
1. Schau [ARCHITEKTUR.md](ARCHITEKTUR.md), welche Komponente ändert sich
2. Wende [Routine aktualisieren](prozesse/routine-aktualisieren.md) an
3. Nutze das [ROUTINE-TEMPLATE.md](templates/ROUTINE-TEMPLATE.md)
4. Teste nach [Redundanz-Management](prozesse/redundanz-management.md)

### Ich möchte meinen Code überprüfen lassen
1. Lies [Review-Prozess](prozesse/review-prozess.md)
2. Bereite Deine Änderungen vor
3. Erstelle einen Pull Request mit Kontext

### Ich möchte doppelten Code vermeiden
1. Lies [Redundanz-Management](prozesse/redundanz-management.md)
2. Nutze das [SSOT-Prinzip](ARCHITEKTUR.md#designprinzipien)
3. Refaktoriere nach Vorlage

### Ich bin neuer Entwickler
1. **Tag 1:** [README.md](README.md) → [ARCHITEKTUR.md](ARCHITEKTUR.md)
2. **Tag 2:** [Hauptmarschplan](marschplaene/HAUPTMARSCHPLAN.md) + eine [Kurzfristig-Routine](routinen/kurzfristig)
3. **Woche 2:** [Review-Prozess](prozesse/review-prozess.md) + erste Contribution

### Ich bin Revisor/Mentor
1. [PFLICHTENHEFT.md](PFLICHTENHEFT.md) – Qualitätskriterien
2. [Review-Prozess](prozesse/review-prozess.md) – Standards
3. [ARCHITEKTUR.md](ARCHITEKTUR.md) – Design-Entscheidungen

---

## 🎓 Learning Paths

### Pfad: Anfänger (Woche 1)
**Zeit:** ~4 Stunden
```
README.md (5 Min)
    ↓
ARCHITEKTUR.md (30 Min)
    ↓
HAUPTMARSCHPLAN.md (20 Min)
    ↓
eine Kurzfristig-Routine aus templates/ (30 Min)
    ↓
Erste Aufgabe implementieren (2 Std)
```

**Ziel:** Verstehen der Architektur, erste praktische Erfahrung

### Pfad: Fortgeschrittene (Woche 2-4)
**Zeit:** ~6 Stunden / Woche
```
Review-Prozess.md (20 Min)
    ↓
Routine aktualisieren.md (20 Min)
    ↓
Redundanz-Management.md (30 Min)
    ↓
2-3 Mittelfristig-Routinen (2 Std)
    ↓
Eigene Features entwickeln & reviewen (2 Std)
```

**Ziel:** Eigenständige Entwicklung, Code Review verstehen

### Pfad: Experte (Woche 5+)
**Zeit:** Projektabhängig
```
Neue Routine erstellen.md (1 Std)
    ↓
PFLICHTENHEFT.md erweitern (1 Std)
    ↓
ARCHITEKTUR.md anpassen (Auf Bedarf)
    ↓
Langfristig-Routinen entwickeln
    ↓
Onboarden von neuen Entwicklern
```

**Ziel:** Projektverantwortung, Architektur-Mitgestaltung

---

## 🔍 Recherche-Übersicht

| Frage | Antwort in |
|-------|-----------|
| Was ist die Projektidee? | [PFLICHTENHEFT.md](PFLICHTENHEFT.md) › Ziele |
| Wie sind die Komponenten verbunden? | [ARCHITEKTUR.md](ARCHITEKTUR.md) › Datenfluss |
| Wie schreibe ich sauberen Code? | [README.md](README.md) › Best Practices |
| Was sind die nächsten Milestones? | [HAUPTMARSCHPLAN.md](marschplaene/HAUPTMARSCHPLAN.md) |
| Wie vermeide ich Duplikate? | [Redundanz-Management](prozesse/redundanz-management.md) |
| Wie erstelle ich eine PR? | [Review-Prozess](prozesse/review-prozess.md) |
| Wie wird Code evaluated? | [PFLICHTENHEFT.md](PFLICHTENHEFT.md) › Qualitätskriterien |
| Woher nehme ich eine Routine? | [ROUTINE-TEMPLATE.md](templates/ROUTINE-TEMPLATE.md) |

---

**Letzte Aktualisierung:** März 2026
