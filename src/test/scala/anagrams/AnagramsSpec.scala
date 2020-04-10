package anagrams

import org.scalatest.flatspec.AnyFlatSpec

class AnagramsSpec extends AnyFlatSpec {
  "llohe" should "be an anagram of 'hello'" in {
    assert(anagrams("hello", "llohe"))
  }

  "'Whoa! Hi!'" should "be an anagram of 'Hi! Whoa!'" in {
    assert(anagrams("Whoa! Hi!", "Hi! Whoa!"))
  }

  "'One One'" should "not be an anagram of 'Two Two Two'" in {
    assert(!anagrams("One One", "Two Two Two"))
  }

  "'One One" should "not be an anagram of 'One One c'" in {
    assert(!anagrams("One One", "One One c"))
  }

  "'A tree, a life, a bench" should "not be an anagram of 'A tree, a fence, a yard'" in {
    assert(!anagrams("A tree, a life, a bench", "A tree, a fence, a yard"))
  }
}
