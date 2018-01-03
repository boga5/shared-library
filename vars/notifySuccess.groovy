def call(def Reason, def WORKSPACE) {
properties([[$class: 'EnvInjectJobProperty', info: [loadFilesFromMaster: false, propertiesContent: "JobWorkSpace=${WORKSPACE}"], keepBuildVariables: true, keepJenkinsSystemVariables: true, on: true]])
 emailext (
 attachLog: true, attachmentsPattern: '*.html, output.xml', body: '''
 ${SCRIPT, template="email_template_success.groovy"}''', subject: '$DEFAULT_SUBJECT', to: 'yerriswamy.konanki@ggktech.com, sneha.kailasa@ggktech.com, sunil.boga@ggktech.com'
 )
}
