using FinalBClient.ModelDB;
using FinalBClient.Models;
using FinalBClient.ServiceReference1;
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
            Db.Configuration.ProxyCreationEnabled = false;
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
                Domicilio = Person.Domicilio,
                Localidad = Person.Localidad,
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
            paciente.Domicilio = model.Domicilio;

            return Json(Db.SaveChanges(), JsonRequestBehavior.AllowGet);
        }

        //GET: ApiData

        public JsonResult GetListPeople()
        {
            //Retornar json con todos los datos de todos los pacientes.
            return Json(Db.Pacientes.AsEnumerable(), JsonRequestBehavior.AllowGet);
        }

        //GET: ApiData
        //Obtener Datos de un paciente
        public JsonResult GetPeople(string cel)
        {
            //Enumerar y buscar el primero coincidiente con la cedula y retornar.
            return Json(Db.Pacientes.AsEnumerable().FirstOrDefault(p => p.Cedula == cel), JsonRequestBehavior.AllowGet);
        }

        //Mas Codigo incoming

        public JsonResult SendSMS(DataBindSMSModel model)
        {
            /*Al ser unicamente un prototipo, estamos guardando un mensaje en nuestra db, el cual sera tomando
            por la app movil. --No es posible hacer un sistema completo de mensajeria en dos dias, 
            para nosotros :D hay mucho que se debe tomar en cuenta para lograrlo --*/

            Service1Client s = new Service1Client();
            var r = s.Ins(string.Format("insert into chat values(74757879,'{0}', 1, 1)", model.SmsBody));
            return Json("1", JsonRequestBehavior.AllowGet);
        }
    }
}