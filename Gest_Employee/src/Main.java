import java.util.Date; 

import java.util.Scanner;

public class Main {

    private static GestionnaireEmployes gestionnaire = new GestionnaireEmployes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    ajouterEmploye();
                    break;
                case 2:
                    supprimerEmploye();
                    break;
                case 3:
                    modifierNomEmploye();
                    break;
                case 4:
                    afficherListeEmployes();
                    break;
                case 5:
                    System.out.println("**Sortie du programme**");
                    break;
                default:
                    System.out.println("Choix invalide ! Veuillez choisir un numéro entre 1 et 5.");
            }
        } while (choix != 5);
    }

    private static void afficherMenu() {
        System.out.println("------Menu de gestion des employés------\r");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Supprimer un employé");
        System.out.println("3. Modifier les infos d'un employé");
        System.out.println("4. Afficher la liste des employés");
        System.out.println("5. Quitter le programme");
        System.out.println("-----------------------------------------");
        System.out.print("=> Votre choix : ");
    }

    private static void ajouterEmploye() {
    	
    	System.out.print("------Ajout d'Employé------\r");
    	
    	System.out.print("Entrez l'id de l'employé : ");
        int id = scanner.nextInt();
    	
        System.out.print("Entrez le nom de l'employé : ");
        String nom = scanner.next();

        System.out.print("Entrez le rôle de l'employé (1=Ingénieur, 2=Chef d'équipe, 3=Technicien) : ");
        int role = scanner.nextInt();
        
        while (role < 1 || role > 3) {
        	System.out.print("Veuillez un role valide : ");
        	role = scanner.nextInt();
        }

        System.out.print("Entrez le salaire horaire de l'employé : ");
        double salaireHoraire = scanner.nextDouble();

        System.out.print("Entrez le nombre d'heures travaillées par l'employé : ");
        int nombreHeuresTravaillees = scanner.nextInt();

        Date dateEmbauche = new Date();

        Employe employe = new Employe(id, nom, role, salaireHoraire, nombreHeuresTravaillees, dateEmbauche);
        gestionnaire.ajouterEmploye(employe);

        System.out.println("\r=>Employé ajouté avec succès !\r");
    }

    private static void supprimerEmploye() {
    	
    	System.out.print("\r-------Suppression d'Employé------\r");
        System.out.print("Entrez l'ID de l'employé à supprimer : ");
        int id = scanner.nextInt();

        gestionnaire.supprimerEmploye(id);

        System.out.println("\r=>Employé supprimé avec succès !\r");
    }

    private static void modifierNomEmploye() {
    	System.out.print("\r-------Modification du nom d'employé------\r");
        System.out.print("Entrez l'ID de l'employé à modifier : ");
        int id = scanner.nextInt();

        
        
        
        

        Employe employe = gestionnaire.rechercherEmployeParId(id);
        
        if (employe != null) {
        	int choice ; 
            
            do {
            	
            	 System.out.println("------Modification ------\r");
                 System.out.println("1. Nouveau nom");
                 System.out.println("2. Nouveau role");
                 System.out.println("3. Nouveau nombre des heures");
                 System.out.println("4. Quitter le programme");
                 System.out.println("-----------------------------------------");
                 System.out.print("=> Votre choix : ");
           	
                
            	choice = scanner.nextInt();

                switch (choice) {
                    case 1: //modification du nom 
                    	System.out.print("Entrez le nouveau nom de l'employé : ");
                        String nom = scanner.next();
                        employe.setNom(nom);
                        break;
                    case 2: // modification du role 
                    	System.out.print("Entrez le nouveau role de l'employé : ");
                        int  role = scanner.nextInt();
                        employe.setRole(role);
                        break;
                    case 3: //modification des Heure de tra 
                    	System.out.print("Entrez le nouveau nombre des heures de l'employé : ");
                        int nombreHeuresTravaillees = scanner.nextInt();
                        employe.setNombreHeuresTravaillees(nombreHeuresTravaillees);
                        break;
                    case 4:
                        System.out.println("Sortie du programme");
                        break;
                    default:
                        System.out.println("Choix invalide ! Veuillez choisir un numéro entre 1 et 5.");
                }
            } while (choice != 4);
            
        } else {
            System.out.println("Employé introuvable !");
        }
    }

    private static void afficherListeEmployes() {
        gestionnaire.afficherListeEmployes();
    }
}
