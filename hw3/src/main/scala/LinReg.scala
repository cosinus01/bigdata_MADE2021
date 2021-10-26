import breeze.linalg.DenseMatrix._
import breeze.linalg._
import java.io._

object LinReg extends App
{


  //  get data
  val rawXTrain = csvread(new java.io.File("data/X_train.csv"))
  val rawXTest = csvread(new java.io.File("data/X_test.csv"))
  val yTrain = csvread(new java.io.File("data/y_train.csv"))
  val yTest = csvread(new java.io.File("data/y_test.csv"))

  // adding column of ones to make it suitable for matrix multiplication and calc intercept
  var xTrain: DenseMatrix[Double] = horzcat(rawXTrain, ones[Double](rawXTrain.rows,1) )
  var xTest: DenseMatrix[Double] = horzcat(rawXTest, ones[Double](rawXTest.rows,1) )

  // parameters & vars
  val theta = DenseVector.ones[Double](xTrain.cols)
  var numIterations: Int = 100000
  var alpha: Double = 0.01
  var trainLoss: Double = 0
  var  valLoss: Double = 0
  // to write results
  val pw = new PrintWriter(new File("results/results.txt" ))

  def prediction(x: DenseMatrix[Double]): DenseVector[Double] =
  {
    x * theta
  }

  def calcLoss(x: DenseMatrix[Double], trueY: DenseVector[Double]): Double =
  {
    (1.0/(2*x.rows))*breeze.linalg.sum((prediction(x)-trueY).map(t => t*t))
  }

  def backProp(x: DenseMatrix[Double], trueY: DenseVector[Double]): Unit =
    {
      theta -= (alpha/x.rows)  * (x.t *(prediction(x)-trueY) )
    }

  // gradient descent learning
  var i:Int = 0
  while (i < numIterations)
  {
    backProp(xTrain, yTrain.toDenseVector)
    trainLoss =  calcLoss(xTrain, yTrain.toDenseVector)
    valLoss = calcLoss(xTest, yTest.toDenseVector)

    //println(s"Train loss: $trainLoss")
    //println(s"Valid loss: $valLoss") // validation

    i+=1
  }

  pw.println(s"HW03: Линейная регрессия на Scala. Студент: Акимов Алексей")
  pw.println(s"train loss: $trainLoss,  validation loss: $valLoss")
  pw.println(s"Оценка параметров по градиентному спуску. Theta: $theta")

  // direct solution
  val directSolution = pinv(xTrain.t * xTrain) * xTrain.t * yTrain
  pw.println(s"Оценка параметров через обратную матрицу. Theta: $directSolution")

  pw.close
}