#!/bin/bash

# Chemin par défaut pour les projets
CHEMIN_PAR_DEFAUT="$HOME/ClculatorInsset"

# Lancer SonarQube
start_sonar() {
    echo "Démarrage de SonarQube..."
    sudo systemctl start sonar.service
}

# Recharger SonarQube
reload_sonar() {
    echo "Redémarrage de SonarQube..."
    sudo systemctl restart sonar.service
}

# Consulter les logs de SonarQube
logs_sonar() {
    echo "Affichage des logs de SonarQube..."
    tail -f /opt/sonar/logs/sonar.log
}

# Afficher l'URL de SonarQube
url_sonar() {
    echo "URL de SonarQube : http://localhost:9010/sonar"
}

# Lancer Jenkins
start_jenkins() {
    echo "Démarrage de Jenkins..."
    sudo service jenkins start
}

# Recharger Jenkins
reload_jenkins() {
    echo "Redémarrage de Jenkins..."
    sudo service jenkins restart
}

# Afficher l'URL de Jenkins
url_jenkins() {
    echo "URL de Jenkins : http://localhost:9000/"
}


# Build le projet avec Maven et SonarQube
build_projet() {
    echo "Construction du projet..."
    cd "$CHEMIN_PAR_DEFAUT" || exit
    mvn clean verify sonar:sonar
}

main_menu() {
    echo "1: Lancer SonarQube"
    echo "2: Recharger SonarQube"
    echo "3: Consulter les logs de SonarQube"
    echo "4: Afficher l'URL de SonarQube"
    echo "5: Build le projet"
    echo "6: Lancer Jenkins"
    echo "7: Recharger Jenkins"
    echo "8: Afficher l'URL de Jenkins"
    echo "9: Quitter"
    read -p "Choisissez une option: " option
    case $option in
        1) start_sonar ;;
        2) reload_sonar ;;
        3) logs_sonar ;;
        4) url_sonar ;;
        5) build_projet ;;
        6) start_jenkins ;;
        7) reload_jenkins ;;
        8) url_jenkins ;;
        9) exit 0 ;;
        *) echo "Option invalide";;
    esac
}

# Boucle principale
while true; do
    main_menu
done


