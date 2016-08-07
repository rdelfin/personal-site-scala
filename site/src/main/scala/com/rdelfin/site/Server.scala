package com.rdelfin.site

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.server.TwitterServer
import com.twitter.util.{Await, Future}
import org.fusesource.scalate._

import scala.io.Source

/**
  * Created by ricar on 25/07/2016.
  */
object Server extends TwitterServer {
  val service = new Service[Request, Response] {
    val engine = new TemplateEngine

    override def apply(request: Request): Future[Response] = {
      log.info("%s => %s", request.path, request.method.toString())
      val responseString = request.path match {
        case "/"       => engine.layout("templates/main.ssp", Map("name" -> "Home", "title" -> "hello"))
        case s: String => Source.fromFile(s.substring(1)).mkString
      }


      val response = Response(request.version, Status.Ok)
      response.contentString = responseString
      log.debug("Sending content %s", response.contentString)
      Future.value(response)
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
