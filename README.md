#  Cookbook App (JavaFX)

**Course:** 1DV508 – Project Course in Computer Science (7.5 credits)  
**Institution:** Linnaeus University – Faculty of Technology  
**Term:** Spring 2022  
**Repository:** https://github.com/mustafaqh/cookbook-app  


---

##  Overview

**Cookbook App** is a **JavaFX desktop application** for managing recipes. It provides a graphical user interface (FXML) on top of a **MySQL** database via **JDBC**, supporting core recipe features (create, view, update, delete), search/filtering, and initial data seeding.

This README gives you everything to get the project running fast: **prerequisites, configuration, database setup, seeding, build/run commands (Gradle), screenshots, and troubleshooting**.

---

##  Features

-  **JavaFX UI** built with **FXML** and optional CSS styling  
-  **Recipe CRUD** (create, read, update, delete)  
-  **Search & filter** by title/ingredient/category  
-  Ingredient–recipe relations (typical many-to-many)  
-  **Seeder** to preload sample recipes into the database  

> Update the list if some features are not implemented in your version.

---

##  Architecture & Tech Stack

- **Language:** Java (≥ 11; 17 LTS recommended)  
- **UI:** JavaFX (FXML + Controllers)  
- **Database:** MySQL 8.x (or MariaDB) via JDBC  
- **Build Tool:** Gradle (Wrapper included)  
- **Persistence:** JDBC (+ DAO/service layers)  
- **Testing:** JUnit (if present)

**Key classes (from your notes):**  
- `db/ConnectionUtil.java` – centralizes DB connection details  
- `db/CreateDataBase.java` – creates the DB & schema  
- `db/CreateRecipes.java` – seeds initial recipe data  
- `app/Main.java` (or similar) – launches JavaFX (`Application.launch(...)`)

---

##  Project Structure (typical)

```
cookbook-app/
 ├── src/
 │   ├── main/java/
 │   │   ├── app/                # Main launcher, routing
 │   │   ├── controller/         # JavaFX controllers
 │   │   ├── db/                 # ConnectionUtil, CreateDataBase, CreateRecipes
 │   │   ├── dao/                # Data access objects
 │   │   ├── model/              # POJOs (Recipe, Ingredient, …)
 │   │   └── service/            # Business logic
 │   └── main/resources/
 │       ├── fxml/               # *.fxml views
 │       ├── css/                # *.css stylesheets
 │       └── images/             # icons/screens
 ├── Images/                     # (optional) screenshots for README
 ├── build.gradle / settings.gradle
 ├── gradle/ & gradlew (+ .bat)  # Gradle wrapper
 └── README.md
```

> If your package names differ, keep the README but adjust folder names accordingly.

---

##  Configuration (DB Credentials)

Before running, **edit your DB credentials**:

- `ConnectionUtil.java` – set DB URL/host/port/db name/username/password.  
- `CreateDataBase.java` – set **username/password** for the account that can create the schema.  
- `CreateRecipes.java` – verify DB name and credentials point to the same schema.

**Example (adjust to your code):**
```java
// ConnectionUtil.java
private static final String URL = "jdbc:mysql://localhost:3306/cookbook?useSSL=false&serverTimezone=UTC";
private static final String USER = "your_mysql_user";
private static final String PASS = "your_mysql_password";
```

> Tip: For production, move secrets to environment variables or a `config.properties` file.

---

##  Prerequisites

- **Java JDK** 11+ (17 preferred)  
- **MySQL** 8.x (or MariaDB 10.x) running locally  
- **MySQL Connector/J** (Gradle dependency or on classpath)  
- **Gradle** – Wrapper provided (`./gradlew`), no global install required

Verify versions:
```bash
java -version
./gradlew -v
mysql --version
```

---

##  Dependencies (Gradle)

If not already present in `build.gradle`, make sure you have something like:

