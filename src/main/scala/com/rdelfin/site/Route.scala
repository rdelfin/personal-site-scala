package com.rdelfin.site

/**
  * Created by rdelfin on 8/14/16.
  */
class Route(val path: String, val viewPath: String, val title: String, val map: Map[String, String]) {
  def attrMap() = map + ("name" -> title) + ("bodyFile" -> viewPath)
  override def hashCode = path.hashCode
  override def equals(obj: Any): Boolean = {
    obj match {
      case route: Route => route.path == path
      case _ => false
    }
  }
}

object Route {
  def apply(path: String, viewPath: String, title: String, map: Map[String, String] = Map()): Route
    = new Route(path, viewPath, title, map)
}