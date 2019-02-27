# Zonky Marketplace 

### Zadání
Zkuste naprogramovat kod, ktery bude kazdych 5m kontrolovat nove pujcky na Zonky.cz trzisti a ty vypise. 
Programove API Zonky trziste je dostupne na adrese https://api.zonky.cz/loans/marketplace dokumentace http://docs.zonky.apiary.io/#). 
Vyber technologii nechame na Vas, jenom at je to prosim v Jave. Berte to tak, ze kod je vasi vizitkou...

### Jak spustit aplikaci
```
mvnw clean spring-boot:run
```

### Poznámky
Oblasti k dalšímu vylepšení:
- lepsi osetreni vyjimek u RestTemplate klienta
- rozdeleni do modulů
- více testů
- přesunutí některých konstant do application.properties apod...