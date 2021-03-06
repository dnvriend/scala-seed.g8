name := "$name$"

organization := "$organization$"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.6"

// functional and typelevel programming
// https://github.com/scalaz/scalaz
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.24"
// https://github.com/mpilquist/simulacrum
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.12.0"
// https://github.com/milessabin/shapeless
libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.3"
// https://github.com/typelevel/cats
//libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

// play-json (JSON library)
//libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.7"

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
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.1" % Provided

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
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

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

// enable updating file headers //
import de.heikoseeberger.sbtheader._
organizationName := "$author_name$"
startYear := Some(2017)
licenses := Seq(("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")))
headerMappings := headerMappings.value + (FileType.scala -> CommentStyle.cppStyleLineComment)

// 
// compiler plugins
//

// https://github.com/scalamacros/paradise
// http://docs.scala-lang.org/overviews/macros/paradise.html
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
// https://github.com/non/kind-projector
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7")

enablePlugins(AutomateHeaderPlugin, SbtScalariform)
