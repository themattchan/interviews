/*
 * Purely functional Queues and Dequeues
 */

class Queue[+A] private (ins: List[A], outs: List[A]) {

  def this() = this(Nil,Nil)
  def this(inits: List[A]) = this(inits,Nil)

  def enqueue[B >: A](e: B): Queue[B] = new Queue(e::ins, outs)

  def dequeue[B >: A]: (Option[B], Queue[B]) = (ins,outs) match {
    case (Nil,Nil)      => (None, this)
    case (Nil, o::outs) => (Some(o), new Queue(Nil,outs))
    case (ins, o::outs) => (Some(o), new Queue(ins,outs))
    case (_::_, Nil)    => new Queue(Nil, ins.reverse).dequeue
  }

  def peek: Option[A] = outs.headOption

  def size: Int = ins.size + outs.size
}

case class Dequeue[+A]() {
  def enqueue(e: A): Dequeue = ???

  def size = ???

  def

}
