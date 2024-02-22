import java.util.List; 
import java.util.ArrayList;

public class GestionnaireEmployes {

    private List<Employe> employes;

    public GestionnaireEmployes() {
        this.employes = new ArrayList<>();
    }

    // Ajouter un employé
    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    // Supprimer un employé
    public void supprimerEmploye(int id) {
        employes.removeIf(employe -> employe.getId() == id);
    }

    // Afficher la liste des employés
    public void afficherListeEmployes() {
    	System.out.println("\r############### Info Employé ###############\r");
        for (Employe employe : employes) {
            System.out.println("------------------------------------");
            System.out.println("ID : " + employe.getId());
            System.out.println("Nom : " + employe.getNom());
            System.out.println("Rôle : " + employe.getRole());
            System.out.println("Heure de travaille : " + employe.getNombreHeuresTravaillees());
            System.out.println("Date d'embauche : " + employe.getDateEmbauche());
            System.out.println("Salaire : " + employe.calculerSalaire());
            System.out.println("------------------------------------");
        }
    }

    // Rechercher un employé par son ID
    public Employe rechercherEmployeParId(int id) {
        return employes.stream().filter(employe -> employe.getId() == id).findFirst().orElse(null);
    }

   

}
