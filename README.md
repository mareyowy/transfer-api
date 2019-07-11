# transfer-api

 ## Requirements:
  - Java 11
  - Maven 3+
  
 ## Running
  - build 
  ```
  mvn clean install
  ```
  - run
  ```
  mvn tomcat7:run
  ```
  
  ## API
  - save transfer
  ```
  transfer-api/rest/transfer
  ```
  
  ```json
  {
                "senderAccount": "PL30249000053679780493680750",
                "recipientAccount": "PL58249000059226380531859730",
                "recipientName": "Krystyna Nowak",
                "recipientAddress": "ul.Zwyczajna 2/1",
                "amount": 250.00,
                "title": "Przelew zwykły",
                "userId" : 1
}
```
- get transfer details
```
transfer-api/rest/transfer/{transferId}
```
- get transfers by account iban
```
transfer-api/rest/transfer/account/{iban}
```
