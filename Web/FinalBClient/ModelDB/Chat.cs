//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace FinalBClient.ModelDB
{
    using System;
    using System.Collections.Generic;
    
    public partial class Chat
    {
        public int Id_Chat { get; set; }
        public Nullable<int> Numero { get; set; }
        public string Cuerpo { get; set; }
        public Nullable<int> Id_Paciente { get; set; }
        public Nullable<int> Id_Doctor { get; set; }
    
        public virtual Doctor Doctor { get; set; }
        public virtual Paciente Paciente { get; set; }
    }
}
