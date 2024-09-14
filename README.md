Event Management System
Overview
The Event Management System is a Spring Boot application that enables users to create, manage, and participate in events. The application provides core CRUD functionalities for events and allows organizers to mark attendance and view event summaries. Additionally, it tracks API requests and responses through a logging mechanism.

Features
CRUD Operations:
Create, retrieve, update, and delete events.
Event Organizer:
Manage events as an organizer.
Event Participant:
Participants can register for events.
Event Attendance:
Organizers can mark attendance for participants.
Event Summary:
Organizers can retrieve a summary of the event.
API Logging:
Log API request and response data for tracking and auditing.
Project Structure
Organizer Functionality:
The organizer can create and manage event details.
Participant Registration:
Participants can register for events.
Event Attendance Marking:
Attendance for the event is recorded by the organizer.
API Log Table:
All API requests (e.g., POST, GET, PUT, DELETE) are logged with the relevant details for later auditing.
API Endpoints
HTTP Method	Endpoint	Description
POST	/api/events	Create a new event
GET	/api/events/{id}	Retrieve event details
PUT	/api/events/{id}	Update event information
DELETE	/api/events/{id}	Delete an event
POST	/api/participants	Register a participant for an event
GET	/api/logs	Retrieve API logs


Database Configuration
The application uses MySQL for persistent data storage, and Flyway for managing database migrations.
