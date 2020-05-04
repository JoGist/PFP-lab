//Scrivere un metodo Scala somma che, dato come parametro una funzion f:Int=>Int, restituisce una funzione che prende
//come parametri due interi a e b e restituisce la somma di f(x) per ogni x compreso tra a e b (estremi inclusi). 
//Scrivere la soluzione nel file E5.scala in modo simile a quanto fatto negli esercizi precedenti e usare il main

//Suggerimento. Usare il seguente schema nella soluzione:

object E5 {
    def somma(f:Int=>Int):(Int, Int)=>Int = {
        def funzioneDaRestituireCheEraGiaAbbastanzaLungaQuindiAllunghiamolaUnAltroPo(a:Int, b:Int):Int = {
            def foooooooooooooooooooooooooooooooooooooooooooooooooo(s:Int, b:Int):Int = {if(b<a) s else foooooooooooooooooooooooooooooooooooooooooooooooooo(s+f(b), b-1)}
        foooooooooooooooooooooooooooooooooooooooooooooooooo(0,b)
        }
    funzioneDaRestituireCheEraGiaAbbastanzaLungaQuindiAllunghiamolaUnAltroPo
    }
}
