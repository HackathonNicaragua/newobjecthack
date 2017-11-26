using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FinalBClient.Models
{
    public class ModelsIndentity
    {
    }

    public class PacienteModel
    {
        public string Cedula { get; set; }
        public string Nombres { get; set; }
        public string Apellidos { get; set; }
        public string Domicilio { get; set; }
        public string Localidad { get; set; }
        public int Telefono { get; set; }
        public DateTime FechaNac { get; set; }
        public string US { get; set; }
    }

    public class ModelDeletePeople
    {
        public string Cedula { get; set; }
    }
}