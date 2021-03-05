document.getElementById('modal_edit').addEventListener('show.bs.modal', setModalData);
document.getElementById('modal_delete').addEventListener('show.bs.modal', setModalData);

function setModalData(event){
    const button = event.relatedTarget;
    this.querySelector('#user_id').value = button.getAttribute('data-bs-id');
    this.querySelector('#user_id_hidden').value = button.getAttribute('data-bs-id');
    this.querySelector('#name').value = button.getAttribute('data-bs-name');
    this.querySelector('#login').value = button.getAttribute('data-bs-login');}