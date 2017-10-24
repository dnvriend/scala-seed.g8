name := "$name$"

organization := "$organization$"

version := "1.0.0-SNAPSHOT"

// uncomment the following to enable typelevel scala
// see: https://github.com/typelevel/scala
//scalaOrganization := "org.typelevel"
//scalaVersion      := "2.12.3-bin-typelevel-4"
scalaVersion := "2.12.2"

// improves type constructor inference with support for partial unification,
// fixing the notorious SI-2712.
scalacOptions += "-Ypartial-unification"

//scalacOptions += "-Ydelambdafy:method"
scalacOptions += "-Ydelambdafy:inline"

// functional and typelevel programming
// https://github.com/scalaz/scalaz
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.16"
// https://github.com/mpilquist/simulacrum
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.11.0"
// https://github.com/milessabin/shapeless
libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
// https://github.com/typelevel/cats
//libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

// play-json (JSON library)
//libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6"

// circe (JSON library)
// libraryDependencies += "io.circe" %% "circe-core" % "0.7.0"
// libraryDependencies += "io.circe" %% "circe-generic" % "0.7.0"
// libraryDependencies += "io.circe" %% "circe-parser" % "0.7.0"

// avro4s
// libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-core" % "1.8.0"

// parse config
// libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.8.0"

// compile-time DI (only used at compile-time so in "provided" scope)
// https://github.com/adamw/macwire
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.0" % Provided

// testing
// https://github.com/typelevel/scalaz-scalatest
libraryDependencies += "org.typelevel" %% "scalaz-scalatest" % "1.1.2" % Test
// https://www.playframework.com/documentation/2.5.x/ScalaTestingWithScalaTest#Mockito  
//libraryDependencies += "org.mockito" % "mockito-core" % "2.11.0" % Test
// http://scalamock.org/
// https://github.com/paulbutcher/ScalaMock
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test
// http://www.scalatest.org/
// https://github.com/scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % Test

// testing configuration
fork in Test := true
parallelExecution := false

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
   .setPreference(AlignSingleLineCaseStatements, true)
   .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
   .setPreference(DoubleIndentConstructorArguments, true)
   .setPreference(DanglingCloseParenthesis, Preserve)

//
// enable scalafix linting
//
scalacOptions ++= scalafixScalacOptions.value
scalafixVerbose := false

val lintAndRewrite = taskKey[Unit]("Lints and rewrites Scala code using defined rules")

lintAndRewrite := {
  // see: https://scalacenter.github.io/scalafix/docs/users/rules
  List(
    "RemoveUnusedImports", // https://scalacenter.github.io/scalafix/docs/rules/RemoveUnusedImports
    "ExplicitResultTypes", // https://scalacenter.github.io/scalafix/docs/rules/ExplicitResultTypes
    "ProcedureSyntax", // https://scalacenter.github.io/scalafix/docs/rules/ProcedureSyntax
    "DottyVolatileLazyVal", // https://scalacenter.github.io/scalafix/docs/rules/DottyVolatileLazyVal
    "ExplicitUnit", // https://scalacenter.github.io/scalafix/docs/rules/ExplicitUnit
    "DottyVarArgPattern", // https://scalacenter.github.io/scalafix/docs/rules/DottyVarArgPattern
    "NoAutoTupling", // https://scalacenter.github.io/scalafix/docs/rules/NoAutoTupling
    "NoValInForComprehension", // https://scalacenter.github.io/scalafix/docs/rules/NoValInForComprehension
    "NoInfer", // https://scalacenter.github.io/scalafix/docs/rules/NoInfer
  ).map(rule => s" $rule")
    .map(rule => scalafix.toTask(rule))
    .reduce(_ dependsOn _).value
}

// enable updating file headers //
organizationName := "$author_name$"
startYear := Some(2017)
licenses := Seq(("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")))
headerMappings := headerMappings.value + (HeaderFileType.scala -> HeaderCommentStyle.CppStyleLineComment)

// 
// compiler plugins
//

// https://github.com/scalamacros/paradise
// http://docs.scala-lang.org/overviews/macros/paradise.html
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
// https://github.com/non/kind-projector
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.4")

enablePlugins(AutomateHeaderPlugin, SbtScalariform)
