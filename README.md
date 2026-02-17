# Contexte du projet

Jeu de gestion médiéval avec uniquement le moteur logique du jeu ("Core Gameplay").

Les règles sont les suivantes :

1. Le but du jeu
Le joueur commence avec un seul habitant. Il doit gérer ses ressources tour par tour pour construire un CHÂTEAU. S'il n'a plus d'habitants, c'est PERDU.

2. Les Ressources à gérer (Variables)
Le jeu doit suivre ces compteurs en permanence (valeurs de départ entre parenthèses) :

Bois (0)
Pierre (0)
Or (50)
Nourriture (100) - Attention, ça baisse vite !
Habitants (1)

3. Déroulement d'un tour (La boucle)
Tant que le jeu n'est pas fini, le programme doit :

Afficher les ressources actuelles.
Demander au joueur ce qu'il veut faire (via un numéro).
Calculer le résultat de l'action.
Faire manger les habitants (Chaque habitant mange 1 unité de nourriture).
-> Si pas assez de nourriture : les habitants meurent de faim (Habitants = 0 => Game Over).

4. Les Actions possibles (Le Menu)
Voici les choix que le joueur doit avoir :

| Choix | Action | Coût / Risque | Gain |

| :--- | :--- | :--- | :--- |

| 1 | Explorer la forêt | Aucun | +5 Bois, +3 Nourriture |

| 2 | Créer une mine | -10 Bois | (Débloque l'accès à la pierre pour les tours suivants) |

| 3 | Travailler à la mine | -5 Nourriture | +5 Pierre, +2 Or (Seulement si mine construite !) |

| 4 | Recruter un soldat | -30 Or | +1 Habitant |

| 5 | Commercer | -5 Pierre | +10 Or |

| 6 | CONSTRUIRE LE CHÂTEAU | -100 Bois, -100 Pierre, -200 Or, -40 Habitants | VICTOIRE IMMÉDIATE ! |


Cordialement,

Michel L.E.
