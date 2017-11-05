# offer
Offer Spring Boot Web Application

## Development
Developed in STS 3.9.1
```$ java -version
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)
```
```$ mvn -v
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T20:39:06+01:00)
Maven home: C:\Program Files\apache-maven-3.5.0
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_121\jre
Default locale: en_GB, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

### Build and run
1. Download the project https://github.com/szrevesz/offer/archive/master.zip
2. Unzip
3. Go the the main directory of the project
4. Build the jar file
```
mvn package
```
5. Run the jar file
```
java -jar target/offer-0.0.1-SNAPSHOT.jar
```
6. In a browser try to open http://localhost:8080/api/offers, it should return an empty list

## Tests
Using `curl`

#### Adding new offer
```curl -X POST -d goods=Product%20One -d description=Buy%20me%20now -d price=199.99 -d currency=GBP http://localhost:8080/api/offer```

#### Modifying an offer
```curl -X PUT -d id=1 goods=Product%20Two -d description=Buy%20me%20now -d price=100.99 -d currency=USD http://localhost:8080/api/offer```

#### Deleting an offer
```curl -X DELETE http://localhost:8080/api/offer/1```

#### Get an offer
```curl http://localhost:8080/api/offer/1```

#### Get all the offers
```curl http://localhost:8080/api/offers```

## MVN test
After running the `mvn clean test` command there was no any error:
```
Tests run: 15, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 21.483 s
[INFO] Finished at: 2017-11-05T01:34:28Z
[INFO] Final Memory: 30M/273M
[INFO] ------------------------------------------------------------------------
```
