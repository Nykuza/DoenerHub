# DoenerHub: Schulische Projektvorlage für Softwareentwicklung

**Version:** 1.0  
**Status:** Template Ready  
**Sprache:** Deutsch  
**Zielgruppe:** Schüler (Klasse 10-13) / Berufsschule

---

## 🎯 Zweck dieses Templates

**DoenerHub** ist eine didaktische Projektvorlage, die Schülern zeigt:

- ✅ **Professionelle Softwarearchitektur** (Model-View-Controller)
- ✅ **Best Practices in Codequalität** (DRY, SSOT, Modularität)  
- ✅ **Teamfähigkeit & Prozesse** (Code Review, Git Workflow)
- ✅ **Vollständige Dokumentation** als Lernressource
- ✅ **Austauschbarer Startcode** für verschiedene Schülerprojekte

Das System demonstriert eine einfache **Döner-Laden-Verwaltung** als Beispiel. Der Code ist leicht ersetzbar – Sie können die Geschäftslogik anpassen, während die Architektur & Prozesse gleich bleiben.

---

## 🚀 Quick Start für Schüler (5 Minuten)

### 1. Repository klonen
```bash
git clone <repo-url>
cd DoenerHub
```

### 2. Handbuch lesen
- **Start:** [docs/handbuch/README.md](docs/handbuch/README.md)
- **Architektur:** [docs/handbuch/ARCHITEKTUR.md](docs/handbuch/ARCHITEKTUR.md)
- **Planung:** [docs/handbuch/marschplaene/HAUPTMARSCHPLAN.md](docs/handbuch/marschplaene/HAUPTMARSCHPLAN.md)

### 3. Code anschauen
```
src/doener-verwaltung/
├── model/          # Datenstrukturen (Läden, Speisen, Getränke)
├── controller/     # Business-Logik (Verwaltung)
└── Main.java       # UI-Loop (Menü-System)
```

### 4. Kompilieren & Starten
```bash
# Kompilieren
javac -d bin src/doener-verwaltung/**/*.java

# Starten
java -cp bin doener_verwaltung.Main
```

### 5. Erste Aufgabe
Siehe [Handbuch-Einstieg](docs/handbuch/README.md) → **Learning Paths** → **Anfänger**

---

## 📚 Dokumentations-Struktur

```
docs/handbuch/
├── README.md ........................ Quick-Start & Best Practices
├── INDEX.md ........................ Vollständiges Inhaltsverzeichnis
├── ARCHITEKTUR.md .................. System-Design & Designprinzipien
├── PFLICHTENHEFT.md ................ Ziele, Scope, Qualitätskriterien
│
├── marschplaene/
│   └── HAUPTMARSCHPLAN.md ......... Phasen, Milestones, Zeitplan
│
├── prozesse/
│   ├── neue-routine-erstellen.md . Neue Standard-Abläufe dokumentieren
│   ├── routine-aktualisieren.md ... Features entwicklen & refaktorieren
│   ├── review-prozess.md ........... Code Review Standards
│   └── redundanz-management.md .... DRY & SSOT anwenden
│
├── templates/
│   ├── ROUTINE-TEMPLATE.md ........ Vorlage für neue Routinen
│   └── beispiel-routine.md ........ Ausführliches Beispiel
│
└── routinen/
    ├── kurzfristig/ ............... Tasks < 2 Tage
    ├── mittelfristig/ ............ Tasks 2-7 Tage
    └── langfristig/ .............. Tasks > 1 Woche
```

**Start:** [docs/handbuch/INDEX.md](docs/handbuch/INDEX.md) für komplette Navigation

---

## 🎓 Lern-Level

### 👶 Anfänger (Woche 1)
- Code lesen & verstehen
- Erste größere Feature implementieren
- Tests schreiben
- **Handbuch:** [README.md](docs/handbuch/README.md)

### 🧑 Fortgeschrittene (Wobche 2-3)
- Code Review durchführen  
- Redundanzen erkennen & abbauen
- Refactoring durchführen
- **Handbuch:** [Review-Prozess](docs/handbuch/prozesse/review-prozess.md)

### 🦸 Experte (Woche 4+)
- Architektur-Entscheidungen treffen
- Neue Prozesse definieren
- Mentoring für neue Schüler
- **Handbuch:** [Neue Routine erstellen](docs/handbuch/prozesse/neue-routine-erstellen.md)

---

## 🛠️ Projekt für Schüler anpassen

### Schritt 1: Gesamtkonzept kopieren, Inhalt ersetzen

```
NICHT ändern:
├── docs/handbuch/        (Prozesse & Templates bleiben)
├── Verzeichnisstruktur  (Model/Controller/Main bleibt)

ÄNDERN SIE:
├── src/doener-verwaltung/
│   ├── model/           ← Neue Datenstrukturen (z.B. Student, Noten statt Laaden, Speisen)
│   ├── controller/      ← Neue Business-Logik
│   └── Main.java        ← Neues Menü-System
│
└── README.md            ← Update mit neuem Projekt-Kontext
```

### Schritt 2: Handbuch-Referenzen aktualisieren

