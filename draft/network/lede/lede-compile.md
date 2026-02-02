# LEDE: Compilation

-   [lede](https://github.com/coolsnowwolf/lede)
-   [如何编译自己需要的 OpenWrt 固件](https://github.com/esirplayground/Compile_OpenWrt_Tutorial)

## 1. What Does “Compiling Firmware” Mean?

-   Instead of using prebuilt firmware, you can **build a custom firmware image** from source.
-   Benefits:
    -   Include only the packages you need → smaller, faster firmware.
    -   Customize kernel, features, or device defaults.
    -   Add your own scripts or modifications.

## 2. Prerequisites

You need a PC (Linux recommended; macOS works with some tweaks):

1.  **Operating System:** Ubuntu 20.04+ or Debian.
2.  **Required Packages:** Install build tools.

```bash
sudo apt update
sudo apt install build-essential git subversion libncurses5-dev zlib1g-dev gawk gcc-multilib flex gettext wget unzip python3 python3-distutils
```

3.   **Disk space:** At least 10 GB free.

4.   **Internet connection**: To download source and packages.

## 3. Download LEDE Source

1.  Open terminal.
2.  Clone the LEDE/OpenWrt repository:

```bash
git clone https://github.com/openwrt/openwrt.git
cd openwrt
```

(Optional) Checkout a stable release:

```bash
git checkout v21.02.5
```

## 4. Update and Install Feeds

**Feeds** are package collections (like `opkg` for building):

```bash
./scripts/feeds update -a
./scripts/feeds install -a
```

-   `update -a`: Downloads package lists.
-   `install -a`: Installs all packages for compilation.

## 5. Configure the Build

1.  Run the menu configuration tool:

```bash
make menuconfig
```

2.   You will see a text-based menu:

-   **Target System** → Your router chipset (e.g., MediaTek, Atheros).
-   **Subtarget** → Specific hardware model.
-   **Target Profile** → Specific router model.
-   **Base System** → Core packages.
-   **LuCI** → Web interface (optional, select if you want web GUI).
-   **Additional Packages** → Select extra tools you want.

3.   Navigate with arrow keys, space to select, and Enter to enter submenus.

4.   Save your configuration when done (`Save` → `Exit`).

---

```sh
make download V=s
```

## 6. Compile the Firmware

-   Start compilation:

```bash
make V=s -j$(nproc)
```

-   `-j$(nproc)` uses all CPU cores to speed up compilation.
-   First build may take **30–120 minutes** depending on PC and selected packages.

**Output firmware location:**

```
bin/targets/<target>/<subtarget>/
```

It contains:

-   `factory.bin` → Flash this if your router has stock firmware.
-   `sysupgrade.bin` → Upgrade existing LEDE/OpenWrt installation.

## 7. Flash the Firmware

1.  Connect PC to router via Ethernet.
2.  Access router web interface or use **TFTP/SSH** depending on device.
3.  Upload the firmware:
    -   **Factory firmware** → first-time install.
    -   **Sysupgrade firmware** → upgrade LEDE/OpenWrt.

**⚠️ Warning:** Flashing firmware incorrectly may brick the router. Always backup your configuration.

## 8. Tips for Beginners

-   Always **backup** your `.config`:

```bash
cp .config ~/lede-config-backup
```

-   If compilation fails:

    ```bash
    make clean
    ```

    Then retry `make menuconfig` → `make -j$(nproc)`.

-   Only include necessary packages for your first build to reduce errors.

-   Use forums and wiki for device-specific guidance:

    -   [OpenWrt Wiki](https://openwrt.org/docs/start)
    -   [OpenWrt Forum](https://forum.openwrt.org/)

## 9. Optional: Customizing Your Firmware

-   Add your own scripts to `/files` folder in the source tree → automatically included.
-   Change default IP:

```bash
vi files/etc/config/network
```

-   Pre-install packages by default:

```bash
vi files/etc/opkg.conf
```
