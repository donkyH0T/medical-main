const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("title");
let out2 = document.getElementById("details");
let ans1_grace = document.getElementById("ans1_grace");
let ans2_grace = document.getElementById("ans2_grace");
let ans3_grace = document.getElementById("ans3_grace");



const resetButton = document.querySelector('button[type="reset"]');

resetButton.addEventListener('click', function () {
    out.textContent = "";
    out2.textContent = "";
});

sendButton.addEventListener('click', () => {
    let cardiac = 0;
    let sts = 0;
    let elevated = 0;
    if (ans1_grace.checked) {
        cardiac = "1";
    }
    if (ans2_grace.checked) {
        sts = "1";
    }
    if (ans3_grace.checked) {
        elevated = "1";
    }

    const data = {
        age: document.getElementById("age_grace").value,
        hr: document.getElementById("rate_grace").value,
        systolic: document.getElementById("rate_grace").value,
        plasmaCreatinine:document.getElementById("kreatinin_grace").value,
        cardiacArrest: cardiac,
        stsegmentoffset: sts,
        elevatedMarkerLevels: elevated,
        heartFailure: document.querySelector('#ans4_grace').value
    };
    $('#spinner-div').show();
    fetch('/calculator/GRACE/result', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if(response.ok){
                return  response.json()
            }else {
                throw new Error('Ошибка HTTP: ' + response.status);
            }
        })
        .then(result => {
            setTimeout(() => {
                out.textContent = result.title || "";
                out2.textContent = result.details || "";
                $('#spinner-div').hide();
            }, 3000);
        })
        .catch(error => {
            out.textContent=(error);
            out2.textContent="";
            setTimeout(() => {
                $('#spinner-div').hide();
            }, 3000);
        });
});

function checkLimits(input) {
    if (input.value < 0) {
        input.value = 0;
    } else if (input.value > 100) {
        input.value = 100;
    }
}

form.addEventListener('submit', (event) => {
    event.preventDefault();
    if(document.getElementById("age_grace").value===""||document.getElementById("rate_grace").value===""||document.getElementById("rate_grace").value==="" ||document.getElementById("kreatinin_grace").value===""||document.querySelector('#ans4_grace').value===""){
        alert("Поле не может быть пустым!");
    }else{
    sendButton.click();}

});

