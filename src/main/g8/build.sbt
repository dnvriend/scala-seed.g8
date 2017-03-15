name := "$name$"

organization := "$organization$"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.1"

// functional and typelevel programming
// https://github.com/scalaz/scalaz
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.9"
// https://github.com/mpilquist/simulacrum
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.10.0"
// https://github.com/milessabin/shapeless
//libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
// https://github.com/typelevel/cats
//libraryDependencies += "org.typelevel" %% "cats" % "0.8.1"

// json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.0-M5"

// compile-time DI (only used at compile-time so in "provided" scope)
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"

// testing
// https://github.com/typelevel/scalaz-scalatest
libraryDependencies += "org.typelevel" %% "scalaz-scalatest" % "1.1.2" % Test
// https://www.playframework.com/documentation/2.5.x/ScalaTestingWithScalaTest#Mockito  
//libraryDependencies += "org.mockito" % "mockito-core" % "2.2.21" % Test
// https://github.com/scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"

// testing configuration
fork in Test := true
parallelExecution := false

licenses +=("Apache-2.0", url("http://opensource.org/licenses/apache2.0.php"))

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)

// enable updating file headers //
import de.heikoseeberger.sbtheader.license.Apache2_0

headers := Map(
  "scala" -> Apache2_0("2016", "$author_name$"),
  "conf" -> Apache2_0("2016", "$author_name$", "#")
)

// 
// compiler plugins
//

// https://github.com/scalamacros/paradise
// http://docs.scala-lang.org/overviews/macros/paradise.html
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
// https://github.com/non/kind-projector
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

enablePlugins(AutomateHeaderPlugin, SbtScalariform)