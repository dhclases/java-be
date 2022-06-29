$(document).ready(function(){
    let studentId = 0;

    $(document).on("click", "#div_pelicula_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        studentId = btn_id.split("_")[2];

        $("div.modal-body")
            .text("Queres eliminar el estudiante con id = " + studentId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/students/' + studentId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Eliminade correctamente !");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the pelicula row on html page
                let row_id = "tr_" + studentId;
                $("#" + row_id).remove();
                $("#div_pelicula_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_pelicula_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});