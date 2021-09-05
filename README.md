# Getting Started

This is for an assignment and can only be run in dev mode. You must have Maven and NPM installed on your machine, as well as Java and NodeJS.

### Running backend
Stand in the root of this project and run ***mvn clean install*** to install dependencies you might need from the pom file. 
Thereafter you can run the service by the command ***mvn spring-boot:run***

### Running frontend
Go into the frontend directory. From there you need to install your node dependencies by running ***npm install***.
Once that is done you can run a frontend dev server by running ***npm run serve***.

### Troubleshooting
Make sure to start the backend server first, as it will only start on port 8080. 
The frontend server will use the next available port if 8080 is taken.