---
title: 2FA
status: done
---

## 1️⃣ What Is 2FA?

**2FA (Two-Factor Authentication)** is an extra layer of security added to your password.

Normally, you log in with:

>   ✅ Something you **know** → your password

With 2FA, you must also provide:

>   ✅ Something you **have** (like your phone)
>
>   or
>
>   ✅ Something you **are** (like your fingerprint)

So even if someone steals your password, they still **can’t log in** without the second factor.

## 2️⃣ Why 2FA Is Important

Passwords alone are not enough because they can be:

-   Guessed
-   Reused across sites
-   Leaked in data breaches
-   Phished through fake websites

For example, if your account on Facebook or Google gets compromised, attackers may gain access to:

-   Your private messages
-   Your email
-   Password reset links
-   Financial data

2FA dramatically reduces this risk.

Even if your password leaks, your account stays protected.

## 3️⃣ The Three Authentication Factors

Security experts divide authentication into three types:

### 1️⃣ Something You Know

-   Password
-   PIN

### 2️⃣ Something You Have

-   Phone
-   Hardware key
-   Authentication app

### 3️⃣ Something You Are

-   Fingerprint
-   Face recognition

2FA simply means using **two different categories** together.

## 4️⃣ Common Types of 2FA (From Weakest to Strongest)

### 📱 1. SMS Codes (Basic Level)

You receive a 6-digit code via text message.

Example:

-   You enter your password.
-   A code is sent to your phone.
-   You enter the code to log in.

✔ Easy to use

❌ Vulnerable to SIM swapping attacks

Better than nothing, but not the best option.

### 📲 2. Authenticator Apps (Recommended)

Apps generate a new 6-digit code every 30 seconds.

Popular apps include:

-   Google Authenticator
-   Microsoft Authenticator
-   Authy

How it works:

-   You scan a QR code when enabling 2FA.
-   The app generates time-based codes (TOTP).
-   You enter the current code when logging in.

✔ Works offline

✔ More secure than SMS

✔ Widely supported

For most beginners, this is the best choice.

### 🔑 3. Hardware Security Keys (Most Secure)

Physical devices you plug in or tap.

Examples:

-   YubiKey

How it works:

-   Insert or tap the key
-   Press a button to confirm

✔ Extremely secure

✔ Resistant to phishing

✔ Used by security professionals

This is ideal for:

-   Journalists
-   Developers
-   Business accounts
-   Anyone serious about security

## 5️⃣ What Is TOTP?

Most authenticator apps use:

**TOTP = Time-Based One-Time Password**

-   Code changes every 30 seconds
-   Based on a shared secret
-   Works without internet

It’s secure because attackers cannot reuse old codes.

## 6️⃣ How to Enable 2FA (General Steps)

Although every website is slightly different, the process is usually:

1.  Go to **Account Settings**
2.  Open **Security**
3.  Click **Enable Two-Factor Authentication**
4.  Choose:
    -   SMS, or
    -   Authenticator app (recommended)
5.  Save your backup codes

## 7️⃣ VERY IMPORTANT: Backup Codes

When enabling 2FA, websites give you:

>   🔐 Backup recovery codes

These are one-time emergency codes in case you lose your phone.

You should:

-   Save them in a password manager
-   Print them and store safely
-   Never screenshot and forget them

If you lose both your password and 2FA device without backups, account recovery can be very difficult.

## 8️⃣ Common Beginner Mistakes

❌ Only enabling SMS 2FA

❌ Not saving backup codes

❌ Not backing up authenticator apps

❌ Storing recovery codes in email

## 9️⃣ Should You Use 2FA Everywhere?

Priority accounts:

-   Email (most important!)
-   Password manager
-   Banking
-   Cloud storage
-   Social media

If your email is hacked, attackers can reset everything else.

## 🔟 2FA vs MFA

You may also hear:

**MFA (Multi-Factor Authentication)**

MFA = two or more factors

2FA = exactly two factors

In daily conversation, people use them interchangeably.

## Final Advice for Beginners

If you do only one thing after reading this guide:

>   Enable authenticator-app-based 2FA on your email account today.

It is one of the highest security improvements you can make with minimal effort.

