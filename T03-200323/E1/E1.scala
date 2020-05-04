sealed abstract class Tree {
    def treeTest() :Boolean = this match {
        case E() => true
        case T(sx:Tree, value:Int, dx:Tree) => val root:Int = value
                                                (sx, dx) match {
                                                    case (E(), E()) => true
                                                    case (T(_, e:Int, _), E()) => if (root < e) false else sx.treeTest
                                                    case (E(), T(_,e:Int, _ )) => if (root > e) false else dx.treeTest
                                                    case (T(_, e1:Int, _ ), T(_, e2:Int, _ )) => if (root < e1) false else 
                                                    if (root > e2) false else
                                                    dx.treeTest && sx.treeTest
                                                } 
    }
}

// albero non vuoto
case class T(l:Tree, e:Int, r:Tree) extends Tree 

// albero vuoto
case class E() extends Tree
