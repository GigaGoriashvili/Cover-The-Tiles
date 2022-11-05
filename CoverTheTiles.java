import java.util.Scanner;

public class CoverTheTiles {
    public static void outputTiles(boolean[] tiles) {
      StringBuilder sb = new StringBuilder("Open tiles: 1:");
      sb.append(tiles[0]);
      for (int i = 1; i < tiles.length; i++) {
      sb.append(" ").append(i + 1).append(":").append(tiles[i]);
      }
      System.out.println(sb.toString());
    }
  
    public static void main(String[] args) throws IllegalAccessException {
      boolean[] tiles = {true, true, true, true, true, true, true, true, true, true};
      int k, a, b, sumOfFreeTiles, credits1, credits2;
      sumOfFreeTiles = 55;
      credits1 = 0;
      credits2 = 0;
      k = 0;
      Scanner tile = new Scanner(System.in);
      
      //This while loop provides the game process with the two nested while's - player 1 and player 2
      while(k < 5) {
        int dice1 = (int) (Math.random()*(6)) + 1;
        int dice2 = (int) (Math.random()*(6)) + 1;
        while (true) {
          System.out.println("Player 1 numbers:");
          System.out.println(dice1);
          System.out.println(dice2);
          outputTiles(tiles);
          System.out.println("Which tiles to cover by player 1:");
          System.out.println("Tile 1:");
          a = tile.nextInt();
          System.out.println("Tile 2:");
          b = tile.nextInt();
          if (a + b == dice1 + dice2 && a != b && (tiles[a - 1] && tiles[b - 1])) {
            tiles[a - 1] = false;
            tiles[b - 1] = false;
            sumOfFreeTiles -= a + b;
            break;
          } else if(a == 0 || b == 0){
            credits1 += sumOfFreeTiles;
            break;
          }
        }
        //This condition checks if player 1 is instantly winner or not
        if (sumOfFreeTiles == 0) {
          System.out.println("Player 2 covers all tiles! Player 1 wins!");
          break;
        }
  
        dice1 = (int) (Math.random()*(6)) + 1;
        dice2 = (int) (Math.random()*(6)) + 1;
        while(true) {
          System.out.println("Player 2 numbers:");
          System.out.println(dice1);
          System.out.println(dice2);
          outputTiles(tiles);
          System.out.println("Which tiles to cover by player 2:");
          System.out.println("Tile 1:");
          a = tile.nextInt();
          System.out.println("Tile 2:");
          b = tile.nextInt();
          if (a + b == dice1 + dice2 && a != b && (tiles[a - 1] == true && tiles[b - 1] == true)) {
            tiles[a - 1] = false;
            tiles[b - 1] = false;
            sumOfFreeTiles -= a + b;
            break;
          } else if(a == 0 || b == 0) {
            credits2 += sumOfFreeTiles;
            break;
          }
        }
        //This condition checks if player 2 is instantly winner or not  
        if (sumOfFreeTiles == 0) {
          System.out.println("Player 2 covers all tiles! Player 2 wins!");
          break;
        }
        k++;
      }
  
      //This code checks who the winner is after ten rounds
      if (sumOfFreeTiles != 0) {
        if (credits2 > credits1) {
          System.out.println("Player 1 wins!");
        } else if (credits2 == credits1) {
          System.out.println("Draw!");
        } else {
          System.out.println("Player 2 wins!");
        }
      }
    }
  }