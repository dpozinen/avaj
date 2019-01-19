package dpozinen.tests;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
public class MainTest {

	// TODO: redo paths; write proper tests
	@Test
	public void testDefault() {
		File expected = new File("C:\\Code\\avaj-launcher\\src\\test\\resources\\sim1.txt");
		File real = new File("C:\\Code\\avaj-launcher\\simulation.txt");
		assertThat(real).hasSameContentAs(expected);
	}
}