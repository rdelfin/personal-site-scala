package com.rdelfin.site

import org.junit.Test
import org.junit.Assert._

/**
  * Created by rdelfin on 8/15/16.
  */
class RouteTest {
  val routeWithoutMap = Route("path", "viewPath", "title")
  val routeWithMap = Route("path", "viewPath", "title", Map("sample" -> "attribute"))

  val baseRoute = Route("path1", "viewPath1", "title1")
  val identicalRoute = Route("path1", "viewPath1", "title1")
  val samePathRoute = Route("path1", "viewPath2", "title2")
  val diffPathRoute = Route("path2", "viewPath1", "title1")
  val diffRoute = Route("path2", "viewPath2", "title2")

  val noMapAttributes = Map("name" -> "title", "bodyFile" -> "viewPath")
  val mapAttributes = noMapAttributes + ("sample" -> "attribute")

  @Test def routeWithoutMapTest(): Unit = assertTrue(routeWithoutMap.attrMap() == noMapAttributes)
  @Test def routeWithMapTest(): Unit = assertTrue(routeWithMap.attrMap() == noMapAttributes)

  @Test def routeSelfEqual(): Unit = assertTrue(baseRoute == baseRoute)
  @Test def routeIdenticalEqual(): Unit = assertTrue(baseRoute == identicalRoute)
  @Test def routeSamePathEqual(): Unit = assertTrue(baseRoute == samePathRoute)
  @Test def routeDifferentPathNotEqual(): Unit = assertTrue(baseRoute != diffPathRoute)
  @Test def routeDifferentRouteNotEqual(): Unit = assertTrue(baseRoute != diffRoute)
}
