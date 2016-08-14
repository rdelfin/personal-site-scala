package com.rdelfin.site

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.server.TwitterServer
import com.twitter.util.{Await, Future}
import org.fusesource.scalate._

/**
  * Created by ricar on 25/07/2016.
  */
object Server extends TwitterServer {
  val service = new Service[Request, Response] {
    val engine = new TemplateEngine

    override def apply(request: Request): Future[Response] = {
      log.info("%s => %s", request.path, request.method.toString())

      if(request.path == "/") {
        val response = Response(request.version, Status.Ok)
        response.contentString = engine.layout("templates/main.ssp", Map("name" -> "Home", "bodyFile" -> "/views/home.ssp"))
        log.debug("Sending content %s", response.contentString)
        Future.value(response)

      }else {
        ResourceReader.get(request.path)
          .map((text) => {
            val response = Response(request.version, Status.Ok)
            response.content = text
            log.debug("Sending content %s", response.contentString)
            response
          }).rescue({
          case t: Throwable =>
            val response = Response(request.version, Status.NotFound)
            Future.value(response)
        })
      }
    }
  }

  def main() = {
    val server = Http.serve(":8080", service)
    onExit {
      server.close()
    }
    Await.ready(server)
  }
}
