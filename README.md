# Front for GiphyProject
Frontend-часть приложения для получения gif-изображений в зависимости от разницы курсов валют.

Для запуска приложения необходимо:
1. Выгрузить репозиторий на свой ПК, на котором заранее установлено JRE или JDK;
2. В папке ...\Front\build\libs открыть командную строку и запустить в ней команду:
```  
java -jar Front-1.0-SNAPSHOT.jar
```
3. Открыть браузер и перейти по адресу:
```  
http://localhost:8090/front
```
Для полноценной работы также необходимо запустить backend-часть приложения
(https://github.com/RSVarfolomeev/GiphyProject).
Значение валюты, которая сравнивается с USD, должно состоять из 3-х символов: EUR, CNY, RUB и т.д.

Docker:
---
Для создания образа Docker перейти в корневую папку приложения "GiphyProject", где лежит файл Dockerfile,
открыть командную строку и запустить в ней команду:
```  
docker build -t giphy_project_front .
```
Запуск контейнера:
```
docker run -d -p 8090:8090 giphy_project_front
```
---
#### Используемый стек технологий:

---

Java 11, Spring Boot, Thymeleaf, Gradle
