function addbook_data(data) {
    let a = $('<a>Kasuj</a>');
    a.click(function () {
        kill(data.id)
    });
    let div = $('<div id="book' + data.id + '">' + data.id + ' - ' + data.title + '</div>');
    div.append(" ");
    div.append(a);
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
        url: '/book/'+id,
        type: 'DELETE',
        success: function () {
            $("#book" + id).remove();
        }
    });
}

$(function () {
    $('#form').submit(on_submit);
    load_all_books();
});