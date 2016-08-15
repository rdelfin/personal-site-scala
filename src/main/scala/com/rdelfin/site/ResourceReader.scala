package com.rdelfin.site

import java.io.FileNotFoundException
import java.util.concurrent.Executors

import com.twitter.io.Buf
import com.twitter.util.{Future, FuturePool}


/**
  * Created by rdelfin on 8/8/16.
  */
object ResourceReader {
  val executor = Executors.newFixedThreadPool(10)
  val futurePool = FuturePool(executor)
  def get(path: String) : Future[Buf] = {


    val future = futurePool {

      val stream = getClass.getResourceAsStream(path)
      if(stream == null || stream.available() == 0)
        throw new FileNotFoundException
      val data = Stream.continually(stream.read).takeWhile(_ != -1).map(_.toByte).toArray


      Buf.ByteArray.Shared(data)
    }

    future
  }
}
