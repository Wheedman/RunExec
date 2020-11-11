pipeline {
    agent any
    
    stages {
         stage('Build') { 
            steps {
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])  
            }
        }
         stage('Test') { 
             environment {
                 TEST = 15
                 GIT_COMMIT = """${sh(
                returnStdout: true,
                     script:  script{
                         def scmVars = git 'https://github.com/Wheedman/RunExec.git'
                         echo "${scmVars.GIT_COMMIT}"
                     }
                   
            )}"""
             }
            steps {
                echo "Commit ist ${GIT_COMMIT}"
                echo "Test is ${TEST}"
                git 'https://github.com/Wheedman/RunExec.git'
                teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100'
            }
        }


        stage('Deploy') { 
            environment {
                GIT_COMMIT = "${env.GIT_COMMIT}"
            }
            steps {
                sh 'echo "${env.GIT_COMMIT}"'
                step([$class: 'TeamscaleUploadBuilder', 
                  url: 'http://localhost:8100',
                  credentialsId: 'teamscale_id', 
                  teamscaleProject: 'jenkinsplugin',
                  partition: 'pipeline',
                  uploadMessage: 'Test',
                  antPatternForFileScan: '**/*.simple',
                  reportFormatId: 'SIMPLE']) // OK
            }
        }
    }
}