```gradle
plugins {
    id 'application'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'mysql:mysql-connector-j:8.4.0'       // JDBC driver
    implementation 'org.openjfx:javafx-controls:21.0.3'
    implementation 'org.openjfx:javafx-fxml:21.0.3'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
}

application {
    // Replace with your JavaFX main class (extends javafx.application.Application)
    mainClass = 'app.Main'
}

tasks.withType(Test) {
    useJUnitPlatform()
}
```

**Run configuration (when needed):**  
On some systems you may need to pass JavaFX modules explicitly:
```bash
./gradlew run --args=""
# or configure org.openjfx.javafxplugin to auto‑add modules
```

---

##  How to Run

### 1) Clone
```bash
git clone https://github.com/mustafaqh/cookbook-app.git
cd cookbook-app
```

### 2) Configure database access
Open and edit:
- `db/ConnectionUtil.java`  
- `db/CreateDataBase.java`

Set your MySQL **user** and **password**. Confirm the DB **name** (e.g., `cookbook`).

### 3) Create database & schema
Run the class that creates the database:
```bash
./gradlew -q run --args="create-db"
# OR run the class directly if you have a separate runner:
# ./gradlew -q run --args="seed"
# (If you are not parsing args, run `db.CreateDataBase` via your IDE or a small runner class.)
```

> If the schema already exists, ensure your code checks for existence or drop/recreate as needed.

### 4) Seed base data (recipes)
```bash
./gradlew -q run --args="seed"
# or run the `db.CreateRecipes` main class from your IDE
```

### 5) Launch the JavaFX app
```bash
./gradlew run
```
The JavaFX window should open. If you run from an IDE, right‑click your JavaFX main class (e.g., `app.Main`) and choose **Run**.

---

##  Database Overview (typical)

**Tables:**
- `recipes(id, title, description, instructions, created_at, updated_at)`  
- `ingredients(id, name)`  
- `recipe_ingredients(recipe_id, ingredient_id, quantity, unit)`  
- `categories(id, name)`  
- `recipe_categories(recipe_id, category_id)`  
- (Optional) `users(id, username, password_hash, created_at)`

**Indexes:** consider indexes on `ingredients.name`, `recipes.title` for faster search.

---

##  Testing

If you have tests:
```bash
./gradlew test
```
- Unit tests for DAOs/services  
- Integration tests that use a separate test DB (e.g., `cookbook_test`)  
- Consider **Testcontainers** or **H2** for CI to avoid local DB coupling

---

## Screenshots (optional)

Place images in `Images/` and reference them here:

![Home View](Images/home.png)
![Recipe Details](Images/details.png)

---

##  Troubleshooting

- **Access denied for user** – check `USER/PASS`, and grant privileges:
  ```sql
  CREATE DATABASE IF NOT EXISTS cookbook;
  CREATE USER 'your_mysql_user'@'localhost' IDENTIFIED BY 'your_mysql_password';
  GRANT ALL PRIVILEGES ON cookbook.* TO 'your_mysql_user'@'localhost';
  FLUSH PRIVILEGES;
  ```
- **Driver not found** – ensure MySQL Connector/J is in `build.gradle` or on your classpath.  
- **JavaFX errors (module not found)** – use the OpenJFX dependencies shown above, or configure the JavaFX Gradle plugin to add modules at run time.  
- **Timezone/SSL warnings** – append params in the JDBC URL:
  `?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`

---

##  Roadmap (nice‑to‑have)

- Image upload for recipes  
- Ratings & comments  
- Meal planner and shopping list export  
- REST API + React/Vue frontend  
- Docker Compose for app + DB + Adminer

---

##  Course Alignment (1DV508)

This project reflects the course goals: planning and executing a software project, working in a team, applying a software process, and producing oral/written presentations and code deliverables. See **Learning Outcomes** in the official course plan.

---

##  License

Academic project for 1DV508 (Linnaeus University).  
Choose a license (MIT/Apache‑2.0) if you plan to share publicly.

---

##  Acknowledgements

- Linnaeus University – 1DV508  
- Team members and supervisor(s)
