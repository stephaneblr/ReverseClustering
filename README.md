# ReverseClustering


#### Use case

On dispose d'une taxonomie (eg l'arbre philogénétique qui classe les animaux). 

On veut associer à chaque animal une série de caractéristiques arborescentes (eg le "requin" a une "dentition" qui a un int "cardinal" et des instances de "dents", etc.).

On souhaite pouvoir associer des caractéristiques à chaque animal mais aussi à chaque groupe d'animal (eg les poissons) de telle sorte que les animaux de la catégorie héritent des caractéristiques. 


----------------------------------------------------

#### Output

On veut pouvoir visualiser : 
- L'arbre taxonomique
- L'arbre caractéristique pour chaque membre de la taxonomie

Et que toute l'information soit exportable dans une base de donnée relationnelle classique. Il y aura donc une table taxonomique et plusieurs tables caractéristiques. Chaque élément possède un ID unique et contient l'ID de son noeud père. 


----------------------------------------------------

#### Utilisation dans l'exemple

Ici la taxonomie est faite sur le type de travaux & constructions encadrés par le code de l'urbanisme. 
