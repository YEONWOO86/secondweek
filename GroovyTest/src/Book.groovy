
class Booka {
    String title
  }
  
  def properties = Collections.synchronizedMap([:])
  
  Booka.metaClass.setAuthor = { String value ->
     properties[System.identityHashCode(delegate) + "author"] = value
  }
  Booka.metaClass.getAuthor = {->
     properties[System.identityHashCode(delegate) + "author"]
  }

  Booka a = new Booka();
    
  a.author = "�����ٶ󸶹ٻ�"
  a.author = "abcde"
  println(a.getAuthor())
  
 