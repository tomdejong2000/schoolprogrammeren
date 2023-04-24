#include <stdio.h>
#include <ctype.h>
#include "lenaArray.h"

//functions die in dit programma gebruikt worden

int avg();

int printPicture();
int printReverse();

int main(){

    //infinite loop die na elke funtie opnieuw vraagt of je een functie wilt uitvoeren
    for (; ;){  
        //geeft de opties in een printf
        printf("kies 1 voor grote print, kies 2 voor kleine print, kies 3 voor spiegel print \n");  
        printf("kies 4 voor grote gemiddelde grijswaarde, kies 5 voor kleine gemiddelde grijswaarde \n");
        //input welke funtie je wilt uitvoeren
        int answer;
        scanf("%d", &answer);
        //functie uitvoeren op basis van de input
        if(answer == 1){
            printPicture(0, 511, 0, 511); //print de foto uit van 0 tot 511
        }else if(answer == 2){
            printPicture(100, 400, 100, 400); //print de foto uit van 100 to 400
        }else if(answer == 3){
            printReverse();
        }else if(answer == 4){
            avg(0, 511, 0, 511); //bereken de gemiddelde grijswaarde van de hele 2d array
        }else if(answer == 5){
            avg(100, 400, 100, 400); //bereken de gemiddelde grijswaarde van 100 tot en met 400
        }else{
            //als er geen getal tussen 1 en 5 word gegeven zeg dat het geen goeie input is en close programma
            printf("dit is geen valid input \n");
            break;
        }
    }


    return 0;

}

int avg(int ystart, int yend, int xstart, int xend){

    int sum = 0;
    //loop door de 2d array en tel alles bij elkaar op 
    for(int y = ystart; y <= yend; y++){
        for(int x = xstart; x <= xend; x++){
            sum = sum + lena[y][x];
        }
    }
    int a = yend - ystart; //krijg het totaal aantal getallen per lijn
    int b = xend - xstart;
    int c = a * b; //krijg totaal aantal getallen
    int avg = sum / c; //deel de som van alle getallen door het aantal getallen in de array
    
    printf("gemiddelde grijswaarde van grote is %d \n", avg); //print het gemiddelde   
    
}
        


int printPicture(int ystart, int yend, int xstart, int xend){
    
    char grey[] = {' ','.',':','-','=','+','*','#','%','@'}; //array met alle grijs waardes

    for(int y = ystart; y <= yend; y++){    //loop door de 2d array
        for(int x = xstart; x <= xend; x++){
            
            int output = lena[y][x]/27.5;  //deel de grijswaarde die uit de 2d array komt door 27.5 om een getal van 0 tot 9 te krijgen
            printf("%c", grey[output]);     //print een char uit de array uit met het getal dat we uit de vorige deel som hebben gekregen
        
        
            if(x == xend ){     //als we aan het einde van de horizonale as zitten ga naar de volgende line
                printf("\n");
            }
        }
    }
}


int printReverse(){

    //zelfde als print function behalve dat de x begint op 400 en eindigt op 100
    char grey[] = {' ','.',':','-','=','+','*','#','%','@'};

    for(int y = 100; y <= 400; y++ ){
        for(int x = 400; x >= 100; x--){
 
            int output = lena[y][x]/27.5;
            printf("%c", grey[output]);
        
            if(x == 100){           //als x 100 is ga naar volgende line
                printf("\n");
            }
        }
    }
}