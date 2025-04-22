import scala.language.experimental.macros

object MyListMacros {
  def makeMyListInvariant[T]: MyListInvariant[T] = macro MyListMacrosImpl.invariantImpl[T]
  def makeMyListCovariant[T]: MyListCovariant[T] = macro MyListMacrosImpl.covariantImpl[T]
  def makeMyListContravariant[T]: MyListContravariant[T] = macro MyListMacrosImpl.contravariantImpl[T]

  def makeMyListInvariantWrapper[T]: InvariantWrapper[T] = new InvariantWrapper[T]
  def makeMyListCovariantWrapper[T]: CovariantWrapper[T] = new CovariantWrapper[T]
  def makeMyListContravariantWrapper[T]: ContravariantWrapper[T] = new ContravariantWrapper[T]
}

class InvariantWrapper[T] {
  def apply(): MyListInvariant[T] = macro MyListMacrosImpl.invariantWrapperImpl[T]
}

class CovariantWrapper[T] {
  def apply(): MyListCovariant[T] = macro MyListMacrosImpl.covariantWrapperImpl[T]
}

class ContravariantWrapper[T] {
  def apply(): MyListContravariant[T] = macro MyListMacrosImpl.contravariantWrapperImpl[T]
}

object MyListMacrosImpl {
  import scala.reflect.macros.blackbox

  def invariantImpl[T: c.WeakTypeTag](c: blackbox.Context): c.Expr[MyListInvariant[T]] = {
    import c.universe._
    val tpe = weakTypeOf[T]
    c.info(c.enclosingPosition, s"Invariant type T is: $tpe", true)
    c.Expr[MyListInvariant[T]](q"null")
  }

  def invariantWrapperImpl[T: c.WeakTypeTag](c: blackbox.Context)(): c.Expr[MyListInvariant[T]] = {
    import c.universe._
    val tpe = weakTypeOf[T]
    c.info(c.enclosingPosition, s"Wrapper invariant type T is: $tpe", true)
    c.Expr[MyListInvariant[T]](q"null")
  }

  def covariantImpl[T: c.WeakTypeTag](c: blackbox.Context): c.Expr[MyListCovariant[T]] = {
    import c.universe._
    val tpe = weakTypeOf[T]
    c.info(c.enclosingPosition, s"Covariant type T is: $tpe", true)
    c.Expr[MyListCovariant[T]](q"null")
  }

  def covariantWrapperImpl[T: c.WeakTypeTag](c: blackbox.Context)(): c.Expr[MyListCovariant[T]] = {
    import c.universe._
    val tpe = weakTypeOf[T]
    c.info(c.enclosingPosition, s"Wrapper covariant type T is: $tpe", true)
    c.Expr[MyListCovariant[T]](q"null")
  }

  def contravariantImpl[T: c.WeakTypeTag](c: blackbox.Context): c.Expr[MyListContravariant[T]] = {
    import c.universe._
    val tpe = weakTypeOf[T]
    c.info(c.enclosingPosition, s"Contravariant type T is: $tpe", true)
    c.Expr[MyListContravariant[T]](q"null")
  }

  def contravariantWrapperImpl[T: c.WeakTypeTag](c: blackbox.Context)(): c.Expr[MyListContravariant[T]] = {
    import c.universe._
    val tpe = weakTypeOf[T]
    c.info(c.enclosingPosition, s"Wrapper contravariant type T is: $tpe", true)
    c.Expr[MyListContravariant[T]](q"null")
  }
}
