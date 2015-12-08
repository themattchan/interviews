trait Tree[A,B] {
  case class Leaf() extends Tree
  case class Node(k: A, v: B, l: Tree, r: Tree) extends Tree

  def insert(k: A, v: B): Tree
  def find(k: A): Option[B]
  def delete(k: A): Tree
}


class AVL[A,B] private (root: Tree)
    extends Tree[A,B] {
  def this() = this(Leaf())

   def find(k: A): Option[B] = root match {
    case Leaf() => None
    case Node(k1,v,l,r) =>
      if (k == k1) Some(v)
      else if (k < k1) l.find(k)
      else r.find(k)
   }


  def insert(k: A, v: B) = root match {


  }


}
