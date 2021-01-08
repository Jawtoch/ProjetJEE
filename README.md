# ProjetJEE
Application stop covid

## Installation

Nécessite un server Apache Tomcat v9.*, disposant de la librairie JDBC `mysql-connector-java-8.0.22`

Une base de données Mysql doit être disponible, avec un utilisateur disposant des droit de lecture, création, mise à jour et suppression dessus.

Trois variables d'environnement doivent être définies:
- DB_DATABASE: nom de la base de données de l'application
- DB_USERNAME: nom d'utilisateur de l'application pour la base données
- DB_PASSWORD: mot de passe de l'utilisateur de l'application.

Les tables seront automatiquement créées au lancement de l'application, si nécessaire