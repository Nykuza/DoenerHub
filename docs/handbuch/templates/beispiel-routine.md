# BEISPIEL-ROUTINE: Neue Unit-Test schreiben (JAva mit JUnit 5)

**Titel:** Neue Unit-Test schreiben  
**Zielgruppe:** Alle  
**Dauer:** 15-20 Minuten  
**Häufigkeit:** Pro neues Feature (= Wöchentlich)  
**Version:** 1.0  
**Status:** Active

---

## 🎯 Zweck

Diese Routine beschreibt, wie eine Unit-Test für eine neue Methode geschrieben wird. Ziel: Logik validieren vor Produktivcode und 70%+ Code-Coverage.

---

## 📌 Kontext

Tests sind der schnellste Weg, Code zu validieren:
- ✅ Fehler vor Production finden
- ✅ Refactoring sicherer machen
- ✅ Code-Dokumentation (Beispiele)
- ✅ Regression vermeiden

---

## 📋 Voraussetzungen

- [ ] Java IDE (IntelliJ oder VS Code)
- [ ] JUnit 5 in pom.xml (Maven)
- [ ] Verständnis: Assert-Methoden (assertEquals, assertTrue, etc.)
- [ ] Read: [ARCHITEKTUR.md](../ARCHITEKTUR.md)

---

## 🔄 Schritt-für-Schritt Ablauf

**Total Time: 15-20 Min**

### Schritt 1: Test-Klasse erstellen (⏱️ 2 Min)

**Beschreibung:** Für jede Produktions-Klasse braucht es eine Test-Klasse in `src/test/java/`.

**Für Klasse:** `src/main/java/Orte.java`  
**Erstelle:** `src/test/java/OrteTest.java`

**Aktion:**
```bash
# Im IDE: Right-click auf Orte.java
# → Generate → Test...
# Oder manuell:

# Erstelle File:
src/test/java/OrteTest.java

# Gerüst:
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrteTest {
    // Tests kommen hier hin
}
```

**Result:**
- ✅ Test-Datei existiert
- ✅ IDE zeigt Datei an
- ✅ Blauer Haken in IDE für JUnit Support

---

### Schritt 2: Test-Methode schreiben (⏱️ 8-10 Min)

**Beschreibung:** Für jede Produktions-Methode mindestens 2 Test-Cases:
1. Happy Path (Normale Nutzung)
2. Error Path (Was kann schiefgehen?)

**Beispiel:** Methode addLaden() testen

**Aktion:**

```java
public class OrteTest {
    
    // Setup vor jedem Test
    private Orte orte;
    
    @BeforeEach
    void setUp() {
        orte = new Orte();  // Frische Instanz für jeden Test
    }
    
    // Test 1: Happy Path - Normal hinzufügen
    @Test
    void testAddLaden_WithValidData_Success() {
        // Arrange (Setup)
        Laeden validLaden = new Laeden("Kebab Palace", "Main St 5");
        
        // Act (Ausführen)
        orte.addLaden(validLaden);
        
        // Assert (Validieren)
        assertEquals(1, orte.getCount());        // Größe gestiegen?
        assertTrue(orte.contains(validLaden));   // Laden drin?
    }
    
    // Test 2: Error Path - Null-Handling
    @Test
    void testAddLaden_WithNull_ThrowsException() {
        // Arrange
        Laeden nullLaden = null;
        
        // Act & Assert - Exception wird erwartet
        assertThrows(IllegalArgumentException.class, 
            () -> orte.addLaden(nullLaden));
    }
    
    // Test 3: Edge Case - Duplikate?
    @Test
    void testAddLaden_WithDuplicate_OneOrTwo() {
        // Arrange
        Laeden laden = new Laeden("Pizza", "Street");
        
        // Act - 2× hinzufügen
        orte.addLaden(laden);
        orte.addLaden(laden);
        
        // Assert - Nur 1? Oder 2?
        // Tipp: Entscheide Geschäftsregel
        assertEquals(1, orte.getCount());  // Duplikate nicht erlaubt
    }
}
```

