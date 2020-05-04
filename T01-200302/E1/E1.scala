// trasformare il seguente medodo in modo che usi la ricorsione di coda

object E1 {
    def sum(n:Int)={
        def camil(n:Int, m:Int):Int = if  (n<1) m else sum2(n-1, m+n)
        sum2(n,0)
    }
}
