package com.rdelfin.personalsite

import org.scalatra._

class MyScalatraServlet extends PersonalSiteStack {
  get("/projects") {
    findTemplate("projects.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

  get("/projects/twitcher") {
    findTemplate("projects/twitcher.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

  get("/projects/car") {
    findTemplate("projects/car.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

  get("/contact") {
    findTemplate("contact.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

  get("/") {
    findTemplate("home.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

}
