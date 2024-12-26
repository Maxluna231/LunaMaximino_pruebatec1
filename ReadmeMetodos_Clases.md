# Metodos

**public static void anadirEmpleado(Scanner teclado, ControladoraPersistencia controlPersis)**
 
- teclado: Objeto Scanner para capturar entradas del usuario
- controlPersis: Objeto de la clase ControladoraPersistencia para manejar operaciones de persistencia.

- Solicita y valida los datos del nuevo empleado
- Crea un objeto Empleado y lo guarda en la base de datos.
- Añade el empleado a una lista local para un acceso más rápido.


## private static void mostrarEmpleado(ControladoraPersistencia controlPersis)

- controlPersis: Objeto para acceder a los datos almacenados.

- Recupera la lista de empleados desde la base de datos.

- Muestra cada empleado con su información detallada.

- Informa si no hay empleados registrados.

## private static void actualizarEmpleado(Scanner teclado, ControladoraPersistencia controlPersis)

- teclado: Objeto Scanner para capturar entradas del usuario.

- controlPersis: Objeto para realizar las operaciones de actualización.

- Solicita el ID del empleado a actualizar.

- Permite modificar nombre, apellido, cargo, salario y fecha de inicio.

- Valida los datos ingresados antes de guardarlos.

- Guarda los cambios en la base de datos.

## public static void eliminarEmpleado(Scanner teclado, ControladoraPersistencia controlPersis)

- teclado: Objeto Scanner para capturar el ID.

- controlPersis: Objeto para gestionar la eliminación en la base de datos.

- Solicita el ID del empleado a eliminar.

- Llama al metodo de eliminación en la base de datos.

## private static void buscarEmpleadosPorCargo(Scanner teclado, ControladoraPersistencia controlPersis)
- teclado: Objeto Scanner para capturar el cargo.

- controlPersis: Objeto para realizar la búsqueda en la base de datos.

- Funcionamiento:

- Solicita el cargo a buscar.

- Recupera y muestra la lista de empleados que coinciden.

# clase Empleado

- Atributos

- id: Identificador único del empleado.

- nombre: Nombre del empleado.

- apellido: Apellido del empleado.

- cargo: Cargo del empleado.

- salario: Salario del empleado.

- fechaInicio: Fecha de inicio en la empresa.

## Metodos
**Getters y Setters: Métodos para obtener y asignar los valores de los atributos.**


# Clase: ControladoraPersistencia

## Metodos

## public void crearEmpleado(Empleado emple)

- Guarda un nuevo empleado en la base de datos.

## public List<Empleado> traerEmpleados()

- Recupera todos los empleados registrados.

## public Empleado traerEmpleadoPorId(Long id)

- Recupera un empleado basado en su ID.

# public void actualizarEmpleado(Empleado emple)

- Actualiza la información de un empleado existente.

# public void eliminarEmpleado(Long idEmpleado)

-  Elimina un empleado de la base de datos.

# public List<Empleado> buscarEmpleadosPorCargo(String cargo)

- Busca empleados que coincidan con un cargo específico.
