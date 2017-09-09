#!/usr/bin/env groovy

try {
		node('ubu-slave-1') {
        stage 'Clean workspace'
               //deleteDir()
               sh 'ls -lah'

        stage 'Checkout source'
              checkout scm

        stage 'Run Test Case'
              echo 'Running test cases'
              sh "sudo sbt version"
              echo  "$PATH"
              sh "mkdir -p $WORKSPACE/target"
	            sh "sudo sbt test"
      			  echo "Passed test cases"

        stage 'Build docker image'
              println "Building and packaging Scala application"
              sh 'sleep 5'
              def img = docker.build('scala-template', '.')

       stage 'Publish image'
               echo "Publishing docker images"
               sh 'eval $(aws ecr get-login --region ap-southeast-2)'
               docker.withRegistry('https://077077460384.dkr.ecr.ap-southeast-2.amazonaws.com', 'ecr:ap-southeast-2:AWS-SVC-ECS') {
                  docker.image('scala-template').push('latest')
                  docker.image('scala-template').push("build-develop-${env.BUILD_NUMBER}")
                }

        stage 'Pull and deploy app'
              echo "Pulling and deploying app from ECR"
              def imageTag = "077077460384.dkr.ecr.ap-southeast-2.amazonaws.com/scala-template:build-develop-${env.BUILD_NUMBER}"
              withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'b0097933-cea0-4729-8b7a-1e1f8702299f', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                // copy the kubeconfig file for your cluster to root of application.
                  sh 'aws s3 cp s3://isentia-kube-config/dev/kubeconfig .'
                  // deploying the tagged image
                  sh("sed -i.bak 's#077077460384.dkr.ecr.ap-southeast-2.amazonaws.com/scala-template:latest#${imageTag}#' ./deployment.yaml")
                  // create deployment, service and pods
                  sh("kubectl apply --namespace=templates --kubeconfig=kubeconfig -f deployment.yaml --record")
              }
          }
}
catch (exc) {
		echo "Caught: ${exc}"

		String recipient = 'chetan.pandey@isentia.com'

		mail subject: "${env.JOB_NAME} (${env.BUILD_NUMBER}) failed",
						body: "It appears that ${env.BUILD_URL} is failing, somebody should do something about that",
							to: recipient,
				 replyTo: recipient,
						from: 'isentia.jenkins@gmail.com'
}
