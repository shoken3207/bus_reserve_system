/**
 * 
 */
 const form = document.querySelector(".form");
 const password = document.querySelector("#password");
 const confirmPassword = document.querySelector("#confirmPassword");
 console.log(form);
 
 form.addEventListener("submit", (e) => {
	e.preventDefault();
	console.log(password.value);
	console.log(confirmPassword.value);
	if(password.value !== confirmPassword.value) {
		console.log("diff")
		console.log(confirmPassword.setCustomValidity);
		confirmPassword.setCustomValidity("パスワードが違います。");
	}else {
		console.log("onClick");
	}
})