import java.util.Date; 

public class Employe {

    private int id;
    private String nom;
    private int role;
    private double salaireHoraire;
    private int nombreHeuresTravaillees;
    private Date dateEmbauche;

    public Employe(int id, String nom, int role, double salaireHoraire, int nombreHeuresTravaillees, Date dateEmbauche) {
        this.id = id;
        this.nom = nom;
        this.role = role;
        this.salaireHoraire = salaireHoraire;
        this.nombreHeuresTravaillees = nombreHeuresTravaillees;
        this.dateEmbauche = dateEmbauche;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
    	this.role = role;  
    }

    public double getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(double salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }

    public int getNombreHeuresTravaillees() {
        return nombreHeuresTravaillees;
    }

    public void setNombreHeuresTravaillees(int nombreHeuresTravaillees) {
        this.nombreHeuresTravaillees = nombreHeuresTravaillees;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

   

    // Calcul du salaire

    public double calculerSalaire() {
        double salaireBrut = salaireHoraire * nombreHeuresTravaillees;
        double bonus = 0;

        switch (role) {
            case 1: //ingénieur
                bonus = salaireBrut * 0.5;
                break;
            case 2: //Chef d'equipe
                bonus = salaireBrut * 0.3;
                break;
            case 3 : //Techniciens 
            	bonus = salaireBrut * 0.1; 
        }

        return salaireBrut + bonus;
    }

}
