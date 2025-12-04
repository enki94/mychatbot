# MyChatbot

A Spring Boot based chatbot application using RiveScript for conversational logic and Solr for data indexing/search.

## Tech Stack

-   **Java 8**
-   **Spring Boot 2.1.3.RELEASE**
    -   Spring Data JPA
    -   Spring Data Solr
    -   Spring Web
    -   Thymeleaf
-   **RiveScript** (v0.10.0)
-   **PostgreSQL** (Database)
-   **Docker** (Containerization)

## Prerequisites

-   Java 8 or higher
-   Maven
-   Docker

## Installation & Running

### 1. Build the Application

Use the Maven wrapper to build the project:

```bash
./mvnw clean install
```

### 2. Run with Docker

This project uses Docker to run PostgreSQL and Solr.

**Build the Docker image:**

```bash
docker build -t mychatbot .
```

**Run the application (linking Postgres and Solr):**

```bash
docker run -p 8080:8080 --link postgres:postgres --link solr:solr --name mychatbot mychatbot
```

*Note: Ensure you have `postgres` and `solr` containers running or adjust the `--link` parameters and `application-docker.properties` accordingly.*

## Project Structure

-   `src/main/java/io/devwin/mychatbot`
    -   `controller`: Web and REST controllers handling HTTP requests.
    -   `model`: JPA entities (`Customer`, `Posts`).
    -   `repository`: Data access layers for JPA and Solr.
-   `src/main/resources`
    -   `rivescript`: Contains RiveScript brain files (`*.rive`).
    -   `templates`: Thymeleaf templates for the UI.
