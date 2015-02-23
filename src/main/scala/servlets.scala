package servlets

import io.undertow.Undertow
import io.undertow.server.{HttpServerExchange, HttpHandler}

object Main extends App {
  override def main(args: Array[String]): Unit = {
    val handler = new HttpHandler {
      override def handleRequest(exchange: HttpServerExchange): Unit = {
        exchange.getResponseSender().send("Helllo world")
      }
    }
    val server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(handler)
      .build()

    server.start()
    val console = System.console()
    if (console != null) {
      console.readLine("Press enter to exit")
      server.stop()
    }
  }
}

// vim: set ts=4 sw=4 et:
