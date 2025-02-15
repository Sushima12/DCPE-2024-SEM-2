/************************************/
/*         Graphics lab             */
/************************************/

#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include "library.h"

#define LEDPort 0x32 		/* LED port */
#define LCDPort 0x33		/* LCD port */
#define KbdPort 0x34		/* keypad port */


unsigned char ProcKey();
unsigned char ScanKey();

const unsigned char ScanTable [12] =
{
  /* 0     1     2     3 */
     0xB7, 0x7E, 0xBE, 0xDE,
  /* 4     5     6     7 */
   0x7D, 0xBD, 0xDD, 0x7B,
  /* 8     9     *     # */
   0xBB, 0xDB, 0x77, 0xD7
};

const unsigned char Bin2LED[] =                           
/*  0     1     2    3 */
 {0x40, 0x79, 0x24, 0x30,
/*  4     5     6    7*/
  0x19, 0x12, 0x02, 0x78,
/*  8     9     A    B*/
  0x00, 0x18, 0x08, 0x03};

unsigned char ScanCode;

#define Col7Lo 0xF7            // column 7 scan
#define Col6Lo 0xFB            // column 6 scan
#define Col5Lo 0xFD            // column 5 scan
#define Col4Lo 0xFE            // column 4 scan

static void initlcd();
static void lcd_writecmd(char cmd);
static void LCDprint(char *sptr);
static void lcddata(unsigned char cmd);

/*************** MAIN PROGRAM ******************/

int main(int argc, char *argv[])
{
	system("killall pqiv");													// clear any instances of pqiv if any
	CM3DeviceInit();
	
	initlcd();
    //Home Screen
	home_screen();

	CM3DeviceDeInit();   
}
//Common Functions
//1. Dispensing your Drink
//2. Home Screen
//3. Confirmation
//4. Sugar Option
//5. Creamer Option
//6. Temperature Option

void dispense_drink() {
    //Waiting Screen
    system("DISPLAY=:0.0 pqiv -f /tmp/ &");

    lcd_writecmd(0x01); // clear
    lcd_writecmd(0x80);
    LCDprint("Dispensing...");
    lcd_writecmd(0xC0);
    LCDprint("Please Wait...");
    usleep(15000000);

    //End Screen
    system("DISPLAY=:0.0 pqiv -f /tmp/ &");

    lcd_writecmd(0x01);
    LCDprint("Enjoy :D");

    //Delay 10 Seconds
    usleep(10000000);
    home_screen();
}

void home_screen() {
	//Return to Home Screen
	system("DISPLAY=:0.0 pqiv -f /tmp/ &");
    // LCD and Keypad
	lcd_writecmd(0x01);	//clear
    lcd_writecmd(0x80);                 /* set LCD to line 1 */
	LCDprint("Choose Your Drink"); 		/* print string to LCD */
	lcd_writecmd(0xC0);					/* set LCD to line 2 */
	LCDprint("1-9 to select");			/* print string to LCD */

	//Drink Selection
	while(1)                            /* loop forever */
	{
		unsigned char i,ii;													// store keypad input and modified keypad input
		i = ScanKey();
		if (i != 0xFF)														// if key is pressed
		{
			if (i > 0x39) {
				ii = i - 0x37;
			} else {
				ii = i - 0x30;
			}

			CM3_outport(LEDPort, Bin2LED[ii]);    							// output to LED

			if (i == '1' ^ i == '2' ^ i == '3')
			{
				//Nespresso, Lipton Tea, Milo
                //Sugar Option, Creamer Option
				sugar_option();
			} 							      
			if (i == '4' ^ i == '5' ^ i == '7' ^ i == '9')
			{	
				//Cadbury, HL Milk, Ovaltine, Minute Maid
				confirmation();
			}
			if (i == '8')
			{
				//Evian Water
				//Display Temperature
				temperature_option();
			}
			if (i == '0')
			{
				//End Program
				lcd_writecmd(0x01);			/* clear screen */
				LCDprint("Goodbye...");	/* print string to LCD */
				system("killall pqiv");     /* close all instances of PQIV */
				exit(0);					/* exit program */
			}

			usleep(300000);
		}
	}
}

void confirmation(void) {
	//Confirmation Page
	system("DISPLAY=:0.0 pqiv -f /tmp/ &");
	// Confirm drink
	lcd_writecmd(0x01);	//clear
	lcd_writecmd(0x80);                
	LCDprint("1 to Confirm"); 		
	lcd_writecmd(0xC0);					
	LCDprint("0 to Cancel");
	while(1) {
		unsigned char i,ii;
		i = ScanKey();
		if (i != 0xFF)														
		{
			if (i > 0x39) {
				ii = i - 0x37;
			} else {
				ii = i - 0x30;
			}

			CM3_outport(LEDPort, Bin2LED[ii]);

			//Options
			if (i == '1') {
				// Brewing page
				dispense_drink();
			} else if (i == '0') {
				// Home screen
				home_screen();
			}
		}
	}
	
	
}

void sugar_option(void) {
	//Sugar Page
	system("DISPLAY=:0.0 pqiv -f /tmp/ &");
	//LCD
	lcd_writecmd(0x01);	//clear
	lcd_writecmd(0x80);                
	LCDprint("Select sugar option"); 		
	lcd_writecmd(0xC0);	
	LCDprint("1-3 to select, 0 to exit");
	while(1) {
		unsigned char i,ii;
		i = ScanKey();
		if (i != 0xFF)														
		{
			if (i > 0x39) {
				ii = i - 0x37;
			} else {
				ii = i - 0x30;
			}

			CM3_outport(LEDPort, Bin2LED[ii]);

			//Options
			if (i == '1') {
				//No Sugar
				creamer_option();
			} else if (i == '2') {
				//Normal amount of sugar
				creamer_option();
			} else if(i == '3') {
				//Less Sugar
				creamer_option();
			} else if(i == '0') {
				home_screen();
			}
		}
	} 			
	
}

