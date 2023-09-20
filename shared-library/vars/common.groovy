def compile () {
    stage("compile") {
        if (code_type == "maven") {
            sh '/home/centos/maven/bin/mvn package'
        }

        if (code_type == "python") {
            print 'python'
        }

        if (code_type == "nodejs") {
           sh 'npm install'
        }

        if (code_type == "static") {
            print 'static'
        }
    }
}

    def test () {
        stage("test") {
            print "test"
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


