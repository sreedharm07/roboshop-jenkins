def call() {

    node('workstation') {
        sh " find . | sed -e '1d' | xargs rm -rf "
        git branch: 'main', url: "https://github.com/sreedharm07/a-${cart}"

        stage('compile-code') {
            common.compile()
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