def call(def rtMaven, def buildInfo, def server) {
 Reason = "Artifacts Deployment Failed"
 rtMaven.deployer.deployArtifacts buildInfo
 server.publishBuildInfo buildInfo
}
//
