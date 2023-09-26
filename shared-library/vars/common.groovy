def compile () {

    if (env.code_type == "python") {
        return "nodejs has no dependencies"
    }

    if (env.code_type == "static") {
        return "frontend has no dependencies"
    }

    stage("compile") {
        if (env.code_type == "maven") {
            sh '/home/centos/maven/bin/mvn package'
        }

        if (env.code_type == "nodejs") {
            sh 'npm install'
        }
    }
}

    def test () {
        stage("test") {
//            if (env.code_type == "nodejs") {
//                sh 'npm test'
//            }
//            if (env.code_type == "python") {
//                sh 'python3.6 -m unittest '
//            }
//            if (env.code_type == "maven") {
//                sh '/home/centos/maven/bin/mvn test'
//            }}
            print 'ok'
        }
    }

    def codequality () {

//        sonaruser =  sh ' aws ssm get-parameter --name "sonar.user" --query="Parameter.Value"'
//        sonarpass =  sh ' aws ssm get-parameter --name "sonar.password" --with-decryption --query="Parameter.Value"'
        stage("codequality") {
            env.sonaruser = sh(script: 'aws ssm get-parameter --name "sonar.user" --query="Parameter.Value" | xargs', returnStdout: true).trim()
            env.sonarpass = sh(script: 'aws ssm get-parameter --name "sonar.password" --with-decryption --query="Parameter.Value" | xargs', returnStdout: true).trim()

            wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: sonarpass]]]) {
                if (env.code_type == "maven") {
                    print 'ok'
//                    sh 'sonar-scanner -Dsonar.host.url=http://172.31.89.172:9000 -Dsonar.login=${sonaruser} -Dsonar.password=${sonarpass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true -Dsonar.java.binaries=./target'
                } else {
                    print 'ok'
//                    sh 'sonar-scanner -Dsonar.host.url=http://172.31.89.172:9000 -Dsonar.login=${sonaruser} -Dsonar.password=${sonarpass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
                }
            }
        }
    }

    def codesecurity () {
        stage("codesecurity") {
            print "codesecurity"
        }
    }

def release () {
    stage("release") {
        if (code_type == "nodejs") {
   sh 'zip -r ${component}-${TAG_NAME}.zip package.json node_module'
        }
    }
}
