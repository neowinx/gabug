import java.util.Date
import play.api._

import models._
import anorm._

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    InitialData.insert()
  }
  
}

/**
 * Initial set of data to be imported 
 * in the sample application.
 */
object InitialData {
  
  def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)
  
  def insert() = {
    
    if(Prueba.findAll().isEmpty) {
      
      Seq(
        Prueba(1, "Test de ingreso al comercio exterior", Some(date("2011-11-18"))),
        Prueba(2, "Test de entrada a la puerta", Some(date("2011-11-18"))),
        Prueba(3, "Se quiere quitar esta cosa de encima", Some(date("2011-11-18")))
      ).foreach(Prueba.create)
      
    }
    
  }
  
}