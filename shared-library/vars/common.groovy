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
        stage("codequality") {
            print "codequality"
        }
    }

    def codesecurity () {
        stage("codesecurity") {
            print "codesecurity"
        }
    }

def release () {
    stage("release") {
        print "release"
    }
}


