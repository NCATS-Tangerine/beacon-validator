# Beacon Validator

The client project was generated with Swagger, but also modified slightly. Check the `git diff` upon regeneration.

Use gradle 4 to build.

# Testing in command line

The easiest way to run these tests is with gradle (currently, release 4.\* of Gradle is assumed) in the command line:

```
gradle test
```

By default it will use the URI set with the `basePath` property in `validator/src/main/resources/application.properties`. You should set this value before running the test. Alternatively, you can set it when running gradle like this:

```shell
basePath="https://kba.ncats.io/beacon/rhea/" gradle test
```
After finishing, results will be saved to `validator/log/{host}/` directory. There will be a separate file for each failing test, detailing the problem and providing the URI that caused the test to fail. There will also be `validator/log/{host}/application.log` which will contain timing statistics.
