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
    
    public partial class Examan
    {
        public int Id_Examen { get; set; }
        public string Nombre { get; set; }
        public string Descripcion { get; set; }
        public string Resultados { get; set; }
        public Nullable<int> Id_Paciente { get; set; }
        public string Interpretacion { get; set; }
    
        public virtual Paciente Paciente { get; set; }
    }
}
