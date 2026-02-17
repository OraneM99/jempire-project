import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static void showRessources(Ressources r) {
        System.out.println("Vos ressources: ");
        System.out.println("Bois : " + r.getBois());
        System.out.println("Pierre : " + r.getPierre());
        System.out.println("Or : " + r.getOr());
        System.out.println("Nourriture : " + r.getNourriture());
        System.out.println("Habitants : " + r.getHabitants());
    }

    public static void main(String[] args) {

        boolean again = true;
        Ressources joueur1 = new Ressources();

        do {
            showRessources(joueur1);
            System.out.println("Que voulez-vous faire ?");
            System.out.println("\t1 - Explorer la forêt | Coût : Aucun. | Gain : +5 Bois, +3 Nourriture.");
            System.out.println("\t2 - Créer une mine | Coût : 10 Bois | Gain : Débloque l'accès à la pierre.");
            System.out.println("\t3 - Travailler à la mine. | Coût : 5 Nourriture | Gain : +5 Pierre, +2 Or.");
            System.out.println("\t4 - Recruter un soldat. | Coût : 30 Or | Gain : +1 Habitant.");
            System.out.println("\t5 - Commercer. | Coût : 5 Pierre | Gain : +10 Or.");
            System.out.println("\t6 - Construire un château. | Coût : 100 Bois, 100 Pierre, 200 Or, 40 Habitants. | Gain : VICTOIRE IMMÉDIATE !!!!");
            again = false;

            String input = sc.nextLine();

        } while(again);

        sc.close();
    }
}