**Assertions erklärt:**

```java
// Ist Wert gleich?
assertEquals(expected, actual);
assertEquals(10, myList.size());

// Ist Boolean true/false?
assertTrue(condition);
assertFalse(condition);

// Ist null?
assertNull(value);
assertNotNull(value);

// Exception wird geworfen?
assertThrows(ExceptionClass.class, () -> { method(); });

// Collections enthalten Element?
assertTrue(list.contains(elm));
```

**Result:**
- ✅ Mindestens 2-3 Test-Methoden
- ✅ Jede Test-Methode testet 1 Sache
- ✅ Klare Arrange-Act-Assert Struktur

---

### Schritt 3: Test ausführen (⏱️ 2 Min)

**Aktion:**
```bash
# Terminal im Projekt-Root:
mvn test

# Oder im IDE:
# RightClick auf OrteTest.java
# → Run Tests
# Oder Grüner Play-Button
```

**Erwartet:**
```
[INFO] Tests run: 3, Failures: 0, Errors: 0

✅ All Green! (3 tests passed)
```

**Falls Rot:**
```
FAILURE: testAddLaden_WithValidData_Success
Expected: 1
Actual: 0

→ Debugging: Ist addLaden() überhaupt implementiert?
```

**Result:**
- ✅ Alle Tests grün
- ✅ Code compileiert
- ✅ Keine Fehler in Test-Logik

---

### Schritt 4: Coverage prüfen (⏱️ 2-3 Min)

**Beschreibung:** Wieviel Code wird von Tests ausgeführt?

**Aktion:**
```bash
# Coverage-Report generieren
mvn jacoco:report

# Dann siehe:
target/site/jacoco/index.html
# (Im Browser öffnen: Datei → Open...)
```

**Zielwert:** ≥ 70% für Neue Methoden

**Good Coverage:**
```
Orte.java:
├── addLaden()      ✅ 100% (alle Pfade getestet)
├── removeLaden()   ✅ 100%
├── getCount()      ✅ 100%
└── Overall         ✅ 92%
```

**Bad Coverage:**
```
Orte.java:
├── addLaden()      ⚠️ 50%  (Error-Path nicht getestet)
└── Overall         ⚠️ 45%
```

**Falls zu niedrig:**
- Schreib weitere Test-Cases
- Test Error Paths, Edge Cases
- Fokus auf kritische Logik

**Result:**
- ✅ Coverage ≥ 70%
- ✅ Alle wichtigen Pfade getestet

---

### Schritt 5: Code-Review (⏱️ 3-5 Min)

**Beschreibung:** Jede Test-Datei muss reviewed werden (wie Produktions-Code).

**Mach einen Commit & erstelle PR:**
```bash
git add src/test/java/OrteTest.java
git commit -m "test: Add unit tests for Orte.addLaden()"
git push origin feature/test-orte
# Erstelle PR auf GitHub
```

**Review-Fragen an Reviewer:**
```markdown
## 🧪 Test-Review Fragen:

- [ ] Sind alle Code-Wege getestet?
- [ ] Positive + Negative Tests da?
- [ ] Test-Namen sind aussagekräftig?
- [ ] Keine Copy-Paste in Tests?
- [ ] Coverage OK?
```

**Result:**
- ✅ PR approved
- ✅ Keine Review-Kommentare
- ✅ Merged in main

---

## ✅ Erfolgs-Kriterien

Diese Routine ist erfolgreich, wenn:

- [ ] 2-3 Test-Cases pro Methode
- [ ] Happy Path + Error Path getestet
- [ ] Alle Tests grün ✅
- [ ] Coverage ≥ 70%
- [ ] Code Review passed
- [ ] Tests in main gemergt

---

## ❌ Häufige Fehler & Lösungen

