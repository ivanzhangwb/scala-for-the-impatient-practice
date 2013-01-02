/**
 * 第二章的课后习题
 */
class Exercise02 {
  /**
   * (1)编写signum函数
   */
  def signum(num: Int): Int = {
    if (num < 0) { -num } else if (num == 0) { 0 } else { num }
  }

  /**
   * (2) 空的{}块表达式 ==>  "x:Unit = ()" 块表达式的值取决于最后一个表达式。
   * (3) 在 val x:Unit = {val y = 1} 的情况下， x = y = 1是合法的 (void的类型是Unit)
   */

  /**
   * (4) Java版本的循环:
   * for(int i = 10;i>0;i--){System.out.println(i)}
   */
  def scalaLoop = {
    for (i <- 0 to 10)
      println(10 - i)
  }

  /**
   * (5) 编写函数，从n打印到0
   */
  def countdown(n: Int) = {
    for (i <- 0 to n)
      println(n - i)
  }

  /**
   * (6) 编写函数，计算字符串的unicode乘积
   * scala> unicodeProduct("Hello")
   * 	 res44: Long = 9415087488
   */
  def unicodeProduct(s: String) = {
    var product: Long = 1
    for (i <- 0 until s.length) {
      product *= s(i).toLong
    }
    product
  }

  /**
   * (7) 不使用for循环
   * 利用集合的特性
   *  x.product 是集合自带的方法
   *  比如：
   * scala> var x = "Hello".map(c => c.toLong)
   * x: scala.collection.immutable.IndexedSeq[Long] = Vector(72, 101, 108, 108, 111)
   *
   * scala> x.product
   * res48: Long = 9415087488
   */
  def unicodeProductWithoutLoop(s: String) = {
    var x = s.map(_.toLong)
    x.product
  }

  /**
   * 求乘积的递归版本
   */
  def recursiveVersion(s: String): Long = {
    var product: Long = 1
    //逐个字母的处理
    def helper(str: String, result: Long): Long = {
      val product = result * (str.head.toLong)
      if (str.length == 1) {
        product
      } else {
        helper(str.tail, product)
      }
    }
    helper(s, product)
  }
}