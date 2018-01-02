def call(def rtMaven, def server, def buildInfo) {
 Reason = "Artifacts Deployment Failed"
					  rtMaven.deployer.deployArtifacts buildInfo
				    server.publishBuildInfo buildInfo
}
