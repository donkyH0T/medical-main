const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("title");
let out2 = document.getElementById("details");
let ans1_grace = document.getElementById("togel1");
let ans2_grace = document.getElementById("togel4");
let ans3_grace = document.getElementById("togel5");
let ans4_grace = document.getElementById("togel6");
let ans5_grace = document.getElementById("togel7");



const resetButton = document.querySelector('#Reset');

resetButton.addEventListener('click', function () {
    out.textContent = "";
    out2.textContent = "";
});

function checkLimits(input) {
    if (input.value < 0) {
        input.value = 0;
    } else if (input.value > 100) {
        input.value = 100;
    }
}


sendButton.addEventListener('click', () => {
    let togel1 = 0;
    let togel = 0;
    let elevated = 0;
    if (ans1_grace.checked) {
        togel1 = "1";
    }

    if (ans2_grace.checked) {
        togel = "1";
    }
    if (ans3_grace.checked) {
        togel = "2";
    }
    if (ans4_grace.checked) {
        togel = "3";
    }
    if (ans5_grace.checked) {
        togel = "4";
    }
    const data = {
        paO2: document.getElementById("PaO2_param").value,
        fio2: document.getElementById("FIO2_param").value,
        ventilation: togel1,
        platelets: document.getElementById("Platelets_param").value,
        bilirubin: document.getElementById("Total_Bilirubin_param").value,
        bloodPressure: togel,
        glasgowScale: document.getElementById("Glasgow_Coma_Score_param").value,
        creatinine: document.getElementById('Creatinine_param').value,
        diuresis: document.getElementById("Urine_Output_param").value
    };
    $('#spinner-div').show();
    fetch('/calculator/SOFA/result', {
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
            out.textContent=(error.message);
            setTimeout(() => {
                $('#spinner-div').hide();
            }, 3000);
        });
});

form.addEventListener('submit', (event) => {
    event.preventDefault();
    sendButton.click();
});
