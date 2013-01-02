package charpter01

/**
 * 第一章的练习题
 */
class Exercise01 {
  /**
   * (1):REPL中建入3：按TAB键，出现的方法有:
   * %            :取余数
   * &            :按位与
   * *            :乘以
   * +            :加法
   * -            :减法
   * /            :除法
   * >            :大于
   * >=           :大于等于
   * >>           :无符号右移
   * >>>          :有符号右移
   * ^            :按位异或
   * asInstanceOf :转换类型
   * isInstanceOf :判定类型
   * toByte       :转换成byte.
   * toChar       :同上
   * toDouble     :同上
   * toFloat      :同上
   * toInt        :同上
   * toLong       :同上
   * toShort      :同上
   * toString     :同上
   * unary_-      :返回数字的求负形式：3.unary_- = -3  -3.unary_- = 3
   * unary_+      :返回数字的原值：3.unary_+ = 3 -3.unary_+ = -3
   * unary_~      :按位补
   * |
   */

  /**
   * (2): 先求3的平方根，再对结果求平方，接着与3进行比较
   * 结果是：3.2398857793132016E-16
   */
  def calculate_3: BigDecimal = {
    import scala.math._
    var sqrtvalue: BigDecimal = sqrt(3)
    var range = 3 - sqrtvalue.pow(2)
    return range
  }

  /**
   * （3) res变量是不可变的 val
   *  (4) 输出3个crazycrazycrazy,字符串相连,在scaladoc中，找StringOps的*方法
   *  (5) 10 max 2 的含义是找出两个数之间最大的数,找BigDecimal中的max方法
   *  (6) var num:BigInt = 2; num.pow(1024)
   *  (7) 引入 import scala.math.BigInt._; import scala.util.Random;
   */

  /**
   * (8) 生成一个随即BigInt,接着转换成字符串
   * 调用结果如下:
   * randomFileContent(4)
   * res16: String = 8jt6
   */
  def randomFileContent(size: Int): String = {
    // 36进制的数值
    val alphanumerics: String = "0123456789abcdefghijklmnopqrstuvwxyz"
    var stringBuilder = new scala.collection.mutable.StringBuilder()
    for(i <- 0 until size){
      var randIndex = scala.util.Random.nextInt(alphanumerics.length())
      stringBuilder.append(alphanumerics.charAt(randIndex))
    }
    stringBuilder.toString
  }
  
  /**
   * (9) : 获取字符串的第一个和最后一个字符的方法有： ->_<-
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
   * (10): 说说take,drop,takeRight 和 dropRight 这些字符串函数的作用：
   * 
   * take: 获取最开始的几个元素 (从左边开始)
   * 	scala> "ivanzhang".take(3)
		res26: String = iva
		
   * drop: 获取除了指定的元素外的其他元素:（从左边开始）
   * 	"ivanzhang".drop(3)
		res29: String = nzhang
		
   * takeRight: 从右边开始
   * 	scala> "ivanzhang".takeRight(3)
		res31: String = ang
		
   * dropRight: 从右边开始
   * 	scala> "ivanzhang".dropRight(3)
		res32: String = ivanzh
   * 
   * 它们与substring的差别:
   * 1. substring如果获取的元素个数超过字符串长度，会报错：
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