package com.bean.tuto;

public class Client {
	private int numCli;
	private static int nbCli;
	private String nomCli;
	private String prenomCli;
	private String adrCli;
	private String telCli;
	private String mailCli;
	
	public Client() {};
	
	
	public Client( String nomCli, String prenomCli, String adrCli, String telCli, String mailCli) {
		super();
		nbCli++;
		this.numCli = nbCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adrCli = adrCli;
		this.telCli = telCli;
		this.mailCli = mailCli;
	}


	public int getNumCli() {
		return numCli;
	}
	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}
	public static int getNbCli() {
		return nbCli;
	}
	public static void setNbCli(int nbCli) {
		Client.nbCli = nbCli;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getAdrCli() {
		return adrCli;
	}
	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}
	public String getTelCli() {
		return telCli;
	}
	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}
	public String getMailCli() {
		return mailCli;
	}
	public void setMailCli(String mailCli) {
		this.mailCli = mailCli;
	}


	public String getPrenomCli() {
		return prenomCli;
	}


	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}

}
