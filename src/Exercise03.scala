import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.SystemFlavorMap
import java.util.TimeZone
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Buffer
import scala.util.Random
/**
 * 第三章的课后练习题
 */
class Exercise03 {
  /**
   * (1) 将a设置为一个n个随机整数整数的数组,a介于 0~n之间
   * val a = Array[Int](5) 这个表示是一个数组，里面只含有5这个元素。
   * val a = new Array[Int](5) 这标示初始化一个5个元素的数组.
   */
  def randomAry(n: Int): Array[Int] = {
    val a = new Array[Int](n)
    for (i <- 0 until n) {
      a(i) = Random.nextInt(n)
    }
    a
  }

  /**
   * (1)' 当然，还可以用ArrayBuffer
   */
  def randomAryBuffer(n: Int): Array[Int] = {
    val a = new ArrayBuffer[Int]()
    for (i <- 0 until n) {
      a += Random.nextInt(n)
    }
    a.toArray
  }

  /**
   * (2) 置换数组的元素
   * scala> swapEle(Array[Int](1,2,3,4,5))
   * res24: Array[Int] = Array(2, 1, 4, 3, 5)
   */
  def swapEle(a: Array[Int]): Array[Int] = {
    val b = new ArrayBuffer[Int]()
    // 0 until (a.length,2) 表示：
    // 每2个元素一跳
    // 从数组尾端开始则是:
    //(0 until a.length).reverse
    // P32

    for (i <- 0 until (a.length, 2)) {
      if (i + 1 < a.length) {
        b += a(i + 1)
        b += a(i)
      } else {
        b += a(i)
      }
    }
    b.toArray
  }

  /**
   * (3) 第二题的for/yield版本
   */
  def swapEleForaYield(a: Array[Int]): Array[Int] = {
    //循环遍历a
    val b = for (i <- 0 until a.length) yield {
      if (i < a.length - 1) {
        // 交换元素
        if (i % 2 == 0) a(i + 1) else a(i - 1)
      } else {
        a(i)
      }
    }
    b.toArray
  }

  /**
   * (4)过滤原来数组中的所有正数和负数
   */
  def filterArray(a: Array[Int]): Array[Int] = {
    var b = a.filter { _ > 0 }
    b ++= a.filter { _ <= 0 }
    b.toArray
  }

  /**
   * (5) 计算数组的平均值
   * average(Array[Double](12.34d,231d,1231.334d,-234.3d))
   * res34: Double = 310.0935
   */
  def average(a: Array[Double]): Double = {
    var sum = a.sum
    sum / a.length
  }

  /**
   * (6) 对于数组的反序
   * var s=Array[Int](12,3,34,54,5)
   * scala> s.reverse
   * res36: Array[Int] = Array(5, 54, 34, 3, 12)
   * ============================================
   * var s=ArrayBuffer[Int](12,3,34,54,5)
   * s: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 3, 34, 54, 5)
   * scala> s.reverse
   * res37: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(5, 54, 34, 3, 12)
   *
   * 当然，还有排序过后的
   * s.sorted.reverse
   */

  /**
   * (7):去掉数组的重复值
   * scala> s+=5
   * res38: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 3, 34, 54, 5, 5)
   * scala> s.distinct
   * res39: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 3, 34, 54, 5)
   */
  def filterDuplicates(a: Array[Int]): Array[Int] = {
    a.distinct
  }

  /**
   * (8) 找到所有负数的下标，去掉最后一个的下标
   */
  def rewrite(a: Array[Int]): Array[Int] = {
    val indexed = for (i <- 0 until a.length if a(i) < 0) yield i
    a.dropRight(indexed.head)
  }

  /**
   * (9)创建一个由java.util.TimeZone.gerAvailableIDs返回的集合,过滤掉美洲的
   */
  def filterTimeZone: Array[String] = {
    val filterword = "America/"
    val a = TimeZone.getAvailableIDs()
    // stripPrefix 返回去掉有指定前缀的字符串
    /**
     * scala> "Amer".stripPrefix("A")
     * res48: java.lang.String = mer
     */
    a.filter(_.startsWith(filterword)).map(_.stripPrefix(filterword))
  }

  /**
   * (10)
   */
  def flavors: Array[String] = {
    import scala.collection.JavaConversions._
    import java.awt.datatransfer.DataFlavor
    import java.awt.datatransfer.SystemFlavorMap
    val command = ArrayBuffer("ls", "-al", "~/bin")
    val pb = new java.lang.ProcessBuilder(command)
    def flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    var f: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    f.toArray
  }
}