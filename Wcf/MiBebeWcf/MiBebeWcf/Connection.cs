using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace MiBebeWcf
{
    public class Connection
    {
        string ruta = "Data Source=mibebeserver.database.windows.net;Initial Catalog=MiBeBe_Database;Integrated Security=False;User ID=mibebeAdmin;Password=miBBpassword7;Connect Timeout=30;Encrypt=True;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";
        public SqlConnection con;
        private SqlCommand cmd;
        private void conectar()
        {
            con = new SqlConnection(ruta);
        }

        public Connection()
        {
            conectar();
        }

        /*metodo de eliminar*/
        public Boolean eliminar(string cadena)
        {
            try
            {
                con.Open();
                cmd = new SqlCommand();
                cmd.CommandText = cadena;
                cmd.Connection = con;
                int i = cmd.ExecuteNonQuery();
                con.Close();
                if (i > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch
            {
                con.Close();
                return false;
            }
        }

        /*metodo de actualizacion*/
        public Boolean actualizar(string cadena)
        {
            try
            {
                con.Open();
                cmd = new SqlCommand();
                cmd.CommandText = cadena;
                cmd.Connection = con;
                int i = cmd.ExecuteNonQuery();
                con.Close();
                if (i > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch
            {
                con.Close();
                return false;
            }
        }
        /*metodo de insercion*/
        public Boolean insertar(string cadena)
        {
            try
            {
                con.Open();
                cmd = new SqlCommand();
                cmd.CommandText = cadena;
                cmd.Connection = con;
                int i = cmd.ExecuteNonQuery();
                con.Close();
                if (i > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch
            {
                con.Close();
                return false;
            }

        }
        /*metodo de busqueda*/
        public DataTable buscar(string cadena)
        {
            try
            {
                DataSet ds = new DataSet();
                SqlDataAdapter da;
                DataTable dt;
                string consulta = cadena;
                con.Open();
                da = new SqlDataAdapter(consulta, con);
                da.Fill(ds);
                con.Close();
                dt = ds.Tables[0];
                return (dt);
            }
            catch
            {
                con.Close();
                return null;
            }
        }
    }
}