var selectedGender = "";


document.getElementById('goToLogin').onclick = function() {
    window.location.href = "login.html";
}


function createAlert(x) {
    document.getElementById('alert_wrapper').innerHTML = x;
    document.getElementById('alert_wrapper').classList.add('open_alert');
    setTimeout(function() {
        document.getElementById('alert_wrapper').classList.remove('open_alert');
    }, 2000)
}


document.getElementById('goToGenderSelect').onclick = function() {
    if(document.getElementById('auth_name').value.length == 0) {
        createAlert('You must enter your name');
    } else if(document.getElementById('auth_email').value.length == 0) {
        createAlert('You must enter your email');
    } else if(!/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(String(document.getElementById('auth_email').value).toLowerCase())) {
        createAlert('You must enter a valid email');
    } else if(document.getElementById('auth_password').value.length < 8) {
        createAlert('Your password must be at least 8 characters long');
    } else if(document.getElementById('auth_password').value != document.getElementById('auth_password_confirm').value) {
        createAlert('Your passwords must match');
    } else {
        var selectedName = document.getElementById('auth_name').value;
        var selectedEmail = document.getElementById('auth_email').value;
        var selectedPassword = document.getElementById('auth_password').value;
        document.getElementById('auth_register_1').style.display = "none";
        document.getElementById('auth_register_2').style.display = "block";
    }
}

document.getElementById('goToAgeSelect').onclick = function() {
    if(selectedGender == "") {
        createAlert('You must select a gender');
    } else {
        document.getElementById('auth_register_2').style.display = "none";
        document.getElementById('auth_register_3').style.display = "block";
    }
}

document.getElementById('select_male_gender').onclick = function() {
    document.getElementById('select_male_gender').classList.add("gender_active");
    document.getElementById('select_female_gender').classList.remove("gender_active");
    selectedGender = "male";
}

document.getElementById('select_female_gender').onclick = function() {
    document.getElementById('select_male_gender').classList.remove("gender_active");
    document.getElementById('select_female_gender').classList.add("gender_active");
    selectedGender = "female";
}


for(var i=1;i<=31;i++) {
    var item = document.createElement("div");
    item.className = "date_selector_item day_selector_item";
    item.id = "day_item_"+i;
    var txt = document.createTextNode(i);
    item.appendChild(txt);
    document.getElementById("date_day_select_list").appendChild(item);
}
for(var i=1;i<=12;i++) {
    var item = document.createElement("div");
    item.className = "date_selector_item month_selector_item";
    item.id = "month_item_"+i;
    var txt = document.createTextNode(i);
    item.appendChild(txt);
    document.getElementById("date_month_select_list").appendChild(item);
}

var currentDate = new Date();

for(var i=currentDate.getFullYear()-60;i<=currentDate.getFullYear()-18;i++) {
    var item = document.createElement("div");
    item.className = "date_selector_item year_selector_item";
    item.id = "year_item_"+i;
    var txt = document.createTextNode(i);
    item.appendChild(txt);
    document.getElementById("date_year_select_list").appendChild(item);
}

document.getElementById("date_year_select_list").scrollTo(0, 30*(1998-currentDate.getFullYear()+60));


var selectedDay = 'dd';
var selectedMonth = 'mm';
var selectedYear = 'yyyy';

document.getElementById('date_day_box').innerHTML = selectedDay;
document.getElementById('date_month_box').innerHTML = selectedMonth;
document.getElementById('date_year_box').innerHTML = selectedYear;


for (var i = 0; i < document.getElementsByClassName('day_selector_item').length; i++) {
    document.getElementsByClassName('day_selector_item')[i].addEventListener('click', function(){
        selectedDay = this.innerHTML;
        document.getElementById('date_day_box').innerHTML = selectedDay;
        document.getElementById('date_month_box').innerHTML = selectedMonth;
        document.getElementById('date_year_box').innerHTML = selectedYear;
        document.getElementById('date_day_select_list').style.display = 'none';
        document.getElementById('date_month_select_list').style.display = 'none';
        document.getElementById('date_year_select_list').style.display = 'none';
    }, false);
}




