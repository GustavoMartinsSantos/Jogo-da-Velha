int matrix[9];
String option;
int digital_ports[18] = {13, 12, 11, 10, 9, 8,
                   		 7, 6, 5, 4, 3, 2, 
                   		 A0, A1, A2, A3, A4, A5};
int position;
bool red = true;
bool out;

void setup() {
  Serial.begin(9600);
  for(int num = 0; num < 18; num++)
  	pinMode(digital_ports[num], OUTPUT);
}

int return_port(int position, bool red) {
  if(red == true) // First degree functions
  	return 2 * position - 2;
  return 2 * position - 1;
}

void loop() {
  Serial.println("Tic Tac Toe Game");
  out = false;
  memset(matrix, 0, sizeof(matrix)); // set matrix to null
  
  for(int cont = 0; cont < 9; cont++) {    
  	for(int y = 0; y < 3; y++) {
      for(int x = 0; x < 3; x++) {
      	int positions = y*3 + x+1;
        Serial.print("|_");
        Serial.print(positions);
        Serial.print("_|");
      }
          
      Serial.println("\n");
    } // print the positions
  
  	do {
      Serial.print("Enter the position: ");
      while (Serial.available() == 0);
      position = Serial.parseInt();        
      Serial.println(position);
    } while(position <= 0 || position > 9||
           	matrix[position - 1] != 0);
    // the user gives the desired position
    
    digitalWrite( // the requested position lights up
    digital_ports[return_port(position, red)], HIGH);
    
    if(red == true)
      matrix[position-1] = 1;
    else
      matrix[position-1] = 2;

    for(int x = 0; x < 3; x++) {
		if(matrix[x] > 0 &&
           matrix[x] == matrix[x+3] &&
           matrix[x] == matrix[x+6]) {
           for(int y = 0; y < 7; y += 3)
              matrix[y/3] = return_port(x+y+1, red);
           out = true; // vertical line
        }
        
        if(matrix[x*3] > 0 &&
           matrix[x*3] == matrix[x*3+1] &&
           matrix[x*3] == matrix[x*3+2]) {
           for(int y = 0; y < 3; y++)
              matrix[y] = return_port(x*3+y+1, red);
           out = true; // horizontal line - to change
        }
    }

	if(matrix[0] > 0 && // main diagonal
       matrix[0] == matrix[4] &&
       matrix[0] == matrix[8]) {
	   for(int y = 0; y < 9; y+= 4)
         matrix[y/4] = return_port(y+1, red);
       out = true;
	}
	
	if(matrix[2] > 0 && // secondary diagonal
       matrix[2] == matrix[4] &&
       matrix[2] == matrix[6]) {
       for(int y = 2; y < 7; y += 2)
         matrix[(y/2)-1] = return_port(y+1, red);
       out = true;  
    }
	  
    if(out) { // the lights flash three times one by one
      for(int z = 0; z < 3; z++) {
      	digitalWrite(digital_ports[matrix[z]], LOW);
        delay(1000);
		digitalWrite(digital_ports[matrix[z]], HIGH);
      }
      
      Serial.println("End of the program. Thanks for playing it!!\n");
      
      delay(5000);
      
      for(int i = 0; i < 18; i++) {
		digitalWrite(digital_ports[i], LOW);
        // turn off all lights
	  }
        
      break;
    }
    
    if(red == true)
      red = false;
    else // it changes the user's turn
      red = true;
  }
}