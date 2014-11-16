int x = 120, y = 120, mazex = 50, mazey = 50;

PImage img1, img2, img3, img4, img5, img6, img7, 
img8, img9, img10, img11, img12, img13, img14, img15;
int[][] inputArray;

//int[] room00, room01, room02, room03, room10, room11, 
//room12, room13, room20, room21, room22, room23, 
//room30, room31, room32, room33;

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
int[] room33 = {
  3, 3
};

void setup()
{
  size(600, 600);

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

  RandomLevelGenerator rnd = new RandomLevelGenerator();
  rnd.RandomLevelGenerator();
  rnd.generateMaze();
  rnd.mazeCompatibility();
  rnd.solvable();

  while (!rnd.mazeCompatibility () || !rnd.solvable())
    rnd.generateMaze();
  inputArray = rnd.maze;

  MazeDisplay display = new MazeDisplay();
  ArrayList<ArrayList<Integer>> parsedArray = display.parsedArray(inputArray);

  for (int i = 0; i < inputArray.length; i++)
  {
    for (int j = 0; j < inputArray[i].length; j++)
    {
      System.out.print(inputArray[i][j]);
      System.out.print("\t");
    }
    System.out.print("\n");
  }

  /* for (ArrayList<Integer> element : parsedArray)
   {
   print(element.get(0));
   print("\n");
   print(element.get(1));
   print("\n");
   print(element.get(2));
   print("\n");
   print(element.get(3));
   print("\n");
   print(element.get(4));
   print("\n");
   }
   */
}

void draw()
{
  background(0);
  //size(800, 800);

  stroke(0);
  fill(255);

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




  stroke(0);
  fill(0, 255, 0); 
  ellipse(x, y, 12, 12);
}

void keyPressed()
{
  if (keyCode == UP)
  {
    y=y-8;
  }

  if (keyCode == DOWN)
  {
    y=y+8;
  }

  if (keyCode == LEFT) 
  {
    collisionDetection();
  }

  if (keyCode == RIGHT)
  {
    collisionDetection();
  }
}

void collisionDetection() {

  int[] room;
  if (x > 50 && x < 175 && y > 50 && y < 175) {
    room = room00;
    checkRoomNumber(room);
  }
  else if (x >= 175 && x < 300 && y > 50 && y < 175) {
    room = room01;
    checkRoomNumber(room);
  }
   else if (x >=300 && x < 425 && y > 50 && y < 175) {
    room = room02;
    checkRoomNumber(room);
  }
    if (x >= 425 && x < 550 && y > 50 && y < 175) {
    room = room03;
    checkRoomNumber(room);
  }
    if (x > 50 && x < 175 && y >= 175 && y < 300) {
    room = room10;
    checkRoomNumber(room);
  }
    if (x >= 175 && x < 300 && y >= 175 && y < 300) {
    room = room11;
    checkRoomNumber(room);
  }
    if (x >= 300 && x < 425 && y >= 175 && y < 300) {
    room = room12;
    checkRoomNumber(room);
  }
    if (x >=425 && x < 550 && y >= 175 && y < 300) {
    room = room13;
    checkRoomNumber(room);
  }
    if (x > 50 && x < 175 && y >=300 && y < 425) {
    room = room20;
    checkRoomNumber(room);
  }
    if (x >=175 && x < 300 && y >=300 && y < 425) {
    room = room21;
    checkRoomNumber(room);
  }
    if (x >=300 && x < 425 && y >=300 && y < 425) {
    room = room22;
    checkRoomNumber(room);
  }
    if (x >=425 && x < 550 && y >=300 && y < 425) {
    room = room23;
    checkRoomNumber(room);
  }
    if (x > 50 && x < 175 && y >= 425 && y < 550) {
    room = room30;
    checkRoomNumber(room);
  }
    if (x >=175 && x < 300 && y >= 425 && y < 550) {
    room = room31;
    checkRoomNumber(room);
  }
    if (x >=300 && x < 425 && y >= 425 && y < 550) {
    room = room32;
    checkRoomNumber(room);
  }
    if (x >=425 && x < 550 && y >= 425 && y < 550) {
    room = room33;
    checkRoomNumber(room);
  }
}

void checkRoomNumber(int[] room)
{
  switch(inputArray[room[0]][room[1]]) {
  case 11000:
//    image(img4, mazex + 125 * i, mazey + 125 * j);
    break;
  case 10100:
    if (keyCode == RIGHT) {
      x = x + 8;
    } else if (keyCode == LEFT)
    {
      if (x - 8 > 50)
        x = x - 8;
    }

    break;
  case 10010:
  //  image(img2, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 10001:
    //image(img1, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 21100:
   // image(img10, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 21010:
    //image(img9, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 21001:
    //image(img7, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 20110:
    if (keyCode == RIGHT) {
      x = x + 8;
    } else if (keyCode == LEFT)
    {
      if (x - 8 > 50)
        x = x - 8;
    }    
    break;
  case 20011:
    //image(img5, mazex + 125 * i, mazey + 125 * j);
    break;
  case 20101:
   // image(img6, mazex + 125 * i, mazey + 125 * j);  
    break;
  case 31110:
    //image(img12, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 31101:
    //image(img14, mazex + 125 * i, mazey + 125 * j);
    break;
  case 31011:
    //image(img13, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 30111:
    //image(img11, mazex + 125 * i, mazey + 125 * j);    
    break;
  case 41111:
    //image(img15, mazex + 125 * i, mazey + 125 * j);    
    break;
  }
}
