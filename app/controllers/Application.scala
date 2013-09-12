package controllers

import play.api.libs.json._
import play.api.mvc._

import models.Prueba

object Application extends Controller {

  implicit val pruebWrites = Json.writes[Prueba]

  def index = Action {
    Ok(views.html.index())
  }

  def sayHello = Action {
    Ok( Json.toJson( Prueba.findAll() ) )
  }
  
}