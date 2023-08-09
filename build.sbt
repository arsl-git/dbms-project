lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """player-11-backend""",
    version := "1.0-0",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      guice,
      javaJdbc,
      javaJpa,
      // Test Database
      "com.mysql" % "mysql-connector-j" % "8.0.31"
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror"
    ),
    // Make verbose tests
    (Test / testOptions) := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
  )
