package com.rdelfin.site

/**
  * Created by rdelfin on 8/14/16.
  */
object ContentType {
  private val contentTypeMap = Map(
    "js"   -> "application/javascript",
    "json" -> "application/json",
    "html" -> "text/html",
    "css"  -> "text/css",
    "pdf"  -> "application/pdf",
    "png"  -> "image/png",
    "jpg"  -> "image/jpeg",
    "jpeg" -> "image/jpeg")

  def apply(path: String): Option[String] = {
    val splitText = path.split("\\.")
    contentTypeMap.get(splitText(splitText.length - 1))
  }

}
