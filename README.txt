Application Java de gestion d’utilisateurs avec PostgreSQL

Créer une application Java permettant de gérer des utilisateurs stockés dans une base de données PostgreSQL, au moyen de la ligne de commande.

Le programme doit afficher un menu proposant les options suivantes :

1 - Lister les utilisateurs
2 - Créer un utilisateur
3 - Modifier un utilisateur
4 - Effacer un utilisateur
5 - Quitter

L’utilisateur sélectionne une option en entrant un chiffre entre 1 et 5.

Si l’utilisateur entre 1, la liste des utilisateurs doit être affichée. Chaque ligne doit être présentée sous la forme :
<ID> : <NOM> <PRENOM>
Le programme affiche ensuite le message : Appuyer sur une touche pour continuer ...

Si l’utilisateur entre 2, une suite de questions doit être posée :

    Veuillez entrer le prénom de l’utilisateur.

    Veuillez entrer le nom de l’utilisateur.

    Créer l’utilisateur <prénom> <nom> ?
    Une fois confirmé, un message doit indiquer que l’utilisateur a bien été créé, puis le message : Appuyer sur une touche pour continuer ...

Si l’utilisateur entre 3, une suite de questions doit être posée :

    Veuillez entrer l’ID de l’utilisateur à modifier.

    Veuillez entrer le prénom de l’utilisateur.

    Veuillez entrer le nom de l’utilisateur.

    Modifier l’utilisateur <ID> par <prénom> <nom> ?
    Une fois confirmé, un message doit indiquer que l’utilisateur a bien été modifié, puis le message : Appuyer sur une touche pour continuer ...

Si l’utilisateur entre 4, une suite de questions doit être posée :

    Veuillez entrer l’ID de l’utilisateur à effacer.

    Effacer l’utilisateur <prénom> <nom> ?
    Une fois confirmé, un message doit indiquer que l’utilisateur a bien été effacé, puis le message : Appuyer sur une touche pour continuer ...

Si l’utilisateur entre 5, le programme est arrêté.

Les utilisateurs doivent être stockés dans une base de données PostgreSQL contenant une table nommée user. Cette table doit contenir les champs suivants :

    id : entier, auto-incrémenté

    name : texte (50 caractères maximum)

    firstname : texte (50 caractères maximum)

Le programme doit contenir une classe principale qui affiche le menu et le lance.
Une classe abstraite BaseMenu doit implémenter l’interface Menu et contenir :

    une méthode permettant d’afficher une question à l’écran et de retourner la réponse de l’utilisateur,

    une méthode execute définissant l’interaction complète avec l’utilisateur et redéfinie dans des classes spécialisées,

    une méthode affichant le message Appuyer sur une touche pour continuer ...

Une classe spécialisée doit être créée pour chaque entrée du menu. Chaque classe doit hériter de BaseMenu, redéfinir la méthode execute, poser les questions nécessaires, effectuer les opérations correspondantes dans la base de données PostgreSQL et afficher le message Appuyer sur une touche pour continuer.
