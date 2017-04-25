package \$package\$

import scalaz._
import Scalaz._

object Person {
  def validateNonEmpty(fieldName: String, value: String): ValidationNel[String, String] =
    Validation.liftNel(value)(_.trim.isEmpty, s"Field '\$fieldName' must not be empty")

  def validateName(name: String): ValidationNel[String, String] =
    validateNonEmpty("name", name)

  def validateGt(fieldName: String, maxValue: Int, value: Int): ValidationNel[String, Int] =
    Validation.liftNel(value)(_ < maxValue, s"Field '\$fieldName' with value '\$value' must be greater than '\$maxValue'")

  def validateLt(fieldName: String, maxValue: Int, value: Int): ValidationNel[String, Int] =
    Validation.liftNel(value)(_ > maxValue, s"Field '\$fieldName' with value '\$value' must be less than '\$maxValue'")

  def validateAge(age: Int): ValidationNel[String, Int] =
    validateGt("age", -1, age) *> validateLt("age", 140, age)

  def validate(name: String, age: Int): ValidationNel[String, Person] =
    (validateName(name) |@| validateAge(age))(Person.apply)
}

final case class Person(name: String, age: Int)

object HelloWorld extends App {
	val result: Disjunction[NonEmptyList[String], Person] = for {
		einstein <- Person.validate("Albert Einstein", 42).disjunction
		fibonacci <- Person.validate("Fibonacci", 135).disjunction
		pythagoras <- Person.validate("Pythagoras", 1764).disjunction	
	} yield pythagoras

	result match {
		case DLeft(messages) => 
		  println(messages)
		case DRight(person) => 
		  println(person)
	}	
}
