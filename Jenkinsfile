pipeline {
	agent any 
		stages {
			stage('clone the project'){
				parallel {
					stage('Compilation') {
						steps {
							echo "Performing Maven clean"
							sh "./mvnw clean install -DskipTests"
						}

					}

				}
			}
			stage('Test and deployment'){
				steps {
					sh "./mvnw clean test"
					}
				}
			stage('Staging') {
				steps {
					input('Do you want to proceed')
					}
				}
			stage('three') {
				when {
					not {
						branch "master"
						}
					}
					steps {
						echo "Hello"
						}
					}
			stage('four') {
					parallel {
						stage('Unit test') {
							steps {
								echo "Running the unit tests"
							}
						}
						stage('Integration test'){
							agent {
								docker {
									reuseNode true
									image 'ubuntu'
								}
							}
							steps {
								echo "Running the integration tests ... "
							}
						}
					}
				}
			}
			
		}