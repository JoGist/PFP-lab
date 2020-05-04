object E3 {
    def noobSort[T <% Ordered[T]](v:Vector[T]) = {
        def auxFunction(c:List[Vector[T]]):Vector[T] = {
            if (c.isEmpty) Vector()
            else if (c.head == v.sorted) c.head
            else auxFunction(c.tail)
        }
        auxFunction(v.permutations.toList)
    }
}