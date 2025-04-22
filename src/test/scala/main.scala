object Main {
  def main(arr: Array[String]): Unit = {
    println("Hello, world!")
  }
  val a1: MyListInvariant[String] = MyListMacros.makeMyListInvariant
  val a2: MyListCovariant[String] = MyListMacros.makeMyListCovariant
  val a3: MyListContravariant[String] = MyListMacros.makeMyListContravariant

  val b1: MyListInvariant[String] = MyListMacros.makeMyListInvariantWrapper()
  val b2: MyListCovariant[String] = MyListMacros.makeMyListCovariantWrapper()
  val b3: MyListContravariant[String] = MyListMacros.makeMyListContravariantWrapper()
}
