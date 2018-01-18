package org.handrinp.studexp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.handrinp.studexp.util.JSONUtils;
import org.json.JSONObject;

public class JSONServlet extends HttpServlet {
  private static final long serialVersionUID = 3831240364841634142L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String json = request.getParameter("json");

    if (json != null) {
      JSONUtils.save(new JSONObject(json));
    }

    response.sendRedirect("./");
  }
}
