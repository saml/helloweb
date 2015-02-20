package servlets


import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.{ServletContextEvent, ServletContextListener}

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext

class HelloServlet extends HttpServlet {
  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    response.getWriter().write("Hello, world")
  }
}

class ServletInitialization extends ServletContextListener {
  override def contextInitialized(event: ServletContextEvent) = {
    val context = event.getServletContext
    val registration = context.addServlet("Hello", classOf[HelloServlet])
    registration.addMapping("/*")
  }
  override def contextDestroyed(event: ServletContextEvent) = {}
}

class Main extends App {
  override def main(args: Array[String]): Unit = {
    val server = new Server(8080)
    val initialization = new ServletInitialization()
    val context = new WebAppContext()
    context.addEventListener(initialization)
    context.setServer(server)
    server.setHandler(context)
    server.start()
  }
}

// vim: set ts=4 sw=4 et:
