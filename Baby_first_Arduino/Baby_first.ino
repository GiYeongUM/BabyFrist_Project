#include <SoftwareSerial.h>
#include <DFPlayer_Mini_Mp3.h>
SoftwareSerial BTSerial(2, 3);
SoftwareSerial Mp3Serial(6,7);

int Green = 5;
int Red = 8;  

void setup() {
  Mp3Serial.begin (9600);
  BTSerial.begin(9600);
  mp3_set_serial (Mp3Serial);
  
  delay(10);
  mp3_set_volume (15);
  delay(10);
  
  pinMode(Green, OUTPUT);
  pinMode(Red, OUTPUT); 
  digitalWrite(Red, HIGH);
}

void loop() {
  if(BTSerial.available()){
    char bt;   
    bt = BTSerial.read();
    if(bt == 'G'){                
      digitalWrite(Green, HIGH);
      digitalWrite(Red, LOW);
      delay(100);
    }
   else if(bt == 'R'){
      digitalWrite(Green, LOW);
      digitalWrite(Red, HIGH);
      delay(100);
   }
   else if(bt == 'B'){
      digitalWrite(Green, LOW);
      digitalWrite(Red, HIGH);
      delay(100);
    }
    else if(bt == 'P'){
      digitalWrite(Green, LOW);
      digitalWrite(Red, LOW);
      delay(100);
    }
    else if(bt == 'S'){
        mp3_play(3);
        delay (20000);
        mp3_stop();
    }
  }  
}
