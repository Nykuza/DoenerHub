# Prozess: Code Review

**Zielgruppe:** Alle Entwickler  
**Dauer:** 15-30 Minuten pro Review  
**Häufigkeit:** Bei jedem Pull Request

---

## 🎯 Zweck

Code Review ist das zentrale Werkzeug für Qualitätskontrolle, Wissenstransfer und gegenseitiges Lernen. Jede Änderung muss reviewt werden, bevor sie in `main` merged wird.

**Vorteile:**
- ✅ Bugs früh finden
- ✅ Design-Probleme vermeiden
- ✅ Best Practices verbreiten
- ✅ Wissentransfer im Team
- ✅ Konsistenter Code-Stil

---

## 📋 Rollen & Verantwortung

### Autor (Code Submitter)
**Aufgaben:**
1. Pull Request mit klarer Beschreibung erstellen
2. Context geben (Was, Warum, Wie)
3. Selbst reviewen vor Submission
4. Feedback einarbeiten
5. Final-OK von Reviewer einholen

**Don'ts:**
- ❌ Großes PR einreichen (> 400 LOC)
- ❌ PR ohne Beschreibung
- ❌ Reviewer drängen (24h Norm ist OK)
- ❌ Feedback ignorieren

### Reviewer(s)
**Aufgaben:**
1. PR innerhalb 24h anschauen
2. Code, Tests, Doku prüfen
3. Konstruktives Feedback geben
4. Fragen stellen bei Unklarheit
5. Approve oder Request Changes

**Don'ts:**
- ❌ Mikromanagement-Feedback
- ❌ „Das hättest du anders machen sollen"
- ❌ Persönliche Kritik
- ❌ Nur oberflächlich prüfen

---

## 📋 Schritt-für-Schritt Ablauf (Autor)

### 1. Self-Review (10-15 Min)

**Vor dem PR:**

```bash
# Diffs anschauen
git diff main...HEAD

# Code reviewen
# Fragen:
# - Folgt Code dem Style-Guide?
# - Gibt es Duplikate?
# - Sind alle Tests grün?
# - Ist Dokumentation aktuell?
```

**Checklist:**
- [ ] Tests: `mvn test` ✅ (100%)
- [ ] Code-Stil: Keine Warnungen
- [ ] DRY: Keine offensichtlichen Duplikate
- [ ] Dokumentation: Aktuell & vollständig
- [ ] Commit-Messages: Aussagekräftig
- [ ] Keine Debug-Ausgaben
- [ ] Keine commented-out Code-Blöcke

### 2. PR Erstellen

**Auf GitHub/GitLab:**

**Titel:** Prägnant, max 50 Zeichen
- ✅ `refactor: addLaden Methode vereinfachen`
- ✅ `fix: NullPointer bei leerer Liste`
- ❌ `Update code`
- ❌ `Aenderungen`

**Beschreibung (Template):**

```markdown
## 📝 Beschreibung
Kurze Zusammenfassung (1-2 Sätze).

Die alte addLaden-Methode war kompliziert. 
Diese PR vereinfacht sie mit einem Stream-basierten Ansatz.

## 🎯 Akzeptanzkriterien
- [ ] Tests für addLaden passed (3/3)
- [ ] Performance ~10% besser
- [ ] Keine Breaking Changes

## 📊 Größe der Änderung
- Files: 2 (Orte.java, OrteTest.java)
- Lines: +15, -20

## 📸 Screenshots / Beispiele
N/A

## 🔗 Abhängigkeiten
Keine anderen PRs nötig.

## 🐛 Bekannte Probleme / TODOs
N/A
```

### 3. Reviewer assignen

```
Reviewer: @mentor oder @senior-developer
```

**Regeln:**
- Min. 1 Reviewer
- < 400 LOC: 1 OK
- > 400 LOC: 2 Reviewer empfohlen
- ARCHITEKTUR-Änderungen: Lead reviewer nötig

### 4. Review-Feedback verarbeiten

**PR-Comment vom Reviewer:**
```
@Autor: Die Methode performant genug?

// Code
orte.addLaden(laden);
```

**Arten von Feedback:**

| Typ | Behandlung |
|-----|-----------|
| **Suggestion** | Kann befolgt werden, muss aber nicht |
| **Comment** | Info/Diskussion nötig |
| **Change Request** | MUSS adressiert werden |
| **Approved** | Grünes Licht zum Merge |

**Vorgehen:**
1. Feedback verstehen (nachfragen if unklar)
2. Code anpassen
3. Commit: `git commit -m "Feedback: xyz"`
4. Push: `git push origin feature/...`
5. Reviewer nochmal um Review bitten

### 5. Merge

```bash
# Nach Approval von Reviewer
git checkout main
git pull
git merge feature/... # oder Squash, oder Rebase
git push
```

---

## 📋 Schritt-für-Schritt Ablauf (Reviewer)

### 1. PR anschauen (2-5 Min)

**Fragen:**
- [ ] PR-Beschreibung verständlich?
- [ ] Titel passt zum Code?
- [ ] Größe ist angemessen (< 400 LOC)?

