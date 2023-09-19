def call ()

    node('workstation') {
        stage('Compile-code') {
            common.compile
        }

        stage('test') {
            echo 'test'
        }

        stage('code-quality') {
            echo 'code-quality'
        }

        stage('code-security') {
            echo 'code-security'
        }

        stage('release') {
            echo 'release'
        }
    }
}