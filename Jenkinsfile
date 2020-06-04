node{
  checkout([$class: 'GitSCM', 
            branches: [[name: '*/master']], 
            doGenerateSubmoduleConfigurations: false, 
            extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
            submoduleCfg: [], 
            userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])
  step([$class: 'TeamscaleUploadBuilder', 
        url: 'http://localhost:8100',
        userName: 'admin',
        ideKey: 'n96xxdkcotjmk4kyzJfCRujcj5sg7W7o',
        teamscaleProject: 'jenkinsplugin',
        partition: 'pipeline',
        uploadMessage: 'Test',
        antPatternForFileScan: '**/*.simple',
        reportFormatId: 'SIMPLE']) // OK
}
