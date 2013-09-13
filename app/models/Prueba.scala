package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

import java.util.Date

case class Prueba(id: Int, descripcion: String, fechaInicio: Option[Date])

object Prueba {

  val simple = {
    get[Int]("prueba.id") ~
      get[String]("prueba.descripcion") ~
      get[Option[Date]]("prueba.fechaInicio") map {
      case id~descripcion~fechaInicio=> Prueba(id, descripcion, fechaInicio)
    }
  }

  def findAll(limit: Int = 10, offset: Int = 0): Seq[Prueba] = {
    DB.withConnection { implicit connection =>
      SQL("select * from prueba limit {limit} offset {offset}")
        .on("limit" -> limit, "offset" -> offset).as(Prueba.simple *)
    }
  }

  def create(prueba: Prueba): Prueba = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into prueba values (
            {id}, {descripcion}, {fechaInicio}
          )
        """
      ).on(
        'id -> prueba.id,
        'descripcion -> prueba.descripcion,
        'fechaInicio -> prueba.fechaInicio
      ).executeUpdate()

      prueba

    }
  }


}
