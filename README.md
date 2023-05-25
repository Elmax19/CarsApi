## Starting the application:
1) _git clone_ this repository
2) add in **Project Settings** UserConsumerService as a module (in case of its absence)
3) create local **MySQL** database with name _"cars"_
4) run command _"mvn clean package"_ for **CarsApi** and **UserConsumerService** modules
5) in the root folder execute command _"docker-compose build"_ (stop the **MySQL80** service in case of an error that 
the port is not available)
6) execute _"docker-compose up"_

## Api testing 
You can _import_ **"Cars API.postman_collection.json"** file located in the root project directory in Postman