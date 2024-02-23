First task: API test automation

Explicación detallada de cada método @Test en el código proporcionado:

testReadUser:
Este test automatizado verifica que se pueda leer la información de un usuario recién creado.
Utiliza una solicitud GET al endpoint /api/v3/user/john_john para obtener la información del usuario.
Luego, verifica que la respuesta tenga un código de estado 200, lo que indica que la solicitud fue exitosa.
Además, comprueba que el campo "id" en la respuesta sea igual a 12345 y que el campo "username" sea igual a "john_john".

testReadUpdatedUser:
Similar al test anterior, este test verifica que se pueda leer la información actualizada de un usuario.
Realiza una solicitud GET al mismo endpoint /api/v3/user/john_john para obtener la información actualizada del usuario.
Al igual que el primer test, verifica que la respuesta tenga un código de estado 200 y que los campos "id" y "username" sean los mismos que los del usuario original.
Puede incluir verificaciones adicionales para otros campos en la respuesta si es necesario en el futuro.

testPerformanceAndValidation:
Este test combina varias pruebas de rendimiento y validación de datos.
Realiza una serie de solicitudes GET al endpoint /api/v3/user/john_john en un bucle para probar el rendimiento del sistema (en este caso, se realizan 5 solicitudes).
Verifica que cada solicitud tenga un código de estado 200, lo que indica que la solicitud fue exitosa.
Luego, realiza una solicitud GET adicional y verifica que el tiempo de respuesta sea menor a 1000 milisegundos (1 segundo), lo que prueba el tiempo de respuesta del sistema.
Finalmente, realiza pruebas de validación de nombres, verificando que los campos "firstName" y "lastName" en la respuesta solo contengan letras utilizando expresiones regulares.