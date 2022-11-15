package application;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class pruebas {
	public static void main(String args[]) {
	      String JE_date = "2023-11-12";
	      DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      // parsing the string to convert it into date
	      LocalDate local_date = LocalDate.parse(JE_date, JEFormatter);
	      
	      if(local_date.isAfter(LocalDate.now())) {
	    	  System.out.println("saasad");
	      }else {
	    	  System.out.println("ni de coña");
	      }
	      System.out.println(local_date);
	    } 
	}

