package exercise3

import scala.math.Numeric.IntIsIntegral.mkNumericOps

sealed trait Tree[A]

case class Empty[A]() extends Tree[A]

case class Node[A](l: Tree[A], a: A, r: Tree[A]) extends Tree[A]

object Tree {

  def fold[A, B](myTree: Tree[B], emptyValue: A, nodeMapper: (A, B, A) => A): A = myTree match {
    case Empty() => emptyValue
    case Node(l, a, r) => nodeMapper(
      fold(l, emptyValue, nodeMapper),
      a,
      fold(r, emptyValue, nodeMapper)
    )
  }

  def map[A, B](myTree: Tree[A], mapper : A => B) : Tree[B] = fold(myTree, Empty[B](), (l : Tree[B], v : A, r : Tree[B]) => Node[B](l, mapper(v), r))

  /**
    * Implement a function height that returns the longest height in a
    * tree
    */
  def height[A](tree: Tree[A]): Int = fold(tree, 0, (l: Int, _: A, r: Int) => 1 + l.max(r))

  /**
    * Create a function that sums all the leaves in a Tree[Int]
    */
  def sum(tree: Tree[Int]): Int = fold(tree, 0, (l: Int, value: Int, r: Int) => value + l + r)

  /**
    * Create a function that counts all the leaves in a tree
    */
  def count[A](tree: Tree[A]): Int = fold(tree, 0, (l: Int, _: A, r: Int) => 1 + l + r)

  /**
    * Create a function that transforms each element in a tree into it's
    * string representation
    */
  def toStringNodes(tree: Tree[Int]): Tree[String] = map(tree, (a : Int) => a.toString)

  /**y e
    * Create a function that squares all elements in an Int tree
    */
  def squared(tree: Tree[Int]): Tree[Int] = map(tree, (a : Int) => a * a)
}
