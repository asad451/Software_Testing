import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiamondGateTest {

	@Test
	void testFirstTransition() {		//simple Entry

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		DiamondGate sut = new DiamondGate(registered);
		assertTrue(sut.visitors == 0);
		
		sut.entry_scan("acp18am");
		sut.entry_sensor_activated();
		sut.time_out();
		
		assertTrue(sut.visitors == 1);
	}

	@Test
	void testSecondTransition() {		//simple Exit

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		DiamondGate sut = new DiamondGate(registered);
		assertTrue(sut.visitors == 1);
		
		sut.exit_scan("acp18am");
		sut.entry_sensor_activated();
		sut.time_out();
		
		assertTrue(sut.visitors == 0);
	}

	@Test
	void testThirdTransition() {		//Exit should remain close until paid the fine and returned the book

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		Collection<String> overdue = new HashSet<String>();
		overdue.add("acp18am");

		DiamondGate sut = new DiamondGate(registered, overdue);
		
		sut.exit_scan("acp18am");
		sut.pay_fine();
		sut.return_book("acp18am");
		
		assertEquals(sut.hasReturned("acp18am"), true);

	}

	@Test
	void testFourthTransition() {		//Allow exit if paid the fine

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		Collection<String> overdue = new HashSet<String>();
		overdue.add("acp18am");

		DiamondGate sut = new DiamondGate(registered, overdue);
		assertTrue(sut.visitors == 1);
		
		sut.exit_scan("acp18am");
		sut.pay_fine();
		sut.return_book("acp18am");
		sut.exit_scan("acp18am");
		sut.entry_sensor_activated();
		sut.time_out();
		
		assertTrue(sut.visitors == 0);

	}

	@Test
	void testFifthTransition() {		//close the door if timeout on entry

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		DiamondGate sut = new DiamondGate(registered);
		assertTrue(sut.visitors == 0);
		
		sut.entry_scan("acp18am");
		sut.time_out();
		
		//assuming visitor count doesn't increment without passing through the gate

		assertTrue(sut.visitors == 0);

	}

	@Test
	void testSixthTransition() {		//close the door if timeout on exit

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		Collection<String> overdue = new HashSet<String>();
		overdue.add("acp18am");

		DiamondGate sut = new DiamondGate(registered, overdue);
		assertTrue(sut.visitors == 1);
		
		sut.exit_scan("acp18am");
		sut.time_out();
		
		//assuming visitor count doesn't increment without passing through the gate

		assertTrue(sut.visitors == 1);

	}

	@Test
	void testSeventhTransition() {		//Whether user has returned the book

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		Collection<String> overdue = new HashSet<String>();
		overdue.add("acp18am");

		DiamondGate sut = new DiamondGate(registered, overdue);
		
		sut.exit_scan("acp18am");
		sut.pay_fine();
		sut.return_book("acp18am");
		
		assertEquals(sut.hasReturned("acp18am"), true);

	}

	@Test
	void testEigthTransition() {		//Whether user is registered

		Collection<String> registered = new HashSet<String>();
		registered.add("acp18am");

		DiamondGate sut = new DiamondGate(registered);
		
		assertEquals(sut.isRegistered("acp18am"), true);

	}
}