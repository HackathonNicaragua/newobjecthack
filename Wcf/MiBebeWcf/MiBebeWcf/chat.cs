using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MiBebeWcf
{
    public class chat
    {
        public int id_chat { get; set; }
        public int numero { get; set; }
        public string cuerpo { get; set; }
        public int id_paciente { get; set; }
        public int id_doctor { get; set; }
    }
}