package org.handrinp.studexp.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.handrinp.studexp.model.Task;
import org.handrinp.studexp.model.User;
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

  public static JSONObject loadExampleUser() {
    User user = new User("Nick");
    Task task1 = new Task("Do homework", 500L, 50);
    task1.setId(50);
    user.addTask(task1);
    Task task2 = new Task("Do dishes", 1000L, 25);
    task2.setId(51);
    user.addTask(task2);
    return new JSONObject(user);
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
