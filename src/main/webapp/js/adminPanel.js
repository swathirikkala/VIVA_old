function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

function loadFunctionalityDiv(funcDiv){

$("#stakeHolders").hide();
$("#projectManagers").hide();
$("#technicalTeam").hide();
$("#projects").hide();
$("#sprints").hide();
$("#epics").hide();
$("#userStoriesDiv").hide();
$("#dashBoard").hide();
$("#"+funcDiv).show();

}