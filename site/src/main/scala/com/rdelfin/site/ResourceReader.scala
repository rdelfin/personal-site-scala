package com.rdelfin.site

import java.io.FileNotFoundException
import java.util.concurrent.Executors

import com.twitter.util.{Future, FuturePool}


/**
  * Created by rdelfin on 8/8/16.
  */
object ResourceReader {
  val executor = Executors.newFixedThreadPool(10)
  val futurePool = FuturePool(executor)
  def get(path: String) : Future[String] = {


    val future = futurePool {

      val stream = getClass.getResourceAsStream(path)
      if(stream == null || stream.available() == 0)
        throw new FileNotFoundException
      val lines = scala.io.Source.fromInputStream(stream).getLines

      lines.reduceRight((s1, s2) => s1 + "\n" + s2)
    }

    future
  }
}
