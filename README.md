# Turbo Get Started

<!-- Main image  -->

![border](./assets/line/border_deco_rt.png)

# Sommaire

- [Introduction](#introduction)
    - [étape-1--créer-le-turbo-repo](#étape-1--créer-le-turbo-repo)
    - [étape-2--ajouter-vite-react](#étape-2--ajouter-vite-react)
- [créer-lapplication-nestjs](#créer-lapplication-nestjs)
    - [étape-3--config-pour-appeler-nest-de-la-racine](#étape-3--config-pour-appeler-nest-de-la-racine)
    - [étape-4--configurer-le-partage-de-code-avec-packages](#étape-4--configurer-le-partage-de-code-avec-packages)

# Navigation

- [Connexion Nest Vite](./doc/connexion_nest_vite.md)

![border](./assets/line/line-pink-point_l.png)

# Introduction
-----------
-----------
-----------
-----------
-----------

### **Étape 1 : Créer le Turbo Repo**
1. Initialiser un **Turbo Repo** :

   ```bash
   npx create-turbo@latest
   ```
---

### **Étape 2 : Ajouter Vite (React)**
1. Pusi on navigue dans le dossier du projet :
   ```bash
   cd my-fullstack-project
   ```

2. Ensuite nous allons Ajouter une application Vite pour le frontend dans le dossier `apps/web` :
   ```bash
   npm create vite@latest apps/web -- --template react-ts
   ```

3. Installe les dépendances :
   ```bash
   npm install
   ```

4. Ajoute un script pour démarrer Vite dans le fichier `package.json` (à la racine) :

```json
   "scripts": {
    "build": "turbo build",
    "dev": "turbo dev",
    "lint": "turbo lint",
    "format": "prettier --write \"**/*.{ts,tsx,md}\"",
    "dev:web": "npm run dev --prefix apps/web",
  "build:web": "npm run build --prefix apps/web"
  },
```

5. Teste le démarrage de Vite :
   ```bash
   npm run dev:web
   ```



-----------
-----------
-----------

---

# Créer l'application NestJS

1. Retourne à la racine de ton Turbo Repo.
   ```bash
   cd C:\Users\franc\Desktop\turbo-repo
   ```

2. Crée une nouvelle application NestJS dans le dossier `apps/api` :
   ```bash
   npx @nestjs/cli new apps/api
   ```
   - Choisis `npm` comme gestionnaire de paquets si demandé.

3. Vérifie que le dossier `apps/api` contient bien le fichier `package.json` ainsi que les autres fichiers générés.

---

### Étape 3 : Config pour appeler nest de la racine 

```
   "dev:api": "npm run start:dev --prefix apps/api"
```

à la suite de cette facon : 

```java
{
  "name": "turbo-repo",
  "private": true,
  "scripts": {
    "build": "turbo build",
    "dev": "turbo dev",
    "lint": "turbo lint",
    "format": "prettier --write \"**/*.{ts,tsx,md}\"",
    "dev:web": "npm run dev --prefix apps/web",
    "build:web": "npm run build --prefix apps/web",
    "dev:api": "npm run start:dev --prefix apps/api"
  },
```


### **Étape 4 : Configurer le partage de code avec `packages`**

- Le dossier packages est déjà configuré dans ton Turbo Repo grâce à la directive workspaces dans le fichier package.json de la racine :

```
"workspaces": [
  "apps/*",
  "packages/*"
]
```


1. Depuis la racine de ton projet (le dossier où se trouve turbo.json), crée un sous-dossier pour le package partagé : **Crée un package partagé** (par exemple, pour des modèles ou des utilitaires) dans `packages/shared` :
   ```bash
   mkdir -p packages/shared
   cd packages/shared
   npm init -y
   ```

2. Puis dans  `packages/shared` nosu allons Modifier le `package.json` pour inclure TypeScript et l'adapter au monorepo :

### AVANT 

```
{
  "name": "shared",
  "version": "1.0.0",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC",
  "type": "commonjs",
  "description": ""
}

```

### APRES

   ```json
   {
     "name": "@turbo/shared",
     "version": "1.0.0",
     "main": "dist/index.js",
     "types": "dist/index.d.ts",
     "scripts": {
       "build": "tsc"
     },
     "devDependencies": {
       "typescript": "^5.5.4"
     }
   }
   ```


- Puis nous allons Installer TypeScript dans packages/shared comme dépendance de développement :

```
npm install --save-dev typescript
```
- puis toujours dans le dossier **shared** nous allons créer un  **NOUVEAU DOSSIER** que nous allons appeler tsconfig.json

```
/shared/tsconfig.json
```

puis nous allons y ajouter la configuration suivante : 


```
{
  "compilerOptions": {
    "declaration": true,
    "emitDeclarationOnly": true,
    "outDir": "dist",
    "strict": true
  },
  "include": ["src"]
}
```



-----------
-----------
-----------



<a href="#sommaire">
<img src="assets/button/back_to_top.png" alt="Home page" style="width: 150px; height: auto;">
</a>

![border](./assets/line/line-teal-point_l.png)

![border](./assets/line/border_deco_rt.png)
