/**
 * 
 */
 
 
 const busItems = document.querySelectorAll(".busItem");
 
 window.addEventListener('DOMContentLoaded', (event) => {
    setTimeout(() => {
		busItems.forEach(busItem => {
			busItem.classList.add("isShow");
		})
	}, 10);

});