**Falls Problem:**
- "Bitte PR-Beschreibung vereinfachen"
- "PR ist zu groß, bitte splitten"

### 2. Code-Review (10-20 Min)

**Checkliste pro File:**

```
[ ] Funktioniert der Code logisch?
[ ] Tests sind vorhanden & grün?
[ ] Fehlerbehandlung vorhanden?
[ ] DRY-Prinzip beachtet?
[ ] SSOT-Prinzip beachtet?
[ ] Variablennamen aussagekräftig?
[ ] Keine commented-out Code-Teile?
[ ] Keine Debug-Ausgaben?
[ ] Performance OK?
[ ] Security-Probleme?
[ ] Dokumentation aktuell?
```

### 3. Tests prüfen

```
Checkliste:
[ ] Unit Tests für neue Funktionalität? 
[ ] Auch negative Tests (Fehler-Fälle)?
[ ] Alte Tests noch grün (Regression)?
[ ] Test-Coverage ausreichend?
[ ] Edge Cases getestet? (null, empty, negative)
```

### 4. Dokumentation prüfen

```
[ ] Code-Kommentare präsent?
[ ] JavaDoc/Dokumentation aktuell?
[ ] ARCHITEKTUR.md ggf. aktualisiert?
[ ] README.md erwähnt neue Features?
[ ] Handbuch-Seiten aktuall?
```

### 5. Feedback geben

**Feedback-Kategorien:**

```markdown
### 🟢 Approved
Sieht gut aus! Merge wenn ready.

---

### 🟡 Comment
Interessant, dass du hier XYZ machst. 
Warum nicht ABC?
(Keine blockierend)

---

### 🔴 Change Request
Die Exception-Handling sollte consistent mit 
anderen Methoden sein. Siehe Zeile 45.

---

### 💡 Suggestion
Tipp: `stream()` könnte `parallelStream()` sein.
(Optional verbessern)
```

**Dos & Don'ts:**

✅ **DO:**
- Konstruktiv & höflich
- Konkrete Beispiele geben
- „Warum" erklären
- Loben was gut ist
- Fragen stellen statt Befehle

❌ **DON'T:**
- Mikromanaging
- Persönliche Kritik
- Sarkasmus / Aggression
- „Das geht anders" ohne Kontext
- Zu viel auf einmal

### 6. Decision treffen

Nach Diskussion:

- **Approve:** ✅ Merge kann stattfinden
- **Request Changes:** 🔴 Autor muss ändern
- **Comment:** 💬 Info, blockiert nicht

---

## ✅ Erfolgs-Kriterien für Review

Das Review ist erfolgreich, wenn:

1. ✅ **Code funktioniert** – Tests grün, Logik OK
2. ✅ **Qualität stimmt** – DRY, SSOT, Stil
3. ✅ **Tests da** – Unit & Integration Tests
4. ✅ **Doku aktuell** – Code-Docs & Handbuch
5. ✅ **Feedback konstruktiv** – Clear & Actionable

---

## 📊 Review-SLA (Service Level Agreement)

| Größe PR | Reviewer-Response | Total Time |
|----------|-------------------|-----------|
| < 100 LOC | 8 Stunden | < 24 Stunden |
| 100-300 LOC | 12 Stunden | 24-48 Stunden |
| > 300 LOC | 24 Stunden | 48+ Stunden |

**Blockierte PRs:**
- Maximal 48h blockiert
- Eskalation an Lead wenn länger

---

## 🎓 Review-Kultur Prinzipien

1. **Psychologically Safe:** Feedback ist für den Code, nicht die Person
2. **Learning Mindset:** Jeder Review ist Gelegenheit zum Lernen
3. **Ownership:** Reviewer teilt Verantwortung für Code-Qualität
4. **Respekt:** Unterschiedliche Lösungen werden akzeptiert (nicht „deine" vs „meine")

---

## ❌ Anti-Patterns (Was nicht OK ist)

| Problem | Symptom | Lösung |
|---------|---------|--------|
| **Zu kritisch** | Jede Zeile kommentiert | Nur blockierende Punkte |
| **Zu oberflächlich** | "Looks good" ohne Review | Mindestens 3 Punkte prüfen |
| **Blockade** | PR wartet > 48h | SLA einhalten |
| **Persönlich** | "Du hättest..." statt "Das könnte..." | Neutral bleiben |

---

## 📋 Review Checklist (zum Ausdrucken)

```
PR #: ___  Titel: ____________________

[ ] Code-Stil OK
[ ] Tests grün
[ ] Tests vollständig?
[ ] Doku aktuell?
[ ] DRY-Prinzip OK?
[ ] Keine Debug-Code?
[ ] Exception-Handling OK?
[ ] Logik sauber?
[ ] Performance-regressionen?
[ ] Breaking Changes dokumentiert?

RESULT:
[ ] Approved
[ ] Change Required
[ ] Comment

Reviewer: ____________  Datum: _______
```

---

**Letzte Aktualisierung:** März 2026

*Fragen? → [README.md](../README.md) oder Mentor*
