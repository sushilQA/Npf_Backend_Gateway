package org.testing.utilities;

import org.json.JSONObject;

import io.restassured.response.Response;

public class ApiValidation {

	String message = null;

	public String apiValidation(Response response) {

		if (response.statusCode() >= 200 & response.statusCode() < 300) {
			JSONObject jsonObject = new JSONObject(response.asPrettyString());
			int npfCode = Integer.parseInt(jsonObject.get("code").toString());
			if (npfCode >= 1000 & npfCode <= 9000) {
				System.out.println("\nSomthing went wrong !");
				System.out.println("\nAnd the response is given below :\n" + response.asPrettyString());
				this.message = "Somthing went wrong";

			} else {
				System.out.println(
						"\nApi is working fine and " + "the Response Code is = " + response.statusCode() + "\n");
				System.out.println("And the response is given below :\n\n" + response.asPrettyString());
				this.message = "Api is working fine";

			}
		} else if (response.statusCode() >= 300 & response.statusCode() < 400) {
			System.out.println("Response Code is =" + response.statusCode());
			JSONObject jsonObject = new JSONObject(response.asPrettyString());
			System.out.println(jsonObject.get("message").toString());
			System.out.println("\nAnd the response is given below :\n" + response.asPrettyString());
			this.message = jsonObject.get("message").toString();
		} else if (response.statusCode() >= 400 & response.statusCode() < 500) {
			System.out.println("Response Code is =" + response.statusCode());
			JSONObject jsonObject = new JSONObject(response.asPrettyString());
			System.out.println(jsonObject.get("message").toString());
			System.out.println("\nAnd the response is given below :\n" + response.asPrettyString());
			this.message = jsonObject.get("message").toString();

		} else if (response.statusCode() >= 500 & response.statusCode() < 512) {
			System.out.println("Response Code is =" + response.statusCode());
			JSONObject jsonObject = new JSONObject(response.asPrettyString());
			System.out.println(jsonObject.get("message").toString());
			System.out.println(jsonObject.get("message").toString());
			System.out.println("\nAnd the response is given below :\n" + response.asPrettyString());
		} else {
			System.out.println("Response Code is =" + response.statusCode());
			JSONObject jsonObject = new JSONObject(response.asPrettyString());
			System.out.println(jsonObject.get("message").toString());
			System.out.println("\nAnd the response is given below :\n" + response.asPrettyString());
			this.message = jsonObject.get("message").toString();

		}
		return message;
	}

}
