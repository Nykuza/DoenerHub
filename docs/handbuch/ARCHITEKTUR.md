# ARCHITEKTUR: DoenerHub Systemdesign

## 🎯 Systemkontext

**DoenerHub** ist ein educatives Verwaltungssystem für Döner-Läden, das Best Practices in Softwaredesign demonstriert. Das System basiert auf einer **klassischen MVC-Architektur** (Model-View-Controller) für Lehrzwecke.

```
┌─────────────────────────────────────────────────────────┐
│                      DoenerHub App                       │
├─────────────────────────────────────────────────────────┤
│                                                           │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐  │
│  │   Controller │  │   View       │  │   Model      │  │
│  │  (Orte,      │  │  (Ausgabe)   │  │  (Läden,     │  │
│  │   Speisen,   │  │              │  │   Getränke)  │  │
│  │   Getränke)  │  │              │  │              │  │
│  └──────────────┘  └──────────────┘  └──────────────┘  │
│        ↑                  ↑                  ↑           │
│        └──────────────────┼──────────────────┘           │
│                      Main.java                          │
│                                                          │
└─────────────────────────────────────────────────────────┘
```

---

## 🧩 Komponenten

### Model Layer
**Verantwortung:** Datendarstellung und Validierung

| Klasse | Aufgaben | Abhängigkeiten |
|--------|----------|------------------|
| `Laeden` | Verwaltung von Läden (Name, Adresse, Status) | Keine |
| `Speisen` | Verwaltung von Speisen (Name, Preis, Kategorie) | Keine |
| `Getraenke` | Verwaltung von Getränken (Name, Preis, Größe) | Keine |

**Prinzipien:**
- Datenstrukturen sind Klassen mit klaren Attributen
- Validierung direkt im Constructor
- Getter/Setter für Datenzugriff (mit Validierung)

### View Layer
**Verantwortung:** Ausgabe an Benutzer (Konsole)

| Komponente | Aufgabe |
|------------|---------|
| Konsolen-Output | Text-basierte Menüs und Ergebnisse |
| Formatierung | Tabellen, Listen, Bestätigungsmeldungen |

**Prinzipien:**
- Trennung von Logik und Ausgabe
- Keine Business-Logik in View-Code
- Wiederverwendbare Formatierungsmethoden

### Controller Layer
**Verantwortung:** Orchestrierung und Business-Logik

| Klasse | Aufgaben |
|--------|----------|
| `Orte` | Verwaltung von Orten (Läden, Speisen, Getränke) |
| Main-Logik | Benutzerinteraktion und Workflow |

**Prinzipien:**
- Koordiniert Model und View
- Implementiert Business-Regeln
- Behandelt Benutzer-Input

### Main-Klasse
**Verantwortung:** Einstiegspunkt und Orchestrierung

```java
public class Main {
    public static void main(String[] args) {
        // 1. Initialisierung
        // 2. Objekte erstellen
        // 3. Menü-Loop
        // 4. Benutzer-Eingaben verarbeiten
    }
}
```

---

## 🔄 Datenfluss

### Ein vollständiger Request-Zyklus

```
┌─────────────────────────────────────────────────┐
│  1. BENUTZER-INPUT                              │
│  ("Neue Speise hinzufügen")                     │
└──────────────────┬────────────────────────────┘
                   │
┌──────────────────▼────────────────────────────┐
│  2. MAIN / CONTROLLER                          │
│  Input validieren, Parameter extrahieren      │
└──────────────────┬────────────────────────────┘
                   │
┌──────────────────▼────────────────────────────┐
│  3. MODEL (Geschäftslogik)                     │
│  Neue Speise erzeugen, Regeln prüfen         │
│  Speise in Liste/Datenstruktur speichern      │
└──────────────────┬────────────────────────────┘
                   │
┌──────────────────▼────────────────────────────┐
│  4. VIEW (Ausgabe)                            │
│  "Speise 'Döner' erfolgreich hinzugefügt"    │
└─────────────────────────────────────────────┘
```

---

## 📐 Designprinzipien

### 1. DRY – Don't Repeat Yourself
**Ziel:** Code-Duplikate vermeiden

❌ **Schlecht:**
```java
// In mehreren Slots kopiert
System.out.println("Enter name:");
String name = scanner.nextLine();
if (name.isEmpty()) {
    System.out.println("Error!");
    return;
}
```

