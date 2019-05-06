function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
	document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
	document.getElementById("mySidebar").style.display = "none";
	document.getElementById("myOverlay").style.display = "none";
}

function loadFunctionalityDiv(funcDiv) {

	$("#stakeHolders").hide();
	$("#projectManagers").hide();
	$("#technicalTeam").hide();
	$("#projects").hide();
	$("#sprints").hide();
	$("#epics").hide();
	$("#userStories").hide();
	$("#dashBoard").hide();

	if (funcDiv == 'projects') {
		loadProjectForm();
	}else if(funcDiv == 'sprints'){
		loadSprintForm();
	}

}

function loadSprintForm(){
	$("#sprints").show();
	$("#sprintsDiv").load('./sprint.html');
	displaySprints();
	try {
		var project = new Object();
		project.assignedManager = sessionStorage.getItem("userId");
		$.ajax({
			url : "./assignedProjects",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(project),
			contentType : 'application/json',
			mimeType : 'application/json',

			success : function(data) {
				var respJSONString = JSON.stringify(data);
				console.log(respJSONString);
				var jsonObj = JSON.parse(respJSONString);
				console.log(jsonObj.responseCode + " : "
						+ jsonObj.responseMessage+" : " + data.responseObject );
//				if (typeof(Storage) !== "undefined") {
//					// Store
//					var responseObject =JSON.parse(JSON.stringify(data.responseObject));
//					sessionStorage.setItem("users", responseObject);
//				} else {
//					console.log("Sorry, your browser does not support Web Storage...");
//				}
				$('#projectName').empty();
				$.each(data.responseObject, function (i, project) {
					console.log("projectName option : " + project);
					sessionStorage.setItem(project.projectId,project.projectName);
					$('#projectName').append('<option value='+project.projectId+'>' + project.projectName + '</option>');
					console.log('<option value='+project.projectId+'>' + project.projectName + '</option>');
				});
				console.log("projectName value in sprint page default : " + $("#projectName").val());
			},

			error : function(data, status, er) {
				alert("loadSprintForm error: " + data + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
}
function loadProjectForm()
{
	$("#projects").show();
	$("#projectsDiv").load('./projectHome.html');
	displayProjects();
	try {
		var user = new Object();
		user.emailId = sessionStorage.getItem("userId");
		$.ajax({
			url : "./getAllUsers",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(user),
			contentType : 'application/json',
			mimeType : 'application/json',

			success : function(data) {
				var respJSONString = JSON.stringify(data);
				console.log(respJSONString);
				var jsonObj = JSON.parse(respJSONString);
				console.log(jsonObj.responseCode + " : "
						+ jsonObj.responseMessage+" : " + data.responseObject );
				if (typeof(Storage) !== "undefined") {
					// Store
					var responseObject =JSON.parse(JSON.stringify(data.responseObject));
					sessionStorage.setItem("users", responseObject);
				} else {
					console.log("Sorry, your browser does not support Web Storage...");
				}
				$('#assignedMenager').empty();
				$.each(data.responseObject, function (i, item) {
					var option = new Option(item, item); 
					console.log("assignedMenager option : " + item);
					$('#assignedMenager').append('<option value='+item.emailId+'>' + item.firstName +' '+ item.lastName + '</option>');

				});
				console.log("assignedMenager value : " + $("#assignedMenager").val());
			},

			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
}
	

