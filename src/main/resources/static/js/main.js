function addbook_data(data) {
    let a1 = $('<a href="/book/'+data.id+'">'+data.title+'</a>');
    let div = $('<div id="book' + data.id + '"></div>');
    div.append(a1);
    $('#books').append(div);
}

function load_all_books() {
    $("#books").empty();
    $.ajax({
        url: '/book',
        type: 'GET',
        success: function (data) {
            data.forEach(addbook_data);
        }
    });
}

function on_submit_addbook_form(e) {
    $.ajax({
        url: "/book",
        type: 'PUT',
        data: {
            'title': $("#form_title").val()
        },
        success: addbook_data
    });
    e.preventDefault();
}

function on_submit_modifybook_form(e) {
    $.ajax({
        url: "/book/"+id,
        type: 'PATCH',
        data: {
            'title': $("#form_title").val()
        },
        success: function() { alert('Saved successfully!'); }
    });
    e.preventDefault();
}


function kill(id) {
    $.ajax({
        url: '/book/'+id,
        type: 'DELETE',
        success: function () {
            $("#book" + id).remove();
            window.location.href = '/';
        }
    });
}

