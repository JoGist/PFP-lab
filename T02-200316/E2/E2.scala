object E2 {
    def corrisp[A,B](a:List[A], b:List[B], f:A=>B):Boolean = {
        if(a==Nil || b==Nil) true
        else if (b.head==f(a.head)) corrisp (a.tail, b.tail, f)
        else false
    }
}
