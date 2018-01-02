def call() {
 Reason = "Artifacts Deployment Failed"
 rtMaven.deployer.deployArtifacts buildInfo
 server.publishBuildInfo buildInfo
}
//def rtMaven, def server, def buildInfo
