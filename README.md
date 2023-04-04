# Grouping-numbers

## Task
* Implement the `NumberRangeSummarizer` Interface and override the methods to produce a comma delimited list of numbers,
grouping the numbers into a range when they are sequential.


## My Approach
* I created a Spring-boot Project using the [Spring Initializr](https://start.spring.io/)
* I chose Java(version 17) as the language and Maven as a Project Management Tool.
* And Spring Boot 3.0.5 was selected .
* After Generating the project I then, created `Number.java` which implements `NumberRangeSummarizer`
* I then added the Interface to my project and change it package name from `numberrangesummarizer` to `sphe.solution.grouping.numberrangesummarizer`
* `Number.java` is in `src/main/java/sphe.soution.grouping`
* `NumberRangeSummarizer` is in `src/main/java/sphe.soution.grouping.numberarrangesummarizer`
* I have `GroupingApplicationTests` in `src/test/sphe.solution.groping` - All my Unit Tests are here.

## Requirement to run this project
* Clone this repo 
```bash
git clone https://github.com/Manuel-Sphe/grouping-numbers
```
* Navigate to the project dir 
```bash
cd grouping-numbers       
```
* Run the project using Maven

* If you don't have Maven installed(Mac and Linux) use the Maven Wrapper
```bash
./mvnw clean spring-boot-run
```
* On Windows powershell 
```shell
.\mvnw clean spring-boot:run 
```
* Alternatively you open the project in IntelliJ or Eclipse 