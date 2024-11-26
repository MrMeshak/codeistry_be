lazy val scala3Version = "3.5.2"

lazy val circeVersion               = "0.14.1"
lazy val catsEffectVersion          = "3.5.6"
lazy val http4sVersion              = "0.23.29"
lazy val pureConfigVersion          = "0.17.7"
lazy val log4catsVersion            = "2.7.0"
lazy val tsecVersion                = "0.5.0"
lazy val scalaTestVersion           = "3.2.19"
lazy val scalaTestCatsEffectVersion = "1.5.0"
lazy val testContainerVersion       = "1.17.3"
lazy val logbackVersion             = "1.4.0"
lazy val slf4jVersion               = "2.0.6"
lazy val javaMailVersion            = "1.6.2"

fork := true

lazy val server = project
  .in(file("."))
  .settings(
    name         := "codeistry",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta"         %% "munit"               % "1.0.0"          % Test,
      "org.typelevel"         %% "cats-effect"         % catsEffectVersion,
      "org.http4s"            %% "http4s-dsl"          % http4sVersion,
      "org.http4s"            %% "http4s-ember-server" % http4sVersion,
      "org.http4s"            %% "http4s-circe"        % http4sVersion,
      "io.circe"              %% "circe-generic"       % circeVersion,
      "io.circe"              %% "circe-fs2"           % circeVersion,
      "org.tpolecat"          %% "skunk-core"          % "0.6.4",
      "com.github.pureconfig" %% "pureconfig-core"     % pureConfigVersion,
      "org.typelevel"         %% "log4cats-slf4j"      % log4catsVersion,
      "org.slf4j"              % "slf4j-simple"        % slf4jVersion,
      "io.github.jmcardon"    %% "tsec-http4s"         % tsecVersion,
      "com.sun.mail"           % "javax.mail"          % javaMailVersion,
      "org.typelevel"         %% "log4cats-noop"       % log4catsVersion  % Test,
      "org.scalatest"         %% "scalatest"           % scalaTestVersion % Test,
      "org.typelevel"     %% "cats-effect-testing-scalatest" % scalaTestCatsEffectVersion % Test,
      "org.testcontainers" % "testcontainers"                % testContainerVersion       % Test,
      "org.testcontainers" % "postgresql"                    % testContainerVersion       % Test,
      "ch.qos.logback"     % "logback-classic"               % logbackVersion             % Test
    )
  )
