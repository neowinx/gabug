# --- First database schema

# --- !Ups

create table prueba (
  id                     integer not null primary key,
  descripcion            varchar(255) not null,
  fechaInicio            date
);

# --- !Downs

drop table if exists prueba;
