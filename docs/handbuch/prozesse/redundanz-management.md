# Prozess: Redundanz-Management

**Zielgruppe:** Alle Entwickler  
**Dauer:** 15-45 Minuten (je Aufgabe)  
**Häufigkeit:** Kontinuierlich during development

---

## 🎯 Zweck

Redundanz-Management verhindert Code-Duplikate und Informations-Duplikate (Verletzung von DRY und SSOT). Dieser Prozess hilft, den Code sauber und wartbar zu halten.

**Beispiele für Redundanz:**
- ❌ Input-Validierung in 3 verschiedenen Methoden
- ❌ Gleiche Geschäftslogik in 2 Klassen
- ❌ Konstanten definiert an mehreren Stellen
- ❌ Dokumentation beschreibt gleiche Sache 2× unterschiedlich

---

## 📋 Schritt-für-Schritt Ablauf

### Phase 1: Redundanz erkennen

#### Automatische Erkennung
```bash
# Code Duplikation mit SonarQube checken
mvn sonar:sonar

# Oder manuell mit IDE
# IntelliJ: Analyze > Run Inspection > Duplicated Code
```

#### Manuelle Erkennung (Code Review)

**Red Flags:**

```java
// 🚩 Gleiche Logik in 2 Methoden
public void addLaden(String name) {
    if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("Name required");
    }
    // Logic
}

public void addSpeise(String name) {
    if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("Name required");
    }
    // Logic
}
```

**Faustregel:** Wenn Code 2× kopiert ist → Extrahieren

### Phase 2: Analyse

**Schritt 1: Redundante Code-Stellen finden**

```
// File1.java (Zeile 45-50)
String city = scanner.nextLine();
if (city.isEmpty()) {
    System.out.println("City required!");
}

// File2.java (Zeile 120-125)
String address = scanner.nextLine();
if (address.isEmpty()) {
    System.out.println("Address required!");
}
```

**Schritt 2: Unterschiede identifizieren**

```
Gemeinsamkeiten:
- Input-Validierung
- Error-Message Output

Unterschiede:
- Variable Namen
- Error-Messages leicht anders
- Kontext unterschiedlich
```

**Schritt 3: Abstraktions-Level bestimmen**

```
Fragen:
1. Sind die Logiken WIRKLICH gleich?
2. Können sie abstrahiert werden?
3. Macht eine gemeinsame Methode Sinn?
4. Oder sind es nur ähnlich-aussehend?
```

### Phase 3: Refactoring

#### Option A: Methode extrahieren

**Vorher:**
```java
// In Main.java
String city = scanner.nextLine();
if (city.isEmpty()) {
    System.out.println("City required!");
}

String address = scanner.nextLine();
if (address.isEmpty()) {
    System.out.println("Address required!");
}
```

**Nachher:**
```java
// In Main.java (privat)
private String readNonEmptyInput(String prompt) {
    System.out.println(prompt);
    String input = scanner.nextLine().trim();
    if (input.isEmpty()) {
        throw new IllegalArgumentException("Input darf nicht leer sein");
    }
    return input;
}

// Verwendet
String city = readNonEmptyInput("City: ");
String address = readNonEmptyInput("Address: ");
```

**Benefits:**
- ✅ DRY respektiert
- ✅ Tests können auf eine Methode testen
- ✅ Änderungen nur an einer Stelle

#### Option B: Konstanten zentralisieren

**Vorher:**
```java
// In Main.java (Zeile 10)
String ERROR_MESSAGE = "Input darf nicht leer sein";

// In Utils.java (Zeile 50)
String ERROR_MESSAGE = "Input darf nicht leer sein";

// In Validator.java (Zeile 100)
String validationError = "Input darf nicht leer sein";
```

**Nachher:**
```java
// In Constants.java
public class Constants {
    public static final String ERROR_REQUIRED = "Input darf nicht leer sein";
    public static final String ERROR_INVALID_PRICE = "Preis muss > 0 sein";
}

// Überall verwendet
throw new IllegalArgumentException(Constants.ERROR_REQUIRED);
```

**Benefits:**
- ✅ SSOT respektiert
- ✅ Änderungen an nur einem Ort
- ✅ Konsistente Messages

#### Option C: Klasse/Interface nutzen

**Vorher:**
```java
// Validierungs-Logik zwischen Klassen verteilt
class Speisen {
    void validate() { ... }
}

class Getraenke {
    void validate() { ... }
}
```

**Nachher:**
```java
// Gemeinsame Interface
public interface Validable {
    void validate() throws ValidationException;
}

// Implementiert in Model-Klassen
public class Speisen implements Validable {
    @Override
    public void validate() { ... }
}
```

### Phase 4: Testing

**Schritt 1: Tests schreiben**

