using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace MiBebeWcf
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código, en svc y en el archivo de configuración.
    // NOTE: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione Service1.svc o Service1.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class Service1 : IService1
    {
        public string GetData(int value)
        {
            return string.Format("You entered: {0}", value);
        }

        public CompositeType GetDataUsingDataContract(CompositeType composite)
        {
            if (composite == null)
            {
                throw new ArgumentNullException("composite");
            }
            if (composite.BoolValue)
            {
                composite.StringValue += "Suffix";
            }
            return composite;
        }

        Connection c;

        public string GetChat(string query)
        {
            try
            {
                //List<chat> lc = new List<chat>();
                string resultado ="";
                c = new Connection();
                var dt =c.buscar(query);


                foreach (DataRow r in dt.Rows)
                {
                    //chat c = new chat();
                    resultado += r[0].ToString() + ";";
                    resultado += r[1].ToString() + ";";
                    resultado += r[2].ToString() + ";";
                    resultado += r[3].ToString() + ";";
                    resultado += r[4].ToString() + ";";
                    resultado += "|";
                    //lc.Add(c);
                }
                //return dt.Select().ToList();

                return resultado;
            }
            catch
            {
                return null;
            }
        }

        public string Ins(string query)
        {
            try
            {
                c = new Connection();
                if(c.insertar(query))
                {
                    return "OK";
                }
                else
                {
                    return "No";
                }
            }
            catch
            {
                return "No exc";
            }
        }
    }
}
