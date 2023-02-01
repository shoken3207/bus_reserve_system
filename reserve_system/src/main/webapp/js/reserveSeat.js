Array.from(document.getElementsByClassName('box')).forEach(e => {
    e.addEventListener('click', () => {
        e.classList.toggle('selected');
    })
})