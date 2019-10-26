pipeline {

    agent any

    triggers {
        cron('H H * * *') //regular build every day
        pollSCM('* * * * *') //polling for changes, here once a minute
    }

    stages {
        stage('Testing') {
            when {
                not {
                    branch 'master'
                }
            }

            steps {
				dir("./validator-project") {
					script {
                	    try {
                            // Run beacon tests (in package bio.knowledge.validator) excluding tests in the aggregator-client and beacon-client sub-project.
                            sh './gradlew clean test -x :aggregator-client:test -x :beacon-client:test --tests "bio.knowledge.validator.beacon.*" --no-daemon'
                	    } finally {
                	        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                	    }
                	}
				}
            }
        }
    }

    post {
        always {
            script {
                if (env.BRANCH_NAME != 'master') {
        	        archiveArtifacts artifacts: '**/build/reports/**', fingerprint: true
                }
            }
        }
    }
}

