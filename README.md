# 🚀 Gestion du Projet PFE

**Dans le contexte des études supérieures, la réalisation des Projets de Fin d'Études (PFE) est une étape cruciale pour les étudiants.** Cependant, la gestion efficace de ces projets implique plusieurs parties prenantes, créant ainsi la nécessité d'une plateforme dédiée. Ce cahier des charges vise à définir les spécifications pour une telle plateforme, ayant pour objectif principal de simplifier la coordination entre les étudiants et les encadrants, d'améliorer le suivi des projets, et de favoriser la communication. L'ambition ultime est d'optimiser la qualité et l'efficacité des projets de fin d'année, contribuant ainsi à l'évolution académique des étudiants.

## 📋 Table des matières

- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## 🛠️ Installation

### Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) : La dernière version de Java pour garantir la compatibilité avec notre projet.
- [Maven](https://maven.apache.org/download.cgi) : Un outil de gestion de projet et de compréhension des dépendances.
- [MySQL](https://dev.mysql.com/downloads/installer/) : La base de données relationnelle sur laquelle repose notre projet.

### Étapes d'installation

1. **Clonez le dépôt :**
    ```bash
    git clone https://github.com/your-username/gestion-pfe.git
    cd gestion-pfe
    ```

2. **Configurez les propriétés de l'application :**
    Créez un fichier `application.properties` dans `src/main/resources/` et ajoutez les propriétés suivantes :
    ```properties
    spring.application.name=your_data_base_name
    spring.datasource.url=jdbc:mysql://localhost:3306/your_data_base_name
    spring.datasource.username=your_user_Name
    spring.datasource.password=Your_Password
    spring.jpa.show-sql=true
    spring.jpa.generate-ddl=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.ddl-auto=update
    server.port=8080
   
    ```

3. **Dépendances Maven :**
    Le projet repose sur plusieurs dépendances essentielles. Voici une liste des principales :

    - **Spring Boot Starter Parent** (v3.2.5) : La base de notre projet Spring Boot.
    - **Spring Boot Starter Data JPA** : Pour l'intégration facile avec JPA et Hibernate.
    - **Spring Boot Starter Web** : Pour construire nos services web RESTful.
    - **MySQL Connector Java** : Pour permettre la connexion à notre base de données MySQL.
    - **Lombok** : Pour réduire le code boilerplate.
    - **Spring Boot Starter Test** : Pour faciliter les tests de notre application.
    - **ModelMapper** (v3.1.1) : Pour le mapping d'objets.
    - **Spring Boot Starter Validation** : Pour la validation des entrées utilisateur.
    - **Jackson Databind** : Pour la manipulation des objets JSON.
    - **Java JWT** (v0.9.1) : Pour la gestion des tokens JWT dans notre application.


1. **Forkez le projet**
2. **Créez votre branche de fonctionnalité :**
    ```bash
    git checkout -b feature/add-Somthing
    ```
3. **Committez vos modifications :**
    ```bash
    git commit -m 'Add user authentication'
    ```
4. **Pushez votre branche :**
    ```bash
    git push origin feature/add-Somthing
    ```
5. **Ouvrez une pull request**

*Happy coding!* 🚀
