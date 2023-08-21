class Rational(n1: Int, d1: Int, n2: Int, d2: Int) {
  def this(n1: Int, d1: Int) = this(n1, d1, 0, 0)
  if(d1==0){
    println("Denominator cannot be zero")
    System.exit(1)
  }
  private val gcdVal: Int = gcd(n1.abs, d1.abs)
  val numerator: Int = n1 / gcdVal
  val denominator: Int = d1 / gcdVal

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numerator, denominator, 0, 0)

  override def toString: String = s"$numerator / $denominator"

  def sub() : (Int,Int) = {
    val n3 = (n1 * d2) - (n2 * d1)
    val d3 = d1 * d2
    var i = 1
    if(n3 < 0 || d3 < 0){
      i = -1
    }
    val gcdVal: Int = gcd(n3.abs, d3.abs)
    val numerator: Int = n3 / gcdVal
    val denominator: Int = d3 / gcdVal
    (numerator*i, denominator)
  }

}
