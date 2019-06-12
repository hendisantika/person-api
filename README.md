# person-api

## Prerequiresites

1. You have to install JDK on your local environment.
2. You have to installed maven on your local environment.

## Things to do:
1. Run this command on your terminal to test: `mvn clean test`
2. Run this command on your terminal to run the app: `mvn clean spring-boot:run`
3. Type this on your terminal : `curl http://localhost:8080/api/person | jq .`
   Response:
   ```
   {
      "gender": "female",
      "fullName": "mrs alice roy",
      "address": "2328 36th ave, sherbrooke",
      "pictures": "https://randomuser.me/api/portraits/women/85.jpg"
    }
   ```
   
   If you hit again it will response random values:
   ```
   {
      "gender": "female",
      "fullName": "miss sham burud",
      "address": "suhms gate 5807, eidsvik",
      "pictures": "https://randomuser.me/api/portraits/women/48.jpg"
    }
   ```     
