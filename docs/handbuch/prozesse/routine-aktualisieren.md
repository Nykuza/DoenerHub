# Prozess: Routine aktualisieren

**Zielgruppe:** Alle Entwickler  
**Dauer:** 30-60 Minuten  
**Häufigkeit:** Mehrmals pro Woche

---

## 🎯 Zweck

Dieser Prozess beschreibt, wie eine bestehende Funktionalität oder Komponente sicher aktualisiert, erweitert oder refaktoriert wird.

**Szenarien:**
- Eine Methode erweitern (neue Parameter)
- Eine Klasse umbenennen
- Code refaktorieren (DRY, SSOT)
- Feature hinzufügen
- Fehler beheben

---

## 📋 Schritt-für-Schritt Ablauf

### Phase 1: Planung (5-10 Min)

**Schritt 1: Änderung definieren**
- [ ] **Was** ändert sich? (Titel)
- [ ] **Warum** ändert es sich? (Kontext)
- [ ] **Wo** ändert es sich? (File/Klasse/Methode)

**Schritt 2: Impact-Analyse**
```
Fragen:
- Welche anderen Dateien sind betroffen?
- Welche Tests müssen aktualisiert werden?
- Welche Dokumentation ändert sich?
- Gibt es Breaking Changes?
```

**Schritt 3: Review vorbesprechen**
- [ ] Mit Mentor/Senior Developer kurz absprechen
- [ ] Akzeptanzkriterien klären
- [ ] Review-Zeitrahmen absprechen

### Phase 2: Vorbereitung (5 Min)

**Schritt 1: Branch erstellen**
```bash
git checkout main
git pull origin main
git checkout -b feature/routine-update-xyz
```

**Naming-Konvention:**
- `feature/<kurzbeschreibung>` – Neue Features
- `fix/<kurzbeschreibung>` – Fehlerbehebungen
- `refactor/<kurzbeschreibung>` – Code-Verbesserungen
- `docs/<kurzbeschreibung>` – Doku-Updates

**Schritt 2: Backup / Test-Plan**
- [ ] Mache ein lokales Backup
- [ ] Schreibe Testplan (was zu prüfen?)
- [ ] Notiere alte Verhalten

### Phase 3: Implementierung (30-45 Min)

**Schritt 1: Code schreiben**

```java
// Beispiel: Methode erweitern
// ALT:
public void addLaden(Laeden laden) { }

// NEU:
public void addLaden(Laeden laden) throws IllegalArgumentException {
    if (laden == null) {
        throw new IllegalArgumentException("Laden darf nicht null sein");
    }
    // Rest der Logik
}
```

**Best Practices:**
- ✅ Kleine, logische Commits
- ✅ DRY-Prinzip anwenden
- ✅ SSOT respektieren
- ✅ Aussagekräftige Variablennamen
- ✅ Kommentare für das „Warum"

**Schritt 2: Tests schreiben / aktualisieren**

```java
// Test für neue Exception
@Test
void testAddLadenWithNull() {
    assertThrows(IllegalArgumentException.class, 
        () -> orte.addLaden(null));
}

// Test für alte Funktionalität (Regression!)
@Test
void testAddLadenWithValidData() {
    Laeden l = new Laeden("Test");
    orte.addLaden(l);
    assertTrue(orte.contains(l));
}
```

**Schritt 3: Lokal testen**
```bash
# Kompilieren
mvn clean compile

# Tests laufen
mvn test

# Code-Analyse
mvn sonar:sonar  # falls konfiguriert
```

### Phase 4: Dokumentation (5-10 Min)

**Schritt 1: Code-Kommentare**
```java
/**
 * Fügt einen neuen Laden hinzu.
 * @param laden Der hinzuzufügende Laden (darf nicht null sein)
 * @throws IllegalArgumentException wenn laden null ist
 */
public void addLaden(Laeden laden) { }
```

**Schritt 2: Changelog / Commit-Message**
```
# Gutes Format:
Type: Brief description

Longer description explaining the change.

Fixes: #123 (wenn Issue-Tracking)
```

**Beispiel:**
```
refactor: Methode readInput zentral aufbauen

- Zusammenfassung der Input-Validierung in readAndValidateInput()
- Reduziert Code-Duplikate in Main.java
- Fehlermeldungen konsistent
- Tests für new Methode

Fixes: #45
```

**Schritt 3: Handbuch aktualisieren**
- [ ] ARCHITEKTUR.md anpassen?
- [ ] README.md aktualisieren?
- [ ] Prozess ändern?

### Phase 5: Code Review (20-30 Min)

