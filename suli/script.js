var a, b, tableElem, rowElem, colElem;
function createTable() {

    a = document.getElementById('row').value;
    b = document.getElementById('column').value;

    if (a == "" || b == "") {
        alert("Enter a number");
    } else {
        tableElem = document.createElement('table');

        for (var i = 0; i < a; i++) {
            rowElem = document.createElement('tr');
            
            for (var j = 0; j < b; j++) {
                colElem = document.createElement('td');
                colElem.appendChild(document.createTextNode(Math.ceil(Math.random() * 100)));
                
                rowElem.appendChild(colElem);
            }
            rowElem.appendChild(document.createTextNode(Math.ceil(Math.random() * 100)));
            tableElem.appendChild(rowElem);
        }

        document.body.appendChild(tableElem);
    }

}

