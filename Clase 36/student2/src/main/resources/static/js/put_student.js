window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_pelicula_form');
    formulario.addEventListener('submit', function (event) {
        let studentId = document.querySelector('#student_id').value;
        const formData = {
            id: document.querySelector('#student_id').value,
            name: document.querySelector('#nombre').value,
            lastname: document.querySelector('#apellido').value,

        };
        const url = '/students';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
            let student = data;
                    let studentString = "{firstname:" + student.name +
                                                " ,lastname:" + student.lastname  + "}";
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> student = </strong> ' + data.toString();
                                        '</div>'

                    // change the updated data for pelicula table record
                    $("#tr_" + studentId + " td.td_first_name").text(student.name);
                    $("#tr_" + studentId + " td.td_address").text(student.lastname);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
        
        }).catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong> Error </strong></div>';

            $("#response").empty();                                    
            $("#response").append(errorAlert);
            $("#response").css({"display": "block"});
        })

    })
    })

          
    

    function find(id) {
        
          const url = '/students'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let student = data;
              $("#student_id").val(student.id);
              $("#nombre").val(student.name);
              $("#apellido").val(student.lastname);
              $("#div_pelicula_updating").css({"display": "block"});
          }).catch(error => {
              console.log(error);
              alert("Error -> " + error);
          })
      }