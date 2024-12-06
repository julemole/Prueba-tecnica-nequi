# Prueba Técnica Accenture

## Pasos para ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/julemole/Prueba-tecnica-nequi.git
2. Abre el proyecto en el editor de tu preferencia (puede ser IntelliJ, VS Code, Eclipse, etc.).
3. Configura las siguientes variables de entorno para utilizar la base de datos que está alojada en AWS:

DB_HOST: Endpoint de la base de datos.
DB_PORT: Puerto de la base de datos (por defecto 3306 para MySQL).
DB_NAME: Nombre de la base de datos.
DB_USERNAME: Usuario de la base de datos.
DB_PASSWORD: Contraseña de la base de datos.

Estas variables se deben configurar en tu entorno de desarrollo o en el sistema operativo.

4. Ejecuta el proyecto con el siguiente comando:

mvn spring-boot:run

## Documentación de Endpoints

Franchise (Franquicia)
Crear una nueva franquicia

Endpoint: POST /franchise
Body:
{
  "name": "string"
}
Editar una franquicia

Endpoint: PUT /franchise/{id}
Body:
{
  "name": "string"
}
Obtener una franquicia por ID

Endpoint: GET /franchise/{id}
Obtener todas las franquicias

Endpoint: GET /franchise
Sucursal
Crear una nueva sucursal asociada a una franquicia

Endpoint: POST /sucursal/{franchiseId}
Body:
{
  "name": "string"
}
Editar una sucursal

Endpoint: PUT /sucursal/{id}
Body:
{
  "name": "string"
}
Obtener sucursales por franquicia

Endpoint: GET /sucursal/franchise/{franchiseId}
Obtener una sucursal por ID

Endpoint: GET /sucursal/{id}
Product (Producto)
Crear un producto asociado a una sucursal

Endpoint: POST /product/{sucursalId}
Body:
{
  "name": "string",
  "stock": "integer"
}
Editar un producto

Endpoint: PUT /product/{id}
Body:
{
  "name": "string",
  "stock": "integer"
}
Actualizar solo el stock de un producto

Endpoint: PATCH /product/{id}
Body:
json
Copiar código
{
  "stock": "integer"
}
Estructura de los modelos
Producto

{
  "id": "integer",
  "name": "string",
  "stock": "integer"
}
Sucursal

{
  "id": "integer",
  "name": "string",
  "productList": [
    {
      "id": "integer",
      "name": "string",
      "stock": "integer"
    }
  ]
}
