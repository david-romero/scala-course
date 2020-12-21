ThisBuild / scalaVersion := "2.12.11"

lazy val V = new {
  val cats                   = "2.0.0"
  val catsEffect             = "2.0.0"
  val monocle                = "2.0.0"
  val mockitoScala           = "1.14.4"
  val scalatestplus          = "1.0.0-M2"
  val scalatest              = "3.2.2"
  val disciplineScalatest    = "1.0.0-M1"
}


lazy val exercise1 = project
  .in(file("exercises/exercise1"))

lazy val exercise2 = project
  .in(file("exercises/exercise2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel"                  %% "cats-core"                       % V.cats,
      "org.typelevel"                  %% "cats-effect"                     % V.catsEffect,
      "org.typelevel"                  %% "discipline-scalatest"            % V.disciplineScalatest % Test,
      "org.scalatest"                  %% "scalatest"                       % V.scalatest % Test,
      "org.scalatestplus"              %% "scalatestplus-scalacheck"        % V.scalatestplus % Test,
      "org.mockito"                    %% "mockito-scala"                   % V.mockitoScala % Test,
      "com.github.julien-truffaut"     %% "monocle-law"                     % V.monocle % Test,
    )
  )

lazy val exercise3 = project
  .in(file("exercises/exercise3"))

lazy val exercise4 = project
  .in(file("exercises/exercise4"))

lazy val exercise5 = project
  .in(file("exercises/exercise5"))
  .dependsOn(exercise3)
  .settings(
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.0"
  )

lazy val exampleScalacheck = project
  .in(file("examples/scalacheck"))
  .dependsOn(exercise3)
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel"                  %% "cats-core"                       % V.cats,
      "org.typelevel"                  %% "cats-effect"                     % V.catsEffect,
      "org.typelevel"                  %% "discipline-scalatest"            % V.disciplineScalatest % Test,
      "org.scalatest"                  %% "scalatest"                       % V.scalatest % Test,
      "org.scalatestplus"              %% "scalatestplus-scalacheck"        % V.scalatestplus % Test,
      "org.mockito"                    %% "mockito-scala"                   % V.mockitoScala % Test,
      "com.github.julien-truffaut"     %% "monocle-law"                     % V.monocle % Test,
    )
  )


lazy val docs = project
  .in(file("docs"))
  .settings(
    Compile / scalacOptions ++= Seq(
      "-encoding", "UTF-8", // 2 args
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions"
    ),
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.5"),
    mdocIn := baseDirectory.value / "mdoc",
    mdocOut := baseDirectory.value / "mdoc-out",
    libraryDependencies ++= Seq(
      "org.scalacheck" %% "scalacheck" % "1.14.0",
      "org.typelevel" %% "cats-core" % "2.1.0"
    )
  )
  .enablePlugins(MdocPlugin)
libraryDependencies in exercise2 ++= Seq(
  "org.scalatest" %% "scalatest" % "latest.integration" % "test"
)
