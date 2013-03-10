import scala.collection.immutable.Map
/**
 * ��4�µĿκ���ϰ
 */
class Exercise04 {
  /**
   * (1) ӳ��Ĵ���,��ԭ����ֵ����9�۴���
   * scala> changeMap(Map("a"->10,"b"->12))
   * res2: Map[String,Double] = Map(a -> 9.0, b -> 10.8)
   */
  def changeMap(valueMap: Map[String, Double]): Map[String, Double] = {
    for ((k, v) <- valueMap) yield (k, v * 0.9)
  }

  /**
   * (2) ����ļ��е��ʵĳ��ִ���
   * scala> calWords
   * (one,3)
   * (two,2)
   * (take,1)
   * (four,4)
   * (five,1)
   * (thhsdafsd,1)
   * (three,3)
   */
  def calWords() {
    var words = scala.collection.mutable.Map[String, Int]()
    val in = new java.util.Scanner(new java.io.File("exercise04.txt"))
    while (in.hasNext()) {
      val word = in.next()
      if (words.getOrElse(word, 0) > 0) {
        words.put(word, words.get(word).get + 1)
      } else {
        words.put(word, 1)
      }
    }

    for ((k, v) <- words)
      println(k, v)
  }

  /**
   * (3) �ڶ���Ŀ��ʹ�ò��ɱ�ļ���
   * scala> calWordsWithImmutable
   * (four,4)
   * (three,3)
   * (two,2)
   * (thhsdafsd,1)
   * (take,1)
   * (five,1)
   * (one,3)
   */
  def calWordsWithImmutable() {
    var words = scala.collection.immutable.Map[String, Int]()
    val in = new java.util.Scanner(new java.io.File("exercise04.txt"))
    while (in.hasNext()) {
      val word = in.next()
      if (words.getOrElse(word, 0) > 0) {
        words += (word -> (words(word).toInt + 1))
      } else {
        words += (word -> 1)
      }
    }

    for ((k, v) <- words)
      println(k, v)
  }

  /**
   * (4) ʹ�������MAP
   * scala> calWordsWithSortedMap
   * (five,1)
   * (four,4)
   * (one,3)
   * (take,1)
   * (thhsdafsd,1)
   * (three,3)
   * (two,2)
   */
  def calWordsWithSortedMap() {
    var words = scala.collection.immutable.SortedMap[String, Int]()
    val in = new java.util.Scanner(new java.io.File("/Users/zhangwenbo/test.txt"))
    while (in.hasNext()) {
      val word = in.next()
      if (words.getOrElse(word, 0) > 0) {
        words += (word -> (words(word).toInt + 1))
      } else {
        words += (word -> 1)
      }
    }

    for ((k, v) <- words)
      println(k, v)
  }

  /**
   * (7) ��ӡ��JAVA��ϵͳ����
   */
  def getJavaEnvProperties() {
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props: scala.collection.Map[String, String] = System.getProperties()
    for ((k, v) <- props)
      println(k + "\t" * 3 + "|" + v)
  }

  /**
   * (9) "Hello".zip("World") ���ֵ�����ǣ�(��������)
   * scala> "Hello".zip("World")  
   * res8: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((H,W), (e,o), (l,r), (l,l), (o,d))
   */
  
  
  
}