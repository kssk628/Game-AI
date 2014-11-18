/**
 * Created by Karthik on 11/14/2014.
 */

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.Random;
import java.util.HashMap;

public class RandomLevelGenerator {
    private int level;
    public int[][] maze;

    private int[] X1Y1 = {10100, 10010, 20110};
    private int[] X10Y1 = {11000, 10100, 21100};
    private int[] XY1 = {11000, 10100, 10010, 21100, 21010, 20110, 31110};
    private int[] X1Y10 = {10010, 10001, 20011};
    private int[] X10Y10 = {11000, 10001, 21001};
    private int[] XY10 = {11000, 10010, 10001, 21010, 21001, 20011, 31011};
    private int[] X1Y = {10100, 10010, 10001, 20110, 20011, 20101, 30111};
    private int[] X10Y = {11000, 10100, 10001, 21100, 21001, 20101, 31101};
    private int[] XY = {11000, 10100, 10010, 10001, 21100, 21010, 21001, 20110, 20011, 20101, 31110, 31101, 31011, 30111, 41111};

    private int[] oneNorth = {10010,21010,20110,20011,31110,31011,30111,41111};
    private int[] oneEast = {10001,21001,20101,20011,31101,31011,30111,41111};
    private int[] oneSouth = {11000,21010,21001,21100,31110,31011,31101,41111};
    private int[] oneWest = {10100,21100,20110,20101,31110,31101,30111,41111};

    Random randomGenerator = new Random();

    private boolean member(int elem, int[] arr)
    {
        boolean found = false;
        for (int x = 0; x < arr.length; x++)
        {
            if (arr[x] == elem)
            {
                found = true;
                break;
            }
        }

        return found;
    }

    public static void main(String[]args)
    {
        RandomLevelGenerator rnd = new RandomLevelGenerator();
        rnd.RandomLevelGenerator();
        rnd.generateMaze();
        rnd.mazeCompatibility();
        rnd.solvable();

        while (!rnd.mazeCompatibility() || !rnd.solvable())
            rnd.generateMaze();

        int[][] maze_now = rnd.maze;
        for (int i = 0; i < maze_now.length; i++)
        {
            for (int j = 0; j < maze_now[i].length; j++)
            {
                System.out.print(maze_now[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }

        System.out.println(rnd.mazeCompatibility() + "\t" + rnd.solvable());
    }

    public void RandomLevelGenerator()
    {
        level = 4;
        maze = new int[level][level];
    }

    public void generateMaze()
    {
        for (int x = 0; x < level; x++)
        {
            for (int y = 0; y < level; y++)
            {
                if (x == 0)
                {
                    if (y == 0) {
                        maze[x][y] = X1Y1[randomGenerator.nextInt(X1Y1.length)];
                    }
                    else if (y == level - 1)
                        maze[x][y] = X1Y10[randomGenerator.nextInt(X1Y10.length)];
                    else
                        maze[x][y] = X1Y[randomGenerator.nextInt(X1Y.length)];
                }
                else if (x == level - 1)
                {
                    if (y == 0)
                        maze[x][y] = X10Y1[randomGenerator.nextInt(X10Y1.length)];
                    else if (y == level - 1)
                        maze[x][y] = X10Y10[randomGenerator.nextInt(X10Y10.length)];
                    else
                        maze[x][y] = X10Y[randomGenerator.nextInt(X10Y.length)];
                }
                else
                {
                    if (y == 0)
                        maze[x][y] = XY1[randomGenerator.nextInt(XY1.length)];
                    else if (y == level - 1)
                        maze[x][y] = XY10[randomGenerator.nextInt(XY10.length)];
                    else
                        maze[x][y] = XY[randomGenerator.nextInt(XY.length)];
                }

            }
        }
        //System.out.println(maze.length);
        /*for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                System.out.print(maze[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }*/
    }

    public boolean mazeCompatibility()
    {
        boolean compatible = true;

        for (int x = 0; x < level; x++)
        {
            for (int y = 0; y < level; y++)
            {
                switch (maze[x][y])
                {
                    case 11000:
                        compatible &= member(maze[x-1][y],oneNorth);
                        break;
                    case 10100:
                        compatible &= member(maze[x][y+1],oneEast);
                        break;
                    case 10010:
                        compatible &= member(maze[x+1][y],oneSouth);
                        break;
                    case 10001:
                        compatible &= member(maze[x][y-1],oneWest);
                        break;
                    case 21100:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x][y+1],oneEast);
                        break;
                    case 21010:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x+1][y],oneSouth);
                        break;
                    case 21001:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x][y-1],oneWest);
                        break;
                    case 20110:
                        compatible &= member(maze[x][y+1],oneEast) && member(maze[x+1][y],oneSouth);
                        break;
                    case 20011:
                        compatible &= member(maze[x+1][y],oneSouth) && member(maze[x][y-1],oneWest);
                        break;
                    case 20101:
                        compatible &= member(maze[x][y+1],oneEast) && member(maze[x][y-1],oneWest);
                        break;
                    case 31110:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x][y+1],oneEast) && member(maze[x+1][y],oneSouth);
                        break;
                    case 31101:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x][y+1],oneEast) && member(maze[x][y-1],oneWest);
                        break;
                    case 31011:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x+1][y],oneSouth) && member(maze[x][y-1],oneWest);
                        break;
                    case 30111:
                        compatible &= member(maze[x][y+1],oneEast) && member(maze[x+1][y],oneSouth) && member(maze[x][y-1],oneWest);
                        break;
                    case 41111:
                        compatible &= member(maze[x-1][y],oneNorth) && member(maze[x+1][y],oneSouth) && member(maze[x][y-1],oneWest) && member(maze[x][y+1],oneEast);
                        break;
                }
            }
        }
        return compatible;
    }

    public boolean solvable()
    {
        boolean solved = false;
        int[] curr = {0,0,maze[0][0]};
        HashMap<Integer,int[]> process = new HashMap<Integer, int[]>();
        HashMap<Integer,int[]> processed = new HashMap<Integer, int[]>();
        process.put(level*level*curr[0] + curr[1], curr);

        int next_x, next_y;
        int[] next;
        int key;

        while (!process.isEmpty())
        {
            Object[] temp = process.keySet().toArray();
            curr = process.get(temp[0]);
            if (curr[0] == level - 1 && curr[1] == level - 1)
            {
                solved = true;
                break;
            }
            process.remove(level*level*curr[0] + curr[1]);
            processed.put(level*level*curr[0] + curr[1], curr); //int[] yoyo = new int[2]; yoyo = new int[]{curr[0], curr[1], curr[2]};
            //System.out.println(curr[0] + " " + curr[1] + " " + curr[2] + " " + process.containsKey(level*level*curr[0] + curr[1]) + " " + processed.containsKey(level*level*curr[0] + curr[1]));
            switch (curr[2])
            {
                case 11000:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 10100:
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 10010:
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 10001:
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 21100:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 21010:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 21001:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 20110:
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 20011:
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 20101:
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 31110:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 31101:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 31011:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 30111:
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
                case 41111:
                    next_x = curr[0] - 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] + 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0] + 1;
                    next_y = curr[1];
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    next_x = curr[0];
                    next_y = curr[1] - 1;
                    key = level*level*next_x + next_y;
                    next = new int[] {next_x, next_y, maze[next_x][next_y]};
                    if (!processed.containsKey(key))
                        process.put(key,next);
                    break;
            }
        }

        return solved;
    }
}
