package view;
import java.util.Arrays;
import controller.controller;
import processing.core.PApplet;

/**
 * This class contains all necessary functions of a view to be usable by the controller.
 * first think we initialize all the parameters such as  the first x and y position
 * and we define all other parameters that we will use
 */

public class view1 extends PApplet {
	final int X_POS = 0;
	final int Y_POS = 0;
	final int X_OFFSET = 20;
	final int Y_OFFSET = 20;

	final int SIZE_TILE = 80;
	final int SIZE_BORDER = 10;
	boolean game = true;
	int[] grid= new int[16];
	controller Controller;
	int score;

	public static void main(String[] args) {
		PApplet.main(view1.class);

	}
	public view1() {
		setSize(900,900);
	}
	/**
     *determine randomly position of a grid
     *@param grid randomly gives a position for the next number
     */
	public void rando(int[]grid){
		Controller.randomcontroller(grid);
	}
	/**
     *checks if the game is over
     *@param grid checks if all 16 rectangles are fall or the 2048 reached to stop the game
     *@return returns all the numbers written in each rectangle
     */
	public boolean isgameover(int [] grid) {
		return Controller.gameover(grid);
	}
	/**
     * this function controls how the colors of the rectangles should be shown in each position
     * @param grid we should know here each position to allows us changing the color
     */
	public void show(int[] grid) {
		  int edge_length = (int)(Math.sqrt(grid.length));
		  int i = 0;
		  int X, Y;
		  for (int y=0; y<edge_length; y++) {
		    Y = Y_POS+Y_OFFSET+SIZE_BORDER+y*(SIZE_TILE+SIZE_BORDER);
		    for (int x=0; x<edge_length; x++) {
		      X = X_POS+X_OFFSET+SIZE_BORDER+x*(SIZE_TILE+SIZE_BORDER);
		      // fill(color(179, 189, 214));
		      fill(color(30+log(grid[i]+1)/log(2)*10, 100, 100));
		      rect(X, Y, SIZE_TILE, SIZE_TILE, 15);
		      if (grid[i] != 0) {
		        fill(color(271, 0, 1));
		        text(grid[i], X+SIZE_TILE/2+1, Y+SIZE_TILE/2+1);
		      }
		      i++;
		    }
		  }
		}
	/**
     * sets up the settings of the game such as the background , text size ....
     */
	public void setup() {
		this.Controller= new controller(this,grid,score);
		  textAlign(CENTER, CENTER);
		  textSize(27);
		  noStroke();
		  background(color(179, 189, 214));
		  colorMode(HSB, 360, 100, 100);
		  int X_SIZE = 2*X_POS+2*X_OFFSET+SIZE_BORDER+4*(SIZE_TILE+SIZE_BORDER);
		  int Y_SIZE = 2*Y_POS+2*Y_OFFSET+SIZE_BORDER+4*(SIZE_TILE+SIZE_BORDER);
		  //size(X_SIZE, Y_SIZE);
		  print("X_SIZE:", X_SIZE, "Y_SIZE:", Y_SIZE);
		  
		  rando(grid);
		  rando(grid);
		  show(grid);
		  println(grid);
		}
	public int movecallview(int[] grid) {
		return Controller.callMove(grid);
	}
	public void callrotate(int[] grid) {
		Controller.rotatecall1(grid);
	}
	public void callrotate2(int[]grid, int num) {
		Controller.rotatecall2(grid, num);
	}
	/**
     * it shows a new numbers of the grid after the key get pressed 
     * and controls the position of the new shown number in the grid
     * plus calculating the score after each press
     */
	
		public void keyPressed() {
		  int[] temp_grid = new int[grid.length];
		  arrayCopy(grid, temp_grid);

		  if (key == CODED && game) {
		    switch(keyCode) {
		      case LEFT:
		        score += movecallview(grid);
		        break;
		      case RIGHT:
		        callrotate2(grid,2);
		        score += movecallview(grid);
		        callrotate2(grid,2);
		        break;
		      case UP:
		    	 callrotate(grid);
		        score += movecallview(grid);
		        callrotate2(grid,3);
		        break;
		      case DOWN:
		    	  callrotate2(grid,3);
		        score += movecallview(grid);
		        callrotate(grid);
		    }
		  }
		  if (!Arrays.equals(grid,temp_grid)) {
		    rando(grid);
		    show(grid);
		    println("SCORE =",score);
		  }
		  if (isgameover(grid)==true) {
		    game = false;
		    println("GAME OVER. YOUR SCORE =",score);
		  }
		}
		/**
	     * Show the game over screen of Game 2048.
	     */
		public void draw() {
			show(grid);
		}

}