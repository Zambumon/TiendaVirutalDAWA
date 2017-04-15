var original = document.getElementById("pass"), confirmation = document.getElementById("passcheck");

function passwordCheck(){
    if(original.value !== confirmation.value) {
        confirmation.setCustomValidity("¡Las contraseñas no coinciden!");
    } else {
        confirmation.setCustomValidity('');
    }
}

original.onchange = passwordCheck;
confirmation.onkeyup = passwordCheck;
