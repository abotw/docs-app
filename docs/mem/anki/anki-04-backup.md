---
title: "Anki: Backup"
icon: simple/anki
status: done
---

**What Is Backed Up, How, and How to Recover**

If Anki matters to you, backups are **not optional**.

## 1. Why Backups Matter in Anki (More Than You Think)

Anki decks represent:

-   Thousands of hours of thinking
-   Carefully designed notes
-   Personalized scheduling history

Losing an Anki collection means:

-   Losing intervals
-   Losing learning progress
-   Losing the *state of your memory*

Anki backups protect **far more than card text**.

## 2. What Exactly Needs to Be Backed Up

Anki data consists of three layers:

### 2.1 Content

-   Notes
-   Fields
-   Tags
-   Deck structure

### 2.2 Scheduling State

-   Review history
-   Intervals
-   Ease factors
-   Due dates

### 2.3 Media

-   Images
-   Audio
-   Screenshots
-   Diagrams

A good backup strategy covers **all three**.

## 3. Anki’s Built-In Automatic Backups

### 3.1 How Auto Backups Work

Every time you:

-   Open Anki
-   Close Anki
-   Sync

Anki silently creates a backup of:

-   Your entire collection database

These are stored locally.

### 3.2 What Is Included

Included:

-   All decks
-   All notes
-   All scheduling data

Not included:

-   Media files (images/audio)

This distinction is critical.

### 3.3 Where Auto Backups Are Stored

Typical locations:

-   **macOS**
    `~/Library/Application Support/Anki2/<Profile>/backups/`
-   **Windows**
    `%APPDATA%\Anki2\<Profile>\backups\`
-   **Linux**
    `~/.local/share/Anki2/<Profile>/backups/`

Files look like:

```
collection-2026-02-08-09-30.colpkg
```

They are timestamped snapshots.

### 3.4 How Many Backups Are Kept

Default:

-   Last **50** backups

Oldest backups are deleted automatically.

You can change this in:

```
Preferences → Backups
```

## 4. Restoring from an Automatic Backup

### 4.1 When to Restore

Common cases:

-   Accidental mass deletion
-   Bad add-on behavior
-   Sync conflict resolution mistake
-   Corrupted collection

### 4.2 Restore Process (Desktop)

1.  Open Anki
2.  `File → Switch Profile`
3.  Click **Open Backup**
4.  Choose a backup by timestamp
5.  Confirm restore

This replaces your current collection.

⚠️ Restore **before syncing** again.

## 5. AnkiWeb Sync Is NOT a Backup

This is a very common misconception.

### 5.1 What Sync Does

-   Keeps devices consistent
-   Mirrors changes everywhere

### 5.2 What Sync Does NOT Do

-   No version history
-   No undo
-   No protection from mistakes

If you delete something and sync:

-   It is deleted everywhere

👉 Sync = **replication**, not backup.

## 6. Full Export Backups (Manual)

### 6.1 Why Manual Exports Matter

Manual exports:

-   Include **media files**
-   Are portable
-   Can be stored offline

Use them as **milestones**:

-   Monthly
-   Before major edits
-   Before add-on experiments

### 6.2 How to Export Properly

1.  Select **All Decks**
2.  `File → Export`
3.  Choose:
    -   Format: `Anki Deck Package (*.apkg)`
    -   ✔️ Include media
    -   ✔️ Include scheduling information

This creates a self-contained archive.

### 6.3 What an `.apkg` Contains

-   All notes
-   All cards
-   Scheduling state
-   All media files

This is the **gold standard backup**.

## 7. Media Folder Backup (Often Forgotten)

Media files live separately from the database.

Folder:

```
collection.media/
```

Problems if not backed up:

-   Missing images
-   Broken audio
-   Blank cards

Best practice:

-   Back up the entire `Anki2` folder, not just files inside it.

## 8. Profiles and Backups

Each profile has:

-   Separate collection
-   Separate backups
-   Separate media

If you use multiple profiles:

-   Back them all up
-   Restore carefully to the correct profile

## 9. Advanced Backup Strategy (Recommended)

### 9.1 The 3-Layer Model

1.  **Anki auto backups** (short-term safety)
2.  **Manual `.apkg` exports** (medium-term safety)
3.  **System-level backups** (long-term safety)

Examples:

-   Time Machine (macOS)
-   Cloud storage
-   External disk

### 9.2 When to Create Manual Backups

Always do it before:

-   Installing new add-ons
-   Bulk editing notes
-   Changing note types
-   Importing large decks

## 10. Recovering from Common Disaster Scenarios

### Scenario 1: Accidental Deletion

→ Restore from auto backup

### Scenario 2: Broken Media

→ Restore `collection.media` from system backup

### Scenario 3: Sync Conflict Gone Wrong

→ Restore backup, then **force upload**

### Scenario 4: Add-on Corruption

→ Restore backup made before installation

## 11. Things Backups Cannot Save You From

-   Poor card design
-   Overloaded decks
-   Burnout from too many reviews

Backups protect data — not decisions.

## 12. Golden Rules to Remember

1.  **Sync is not backup**
2.  **Auto backups don’t include media**
3.  **Manual exports are your lifeline**
4.  **Never sync after a mistake before restoring**
5.  **Back up before experimenting**

# Final Mental Model

>   **Anki backups preserve not just information, but time.**

Your decks represent:

-   **Past effort**
-   **Future efficiency**

Protect them like source code.

