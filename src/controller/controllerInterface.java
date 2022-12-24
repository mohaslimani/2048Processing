package controller;

/**
 * The interface of a controller from the perspective of a view object.
 * All elements that are not part of this interface are invisible for the view.
 */
public interface controllerInterface {
	 /**
     * This method should be called whenever the controller should decide what the view should display.
     * The controller will call one of the drawX()-Methods from the view.
     */
	 void randomcontroller(int[]grid);
	 boolean gameover(int[] grid);
     int callMove(int []grid);
	 void rotatecall1(int[] grid);
	 void rotatecall2(int[] grid,int num);
}
