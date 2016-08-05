name := "site"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "twttr" at "https://maven.twttr.com/"
resolvers += "mvnrepo" at "https://mvnrepository.com/artifact/"

libraryDependencies += "com.twitter" %% "twitter-server" % "1.21.0"

libraryDependencies += "org.scalatra.scalate" % "scalate-wikitext_2.11" % "1.7.1"
libraryDependencies += "org.scalatra.scalate" % "scalate-page_2.11" % "1.7.1"
libraryDependencies += "org.scalatra.scalate" % "scalate-test_2.11" % "1.7.1"

mainClass in (Compile,run) := Some("com.rdelfin.site.Server")