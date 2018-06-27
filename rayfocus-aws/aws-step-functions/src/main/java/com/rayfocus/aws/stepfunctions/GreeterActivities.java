package com.rayfocus.aws.stepfunctions;

import java.util.concurrent.TimeUnit;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.model.GetActivityTaskRequest;
import com.amazonaws.services.stepfunctions.model.GetActivityTaskResult;
import com.amazonaws.services.stepfunctions.model.SendTaskFailureRequest;
import com.amazonaws.services.stepfunctions.model.SendTaskSuccessRequest;
import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.databind.JsonNode;

public class GreeterActivities {
	
	private static final String ACTIVITY_ARN = "arn:aws:states:us-east-1:744223441980:activity:activity_get_greeting";
	
	public static void main(String[] args) throws InterruptedException {
		ClientConfiguration clientConfig = new ClientConfiguration().
										   withSocketTimeout((int)TimeUnit.SECONDS.toMillis(70));
		AWSStepFunctions stepFunctionClient = AWSStepFunctionsClientBuilder.standard().
											  withCredentials(new ProfileCredentialsProvider("default")).
											  withRegion(Regions.US_EAST_1).
											  withClientConfiguration(clientConfig).
				                              build();
		while(true) {
			GetActivityTaskResult activityTaskResult = stepFunctionClient.getActivityTask(new GetActivityTaskRequest().withActivityArn(ACTIVITY_ARN));
			if(activityTaskResult.getTaskToken() != null) {
				try {
					// parse the input
					JsonNode inputJson = Jackson.jsonNodeOf(activityTaskResult.getInput());
					String gretingActivityOutput = getOutputAsJsonString(inputJson);
					System.out.println(gretingActivityOutput);
					// send result
					stepFunctionClient.sendTaskSuccess(new SendTaskSuccessRequest().
													   withOutput(gretingActivityOutput).
													   withTaskToken(activityTaskResult.getTaskToken())
													);
				}
				catch(Exception e) {
					stepFunctionClient.sendTaskFailure(new SendTaskFailureRequest().
													   withTaskToken(activityTaskResult.getTaskToken())
													  );
				}
			}
			else {
				// take some rest; sleep for a minute
				Thread.sleep(1000);
			}
		}
		
	}
	
	private static String getOutputAsJsonString(JsonNode json) {
		String who = json.get("who").textValue();
		String greetingMessage = json.get("greetingMessage").textValue();
<<<<<<< HEAD
		return "{\"result\" : \"Hello "+who+"! "+ greetingMessage +"\"}";
=======
		return "{\"result\" : \""+who+"! "+ greetingMessage +"\"}";
>>>>>>> 41aec94603ed7e98ab096294bb35d28a98432126
	}
}