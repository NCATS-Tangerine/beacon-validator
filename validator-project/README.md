# Knowledge Beacon Validator

This subprojects contains three of its own. The `aggregator-client` and `beacon-client` subprojects contain classes  for querying the Beacon Aggregator and the beacons, and the `validator` contains tests.

Before use [application.properties](validator/main/resources/application.properties) must be created if not already existing, and configured.

The tests are mainly metamorphic, checking that certain relations hold between the inputs and outputs of endpoints. The single letter "e" is often used as a query keyword to blindly get records from the data source. As such, only the API implementation is being tested. These tests offer no assurance that the statements being reported through this API is meaningful or true.
