 <a href="../README.md">
  <img src="../assets/button/home_page.png" alt="Home page" style="width: 150px; height: auto;">
</a>

![border](../assets/line/border_deco_rt.png)

# CONNEXION JAVA REACT VITE

![border](../assets/line/line-pink-point_l.png)

## Sommaire

- [Introduction](#introduction)
- [Vite react](#vite-react)

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

### RETOUR DANS LA CONFIG DU BACKEND 

- ensuite nous irons dans le dossier **backend** de notre repo 

```
cd C:\Users\franc\Desktop\monorepo-react-java\my-turborepo\apps\backend
```

- Puis nous allons y générer un projet maven 

```
mvn archetype:generate -DgroupId=com.example -DartifactId=backend -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

```

![border](../assets/line/line-pink-point_r.png)

<a href="#sommaire">
  <img src="../assets/button/back_to_top.png" alt="Back to top" style="width: 150px; height: auto;">
</a>

![border](../assets/line/border_deco_l.png)
