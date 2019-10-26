build:
	docker build -t jenkins/validator .
	
run:
	docker run -u 0 -d --name='jenkins' -p 8080:8080 -p 50000:50000 -v `pwd`/jenkins_home:/var/jenkins_home jenkins/validator

start:
	docker start jenkins

stop:
	docker stop jenkins
	
log:
	docker logs jenkins -f

clean_docker_container:
	docker rm jenkins

clean_jenkins_home:
	rm -rf jenkins_home
	
generate-beacon:
	wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.8/swagger-codegen-cli-2.4.8.jar -O swagger-codegen-cli.jar
	java -jar swagger-codegen-cli.jar generate -i beacon-api.yaml -l spring -o beacon-client --model-package bio.knowledge.beacon.model --api-package bio.knowledge.beacon.api --additional-properties basePackage=bio.knowledge.beacon,configPackage=bio.knowledge.beacon.config
	
generate-aggregator:
	wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.8/swagger-codegen-cli-2.4.8.jar -O swagger-codegen-cli.jar
	java -jar swagger-codegen-cli.jar generate -i beacon-aggregator-api.yaml -l spring -o aggregator-client --model-package bio.knowledge.aggregator.model --api-package bio.knowledge.aggregator.api --additional-properties basePackage=bio.knowledge.aggregator,configPackage=bio.knowledge.aggregator.config
	
