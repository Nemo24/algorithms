val lst= List (1,2,3,4,5,6,7,8,9,10)
def sum(lst:List[Int]):Int = {
   lst reduceLeft(_ + _)
}

def sum2(lst:List[Int]):Int = {
  (lst foldLeft(0))(_ + _)
}
def product(lst:List[Int]):Int = {
  lst reduceLeft(_ * _)
}
def product2(lst:List[Int]):Int = {
  (lst foldLeft(1))(_ * _)
}
/*def sum2(lst:List[Int]):Int = {
   lst foldLeft(_ + _)
}*/

sum(lst)
product(lst)
sum2(lst)
product2(lst)
1+2
//sum(Nil)
sum2(Nil)

def concat[T](xs:List[T],ys:List[T]) =
{
  (xs foldRight( ys) )(_ :: _)
}

def concat2[T](xs:List[T],ys:List[T]) =
{
  (xs foldLeft( ys) )(_ :: _)
}

concat(List(1,2,3),List(5,6))
