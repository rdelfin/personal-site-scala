name := "site"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "twttr" at "https://maven.twttr.com/"
resolvers += "mvnrepo" at "https://mvnrepository.com/artifact/"
resolvers += "scala tools mvn2" at "http://scala-tools.org/repo-releases"
resolvers += "releases"  at "http://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.twitter" %% "twitter-server" % "1.21.0"

libraryDependencies += "org.scalatra.scalate" % "scalate-wikitext_2.11" % "1.7.1"
libraryDependencies += "org.scalatra.scalate" % "scalate-page_2.11" % "1.7.1"
libraryDependencies += "org.scalatra.scalate" % "scalate-test_2.11" % "1.7.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.0.M1" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

mainClass := Some("com.rdelfin.site.Server")
