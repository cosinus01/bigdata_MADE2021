import javax.management.Query.and

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps
import scala.util.Random

// Types
val yInt: Short = 5 //555L
val xInt: Int = Int.MaxValue
xInt.+(yInt)
xInt + yInt
xInt.toDouble
val name: String = "Mark"
val letter: Char = 'c'
var is_cold: Boolean = false

// Some code
if (is_cold)
  {
    print(s"Hi, $name, warm ")
  }
else
  {
    print(s"Привет, $name, cold ")
  }

def convertCtoF(C: Double): Double = //Unit
{
  C*(9.0/5.0) + 32.0
}

def printCtoF(C: Double): Unit = //Unit
{
  print(C*(9.0/5.0) + 32.0)
}

convertCtoF(20)
val celsArray: Array[Double] = Array(5.0, 6.0, 3.0)

for (temp <- celsArray)
  {
    printCtoF(temp)
  }

//python way
val celsArrat: Array[Double] = for (temp <- celsArray) yield convertCtoF(temp)

//scala way
val scalaWayArray: Array[Double] = celsArrat.map(convertCtoF)

//scala better way
val scalaBettterWayArray: Array[Double] = celsArrat.map(t => convertCtoF(t))

// compare arrays
scalaWayArray.sameElements(scalaBettterWayArray)

case class Person(firstName: String, secondName: String, age: Int = 30)
val rechard = Person("Richard","Kruse")
val anatoly = Person("Anatoly","Kruse", 27)
val gena = Person("Gennadiy","Kruse", 27)

var band: ArrayBuffer[Person] = ArrayBuffer(rechard)
band.appendAll(Array[Person](anatoly, gena))

var dayOfWeek: Array[String] = Array("Mn", "Th", "Wn", "Cht", "Pt", "Sb", "Ws")

var tempAr: Array[Double] = Array.fill(7)(9.0)

var randomTemp: Array[Double] = tempAr.map(t => t + (Random.nextDouble * 5).round)


var sdayOfWeek: Map[String, Double] = dayOfWeek
  .zip(tempAr)
  .toMap

var check: Double = sdayOfWeek("Mn")
var check: Double = sdayOfWeek.getOrElse("Mn", 9.0)


def patternMatchingFunc(person: Person, day: String): String =
{

val degree: Double =  sdayOfWeek.getOrElse(day, 23)
if (person.firstName == "Richard" & person.secondName == "Kruse")
  {
    degree match
      {
      case 23 => "some"
      case 1 || 2|| 4 => "Sun"
      case _ => degree.toString
      }
  }
else
  {
    degree.toString
  }

}







