import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class maze extends PApplet {

int x = 120, y = 120, x2 = 720, y2 = 120, mazex = 50, mazey = 50, maze2x = 650, maze2y = 50;
boolean[] key1 = {
  false, false, false, false
};
boolean[] key2 = {
  false, false, false, false
};

int player1score = 0, player2score = 0;


boolean player1 = false;
boolean player2 = false;

boolean gamestate = false;

String[] newArray;
String[][] arrayofMazes;

PImage img1, img2, img3, img4, img5, img6, img7, 
img8, img9, img10, img11, img12, img13, img14, img15;
int[][] inputArray = new int[4][4];

PFont font; 
PFont font2; 

int[]room00 = {
  0, 0
};
int[]room01 = {
  0, 1
};
int[]room02 = {
  0, 2
};
int[]room03 = {
  0, 3
};
int[]room10 = {
  1, 0
};
int[]room11 = {
  1, 1
};
int[]room12 = {
  1, 2
};
int[]room13 = {
  1, 3
};
int[]room20 = {
  2, 0
};
int[]room21 = {
  2, 1
};
int[]room22 = {
  2, 2
};
int[]room23 = {
  2, 3
};
int[]room30 = {
  3, 0
};
int[]room31 = {
  3, 1
};
int[]room32 = {
  3, 2
};
int[]room33 = {
  3, 3
};

public void initMaze()
{
  if (player1)
    player1score++;
  if (player2)
    player2score++;
  player1 = false;
  player2 = false;
  gamestate = false;
  key1 = new boolean[] {
    false, false, false, false
  };
  key2 = new boolean[] {
    false, false, false, false
  };
  x = 120; 
  y = 120; 
  x2 = 720; 
  y2 = 120; 
  mazex = 50; 
  mazey = 50; 
  maze2x = 650; 
  maze2y = 50;
  int row = (int) Math.floor(Math.random()*10);
  for (int a = 0; a < 4; a++) {
    for (int b = 0; b < 4; b++) {
      inputArray[a][b] = Integer.parseInt(arrayofMazes[row][4 * a + b ]);
    }
  }
}

public void setup()
{
  size(1200, 600);



  newArray = loadStrings("inputarray.txt");

  arrayofMazes = new String[newArray.length][16];

  for (int i = 0; i < newArray.length; i++)
  {
    arrayofMazes[i] = newArray[i].split("\t");
  }

  initMaze();

  img1 = loadImage("10001.png");
  img2 = loadImage("10010.png");
  img3 = loadImage("10100.png");
  img4 = loadImage("11000.png");
  img5 = loadImage("20011.png");
  img6 = loadImage("20101.png");
  img7 = loadImage("21001.png");
  img8 = loadImage("20110.png");
  img9 = loadImage("21010.png");
  img10 = loadImage("21100.png");
  img11 = loadImage("30111.png");
  img12 = loadImage("31110.png");
  img13 = loadImage("31011.png");
  img14 = loadImage("31101.png");
  img15 = loadImage("41111.png");

  /*  RandomLevelGenerator rnd = new RandomLevelGenerator();
   rnd.RandomLevelGenerator();
   rnd.generateMaze();
   rnd.mazeCompatibility();
   rnd.solvable();
   
   while (!rnd.mazeCompatibility () || !rnd.solvable())
   rnd.generateMaze();
   inputArray = rnd.maze;
   */
  for (int i = 0; i < inputArray.length; i++)
  {
    for (int j = 0; j < inputArray[i].length; j++)
    {
      System.out.print(inputArray[i][j]);
      System.out.print("\t");
    }
    System.out.print("\n");
  }
  font2 = createFont("Arial", 16, true);
  font = createFont("Arial", 16, true);
} 

public void draw()
{
  background(0);
  stroke(0);
  fill(255);

  if (!player1 && !player2)
  {
    textFont(font2, 25);
    textAlign(CENTER);
    text("PLAYER 1 : " + player1score, 90, 35);
    text("PLAYER 2 : " + player2score, 690, 35);
    for (int j = 0; j< inputArray.length; j++)
    {
      for (int i = 0; i< inputArray[j].length; i++)
      {
        switch(inputArray[j][i]) {

        case 11000:
          image(img4, mazex + 125 * i, mazey + 125 * j);
          break;
        case 10100:
          image(img3, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 10010:
          image(img2, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 10001:
          image(img1, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 21100:
          image(img10, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 21010:
          image(img9, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 21001:
          image(img7, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 20110:
          image(img8, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 20011:
          image(img5, mazex + 125 * i, mazey + 125 * j);
          break;
        case 20101:
          image(img6, mazex + 125 * i, mazey + 125 * j);  
          break;
        case 31110:
          image(img12, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 31101:
          image(img14, mazex + 125 * i, mazey + 125 * j);
          break;
        case 31011:
          image(img13, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 30111:
          image(img11, mazex + 125 * i, mazey + 125 * j);    
          break;
        case 41111:
          image(img15, mazex + 125 * i, mazey + 125 * j);    
          break;
        }
      }
    }

    for (int j = 0; j< inputArray.length; j++)
    {
      for (int i = 0; i< inputArray[j].length; i++)
      {
        switch(inputArray[j][i]) {

        case 11000:
          image(img4, maze2x + 125 * i, maze2y + 125 * j);
          break;
        case 10100:
          image(img3, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 10010:
          image(img2, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 10001:
          image(img1, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 21100:
          image(img10, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 21010:
          image(img9, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 21001:
          image(img7, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 20110:
          image(img8, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 20011:
          image(img5, maze2x + 125 * i, maze2y + 125 * j);
          break;
        case 20101:
          image(img6, maze2x + 125 * i, maze2y + 125 * j);  
          break;
        case 31110:
          image(img12, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 31101:
          image(img14, maze2x + 125 * i, maze2y + 125 * j);
          break;
        case 31011:
          image(img13, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 30111:
          image(img11, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        case 41111:
          image(img15, maze2x + 125 * i, maze2y + 125 * j);    
          break;
        }
      }
    }


    textFont(font, 16);
    fill(0, 255, 0);                        
    textAlign(CENTER);
    text("START", 120.0f, 120.0f);

    fill(0, 255, 0);                         
    textAlign(CENTER);
    text("GOAL", 480.0f, 480.0f);

    fill(255, 0, 0);                        
    textAlign(CENTER);
    text("START", 720.0f, 120.0f);

    fill(255, 0, 0);                         
    textAlign(CENTER);
    text("GOAL", 1080.0f, 480.0f);

    stroke(0);
    fill(0, 255, 0); 
    ellipse(x, y, 12, 12);
    fill(255, 0, 0); 
    ellipse(x2, y2, 12, 12);
  } else if (player1)
  {

    textFont(font2, 30);
    fill(255, 255, 255);
    textAlign(CENTER);
    text("Player1 has won this maze!\nPress 'R' for new maze", 600, 300);
  } else if (player2)
  {
    font2 = createFont("Arial", 16, true);
    textFont(font2, 30);
    fill(255, 255, 255);
    textAlign(CENTER);
    text("Player2 has won this maze!\nPress 'R' for new maze", 600, 300);
  }

  if (keyPressed && !gamestate)
  {
    switch(keyCode)
    {
    case UP:  
      key1[0] = true;
      break;

    case RIGHT:
      key1[1] = true;
      break;

    case DOWN:
      key1[2] = true;
      break;

    case LEFT:
      key1[3] = true;
      break;
    }
  }
  if (keyPressed && !gamestate) {

    switch(key)
    {
    case 'w': 
    case 'W':  
      key2[0] = true;
      break;

    case 'd': 
    case 'D':
      key2[1] = true;
      break;

    case 's': 
    case 'S':
      key2[2] = true;
      break;

    case 'a': 
    case 'A':
      key2[3] = true;
      break;
    }
  }

  if (keyPressed & gamestate)
  {
    if (key == 'r' || key == 'R')
      initMaze();
  }

  keyPressed1();
  keyPressed2();
}


public void keyReleased() {

  switch(keyCode)
  {
  case UP:  
    key1[0] = false;
    break;

  case RIGHT:
    key1[1] = false;
    break;

  case DOWN:
    key1[2] = false;
    break;

  case LEFT:
    key1[3] = false;
    break;
  }
  switch(key)
  {
  case 'w': 
  case 'W':  
    key2[0] = false;
    break;

  case 'd': 
  case 'D':
    key2[1] = false;
    break;

  case 's': 
  case 'S':
    key2[2] = false;
    break;

  case 'a': 
  case 'A':
    key2[3] = false;
    break;
  }
}

public void keyPressed1() {

  int[] room;
  if (x > 50 && x <= 175 && y > 50 && y <= 175) {
    room = room00;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 175 && x <= 300 && y > 50 && y <= 175) {
    room = room10;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 300 && x <= 425 && y > 50 && y <= 175) {
    room = room20;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 425 && x <= 550 && y > 50 && y <= 175) {
    room = room30;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 50 && x <= 175 && y > 175 && y <= 300) {
    room = room01;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 175 && x <= 300 && y > 175 && y <= 300) {
    room = room11;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 300 && x <= 425 && y > 175 && y <= 300) {
    room = room21;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 425 && x <= 550 && y > 175 && y <= 300) {
    room = room31;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 50 && x <= 175 && y > 300 && y <= 425) {
    room = room02;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 175 && x <= 300 && y > 300 && y <= 425) {
    room = room12;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 300 && x <= 425 && y > 300 && y <= 425) {
    room = room22;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 425 && x <= 550 && y > 300 && y <= 425) {
    room = room32;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 50 && x <= 175 && y > 425 && y <= 550) {
    room = room03;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 175 && x <= 300 && y > 425 && y <= 550) {
    room = room13;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 300 && x <= 425 && y > 425 && y <= 550) {
    room = room23;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  } else if (x > 425 && x <= 550 && y > 425 && y <= 550) {
    room = room33;
    player1 = true;
    gamestate = true;
    //print(room[0] + " " + room[1]);
    checkRoomNumber(room);
  }
}

public void checkRoomNumber(int[] room)
{
  switch(inputArray[room[1]][room[0]]) {
  case 11000:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if (x - 4 > 50 + room[0] * 125)
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if (y + 4 <= 175 + room[1] * 125)
        y = y + 4;
    }

    break;
  case 10100:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {
      if (x - 4 > 50 + 125 * room[0])
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + 125 * room[1])
        y = y - 4;
    }  
    if (key1[2]) {
      if (y + 4 <= 175 + 125 * room[1])
        y = y + 4;
    }
    break;
  case 10010:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if (x - 4 > 50 + room[0] * 125)
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + room[1] * 125)
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 10001:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + 125 * room[1])
        y = y - 4;
    }
    if (key1[2]) {
      if (y + 4 <= 175 + 125 * room[1])
        y = y + 4;
    }
    break;
  case 21100:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {
      if (x - 4 > 50 + room[0] * 125)
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if (y + 4 <= 175 + 125 * room[1])
        y = y + 4;
    }
    break;
  case 21010:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if (x - 4 > 50 + room[0] * 125)
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 21001:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if (y + 4 <= 175 + 125 * room[1])
        y = y + 4;
    }
    break;
  case 20110:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {
      if (x - 4 > 50 + room[0] * 125)
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + 125 * room[1])
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 20011:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + 125 * room[1])
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 20101:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + 125 * room[1])
        y = y - 4;
    }
    if (key1[2]) {
      if (y + 4 <= 175 + 125 * room[1])
        y = y + 4;
    }
    break;
  case 31110:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {      
      if (x - 4 > 50 + room[0] * 125)
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 31101:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {  
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if (y + 4 <= 175 + 125 * room[1])
        y = y + 4;
    }
    break;
  case 31011:
    if (key1[1]) {
      if (x + 4 <= 175 + room[0] * 125)
        x = x + 4;
    }
    if (key1[3]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 30111:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {  
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if (y - 4 > 50 + 125 * room[1])
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  case 41111:
    if (key1[1]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x + 4 <= 175 + room[0] * 125)
          x = x + 4;
      } else
        x = x + 4;
    }
    if (key1[3]) {
      if ((y > 50 + 125 * room[1] && y < 100 + 125 * room[1]) || (y > 120 + 125 * room[1] && y <= 175 + 125 * room[1]))
      {
        if (x - 4 > 50 + 125 * room[0])
          x = x - 4;
      } else
        x = x - 4;
    }
    if (key1[0]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y - 4 > 50 + room[1] * 125)
          y = y - 4;
      } else
        y = y - 4;
    }
    if (key1[2]) {
      if ((x > 50 + 125 * room[0] && x < 100 + 125 * room[0]) || (x > 120 + 125 * room[0] && x <= 175 + 125 * room[0]))
      {
        if (y + 4 <= 175 + room[1] * 125)
          y = y + 4;
      } else
        y = y + 4;
    }
    break;
  }
}

public void keyPressed2() {

  int[] room;
  if (x2 > 650 && x2 <= 775 && y2 > 50 && y2 <= 175) {
    room = room00;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 775 && x2 <= 900 && y2 > 50 && y2 <= 175) {
    room = room10;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 900 && x2 <= 1025 && y2 > 50 && y2 <= 175) {
    room = room20;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 1025 && x2 <= 1150 && y2 > 50 && y2 <= 175) {
    room = room30;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 650 && x2 <= 775 && y2 > 175 && y2 <= 300) {
    room = room01;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 775 && x2 <= 900 && y2 > 175 && y2 <= 300) {
    room = room11;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 900 && x2 <= 1025 && y2 > 175 && y2 <= 300) {
    room = room21;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 1025 && x2 <= 1150 && y2 > 175 && y2 <= 300) {
    room = room31;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 650 && x2 <= 775 && y2 > 300 && y2 <= 425) {
    room = room02;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 775 && x2 <= 900 && y2 > 300 && y2 <= 425) {
    room = room12;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 900 && x2 <= 1025 && y2 > 300 && y2 <= 425) {
    room = room22;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 1025 && x2 <= 1150 && y2 > 300 && y2 <= 425) {
    room = room32;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 650 && x2 <= 775 && y2 > 425 && y2 <= 550) {
    room = room03;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 775 && x2 <= 900 && y2 > 425 && y2 <= 550) {
    room = room13;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 900 && x2 <= 1025 && y2 > 425 && y2 <= 550) {
    room = room23;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  } else if (x2 > 1025 && x2 <= 1150 && y2 > 425 && y2 <= 550) {
    room = room33;
    player2 = true;
    gamestate = true;
    //print(room[0] + " " + room[1]);
    checkRoomNumber2(room);
  }
}

public void checkRoomNumber2(int[] room)
{
  switch(inputArray[room[1]][room[0]]) {
  case 11000:
    if (key2[1]) {
      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }
    if (key2[3]) {
      if (x2 - 4 > 650 + room[0] * 125)
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }    
    if (key2[2]) {
      if (y2 + 4 <= 175 + room[1] * 125)
        y2 = y2 + 4;
    }
    break;
  case 10100:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if (x2 - 4 > 650 + 125 * room[0])
        x2 = x2 - 4;
    }  
    if (key2[0]) {
      if (y2 - 4 > 50 + 125 * room[1])
        y2 = y2 - 4;
    }  
    if (key2[2]) {
      if (y2 + 4 <= 175 + 125 * room[1])
        y2 = y2 + 4;
    }
    break;
  case 10010:
    if (key2[1]) {
      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if (x2 - 4 > 650 + room[0] * 125)
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if (y2 - 4 > 50 + room[1] * 125)
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 10001:
    if (key2[1]) {

      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if (y2 - 4 > 50 + 125 * room[1])
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if (y2 + 4 <= 175 + 125 * room[1])
        y2 = y2 + 4;
    }
    break;
  case 21100:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if (x2 - 4 > 650 + room[0] * 125)
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if (y2 + 4 <= 175 + 125 * room[1])
        y2 = y2 + 4;
    }
    break;
  case 21010:
    if (key2[1]) {
      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if (x2 - 4 > 650 + room[0] * 125)
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 21001:
    if (key2[1]) {

      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if (y2 + 4 <= 175 + 125 * room[1])
        y2 = y2 + 4;
    }
    break;
  case 20110:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if (x2 - 4 > 650 + room[0] * 125)
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if (y2 - 4 > 50 + 125 * room[1])
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 20011:
    if (key2[1]) {
      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if (y2 - 4 > 50 + 125 * room[1])
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 20101:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }        
    if (key2[0]) {

      if (y2 - 4 > 50 + 125 * room[1])
        y2 = y2 - 4;
    }  
    if (key2[2]) {
      if (y2 + 4 <= 175 + 125 * room[1])
        y2 = y2 + 4;
    }
    break;
  case 31110:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if (x2 - 4 > 650 + room[0] * 125)
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 31101:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if (y2 + 4 <= 175 + 125 * room[1])
        y2 = y2 + 4;
    }
    break;
  case 31011:
    if (key2[1]) {
      if (x2 + 4 <= 775 + room[0] * 125)
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 30111:
    if (key2[1]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if (y2 - 4 > 50 + 125 * room[1])
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  case 41111:
    if (key2[1]) {

      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 + 4 <= 775 + room[0] * 125)
          x2 = x2 + 4;
      } else
        x2 = x2 + 4;
    }    
    if (key2[3]) {
      if ((y2 > 50 + 125 * room[1] && y2 < 100 + 125 * room[1]) || (y2 > 120 + 125 * room[1] && y2 <= 175 + 125 * room[1]))
      {
        if (x2 - 4 > 650 + 125 * room[0])
          x2 = x2 - 4;
      } else
        x2 = x2 - 4;
    }
    if (key2[0]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 - 4 > 50 + room[1] * 125)
          y2 = y2 - 4;
      } else
        y2 = y2 - 4;
    }
    if (key2[2]) {
      if ((x2 > 650 + 125 * room[0] && x2 < 700 + 125 * room[0]) || (x2 > 720 + 125 * room[0] && x2 <= 775 + 125 * room[0]))
      {
        if (y2 + 4 <= 175 + room[1] * 125)
          y2 = y2 + 4;
      } else
        y2 = y2 + 4;
    }
    break;
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "maze" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
