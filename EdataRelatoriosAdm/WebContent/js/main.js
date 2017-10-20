function goTo(id) {
	var nomeAtt1 = document.getElementById("att1").value;
	var att1 = document.getElementById(nomeAtt1).value;
	
	document.getElementById(nomeAtt1).value = id;
	
	document.forms[0].submit();

}