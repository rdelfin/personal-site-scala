package com.rdelfin.personalsite

import org.scalatra._

class MyScalatraServlet extends PersonalSiteStack {
  get("/blog/post3") {
    findTemplate("blog/post3.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    }  get
  }

  get("/blog/post1") {
    findTemplate("blog/post1.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

  get("/blog") {
    findTemplate("blog.ssp") map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } get
  }

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
