package com.example.newobjecthack.mibebe;

/**
 * Created by DTI34 on 25/11/2017.
 */

public class chat {
    private int id_chat;
    private String numero;
    private String cuerpo;
    private int id_paciente;
    private int id_doctor;

    public chat() {
       super();
    }

    public chat(int id_chat, String numero, String cuerpo, int id_paciente, int id_doctor) {
        this.id_chat = id_chat;
        this.numero = numero;
        this.cuerpo = cuerpo;
        this.id_paciente = id_paciente;
        this.id_doctor = id_doctor;
    }

    public int Id_chat() {
        return id_chat;
    }

    public void setId_chat(int id) {
        this.id_chat = id;
    }

    public String Numero() {
        return numero;
    }

    public void setNumero(String id) {
        this.numero = id;
    }
    public String Cuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String c) {
        this.cuerpo = c;
    }
    public int Id_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id) {
        this.id_paciente = id;
    }
    public int Id_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id) {
        this.id_doctor = id;
    }
}
