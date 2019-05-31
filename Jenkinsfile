pipeline {
	agent any {
		stages {
			stage('one'){
				steps {
					echo 'This is my first build'
					}
				}
			stage('two') {
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
		}
	
