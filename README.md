**Dokumentation Task-Liste** <br>
Projekt von: <br>
Adriyana Grotseva    s0527080, <br>
Anna Sokolov         s0563332, <br>
Ksenia Tereshenkova s0564412, <br>
Kübra Demir         s0553666 <br>
<br>
**1.Thema**<br>
  In unserem Projekt haben wir eine Taskliste entwickelt. Ein User kann sich auf der Seite registrieren und anschließend einloggen. Nach dem Log-In kommt er auf seine individuelle Taskliste. <br>
  Der Aufbau der Taskliste sieht folgendermaßen aus: <br>
 -Unter dem Reiter Add Item, kann der User eine beliebige Task erstellen.<br>
 -Beim klicken auf das add-Button wird die Task in den Reiter ‚ToDo‘ übernommen. Dies ist die ToDo-Liste vom User. <br>
 -Bei der ‚ToDo‘-Liste hat der User die Möglichkeit die Task zu editieren (bzw. umbenennen), zu löschen oder ein Häkchen zu setzen falls die Task abgearbeitet wurde. <br>
 -Wenn ein Häkchen gesetzt wird, erscheint die Task in dem Reiter ‚completed‘. <br>
 -In ‚completed‘ stehen abgeschlossene Tasks. Der User hat hier dieselben Möglichkeiten wie auf dem Reiter ‚ToDo‘. Ergänzend kommt noch hinzu, dass der User das Häkchen wieder rausnehmen kann und die Task dann wieder zurück in die ‚ToDo‘-Liste kommt.<br> 
<br><br>
**2.Architektur**<br>
  Wir haben uns erst einmal Gedanken darüber gemacht, wie wir unser Projekt aufbauen können. Dazu ist es wichtig zu wissen, welche Microservices wir überhaupt brauchen, um eine TaskListe entwickeln zu können. In den Folgenden Punkten gehen wir genauer darauf ein, welche Technologien in unserem Projekt vorkommen und welche Microservices wir entwickelt haben. <br>
  **a.Technologien:** <br>
    -	Spring Boot: Unser Backend Code wurde hauptsächlich mit Springboot realisiert.  Dabei war es wichtig REST-Services zu verwenden um die Kommunikation zwischen unseren Microservices zu ermöglichen. <br>
    -	Spring Data JPA <br>
    -	Spring Web<br>
    -	Thymeleaf: Mit Thymeleaf haben wir unsere UI erstellt. <br>
    -	Eureka<br>
    -	Docker<br>
    -	H2-Datenbank<br>
    - resilience Fallback Netflix<br>
    <br>
  **b. Microservices**<br>
     Unsere Applikation hat folgende Microservices: <br>
     auth-service: Dieser Service übernimmt die gesamte Authentifizierung. Sie ist zuständig für das registrieren und den Login.<br>
     (eureka-service: Der Service zum Verbinden von anderen MS)<br>
     frontend-service: Der frontend-Service bildet unsere gesamte UI. Sie kommuniziert mit allen anderen Services. <br>
     todos-infos-service: Dieser Service verteilt die Tasks in Kategorien sowohl erlaubt, die Tasks zu Favoriten hinzuzufügen<br>
     todos-service: Dieser Service lässt, die eingegebene Tasks zu speichern und später die erledigten Tasks abzuhacken.
<br>
<br><br>
**3. Anleitung**<br>
  - Added jQuery code to call auth service for registration https://github.com/cyber-  tooth/TaskListie/blob/feature/dockerize/frontend/src/main/resources/public/vt_register.html<br>
  - Added config classes to allow cross origin, and to disable csrf https://github.com/cyber-  tooth/TaskListie/commit/5a35d392a42951bfbd58454f7b3b7d463bd8e027<br>
   - in todos-service: docker-compose build (to build the image or build the latest image with changes)<br>
   - docker-compose up (starts the docker)<br>
   - our Dockerfile is in deploy directory because we want to keep clean the path directory so everything that is related to deployment (eg certificates) would go to that directory<br>
   - docker-compose.yml file is to help to run it and because we want to run in the same way we put it in main folder tasklistie so then we have to run only one command instead of 5<br>
   - docker-compose down (shuts it down)<br>
   - docker-compose up -d (runs docker on the background so you can use terminal while its building)

