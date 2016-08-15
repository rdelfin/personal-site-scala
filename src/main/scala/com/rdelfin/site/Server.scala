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
    val routes = new Routes(engine)

    override def apply(request: Request): Future[Response] = {
      log.info("%s => %s", request.path, request.method.toString())

      routes.get(request.path)
    }
  }

  def main() = {
    val server = Http.serve(":80", service)
    onExit {
      server.close()
    }
    Await.ready(server)
  }
}
