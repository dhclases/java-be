window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará del nuevo odontologo
    const formulario = document.querySelector('#add_new_odontologo');
    console.log("*** Carga de pagina");
    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {
        console.log("*** Guardando");
        console.log("*** Seteando valores");
       //creamos un JSON que tendrá los datos de un nuevo odontologo
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,

        };
        //invocamos utilizando la función fetch la API peliculas con el método POST que guardará
        //la película que enviaremos en formato JSON
        console.log("*** Definiendo url");
        const url = '/odontologos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        console.log("Se Envia  " + JSON.stringify(formData).toString);
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log("Inicio de lectura del POST");
                 //Si no hay ningun error se muestra un mensaje diciendo que el odontologo
                 //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Odontologo agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";

       
                   resetUploadForm();
               
                

            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que el odontologo
                    //no se pudo guardar y se intente nuevamente
                    console.log("*** Error");
                    console.log(error);
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
                     resetUploadForm();})
    });


    function resetUploadForm(){
        console.log("*** Reseteando formulario");
        setTimeout(() => {  console.log("Dormir..."); }, 5000);
            document.querySelector('#nombre').value = "";
            document.querySelector('#apellido').value = "";
            document.querySelector('#matricula').value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/odontologoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});