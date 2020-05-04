object E4 {
    def checkBitonic(l:List[Int]):(List[Int],List[Int]) = {
        if (l == Nil)  (List(), List())
        else {
            val max:Int = l.max
            val (a,b) = l.splitAt(l.indexOf(max)+1)
            if (a == a.sorted && b.reverse == b.sorted) (a,b)
            else (List(), List())
        }
    }
}
