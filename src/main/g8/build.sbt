name := "$name$"

organization := "$organization$"

version := "1.0.0"

scalaVersion := "2.11.8"
scalaOrganization := "org.typelevel"
scalacOptions += "-Ypartial-unification" // enable fix for SI-2712
scalacOptions += "-Yliteral-types"       // enable SIP-23 implementation

// functional and typelevel programming
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.7"
libraryDependencies += "org.typelevel" %% "scalaz-outlaws" % "0.2"
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.10.0"
//libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
//libraryDependencies += "org.typelevel" %% "cats" % "0.8.1"
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.10.0"

// testing
libraryDependencies += "org.typelevel" %% "scalaz-scalatest" % "1.1.0" % Test  
//libraryDependencies += "org.mockito" % "mockito-core" % "2.2.21" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"

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

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

enablePlugins(AutomateHeaderPlugin, SbtScalariform)
