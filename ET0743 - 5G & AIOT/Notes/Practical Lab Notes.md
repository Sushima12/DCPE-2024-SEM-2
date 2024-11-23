
---
--- Contents ---
1. Lab 1 - 5G Hat and AT Commands

---
#### 5G Hat and AT Commands

>Pi and PC Connection
- USB 3.0 Connection
  - Connect to the Top USB 3.0 to the PC with Cable
  - There should be a faint red light at the back to indicate connection

>Setup:
1. Make sure the Port is referring to the AT Port
   - Check device manager

> AT Commands 
1. `AT+QENG="servingcell"`
   - To query information of serving cell
2. `AT+QUIMSLOT?`
   - Check SIM slot
   `AT+QUIMSLOT=1`
   -  Switch to slot 1
3. `AT+QNWPREFCFG= “mode_pref”, NR5G`
   - Force 5G Standalone
   `AT+QENG="servingcell"`
   - Query network status
   `AT+QCFG="usbnet", 2`
   - Switch to MBIM mode
   `AT+CFUN=1,1`
   - Save & reboot the 5G module

>Other AT Commands
1. `AT+CGPADDR=1`
   - query IP address
2. `AT+QENG="servingcell"
   - query network status
3. `AT+QNWINFO
   - query network info
4. `AT+QNWPREFCFG= “nr5g_band”, 77:78`
   - setup 5G frequency bands
5. `AT+COPS?`
   - query network operator
6. `AT+QNWPREFCFG= “mode_pref”, NR5G`
   - force to 5G SA mode
7. `AT+QNWPREFCFG=” mode_pref”, AUTO`
   - change to normal mode
8. `AT+QNWPREFCFG= “nr5g_disable_mode”, 0`
   - enable 5G NSA and SA 
9. `AT+QNWPREFCFG= “nr5g_disable_mode”, 2`
   - disable 5G NSA mode
10. `AT+CGCONTRDP`
    - query public / SIM IP address
11. `AT+CSQ`
    - returns signal strength (dBm) and bit error rate 

---
#### Raspberry Pi & Linux Basics

>Linux Commands
1. `ls`
   - List files and folders in the current directory
2. `pwd`
   - Displays current directory path
3. `cd`
   - Navigate directories
4. `mkdir`
   - Create directories
5. `mv`
   - Move / Rename directories
6. `cp`
   - Move / Copying files
7. `rm`
   - Delete files / directories
8. `sudo`
   - Change user permissions level to root user (administrator mode)
9. `touch`
   - Create new empty file
10. `rmdir`
    - Remove directory specified by directory parameter
11. `man`
    - Display user manual of any Linux command

---
##### 5G -RPI4 and 5G Modem applications
>Notes:
1. Ensure that the USB Bridge is connecting the 5G module and RPi

>Command to uninstall program
- `sudo apt purge ProgramName` -y

>Connecting RPi to WiFi
1. `sudo nano /etc/wpa_supplicant/wpa_supplicant.conf`
2. Open `wificonfig.txt` in desktop
   - Copy it to the terminal
3. Replace login credentials with school wifi login details
   - `Ctrl + s` to save
   - `Ctrl + x` to edit
4. Restart networking service
   - `sudo systemctl restart wpa_supplicant`
5. Reboot RPi
   - `sudo reboot`
6. Minicom Installation
   - `sudo apt-get install minicom`
7. Activate Minicom
   - `sudo minicom -D/dev/ttyUSB2`
8. Turn off WiFi
9. AT Commands to be sent to Minicom
   - `AT+QNWPREFCFG= "mode_pref", NR5G`
   - `AT+QENG=”servingcell”`
   - `AT+QCFG=”usbnet”,1`
     - switch to ECM mode
   - `AT+CFUN=1,1`
     - save and reboot
10. It should output "Cannot Open /dev/ttyUSB2", then reboot the RPi
    - `sudo reboot`
11. After resetting, open terminal and enter the following commands
    - `ifconfig usb0`
    - `ping -c 10 google -I`

---
####