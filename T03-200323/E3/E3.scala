case class Film(id:Int, titolo:String, anno:Int)
case class Regista(id:Int, nome:String)
case class DirettoDa(idFilm:Int, idRegista:Int)

case class DB(film:List[Film], registi:List[Regista], regie:List[DirettoDa]) {
    def registiConFilm(p:Film=>Boolean):List[Regista] = {
        val filmP = film.filter(x=>p(x)) 
        for {
            r <- registi 
            f <- filmP
            val t = DirettoDa(f.id, r.id) 
            if (regie. contains(t))  
        } yield r
    }.distinct
}
