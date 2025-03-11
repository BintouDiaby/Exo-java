import java.util.ArrayList;
import java.util.Scanner;

public class GestionUtilisateurs {
    private static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    public static void menuUtilisateurs(Scanner scanner) {
        int choix;
        do {
            System.out.println("\nGESTION DES UTILISATEURS :");
            System.out.println("1: Ajouter un utilisateur");
            System.out.println("2: Supprimer un utilisateur");
            System.out.println("3: Modifier un utilisateur");
            System.out.println("4: Lister les utilisateurs");
            System.out.println("5: Retour");
            System.out.println("0: Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterUtilisateur(scanner);
                    break;
                case 2:
                    supprimerUtilisateur(scanner);
                    break;
                case 3:
                    modifierUtilisateur(scanner);
                    break;
                case 4:
                    listerUtilisateurs();
                    break;
                case 5:
                    return;  // Retour au menu principal
                case 0:
                    System.exit(0);  // Quitter l'application
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    // Ajouter un utilisateur
    public static void ajouterUtilisateur(Scanner scanner) {
        System.out.print("Identifiant : ");
        String identifiant = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        System.out.print("Rôle (admin/user) : ");
        String role = scanner.nextLine();

        utilisateurs.add(new Utilisateur(identifiant, motDePasse, role));
        System.out.println("Utilisateur ajouté !");
    }

    // Supprimer un utilisateur
    public static void supprimerUtilisateur(Scanner scanner) {
        listerUtilisateurs();
        System.out.print("Numéro de l'utilisateur à supprimer : ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < utilisateurs.size()) {
            utilisateurs.remove(index);
            System.out.println("Utilisateur supprimé !");
        } else {
            System.out.println("Index invalide !");
        }
    }

    // Modifier un utilisateur
    public static void modifierUtilisateur(Scanner scanner) {
        listerUtilisateurs();
        System.out.print("Numéro de l'utilisateur à modifier : ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < utilisateurs.size()) {
            System.out.print("Nouvel identifiant : ");
            String nouvelIdentifiant = scanner.nextLine();
            System.out.print("Nouveau mot de passe : ");
            String nouveauMotDePasse = scanner.nextLine();
            System.out.print("Nouveau rôle (admin/user) : ");
            String nouveauRole = scanner.nextLine();

            Utilisateur utilisateur = utilisateurs.get(index);
            utilisateur.setIdentifiant(nouvelIdentifiant);
            utilisateur.setMotDePasse(nouveauMotDePasse);
            utilisateur.setRole(nouveauRole);

            System.out.println("Utilisateur modifié !");
        } else {
            System.out.println("Index invalide !");
        }
    }

    // Lister les utilisateurs
    public static void listerUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré.");
        } else {
            for (int i = 0; i < utilisateurs.size(); i++) {
                System.out.println(i + ": " + utilisateurs.get(i));
            }
        }
    }
}
