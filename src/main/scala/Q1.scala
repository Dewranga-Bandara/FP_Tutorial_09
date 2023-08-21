import scala.io.StdIn.readInt

object Q1 {
  def main(args: Array[String]): Unit = {
    print("Enter the numerator: ")
    val n = readInt()
    print("Enter the denominator: ")
    val d = readInt()
    val rational = new Rational(n, d)
    val negRational = rational.neg

    println(s"Original rational: $rational")
    println(s"Negated rational: $negRational")
  }
}