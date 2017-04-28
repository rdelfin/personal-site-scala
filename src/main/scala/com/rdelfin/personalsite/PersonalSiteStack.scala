package com.rdelfin.personalsite

import org.scalatra._
import scalate.ScalateSupport

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
