def call() {

    pipeline {
        agent any
        options {
            ansiColor('xterm')

        parameters {
            string(name: 'COMPONENT', defaultValue: '', description: 'which component to deploy ?')
            string(name: 'ENV', defaultValue: '', description: 'which environment to deploy ?')
            string(name: 'VERSION', defaultValue: '', description: 'which version to deploy ?')
        }


        stages {

            stage('aws-parameter value update') {
                steps {
                    sh '''
                aws ssm put-parameter --name "${COMPONENT}.${ENV}.${VERSION}" --type "String" --value "${VERSION}" --overwrite
                
                '''
                }
            }

            stage('deploy') {
                steps {
                    sh '''
aws ec2 describe-instances  --filters "Name=tag:Name,Values=${ENV}-${COMPONENT}" --query "Reservations[*].Instances[*].[PrivateIpAddress]" --output text >inv

ansible-playbook -i inv main.yml -e component=${COMPONENT} -e env=${ENV}

'''
                }
            }
            post {
                always {
                    ClearWc()
                }
            }
        }
    }
}