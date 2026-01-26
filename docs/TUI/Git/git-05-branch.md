# Git Branch

## 1. Why Do We Need Branches?

Imagine you are writing a program:

-   The **main code works**
-   You want to **add a new feature**
-   But you don’t want to break the working version

👉 **Branches** let you work on new ideas **independently** from the main code.

Think of branches as:

>   **Parallel timelines** of your project

------

## 2. What Is a Git Branch?

A **Git branch** is:

-   A **pointer** to a commit
-   A **separate line of development**

By default, every Git repository has one branch:

```text
main
```

(Older repos may use `master`.)

------

## 3. Visual Mental Model

```
A --- B --- C   (main)
          \
           D --- E   (feature-login)
```

-   `main` keeps stable code
-   `feature-login` is where new work happens

------

## 4. Check Current Branch

```bash
git branch
```

Output:

```text
* main
```

-   `*` means **current branch**

Or:

```bash
git status
```

------

## 5. Create a New Branch

### Create branch only

```bash
git branch feature-login
```

### Create and switch (recommended)

```bash
git checkout -b feature-login
```

Or (newer syntax):

```bash
git switch -c feature-login
```

------

## 6. Switch Between Branches

```bash
git checkout main
```

Or:

```bash
git switch main
```

⚠️ You must have **clean working tree** (no uncommitted changes), or Git may block switching.

------

## 7. Work on a Branch

Once on a branch:

```bash
# edit files
git add .
git commit -m "Add login feature"
```

✔️ Commits belong **only to this branch**

------

## 8. Merge a Branch

When your feature is ready:

### Step 1: Switch to target branch

```bash
git switch main
```

### Step 2: Merge

```bash
git merge feature-login
```

Result:

-   Changes from `feature-login` are added to `main`

------

## 9. Fast-Forward vs Merge Commit

### Fast-forward merge

Happens when main hasn’t changed:

```
main ─────▶
```

### Merge commit

When both branches changed:

```
        ┌── feature
main ───┴── merge commit
```

Git handles this automatically.

------

## 10. Delete a Branch (After Merge)

```bash
git branch -d feature-login
```

Force delete (dangerous):

```bash
git branch -D feature-login
```

------

## 11. Handle Merge Conflicts (Basic Idea)

Conflict happens when **same lines** are changed.

Git will mark conflicts like:

```text
<<<<<<< HEAD
code from main
=======
code from feature
>>>>>>> feature-login
```

Steps:

1.  Edit file manually
2.  Remove markers
3.  Save correct version
4.  Commit

------

## 12. Branches with Remote (GitHub)

### Push a branch

```bash
git push -u origin feature-login
```

### See remote branches

```bash
git branch -r
```

### Delete remote branch

```bash
git push origin --delete feature-login
```

------

## 13. Common Beginner Workflow

```bash
git switch -c feature-x
# work and commit
git switch main
git merge feature-x
git branch -d feature-x
```

------

## 14. Best Practices

-   Keep `main` **stable**
-   One branch = **one task**
-   Use clear names:
    -   `feature-login`
    -   `fix-crash`
    -   `docs-readme`
-   Delete branches after merging

------

## 15. Summary

| Concept           | Meaning                      |
| ----------------- | ---------------------------- |
| Branch            | Independent development line |
| main              | Stable production code       |
| checkout / switch | Change branch                |
| merge             | Combine branches             |
| conflict          | Manual decision needed       |

