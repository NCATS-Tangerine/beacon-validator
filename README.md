# beacon-tester

## Use

You can get the `beacon-tester.jar` file with `wget https://github.com/lhannest/beacon-tester/raw/master/beacon-tester.jar`.

Usage: java -jar beacon-tester.jar beacon-url [keyword...]

By default the keyword is "e" (since it is the most common character in the English language). You can change this by setting the `keyword` parameter. For example:

java -jar beacon-tester.jar https://biolink-kb.ncats.io diabetes

## Issues

This application tests the syntax of respones, pagination, and semantic filtering for a knowledge beacon. Improper syntax will result in the swagger generated client code not able to parse the response, and an exception will be thrown. Testing pagination and semantic filtering is more failable. What happens is:

- Get the first page of up to size 50, and then attempts to get this same data in two pages half the size of the original. If the two half pages concatenated are not equivalent to the first whole page, then the beacon will fail.

- For each of the possible semantic filters, get a page of size 50 of data with that filter applied. If any data is returned that does not match that filter, then the beacon fails the test.


## Setting up the tests

Assumptions need to be made about the sort of data in the database. Since 'e' is the most common character in the English language, this single character will be used as a keyword in most of the queries. If this is innapropriate for your beacon for whatever reason, you can change the keyword(s) with the applications parameter.
