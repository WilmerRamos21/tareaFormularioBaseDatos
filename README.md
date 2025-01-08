# Proyecto: Sistema de Login con JDBC y Visualización de Datos

Este proyecto es una aplicación Java que utiliza JDBC para conectarse a una base de datos MySQL, permitiendo a los usuarios autenticarse mediante un formulario de login y, posteriormente, visualizar datos almacenados en la base de datos en una interfaz gráfica amigable.

## Características del Proyecto

- Sistema de Login Seguro:
    El usuario ingresa su nombre de usuario y contraseña en un formulario de login.
    La autenticación se realiza mediante consultas parametrizadas con PreparedStatement para evitar vulnerabilidades como la inyección SQL.
- Interfaz Gráfica:
    Desarrollada en Java Swing, con formularios intuitivos y fáciles de usar.
    Tras el login exitoso, se muestra un mensaje de bienvenida personalizado.
- Visualización de Datos:
    Los datos se presentan en un componente JTable, que se actualiza dinámicamente desde la base de datos.
    Compatible con bases de datos estructuradas en MySQL.
- Diseño Modular:
    Código organizado en clases separadas para facilitar el mantenimiento y la escalabilidad.

## Capturas
<img width="1440" alt="Login" src="https://github.com/user-attachments/assets/1da20a5f-f020-4962-824e-e72d8ba97885" />

<img width="1440" alt="Mensaje de bienvenida" src="https://github.com/user-attachments/assets/13eb2df8-7ef7-4de5-882c-e4bf37e786a2" />

<img width="1440" alt="Datos en JTable" src="https://github.com/user-attachments/assets/e8009d36-dbed-4a51-8040-ed41761c4d2b" />
