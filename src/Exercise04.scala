import scala.collection.immutable.Map
/**
 * 第4章的课后练习
 */
class Exercise04 {
  /**
   * (1) 映射的处理,将原来的值都以9折处理
   * scala> changeMap(Map("a"->10,"b"->12))
   * res2: Map[String,Double] = Map(a -> 9.0, b -> 10.8)
   */
  def changeMap(valueMap: Map[String, Double]): Map[String, Double] = {
    for ((k, v) <- valueMap) yield (k, v * 0.9)
  }

  /**
   * (2) 清点文件中单词的出现次数
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
   * (3) 第二题目的使用不可变的集合
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
   * (4) 使用排序的MAP
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
   * (7) 打印出JAVA的系统属性
   */
  def getJavaEnvProperties() {
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props: scala.collection.Map[String, String] = System.getProperties()
    for ((k, v) <- props)
      println(k + "\t" * 3 + "|" + v)
  }

  /**
   * (9) "Hello".zip("World") 出现的情况是：(拉链操作)
   * scala> "Hello".zip("World")  
   * res8: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((H,W), (e,o), (l,r), (l,l), (o,d))
   */
  
  
  
}