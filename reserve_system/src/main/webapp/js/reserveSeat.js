const seats  = document.getElementById('seats');
const submit = document.getElementById('submit');
const boxes = document.getElementsByClassName('box');

let counter = 0;
let k = 0;
const alpha = ['a', 'b', 'c', 'd'];
let selectedList = [];

submit.disabled = true;
seats.innerHTML = `${counter}席確保`;

Array.from(boxes).forEach(e => {
    const i = Math.floor(k / 4);
    const j = k % 4;
    k++;
    e.dataset.seatNo = i + alpha[j];
    if (e.classList.contains('reserved')) return;
    e.addEventListener('click', () => {
        if (e.classList.contains('selected')) {
            e.classList.remove('selected');
            selectedList.splice(e.dataset.seatNo, 1);
            counter--;
        } else {
            e.classList.add('selected');
            selectedList.push(e.dataset.seatNo);
            counter++;
        }
        seats.innerHTML = `${counter}席確保`;
        document.seatForm.selectedSeats.value = selectedList;
        submit.disabled = counter === 0;
    })
})

const reset = () => {
	Array.from(boxes).forEach(e => {
		e.classList.remove('selected');
	})
	selectedList = [];
	document.seatForm.selectedSeats.value = selectedList;
	submit.disabled = true;
	counter = 0;
	seats.innerHTML = `${counter}席確保`;
}