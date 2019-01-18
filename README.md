# Beacon Validator

The client project was generated with Swagger, but also modified slightly. Check git diff upon regeneration.

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

This will overwrite the `basePath` property in application.properties.
