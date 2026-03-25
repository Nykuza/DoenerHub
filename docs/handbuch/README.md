# Handbuch: Schülerprojekt „DoenerHub"

Willkommen im Handbuch für das Schülerprojekt „DoenerHub"! Dieses Dokument hilft dir, schnell einen Überblick über das Projekt zu bekommen und produktiv zu arbeiten.

## 🚀 Quick-Start (5 Minuten)

### 1. Projekt verstehen
- **Was ist DoenerHub?** Ein einfaches Verwaltungssystem für Döner-Läden.
- **Kernkomponenten:** Model (Datenstrukturen), View (Ausgabe), Controller (Logik).

### 2. Erste Schritte
1. Lese [ARCHITEKTUR.md](ARCHITEKTUR.md) für den Systemaufbau
2. Schaue dir die Starter-Dateien in `src/` an
3. Starte mit einem Prozess aus [INDEX.md](INDEX.md)

### 3. Häufige Aufgaben
| Aufgabe | Siehe |
|---------|-------|
| Neue Funktion implementieren | [Routine aktualisieren](prozesse/routine-aktualisieren.md) |
| Code überprüfen lassen | [Review-Prozess](prozesse/review-prozess.md) |
| Duplikate vermeiden | [Redundanz-Management](prozesse/redundanz-management.md) |
| Marschplan und Planung | [Hauptmarschplan](marschplaene/HAUPTMARSCHPLAN.md) |

## 📚 Struktur dieses Handbuchs

```
docs/handbuch/
├── README.md (dieser Datei)
├── INDEX.md (vollständiges Inhaltsverzeichnis)
├── ARCHITEKTUR.md (Systemaufbau & Designprinzipien)
├── PFLICHTENHEFT.md (Ziele, Scope, Risiken)
├── marschplaene/
│   └── HAUPTMARSCHPLAN.md
├── prozesse/ (Review, Routinen, Redundanz)
├── routinen/ (Sammlungen von Best Practices)
└── templates/ (Vorlagen und Beispiele)
```

## 💡 Best Practices

1. **DRY (Don't Repeat Yourself)**
   - Kopierter Code → Gemeinsame Methode
   - Nutze [Redundanz-Management](prozesse/redundanz-management.md)

2. **SSOT (Single Source of Truth)**
   - Jede Info an nur einer Stelle
   - [ARCHITEKTUR.md](ARCHITEKTUR.md) ist die Quelle für Design-Entscheidungen

3. **Modularität**
   - Kleine, verständliche Klassen
   - Jede Klasse eine Verantwortung (SRP)

4. **Schreibe Tests**
   - Alle Kernlogik testen
   - Fehler früh finden

5. **Code-Lesbarkeit**
   - Aussagekräftige Variablennamen
   - Kommentare für das „Warum", nicht das „Was"

## 🎯 Learning Paths

### Anfänger (Woche 1)
1. [ARCHITEKTUR.md](ARCHITEKTUR.md) durchlesen
2. [Hauptmarschplan](marschplaene/HAUPTMARSCHPLAN.md) verstehen
3. Erste Routine aus [Kurzfristig-Sammlung](routinen/kurzfristig)

### Fortgeschrittene (Woche 2+)
1. [Review-Prozess](prozesse/review-prozess.md) meistern
2. Neue Routinen aus [Mittelfristig-Sammlung](routinen/mittelfristig)
3. [Redundanz-Management](prozesse/redundanz-management.md) praktizieren

### Experte
1. [Neue Routine erstellen](prozesse/neue-routine-erstellen.md)
2. [Architektur erweitern](ARCHITEKTUR.md)
3. [Pflichtenheft anpassen](PFLICHTENHEFT.md)

## ❓ Fragen?

- **Problem mit dem Projekt?** → [Redundanz-Management](prozesse/redundanz-management.md)
- **Code Review nötig?** → [Review-Prozess](prozesse/review-prozess.md)
- **Neuer Prozess?** → [Neue Routine erstellen](prozesse/neue-routine-erstellen.md)
- **Ziele unklar?** → [PFLICHTENHEFT.md](PFLICHTENHEFT.md)

---

*Letzte Aktualisierung: März 2026*
