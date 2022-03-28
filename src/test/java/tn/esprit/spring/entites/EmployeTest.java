package tn.esprit.spring.entites;

import static org.junit.Assert.*;

import org.junit.Test;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

public class EmployeTest {

	@Test
	public void testEmployeEntity() {
		//test de la methode getId
        Employe e = new Employe();
        e.setId(1);
        assertEquals(1, e.getId());
        //test de la methode getNom
        e.setNom("Ghannouchi");
        assertEquals("Ghannouchi", e.getNom());
        //test de la methode getPrenom
        e.setPrenom("Mustapha");
        assertEquals("Mustapha", e.getPrenom());
        //test de la methode getEmail
        e.setEmail("test@test.tn");
        assertEquals("test@test.tn", e.getEmail());
        //test de la methode getPassword
        e.setPassword("password");
        assertEquals("password", e.getPassword());
        //test de la methode getRole
        e.setRole(Role.ADMINISTRATEUR);
        assertEquals(Role.ADMINISTRATEUR, e.getRole());
       
        
	}

}
