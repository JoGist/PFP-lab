// Scrivere un metodo `def subList(l:List[T]):Boolean` applicabile su un oggetto `List[T]` `s` che restituisce `true` 
// se e solo se tutti gli elementi di `l` appaiono anche in `s` nello stesso ordine, anche non consecutivamente.

import scala.language.implicitConversions

object E3 { 
    implicit def seq2MySeq[T](s:List[T]):MyList[T] = new MyList(s)
}

class MyList[T](s:List[T]) {
	import E3._
    def subList(l:List[T]):Boolean = {
        if(l.forall(x=>s.contains(x)) && s.filter(x=>l.contains(x))==l) true
        else false
    }
}
