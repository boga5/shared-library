def call(def rtMaven) {
 Reason = "Artifacts Deployment Failed"
 rtMaven.deployer.deployArtifacts buildInfo
 server.publishBuildInfo buildInfo
}
//, def server, def buildInfo
