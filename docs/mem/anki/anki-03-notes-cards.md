---
title: "Anki: Notes & Cards"
icon: simple/anki
status: done
---

**How Anki Stores Knowledge vs How It Tests Memory**

If you understand this chapter, you understand Anki.

## 1. The Core Distinction (Memorize This)

>   **Notes store information.**
>
>   **Cards test memory.**

You **create notes**.

Anki **generates cards**.

This separation is not cosmetic — it is a *design principle*.

## 2. What Is a Note?

A **note** is **a structured container** of information.

It is:

-   One *concept*
-   With multiple *fields*
-   Saved once

Examples of fields:

-   Term
-   Definition
-   Example
-   Explanation
-   Image
-   Extra info

A note is **not something you review** directly.

### 2.1 Example: Vocabulary Note

Fields:

```
Word: abandon
Meaning: give up completely
Example: He abandoned the plan.
Pronunciation: /əˈbændən/
```

This is **one note**.

## 3. What Is a Card?

A **card** is a *question–answer pair* generated from a note.

A card:

-   Has a front (question)
-   Has a back (answer)
-   Is scheduled for review
-   Is shown repeatedly over time

Cards are what Anki actually shows you.

### 3.1 Cards Generated from One Note

From the same vocabulary note, Anki can generate:

-   Card 1
    Front: `abandon`
    Back: `give up completely`
-   Card 2
    Front: `give up completely`
    Back: `abandon`
-   Card 3
    Front: `He ___ the plan.`
    Back: `abandoned`

One note → multiple cards.

## 4. Why Anki Separates Notes and Cards

This separation allows:

1.  **Reuse**
    -   One fact, many tests
2.  **Consistency**
    -   Fix the note → all cards update
3.  **Multiple recall directions**
    -   Recognition
    -   Production
    -   Contextual recall
4.  **Better memory coverage**
    -   Memory is context-dependent

Anki tests *how* you know something, not just *that* you know it.

## 5. Note Types: The Blueprint

A **note type** defines:

-   What fields exist
-   How many cards are created
-   What each card looks like

Examples:

-   Basic
-   Basic (and reverse)
-   Cloze
-   Custom note types

Think of a note type as a **card factory**.

### 5.1 Basic Note Type

Fields:

```
Front
Back
```

Cards:

-   One card per note

Use when:

-   Knowledge is one-directional
-   You want simplicity

### 5.2 Basic (and Reverse)

Fields:

```
Front
Back
```

Cards:

-   Front → Back
-   Back → Front

Use when:

-   Both directions matter
-   Vocabulary, definitions

Caution:

-   Not always appropriate (not all facts are symmetric)

### 5.3 Cloze Note Type

Fields:

```
Text
Extra
```

Example note:

```
TCP is a {{c1::connection-oriented}} protocol.
```

Cards:

-   One per cloze deletion

Why cloze is powerful:

-   Keeps context
-   Encourages atomic deletions
-   Fast to create

## 6. Fields: Design Matters

Fields are **raw data**, not cards.

Good field design:

-   Clear purpose per field
-   No mixing of unrelated info
-   Optional extra fields allowed

Bad field design:

-   Huge paragraphs
-   Multiple concepts in one field
-   Formatting chaos

Rule:

>   If you hesitate while recalling, the card is poorly designed.

## 7. Card Templates: How Notes Become Cards

A **card template** decides:

-   What appears on the front
-   What appears on the back
-   How fields are arranged

Example template logic:

```
Front: {{Word}}
Back: {{Meaning}}<br>{{Example}}
```

Change the template:

-   All existing cards update
-   No need to re-enter notes

This is why notes are more important than cards.

## 8. One Note, Many Cards — But Not Too Many

Anki allows many cards per note, but:

Too few cards:

-   Poor coverage

Too many cards:

-   Review overload
-   Redundancy
-   Fatigue

Rule of thumb:

-   1–5 cards per note
-   Each card tests a *different angle*

## 9. Editing Notes vs Editing Cards

### Edit the note when:

-   Content is wrong
-   Explanation is unclear
-   Example is bad

### Edit the card when:

-   Question is poorly phrased
-   Front reveals the answer
-   Card is ambiguous

Most of the time:

>   **Edit the note, not the card.**

## 10. Common Beginner Confusions

### “Why did editing one card change others?”

Because they share the same note.

### “Why do I see cards I didn’t create?”

Anki generated them from the note type.

### “Why does deleting a note delete many cards?”

Because cards depend on the note.

## 11. Designing Notes with Memory in Mind

Ask while creating a note:

-   What might I forget?
-   In what direction will I need recall?
-   What context helps recall but doesn’t give away the answer?

Design notes so cards can be:

-   Short
-   Clear
-   Atomic

## 12. Mental Model to Keep Forever

>   **Notes are knowledge.**
>
>   **Cards are questions.**
>
>   **Templates are factories.**

If Anki feels hard:

-   Fix cards → short term
-   Fix notes → long term

## Final Advice

Most Anki problems are **note design problems** disguised as scheduling issues.

If you master notes and cards:

-   Reviews become fast
-   Retention becomes high
-   Anki becomes boring — in a good way

