# LEDE: menuconfig

When you build LEDE/OpenWrt from source, `make menuconfig` is where you **select target device, kernel modules, and optional packages**. This is essential for features like USB, SD card, and Shadowsocks.

## 1. Start `make menuconfig`

1.  Open terminal in your LEDE source folder:

```bash
cd ~/lede
make menuconfig
```

2.   You will see a **menu interface**:

-   Use **Arrow Keys** to navigate
-   **Enter** to select
-   **Space** to toggle [*] selection
-   **Esc** to go back

## 2. Select Target System

1.  Go to **Target System**
    -   Example: `MediaTek Ralink MIPS` (for MT1300)
2.  Select **Target Profile**
    -   Example: `GL.iNet GL-MT1300`
3.  Press **Exit** to go back

>   This ensures the firmware matches your router hardware.

## 3. Enable USB Support

1.  Go to **Kernel modules → USB Support**
2.  Enable the following (press Space to select):

```
[*] kmod-usb-core       (core USB support)
[*] kmod-usb2            (USB 2.0 support)
[*] kmod-usb-storage     (USB storage devices)
[*] kmod-usb3            (USB 3.0 if your router supports)
[*] block-mount          (for mounting USB drives)
[*] kmod-fs-ext4         (if using ext4 formatted drives)
[*] kmod-fs-vfat         (if using FAT32 formatted drives)
[*] kmod-fs-exfat        (optional for exFAT)
```

>   If you want **automatic mounting**, you can also select `kmod-fs-auto` or `kmod-fs-ntfs` for Windows-formatted drives.

## 4. Enable SD Card Support (if your router has a slot)

-   Usually under **Kernel modules → MTD/Memory Technology Devices or USB Storage → MMC/SD Card Support**
-   Enable:

```
[*] kmod-mmc
[*] kmod-mmc-spi
[*] block-mount
[*] kmod-fs-ext4 (or vfat/exfat depending on your SD card)
```

>   SD card support often uses the same storage subsystem as USB in OpenWrt.

## 5. Select Shadowsocks / SSR Packages

1.  Go back to **Menuconfig main menu → Network → VPN**
2.  Enable **ShadowsocksR client packages**:

```
[*] luci-app-shadowsocksr  (web interface)
[*] shadowsocksr-libev-ssr  (core)
[*] shadowsocksr-libev-ssr-local
```

-   If you don’t see SSR in the menu, you may need to **add the extra feed**:

```bash
# Edit feeds.conf.default
echo "src-git helloworld https://github.com/fw876/helloworld.git" >> feeds.conf.default
./scripts/feeds update -a
./scripts/feeds install -a
```

Then rerun `make menuconfig`.

------

## **6. Optional: Other Useful Packages**

-   **Samba / File sharing**: `luci-app-samba` → allows sharing USB/SD over LAN
-   **Additional filesystem support**: `kmod-fs-btrfs`, `kmod-fs-xfs` (if using special filesystems)
-   **Network tools**: `nano`, `htop`, `wget` for easier management

------

## **7. Save Configuration and Build**

1.  After selecting all packages, press **Exit** until you return to the main menu
2.  It will ask: **Save configuration? → Yes**
3.  Start the build:

```bash
make -j$(nproc) V=s
```

-   `-j$(nproc)` uses all CPU cores to speed up compilation
-   `V=s` shows detailed compilation log

>   Once built, you’ll have a **firmware image** in `bin/targets/<target>` ready to flash.

------

## ✅ **Summary for Beginners**

1.  `make menuconfig` → select **target system / profile**
2.  **Enable USB support** under kernel modules → USB
3.  **Enable SD card support** under kernel modules → MMC/SD
4.  **Enable ShadowsocksR packages** under Network → VPN
5.  **Add any extra feeds** if SSR packages are missing
6.  Save → Build firmware

>   Tip: For beginners, you can **start with only USB + SSR** and later add extra packages. Avoid selecting everything to keep firmware small.

------

If you want, I can make a **visual beginner-friendly map of menuconfig selections**, showing exactly which menus to go through for **USB, SD card, and SSR**, so you can just follow it like a checklist.

Do you want me to do that?