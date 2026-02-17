import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static boolean accesMine = false;
    private static boolean defaite = false;
    private static boolean victoire = false;
    private static boolean skipTour = false;

    private static void explorerForet(Ressources ressourcesJoueur) {
        int bois =  ressourcesJoueur.getBois();
        int nourriture =  ressourcesJoueur.getNourriture();
        ressourcesJoueur.setBois(bois + 5);
        ressourcesJoueur.setNourriture(nourriture + 3);

        System.out.println("Vous avez gagné 5 de bois et 3 de nourriture");
    }

    private static void creerMine(Ressources ressourcesJoueur) {
        int bois = ressourcesJoueur.getBois();
        if (accesMine) {
            System.out.println("Une mine c'est déjà assez suffisant, spam plus le clavier");
            skipTour = true;
        }
        if (bois < 10) {
            System.out.println("Vous n'avez pas assez de bois");
            skipTour = true;
        }
        else {
            ressourcesJoueur.setBois(bois - 10);
            System.out.println("Vous avez débloqué l'accès à la pierre");
            accesMine = true;
        }
    }

    private static void travaillerMine (Ressources ressourcesJoueur) {
        if (!accesMine) {
            System.out.println("Impossible de miner sans mine, élémentaire.");
            skipTour = true;
            return;
        }
        int nourriture = ressourcesJoueur.getNourriture();
        if (nourriture < 5) {
            System.out.println("Un nain se doit d'être en bonne condition pour pouvoir miner, mange plus camarade !");
            skipTour = true;
        } else {
            System.out.println("Après une dose considérable de bière, vos nains ont ramassé de la grosse caillasse y compris celle qui brille !");
            ressourcesJoueur.setNourriture(nourriture - 5);
            int pierre =  ressourcesJoueur.getPierre();
            ressourcesJoueur.setPierre(pierre + 5);
            int or = ressourcesJoueur.getOr();
            ressourcesJoueur.setOr(or + 2);
        }
    }

    private static void recruterSoldat(Ressources ressourcesJoueur) {
        int or =  ressourcesJoueur.getOr();
        if (or < 30) {
            System.out.println("Vos cailloux ne brillent pas assez");
            skipTour = true;
        } else  {
            int habitants = ressourcesJoueur.getHabitants();
            ressourcesJoueur.setOr(or - 30);
            ressourcesJoueur.setHabitants(habitants + 1);
            System.out.println("SPARTIATE ! QUEL EST TON METIER ? AOUH AOUH !");
        }
    }

    private static void commercer(Ressources ressourcesJoueur) {
        int pierre = ressourcesJoueur.getPierre();
        if (pierre < 5) {
            System.out.println("*Bruit d'un villageois qui refuse sur Minecraft*");
            skipTour = true;
        } else {
            ressourcesJoueur.setPierre(pierre - 5);
            int or =   ressourcesJoueur.getOr();
            ressourcesJoueur.setOr(or + 10);
            System.out.println("Félicitation ! Vous venez d'arnaquer un marchand honnête ! Non mais sérieusement, 10 d'or les 5 pierres ?...");
        }
    }

    public static void construireChateau(Ressources ressourcesJoueur) {
        int bois =  ressourcesJoueur.getBois();
        int pierre =  ressourcesJoueur.getPierre();
        int or =  ressourcesJoueur.getOr();
        int habitants = ressourcesJoueur.getHabitants();

        if (bois < 100 && pierre < 100 && or < 200 && habitants < 40 ) {
            System.out.println("T'as vraiment cru bâtir un château avec 3 pierres et un bâton ?!");
            skipTour = true;
        }
        else {
            ressourcesJoueur.setBois(bois - 100);
            ressourcesJoueur.setPierre(pierre - 100);
            ressourcesJoueur.setOr(or - 200);
            System.out.println("Félicitation, Rome ne s'est pas bâti en un jour, ni en un tour ; Vous avez débuté un grand Empire \n(qui a un château T3 exposition plein sud, pas cher en plus c'est une bonne affaire)");
            victoire = true;
            //ressourcesJoueur.setHabitants(habitants - 100); On les sacrifie du coup ?
        }
    }

    private static void nourrirHabitants(Ressources ressourcesJoueur) {
        int nourriture = ressourcesJoueur.getNourriture();
        int habitants = ressourcesJoueur.getHabitants();
        if (habitants <= 0) {
            defaite = true;
        }
        if (nourriture < habitants) {
            ressourcesJoueur.setNourriture(habitants - (habitants - nourriture));
        } else {
            System.out.println("Vous avez ressourcé vos troupes pour " + (habitants) + " point de nourriture.");
            ressourcesJoueur.setNourriture(nourriture - habitants);
        }
    }

    private static void showRessources(Ressources r) {
        System.out.println("Vos ressources: ");
        System.out.println("Bois : " + r.getBois());
        System.out.println("Pierre : " + r.getPierre());
        System.out.println("Or : " + r.getOr());
        System.out.println("Nourriture : " + r.getNourriture());
        System.out.println("Habitants : " + r.getHabitants());
    }

    public static void main(String[] args) {
        Ressources joueur1 = new Ressources();
        int habitants = joueur1.getHabitants();
        do {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("\t1 - Explorer la forêt | Coût : Aucun. | Gain : +5 Bois, +3 Nourriture.");
            System.out.println("\t2 - Créer une mine | Coût : 10 Bois | Gain : Débloque l'accès à la pierre.");
            System.out.println("\t3 - Travailler à la mine. | Coût : 5 Nourriture | Gain : +5 Pierre, +2 Or.");
            System.out.println("\t4 - Recruter un soldat. | Coût : 30 Or | Gain : +1 Habitant.");
            System.out.println("\t5 - Commercer. | Coût : 5 Pierre | Gain : +10 Or.");
            System.out.println("\t6 - Construire un château. | Coût : 100 Bois, 100 Pierre, 200 Or, 40 Habitants. | Gain : VICTOIRE IMMÉDIATE !!!!");

            switch (sc.nextByte()) {
                case 1 -> explorerForet(joueur1);
                case 2 -> creerMine(joueur1);
                case 3 -> travaillerMine(joueur1);
                case 4 -> recruterSoldat(joueur1);
                case 5 -> commercer(joueur1);
                case 6 -> construireChateau(joueur1);
                default -> System.out.println("Impossible d'effectuer cette action");
            }
            if (!skipTour) {
                nourrirHabitants(joueur1);
            }
            showRessources(joueur1);
        } while(!victoire || !defaite);


        if (habitants <= 0) {
            System.out.println("Votre royaume a péri d'une grande famine. Tips : essayez de manger vos camarades pour temporiser la famine");
        }
        sc.close();
    }
}
