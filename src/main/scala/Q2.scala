import scala.io.StdIn.readInt

object Q2 {
  def main(args: Array[String]): Unit = {
    print("Enter the first numerator: ")
    val n1 = readInt()
    print("Enter the first denominator: ")
    val d1 = readInt()
    print("Enter the second numerator: ")
    val n2 = readInt()
    print("Enter the second denominator: ")
    val d2 = readInt()
    print("Enter the third numerator: ")
    val n3 = readInt()
    print("Enter the third denominator: ")
    val d3 = readInt()
    val rational1 = new Rational(n1, d1, n2, d2)
    val result = rational1.sub()
    val rational2 = new Rational(result._1, result._2, n3, d3)
    val finalResult = rational2.sub()
    println(s"x = $n1/$d1 , y = $n2/$d2 , z = $n3/$d3 \nx-y-z = ${finalResult._1}/${finalResult._2}")

  }
}