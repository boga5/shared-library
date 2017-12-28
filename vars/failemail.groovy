def call(def Reason) {
emailext (
	attachLog: true, attachmentsPattern: '*.html, output.xml', body: """<span style=\'line-height: 22px; font-family: Candara; padding: 10.5px; font-size: 15px; word-break: break-all; word-wrap: break-word; \'>
	<h1><FONT COLOR=red>\$PROJECT_NAME - Build # \$BUILD_NUMBER - \$BUILD_STATUS</FONT></h1>
	<h2>${Reason}</h2>
	<p><h2><a href="\$BUILD_URL">Click Here</a> to view build result</h2><br><h3>Please find below, the build logs and other files.</h3></p>
	</span>""", subject: '$DEFAULT_SUBJECT', to: 'yerriswamy.konanki@ggktech.com'
	)
}
