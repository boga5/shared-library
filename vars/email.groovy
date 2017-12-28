
def call() {
 def notifySuccessful(){
emailext (
 attachLog: true, attachmentsPattern: '*.html, output.xml', body: '''<span style=\'line-height: 22px; font-family: Candara; padding: 10.5px; font-size: 15px; word-break: break-all; word-wrap: break-word; \'>
 <tr><td><a href="$BUILD_URL">Click Here</a> to view build result</h2><br><h3>Please find below, the build logs and other files.</td></tr></table>
 </span>''', subject: '$DEFAULT_SUBJECT', to: 'yerriswamy.konanki@ggktech.com'
 )
 }}
