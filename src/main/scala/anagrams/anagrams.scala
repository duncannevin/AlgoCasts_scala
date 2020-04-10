package anagrams

object anagrams {
  def apply(str1: String, str2: String): Boolean = str1.toSeq.sorted.unwrap == str2.toSeq.sorted.unwrap
}
