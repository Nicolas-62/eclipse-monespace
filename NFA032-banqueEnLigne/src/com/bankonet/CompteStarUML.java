package com.bankonet;

public abstract class CompteStarUML {

    /**
     * Default constructor
     */
    public CompteStarUML() {
    }

    /**
     * 
     */
    private String numero;

    /**
     * 
     */
    private String intitule;

    /**
     * 
     */
    private double solde;

    /**
     * @param unNumero 
     * @param unIntitule 
     * @param unSolde
     */
    public void Compte(String unNumero, String unIntitule, double unSolde) {
        // TODO implement here
    }

    /**
     * @param montant 
     * @return
     */
    protected abstract boolean debitAutorise(double montant);

    /**
     * @param montant 
     * @return
     */
    public void debiter(double montant) {
        // TODO implement here
        return null;
    }

}

