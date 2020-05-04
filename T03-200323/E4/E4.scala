object E4 {
    def isAnagramOf(a:String, b:String):Boolean = {
		val c = b.toSeq.permutations.toList.map(x=>x.toString)
        if(c.contains(a)) true else false
    }
}
