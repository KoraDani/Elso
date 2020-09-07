$(document).ready(function () {
    $('#btn').click(function () {
        $(colElem).append(1);
    });

    $('#btn').click(function () {
        $(tableElem).find("td").each(function(){
            $(this).html(Math.floor(Math.random() * 100));
        });
      });
});