package com.rdelfin.site

import com.twitter.finagle.http.Response
import com.twitter.finagle.http.Status
import com.twitter.io.Buf
import com.twitter.logging.Logger
import com.twitter.util.Future
import org.fusesource.scalate.TemplateEngine

/**
  * Created by rdelfin on 8/14/16.
  */
class Routes(val engine: TemplateEngine) {
  private val log = Logger(getClass.getName.stripSuffix("$"))

  private val views = List(Route("/", "/views/home.ssp", "Home"),
                           Route("/contact", "/views/contact.ssp", "Contact Me"),
                           Route("/projects/car", "/views/projects/car.ssp", "Project: Robot Car"))
  private val templatePath: String = "/templates/main.ssp"

  def get(path: String) : Future[Response] = {

    getView(path) match {
      case view: Some[Route] =>
        val response = Response(Status.Ok)
        response.contentString = engine.layout(templatePath, view.get.attrMap())
        response.contentType = "text/html"
        Future.value(response)
      case _ =>
        getResource(path)
    }
  }

  private def getView(path: String): Option[Route] = views.find(_.path == path)

  private def getResource(path: String): Future[Response] = {
    ResourceReader.get(path).map((data: Buf) => {
      val response = Response(Status.Ok)
      response.content = data
      response.contentType = ContentType(path).getOrElse("")
      response
    }).rescue({
      case t: Throwable =>
        val response = Response(Status.NotFound)
        response.contentString = engine.layout("templates/main.ssp", Map("name" -> "404 Not Found", "bodyFile" -> "/error/404.ssp", "path" -> path))
        Future.value(response)
    })
  }
}
