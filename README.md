# Full Stack Challenge

A full-stack company management application built with **Java EE** and **AngularJS**.

The project includes a REST API for company management, a Single Page Application for consuming the API, and an additional Java logic challenge.

## Tech Stack

### Backend

* Java
* Java EE 8
* JAX-RS
* JPA / Hibernate
* Jersey
* MySQL
* Maven

### Frontend

* AngularJS 1.8
* Bootstrap
* HTML
* CSS
* JavaScript

### Server

* Apache Tomcat 9

## Architecture

```text
AngularJS SPA
     ↓
REST API
     ↓
Service
     ↓
DAO
     ↓
JPA / Hibernate
     ↓
MySQL
```

## Features

* Company management
* Create, read, update and delete operations
* REST API
* Data validation
* MySQL persistence
* AngularJS SPA
* Layered backend architecture

## API

Base path:

```text
/api/company
```

### Get all companies

```http
GET /api/company
```

### Get company by ID

```http
GET /api/company/{id}
```

### Create company

```http
POST /api/company/create
```

### Update company

```http
PUT /api/company/{id}
```

### Delete company

```http
DELETE /api/company/{id}
```

## Project Structure

```text
backend/
├── src/main/java
│   ├── resource
│   ├── service
│   ├── dao
│   ├── domain
│   └── validation
│
└── src/main/webapp
    ├── index.html
    └── js

relogio/
└── Java logic challenge
```

## How to Run

Create a MySQL database:

```sql
CREATE DATABASE neomind;
```

Build the backend:

```bash
cd backend
./mvnw clean package
```

On Windows:

```bash
mvnw.cmd clean package
```

Deploy the generated WAR to **Apache Tomcat 9**.

The application can then be accessed through Tomcat, with the API available under:

```text
/api/company
```

## Postman

A Postman collection is included in the repository:

```text
Company API.postman_collection.json
```

It contains requests for testing the available API endpoints.

## Additional Challenge

The repository also contains a Java clock challenge inside the `relogio` directory.
