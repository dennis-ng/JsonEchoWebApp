
import java.util.Date;

import org.json.JSONObject;

import spark.Spark;


public class Main {
	public static void main(String[] args) {
		Spark.port(Integer.valueOf(System.getenv("PORT")));
		JSONObject obj = new JSONObject();
		/**
			When an "echo" request is received, a JSON string containing the
			parameters and the current time will be generated and returned.
		**/
		Spark.get("echo", (request, response) -> {
			obj.put("parameters", request.queryString());
			obj.put("timestamp", new Date());
			return obj.toString();
		});
	}
}
