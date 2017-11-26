using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FinalBClient.Models
{
    public class ModelsIndentity
    {
    }

    //Modelo para ingreso de nuevo paciente
    public class PacienteModel
    {
        public string Cedula { get; set; }
        public string Nombres { get; set; }
        public string Apellidos { get; set; }
        public string Domicilio { get; set; }
        public string Localidad { get; set; }
        public string US { get; set; }
    }

    //Modelo para Borrar o quizas actualizar tambien
    public class ModelDeleteOrUpdatePeople
    {
        public string Cedula { get; set; }
    }

    public class DataBindSMSModel
    {
        public string SmsBody { get; set; }
    }
}