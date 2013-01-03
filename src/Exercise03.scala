import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.SystemFlavorMap
import java.util.TimeZone
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Buffer
import scala.util.Random
/**
 * �����µĿκ���ϰ��
 */
class Exercise03 {
  /**
   * (1) ��a����Ϊһ��n�������������������,a���� 0~n֮��
   * val a = Array[Int](5) �����ʾ��һ�����飬����ֻ����5���Ԫ�ء�
   * val a = new Array[Int](5) ���ʾ��ʼ��һ��5��Ԫ�ص�����.
   */
  def randomAry(n: Int): Array[Int] = {
    val a = new Array[Int](n)
    for (i <- 0 until n) {
      a(i) = Random.nextInt(n)
    }
    a
  }

  /**
   * (1)' ��Ȼ����������ArrayBuffer
   */
  def randomAryBuffer(n: Int): Array[Int] = {
    val a = new ArrayBuffer[Int]()
    for (i <- 0 until n) {
      a += Random.nextInt(n)
    }
    a.toArray
  }

  /**
   * (2) �û������Ԫ��
   * scala> swapEle(Array[Int](1,2,3,4,5))
   * res24: Array[Int] = Array(2, 1, 4, 3, 5)
   */
  def swapEle(a: Array[Int]): Array[Int] = {
    val b = new ArrayBuffer[Int]()
    // 0 until (a.length,2) ��ʾ��
    // ÿ2��Ԫ��һ��
    // ������β�˿�ʼ����:
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
   * (3) �ڶ����for/yield�汾
   */
  def swapEleForaYield(a: Array[Int]): Array[Int] = {
    //ѭ������a
    val b = for (i <- 0 until a.length) yield {
      if (i < a.length - 1) {
        // ����Ԫ��
        if (i % 2 == 0) a(i + 1) else a(i - 1)
      } else {
        a(i)
      }
    }
    b.toArray
  }

  /**
   * (4)����ԭ�������е����������͸���
   */
  def filterArray(a: Array[Int]): Array[Int] = {
    var b = a.filter { _ > 0 }
    b ++= a.filter { _ <= 0 }
    b.toArray
  }

  /**
   * (5) ���������ƽ��ֵ
   * average(Array[Double](12.34d,231d,1231.334d,-234.3d))
   * res34: Double = 310.0935
   */
  def average(a: Array[Double]): Double = {
    var sum = a.sum
    sum / a.length
  }

  /**
   * (6) ��������ķ���
   * var s=Array[Int](12,3,34,54,5)
   * scala> s.reverse
   * res36: Array[Int] = Array(5, 54, 34, 3, 12)
   * ============================================
   * var s=ArrayBuffer[Int](12,3,34,54,5)
   * s: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 3, 34, 54, 5)
   * scala> s.reverse
   * res37: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(5, 54, 34, 3, 12)
   *
   * ��Ȼ��������������
   * s.sorted.reverse
   */

  /**
   * (7):ȥ��������ظ�ֵ
   * scala> s+=5
   * res38: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 3, 34, 54, 5, 5)
   * scala> s.distinct
   * res39: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(12, 3, 34, 54, 5)
   */
  def filterDuplicates(a: Array[Int]): Array[Int] = {
    a.distinct
  }

  /**
   * (8) �ҵ����и������±꣬ȥ�����һ�����±�
   */
  def rewrite(a: Array[Int]): Array[Int] = {
    val indexed = for (i <- 0 until a.length if a(i) < 0) yield i
    a.dropRight(indexed.head)
  }

  /**
   * (9)����һ����java.util.TimeZone.gerAvailableIDs���صļ���,���˵����޵�
   */
  def filterTimeZone: Array[String] = {
    val filterword = "America/"
    val a = TimeZone.getAvailableIDs()
    // stripPrefix ����ȥ����ָ��ǰ׺���ַ���
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