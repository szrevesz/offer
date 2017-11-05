# offer
Offer Web Application

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
