package interfacage;

public abstract class Collaborateur {
    protected String nom;
    protected String prenom;

//    public Collaborateur(String nom, String prenom) {
//        this.nom = nom;
//        this.prenom = prenom;
//    }
    public Collaborateur() {
       
    }

    public abstract long calculerSalaire();

    public void annoncerSalaire() {
        System.out.println("Salaire : " + calculerSalaire());
    }
}

