grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"

// Secure the oauth endpoints
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/oauth/authorize.dispatch':['IS_AUTHENTICATED_REMEMBERED'],
	'/oauth/token.dispatch':['IS_AUTHENTICATED_REMEMBERED'],
]
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'test.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'test.UserRole'
grails.plugin.springsecurity.authority.className = 'test.Role'

grails.plugin.springsecurity.providerNames = [
		'daoAuthenticationProvider',
		'anonymousAuthenticationProvider',
		'rememberMeAuthenticationProvider',
		'clientCredentialsAuthenticationProvider'
]

grails.plugin.springsecurity.oauthProvider.clients = [
	[
		clientId:"clientId",
		clientSecret:"clientSecret",
		authorizedGrantTypes:["authorization_code", "refresh_token", "client_credentials", "password", "implicit"]
	],
]

grails.serverURL = "http://localhost:8080/test-oauth-server"

log4j = {
	debug	'grails.app.bootstrap.BootStrap',
			'grails.app',
			'grails.plugin.springsecurity.oauthprovider'
	info	'org.hibernate.SQL',
			'org.springframework.security'
	error	'org.codehaus.groovy.grails.web.servlet',	//	controllers
			'org.codehaus.groovy.grails.web.pages', 	//	GSP
			'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
			'org.codehaus.groovy.grails.web.sitemesh',	//	layouts
			'org.springframework',
			'org.hibernate',
			'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
			'org.codehaus.groovy.grails.web.mapping', // URL mapping
			'org.codehaus.groovy.grails.plugins', // plugins
			'org.codehaus.groovy.grails.commons' // core / classloading
	warn	'org.mortbay.log'
}