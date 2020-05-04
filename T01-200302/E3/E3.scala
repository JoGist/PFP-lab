//Si scriva un metodo Scala sommaQuadrati che, dati due interi x e y con x<=y, calcola la somma dei quadrati 
//dei numeri da x a y, compresi. Scrivere la soluzione nel file E3.scala in modo simile a quanto fatto negli 
//esercizi precedenti e usare il programma di prova E3Main.scala fornito.

object E3 {
    def sommaQuadrati(x:Int, y:Int):Int = {
        def camil(x:Int, y:Int, z:Int):Int = if (x>y) z else camil(x+1, y, (x*x)+z)
        camil(x,y,0)
    }
}