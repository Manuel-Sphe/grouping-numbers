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

NB : 
I used Spring Container(IoC) for Dependency injection, also used Lazy initialisation to only construct a Bean when it's needed


## Output After running the project 
* You'll see the TEST section, runs the Tests file
```shell
./mvnw clean spring-boot:run
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< sphe.solution:grouping >-----------------------
[INFO] Building grouping 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.2.0:clean (default-clean) @ grouping ---
[INFO] Deleting /Users/sphesihle/Downloads/grouping/target
[INFO]
[INFO] >>> spring-boot-maven-plugin:3.0.5:run (default-cli) > test-compile @ grouping >>>
[INFO]
[INFO] --- maven-resources-plugin:3.3.0:resources (default-resources) @ grouping ---
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.10.1:compile (default-compile) @ grouping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/sphesihle/Downloads/grouping/target/classes
[INFO]
[INFO] --- maven-resources-plugin:3.3.0:testResources (default-testResources) @ grouping ---
[INFO] skip non existing resourceDirectory /Users/sphesihle/Downloads/grouping/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.10.1:testCompile (default-testCompile) @ grouping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/sphesihle/Downloads/grouping/target/test-classes
[INFO]
[INFO] <<< spring-boot-maven-plugin:3.0.5:run (default-cli) < test-compile @ grouping <<<
[INFO]
[INFO]
[INFO] --- spring-boot-maven-plugin:3.0.5:run (default-cli) @ grouping ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.5)

2023-04-05T10:04:30.483+02:00  INFO 60378 --- [  restartedMain] s.solution.grouping.GroupingApplication  : Starting GroupingApplication using Java 20 with PID 60378 (/Users/sphesihle/Downloads/grouping/target/classes started by sphesihle in /Users/sphesihle/Downloads/grouping)
2023-04-05T10:04:30.485+02:00  INFO 60378 --- [  restartedMain] s.solution.grouping.GroupingApplication  : No active profile set, falling back to 1 default profile: "default"
2023-04-05T10:04:30.509+02:00  INFO 60378 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2023-04-05T10:04:30.763+02:00  INFO 60378 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2023-04-05T10:04:30.774+02:00  INFO 60378 --- [  restartedMain] s.solution.grouping.GroupingApplication  : Started GroupingApplication in 0.474 seconds (process running for 0.686)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.459 s
[INFO] Finished at: 2023-04-05T10:04:31+02:00
[INFO] ------------------------------------------------------------------------
(base) ➜  grouping git:(main) ✗ ./mvnw test
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< sphe.solution:grouping >-----------------------
[INFO] Building grouping 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:3.3.0:resources (default-resources) @ grouping ---
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.10.1:compile (default-compile) @ grouping ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.3.0:testResources (default-testResources) @ grouping ---
[INFO] skip non existing resourceDirectory /Users/sphesihle/Downloads/grouping/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.10.1:testCompile (default-testCompile) @ grouping ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ grouping ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running sphe.solution.grouping.GroupingApplicationTests
10:04:48.294 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Neither @ContextConfiguration nor @ContextHierarchy found for test class [GroupingApplicationTests]: using SpringBootContextLoader
10:04:48.296 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader -- Could not detect default resource locations for test class [sphe.solution.grouping.GroupingApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
10:04:48.296 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [sphe.solution.grouping.GroupingApplicationTests]: GroupingApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
10:04:48.311 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Using ContextCustomizers for test class [GroupingApplicationTests]: [ExcludeFilterContextCustomizer, DuplicateJsonObjectContextCustomizer, MockitoContextCustomizer, TestRestTemplateContextCustomizer, DisableObservabilityContextCustomizer, PropertyMappingContextCustomizer, Customizer]
10:04:48.355 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider -- Identified candidate component class: file [/Users/sphesihle/Downloads/grouping/target/classes/sphe/solution/grouping/GroupingApplication.class]
10:04:48.356 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration sphe.solution.grouping.GroupingApplication for test class sphe.solution.grouping.GroupingApplicationTests
10:04:48.401 [main] DEBUG org.springframework.test.context.util.TestContextSpringFactoriesUtils -- Skipping candidate TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener] due to a missing dependency. Specify custom TestExecutionListener classes or make the default TestExecutionListener classes and their required dependencies available. Offending class: [jakarta/servlet/ServletContext]
10:04:48.403 [main] DEBUG org.springframework.test.context.util.TestContextSpringFactoriesUtils -- Skipping candidate TestExecutionListener [org.springframework.test.context.transaction.TransactionalTestExecutionListener] due to a missing dependency. Specify custom TestExecutionListener classes or make the default TestExecutionListener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttributeSource]
10:04:48.404 [main] DEBUG org.springframework.test.context.util.TestContextSpringFactoriesUtils -- Skipping candidate TestExecutionListener [org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener] due to a missing dependency. Specify custom TestExecutionListener classes or make the default TestExecutionListener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttribute]
10:04:48.406 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Using TestExecutionListeners for test class [GroupingApplicationTests]: [DirtiesContextBeforeModesTestExecutionListener, ApplicationEventsTestExecutionListener, MockitoTestExecutionListener, DependencyInjectionTestExecutionListener, DirtiesContextTestExecutionListener, EventPublishingTestExecutionListener, ResetMocksTestExecutionListener, RestDocsTestExecutionListener, MockRestServiceServerResetTestExecutionListener, MockMvcPrintOnlyOnFailureTestExecutionListener, WebDriverTestExecutionListener, MockWebServiceServerTestExecutionListener]
10:04:48.406 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener -- Before test class: class [GroupingApplicationTests], class annotated with @DirtiesContext [false] with mode [null]
10:04:48.414 [main] DEBUG org.springframework.test.context.support.DependencyInjectionTestExecutionListener -- Performing dependency injection for test class sphe.solution.grouping.GroupingApplicationTests

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.5)

2023-04-05T10:04:48.571+02:00  INFO 60423 --- [           main] s.s.grouping.GroupingApplicationTests    : Starting GroupingApplicationTests using Java 20 with PID 60423 (started by sphesihle in /Users/sphesihle/Downloads/grouping)
2023-04-05T10:04:48.572+02:00  INFO 60423 --- [           main] s.s.grouping.GroupingApplicationTests    : No active profile set, falling back to 1 default profile: "default"
2023-04-05T10:04:48.828+02:00  INFO 60423 --- [           main] s.s.grouping.GroupingApplicationTests    : Started GroupingApplicationTests in 0.397 seconds (process running for 0.947)
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.903 s - in sphe.solution.grouping.GroupingApplicationTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.459 s
[INFO] Finished at: 2023-04-05T10:04:49+02:00
[INFO] ------------------------------------------------------------------------
(base) ➜  grouping git:(main) ✗ ./mvnw clean spring-boot:run
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< sphe.solution:grouping >-----------------------
[INFO] Building grouping 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.2.0:clean (default-clean) @ grouping ---
[INFO] Deleting /Users/sphesihle/Downloads/grouping/target
[INFO]
[INFO] >>> spring-boot-maven-plugin:3.0.5:run (default-cli) > test-compile @ grouping >>>
[INFO]
[INFO] --- maven-resources-plugin:3.3.0:resources (default-resources) @ grouping ---
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.10.1:compile (default-compile) @ grouping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/sphesihle/Downloads/grouping/target/classes
[INFO]
[INFO] --- maven-resources-plugin:3.3.0:testResources (default-testResources) @ grouping ---
[INFO] skip non existing resourceDirectory /Users/sphesihle/Downloads/grouping/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.10.1:testCompile (default-testCompile) @ grouping ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/sphesihle/Downloads/grouping/target/test-classes
[INFO]
[INFO] <<< spring-boot-maven-plugin:3.0.5:run (default-cli) < test-compile @ grouping <<<
[INFO]
[INFO]
[INFO] --- spring-boot-maven-plugin:3.0.5:run (default-cli) @ grouping ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.5)

2023-04-05T10:04:59.868+02:00  INFO 60467 --- [  restartedMain] s.solution.grouping.GroupingApplication  : Starting GroupingApplication using Java 20 with PID 60467 (/Users/sphesihle/Downloads/grouping/target/classes started by sphesihle in /Users/sphesihle/Downloads/grouping)
2023-04-05T10:04:59.870+02:00  INFO 60467 --- [  restartedMain] s.solution.grouping.GroupingApplication  : No active profile set, falling back to 1 default profile: "default"
2023-04-05T10:04:59.894+02:00  INFO 60467 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2023-04-05T10:05:00.138+02:00  INFO 60467 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2023-04-05T10:05:00.149+02:00  INFO 60467 --- [  restartedMain] s.solution.grouping.GroupingApplication  : Started GroupingApplication in 0.455 seconds (process running for 0.647)
```