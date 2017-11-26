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
        private MiBeBe_DatabaseEntities Db;

        public ApiDataController()
        {
            Db = new MiBeBe_DatabaseEntities();
            //Evitar problema de referencia circular -- check foreing key --
            Db.Configuration.ProxyCreationEnabled = true;
        }


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
        public JsonResult DetPeople(ModelDeleteOrUpdatePeople model)
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
        
        //UPDATE :ApiData
        //Actualizar datos de un paciente de nuestra base de datos
        public JsonResult UpPeople(PacienteModel model)
        {
            //Seleccionando el paciente el cual modificaremos
            Paciente paciente = Db.Pacientes.FirstOrDefault(p => p.Cedula == model.Cedula);

            //Actualizando sus datos
            paciente.Nombres = model.Nombres;
            paciente.Apellidos = model.Apellidos;
            paciente.US = model.US;
            paciente.Localidad = model.Localidad;
            paciente.FechaNac = model.FechaNac;
            paciente.Domicilio = model.Domicilio;
            paciente.Telefono = model.Telefono;

            return Json(Db.SaveChanges(), JsonRequestBehavior.AllowGet);
        }

        //GET: ApiData
        //Obtener Datos de un paciente
        public JsonResult GetPeople(string cel)
        {
            //Enumerar y buscar el primero coincidiente con la cedula y retornar.
            return Json(Db.Pacientes.AsEnumerable().FirstOrDefault(p => p.Cedula == cel), JsonRequestBehavior.AllowGet);
        }


        //Mas Codigo incoming
    }
}