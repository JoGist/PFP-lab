object E2 {
    def getModel(n:Int):List[Shape] = {
        getModelAux(1, n)
    }

    def getModelAux(i:Int, n:Int):List[Shape] = {
        if(i<=n) Circle(0.5*i/n, 0.5*i/n, 0.5*i/n) :: getModelAux(i+1, n)
        else Nil
    }
}
