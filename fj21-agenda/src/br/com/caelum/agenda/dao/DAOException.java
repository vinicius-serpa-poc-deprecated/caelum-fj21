package br.com.caelum.agenda.dao;

public class DAOException extends RuntimeException {

	DAOException(Exception e) {
		System.out.println("Ocorreu uma exceção no DAO! " + e.getMessage());
		throw new RuntimeException(e);
	}
	
}
