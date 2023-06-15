const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("title");
let out2 = document.getElementById("details");




const resetButton = document.querySelector('input[type="reset"]');


resetButton.addEventListener('click', function () {
    displayElement.textContent = "";
});

sendButton.addEventListener('click', () => {
    const data = {
        bilirubin: document.querySelector('#mySelect1').value,
        albumin: document.querySelector('#mySelect2').value,
        inr: document.querySelector('#mySelect3').value,
        ascites: document.querySelector('#mySelect4').value,
        encephalopathy: document.querySelector('#mySelect5').value
    };
    $('#spinner-div').show();
    fetch('/calculator/Child-Pugh/result', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(result => {
            setTimeout(() => {
                out.textContent = result.title || "";
                out2.textContent = result.details || "";
                $('#spinner-div').hide();
            }, 3000);
        })
        .catch(error => {
            out.textContent=('Ошибка '+ error);
            setTimeout(() => {
                $('#spinner-div').hide();
            }, 3000);
        });
});

form.addEventListener('submit', (event) => {
    event.preventDefault();
    sendButton.click();
});