# Prozess: Neue Routine erstellen

**Zielgruppe:** Fortgeschrittene Entwickler, Mentoren  
**Dauer:** 1-2 Stunden  
**Häufigkeit:** Gelegentlich (wenn neuer Standard-Ablauf nötig)

---

## 🎯 Zweck

Dieser Prozess beschreibt, wie neue Routinen (Standard-Abläufe für häufig wiederkehrende Aufgaben) dokumentiert und in das System integriert werden.

**Beispiele für Routinen:**
- Neue Klasse schreiben (Template)
- Feature Code Review durchführen
- Fehler debuggen
- Test-Suite erweitern

---

## 📋 Schritt-für-Schritt Ablauf

### Phase 1: Identifikation (15 Min)

**Frage:** Welche Aufgabe wird wiederholt?
- [ ] Aufgabe ist mindestens 2× vorgekommen
- [ ] Aufgabe dauert > 10 Minuten
- [ ] Aufgabe könnte standardisiert werden

**Ergebnis:**
- [ ] Aufgabe ist klar definiert
- [ ] Vorteile der Routine sind identifiziert
- [ ] Zielgruppe ist bekannt

### Phase 2: Analyse (20 Min)

**Schritt 1: Current State dokumentieren**
```
Aktuelle Schritte (zu Papier oder Digital):
1. [Schritt 1]
2. [Schritt 2]
...
```

**Schritt 2: Variationen & Edge Cases**
- Wo unterscheiden sich die Durchführungen?
- Welche Fehler passieren häufig?
- Welche Entscheidungspunkte gibt es?

**Schritt 3: Best Practice identifizieren**
- Welcher Weg ist am saubersten?
- Welche Werkzeuge helfen?
- Wer sind erfolgreiche Vorbilder?

### Phase 3: Template erstellen (30 Min)

**Nutze die Vorlage:** [ROUTINE-TEMPLATE.md](../templates/ROUTINE-TEMPLATE.md)

Ausfüllen:
- [ ] Titel & Zweck
- [ ] Schritt-für-Schritt (mit Screenshots/Code-Beispielen)
- [ ] Häufige Fehler & Lösungen
- [ ] Abhängigkeiten & Voraussetzungen
- [ ] Erfolgs-Kriterien
- [ ] Zeitbudget
- [ ] Rollen & Verantwortung

### Phase 4: Review (20 Min)

**Review-Checkliste:**
- [ ] Sprache konsistent & verständlich?
- [ ] Alle Schritte nachvollziehbar?
- [ ] Code-Beispiele konkret & korrekt?
- [ ] Links funktional?
- [ ] Fehlerbehandlung beschrieben?

**Reviewer:** Mindestens 1-2 andere Person

### Phase 5: Integration (10 Min)

**Ablage:**
1. Datei in richter Ordner speichern:
   - `routinen/kurzfristig/` (< 2 Tage)
   - `routinen/mittelfristig/` (2-7 Tage)
   - `routinen/langfristig/` (> 1 Woche)

2. In [INDEX.md](../INDEX.md) verlinken
3. Ggf. in README.md referenzieren

4. Git-Commit:
   ```bash
   git add docs/handbuch/
   git commit -m "docs: Neue Routine 'XYZ' hinzugefügt"
   ```

### Phase 6: Kommunikation (5 Min)

- [ ] Team benachrichtigen (Slack, E-Mail)
- [ ] In Review-Session erwähnen
- [ ] Link in Doku-Index pinnen
- [ ] Optional: Kurzes Erklärvideo

---

## ✅ Erfolgs-Kriterien

Die neue Routine ist erfolgreich, wenn:

1. ✅ **Verständlichkeit:** Jeder kann sie ohne Fragen folgen
2. ✅ **Verwendbarkeit:** Sie wird von > 70% des Teams genutzt
3. ✅ **Wartbarkeit:** Sie wird mitgeführt bei Architektur-Änderungen
4. ✅ **Effizienz:** Sie spart Zeit (messbar)
5. ✅ **Konsistenz:** Sie führt zu konsistenten Ergebnissen

---

## ❌ Häufige Fehler

| Fehler | Grund | Lösung |
|--------|-------|--------|
| Routine zu kurz | Wichtige Details fehlen | Mit jemandem durchspielen, der es nicht kennt |
| Routine zu lang | Zu viel unnötige Info | Nur essenzielle Schritte, Links für Details |
| Keine Bilder/Beispiele | Zu abstrakt | Screenshots, Code-Beispiele hinzufügen |
| Veraltete Links | Keine Wartung | Regelmäßig prüfen, in Index pflegen |
| Zu technisch geschrieben | Zielgruppe zu fortgeschritten | Glossar, einfache Erklärungen |

---

## 🔗 Abhängigkeiten

- [ROUTINE-TEMPLATE.md](../templates/ROUTINE-TEMPLATE.md) – Vorlage
- [INDEX.md](../INDEX.md) – Registrierung
- [Review-Prozess.md](review-prozess.md) – Für Review der Routine

---

## 👥 Rollen & Verantwortung

| Rolle | Aufgabe |
|-------|---------|
| **Initiator** | Identifiziert Routine-Bedarf, schreibt Draft |
| **Autor** | Umsetzt volle Routine-Dokumentation |
| **Reviewer** | Prüft auf Klarheit, Richtigkeit, Vollständigkeit |
| **Integrateur** | Verlinkt in Doku, committed zu Git |

---

## ⏱️ Zeitbudget

| Phase | Zeit |
|-------|------|
| 1. Identifikation | 15 Min |
| 2. Analyse | 20 Min |
| 3. Template | 30 Min |
| 4. Review | 20 Min |
| 5. Integration | 10 Min |
| 6. Kommunikation | 5 Min |
| **TOTAL** | **1,5-2 Stunden** |

---

## 📎 Anhang: Review-Checkliste

```markdown
## Review-Checkliste für neue Routine

- [ ] Titel ist prägnant & verständlich
- [ ] Zweck ist klar & motivierend geschrieben
- [ ] Schritt-für-Schritt ist nachvollziehbar
- [ ] Alle verwendeten Tools/Konzepte sind erklärt
- [ ] Code-Beispiele sind konkret & getestet
- [ ] Häufige Fehler sind dokumentiert
- [ ] Abhängigkeiten sind aufgelistet
- [ ] Rollen sind klar zugewiesen
- [ ] Erfolgs-Kriterien sind messbar
- [ ] Links sind funktional
- [ ] Grammatik & Rechtschreibung OK
- [ ] Konsistenzprüfung mit anderen Routinen

Freigegeben: [Name, Datum]
```

---

**Letzte Aktualisierung:** März 2026

*Fragen? → [README.md](../README.md) oder [Projektleitung](mailto:info@project.local)*