**Vorbereitung:**
```bash
git add .
git commit -m "<message>"
git push origin feature/...
# Erstelle Pull Request auf GitHub/GitLab
```

**PR-Template ausfüllen:**
```markdown
## 📝 Beschreibung
Was ändert sich und warum?

## 🎯 Akzeptanzkriterien
- [ ] Test 1 passed
- [ ] Test 2 passed

## 📸 Screenshots (falls UI)
[Screenshot hier]

## 🔗 Abhängigkeiten
Andere PRs, Dependencies?

## ✅ Checkliste
- [ ] Lokale Tests passed
- [ ] Keine Warnungen
- [ ] Dokumentation aktualisiert
```

**Review-Feedback:**
- [ ] Feedback einholen (24h Max)
- [ ] Feedback umsetzen
- [ ] Nachkommit pushen
- [ ] Nochmal reviewen lassen

### Phase 6: Merging (5 Min)

**Schritt 1: Merge vorbereiten**
```bash
# Stelle sicher, dass main aktuell ist
git checkout main
git pull origin main

# Rebase your Branch (optional, aber clean)
git rebase origin/main
git push
```

**Schritt 2: Merge durchführen**
```bash
# Via GitHub UI oder:
git merge --squash feature/...
# oder
git rebase feature/... main
```

**Merge-Optionen:**
- **Squash:** Alle Commits zu 1 zusammenfassen (für kleine Changes)
- **Rebase:** Geschichte linear halten (saubere Commits)
- **Merge Commit:** Alle Commits behalten (für große Features)

**Schritt 3: Aufräumen**
```bash
git push origin --delete feature/...
git branch -D feature/...
```

---

## ✅ Erfolgs-Kriterien

Die Routine ist erfolgreich, wenn:

1. ✅ **Funktional:** Features/Fixes funktionieren wie spezifiziert
2. ✅ **Getestet:** Tests (alt + neu) passen zu 100%
3. ✅ **Sauber:** Code folgt Style-Guide & DRY-Prinzip
4. ✅ **Reviewed:** Mind. 1-2 Personen haben approved
5. ✅ **Dokumentiert:** Doku ist aktuell
6. ✅ **Merged:** Code ist in `main`

---

## ❌ Häufige Fehler & Lösungen

| Fehler | Grund | Lösung |
|--------|-------|--------|
| Tests falsch | Nur positive Tests | Auch Fehler-Fälle testen |
| Konflikte beim Merge | Branch zu alt | Häufiger rebasen |
| Review Feedback ignored | Zu ungeduldig | Alle Anmerkungen addressieren |
| Doku vergessen | zu schnell merged | Doku-Check in Checkliste |
| Breaking Changes | Nicht dokumentiert | Changelog, Migrations-Guide |

---

## 🔗 Abhängigkeiten

- [Review-Prozess.md](review-prozess.md) – Für Code Review
- [ARCHITEKTUR.md](../ARCHITEKTUR.md) – Design-Kontext
- [Redundanz-Management.md](redundanz-management.md) – DRY Check

---

## 👥 Rollen

| Rolle | Aufgabe |
|-------|---------|
| **Entwickler** | Implementiert Änderung |
| **Reviewer(s)** | Prüft Code, Tests, Doku |
| **Merger** | Führt finalen Merge durch |

---

## ⏱️ Zeitbudget

| Phase | Zeit |
|-------|------|
| Planung | 5-10 Min |
| Vorbereitung | 5 Min |
| Implementierung | 30-45 Min |
| Dokumentation | 5-10 Min |
| Code Review | 20-30 Min |
| Merging | 5 Min |
| **TOTAL** | **1,5-2 Stunden** |

---

## 📎 Git Cheat-Sheet für diesen Prozess

```bash
# Neuen Branch starten
git checkout -b feature/meine-aenderung

# Lokal testen & commiten
git add <files>
git commit -m "message"

# Mehrmals committen (granular)
git add <file1>
git commit -m "Part 1"
git add <file2>
git commit -m "Part 2"

# Push zum Remote
git push origin feature/meine-aenderung

# Pull Request erstellen & reviewen lassen

# Nach Feedback: Neue Commits
git add <files>
git commit -m "Feedback: xyz"
git push origin feature/meine-aenderung

# PR approved? Merge durchführen
git checkout main
git pull
git merge --squash feature/meine-aenderung
git commit
git push

# Branch löschen
git branch -D feature/meine-aenderung
git push origin --delete feature/meine-aenderung
```

---

**Letzte Aktualisierung:** März 2026

*Fragen? → [Review-Prozess.md](review-prozess.md) oder Mentor*
