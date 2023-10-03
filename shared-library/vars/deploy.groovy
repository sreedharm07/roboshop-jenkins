def call() {

    pipeline {
        agent any

        parameters {
            string(name: 'COMPONENT', defaultValue: '', description: 'which component to deploy ?')
            string(name: 'ENV', defaultValue: '', description: 'which environment to deploy ?')
            string(name: 'VERSION', defaultValue: '', description: 'which version to deploy ?')
        }


        stages {
            stage('aws-parameter value update') {
                sh '''
                aws ssm put-parameter --name "${COMPONENT}.${ENV}.${VERSION}" --type "String" --value "1.0.2" --overwrite
                
                '''
            }

            stage('deploy') {
                steps {
                    echo "ok"
//                    sh '''
//
//
//'''
                }
            }
        }
    }
    post {
        always{
            ClearWc()
        }
    }
}