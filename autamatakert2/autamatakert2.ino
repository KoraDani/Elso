#include <TimeLib.h>

int relay = 9;

int red_light_pin= 12;
int green_light_pin = 11;
int blue_light_pin = 10;

const int szenzor = A0;
int szenzorertek = 0;
int szazalekertek = 0;

const int tranzisztor = 13;

const int hatora = 6* 3600000;

int magasalacsony = 1;

int ora = hour();

void setup() {
  pinMode(red_light_pin, OUTPUT);
  pinMode(green_light_pin, OUTPUT);
  pinMode(blue_light_pin, OUTPUT);

  pinMode(tranzisztor,OUTPUT);

  pinMode(relay,OUTPUT);

  Serial.begin(9600);

  digitalWrite(tranzisztor, HIGH);
  delay(200);
  szenzorertek = analogRead(szenzor);
  szazalekertek = map(szenzorertek, 1023, 300, 0, 100);
  delay(200);
  digitalWrite(tranzisztor, LOW);
}
void loop() {
unsigned long ido = millis();
  
  if(ora% 2 == 0){
  digitalWrite(tranzisztor, HIGH);
  delay(2000);
  szenzorertek = analogRead(szenzor);
  szazalekertek = map(szenzorertek, 1023, 300, 0, 100);
  delay(2000);
  digitalWrite(tranzisztor, LOW);

  }

  if(szazalekertek>= 75){
    RGB_color(0, 0, 255); // Blue
    }
  if(szazalekertek< 75 && szazalekertek >50){
      RGB_color(0, 255, 0); // Green
    }
  if(szazalekertek<= 50 && szazalekertek >25){
        RGB_color(255, 255, 0); // Yellow
    }
  if(szazalekertek<= 25 && szazalekertek >=1){
        RGB_color(255, 0, 0); // Red
    }
  if(szazalekertek == 0){
      RGB_color(255,0, 0); // Red
  delay(500);
    }
if(ora % 4 == 0){
  magasalacsony = 0;
  }
  if(ora % 8 == 0){
  magasalacsony = 1;
  }

    digitalWrite(relay,magasalacsony);

    Serial.println(ora);
    Serial.println(szazalekertek);
}
void RGB_color(int red_light_value, int green_light_value, int blue_light_value)
 {
  analogWrite(red_light_pin, red_light_value);
  analogWrite(green_light_pin, green_light_value);
  analogWrite(blue_light_pin, blue_light_value);
}
