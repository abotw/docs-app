---
title: Surge
status: done
---

## 1. What is Surge?

**Surge** is a powerful **network toolbox for macOS & iOS**.
At its core, it works as a **local proxy** that lets you:

-   🚀 Bypass network restrictions (via proxy nodes)
-   🧠 Control traffic routing with rules
-   🧪 Debug network requests (very strong feature)
-   🔒 Enhance privacy and security
-   📱 Manage proxies on Apple devices elegantly

>   In simple terms:
>   **Surge decides “which app / website goes through which proxy (or not)”**

## 2. Surge vs Other Tools (Quick Comparison)

| Tool         | Strength        | Weakness                 |
| ------------ | --------------- | ------------------------ |
| Clash        | Free, popular   | Limited rule flexibility |
| Shadowrocket | Easy on iOS     | Less powerful            |
| **Surge**    | 🔥 Most powerful | Paid, learning curve     |

If you want **fine-grained control** and **professional-grade rules**, Surge is worth it.

## 3. Supported Platforms

-   ✅ **macOS** (recommended for beginners)
-   ✅ **iOS / iPadOS**
-   ❌ Windows / Linux (not supported)

## 4. Core Concepts (Must Understand)

Don’t skip this section 👇
Surge becomes *easy* once these are clear.

### 4.1 Proxy

A **proxy** is a server that forwards your traffic.

Examples:

-   Shadowsocks
-   Vmess
-   Trojan
-   HTTP / HTTPS

In Surge, **proxies are called `Proxy` or `Proxy Group`**.

### 4.2 Policy (Proxy Group)

A **Policy** decides *which proxy to use*.

Common types:

-   `select` → manually choose
-   `url-test` → auto choose fastest
-   `fallback` → backup system

Example:

```
ProxyGroup = select, 🇯🇵 JP, 🇺🇸 US, DIRECT
```

### 4.3 Rule

Rules decide:

>   **Which traffic uses which policy**

Examples:

-   Google → Proxy
-   Local websites → Direct
-   Ads → Block

Rule logic:

```
IF (condition) → THEN (policy)
```

### 4.4 DIRECT / REJECT

-   `DIRECT` → no proxy, go straight
-   `REJECT` → block traffic

## 5. How Surge Works (Big Picture)

```
App → Surge → Rule → Policy → Proxy → Internet
```

Surge always follows this order.

## 6. Installing Surge (macOS)

1.  Download from official site
2.  Install & open Surge
3.  Allow:
    -   Network extension
    -   VPN permission
4.  Status bar icon appears → Surge is running

## 7. Configuration File (.conf)

Surge uses **one main config file**.

Structure:

```
[General]
[Proxy]
[Proxy Group]
[Rule]
```

You usually **subscribe** instead of writing from scratch.

## 8. Using a Subscription (Most Common)

### 8.1 Import Subscription

1.  Open Surge
2.  Profiles → Download Profile from URL
3.  Paste your provider’s subscription link
4.  Update profile

That’s it ✅

### 8.2 Profile Update

-   Surge can auto-update
-   You can also manually refresh

## 9. Understanding Each Section (With Examples)

### 9.1 [General]

Basic behavior settings:

```
[General]
loglevel = notify
dns-server = system
```

Beginners usually don’t touch this.

### 9.2 [Proxy]

Defines actual nodes.

Example:

```
[Proxy]
JP = ss, jp.example.com, 8388, encrypt-method=aes-256-gcm, password=123456
```

If you use subscriptions → auto generated.

### 9.3 [Proxy Group]

This is **very important**.

Example:

```
[Proxy Group]
Proxy = select, JP, US, DIRECT
Auto = url-test, JP, US, url=http://www.gstatic.com/generate_204
```

You usually use:

-   One **manual group**
-   One **auto group**

### 9.4 [Rule]

Rules are matched **top → bottom**.

Example:

```
[Rule]
DOMAIN-SUFFIX,google.com,Proxy
DOMAIN-SUFFIX,apple.com,DIRECT
GEOIP,CN,DIRECT
FINAL,Proxy
```

Meaning:

1.  Google → Proxy
2.  Apple → Direct
3.  China IP → Direct
4.  Everything else → Proxy

## 10. Rule Matching Priority ⚠️

Very important:

```
FIRST match wins
```

So:

-   Specific rules → top
-   General rules → bottom
-   `FINAL` → always last

## 11. Common Beginner Setup (Recommended)

### Simple & Safe Strategy

-   Domestic websites → DIRECT
-   Foreign websites → Proxy
-   Auto node selection

This gives:

-   Good speed
-   Low maintenance

## 12. Surge Dashboard (macOS)

Key panels:

-   **Overview** → proxy status
-   **Traffic** → real-time connections
-   **Requests** → HTTP debugging
-   **Rules** → see matched rules

>   Surge is famous for its **Request Inspector**

## 13. Debugging with Surge (Bonus)

You can:

-   View HTTPS requests
-   Modify headers
-   Mock responses
-   Test APIs

This is why many developers love Surge.

## 14. Common Beginner Mistakes

❌ Putting `FINAL` too early

❌ Mixing Clash rules directly

❌ Forgetting to enable Surge

❌ No DIRECT rules → slow local access

## 15. Learning Path (Recommended)

1.  Use subscription (don’t write config)
2.  Learn:
    -   Proxy Group
    -   Rule logic
3.  Modify rules
4.  Learn Rewrite & Script (advanced)

## 16. When Should You Use Surge?

Use Surge if you want:

-   ✅ Precise routing control
-   ✅ Strong debugging
-   ✅ macOS / iOS ecosystem
-   ❌ Not free

## 17. Summary

-   Surge = **professional proxy controller**
-   Rules decide **where traffic goes**
-   Policy decides **which node to use**
-   Beginners should **start with subscriptions**
-   Learn rules slowly → Surge becomes addictive 😄