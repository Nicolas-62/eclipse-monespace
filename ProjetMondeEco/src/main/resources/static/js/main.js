/********************* explication fonction call() : ********************************/
/*Using call to invoke a function and specifying the context for 'this'
 In the example below, when we call greet, the value of this will be bound to object obj.

 function greet() {
 var reply = [this.animal, 'typically sleep between', this.sleepDuration].join(' ');
 console.log(reply);
 }

 var obj = {
 animal: 'cats', sleepDuration: '12 and 16 hours'
 };

 greet.call(obj);  // cats typically sleep between 12 and 16 hours*/

/************************************************************************************/

/**
 * ******************** Listeners
 * **************************************************
 */

var setupListener = function() {

	document.getElementById("formContact").addEventListener("submit",
			verifFormContact);

	document.getElementById("nomContact").addEventListener("keyup",
			verifNomPrenom);

	document.getElementById("prenomContact").addEventListener("keyup",
			verifNomPrenom);

	document.getElementById("emailContact")
			.addEventListener("keyup", verifMail);

	document.getElementById("messageContact").addEventListener("keyup",
			verifMessage);
}
window.addEventListener("load", setupListener);

/**
 * ******************** fonctions
 * **************************************************
 */

var verifNomPrenom = function() {
	var regex = /^[a-zA-Zàâéèëêïîôùüçœ\'’ -]{2,25}$/;
	if (!regex.test(this.value)) {
		this.classList.remove("is-valid");
		this.classList.add("is-invalid");
		return false;

	} else {
		this.classList.remove("is-invalid");
		this.classList.add("is-valid");
		return true;
	}
}
var verifMail = function() {
	var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if (!regex.test(this.value)) {
		this.classList.remove("is-valid");
		this.classList.add("is-invalid");
		return false;

	} else {
		this.classList.remove("is-invalid");
		this.classList.add("is-valid");
		return true;
	}
}
var verifMessage = function() {
	var regex = /^[a-zA-Z0-9àâéèëêïîôùüçœ+=\'’ ._ ,-\w\d\s]{100,2000}$/;

	if (!regex.test(this.value)) {
		console.log("invalid" + this.value);
		this.classList.remove("is-valid");
		this.classList.add("is-invalid");
		return false;

	} else {

		this.classList.remove("is-invalid");
		this.classList.add("is-valid");
		return true;
	}
}
var verifFormContact = function(e) {

	var NomOk = verifNomPrenom.call(this.nomContact);

	var PrenomOk = verifNomPrenom.call(this.prenomContact);

	var MailOk = verifMail.call(this.emailContact);

	var MessageOk = verifMessage.call(this.messageContact);

	if (NomOk && PrenomOk && MailOk && MessageOk) {
		return true;
	} else {
		e.preventDefault();
		return false;
	}
}
