import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String identifiant, motDePasse;
        
        // Connexion
        System.out.println("******************************************");
        System.out.println("BIENVENU DANS L’APPLICATION ETAB v1.1");
        System.out.println("******************************************");
        System.out.print("Identifiant : ");
        identifiant = scanner.nextLine();
        System.out.print("Mot de passe : ");
        motDePasse = scanner.nextLine();

        if (identifiant.equals("Bintou") && motDePasse.equals("1234")) {
            afficherMenu(scanner);
        } else {
            System.out.println("Identifiants incorrects !");
        }
        scanner.close();
    }

    public static void afficherMenu(Scanner scanner) {
        int choix;
        do {
            System.out.println("\nMENU PRINCIPAL :");
            System.out.println("1: Gestion des élèves");
            System.out.println("2: Gestion des professeurs");
            System.out.println("3: Gestion des utilisateurs");
            System.out.println("0: Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();  // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    GestionEleves.menuEleves(scanner);
                    break;
                case 2:
                    GestionProfesseurs.menuProfesseurs(scanner);
                    break;
                case 3:
                    GestionUtilisateurs.menuUtilisateurs(scanner);


                                                                                                                                                                                                                                                                                                                                                                                                        


                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 0);
    }
}
