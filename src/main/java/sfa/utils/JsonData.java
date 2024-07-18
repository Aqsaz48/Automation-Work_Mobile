package sfa.utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonData {
	private InputStream jsonfile;
	private JSONObject jsonObject;
	public JSONObject getJsonData(String jsonFile) throws IOException {
		try {
			jsonfile = getClass().getClassLoader().getResourceAsStream(jsonFile);
			jsonObject = new JSONObject(new JSONTokener(jsonfile));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jsonfile != null)
				jsonfile.close();
		}
		return jsonObject;
	}

}
