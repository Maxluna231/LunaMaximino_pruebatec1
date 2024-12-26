
package com.hackaboss.pruebatecnica;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Empleado;
import logica.SalarioInvalidoException;
import persistencia.ControladoraPersistencia;


   public class PruebaTecnica {
   private static List<Empleado> empleados = new ArrayList<>();
  
    public static void main(String[] args) {
      ControladoraPersistencia controlPersis = new ControladoraPersistencia(); 
      Scanner teclado = new Scanner(System.in);
      boolean bandera = false; 

        System.out.println("=======================================");
        System.out.println("  ʕ•́ᴥ•̀ʔ   GESTIÓN DE EMPLEADOS  ʕ•́ᴥ•̀ʔ ");
        System.out.println("=======================================");
   
        while(bandera != true) {
            System.out.println("\nSeleccione una opcion :) ");
            System.out.println("1.Agregar un nuevo empleado");
            System.out.println("2.Mostrar empleados");
            System.out.println("3.Actualizar empleados");
            System.out.println("4.Eliminar empleados");
            System.out.println("5.Buscar empleado por cargo");
            System.out.println("6.Salir");
            
             if (!teclado.hasNextInt()) {
                System.out.println("Opción no válida. Intente de nuevo.");
                teclado.next(); // Descarta la entrada no válida
                continue;
            }


            
            int choice = teclado.nextInt();
            teclado.nextLine();
            
             switch (choice) {
                case 1:
                    anadirEmpleado(teclado, controlPersis);
                    break;
                case 2:
                    mostrarEmpleado(controlPersis);
                    break;
                      case 3:
                    actualizarEmpleado(teclado, controlPersis);
                    break;
                case 4:
                    eliminarEmpleado(teclado, controlPersis);
                    break;
                case 5:
                    buscarEmpleadosPorCargo(teclado, controlPersis);
                    break;
                case 6:
                    bandera = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
             
            }
        
        teclado.close();
            }
    
        
        
        public static void anadirEmpleado(Scanner teclado, ControladoraPersistencia controlPersis){
          Empleado emple = new Empleado();
            
          String nombre = null;
          boolean nombreValido = false;
          
          while(nombreValido != true) {
          try {
                System.out.println("Ingrese su nombre");
                nombre = teclado.nextLine();
                //validar si nombre es correcto
                validarNombre(nombre);
                nombreValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
          }
          emple.setNombre(nombre); // Asignar el nombre al empleado
          
          
          String apellido = null;
          boolean apellidoValido = false;
          
          while (apellidoValido !=true){
          
          try {
              System.out.println("Ingrese su apellido");
              apellido = teclado.nextLine();
              //validar si apellido es correcto
              validarApellido(apellido);
              apellidoValido = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
          }
           emple.setApellido(apellido); // Asignar el apellido al empleado
           
          String cargo = null;
          boolean cargoValido = false;
          
          while (cargoValido !=true){
              try{
              System.out.println("Ingrese el cargo");
              cargo = teclado.nextLine();
              //validar si cargo es correcto
              validarCargo(cargo);
              cargoValido = true;
          }catch (IllegalArgumentException e){
                  System.out.println(e.getMessage());
                  
                  }
          } 
         emple.setCargo(cargo); // Asignar el cargo al empleado 
          
          double salario = 0.0;
          boolean salarioValido = false;
          
          while (salarioValido != true) {
          try {
              System.out.println("Ingrese salario");
              salario = teclado.nextDouble();
              //validar si salario es correcto
              validarSalario(salario);
              salarioValido = true;
          }catch (SalarioInvalidoException e){
              System.out.println(e.getMessage());
          }
          
          }
        emple.setSalario(salario); // Asignar el salario al empleado
        teclado.nextLine(); // Limpiar el buffer
          
          String fechaInicio = null;
          boolean fechaValido = false;
          
          while (fechaValido != true){
          
              try{
                  System.out.println("Ingrese su fecha de inicio del empleado");
                  fechaInicio = teclado.nextLine();
                  //validar si fechaInicio es correcto
                  validarFecha(fechaInicio);
                  fechaValido = true;
              }catch (IllegalArgumentException e){
                  System.out.println(e.getMessage());
              }
          }
           emple.setFechaInicio(fechaInicio); // Asignar la fecha al empleado
          
             controlPersis.crearEmpleado(emple);
              empleados.add(emple); // Añadir a la lista local
            System.out.println("Registrado con exito");
    }
    
    
 
private static void mostrarEmpleado(ControladoraPersistencia controlPersis) {
    // Obtener todos los empleados desde la base de datos
    List<Empleado> listaEmpleados = controlPersis.traerEmpleados();

    // Verificar si hay empleados registrados
    if (listaEmpleados.isEmpty()) {
        System.out.println("No hay empleados registrados en la base de datos.");
    } else {
        System.out.println("---- Lista de Empleados ----");
        // Usar un bucle for-each para mostrar los datos
        for (Empleado empleado : listaEmpleados) {
            System.out.println("ID: " + empleado.getId() +
                    ", Nombre: " + empleado.getNombre() +
                    ", Apellido: " + empleado.getApellido() +
                    ", Cargo: " + empleado.getCargo() +
                    ", Salario: " + empleado.getSalario() +
                    ", Fecha de Inicio: " + empleado.getFechaInicio());
        }
    }
}
    
    private static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
         throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private static void validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
         throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
    }

    private static void validarCargo(String cargo) {
       if (cargo == null || cargo.trim().isEmpty()) {
     throw new IllegalArgumentException("El apellido no puede estar vacío");
       }
    }

    private static void validarSalario(double salario) throws SalarioInvalidoException {
       if (salario <= 0) {
            throw new SalarioInvalidoException("El monto ingresado es inválido. Debe ser mayor a 0");
        }
    }

    private static void validarFecha(String fechaInicio) {
      if (fechaInicio == null || fechaInicio.trim().isEmpty()) {
      throw new IllegalArgumentException("La fecha no puede estar vacia");
      }
    }

    private static void actualizarEmpleado(Scanner teclado, ControladoraPersistencia controlPersis) {
    System.out.println("Ingrese el ID del empleado a actualizar:");
    Long id = teclado.nextLong(); // Usar Long en lugar de int
    teclado.nextLine();  // Limpiar el buffer

    // Traer el empleado por ID
    Empleado empleado = controlPersis.traerEmpleadoPorId(id);

    if (empleado != null) {
        System.out.println("Empleado encontrado: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Ingrese el nuevo nombre (deje vacío para no cambiar):");
        String nombre = teclado.nextLine();
        if (!nombre.trim().isEmpty()) empleado.setNombre(nombre);

        System.out.println("Ingrese el nuevo apellido (deje vacío para no cambiar):");
        String apellido = teclado.nextLine();
        if (!apellido.trim().isEmpty()) empleado.setApellido(apellido);

        System.out.println("Ingrese el nuevo cargo (deje vacío para no cambiar):");
        String cargo = teclado.nextLine();
        if (!cargo.trim().isEmpty()) empleado.setCargo(cargo);

        System.out.println("Ingrese el nuevo salario (0 para no cambiar):");
        double salario = teclado.nextDouble();
        if (salario > 0) empleado.setSalario(salario);

        teclado.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese la nueva fecha de inicio (deje vacío para no cambiar):");
        String fechaInicio = teclado.nextLine();
        if (!fechaInicio.trim().isEmpty()) empleado.setFechaInicio(fechaInicio);

        // Llamada a actualizar el empleado en la base de datos
        controlPersis.actualizarEmpleado(empleado);
        System.out.println("Empleado actualizado exitosamente.");
    } else {
        System.out.println("Empleado no encontrado.");
    }
}

    public static void eliminarEmpleado(Scanner teclado, ControladoraPersistencia controlPersis) {
     System.out.println("Ingrese el ID del empleado a eliminar:");
    
    Long idEmpleado = teclado.nextLong();  // Leer el ID del empleado
    teclado.nextLine(); // Limpiar el buffer
    
    // Llamar al método eliminarEmpleado de la controladora de persistencia
    controlPersis.eliminarEmpleado(idEmpleado);
}

    private static void buscarEmpleadosPorCargo(Scanner teclado, ControladoraPersistencia controlPersis) {
    System.out.println("Ingrese el cargo del empleado que desea buscar:");
    String cargo = teclado.nextLine();  // Leer el cargo ingresado por el usuario

    // Llamar al método buscarEmpleadosPorCargo de la controladora de persistencia
    List<Empleado> empleadosPorCargo = controlPersis.buscarEmpleadosPorCargo(cargo);

    // Verificar si la lista está vacía
    if (empleadosPorCargo.isEmpty()) {
        System.out.println("No se encontraron empleados con ese cargo.");
    } else {
        // Imprimir los empleados encontrados
        System.out.println("Empleados con el cargo " + cargo + ":");
        for (Empleado empleado : empleadosPorCargo) {
            System.out.println("ID: " + empleado.getId() +
                    ", Nombre: " + empleado.getNombre() +
                    ", Apellido: " + empleado.getApellido() +
                    ", Salario: " + empleado.getSalario() +
                    ", Fecha de Inicio: " + empleado.getFechaInicio());
        }
    }
}


        }
       
       
    
 
