# PFLICHTENHEFT: DoenerHub Projekt

**Version:** 1.0  
**Status:** Aktiv  
**Letzte Aktualisierung:** März 2026

---

## 📌 Zusammenfassung

**DoenerHub** ist eine educative Softwareentwicklungs-Projektvorlage, mit der Schüler Best Practices in Architektur (MVC), Codequalität (DRY, SSOT) und Teamarbeit (Code Review, Prozesse) lernen. Das Projekt dient als **Starter-Kit** für Schülerprojekte und demonstriert professionelle Entwicklungspraktiken.

---

## 🎯 Ziele (What & Why)

### Primäre Ziele
1. **Softwaredesign lehren**
   - Model-View-Controller Architektur praktisch umsetzen
   - Designprinzipien (DRY, SSOT, SRP) verstehen

2. **Professionelle Prozesse etablieren**
   - Code Review & Feedback-Kultur
   - Redundanzmanagement und Refactoring
   - Dokumentation & Wissenstransfer

3. **Schülern einen Head-Start geben**
   - Strukturierte Projektvorlage
   - Bewährte Prozesse
   - Klare Dokumentation

### Sekundäre Ziele
- Codequalität und Lesbarkeit trainieren
- Git Workflow und PR-Handling üben
- Teamfähigkeit entwickeln
- Test-Driven Development (optional)

---

## 🔷 Scope (Was ist INBEGRIFFEN)

### Funktional
- ✅ Verwaltung von Läden (Döner-Läden)
- ✅ Verwaltung von Speisen (Menu-Items)
- ✅ Verwaltung von Getränken (Getränke-Katalog)
- ✅ Basis-Menü-System (Konsolen-basiert)
- ✅ Einfache Persistierung (optional: Dateien/JSON)

### Non-Funktional
- ✅ Klare Architektur (MVC)
- ✅ Vollständige Dokumentation auf Deutsch
- ✅ Prozess-Templates (Review, Routinen, Redundanz)
- ✅ Learning-Paths (Anfänger, Fortgeschritten, Experte)
- ✅ Code-Quality Standards

### Umfang je Phase
| Phase | Dauer | Umfang |
|-------|-------|--------|
| Phase 1: Basis | 2-3 Wochen | Grundlegende CRUD-Operationen |
| Phase 2: Erweitert | 1 Monat | Persistierung, Filterung, Sortierung |
| Phase 3: Professionell | 1-2 Monate | DB, API, Web-Frontend |

---

## ❌ Nicht-Ziele (Was ist NICHT INBEGRIFFEN)

- ❌ Produktive Döner-Läden-Software (ist Template, nicht Endprodukt)
- ❌ Enterprise-Scale (für Schule dimensioniert)
- ❌ Multi-User / Multi-Tenant (Einfaches Single-User-System)
- ❌ Sicherheit (Encryption, Auth – nicht im Scope)
- ❌ Mobile-App (nur Web/Konsole)
- ❌ Machine Learning (reine Business-Logik)

---

## 👥 Stakeholder

### Primär
- **Schüler** – Lernen, Entwickeln, Umsetzen
- **Lehrende** – Anleitung, Evaluation, Feedback

### Sekundär
- **Projektmanagement** – Zeittracks, Milestones
- **Peer-Reviewer** – Code Quality Checks

### Extern
- **Git-Repository-Host** (GitHub, GitLab)
- **Dokumentations-Viewer** (Markdown-Renderer)

---

## ⚠️ Risiken

### 1. Zu hohe Komplexität (Kritisch)
**Problem:** Schüler verstehen die Architektur nicht  
**Lösung:** Learning-Paths, Mentoring, schrittweise Komplexität  
**Überwachung:** Wöchentliche 1:1 Check-ins

### 2. Doku-Verwahrlosung (Hoch)
**Problem:** Dokumentation wird nicht aktuell gehalten  
**Lösung:** Review-Prozess für Doku-Änderungen, Template-Vorlagen  
**Überwachung:** Doku-Quality im Code Review

### 3. Code-Duplikate (Mittel)
**Problem:** Schüler kopieren Code statt zu refaktorieren  
**Lösung:** Redundanz-Management Prozess, Pairing-Sessions  
**Überwachung:** DRY-Check im Review

### 4. Prozess-Überload (Mittel)
**Problem:** Zu viele Regeln → Schüler halten sich nicht dran  
**Lösung:** Schrittweise Einführung (Woche 1: Basics, Woche 3: Advanced)  
**Überwachung:** Einhaltungs-Rate im Tracking

---

## 📊 Qualitätskriterien

