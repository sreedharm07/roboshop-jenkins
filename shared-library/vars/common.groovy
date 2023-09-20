def compile () {

    if (code_type == "nodejs") {
        return "nodejs has no dependencies"
    }

    if (code_type == "static") {
        return "frontend has no dependencies"
    }

    stage("compile") {
        if (code_type == "maven") {
            sh '/home/centos/maven/bin/mvn package'
        }

        if (code_type == "python") {
            print 'python'
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


