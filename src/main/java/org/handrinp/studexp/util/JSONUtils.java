package org.handrinp.studexp.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class JSONUtils {
  private static final String JSON_URL = "https://api.myjson.com/bins/openp";

  public static void save(JSONObject json) {
    HttpURLConnection conn = null;

    try {
      URL url = new URL(JSON_URL);
      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("PUT");
      conn.setRequestProperty("Content-Type", "application/json;");
      conn.setRequestProperty("Accept", "application/json;");
      conn.setDoOutput(true);
      OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
      writer.write(json.toString());
      writer.flush();
      writer.close();
      conn.getResponseCode();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
  }

  public static JSONObject load() {
    HttpURLConnection conn = null;
    StringBuilder json = new StringBuilder();

    try {
      URL url = new URL(JSON_URL);
      conn = (HttpURLConnection) url.openConnection();
      InputStreamReader in = new InputStreamReader(conn.getInputStream());
      int read;
      char[] buff = new char[1024];

      while ((read = in.read(buff)) != -1) {
        json.append(buff, 0, read);
      }
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }

    return new JSONObject(json.toString());
  }
}
