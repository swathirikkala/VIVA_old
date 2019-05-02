function openModal(modalDiv){
$("#"+modalDiv).load('md.html');  
    document.getElementById(modalDiv).style.display='block';

}
function closeModal(modalDiv){

$("#"+modalDiv).display(none);  
  document.getElementById(modalDiv).style.display='none';
}