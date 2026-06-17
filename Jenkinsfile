pipeline{
	agent any
	
	tools{
		maven 'Maven'
		jdk 'JDK'
	}
	
	stages{
		stage('Checkout'){
		
		steps{
			git branch :'master',url:'https://github.com/shraddha1231/s1.git'
		}
	  }
	  
	  	stage('Build'){
		
		steps{
			sh 'mvn clean package'
		}
	  }
	  	stage('Test'){
		
		steps{
			sh 'mvn test'
		}
	  }
	 
	
	 }
	 post{
	 	success{
	 	
	 	
	 		echo 'build'
	 	}
	 	
	 	failure{
	 	     
	 	     echo 'fail'
	 	    }
	 	}
	 }
	 
