import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Model;

class TestGame2048 {
	public int[] grid = new int[16]; 
	@Test
	void is_game_over() {
		Model m1 = new Model(new int [16], 0);
		assertTrue(m1.grid==grid);
		m1.free_slots(new int [16]);
     }
	

}