| Fehler | Ursache | Lösung |
|--------|--------|--------|
| **Test wird nicht grün** | Methode nicht implementiert | Zuerst Produktions-Code schreiben (oder TDD!) |
| **NullPointerException in Test** | Forget setUp() / Initialization | `@BeforeEach void setUp()` verwenden |
| **Coverage nur 20%** | Zu wenige Test-Cases | Schreib auch Error-Paths und Edge-Cases |
| **Test flaky (manchmal fail)** | Non-deterministic Logic | Verwendee feste Test-Daten, keine Random-Werte |
| **Copy-Paste Tests** | Zu wenig Refactoring | Extrahiere Helper-Methoden |

---

## 🔗 Abhängigkeiten

- [ARCHITEKTUR.md](../ARCHITEKTUR.md) – Verständnis von MVC
- [Redundanz-Management](../prozesse/redundanz-management.md) – Duplikate vermeiden
- [Review-Prozess](../prozesse/review-prozess.md) – Test-Code Review

---

## 📸 Beispiel Java-Test (vollständig)

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadenTest {
    
    private Laeden laden;
    
    @BeforeEach
    void setUp() {
        laden = new Laeden("Döner Palace", "Main Str 5");
    }
    
    // Happy Path Test
    @Test
    void testConstructor_ValidData() {
        assertEquals("Döner Palace", laden.getName());
        assertEquals("Main Str 5", laden.getAdresse());
    }
    
    // Error Test: Leerer Name
    @Test
    void testConstructor_EmptyName_Throws() {
        assertThrows(IllegalArgumentException.class,
            () -> new Laeden("", "Adresse"));
    }
    
    // Setter Test
    @Test
    void testSetName() {
        laden.setName("New Name");
        assertEquals("New Name", laden.getName());
    }
    
    // toString Test
    @Test
    void testToString_Format() {
        String str = laden.toString();
        assertTrue(str.contains("Döner Palace"));
        assertTrue(str.contains("Main Str 5"));
    }
}
```

---

## 👥 Rollen

| Rolle | Aufgabe |
|-------|---------|
| **Entwickler** | Schreibt Test + Produktions-Code |
| **Reviewer** | Validiert Test-Qualität & Coverage |
| **Mentor** | Hilft bei Test-Design Fragen |

---

## ⏱️ Zeitbudget

| Schritt | Zeit |
|---------|------|
| 1. Test-Klasse erstellen | 2 Min |
| 2. Test-Methoden schreiben | 8-10 Min |
| 3. Test ausführen | 2 Min |
| 4. Coverage prüfen | 2-3 Min |
| 5. Code Review | 3-5 Min |
| **TOTAL** | **15-20 Min** |

---

## 🎓 Was ich gelernt habe

Nach dieser Routine verstehe ich:

- ✅ Struktur von Unit Tests (Arrange-Act-Assert)
- ✅ Test-Naming Konventionen
- ✅ Positive + Negative Test-Cases
- ✅ Exception Testing mit assertThrows()
- ✅ Code Coverage Messung
- ✅ Test-Isolation mit @BeforeEach

---

## ❓ FAQ

**F: TDD oder normale Tests?**  
A: Beide sind OK. TDD (Test First) macht Sie effizienter. Normale (Code First) ist leichter zum Starten.

**F: Wie viele Test-Cases sind genug?**  
A: Pro Methode: 2-3 minimum (Happy + Error + Edge-Case). Ziel: 70-90% Coverage.

**F: Muss ich jeden Parameter testen?**  
A: Nein. Fokus auf kritische Logik. Parameter-Validierung = kritisch. Getter = weniger kritisch.

**F: Können Tests zu detailliert sein?**  
A: Ja! Beispiel: `testGetName_ReturnsNameIfSet()` bei einfachem Getter ist overkill.

---

## 📞 Support

- **Test schreiben?** → Buddy/Mentor
- **JUnit Syntax?** → [JUnit Docs](https://junit.org/junit5/docs/current/user-guide/)
- **Coverage-Tool Fragen?** → [JaCoCo Docs](https://www.jacoco.org/)

---

**Letzte Aktualisierung:** März 2026

*Siehe auch: [ROUTINE-TEMPLATE.md](ROUTINE-TEMPLATE.md) für Vorlage, [Review-Prozess](../prozesse/review-prozess.md) für Test-Review*
