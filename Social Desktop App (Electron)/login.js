document.getElementById('goToRegister').onclick = function() {
    window.location.href = "register.html";
}


function createAlert(x) {
    document.getElementById('alert_wrapper').innerHTML = x;
    document.getElementById('alert_wrapper').classList.add('open_alert');
    setTimeout(function() {
        document.getElementById('alert_wrapper').classList.remove('open_alert');
    }, 2000)
}


document.getElementById('loginSubmit').onclick = function() {
    if(document.getElementById('auth_email').value.length == 0) {
        createAlert('You must enter your email');
    } else if(!/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(String(document.getElementById('auth_email').value).toLowerCase())) {
        createAlert('You must enter a valid email');
    } else if(document.getElementById('auth_password').value.length < 8) {
        createAlert('Your password must be at least 8 characters long');
    } else {
        window.location.href = "index.html";
    }
}