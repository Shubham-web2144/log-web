# BK Global Freight Solution
	This is spring boot web application made using html, css, javascript, java and spring boot

# Run On Local Machine
	# Pre-requisite
		- OpenJDK 18+
		- apcahe maven 3.1.3+
		- Eclipse OR STS
		- apache tomcat - 10
		- MySql Database

## setup
	- Extract zip file
	- import into eclipse or sts
	- right click on parent folder and search 'maven' option
	- in 'maven' option click on 'update' and also check 'force to update'

## Database configuration
	- open aaplication.properties file 
	- {DATABASE_NAME} change this with your database name (Note: You have to create first your database.)
	- {DATABASE_USER} replace with your user name
	- {DATABASE_USER_PASSWORD } replace with your password

## run
	- right click on your parent folder and `run` as `Java Application`
	- By default it will run on port `8080`
	
## Open browser search 'http://localhost:8080/"

## Application Path
	# /, /home, /index - This path land you on home page.

## Other paths
	- /air
	- /consult
	- /contact
	- /corevalues
	- /custome
	- /management
	- /ocean
	- /pms
	- /ptm
	- /sustain
	- /vision-mission
	- /companyoverview
	
# Admin Page
	- /admin-login 
		By default 'username' is 'admin' and 'password' is 'admin', you can change it after login.
	- after successful login you will redirected to '/admin-home'
	
## Admin Home
	# Update Content Option
		- You can update your application pages content
		- All fields are required.
		
	# Contact
		- You can add your address and display on 'contact' page.
		- There is option 'activate/deactivate' which can activate or deactivate.
		- You can remove or delete.
	# Reset Password
		- You can reset your password.
		- Both fields are required.
		- Password should be 1 letter, 1 symbol and 1 number at-least.
		
# Note: Ensure you have to logout after you have done as login.

================================================================================

# Deploy on hosting or server

## Deploye On VPS (Hstinger VPS)

	- Sign Up for Hostinger:
				If you haven't already, sign up for a Hostinger account.
	
	- Choose a VPS Hosting Plan:
				Log in to your Hostinger account and select a VPS hosting plan that meets 				your requirements in terms of CPU, RAM, storage, and bandwidth.

	- Select an Operating System:
				During the VPS setup process, you'll typically be prompted to choose an 				operating system. Popular choices for Java applications include Ubuntu, 				CentOS, or Debian. Make your selection and proceed.

	- Configure Your VPS:
				Set up your VPS by specifying details such as the server location, server 				size, and any additional features you may want. Pay attention to the 				server's SSH key option, as this is a secure way to access your server.

	- Access Your VPS:
				Once your VPS is provisioned, you'll receive SSH access credentials or you 				can use SSH keys if you provided them during setup. Use an SSH client 				(e.g., OpenSSH, PuTTY) to connect to your VPS.
				Update the Operating System:

	- Update the installed packages and the operating system itself to ensure it's up to 	 	date. On Ubuntu, for example, you can use

	- Install Java:
				Install a compatible version of Java on your VPS. For example, to install 				OpenJDK 11 on Ubuntu, use the following commands:
	
	- Install Tomcat:
				Install tomcat version 10 on VPS .

	- Prepare Your Spring Boot Application:

	- Build File (.war) :
				Locate .war file in target/folder. OR you can build by right click on 				project folder in eclipse and click on 'Run As' and select 'Maven clean' 				and after that select 'Maven build' and enete in 'Goals' section/input 				'package'. You will get war file.

	- Use SCP or SFTP to transfer your Spring Boot application's JAR/WAR file to your VPS. 	You can use the scp command as shown in the previous response.

	- Configure Application Properties:
				Edit your Spring Boot application's configuration files (e.g., 				application.properties or application.yml) on the VPS to set the correct 				server port, database connection details, and any other environment 				specific configurations.
				

	- Start Your Spring Boot Application:
				Use the java -jar command to start your Spring Boot application on your 				VPS. You may want to use a tool like screen or tmux to keep the 				application running, especially if you plan to disconnect from the SSH 				session.

	- Domain Configuration (Optional):
				If you have a custom domain, update your DNS records to point to your 				VPS's IP address. You can manage DNS settings through Hostinger's control 
				

## Reference Youtube link to deploy 
	https://youtu.be/76t63IEnQXE?si=addK1GEe2r2FGhIr

