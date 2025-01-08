 <a href="../README.md">
  <img src="../assets/button/home_page.png" alt="Home page" style="width: 150px; height: auto;">
</a>

![border](../assets/line/border_deco_rt.png)

# CONNEXION JAVA REACT VITE

![border](../assets/line/line-pink-point_l.png)

## Sommaire

- [Introduction](#introduction)
- [Vite react](#vite-react)
- [Java dans le backend](#java-dans-le-backend)
- [Creation du projet spring initializr](#creation-du-projet-spring-initializr)
- [Retour a la racine de turbo pour gérer le backend](#retour-a-la-racine-de-turbo-pour-gérer-le-backend)
- [Verifier que chaque partie fonctionne independemment](#vérifier-que-chaque-partie-focntionne-independemment)



![border](../assets/line/border_deco_rb.png)

# Introduction

- on crée le projet en créant un repertorie pour mon projet 

```
mkdir monorepo-react-java
cd monorepo-react-java
```
- Puis on initialise notre monorepo avec turbo

```
npx create-turbo@latest
```
## Vite React

- ensuite nous irons dans le dossier apps ou nous allons créer en premeir notre front react 

```
cd apps
```

- Puis nous allons créer dans **apps** notre application react 

```
npm create vite@latest frontend --template react-ts

```

- ensuite nous allons nous depalcer dans le dossier frontend 

```
cd frontend
```

- Puis nous allons faire 

```
npm install
```

- ensuite nous allons mettre à jour les scripts dans le package.json de apps/frontend pour utiliser Turbo

```
"scripts": {
  "dev": "vite",
  "build": "vite build",
  "preview": "vite preview"
}

```

- Puis nous allons vérifier que notre front fonctionne 

```
npm run dev
```

## Java dans le backend 

- Nous allons **créer un dossier pour notre backend** 

```
mkdir apps/backend
cd apps/backend
```

- Et nous allosn initialiser un projet maven 

PS : pour l'initialiser nous allons télécharger apache-maven-3.9.9-bin 

[Maven](https://maven.apache.org/download.cgi)

- une fois le dossier dézippé on le place dans le dossier

```
C:\Maven
```

- puis nous allons créer une **variable d'environnement** 

### Ajouter MAVEN_HOME :

Nous irons dans "Variables d'environnement".
Puis sous "Variables système", on clique sur "Nouveau".
Nom de la variable : MAVEN_HOME
Valeur de la variable : C:\Maven\apache-maven-3.9.9

Ensuite nous allons ajouter Maven au PATH :

Toujours dans "Variables système", trouve la variable Path et clique sur "Modifier".
Clique sur "Nouveau" et ajoute :

```
C:\Maven\apache-maven-3.9.9-bin\apache-maven-3.9.9
```

### Ajout de Maven au path : 


Ajouter Maven au Path
Ajoute le chemin du dossier bin de Maven à la variable d’environnement Path. C’est là que se trouve le fichier exécutable mvn.

Trouve la variable système Path.
Ajoute cette entrée :

```
C:\Maven\apache-maven-3.9.9-bin\apache-maven-3.9.9\bin
```

VERIFICATION INSTALALTION MAVEN 

```
mvn -v
```

### CREATION DU PROJET Spring Initializr

- ensuite nous irons dans le dossier **apps** de notre repo ( on va y créer le dossier backend via java spring )

- Pour aller dans le dossier en question 

```
code .
```

- Puis nous allons lancer Spring Initializr :

Appuie sur Ctrl+Shift+P pour ouvrir la palette de commandes.
Recherche Spring Initializr: Generate a Maven Project.

- Ensuite nous allons configurer notre projet 

```
Configure ton projet :

Sélectionne les options suivantes :
Language : Java
Build System : Maven
Group Id : com.example
Artifact Id : backend
Packaging : Jar
Dependencies : Ajoute Spring Web pour créer un backend REST.
```
## Retour a la racine de Turbo pour gérer le backend

- Nous allons retourner a la racine du projet 

```
cd C:\Users\franc\Desktop\monorepo-react-java\my-turborepo
```

- ainsi dans le package de turbo a al racine nous allosn ajouter : 

```
"scripts": {
  "backend:dev": "cd apps/backend && mvn spring-boot:run",
  "backend:build": "cd apps/backend && mvn package",
  "dev": "turbo run dev",
  "build": "turbo run build"
}
```

- Puis nous allons transformer le fichier **turbo.json** 

```bash
{
  "$schema": "https://turbo.build/schema.json",
  "ui": "tui",
  "tasks": {
    "build": {
      "dependsOn": ["^build"],
      "inputs": ["$TURBO_DEFAULT$", ".env*"],
      "outputs": [".next/**", "!.next/cache/**"]
    },
    "lint": {
      "dependsOn": ["^lint"]
    },
    "check-types": {
      "dependsOn": ["^check-types"]
    },
    "dev": {
      "cache": false,
      "persistent": true
    }
  }
}
```

- Puis nous allons le transformer avec quelques ajouts 

```BASH
{
  "pipeline": {
    "dev": {
      "dependsOn": ["^dev"],
      "outputs": []
    },
    "build": {
      "dependsOn": ["^build"],
      "outputs": ["apps/backend/target/**", "apps/frontend/dist/**"]
    },
    "backend:dev": {
      "inputs": ["apps/backend/src/**", "apps/backend/pom.xml"],
      "cache": false
    },
    "frontend:dev": {
      "inputs": ["apps/frontend/src/**", "apps/frontend/package.json"],
      "cache": false
    }
  }
}

```

- Puis nous allons modifier le package.json pour lancer le backend et le front end 


```bash
"scripts": {
  "dev": "turbo run dev",               // Lance le frontend et le backend en mode dev
  "build": "turbo run build",           // Construit le frontend et le backend
  "backend:dev": "cd apps/backend && mvn spring-boot:run", // Lance uniquement le backend
  "frontend:dev": "cd apps/frontend && npm start",         // Lance uniquement le frontend
  "backend:build": "cd apps/backend && mvn package",       // Construit uniquement le backend
  "frontend:build": "cd apps/frontend && npm run build"    // Construit uniquement le frontend
}
```

## Vérifier que chaque partie focntionne independemment 

- Nous allons dans le dossier backend 

```
 cd apps/backend
```

- Ensuite nous allons compiler et exécuter le backend 

```
mvn compile spring-boot:run
```





![border](../assets/line/line-pink-point_r.png)

<a href="#sommaire">
  <img src="../assets/button/back_to_top.png" alt="Back to top" style="width: 150px; height: auto;">
</a>

![border](../assets/line/border_deco_l.png)
