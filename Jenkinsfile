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
        //  stage('Test') { 
        //      environment {
        //          GIT_COMMIT = ""
        //      }

        //     steps {
        //         script {
        //          def scmVars = checkout([$class: 'GitSCM', 
        //             branches: [[name: '*/master']], 
        //             doGenerateSubmoduleConfigurations: false, 
        //             extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
        //             submoduleCfg: [], 
        //             userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])  
        //          GIT_COMMIT = scmVars.GIT_COMMIT
        //      }
        //         echo "Commit ist ${GIT_COMMIT}"
        //        teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
        //        teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
          
        //     }
        // }
    }
    post { 
            always {
               
            //     script {
            //      def GIT_COMMIT = ""
            //      def scmVars = checkout([$class: 'GitSCM', 
            //         branches: [[name: '*/master']], 
            //         doGenerateSubmoduleConfigurations: false, 
            //         extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
            //         submoduleCfg: [], 
            //         userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])  
            //      GIT_COMMIT = scmVars.GIT_COMMIT
            //  }
                echo "Commit ist ${GIT_COMMIT}"
               teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
               teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
          
            }
    }
}
