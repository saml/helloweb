import asynchttpserver
import asyncdispatch

proc app(req: Request) {.async.} =
  await(req.respond(Http200, "Hello world"))

when isMainModule:
  const port = 8080
  echo("Check http://localhost:",port)
  var server = newAsyncHttpServer()
  asyncCheck(server.serve(Port(port), app))
  runForever()
    
