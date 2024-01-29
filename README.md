# System zdalnej kompresji plików [zip]

## Opis

Aplikacja służy do kompresji przesłanych plików do formatu zip.
Serwer [backend] działa na porcie 8080.
Serwer [frontend] działa na porcie 3000.
Komunikacja jest przewrowadzona za pomocą protokołu HTTP.

## Wymagania wstępne

Do uruchomienia aplikacji potrzebujemy:
- Java 17
- Node.js 18.15

## Uruchomienie

Aby uruchomic serwer spring-boot należy wykonać z głownego katalogu projektu
```bash
java -jar build/libs/zipCompressor-0.0.1-SNAPSHOT.jar
```

Aby uruchomić serwer react nalezy przejść do katalogu /frontend i wykonać
```bash
npm install
npm start
```

## Autor

Jakub Sawa 154058
