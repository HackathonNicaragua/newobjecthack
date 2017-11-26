﻿$(document).ready(function () {
    LoadUsers();
});

function LoadUsers() {
    axios.get("/ApiData/GetListPeople").then((users) => {
        var html = '';
        users.data.forEach((user, index) => {
            html += `<tr>`;
            html += `<td>${user.Nombres +' '+ user.Apellidos}</td>`
            html += `<td>${user.Cedula}</td>`
            html += `<td>${user.US}</td>`
            html += `<td><button type="button" class="btn btn-danger" onclick="getUserById('${user.Cedula}')">Editar</button></td>`
            html += `<td><button type="button" class="btn btn-danger" onclick="deleteUser('${user.Cedula}')">Eliminar</button></td>`
            html += `</tr>`
        })
        $("tbody.tcuerpo").html(html);
    }).catch(err => alert(err))
 }

//POST
//Funcion para aregagr usuario
function addUser() {

    var Obj = {
        Cedula: $('#InputCedula').val(),
        Nombres: $('#InputNames').val(),
        Apellidos: $('#InputLastNames').val(),
        Domicilio: $('#InputDomicilio').val(),
        Localidad: $('#InputLocalidad').val(),
        US: $('#InputUS').val()
    };

    console.log(Obj);

    $.ajax({
        url: "/ApiData/PutPeople",
        data: JSON.stringify(Obj),
        type: "POST",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            //Actualizamos la tabla
            $('#usersModal').modal('hide');
            LoadUsers();
        },
        error: function (errormessage) {
            console.log(errormessage.responseText)
        }
    });
}

function sendMsj() {

    var Obj = {
        SmsBody: $('#InputSMSBody').val(),      
    };

    $.ajax({
        url: "/ApiData/SendSMS",
        data: JSON.stringify(Obj),
        type: "POST",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            //Actualizamos la tabla
            $('#smsModal').modal('hide');
            
        },
        error: function (errormessage) {
            console.log(errormessage.responseText)
        }
    });

}

function getUserById(id) {

}

function deleteUser(id) {

}