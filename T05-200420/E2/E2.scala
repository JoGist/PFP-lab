// Scrivere una versione parallela `fibPar` del metodo `fib` definito nel file `Fib.scala` usando
// fork-join in Scala mediante il costrutto `par`.

import Par._
import Fib._

object E2 {
    def fibPar(a:Int, b:Int)(n:Int):Long = {
        if(n<2) a
        else if(n==2) b
        else {
            val(ris_a, ris_b):(Long, Long) = par {
                fib(a,b)(n-1)
            }
            {
                fib(a,b)(n-1)
            }
            ris_a+ris_b
        }
    }
}