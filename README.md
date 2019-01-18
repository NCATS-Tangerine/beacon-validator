# Beacon Validator

The client project was generated with Swagger, but also modified slightly. Check the `git diff` upon regeneration.

Use gradle 4 to build.

# Testing in command line

The easiest way to run these tests is with gradle in the command line:

```
gradle4 test
```

By default it will use the URI set with `basePath` in `validator/src/main/resources/application.properties`. Alternatively, and much easier, you can set it when running gradle like this:

```shell
basePath="https://kba.ncats.io/beacon/rhea/" gradle4 test
```
After finishing, results will be saved to `validator/log/{host}/` directory. There will be a separate file for each failinig test detailing the problem and providing the URI that caused the test to fail. There will also be `validator/log/{host}/application.log` which will contain timing statistics.
