name := "$name$"

organization := "$organization$"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

// see: https://tpolecat.github.io/2017/04/25/scalac-flags.html
scalacOptions ++= Seq(
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-explaintypes",                     // Explain type errors in more detail.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:implicitConversions",     // Allow definition of implicit functions called views
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
  "-Xfuture",                          // Turn on future language features.
  "-Xlint:adapted-args",               // Warn if an argument list is modified to match the receiver.
  "-Xlint:by-name-right-associative",  // By-name parameter of right associative operator.
  "-Xlint:constant",                   // Evaluation of a constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
  "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
  "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
  "-Xlint:option-implicit",            // Option.apply used implicit view.
  "-Xlint:package-object-classes",     // Class or object defined in package object.
  "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
  "-Xlint:unsound-match",              // Pattern match may not be typesafe.
  "-Yno-adapted-args",                 // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
  "-Ypartial-unification",             // Enable partial unification in type constructor inference
  "-Ywarn-dead-code",                  // Warn when dead code is identified.
  "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
  "-Ywarn-inaccessible",               // Warn about inaccessible types in method signatures.
  "-Ywarn-infer-any",                  // Warn when a type argument is inferred to be `Any`.
  "-Ywarn-nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Ywarn-nullary-unit",               // Warn when nullary methods return Unit.
  "-Ywarn-numeric-widen",              // Warn when numerics are widened.
  "-Ywarn-unused:implicits",           // Warn if an implicit parameter is unused.
  "-Ywarn-unused:imports",             // Warn if an import selector is not referenced.
  "-Ywarn-unused:locals",              // Warn if a local definition is unused.
  "-Ywarn-unused:params",              // Warn if a value parameter is unused.
  "-Ywarn-unused:patvars",             // Warn if a variable bound in a pattern is unused.
  "-Ywarn-unused:privates",            // Warn if a private member is unused.
  "-Ywarn-value-discard",              // Warn when non-Unit expression results are unused.
  "-target:jvm-1.8",                   // Generate Java 8 byte code
)

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
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test

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
