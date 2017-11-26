package com.example.newobjecthack.mibebe;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static org.ksoap2.SoapEnvelope.*;

public class Activity_chat extends AppCompatActivity {
    String URL = "http://mibebewcf.azurewebsites.net/Service1.svc?wsdl";
    String NAMESPACE = "http://tempuri.org/";
    //String SOAP_ACTION = "http://tempuri.org/IService1/GetData";
    String SOAP_ACTION = "http://tempuri.org/IService1/Ins";
    String METHOD_NAME = "Ins";
    String PARAMETER_NAME = "query";
    ListView lmensajes;
    TextView txtmensaje;

    private Timer TIM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //lmensajes = (ListView) findViewById(R.id.list_messages);
        txtmensaje = (TextView) findViewById(R.id.input);
        setSupportActionBar(toolbar);
        /*TIM = new Timer();
        TimerTask timerTask;
        {
            timerTask = new TimerTask() {
                @Override
                public void run() {

                }
            };
        }
        TIM.scheduleAtFixedRate(timerTask, 0, 10);*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                /*Database usdbh =
                        new Database(getApplicationContext(), "BDmibebe", null, 1);

                SQLiteDatabase db = usdbh.getWritableDatabase();
                try
                {
                    db.execSQL("INSERT INTO empresa (Nombre,Notificacion,Aviso) " +
                            "VALUES ('" + 1 + "', '" + 2 +"',"+ 0 +")");
                    //Cerramos la base de datos
                    db.close();

                    Toast.makeText(getApplicationContext(),"Cliente agregado", Toast.LENGTH_LONG).show();
                }
                catch (SQLException ex)
                {
                    Toast.makeText(getApplicationContext(),"Error cuando se intentaba guardar el cliente, intentelo de nuevo", Toast.LENGTH_LONG).show();
                }*/

                String consulta = "insert into chat values(77825484,'" + txtmensaje.getText() + "',1,1)";
                new CallWebService().execute(consulta);
            }
        });
        /*final Handler handler = new Handler();
        final Runnable r = new Runnable()
        {
            public void run()
            {
                mostrarsms();
            }
        };

        handler.postDelayed(r, 1000);*/
        /*Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            int sec = 0;
            @Override
            public void run() {
                SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
                soapObject.addProperty(PARAMETER_NAME, params[0]);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(soapObject);
                HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
                try {
                    httpTransportSE.call(SOAP_ACTION, envelope);
                    //SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();
                    Object o = (Object) envelope.getResponse();
                    Toast.makeText(getApplicationContext(),o.toString(), Toast.LENGTH_LONG).show();
                    //result = soapPrimitive.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    //result = e.getMessage();
                }
            }
        };
        timer.scheduleAtFixedRate(t,1000,1000);*/
        String consulta = "select * from message";
        new refresh_sms().execute(consulta);
    }

    public void mostrarsms()
    {
        Database usdbh = new Database(this, "BDmibebe", null, 1);
        SQLiteDatabase db = usdbh.getReadableDatabase();
        Cursor resul=db.rawQuery("select * from message",null);
        try {
            ArrayList<chat> chats = new ArrayList<chat>();
            if(resul.moveToFirst())
            {
                do
                {
                    chat c = new chat();
                    c.setId_chat(resul.getInt(0));
                    c.setNumero(resul.getString(1));
                    c.setCuerpo(resul.getString(2));
                    c.setId_paciente(resul.getInt(3));
                    c.setId_doctor(resul.getInt(4));
                    chats.add(c);
                }while(resul.moveToNext());

                chatadapter miAdaptador = new chatadapter(getApplicationContext(), chats);
                lmensajes = (ListView) findViewById(R.id.list_messages);
                lmensajes.setAdapter(miAdaptador);
            }
            else {
                Toast.makeText(this,"No se encontraron mensajes", Toast.LENGTH_LONG).show();
            }
        }
        catch (SQLException ex) {
            Toast.makeText(this,"Error al leer la base de datos intentelo de nuevo", Toast.LENGTH_LONG).show();
        }
    }

    class CallWebService extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            //aqui vamos a mostrar los resultados.
            //text.setText("Square = " + s);
            String consulta = "select top 10 * from chat";
            new getmensajes().execute(consulta);
            txtmensaje.setText("");
        }

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
            soapObject.addProperty(PARAMETER_NAME, params[0]);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(soapObject);
            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
            try {
                httpTransportSE.call(SOAP_ACTION, envelope);
                SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();
                result = soapPrimitive.toString();
            } catch (Exception e) {
                result = e.getMessage();
            }
            return result;
        }
    }



    class getmensajes extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            String[] row = s.split("\\|");
            for (int i = 0; i < row.length; i++)
            {
                //Toast.makeText(getApplicationContext(),row[i], Toast.LENGTH_LONG).show();
                String[] cols = row[i].split("\\;");

                Database usdbh = new Database(getApplicationContext(), "BDmibebe", null, 1);

                SQLiteDatabase db = usdbh.getWritableDatabase();
                try
                {
                    db.execSQL("delete from  message where IDchat = "+ cols[0] +"");
                    db.execSQL("INSERT INTO message (IDchat,Numero,Cuerpo, idpaciente, iddoctor) " +
                            "VALUES (" + cols[0] + ", " + cols[1].toString() +",'"+ cols[2].toString() +"', "+ cols[3].toString() +","+ cols[4].toString() +")");
                    //Cerramos la base de datos
                    db.close();
                    //Toast.makeText(getApplicationContext(),"Cliente agregado", Toast.LENGTH_LONG).show();
                }
                catch (SQLException ex)
                {
                    Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            String consulta = "select * from message ORDER BY IDchat DESC LIMIT 8";
            new refresh_sms().execute(consulta);
        }

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            SoapObject soapObject = new SoapObject(NAMESPACE, "GetChat");
            soapObject.addProperty(PARAMETER_NAME, "select top 8 * from chat order by id_chat desc");
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(soapObject);
            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);
            try {
                httpTransportSE.call("http://tempuri.org/IService1/GetChat", envelope);
                SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();
                result = soapPrimitive.toString();
            } catch (Exception e) {
                result=e.getMessage();
            }
            return result;
        }

    }

    ArrayList<chat> chats;

    class refresh_sms extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("")) {
                chatadapter miAdaptador = new chatadapter(getApplicationContext(), chats);
                lmensajes = (ListView) findViewById(R.id.list_messages);
                lmensajes.setAdapter(miAdaptador);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No se encontraron mensajes", Toast.LENGTH_LONG).show();
            }
            String consulta = "select top 10 * from chat ";
            new getmensajes().execute(consulta);
        }

        @Override
        protected String doInBackground(String... params) {
            String R="";
            Database usdbh = new Database(getApplicationContext(), "BDmibebe", null, 1);
            SQLiteDatabase db = usdbh.getReadableDatabase();
            Cursor resul=db.rawQuery(params[0],null);
            try {
                chats = new ArrayList<chat>();
                if(resul.moveToFirst())
                {
                    do
                    {
                        chat c = new chat();
                        c.setId_chat(resul.getInt(0));
                        c.setNumero(resul.getString(1));
                        c.setCuerpo(resul.getString(2));
                        c.setId_paciente(resul.getInt(3));
                        c.setId_doctor(resul.getInt(4));
                        chats.add(c);
                    }while(resul.moveToNext());

                }
                else {
                    R="No se encontraron mensajes";
                }
            }
            catch (SQLException ex) {
                R="Error al leer la base de datos intentelo de nuevo";
            }

            return R;
        }

    }
}