✅ **Gut:**
```java
private String readAndValidateInput(String prompt) {
    System.out.println(prompt);
    String input = scanner.nextLine().trim();
    if (input.isEmpty()) {
        throw new IllegalArgumentException("Input darf nicht leer sein");
    }
    return input;
}
```

**Richtlinie:** Wenn Code 2× kopiert wird → Methode schreiben

### 2. SSOT – Single Source of Truth
**Ziel:** Jede Information an nur einer Stelle

❌ **Schlecht:**
```java
class Laeden {
    private String name;
}
// ... später in einer anderen Methode:
String ladenName = "..."; // Duplikat der Info!
```

✅ **Gut:**
```java
class Laeden {
    private String name;
    
    public String getName() {  // Einzige Quelle
        return name;
    }
}
```

**Richtlinie:** Namen, Regeln, Status nur an einer Stelle definieren

### 3. Modularität (SRP – Single Responsibility Principle)
**Ziel:** Jede Klasse hat genau eine Verantwortung

❌ **Schlecht:**
```java
class Speisen {
    void saveToDB() { }          // DB-Logik
    void printToScreen() { }     // UI-Logik
    void calculatePrice() { }    // Business-Logik
}
```

✅ **Gut:**
```java
// Speisen: nur Datenstruktur
class Speisen {
    private String name;
    private double preis;
}

// Speisen-Repository: DB-Logik
class SpeisRepository { }

// Speisen-View: UI-Logik
class SpeisView { }
```

**Richtlinie:** Wenn eine Klasse zu viele Verantwortungen hat → Splitten

### 4. Separation of Concerns (SoC)
**Ziel:** Verschiedene Aspekte trennen

| Aspekt | Klasse/Layer |
|--------|-------------|
| Daten | Model |
| Ausgabe | View |
| Logik | Controller |

**Richtlinie:** Controller entscheidet, View zeigt, Model speichert

---

## 🚀 Erweiterungspunkte

### Für kleine Projekte (Phase 1)
- Mehr Items zu Model-Klassen (z.B. Getränke-Größen)
- Persistierung (Dateien, JSON)
- Validierungsregeln erweitern

### Für mittlere Projekte (Phase 2)
- Datenbank-Integration (SQL)
- Authentifizierung (Login-System)
- Benutzerrollen (Admin/Benutzer)

### Für große Projekte (Phase 3)
- REST-API
- Frontend-Framework (Web-UI)
- Testen-Framework (JUnit)
- CI/CD-Pipeline

---

## 🔐 Qualitätsregeln (Non-Negotiable)

1. **Keine leeren Catch-Blöcke**
   ```java
   ❌ try { } catch (Exception e) { }
   ✅ try { } catch (Exception e) { e.printStackTrace(); }
   ```

2. **Aussagekräftige Variablennamen**
   ```java
   ❌ String s = scanner.nextLine();
   ✅ String userName = scanner.nextLine();
   ```

3. **Jede Methode hat eine Aufgabe**
   - Max 20 Zeilen (Richtlinie)
   - 1-2 Verantwortungen

4. **Tests für kritische Logik**
   - Validierung testen
   - Edge-Cases (leerer Input, Null, negative Werte)

5. **Kommentare für das „Warum", nicht das „Was"**
   ```java
   ❌ // Schleife über alle Läden
   for (Laeden laden : laeden) { }
   
   ✅ // Läden sortieren nach Öffnungszeit (früheste zuerst)
   for (Laeden laden : laeden) { }
   ```

---

## 📋 Abhängigkeits-Map

```
Main.java
├── Orte (Controller)
├── Laeden (Model)
├── Speisen (Model)
├── Getraenke (Model)
└── java.util.Scanner (Input)

Orte.java
├── Laeden (Model)
├── Speisen (Model)
├── Getraenke (Model)
└── java.util.ArrayList (Storage)
```

**Keine Zirkeldependenzen erlaubt!**

---

## 🎓 Lernziele für Schüler

Nach dem Verständnis dieser Architektur können Schüler:

- ✅ Model-View-Controller unterscheiden
- ✅ Modularität anwenden
- ✅ DRY und SSOT verstehen
- ✅ Separation of Concerns implementieren
- ✅ Einfache Klassen-Hierarchien bauen
- ✅ Listen und Collections verwenden
- ✅ Input-Validierung schreiben
- ✅ Fehlerbehandlung strukturieren

---

**Letzte Aktualisierung:** März 2026

*Fragen zur Architektur? → [README.md](README.md) oder [PFLICHTENHEFT.md](PFLICHTENHEFT.md)*
