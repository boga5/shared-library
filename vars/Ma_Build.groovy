def call() {
Reason = "Maven Build Failed"
   rtMaven.deployer server: server, snapshotRepo: docker_properties.snapshot_repo, releaseRepo: docker_properties.release_repo   //Deploying artifacts to this repo //
   rtMaven.deployer.deployArtifacts = false  //this will not publish artifacts soon after build succeeds //
   rtMaven.tool = 'maven'       //Defining maven tool //
   // Maven build starts here //
   withSonarQubeEnv {
    def mvn_version = tool 'maven'
    withEnv( ["PATH+MAVEN=${mvn_version}/bin",'Sonar_Project_Name=' + "${temp.Sonar_project_name}"]  ) {
     buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean install -Dmaven.test.skip=true $SONAR_MAVEN_GOAL -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.projectKey=${Sonar_Project_Name} -Dsonar.projectName=${Sonar_Project_Name}'
    }
   }
}