```java
@Test
void testReadNonEmptyInput_WithValidInput() {
    // Setup
    String validInput = "TestCity";
    
    // Execute
    String result = main.readNonEmptyInput("prompt");
    
    // Assert
    assertEquals("TestCity", result);
}

@Test
void testReadNonEmptyInput_WithEmptyInput() {
    // Setup
    String emptyInput = "";
    
    // Execute & Assert
    assertThrows(IllegalArgumentException.class, 
        () -> main.readNonEmptyInput("prompt"));
}
```

**Schritt 2: Regression checken**

```bash
# Alle Tests müssen noch grün sein
mvn test

# Coverage checken
mvn jacoco:report
```

### Phase 5: Dokumentation

**Schritt 1: Neue Methode dokumentieren**

```java
/**
 * Liest eine non-empty Eingabe vom Benutzer.
 * 
 * @param prompt Die Eingabe-Aufforderung für den Benutzer
 * @return Die eingegebene, getrimte, non-empty Zeichenkette
 * @throws IllegalArgumentException wenn Input leer ist
 * 
 * @example
 * String name = readNonEmptyInput("Name: ");
 */
private String readNonEmptyInput(String prompt) { ... }
```

**Schritt 2: ARCHITEKTUR.md updaten**

Wenn Änderungen Architektur betreffen:
```markdown
## Refactoring: Input-Validierung zentralisiert

Die Input-Validierungs-Logik wurde in 
readNonEmptyInput() zentralisiert.
DRY-Prinzip: 3 Code-Duplikate entfernt.
```

### Phase 6: Code Review & Merge

```
PR-Titel: "refactor: Input-Validierung zentralisieren"

Feedback-Fokus:
[ ] Funktioniert das Refactoring?
[ ] Tests grün?
[ ] Alte und neue Tests beide OK?
[ ] Keine Branche Changes?
[ ] Dokumentation OK?
```

---

## ✅ Erfolgs-Kriterien

Das Redundanz-Management ist erfolgreich, wenn:

1. ✅ **Duplikate weg:** Code-Duplication sinkt
2. ✅ **Tests grün:** Alle alte + neue Tests pass
3. ✅ **SSOT:** Info ist nur an einer Stelle
4. ✅ **DRY:** Keine offensichtlichen Duplikate mehr
5. ✅ **Lesbar:** Refactorierter Code ist verständlich

---

## 🔍 Redundanz-Typen

### Code-Redundanz (häufig)
```java
❌ Gleicher Code in mehreren Methoden
```
**Lösung:** Methode extrahieren → DRY

### Data-Redundanz (häufig)
```java
❌ Gleiche Konstante an mehreren Stellen
```
**Lösung:** Constants.java → SSOT

### Logic-Redundanz (mittel)
```java
❌ Gleiche Business-Logik in mehreren Klassen
```
**Lösung:** Gemeinsame Base-Class oder Util-Klasse

### Documentation-Redundanz (häufig)
```markdown
❌ Gleiche Info in Index.md und README.md
```
**Lösung:** Ein Dokument + Links → SSOT

### Dependencies-Redundanz (selten)
```xml
❌ Gleiche Library in 2 verschiedenen Versionen
```
**Lösung:** pom.xml zentralisieren

---

## ⚠️ Anti-Patterns

| Problem | Was NICHT tun | Grund |
|---------|---------------|-------|
| Over-Abstraction | Alles in 1 Methode zwingen | Wird unlesbar |
| Falsche Extraktion | Utils für einmalige Logik | Mehr Overhead als Nutzen |
| Breaking Ähnlichkeit | Code außerhalb rauben | Tests brechen |

---

## 📋 Redundanz-Checkliste (für Code Review)

```
Code-Review: DRY & SSOT Check

[ ] Gibt es offensichtliche Code-Duplikate?
[ ] Sind Konstanten zentralisiert?
[ ] Gibt es doppelte Validierungs-Logik?
[ ] Duplicated Tests?
[ ] Dokumentation dupliziert?
[ ] Dependencies mehrfach definiert?

RESULT:
[ ] OK - Kein Redundanz erkannt
[ ] ⚠️ Kleine Redundanzen (hints geben)
[ ] ❌ Große Redundanzen (Change Request)
```

---

## 📚 Ressourcen

- [ARCHITEKTUR.md](../ARCHITEKTUR.md#designprinzipien) – DRY & SSOT Prinzipien
- [Routine aktualisieren](routine-aktualisieren.md) – Refactoring-Workflow
- [Review-Prozess](review-prozess.md) – Code-Review Standards

---

## 🎓 Lernziele

Nach diesem Prozess können Sie:

- ✅ Code-Redundanzen identifizieren
- ✅ DRY & SSOT Prinzipien anwenden
- ✅ Methoden extrahieren
- ✅ Konstanten zentralisieren
- ✅ Refactoring sauber umsetzen
- ✅ Tests bei Refactoring halten

---

**Letzte Aktualisierung:** März 2026

*Fragen? → [README.md](../README.md) oder Mentor*
