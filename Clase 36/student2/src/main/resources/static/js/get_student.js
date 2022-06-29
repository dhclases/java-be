window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/students/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
    $.each(data, (i, student) => {

      let deleteButton = '<button ' +
                              'id=' +
                              '\"' + 'btn_delete_' + student.id + '\"'+
                              ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                              '>&times</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + student.id + '\"' +
                                  ' type="button" onclick="find('+student.id+')" class="btn btn-info btn_id">' +
                                  student.id +
                                  '</button>';
      
      let tr_id = 'tr_' + student.id;
      let studentRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + student.name.toUpperCase() + '</td>' +
                '<td class=\"td_address\">' + student.lastname + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';                
      $('#peliculaTable tbody').append(studentRow);
    });

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/studentsList.html") {
      $(".nav .nav-item a:last").addClass("active");
  }
})
})