# VideoTutorialsManager
* E-learning data repository for storing and managing tutorials. 
* Including functionalities like time management and  rating of tutorials.

# Main technologies: 
 * Java 8, Spring MVC, Spring Security, Spring RestTemplate, Hibernate, MySql, Jetty, Maven 
 * Integration with NOEMBED Rest API
 
### Functionalities
* User can store his favorite video tutorials
* When Tutorial comes from known provider like YouTube or Vimeo
* Data are fetched dynamically by noembed service
* by given URL to the video tutorial
* User can store his plan in what time period wants to watch the tutorials
* Store the progress about a given tutorial
* add do rating of the tutorials
* and divide tutorials to categories

### App start
* first run script in file DATABASE/DDL for database creation
* second: type url = http://localhost:8080/TutorialsManager/init-data
* this url will init start data and users:
* user 1: login=admin password=admin and user 2: login=user password=user

