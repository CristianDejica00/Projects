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

document.getElementById("quest_creator_input").onkeyup = function() {
    if(document.getElementById("quest_creator_input").value.length > 0) {
        document.getElementById("quest_creator_input").style.width = "calc(100% - 80px)";
        document.getElementById("quest_creator_submit").style.display = "block";
    } else {
        document.getElementById("quest_creator_input").style.width = "calc(100% - 40px)";
        document.getElementById("quest_creator_submit").style.display = "none";
    }
}

window.onclick = function(evt) {
    if(evt.target.className == "post_menu_toggle") {
        for(i=0;i<document.getElementsByClassName('post_menu_options').length;i++) {
            if(document.getElementsByClassName('post_menu_options')[i] === evt.target.parentElement.getElementsByClassName('post_menu_options')[0]) {
                document.getElementsByClassName('post_menu_options')[i].style.display = 'block';
            } else {
                document.getElementsByClassName('post_menu_options')[i].style.display = 'none';
            }
        }
        evt.target.parentElement.getElementsByClassName('post_menu_options').style.display = 'block';
    } else {
        for(i=0;i<document.getElementsByClassName('post_menu_options').length;i++) {
            document.getElementsByClassName('post_menu_options')[i].style.display = 'none';
        }
    }
}