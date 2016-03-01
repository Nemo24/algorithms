package test

/**
 * Created by mm on 15/10/15.
 */
object ReverseList {
  def reverseList[T](lst:List[T]) :List[T] = {
    lst match {
      case Nil => lst
      case x:: xs => reverseList(xs) ++ List(x)
    }
  }

}

object ReverseListTest extends  App {
  val a = List(1,2,3,4,5)
  val b = ReverseList.reverseList(a)
  println(b)
}