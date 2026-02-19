import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Ennemy_Raid raid = new Ennemy_Raid();
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rnd = new  Random();
    private static boolean accesMine = false;
    private static boolean defaite = false;
    private static boolean victoire = false;
    private static boolean skipTour = false;
    private static boolean mineBloquee = false;
    private static boolean distillerieConstruite = false;
    private static int tourRestantBloque = 0;

    private static void explorerForet(Ressources ressourcesJoueur) {
        int bois =  ressourcesJoueur.getBois();
        int nourriture =  ressourcesJoueur.getNourriture();
        ressourcesJoueur.setBois(bois + 5);
        ressourcesJoueur.setNourriture(nourriture + 3);

        System.out.println("Vous avez gagné 5 de bois et 3 de nourriture");

        int event = rnd.nextInt(100);

        if (event <= 5) {
            System.out.println("Vous avez rencontré un vagabond ! +1 Habitant");
            ressourcesJoueur.setHabitants(ressourcesJoueur.getHabitants() + 1);
        }
    }

    private static void creerMine(Ressources ressourcesJoueur) {
        int bois = ressourcesJoueur.getBois();
        if (accesMine) {
            System.out.println("Une mine c'est déjà assez suffisant, spam plus le clavier");
            skipTour = true;
            return;
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

        if (mineBloquee) {
            System.out.println("Vous ne pouvez pas utiliser votre mine pour l'instant : Tour restant : " + tourRestantBloque);
            skipTour = true;
            return;
        }

        int nourriture = ressourcesJoueur.getNourriture();

        if (nourriture < 5 && !mineBloquee) {
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

        int event = rnd.nextInt(100);

        if (event > 1 && event <= 10) {
            System.out.println("Vous avez récupéré plus de caillasse ! +2 Pierres");
            ressourcesJoueur.setPierre(ressourcesJoueur.getPierre() + 2);
        } else if (event <= 1) {
            System.out.println("Un éboulement de caillasse vous tombe sur la tête ! Vous perdez 1 Habitant.");
            System.out.println("Suite à cette évènement, votre mine n'est plus accessible pendant 2 tours.");
            ressourcesJoueur.setHabitants(ressourcesJoueur.getHabitants() - 1);
            mineBloquee = true;
            tourRestantBloque = 2;
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

        if (distillerieConstruite) {

            int event = rnd.nextInt(100);

            if (event <= 5 && event > 1) {
                System.out.println("Vos nains étaient trop bourrés pour vendre quelque chose, vous avez tout perdu et rien gagné.");
                ressourcesJoueur.setPierre(ressourcesJoueur.getOr() - 10);
            } else if (event <= 1) {
                System.out.println("Vos nains étaient vachement efficace, vous avez vendu 5 pierres pour 20 pièces d'or ! (Je pense que le marchand devait être bourré  ...)");
                ressourcesJoueur.setOr(ressourcesJoueur.getOr() + 10);
            }
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

    public static void construireDistillerie(Ressources ressourcesJoueur) {
        int bois = ressourcesJoueur.getBois();
        int pierre = ressourcesJoueur.getPierre();
        int or =  ressourcesJoueur.getOr();

        if (bois < 30 && pierre < 10 && or < 10) {
            System.out.println("Une bonne binouze ça se mérite.");
            skipTour = true;
        } else if (!accesMine) {
            System.out.println("Tu crois pouvoir construire une distillerie sans pierre ?");
        } else {
            ressourcesJoueur.setBois(bois - 30);
            ressourcesJoueur.setPierre(pierre - 10);
            ressourcesJoueur.setOr(or - 10);
            System.out.println("C'est l'heure de boire !");
            distillerieConstruite = true;
        }
    }

    private static void nourrirHabitants(Ressources ressourcesJoueur) {
        int nourriture = ressourcesJoueur.getNourriture();
        int habitants = ressourcesJoueur.getHabitants();
        if (habitants <= 0) {
            System.out.println("Votre royaume a péri d'une grande famine. Tips : essayez de manger vos camarades pour temporiser la famine");
            defaite = true;
        }
        if (nourriture <= habitants) {
            int deficit = nourriture - habitants;
            if (deficit < 0) {
                ressourcesJoueur.setHabitants(habitants - Math.abs(deficit));
                ressourcesJoueur.setNourriture(0);
            } else {
                ressourcesJoueur.setNourriture(deficit);
            }
        } else {
            ressourcesJoueur.setNourriture(nourriture - habitants);
            System.out.println("Vous avez ressourcé vos troupes pour " + (habitants) + " point de nourriture.");
        }
    }

    private static void showRessources(Ressources r) {
        System.out.println();
        System.out.println("Ressources : Bois : " + r.getBois() + " | Pierre : " + r.getPierre() + " | Or : " + r.getOr() + " | Nourriture : " + r.getNourriture() + " | Habitants : " + r.getHabitants());
    }

    public static void main(String[] args) {
        Ressources joueur1 = new Ressources();
        int nombreTour = 1;

        do {
            showRessources(joueur1);
            System.out.println();
            System.out.println("\t1 - Explorer la forêt   (+5 Bois, +3 Nourriture)");
            System.out.println("\t2 - Créer une mine      (-10 Bois)");
            System.out.println("\t3 - Travailler mine     (-5 Nourriture, +5 Pierre, +2 Or)");
            System.out.println("\t4 - Recruter soldat     (-30 Or, +1 Habitant)");
            System.out.println("\t5 - Commercer           (-5 Pierre, +10 Or)");
            System.out.println("\t6 - Créer une distillerie (-30 Bois, -10 Pierre, -10 Or)");
            System.out.println("\t7 - Construire château  (VICTOIRE)");

            byte action = sc.nextByte();

            switch (action) {
                case 1 -> explorerForet(joueur1);
                case 2 -> creerMine(joueur1);
                case 3 -> travaillerMine(joueur1);
                case 4 -> recruterSoldat(joueur1);
                case 5 -> commercer(joueur1);
                case 6 -> construireDistillerie(joueur1);
                case 7 -> construireChateau(joueur1);
                default -> System.out.println("Impossible d'effectuer cette action.");
            }

            if (!skipTour) {
                if (tourRestantBloque > 0) {
                    tourRestantBloque--;
                } else if (tourRestantBloque == 0) {
                    mineBloquee = false;
                }
                nombreTour++;
                System.out.println("Tour : " + nombreTour);
                if (raid.apparitionRaid(nombreTour)) {
                    raid.monstresRaid(nombreTour, joueur1);
                }
                nourrirHabitants(joueur1);
                showRessources(joueur1);
                if (habitants <= 0) {
                    defaite = true;
                }
            }

            skipTour = false;
        } while(!victoire && !defaite);
        sc.close();
    }
}
