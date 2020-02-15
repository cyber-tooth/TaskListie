Dokumentation Task-Liste <br>
Projekt von:
Ksenia Tereshenkova s0564412, 
Kübra Demir         s0553666, 
Adriana Grotseva    s0527080, 
Anna Skolov         s0563332

1.Thema
  In unserem Projekt haben wir eine Taskliste entwickelt. Ein User kann sich auf der Seite registrieren und anschließend einloggen. Nach
  dem Log-In kommt er auf seine individuelle Taskliste. 
  Der Aufbau der Taskliste sieht folgendermaßen aus: 
 -Unter dem Reiter Add Item, kann der User eine beliebige Task erstellen.
 -Beim klicken auf das add-Button wird die Task in den Reiter ‚ToDo‘ übernommen. Dies ist die ToDo-Liste vom User
 -Bei der ‚ToDo‘-Liste hat der User die Möglichkeit die Task zu editieren (bzw. umbenennen), zu löschen oder ein Häkchen zu setzen falls
  die Task abgearbeitet wurde. 
 -Wenn ein Häkchen gesetzt wird, erscheint die Task in dem Reiter ‚completed‘. 
 -In ‚completed‘ stehen abgeschlossene Tasks. Der User hat hier dieselben Möglichkeiten wie auf dem Reiter ‚ToDo‘. Ergänzend kommt noch
  hinzu, dass der User das Häkchen wieder rausnehmen kann und die Task dann wieder zurück in die ‚ToDo‘-Liste kommt. 

2.Architektur
  Wir haben uns erst einmal Gedanken darüber gemacht, wie wir unser Projekt aufbauen können. Dazu ist es wichtig zu wissen, welche
  Microservices wir überhaupt brauchen, um eine TaskListe entwickeln zu können. In den Folgenden Punkten gehen wir genauer darauf ein 
  welche Technologien in unserem Projekt vorkommen und welche Microservices wir entwickelt haben. 
  a.Technologien
    -	Spring Boot: Unser Backend Code wurde hauptsächlich mit Springboot realisiert.  Dabei war es wichtig REST-Services zu verwenden um
      die Kommunikation zwischen unseren Microservices zu ermöglichen. 
    -	Spring Data JPA 
    -	Spring Web
    -	Thymeleaf: Mit Thymeleaf haben wir unsere UI erstellt. 
    -	Eureka
    -	Docker
    -	H2 Datenbank
    - resilience Fallback Netflix
    
  b. Microservices
     Unsere Applikation hat folgende Microservices: 
     auth-service: Dieser Service übernimmt die gesamte Authentifizierung. Sie ist zuständig für das registrieren und den Login.
     eureka-service: 
     frontend-service: Der frontend-Service bildet unsere gesamte UI. Sie kommuniziert mit allen anderen Services. 
     todos-infos-service: 
     todos-service:

3. Anleitung
  - Added jQuery code to call auth service for registration https://github.com/cyber-  tooth/TaskListie/blob/feature/dockerize/frontend/src/main/resources/public/vt_register.html
  - Added config classes to allow cross origin, and to disable csrf https://github.com/cyber-  tooth/TaskListie/commit/5a35d392a42951bfbd58454f7b3b7d463bd8e027
   - in todos-service: docker-compose build (to build the image or build the latest image with changes)
   - docker-compose up (starts the docker)
   - our Dockerfile is in deploy directory because we want to keep clean the path directory so everything that is related to deployment
    (eg certificates) would go to that directory
   - docker-compose.yml file is to help to run it and because we want to run in the same way we put it in main folder tasklistie so then
     we have to run only one command instead of 5
   - docker-compose down (shuts it down)
   - docker-compose up -d (runs docker on the background so you can use terminal while its building)

