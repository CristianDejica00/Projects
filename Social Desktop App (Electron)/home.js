window.onload = function() {
    var cont_wrap = document.getElementById('content_wrapper');
    document.getElementById('profile_options').style.right = (window.innerWidth - cont_wrap.clientWidth)/2 + 18 + "px";
}

window.onresize = function() {
    var cont_wrap = document.getElementById('content_wrapper');
    document.getElementById('profile_options').style.right = (window.innerWidth - cont_wrap.clientWidth)/2 + 18 + "px";
}

window.onclick = function(evt) {
    if(evt.target.id == "navbar_avatar_circle") {
        document.getElementById('profile_options').style.display = "block";
    } else {
        document.getElementById('profile_options').style.display = "none";
    }
}