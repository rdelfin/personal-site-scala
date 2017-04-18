package com.rdelfin.personalsite

import org.scalatra._
import scalate.ScalateSupport
import org.fusesource.scalate.{ TemplateEngine, Binding }
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import javax.servlet.http.HttpServletRequest
import collection.mutable

trait PersonalSiteStack extends ScalatraServlet with ScalateSupport {

  notFound {
    // remove content type in case it was set through an action
    contentType = null

    serveStaticResource() getOrElse {
      findTemplate("notfound.ssp") map { path =>
        contentType = "text/html"
        layoutTemplate(path)
      } get
    }
  }

}