In `docs/handbuch/ARCHITEKTUR.md`:
- Systemkontext ersetzen (Komponentendiagramm anpassen)
- Beispiel-Code für neue Domäne anpassen
- Links aktualisieren

### Schritt 3: Starter-Daten aktualisieren

In `src/doener-verwaltung/Main.java`:
- `initializeExampleData()` mit relevanten Beispieldaten füllen
- Menü-Texte anpassen
- Fehlerbehandlung konsistent halten

---

## 📋 Git-Workflow für Schüler

### Branch erstellen
```bash
git checkout -b feature/meine-aufgabe
```

### Arbeiten & Committen
```bash
git add src/
git commit -m "feat: Feature XYZ implementiert"
```

### Code Review einholen
```bash
git push origin feature/...
# Erstelle Pull Request auf GitHub/GitLab
# Warte auf Review
```

### Merge nach Review
```bash
git checkout main
git merge feature/...
git push origin main
```

**Details:** [Routine aktualisieren](docs/handbuch/prozesse/routine-aktualisieren.md#schritt-5-fällt-weg-für-schüler-bei-bedarf-anonym) (vereinfacht für Schule)

---

## 🎯 Qualitäts-Standards

### Code-Qualität
- ✅ **Tests:** ≥ 70% Coverage (JUnit 5)
- ✅ **DRY:** Keine Duplikate (max 2 Zeilen Ähnlichkeit)
- ✅ **Lesbarkeit:** Max 20 LOC pro Methode
- ✅ **Fehlerbehandlung:** Exception-Handling für Nutzer-Input

### Dokumentation  
- ✅ **Aktualität:** Mit Code-Änderungen synchron
- ✅ **Vollständigkeit:** Jede Klasse/Methode dokumentiert
- ✅ **Beispiele:** Code-Snippets in Doku

### Prozesse
- ✅ **Code Review:** Vor jedem Merge (24h SLA)
- ✅ **Testing:** Alle Tests grün vor Merge
- ✅ **Commit-Messages:** Aussagekräftig (siehe [Routine aktualisieren](docs/handbuch/prozesse/routine-aktualisieren.md))

---

## 📞 Häufige Aufgaben

| Ich möchte... | Lese... |
|---|---|
| Das Projekt verstehen | [ARCHITEKTUR.md](docs/handbuch/ARCHITEKTUR.md) |
| Eine neue Funktion implementieren | [Routine aktualisieren](docs/handbuch/prozesse/routine-aktualisieren.md) |
| Code überprüfen lassen | [Review-Prozess](docs/handbuch/prozesse/review-prozess.md) |
| Duplikate vermeiden | [Redundanz-Management](docs/handbuch/prozesse/redundanz-management.md) |
| Tests schreiben | [Beispiel-Routine](docs/handbuch/templates/beispiel-routine.md) |
| Neue Routine dokumentieren | [ROUTINE-TEMPLATE](docs/handbuch/templates/ROUTINE-TEMPLATE.md) |
| Marschplan sehen | [Hauptmarschplan](docs/handbuch/marschplaene/HAUPTMARSCHPLAN.md) |

---

## 🔧 Technische Details

### Voraussetzungen  
- **Java:** 11+ (oder beliebig neuer)
- **IDE:** IntelliJ IDEA oder VS Code mit Java Extensions
- **Git:** Version Control
- **Maven:** Build-Tool (optional, für Tests)

### Projekt-Struktur
```
DoenerHub/
├── src/doener-verwaltung/           # Source Code
│   ├── model/                        # Model Layer (Datenstrukturen)
│   ├── controller/                   # Controller Layer (Logik)
│   └── Main.java                     # View Layer (UI)
├── docs/handbuch/                    # Dokumentation & Prozesse
├── LICENSE                           # MIT License
└── README.md                         # Diese Datei
```

### Kompilieren

```bash
# Einfach (Single File):
javac -d bin src/doener-verwaltung/**/*.java

# Mit Maven (falls pom.xml vorhanden):
mvn clean compile
mvn test
```

### TODO: Nächste Schritte

- [ ] Java IDE installieren
- [ ] Repository clonen
- [ ] Handbuch lesen ([Index](docs/handbuch/INDEX.md))
- [ ] Code compilieren & starten
- [ ] Erste Routine aus [Learning Path](docs/handbuch/INDEX.md#lernpaths) durchführen

---

## 📜 Lizenz

Dieses Projekt steht unter der **MIT License**. Siehe [LICENSE](LICENSE) für Details.

---

## 💬 Feedback & Support

- **Doku-Fragen?** → Siehe [INDEX.md](docs/handbuch/INDEX.md)
- **Code-Fragen?** → Mentor oder Lehrende
- **Fehler gefunden?** → Issue im Git-Repository
- **Doku verbessern?** → Pull Request willkommen!

---

## 📝 Versionsverlauf

| Version | Datum | Status |
|---------|-------|--------|
| 1.0 | März 2026 | Produktionsreife Template |

---

**Viel Erfolg beim Lernen! 🚀**

*Fragen? → [Handbuch-Index](docs/handbuch/INDEX.md) oder Mentor fragen*
