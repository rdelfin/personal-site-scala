package com.rdelfin.site

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response, Status}
import com.twitter.server.TwitterServer
import com.twitter.util.{Await, Future}
import com.twitter.logging
import org.fusesource.scalate._

/**
  * Created by ricar on 25/07/2016.
  */
object Server extends TwitterServer {
  val service = new Service[Request, Response] {
    val engine = new TemplateEngine

    override def apply(request: Request): Future[Response] = {
      val response = Response(request.version, Status.Ok)
      response.contentString = engine.layout("templates/main.ssp")
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
