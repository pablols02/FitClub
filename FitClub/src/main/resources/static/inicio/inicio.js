document.getElementById('formulario').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita el envío tradicional del formulario

    // Obtener datos del formulario
    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    const mensaje = document.getElementById('mensaje').value;

    // Datos para EmailJS
    const templateParams = {
        nombre: nombre,
        email: email,
        mensaje: mensaje
    };

    // Enviar correo usando EmailJS
    emailjs.send('service_o9vsymm', 'template_it20ynx', templateParams)
    .then(function(response) {
        console.log('Correo enviado con éxito', response.status, response.text);
        alert('Correo enviado con éxito.');
        document.getElementById('formulario').reset();
    }, function(error) {
        console.error('Error al enviar el correo:', error);
        alert('Error al enviar el correo.');
    });
});