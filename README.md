# JEMPIRE PROJECT

Bienvenue dans JEMPIRE, un jeu de gestion en console où vous devez développer votre royaume, gérer vos ressources et construire votre château pour gagner !

---

## Objectif du jeu

Le joueur commence avec un seul habitant. Il doit gérer ses ressources tour par tour pour construire un CHÂTEAU. S'il n'a plus d'habitants, c'est PERDU. 

## Les Ressources à gérer
Le jeu doit suivre ces compteurs en permanence (valeurs de départ entre parenthèses) :

- Bois (0)
- Pierre (0)
- Or (50)
-Nourriture (100) - Attention, ça baisse vite !
- Habitants (1)

## Déroulement d'un tour
À chaque tour, un menu et vos resssources s’affichent dans la console.
Vous devez entrer un numéro correspondant à l’action souhaitée.

Chaque tour vos habitants mangent de la nourriture donc 1 unité de nourriture par habitant.

-> Si pas assez de nourriture : les habitants meurent de faim (Habitants = 0 => Game Over).

## Les Actions possibles
Voici les choix que le joueur doit avoir :

| Choix | Action | Coût / Risque | Gain |

| :--- | :--- | :--- | :--- |

| 1 | Explorer la forêt | Aucun | +5 Bois, +3 Nourriture |

| 2 | Créer une mine | -10 Bois | (Débloque l'accès à la pierre pour les tours suivants) |

| 3 | Travailler à la mine | -5 Nourriture | +5 Pierre, +2 Or (Seulement si mine construite !) |

| 4 | Recruter un soldat | -30 Or | +1 Habitant |

| 5 | Commercer | -5 Pierre | +10 Or |

| 6 | CONSTRUIRE LE CHÂTEAU | -100 Bois, -100 Pierre, -200 Or, -40 Habitants | VICTOIRE IMMÉDIATE ! |

## Stratégie conseillée

Commencez par explorer la forêt pour accumuler du bois et de la nourriture.

Créez une mine rapidement.

Travaillez à la mine pour générer pierre et or.

Recrutez des soldats progressivement.

Accumulez toutes les ressources nécessaires pour construire le château.