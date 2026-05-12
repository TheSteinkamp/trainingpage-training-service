# TrainingPage training-service

## Description 

A fitness application built with multiple microservices to help you with planning, logging and improving your home training.
The system is a microservice application built with Spring Boot, React, and PostgreSQL and containerized using Docker for easy setup and deployment.


Training-service is fetching a list of filtered exercises through an Exercise Db API. it is also handling everything regarding sessions and exercises, 
e.g. the creation of a new session, filtering exercises and fetching all exercises from a single user. 


## Technology stack

* External API Integration (ExerciseDB via RapidAPI)
* Java Spring Boot
* Eureka Client
* PostgreSQL

## Endpoints

| Method | Endpoint | Description | Auth Required |
| :--- | :--- | :--- | :--- |
| GET | /exercise/bodypartlist | Fetch list of availible bodyparts for filtering | Yes |
| GET | /exercise/difficultylist | Fetch list of availible difficulties for filtering  | Yes |
| GET | /exercise/bodypart/{bodypart}/difficulty/{difficulty}| Fetch the filtered exercises | Yes |
| GET | /exercise/session | Fetch all exercises for one session | Yes |
| POST | /training/new | Add a new session | Yes |
| GET | /training/user/{id} | Fetch all sessions per user | Yes |


## Setup

This service is designed to be run as part of the Docker Compose cluster.
For instructions on how to start the project go to the readme file at [trainingpage](https://github.com/TheSteinkamp/trainingpage.git)
