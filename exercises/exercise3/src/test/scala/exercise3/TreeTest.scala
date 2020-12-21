package exercise3

import org.mockito.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class TreeTest extends AnyFlatSpec with Matchers with MockitoSugar {

  it should "returns 2 with the height method" in {
    // given
    val tree = Node[Int](Node[Int](Empty(), 1, Empty()), 3, Node[Int](Empty(), 2, Empty()))

    // when
    val height = Tree.height(tree)

    // then
    assert(height == 2)
  }

  it should "returns 6 with the sum method" in {
    // given
    val tree = Node[Int](Node[Int](Empty(), 1, Empty()), 3, Node[Int](Empty(), 2, Empty()))

    // when
    val height = Tree.sum(tree)

    // then
    assert(height == 6)
  }

  it should "returns 3 with the count method" in {
    // given
    val tree = Node[Int](Node[Int](Empty(), 1, Empty()), 3, Node[Int](Empty(), 2, Empty()))

    // when
    val height = Tree.count(tree)

    // then
    assert(height == 3)
  }

  it should "returns the same tree with the values mapped as string" in {
    // given
    val tree = Node[Int](Node[Int](Empty(), 1, Empty()), 3, Node[Int](Empty(), 2, Empty()))

    // when
    val stringTree = Tree.toStringNodes(tree)

    // then
    assert(stringTree == Node[String](Node[String](Empty(), "1", Empty()), "3", Node[String](Empty(), "2", Empty())))
  }

  it should "returns the square of each value of an int tree" in {
    // given
    val tree = Node[Int](Node[Int](Empty(), 1, Empty()), 3, Node[Int](Empty(), 2, Empty()))

    // when
    val treeWithSquare = Tree.squared(tree)

    // then
    assert(treeWithSquare == Node[Int](Node[Int](Empty(), 1, Empty()), 9, Node[Int](Empty(), 4, Empty())))
  }

}
