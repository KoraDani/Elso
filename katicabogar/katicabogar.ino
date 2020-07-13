//ütés szenzor
int utes = 4;

//fény követés
  int olvas;
  int olvas2;
  int olvas3;

//hőmérséklet
#include "DHT.h"
#define DHTPIN 5
#define DHTTYPE DHT11 
DHT dht(DHTPIN, DHTTYPE);

//ultrahangos távolságérzékelő
const int trig = 2;
const int echo = 3;
long duration;
int distance;

#include <Wire.h>
// fény érzékelő
#include <BH1750.h>
BH1750 lightMeter;

//motor beállítás
const int motorenaA = 13;
const int motor11 = 12;
const int motor12 = 11;

const int motorenaB = 10;
const int motor21 = 9;
const int motor22 = 8;

bool motorbeki = true;

void setup() {
  Serial.begin(9600);
  Wire.begin();

//fény érzékel beállításai
  lightMeter.begin();
  Serial.println("Running...");

//motorok beállítása
pinMode(motorenaA, OUTPUT);
pinMode(motorenaB, OUTPUT);
pinMode(motor11, OUTPUT);
pinMode(motor12, OUTPUT);
pinMode(motor21, OUTPUT);
pinMode(motor22, OUTPUT);


//ulatrahangos beállítások
pinMode(trig,OUTPUT);
pinMode(echo,INPUT);
// hőmérséklet
dht.begin();

//ütés beállítás
pinMode(utes, INPUT);
}

void loop() {
analogWrite(motorenaA, 255);
analogWrite(motorenaB, 255);
//----------------------------------------------------------------------------------------------------------------------
    //fotoellenállás
    olvas = analogRead(A0);
    //Serial.println(olvas);
   olvas2 = analogRead(A1);
   //Serial.println(olvas2);    
   olvas3 = analogRead(A2);
   //Serial.println(olvas3);
  //delay(500);
  if(olvas > 900 && motorbeki){
     digitalWrite(motor11 ,LOW);
     digitalWrite(motor12 ,LOW);
     digitalWrite(motor21 ,HIGH);
     digitalWrite(motor22 ,LOW);
     Serial.println("Jobbra");
    }
  if(olvas3 > 900 && motorbeki){
     digitalWrite(motor11 ,LOW);
     digitalWrite(motor12 ,HIGH);
     digitalWrite(motor21 ,LOW);
     digitalWrite(motor22 ,LOW); 
     Serial.println("Balra");
    }
---------------------------------hiba-----------------------------------
    if(olvas2 > 900 && motorbeki){
     digitalWrite(motor11 ,LOW);
     digitalWrite(motor12 ,HIGH);
     digitalWrite(motor21 ,LOW);
     digitalWrite(motor22 ,HIGH);
     Serial.println("Előre");
      }
---------------------------------hiba-----------------------------------
    else{
     digitalWrite(motor11 ,LOW);
     digitalWrite(motor12 ,LOW);
     digitalWrite(motor21 ,LOW);
     digitalWrite(motor22 ,LOW);
      }
//----------------------------------------------------------------------------------------------------------------------
      //fény mennyiség
      uint16_t lux = lightMeter.readLightLevel(true);
      //Serial.print("Light: ");
      //Serial.println(lux);
      //Serial.println(" lx");
      delay(33);
      if(lux< 20){
          digitalWrite(motor11 ,LOW);
          digitalWrite(motor12 ,LOW);
          digitalWrite(motor21 ,LOW);
          digitalWrite(motor22 ,LOW);
          Serial.println("Alszik");
          motorbeki = false;
        }
        else{
          motorbeki = true;
          }
//----------------------------------------------------------------------------------------------------------------------
    //hőmérséklet
    float t = dht.readTemperature();
    //Serial.println(t);
//----------------------------------------------------------------------------------------------------------------------
    //ultrahangos távolságmérés
    digitalWrite(trig, LOW);
    delayMicroseconds(2);
    
    digitalWrite(trig, HIGH);
    delayMicroseconds(10);
    digitalWrite(trig, LOW);
    
    duration = pulseIn(echo, HIGH);
    
    distance= duration*0.034/2;
    
    //Serial.print("Distance: ");
    //Serial.println(distance);
    
---------------------------------hiba-----------------------------------
        if(distance < 10 && motorbeki){
           digitalWrite(motor11 ,HIGH);
           digitalWrite(motor12 ,LOW);
           digitalWrite(motor21 ,HIGH);
           digitalWrite(motor22 ,LOW);
            Serial.println("Hátra");
        }else{
            digitalWrite(motor11 ,LOW);
            digitalWrite(motor12 ,LOW);
            digitalWrite(motor21 ,LOW);
            digitalWrite(motor22 ,LOW);
        }
---------------------------------hiba-----------------------------------
//----------------------------------------------------------------------------------------------------------------------
    //ütés mérés
    float erzekel = analogRead(A3);
    //Serial.println(erzekel);
}
