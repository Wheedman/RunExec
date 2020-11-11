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
                sh 'printenv'
            }
        }

        stage('Deploy') { 
            steps {
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
