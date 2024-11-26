package com.codeistry

import cats.Monad
import cats.implicits.*
import cats.effect.{IO, IOApp}
import cats.instances.*
import org.http4s.*
import org.http4s.dsl.*
import org.http4s.dsl.impl.*
import org.http4s.server.*
import org.http4s.ember.server.EmberServerBuilder
import pureconfig.ConfigSource

import com.codeistry.config.syntax.*
import com.codeistry.config.EmberConfig
import com.codeistry.http.routes.HealthRoutes

object Application extends IOApp.Simple {

  override def run: IO[Unit] = {

    ConfigSource.default
      .at("ember-config")
      .loadF[IO, EmberConfig]
      .flatMap(config => {
        EmberServerBuilder
          .default[IO]
          .withHost(config.host)
          .withPort(config.port)
          .withHttpApp(HealthRoutes[IO].routes.orNotFound)
          .build
          .use(_ => IO.println("server running") *> IO.never)
      })
  }
}
