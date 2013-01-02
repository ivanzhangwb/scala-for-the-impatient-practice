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
  
  /**
   * (9) : ��ȡ�ַ����ĵ�һ�������һ���ַ��ķ����У� ->_<-
   * scala> "ivanzhang".head
   * res20: Char = i
   * scala> "ivanzhang".last
   * res21: Char = g
   * scala> "ivanzhang".first
   * warning: there were 1 deprecation warnings; re-run with -deprecation for details
   * res22: Char = i
   * scala> "ivanzhang".indexOf(1)
   * res23: Int = -1
   * scala> "ivanzhang".substring(0,1)
   * res24: java.lang.String = i
   * scala> "ivanzhang".substring("ivanzhang".length()-1)
   * res25: java.lang.String = g
   */
  
  /**
   * (10): ˵˵take,drop,takeRight �� dropRight ��Щ�ַ������������ã�
   * 
   * take: ��ȡ�ʼ�ļ���Ԫ�� (����߿�ʼ)
   * 	scala> "ivanzhang".take(3)
		res26: String = iva
		
   * drop: ��ȡ����ָ����Ԫ���������Ԫ��:������߿�ʼ��
   * 	"ivanzhang".drop(3)
		res29: String = nzhang
		
   * takeRight: ���ұ߿�ʼ
   * 	scala> "ivanzhang".takeRight(3)
		res31: String = ang
		
   * dropRight: ���ұ߿�ʼ
   * 	scala> "ivanzhang".dropRight(3)
		res32: String = ivanzh
   * 
   * ������substring�Ĳ��:
   * 1. substring�����ȡ��Ԫ�ظ��������ַ������ȣ��ᱨ��
   * 	scala> "ivanzhang".take(13)
		res27: String = ivanzhang
		
		scala> "ivanzhang".substring(0,13)
		java.lang.StringIndexOutOfBoundsException: String index out of range: 13
			at java.lang.String.substring(String.java:1934)
			at .<init>(<console>:14)
			at .<clinit>(<console>)
			at .<init>(<console>:11)
			at .<clinit>(<console>)
			at $print(<console>)
			at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
			at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
			at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
			at java.lang.reflect.Method.invoke(Method.java:597)
			at scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:704)
			at scala.tools.nsc.interpreter.IMain$Request$$anonfun$14.apply(IMain.scala:920)
			at scala.tools.nsc.interpreter.Line$$anonfun$1.apply$mcV$sp(Line.scala:43)
			at scala.tools.nsc.io.package$$anon$2.run(package.scala:25)
			at java.lang.Thread.run(Thread.java:680)
	*
   */
}