for (var i = 0; i < document.getElementsByClassName('month_selector_item').length; i++) {
    document.getElementsByClassName('month_selector_item')[i].addEventListener('click', function(){
        selectedMonth = this.innerHTML;
        if(selectedMonth == '2') {
            if(parseInt(selectedYear, 10) % 4 == 0) {
                document.getElementById('day_item_29').style.display = 'block';
                if(selectedDay == '30' || selectedDay == '31') {
                    selectedDay = '29';
                }
            } else {
                document.getElementById('day_item_29').style.display = 'none';
                if(selectedDay == '29' || selectedDay == '30' || selectedDay == '31') {
                    selectedDay = '28';
                }
            }
            document.getElementById('day_item_30').style.display = 'none';
            document.getElementById('day_item_31').style.display = 'none';
        } else if(selectedMonth == '4' || selectedMonth == '6' || selectedMonth == '9' || selectedMonth == '11') {
            document.getElementById('day_item_29').style.display = 'block';
            document.getElementById('day_item_30').style.display = 'block';
            document.getElementById('day_item_31').style.display = 'none';
            if(selectedDay == '31') {
                selectedDay = '30';
            }
        } else {
            document.getElementById('day_item_29').style.display = 'block';
            document.getElementById('day_item_30').style.display = 'block';
            document.getElementById('day_item_31').style.display = 'block';
        }

        document.getElementById('date_day_select_list').style.display = 'none';
        document.getElementById('date_month_select_list').style.display = 'none';
        document.getElementById('date_year_select_list').style.display = 'none';
        document.getElementById('date_day_box').innerHTML = selectedDay;
        document.getElementById('date_month_box').innerHTML = selectedMonth;
        document.getElementById('date_year_box').innerHTML = selectedYear;
    }, false);
}


    

for (var i = 0; i < document.getElementsByClassName('year_selector_item').length; i++) {
    document.getElementsByClassName('year_selector_item')[i].addEventListener('click', function(){
        selectedYear = this.innerHTML;
        if(selectedMonth == '2') {
            if(parseInt(selectedYear, 10) % 4 == 0) {
                document.getElementById('day_item_29').style.display = 'block';
                if(selectedDay == '30' || selectedDay == '31') {
                    selectedDay = '29';
                }
            } else {
                document.getElementById('day_item_29').style.display = 'none';
                if(selectedDay == '29' || selectedDay == '30' || selectedDay == '31') {
                    selectedDay = '28';
                }
            }
        }
        document.getElementById('date_day_box').innerHTML = selectedDay;
        document.getElementById('date_month_box').innerHTML = selectedMonth;
        document.getElementById('date_year_box').innerHTML = selectedYear;
        document.getElementById('date_day_select_list').style.display = 'none';
        document.getElementById('date_month_select_list').style.display = 'none';
        document.getElementById('date_year_select_list').style.display = 'none';
    }, false);
}



document.getElementById('registerSubmit').onclick = function(){
    if(selectedDay == 'dd' || selectedMonth == 'mm' || selectedYear == 'yyyy') {
        createAlert('You must select a birth date');
    } else {
        window.location.href = "registermail.html";
    }
}



document.getElementById("date_day_box").onclick = function() {
    document.getElementById('date_day_select_list').style.display = 'block';
    document.getElementById('date_month_select_list').style.display = 'none';
    document.getElementById('date_year_select_list').style.display = 'none';
}

document.getElementById("date_month_box").onclick = function() {
    document.getElementById('date_day_select_list').style.display = 'none';
    document.getElementById('date_month_select_list').style.display = 'block';
    document.getElementById('date_year_select_list').style.display = 'none';
}

document.getElementById("date_year_box").onclick = function() {
    document.getElementById('date_day_select_list').style.display = 'none';
    document.getElementById('date_month_select_list').style.display = 'none';
    document.getElementById('date_year_select_list').style.display = 'block';
}