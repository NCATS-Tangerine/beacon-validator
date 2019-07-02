# Beacon Validator

The client project was generated with Swagger, but also modified slightly. Check the `git diff` upon regeneration.

Use gradle 4 to build.

# Testing in command line

Note that the following properties need to be set before running the standalone tests:
 
 1. the `basePath` property in `validator/src/main/resources/application.properties` (Copy over the template file)
 2. the 'beacon_test_dir' property in the gradle.properties file (in the root directory) will override the location 
 of the test output (copy over the template file).

With these properties set, the current way to run these tests is with gradle on the command line (note, 
release 4.\* of Gradle is needed to run them) in the command line:

```
gradle test
```

After finishing, results will be saved to `validator/log/{host}/` directory. There will be a separate file for each 
failing test, detailing the problem and providing the URI that caused the test to fail. There will also be 
`validator/log/{host}/application.log` which will contain timing statistics.

(Sorry... setting up the properties files is still somewhat manual... This test process needs further automation!)