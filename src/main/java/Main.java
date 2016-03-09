
import java.util.Date;

import org.json.JSONObject;

import spark.Spark;


public class Main {
	public static void main(String[] args) {
		Spark.port(Integer.valueOf(System.getenv("PORT")));
		JSONObject obj = new JSONObject();
		Spark.get("echo", (request, response) -> {
			obj.put("parameters", request.queryString());
			obj.put("timestamp", new Date());
			return obj.toString();
		});
	}
}
