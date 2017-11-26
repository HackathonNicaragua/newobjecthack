using FinalBClient.ModelDB;
using FinalBClient.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace FinalBClient.Controllers
{

    public class ApiDataController : Controller
    {
        //Instanciar el model creado, buenas practicas usar --readonly--
        private MiBeBe_DatabaseEntities Db = new MiBeBe_DatabaseEntities();
        
        // GET: ApiData
        public JsonResult PutPeople(PacienteModel Person)
        {
            //Agregar nuevo paciente

            //Create an object Paciente
            Paciente paciente = new Paciente
            {
                Nombres = Person.Nombres,
                Apellidos = Person.Apellidos,
                Cedula = Person.Cedula,
                Telefono = Person.Telefono,
                Domicilio = Person.Domicilio,
                Localidad = Person.Localidad,
                FechaNac = Person.FechaNac,
                US = Person.US
            };

            //Insert object paciente into a Pacientes table
            Db.Pacientes.Add(paciente);
            return Json(Db.SaveChanges(), JsonRequestBehavior.AllowGet);
        }

        //DELETE :ApiData
        //Eliminar un paciente de nuestra Base de Datos
        public JsonResult DetPeople(ModelDeletePeople model)
        {
            //Consultamos a nuestra Db, seleccionamos el que sera eliminado.
            var query = from p in Db.Pacientes
                        where p.Cedula.Contains(model.Cedula)
                        select p;

            //Remover el seleccionado
            foreach (Paciente p in query)
            {
                Db.Pacientes.Remove(p);
            }

            return Json(Db.SaveChanges(), JsonRequestBehavior.AllowGet);
        } 
    }
}