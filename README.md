# Backend Software Developer Exam

This repository contains a Java-based backend application that provides REST API endpoints to interact with
Elasticsearch. The application includes functionalities to create an index, add documents to the index, and retrieve
documents by ID.

## Prerequisites

Before running the project, ensure that you have the following tools installed:

- Java 17 or higher
- Elasticsearch compatible with Java 17 or higher

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/hlucas13/vicarius-backend-exam.git
   ```

2. **Navigate to the Project Directory:**
   ```bash
   cd vicarius-backend-exam
   ```

3. **Run the Application:**
   ```bash
   ./gradlew bootRun
   ```

   This will start the application on the default port (8080).

## Testing Endpoints

You can test the API endpoints using tools like Postman, CURL, or any similar HTTP client.

### Create Index

- **Endpoint:** `POST /api/security-toolkit/create-index`
- **Response:** Index created or already exists

### Create Document

- **Endpoint:** `POST /api/security-toolkit/create-document`
- **Payload:** JSON body representing a `SecurityToolkit` document:

    ```json
    {
      "firewall": "value1",
      "antivirus": "value2",
      "networkMonitoring": "value3"
    }
    ```
- **Response:** Document ID to be used in the endpoint "Get Document by ID"

### Get All Documents

- **Endpoint:** `GET /api/security-toolkit/documents`
- **Response:** All documents stored in the current index

### Get Document by ID

- **Endpoint:** `GET /api/security-toolkit/document/{id}`
- **Path Variable:** Replace `{id}` with the actual ID of the document.
- **Response:** Document retrieved by the ID provided in the endpoint "Create Document"

## Video Demonstration

A video demonstrating the code running on a local machine is
available [here](https://github.com/hlucas13/vicarius-backend-exam/blob/main/video/demo.mov)
or [here](https://vimeo.com/user208459221).

## Notes

- This project uses Spring Boot and Elasticsearch for backend development.
- Docker was not used, as specified in the requirements.

Feel free to report issues or provide feedback!