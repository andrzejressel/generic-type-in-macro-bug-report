import scala.quoted.*

object MyListMacros {
  inline def makeMyListInvariant[T]: MyListInvariant[T] = ${ MyListMacrosImpl.invariantImpl[T] }
  inline def makeMyListCovariant[T]: MyListCovariant[T] = ${ MyListMacrosImpl.covariantImpl[T] }
  inline def makeMyListContravariant[T]: MyListContravariant[T] = ${ MyListMacrosImpl.contravariantImpl[T] }

  def makeMyListInvariantWrapper[T]: InvariantWrapper[T] = new InvariantWrapper[T]
  def makeMyListCovariantWrapper[T]: CovariantWrapper[T] = new CovariantWrapper[T]
  def makeMyListContravariantWrapper[T]: ContravariantWrapper[T] = new ContravariantWrapper[T]
}

class InvariantWrapper[T] {
  inline def apply(): MyListInvariant[T] = ${ MyListMacrosImpl.invariantWrapperImpl[T] }
}

class CovariantWrapper[T] {
  inline def apply(): MyListCovariant[T] = ${ MyListMacrosImpl.covariantWrapperImpl[T] }
}

class ContravariantWrapper[T] {
  inline def apply(): MyListContravariant[T] = ${ MyListMacrosImpl.contravariantWrapperImpl[T] }
}

object MyListMacrosImpl {
  def invariantImpl[T: Type](using Quotes): Expr[MyListInvariant[T]] = {
    import quotes.reflect.*
    report.info(s"Invariant type T is: ${Type.show[T]}")
    '{ null.asInstanceOf[MyListInvariant[T]] }
  }

  def invariantWrapperImpl[T: Type](using Quotes): Expr[MyListInvariant[T]] = {
    import quotes.reflect.*
    report.info(s"Wrapper invariant type T is: ${Type.show[T]}")
    '{ null.asInstanceOf[MyListInvariant[T]] }
  }

  def covariantImpl[T: Type](using Quotes): Expr[MyListCovariant[T]] = {
    import quotes.reflect.*
    report.info(s"Covariant type T is: ${Type.show[T]}")
    '{ null.asInstanceOf[MyListCovariant[T]] }
  }

  def covariantWrapperImpl[T: Type](using Quotes): Expr[MyListCovariant[T]] = {
    import quotes.reflect.*
    report.info(s"Wrapper covariant type T is: ${Type.show[T]}")
    '{ null.asInstanceOf[MyListCovariant[T]] }
  }

  def contravariantImpl[T: Type](using Quotes): Expr[MyListContravariant[T]] = {
    import quotes.reflect.*
    report.info(s"Contravariant type T is: ${Type.show[T]}")
    '{ null.asInstanceOf[MyListContravariant[T]] }
  }

  def contravariantWrapperImpl[T: Type](using Quotes): Expr[MyListContravariant[T]] = {
    import quotes.reflect.*
    report.info(s"Wrapper contravariant type T is: ${Type.show[T]}")
    '{ null.asInstanceOf[MyListContravariant[T]] }
  }
}