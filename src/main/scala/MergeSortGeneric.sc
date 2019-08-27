def msort(xs:List[Int]):List[Int] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs:List[Int],ys:List[Int]): List[Int] = {
      (xs,ys) match {
        case( Nil,y) => y
        case( x,Nil) => x
        case (x::xs1,y::ys1) => if (x<=y) x :: merge(xs1,ys) else y :: merge(xs,ys1)
      }
    }

    val (fst,snd) = xs splitAt n
    merge(msort(fst),msort(snd))
  }
}

val a = List(8,4,6,5,2,7,1,0)
msort(a)

def msortGen[T](xs:List[T],lt:(T,T) => Boolean):List[T] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs:List[T],ys:List[T]): List[T] = {
      (xs,ys) match {
        case( Nil,y) => y
        case( x,Nil) => x
        case (x::xs1,y::ys1) => if (lt(x,y)) x :: merge(xs1,ys) else y :: merge(xs,ys1)
      }
    }

    val (fst,snd) = xs splitAt n
    merge(msortGen(fst,lt),msortGen(snd,lt))
  }
}
case class student(name:String , age:Int)
val students = List(student("s2",2),student("s3",3),student("s1",1))
msortGen[student](students,(x,y)=> x.age < y.age)
