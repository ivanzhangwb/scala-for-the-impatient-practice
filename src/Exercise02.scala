/**
 * �ڶ��µĿκ�ϰ��
 */
class Exercise02 {
  /**
   * (1)��дsignum����
   */
  def signum(num: Int): Int = {
    if (num < 0) { -num } else if (num == 0) { 0 } else { num }
  }

  /**
   * (2) �յ�{}����ʽ ==>  "x:Unit = ()" ����ʽ��ֵȡ�������һ�����ʽ��
   * (3) �� val x:Unit = {val y = 1} ������£� x = y = 1�ǺϷ��� (void��������Unit)
   */

  /**
   * (4) Java�汾��ѭ��:
   * for(int i = 10;i>0;i--){System.out.println(i)}
   */
  def scalaLoop = {
    for (i <- 0 to 10)
      println(10 - i)
  }

  /**
   * (5) ��д��������n��ӡ��0
   */
  def countdown(n: Int) = {
    for (i <- 0 to n)
      println(n - i)
  }

  /**
   * (6) ��д�����������ַ�����unicode�˻�
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
   * (7) ��ʹ��forѭ��
   * ���ü��ϵ�����
   *  x.product �Ǽ����Դ��ķ���
   *  ���磺
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
   * ��˻��ĵݹ�汾
   */
  def recursiveVersion(s: String): Long = {
    var product: Long = 1
    //�����ĸ�Ĵ���
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