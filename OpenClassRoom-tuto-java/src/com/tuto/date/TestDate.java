package com.tuto.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		// formatage :
		LocalDateTime localDateTime = LocalDateTime.now();
		Date date = new Date();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_kk_mm_ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd LLLL yyyy");
		String textDate = localDateTime.format(formatter);
		System.out.println("Date : " + date);
		System.out.println("LocalDateTime : " + localDateTime);
		System.out.println("date formattée : " + textDate);
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Date et heure courante : " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("Date courante : " + date1);

		Month mois = currentTime.getMonth();
		int jour = currentTime.getDayOfMonth();
		int heure = currentTime.getHour();

		System.out.println("Mois : " + mois + ", jour : " + jour + ", heure : " + heure);

		// Avoir le 25 décembre 2023
		LocalDateTime date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
		System.out.println("Date modifiée : " + date2);

		// une autre façon
		LocalDate date3 = LocalDate.of(2023, Month.DECEMBER, 25);
		System.out.println("Autre façon de faire : " + date3);

		// On peut même parser une date depuis un String
		LocalTime parsed = LocalTime.parse("20:15:30");
		System.out.println("Date parsée : " + parsed);

		/*************************************************************************/
		// AJOUTER, RETIRER DU TEMPS /

		// Le 25 Décembre 2018 a 13H37
		LocalDateTime ldt = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
		System.out.println("Date de référence : " + ldt);
		// Utilisation de l'objet ChronoUnit pour changer l'objet
		System.out.println("+1 semaine : " + ldt.plus(1, ChronoUnit.WEEKS));
		System.out.println("+2 mois : " + ldt.plus(2, ChronoUnit.MONTHS));
		System.out.println("+3 ans : " + ldt.plus(3, ChronoUnit.YEARS));
		System.out.println("+4 heures : " + ldt.plus(4, ChronoUnit.HOURS));
		System.out.println("-5 secondes : " + ldt.minus(5, ChronoUnit.SECONDS));
		System.out.println("-38 minutes : " + ldt.minusMinutes(38));
		/*********************************************************************************/
		// PERIODES :
		// Toujours notre 25 Décembre 2018 a 13H37
		LocalDateTime ldt4 = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
		LocalDateTime ldt2 = ldt4.plus(3, ChronoUnit.YEARS);
		LocalDateTime ldt3 = ldt4.minusMinutes(1337);

		Period p = Period.between(ldt4.toLocalDate(), ldt2.toLocalDate());
		Duration d = Duration.between(ldt4.toLocalTime(), ldt3.toLocalTime());
		System.out.println("Période : " + p);
		System.out.println("Durée : " + d.getSeconds());
		System.out.println("Ecart en jour : " + ChronoUnit.DAYS.between(ldt4, ldt2));

	}

}
