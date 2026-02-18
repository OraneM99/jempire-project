public class Ennemy_Raid {
    private void raid (int nombreTour, Ressources ressourcesJoueur) {
        if (apparitionRaid(nombreTour)) {
            monstresRaid(nombreTour, ressourcesJoueur);
        }
    }

    public boolean apparitionRaid(int nombreTour) {
        // pourcentage de chance d'apparition = a partir du tour 2 (base) 0.01 + (nbrtour/2)/50 //90 tours pour atteindre le max
        if (nombreTour > 1) {
            double base = 0.01;
            double max = 0.8;

            if (! ((base) + ((nombreTour / 2.0) / 50.0) > max)) {
                base += ((nombreTour / 2.0) / 50.0);
            } else {
                base = max;
            }
            return Math.random() < base;
        }
        return false;
    }

    public void monstresRaid(int nombreTour, Ressources ressourcesJoueur) {
        double radcafards;
        double rataupes;
        double schtroumpfCannibal;
        double random;
        if (nombreTour <= 20) {
            schtroumpfCannibal = 0.99; // 1%
            rataupes = 0.89; // 10%
            radcafards = 0.79; // 79%
            random = Math.random();
            if (random <= radcafards) {
                apparitionRadcafards(nombreTour, ressourcesJoueur);
            } else if (random <= rataupes) {
                apparitionRataupes(nombreTour, ressourcesJoueur);
            } else {
                System.out.println("Pas encore intégré");
            }
        } else if (nombreTour <= 40) {
            schtroumpfCannibal = 0.95; // 5%
            rataupes = 0.94; // 74%
            radcafards = 0.20; // 20%
            random = Math.random();
            if (random <= radcafards) {
                apparitionRadcafards(nombreTour, ressourcesJoueur);
            } else if (random <= rataupes) {
                apparitionRataupes(nombreTour, ressourcesJoueur);
            } else {
                System.err.println("Pas encore intégré");
            }
        } else {
            radcafards = 0.90; // 10%
            rataupes = 0.30; // 60%
            schtroumpfCannibal = 0.29; // 29%
            random = Math.random();
            if (random >= radcafards) {
                apparitionRadcafards(nombreTour,ressourcesJoueur);
            } else if (random >= rataupes) {
                apparitionRataupes(nombreTour,ressourcesJoueur);
            } else {
                System.out.println("Pas encore intégré");
            }
        }
    }

    private void apparitionRadcafards(int nombreTour, Ressources ressourcesJoueur) {
        // 1 Radcafard tues 1 Habitant
        int habitants = ressourcesJoueur.getHabitants();
        int nombreRadcafards = (int)(Math.random() * habitants / 2);
        int perte = 0;

        System.err.println("Une horde de radcafards est apparue, vite à vos stimpacks !");
        for (int i = 1; i < habitants; i++) {
            if(Math.random() < 0.8) {
                System.err.println("Abri 042 : habitant " + i + " a succombé à ses blessures.");
                perte++;
            }
        }
        habitants -= perte;
        System.err.println("Vous avez perdu " + perte + " habitant.s");
        if (habitants - nombreRadcafards >= 25) {
            int bonus = 0;
            for(int i = 0; i < nombreRadcafards; i++) {
                if(Math.random() > 0.7) {
                    bonus++;
                }
            }
            ressourcesJoueur.setNourriture(ressourcesJoueur.getNourriture() + bonus);
            System.out.println("Vos habitants se sont bien battus, et vous ont gardé quelques morceaux de radcafards ! Miam ! (Nourriture + )" + bonus);
        }
        ressourcesJoueur.setHabitants(habitants);
    }

    private void apparitionRataupes(int nombreTour, Ressources ressourcesJoueur) {
        // 1 Radcafard tues 2 Habitant
        int habitants = ressourcesJoueur.getHabitants();
        int nombreRataupes = (int)(Math.random() * habitants / 2);
        int perte = 0;

        System.err.println("Une horde de rataupes est apparue, vite à vos stimpacks !");
        for (int i = 1; i < habitants; i++) {
            if(Math.random() < 0.8) {
                System.err.println("Abri 042 : habitant " + i + " a succombé à ses blessures.");
                perte++;
            }
            i++;
            if(Math.random() < 0.8) {
                System.err.println("Abri 042 : habitant " + i + " a succombé à ses blessures.");
                perte++;
            }
        }
        habitants -= perte;
        System.err.println("Vous avez perdu " + perte + " habitant.s");
        if (habitants - nombreRataupes >= 25) {
            int bonus = 0;
            for(int i = 0; i < nombreRataupes; i++) {
                if(Math.random() > 0.7) {
                    bonus++;
                }
            }
            ressourcesJoueur.setNourriture(ressourcesJoueur.getNourriture() + bonus);
            System.out.println("Vos habitants se sont bien battus, et vous ont gardé quelques morceaux de rataupes ! Miam ! (Nourriture + )" + bonus);
        }
        ressourcesJoueur.setHabitants(habitants);
    }
}
