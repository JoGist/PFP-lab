import scala.language.implicitConversions

object E2 {
    implicit def vec2vec[T](v:Vector[T]) = E2(v)
}

case class E2[T](v:Vector[T]) {
    import E2._

    def isMappedFrom[T1](m:Vector[T1], f:T=>T1):Boolean = {
        val res:Vector[T1] = v.map(f)
        if (res == m) true
        else false
    }
}