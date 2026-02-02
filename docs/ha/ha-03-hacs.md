---
title: HACS
icon: simple/homeassistant
status: draft
---

## 1. What is HACS?

**HACS** stands for **Home Assistant Community Store**.

Think of it as:

>   🏪 **An app store for Home Assistant**

With HACS, you can easily install:

-   **Custom integrations** (e.g. Xiaomi, iCloud, Govee, Tuya extras)
-   **Custom Lovelace cards** (better dashboards)
-   **Themes** (dark mode, minimal UI, iOS-style look)
-   **Plugins** made by the community

Without HACS, installing these usually means:

-   Manually copying files
-   Editing folders
-   Restarting HA multiple times

With HACS → **one click install & update**.

------

## 2. Do you really need HACS?

Short answer: **Yes, if you want to level up Home Assistant.**

You’ll want HACS if you:

-   Use community integrations not in official HA
-   Want better dashboards (Mushroom, Mini Graph Card, etc.)
-   Like clean, modern UI themes
-   Hate manual updates

If you only use official integrations → HACS is optional
But most HA power users **cannot live without it** 😉

------

## 3. Prerequisites (Before Installing)

Make sure you have:

✅ Home Assistant **OS / Supervised / Container**

❌ HACS does **NOT** work on Core (venv only)

Check:

```
Settings → About → Installation type
```

You also need:

-   Internet access
-   A Home Assistant user account (admin)

------

## 4. Install HACS (Step by Step)

### Step 1: Enable Advanced Mode

1.  Go to **Settings → User Profile**
2.  Enable **Advanced Mode**

This unlocks custom integrations.

### Step 2: Download HACS

Open **Terminal / SSH** in Home Assistant and run:

```bash
wget -O - https://get.hacs.xyz | bash -
```

This will:

-   Create `/config/custom_components/hacs`
-   Download HACS files automatically

### Step 3: Restart Home Assistant

Go to:

```
Settings → System → Restart
```

Wait until HA is fully back online.

### Step 4: Add HACS Integration

1.  Go to **Settings → Devices & Services**
2.  Click **Add Integration**
3.  Search for **HACS**
4.  Follow the onboarding steps

You will be asked to:

-   Accept terms
-   Choose categories (Integrations, Frontend, Themes)

### Step 5: GitHub Authorization (Important)

HACS uses **GitHub API**.

You will:

1.  Be shown a **GitHub verification code**
2.  Open a link
3.  Login to GitHub
4.  Paste the code

👉 No repo access needed

👉 Public GitHub account is enough

## 5. Where to Find HACS After Installation?

After success, you’ll see:

```
Sidebar → HACS
```

Inside HACS you’ll find sections like:

-   **Integrations**
-   **Frontend**
-   **Themes**
-   **Automations** (optional)

------

## 6. Install Your First Thing with HACS

### Example: Install a Custom Integration

1.  Open **HACS**
2.  Go to **Integrations**
3.  Click **Explore & Download Repositories**
4.  Search an integration (e.g. `Govee`, `Xiaomi`, `iCloud`)
5.  Click **Download**
6.  Restart Home Assistant
7.  Add it via **Settings → Devices & Services**

------

### Example: Install a Lovelace Card

1.  HACS → **Frontend**
2.  Search: `Mushroom`
3.  Download
4.  Restart HA
5.  Add card in Dashboard UI

✨ Much nicer UI instantly

------

## 7. Updating with HACS

This is where HACS shines.

-   Updates appear automatically in HACS
-   One click → update
-   No manual file handling

You’ll often see:

```
🔔 HACS → Updates available
```

------

## 8. HACS vs Official Integrations

| Feature           | Official HA | HACS      |
| ----------------- | ----------- | --------- |
| Stability         | ⭐⭐⭐⭐⭐       | ⭐⭐⭐       |
| New features      | Slow        | Very fast |
| Community plugins | ❌           | ✅         |
| One-click updates | ✅           | ✅         |

💡 Best practice:

-   Prefer **official** when possible
-   Use **HACS** when official doesn’t exist

------

## 9. Common Beginner Mistakes

❌ Forgetting to restart after install
❌ Installing but not adding integration
❌ Using Core install (HACS unsupported)
❌ Missing GitHub auth step

------

## 10. Is HACS Safe?

Yes, **if you are careful**:

-   HACS itself is widely trusted
-   Integrations are community-made
-   Always check:
    -   Stars
    -   Last update
    -   README

If something breaks → disable it and restart.

------

## 11. Recommended HACS Picks for Beginners

🔥 **Integrations**

-   Xiaomi Miot
-   iCloud3
-   Govee
-   LocalTuya

🎨 **Frontend / Cards**

-   Mushroom
-   Mini Graph Card
-   Button Card

🎭 **Themes**

-   Mushroom Theme
-   iOS Theme
-   Minimalist

------

## 12. Final Thoughts

If Home Assistant is the **operating system** of your smart home,
then **HACS is the app store** that makes it powerful and fun.

Once you install HACS:

>   You’ll never want to manage custom integrations manually again 😄

