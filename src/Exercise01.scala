package charpter01

/**
 * ��һ�µ���ϰ��
 */
class Exercise01 {
  /**
   * (1):REPL�н���3����TAB�������ֵķ�����:
   * %            :ȡ����
   * &            :��λ��
   * *            :����
   * +            :�ӷ�
   * -            :����
   * /            :����
   * >            :����
   * >=           :���ڵ���
   * >>           :�޷�������
   * >>>          :�з�������
   * ^            :��λ���
   * asInstanceOf :ת������
   * isInstanceOf :�ж�����
   * toByte       :ת����byte.
   * toChar       :ͬ��
   * toDouble     :ͬ��
   * toFloat      :ͬ��
   * toInt        :ͬ��
   * toLong       :ͬ��
   * toShort      :ͬ��
   * toString     :ͬ��
   * unary_-      :�������ֵ�����ʽ��3.unary_- = -3  -3.unary_- = 3
   * unary_+      :�������ֵ�ԭֵ��3.unary_+ = 3 -3.unary_+ = -3
   * unary_~      :��λ��
   * |
   */

  /**
   * (2): ����3��ƽ�������ٶԽ����ƽ����������3���бȽ�
   * ����ǣ�3.2398857793132016E-16
   */
  def calculate_3: BigDecimal = {
    import scala.math._
    var sqrtvalue: BigDecimal = sqrt(3)
    var range = 3 - sqrtvalue.pow(2)
    return range
  }

  /**
   * ��3) res�����ǲ��ɱ�� val
   *  (4) ���3��crazycrazycrazy,�ַ�������,��scaladoc�У���StringOps��*����
   *  (5) 10 max 2 �ĺ������ҳ�������֮��������,��BigDecimal�е�max����
   *  (6) var num:BigInt = 2; num.pow(1024)
   *  (7) ���� import scala.math.BigInt._; import scala.util.Random;
   */

  /**
   * (8) ����һ���漴BigInt,����ת�����ַ���
   * ���ý������:
   * randomFileContent(4)
   * res16: String = 8jt6
   */
  def randomFileContent(size: Int): String = {
    // 36���Ƶ���ֵ
    val alphanumerics: String = "0123456789abcdefghijklmnopqrstuvwxyz"
    var stringBuilder = new scala.collection.mutable.StringBuilder()
    for(i <- 0 until size){
      var randIndex = scala.util.Random.nextInt(alphanumerics.length())
      stringBuilder.append(alphanumerics.charAt(randIndex))
    }
    stringBuilder.toString
  }
  
  
}