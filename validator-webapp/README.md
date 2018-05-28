## validator-webapp

The webapp/client directory was generated by Swagger using the `beacon-aggregator-spec.yaml` specification file. ApiClient was modified slightly to expose the requesting URL. This will have to be added again if the client code is ever regenerated unless you use the `--skip-overwrite` flag with Swagger.

Make sure to setup `/webapp/configfile` properly. You need to copy the *'configfile-template'* file into *'configfile'* and change the secret key. You will want to generate your own secret key. You can do this with python:
```python
>>> import os
>>> os.urandom(24)
'\xfd{H\xe5<\x95\xf9\xe3\x96.5\xd1\x01O<!\xd5\xa2\xa0\x9fR"\xa1\xa8'

# Just take that thing and copy/paste it into your *'configfile'* and you're done.
```
This suggestion was taken from http://flask.pocoo.org/docs/0.12/quickstart/, you can read more there.

Run the application with Docker. On Linux:

```shell
cd validator-webapp
docker build -t validator .
docker run --rm -p 5000:5000 validator
```

Note that depending on how your Docker installation is set up, you may need to use *'sudo'* to run these docker commands.  The `--rm` flag for `docker run` ensures that the container will be deleted after closing, so that containers don't add up every time you run the image. The `-p` flag bridges ports from within the container to the host network. The application will run on port 5000 within the container, and we map it to the host's port 5000.

With the application running, open your browser to http://localhost:5000 to see the UI in action.

Along with the UI on the main page, there are two API calls:

http://localhost:5000/tests will return a json page of all the tests available, looking something like this:
```json
[
  "statement pagination",
  "is online",
  "workflow",
  "concept pagination",
  "always fails"
]
```
You can then use `http://localhost:5000/test/<path : beacon_url>` to run a test on any beacon (including beacons that aren't known to the beacon aggregator). This call takes a list parameter named `tests`, with which you can choose which tests to be run. If you don't include the `tests` parameter, then all tests will be run. Keep in mind that running all tests in one go may be very slow.

http://localhost:5000/test/http://rkb.ncats.io?tests=is+online&tests=always+fails

Note, spaces in the `tests` parameter don't necessarily need to be URL encoded, but it's generally a good idea.

This will run the tests "is online" and "always fails" for http://rkb.ncats.io, resulting in a json response looking like:
```json
[
  {
    "error": null,
    "passed": true,
    "test_name": "is online"
  },
  {
    "error": {
      "message": "This test always automatically fails. There was no offending URL because no API request to the beacon was made.",
      "type": "FailedTestException",
      "url_request": null
    },
    "passed": false,
    "test_name": "always fails"
  }
]
```