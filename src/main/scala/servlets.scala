package servlets

import javax.servlet.annotation.WebServlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name="Hello", urlPatterns=Array("/*"))
class HelloServlet extends HttpServlet {
  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    response.getWriter().write("Hello, world")
  }
}

// vim: set ts=4 sw=4 et:
