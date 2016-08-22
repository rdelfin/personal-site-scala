package com.rdelfin.site

import org.scalatest._


/**
  * Created by rdelfin on 8/15/16.
  */
class RouteTest extends UnitSpec {
  "A route attribute map" should "contain a name and bodyFile" in {
    val route = Route("path", "viewPath", "title")
    val map = Map("name" -> "title", "bodyFile" -> "viewPath")
    assert(route.attrMap() == map)
  }

  it should "contain a name, bodyFile, and any additional mappings passed in" in {
    val route = Route("path", "viewPath", "title", Map("sample" -> "attribute"))
    val map = Map("name" -> "title", "bodyFile" -> "viewPath", "sample" -> "attribute")
    assert(route.attrMap() == map)
  }

  "A route" should "equal itself" in {
    val route = Route("path1", "viewPath1", "title1")
    assert(route == route)
  }

  it should "equal an identical route" in {
    val route1 = Route("path1", "viewPath1", "title1")
    val route2 = Route("path1", "viewPath1", "title1")
    assert(route1 == route2)
  }

  it should "equal a route with only the same path" in {
    val route1 = Route("path1", "viewPath1", "title1")
    val route2 = Route("path1", "viewPath2", "title2")
    assert(route1 == route2)
  }

  it should "not equal a route with only a different path" in {
    val route1 = Route("path1", "viewPath1", "title1")
    val route2 = Route("path2", "viewPath1", "title1")
    assert(route1 != route2)
  }

  it should "not equal an entirely different path" in {
    val route1 = Route("path1", "viewPath1", "title1")
    val route2 = Route("path2", "viewPath2", "title2")
    assert(route1 != route2)
  }
}
