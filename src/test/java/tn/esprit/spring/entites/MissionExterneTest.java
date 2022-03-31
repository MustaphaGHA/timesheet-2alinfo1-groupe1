package tn.esprit.spring.entites;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.MissionExterne;

@RunWith(SpringRunner.class)
@SpringBootTest
class MissionExterneTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmployeEntity() {
		// test de la methode getsetEmailFacturation et setEmailFacturation
		MissionExterne me = new MissionExterne();
		me.setEmailFacturation("Ramy@gmail.com");
		assertEquals("Ramy@gmail.com", me.getEmailFacturation());
		// test de la methode getTauxJournalierMoyen et setTauxJournalierMoyen
		me.setTauxJournalierMoyen(1.2F);
		assertEquals(1.2F, me.getTauxJournalierMoyen(),0);
	}
	
}
