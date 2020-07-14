//#include <RTClib.h>

#include <TM1637Display.h>

#include <TimeLib.h>

#include <ThreeWire.h>  
#include <RtcDS1302.h>

#define CLK 7
#define DIO 8

ThreeWire myWire(5,4,6); // clk= 4 dat= 5 rst = 6
RtcDS1302<ThreeWire> Rtc(myWire);

TM1637Display display = TM1637Display(CLK, DIO);

int relay = 9;

int red_light_pin= 10;
int green_light_pin = 11;
int blue_light_pin = 12;

const int szenzor = A0;
const int szenzor2 = A1;

int szenzorertek = 0;
int szazalekertek = 0;

int szenzorertek2 = 0;
int szazalekertek2 = 0;

const int tranzisztor = 13;

const int hatora = 6* 3600000;

int magasalacsony = 1;

//int ido2 = setTime(9,1,0,0,6,2020);

int ora;
int perc;
int masodperc;

void setup() {
Serial.begin(9600);

    Serial.print("compiled: ");
    Serial.print(__DATE__);
    Serial.println(__TIME__);

    Rtc.Begin();
    RtcDateTime compiled = RtcDateTime(__DATE__, __TIME__);
   printDateTime(compiled);
    Serial.println();

    if (!Rtc.IsDateTimeValid()) {
        // Common Causes: 1) first time you ran and the device wasn't running yet 2) the battery on the device is low or even missing
        Serial.println("RTC lost confidence in the DateTime!");
        Rtc.SetDateTime(compiled);
    }

    if (Rtc.GetIsWriteProtected()) {
        Serial.println("RTC was write protected, enabling writing now");
        Rtc.SetIsWriteProtected(false);
    }

    if (!Rtc.GetIsRunning()) {
        Serial.println("RTC was not actively running, starting now");
        Rtc.SetIsRunning(true);
    }

    RtcDateTime now = Rtc.GetDateTime();
    if (now < compiled) {
        Serial.println("RTC is older than compile time!  (Updating DateTime)");
        Rtc.SetDateTime(compiled);
    }
    else if (now > compiled)
        Serial.println("RTC is newer than compile time. (this is expected)");
    else
        Serial.println("RTC is the same as compile time! (not expected but all is fine)");

  
  pinMode(red_light_pin, OUTPUT);
  pinMode(green_light_pin, OUTPUT);
  pinMode(blue_light_pin, OUTPUT);

  pinMode(tranzisztor,OUTPUT);

  pinMode(relay,OUTPUT);


  digitalWrite(tranzisztor, HIGH);
  delay(200);
  szenzorertek = analogRead(szenzor);
  szazalekertek = map(szenzorertek, 1023, 300, 0, 100);
  szenzorertek2 = analogRead(szenzor2);
  szazalekertek2 = map(szenzorertek2, 1023, 300, 0, 100);
  delay(200);
  digitalWrite(tranzisztor, LOW);

  display.setBrightness(5);
  display.clear();
}
void loop() {

  
    RtcDateTime now = Rtc.GetDateTime();
   printDateTime(now);
  Serial.println();
    
  if(perc == 30){
  digitalWrite(tranzisztor, HIGH);
  //delay(2000);
  szenzorertek = analogRead(szenzor);
  szazalekertek = map(szenzorertek, 1023, 300, 0, 100);
  szenzorertek2 = analogRead(szenzor2);
  szazalekertek2 = map(szenzorertek2, 1023, 300, 0, 100);
  //delay(2000);
  digitalWrite(tranzisztor, LOW);

  }

  if(szazalekertek>= 75 || szazalekertek2 >= 75){
    RGB_color(0, 0, 255); // Blue
    }
  if(szazalekertek < 75 && szazalekertek >50 || szazalekertek2< 75 && szazalekertek2 >50){
      RGB_color(0, 255, 0); // Green
    }
  if(szazalekertek <= 50 && szazalekertek >25 || szazalekertek2 <= 50 && szazalekertek2 >25){
        RGB_color(255, 255, 0); // Yellow
    }
  if(szazalekertek <= 25 && szazalekertek >=1 || szazalekertek2 <= 25 && szazalekertek2 >=1){
        RGB_color(255, 0, 0); // Red
    }
  if(szazalekertek == 0 || szazalekertek2 == 0){
      RGB_color(255,0, 0); // Red
    }
if(ora % 4 == 0){
  magasalacsony = 0;
  }
  if(ora % 8 == 0){
  magasalacsony = 1;
  }

    digitalWrite(relay,magasalacsony);
    Serial.println(szazalekertek);
    Serial.println(szazalekertek2);

delay(1000);

}
void RGB_color(int red_light_value, int green_light_value, int blue_light_value)
 {
  analogWrite(red_light_pin, red_light_value);
  analogWrite(green_light_pin, green_light_value);
  analogWrite(blue_light_pin, blue_light_value);
}
#define countof(a) (sizeof(a) / sizeof(a[0]))
void printDateTime(const RtcDateTime& dt) {
    char datestring[20];
    snprintf_P(datestring, 
            countof(datestring),
            PSTR("%02u/%02u/%04u %02u:%02u:%02u"),
            dt.Month(), dt.Day(), dt.Year(),
            dt.Hour(), dt.Minute(), dt.Second() );

            ora = dt.Hour();
            perc = dt.Minute();
    //Serial.print(datestring);

      int displaytime = (dt.Hour() * 100) + dt.Minute();
  // Print displaytime to the Serial Monitor:
  Serial.println(displaytime);
  // Display the current time in 24 hour format with leading zeros enabled and a center colon:
  display.showNumberDecEx(displaytime, 0b11100000, true);
  // Remove the following lines of code if you want a static instead of a blinking center colon:
  display.showNumberDec(displaytime, true); // Prints displaytime without center colon.
}
