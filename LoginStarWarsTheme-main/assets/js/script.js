const mode = document.getElementById('jedi');

mode.addEventListener('click',() => {
    const form = document.getElementById('login_form')
   if(mode.classList.contains('fa-jedi-order')) {
        mode.classList.remove('fa-jedi-order');
        mode.classList.add('fa-galactic-republic');

        form.classList.add('dark');
        return;
   }
   mode.classList.add('fa-jedi-order');
   mode.classList.remove('fa-galactic-republic');   
   form.classList.remove('dark');

});