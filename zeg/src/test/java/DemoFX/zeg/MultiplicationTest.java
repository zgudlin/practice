package DemoFX.zeg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplicationTest {

	@Test
	public void multiplyTest() {
		Multiplication m = new Multiplication();
		int exp = 8;
		assertEquals(exp, m.multiply(2, 4));
	}

}
