import scala.annotation.tailrec

class Robot {
  def reset(): String = {
    this.name = RandomName.generateName()
    this.name
  }
  var name = RandomName.generateName()
}

object RandomName {
   private val usedName = scala.collection.mutable.ListBuffer.empty[String]

   @tailrec
   def generateName():String = {
    val random = new scala.util.Random
    val prefix = random.shuffle(('A' to 'X').toList).take(2).mkString
    val digits = random.shuffle((0 to 9).toList).take(3).mkString
    val newName = prefix + digits

    if (this.usedName contains newName)
      this.generateName()
    else {
      this.usedName += newName
      newName
    }
  }
}