void creamer_option(void) {
	//Creamer page
	system("DISPLAY=:0.0 pqiv -f /tmp/ &");
	//LCD
	lcd_writecmd(0x01);	//clear
	lcd_writecmd(0x80);                
	LCDprint("Select creamer option"); 		
	lcd_writecmd(0xC0);	
	LCDprint("1-2 to select, 0 to exit"); 
	
	while(1) {
		unsigned char i,ii;
		i = ScanKey();
		if (i != 0xFF)														
		{
			if (i > 0x39) {
				ii = i - 0x37;
			} else {
				ii = i - 0x30;
			}

			CM3_outport(LEDPort, Bin2LED[ii]);

			//Options
			if (i == '1') {
				//No Creamer
				confirmation();
			} else if (i == '2') {
				//Creamer
				confirmation();
			} else if(i == '0') {
				home_screen();
			}
		}
	}
	
}

void temperature_option(void) {
	//Temperature Page
	system("DISPLAY=:0.0 pqiv -f /tmp/ &");
	//LCD
	lcd_writecmd(0x01);	//clear
	lcd_writecmd(0x80);                
	LCDprint("Select temperature option"); 		
	lcd_writecmd(0xC0);	
	LCDprint("1-4 to select, 0 to exit");

	while(1) {
		unsigned char i,ii;
		i = ScanKey();
		if (i != 0xFF)														
		{
			if (i > 0x39) {
				ii = i - 0x37;
			} else {
				ii = i - 0x30;
			}

			CM3_outport(LEDPort, Bin2LED[ii]);

			//Options
			if (i == '1') {
				//Hot
				confirmation();
			} else if (i == '2') {
				//Warm
				confirmation();
			} else if(i == '3') {
				//Normal
				confirmation();
			} else if(i == '4') {
				//Cold
				confirmation();
			} else if(i == '0') {
				home_screen();
			}
		}
	}
}

//----------- LCD Functions --------------

static void initlcd(void)
{
    usleep(20000);
	lcd_writecmd(0x30);
    usleep(20000);
	lcd_writecmd(0x30);   
  	usleep(20000);
	lcd_writecmd(0x30);

	lcd_writecmd(0x02);  // 4 bit mode 
	lcd_writecmd(0x28);  // 2 line  5*7 dots
	lcd_writecmd(0x01);  //clear screen
	lcd_writecmd(0x0c);  //dis on cur off
	lcd_writecmd(0x06);  //inc cur
	lcd_writecmd(0x80);
}

static void lcd_writecmd(char cmd)
{
	char data;

	data = (cmd & 0xf0);
	CM3_outport(LCDPort, data | 0x04);
	usleep(10);
	CM3_outport(LCDPort, data);

	usleep(200);

	data = (cmd & 0x0f) << 4;
	CM3_outport(LCDPort, data | 0x04);
	usleep(10);
	CM3_outport(LCDPort, data);

	usleep(2000);
}

static void LCDprint(char *sptr)
{
	while (*sptr != 0)
	{
		int i=1;
        lcddata(*sptr);
		++sptr;
	}
}

static void lcddata(unsigned char cmd)
{

	char data;

	data = (cmd & 0xf0);
	CM3_outport(LCDPort, data | 0x05);
	usleep(10);
	CM3_outport(LCDPort, data);

	usleep(200);

	data = (cmd & 0x0f) << 4;
	CM3_outport(LCDPort, data | 0x05);
	usleep(10);
	CM3_outport(LCDPort, data);

	usleep(2000);
}

//----------- Keypad Functions ----------------

unsigned char ScanKey()
{
	CM3_outport(KbdPort, Col7Lo);
	ScanCode = CM3_inport(KbdPort);
	ScanCode |= 0x0F;
	ScanCode &= Col7Lo;
	if (ScanCode != Col7Lo)
	{
	    return ProcKey();
	}

	CM3_outport(KbdPort, Col6Lo);
	ScanCode = CM3_inport(KbdPort);
	ScanCode |= 0x0F;
	ScanCode &= Col6Lo;
	if (ScanCode != Col6Lo)
	{
	    return ProcKey();
	}

	CM3_outport(KbdPort, Col5Lo);
	ScanCode = CM3_inport(KbdPort);
	ScanCode |= 0x0F;
	ScanCode &= Col5Lo;
	if (ScanCode != Col5Lo)
	{
	    return ProcKey();
	}

	CM3_outport(KbdPort, Col4Lo);
	ScanCode = CM3_inport(KbdPort);
	ScanCode |= 0x0F;
	ScanCode &= Col4Lo;
	if (ScanCode != Col4Lo)
	{
	    return ProcKey();
	}

	return 0xFF;
}

unsigned char ProcKey()
{
	unsigned char j;
	for (j = 0 ; j <= 12 ; j++)
	if (ScanCode == ScanTable [j])
	{
	   if(j > 9) {
		   j = j + 0x37;
	   } else {
		   j = j + 0x30;
	   }
	   return j;
	}

	if (j == 12)
	{
		return 0xFF;
	}

	return (0);
}
