
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    empleadoJpaController empleJPA = new empleadoJpaController();
    
    public void crearEmpleado (Empleado emp) {
    empleJPA.create(emp);
    }
    
    public void borrarEmpleado(Long id) {
    try {
       empleJPA.destroy(id);
       } catch (NonexistentEntityException ex) {
       Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
      }
   
    }
    
    public List <Empleado> traerEmpleados () {
      return empleJPA.findempleadoEntities();
    
    }
    
    public void modificarPersona (Empleado emp) {
      
        try {
         empleJPA.edit(emp);
        } catch (Exception ex) {
         Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public Empleado traerEmpleadoPorId(Long id) {
        
         EntityManager em = getEntityManager(); // Obtén el EntityManager
    return em.find(Empleado.class, id); // Busca y devuelve el empleado con el ID proporcionado
    }
    
    // Método para actualizar un empleado en la base de datos
    public void actualizarEmpleado(Empleado empleado) {
    EntityManager em = getEntityManager(); // Obtén el EntityManager
    em.getTransaction().begin();           // Inicia la transacción

    // Asegúrate de que el empleado tiene un ID válido
    if (empleado.getId() != null) {
        // Usa merge para actualizar la entidad existente o persistir una nueva si no existe
        em.merge(empleado);
    } else {
        System.out.println("Empleado no válido para actualización.");
    }

    em.getTransaction().commit(); // Realiza el commit de la transacción    }
    
    }
    public void eliminarEmpleado(Long id) {
      EntityManager em = getEntityManager(); // Obtén el EntityManager
      em.getTransaction().begin();  // Inicia la transacción

      // Buscar el empleado por ID
      Empleado empleado = em.find(Empleado.class, id);

    if (empleado != null) {
        // Si el empleado existe, eliminarlo
        em.remove(empleado);
        em.getTransaction().commit();  // Commit de la transacción
        System.out.println("Empleado con ID " + id + " ha sido eliminado.");
    } else {
        System.out.println("Empleado no encontrado con ID " + id);
    }
    }
    
    // Método para buscar empleados por cargo
    public List<Empleado> buscarEmpleadosPorCargo(String cargo) {
       
        EntityManager em = getEntityManager();  // Obtén el EntityManager
      String queryStr = "SELECT e FROM Empleado e WHERE e.cargo = :cargo";  // Consulta JPQL
       return em.createQuery(queryStr, Empleado.class)
             .setParameter("cargo", cargo)
             .getResultList();  // Ejecuta la consulta y obtiene los resultados
    }

    
    private EntityManager getEntityManager() {
   
    return javax.persistence.Persistence.createEntityManagerFactory("empleadoPU").createEntityManager();
}
}
