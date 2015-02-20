name := "hello"

organization := "web-scale"

version := "0.0.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.eclipse.jetty" % "jetty-webapp" % "9.3.0.M1"
)


