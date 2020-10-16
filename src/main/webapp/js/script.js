
//All necessary scripts for buttons and pop-up forms
//Function for buttons to increase and decrease count
function increaseValue(id) {
  var value = parseInt(document.getElementById(id).value, 10);
  value = isNaN(value) ? 1 : value;
  value++;
  document.getElementById(id).value = value;
}
function decreaseValue(id) {
    var value = parseInt(document.getElementById(id).value, 10);
    value = isNaN(value) ? 1 : value;
    value < 1 ? value = 1 : '';
    value--;
    var minimum = 1;
    if (value < minimum){value = minimum;};
    document.getElementById(id).value = value;
}
//Function for pop-up forms
function openForm(id){
    document.getElementById(id).style.display='block';
    
}
function closeForm(id){
    document.getElementById(id).style.display='none';
}

