/**
 * 
 */
 const form = document.querySelector(".form");
 const password = document.querySelector("#password");
 const confirmPassword = document.querySelector("#confirmPassword");
 
 form.addEventListener("submit", (e) => {
	e.preventDefault();
	if(password.value !== confirmPassword.value) {
		confirmPassword.setCustomValidity("パスワードが違います。");
	}else {
		form.submit();
	}
})