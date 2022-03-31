package tn.esprit.spring.entites;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.TimesheetPK;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetPKTest {
	@Test
	public void setIdMissionTest() {
		TimesheetPK T = new TimesheetPK();
		int Id = 1000;
		T.setIdMission(1000);
		int result = T.getIdMission();
		assertEquals(Id, result);
	}

	@Test
	public void getIdMissionTest() {
		TimesheetPK T = new TimesheetPK();
		int Id = 1000;
		T.setIdMission(Id);
		assertEquals(1000, T.getIdMission());
	}

	@Test
	public void setDateFinTest() {
		TimesheetPK T = new TimesheetPK();
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();
		T.setDateFin(dateObj);
		assertEquals(dateObj, T.getDateFin());
	}

	@Test
	public void getDateFinTest() {
		TimesheetPK T = new TimesheetPK();
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();
		T.setDateFin(dateObj);
		Date dateFin = T.getDateFin();
		assertEquals(dateObj, dateFin);
	}

	@Test
	public void getIdEmployeTest() {
		TimesheetPK T = new TimesheetPK();
		int Id = 1000;
		T.setIdEmploye(Id);
		assertEquals(1000, T.getIdEmploye());
	}

	@Test
	public void setIdEmployeTest() {
		TimesheetPK T = new TimesheetPK();
		int Id = 1000;
		T.setIdEmploye(Id);
		int result = T.getIdEmploye();
		assertEquals(Id, result);
	}

}