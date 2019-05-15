function addbook_data(data) {
    $('#books').append(
        $('<div id="book'+data.id+'">'+data.id+' - '+data.title+' <a href="javascript:kill('+data.id+'")>Kasuj</a></div>')
    );
}

function load_all_books() {
    $("#books").empty();
    $.ajax({
        url: '/book',
        type: 'GET',
        success: function(data) {
            data.forEach(addbook_data);
        }
    });
}

function on_submit(e) {
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

function kill(id) {
    $.ajax({
        url: '/book',
        type: 'DELETE',
        data: {
            id: id
        },
        success: function() {
            $("#book"+id).remove();
        }
    });
}

$(function() {
    $('#form').submit(on_submit);
    load_all_books();
});