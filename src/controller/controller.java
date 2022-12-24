package controller;
import model.Model;
import view.view1;
import view.view2;
/*
 * A controller implementation for a GUI view.
 * It implements a state machine to keep track of the state the view should draw next.
 * 
 */
public class controller {
	/**
     * Creates a new controller object with the given view and size.
     * @param View   The view object that should be used by the controller. Cannot be changed later.
     * @param grid   The grid of the game that means how much parts schould be in our game, ours is 16
     * @param score  The reached score in each time
     */

		view1 View;
		Model Model;
		view2 view_2;
		
		public controller(view1 View, int[]grid, int score) {
			this.Model= new Model(grid,score);
			this.View=new view1();
		}
		public controller(view2 View, int[]grid, int score) {
			this.Model= new Model(grid,score);
			this.view_2=new view2();
		}
		 /**
	     * gameover schows us each number of the grids as soon as the game is over
	     
	     
	     */
		public void randomcontroller(int[]grid) {
			Model.random_tile(grid);
		}
		public boolean gameover(int[] grid) {
			return Model.is_game_over(grid);
		}

		public int callMove(int []grid) {
			return Model.move(grid);
		}
		 /**
	     *change the rotation of the numbers each time the mouse is clicked
	     * @param grid  defined the position of the grid that we can rotate
	     * @param num  The new number of the grid
	     */
		public void rotatecall1(int[] grid) {
			Model.rotate(grid);
		}
		public void rotatecall2(int[] grid,int num) {
			Model.rotate(grid,num );
		}
	
		
	}