### Code-Qualität
| Kriterium | Standard | Messung |
|-----------|----------|---------|
| Test-Coverage | ≥ 70% | JUnit/Code Coverage Reports |
| Lesbarkeit | ≤ 2 Code Review Anmerkungen | Per PR |
| Duplizierung | < 5% DRY-Violations | Code Duplication Analysis |
| Fehlerign | 0 kritische Fehler | Statische Code-Analyse |

### Dokumentation
| Kriterium | Standard | Messung |
|-----------|----------|---------|
| Vollständigkeit | Alle Dateien dokumentiert | Doku-Checklist |
| Aktualität | Updates mit Code-Änderungen | Last-Modified-Dates |
| Verständlichkeit | Verständlich für Jahr 10-13 Schüler | Lesbarkeitsprüfung |
| Links | Alle Links funktional | Link-Checker |

### Prozesse
| Kriterium | Standard | Messung |
|-----------|----------|---------|
| Review-Rate | 100% PRs reviewed | GitHub Analytics |
| Review-Time | < 24h | Timestamp-Check |
| Prozess-Einhaltung | > 90% Compliance | Audit-Log |

### Architektur
| Kriterium | Standard | Messung |
|-----------|----------|---------|
| MVC-Separation | Stricte Layering | Architecture Review |
| Abhängigkeits-Zirkeln | 0 | Dependency Analysis |
| Modularität | Klassen ≤ 300 LOC | Code Metrics |

---

## 📅 Meilensteine (Ausblick)

| # | Milestone | Ziel | Dauer |
|---|-----------|------|-------|
| 1 | Setup & Basis-Architektur | MVC-Struktur, erste Klassen | Woche 1 |
| 2 | Feature-Development | CRUD-Operationen, Menü | Wochen 2-3 |
| 3 | Quality Assurance | Testing, Code Review, Doku | Woche 4 |
| 4 | Optimierung & Extensions | Performance, neue Features | Wochen 5-6 |
| 5 | Abschluss & Präsentation | Demo, Dokumentation, Reflexion | Woche 7-8 |

---

## 🎓 Success Criteria

### Für Schüler
- ✅ Verstehen MVC-Architektur
- ✅ Wenden DRY/SSOT in Code an
- ✅ Schreiben aussagekräftige Tests
- ✅ Führen Code Review durch
- ✅ Dokumentieren professionell
- ✅ Arbeiten mit Git & PR

### Für Lehrende
- ✅ Schüler zeigen Eigenständigkeit
- ✅ Code-Quality Standards werden eingehalten
- ✅ Prozesse funktionieren ohne Anleitung
- ✅ Dokumentation ist aktuell & hilfreich

---

## 📋 Definitionen

### "Fertig" (Definition of Done)
Ein Feature ist fertig, wenn:
1. ✅ Code ist geschrieben & getestet (≥ 70% Coverage)
2. ✅ Code Review ist passed
3. ✅ Dokumentation ist aktualisiert
4. ✅ Kein DRY-Violations
5. ✅ In `main` branch gemergt

### "Ready" (Definition of Ready)
Eine Aufgabe ist bereit für Development wenn:
1. ✅ User Story/Task klar geschrieben
2. ✅ Akzeptanzkriterien definiert
3. ✅ Dependencies geklärt
4. ✅ Estimate vorhanden

---

## 🔄 Änderungs-Management

### Vorgehen für Anforderungs-Änderungen
1. Change-Request schreiben (Was, Warum, Auswirkung)
2. Stakeholder-Review (Lehrende, Projekt-Lead)
3. Priorität & Sequenz festlegen
4. Aktualisierung von PFLICHTENHEFT
5. Kommunikation an Team

### Prioritäten
| Level | Zeitrahmen | Beispiel |
|-------|-----------|---------|
| Kritisch | Sofort | Sicherheits-Fehler |
| Hoch | Diese Woche | Feature aus Roadmap |
| Mittel | Nächste Woche | Optimierung |
| Niedrig | Später | Nice-to-have |

---

## 📞 Kontakt & Support

- **Fragen zum Pflichtenheft?** → Projektleitung / Lehrende
- **Fragen zur Architektur?** → [ARCHITEKTUR.md](ARCHITEKTUR.md)
- **Prozess-Fragen?** → [prozesse/](prozesse/)
- **Dokumentation?** → [README.md](README.md) / [INDEX.md](INDEX.md)

---

**Unterschrift (Digital):** Projektleitung  
**Gültig ab:** März 2026  
**Nächste Review:** Juni 2026

*Dieses Dokument unterliegt regelmäßigen Reviews und Aktualisierungen.*
