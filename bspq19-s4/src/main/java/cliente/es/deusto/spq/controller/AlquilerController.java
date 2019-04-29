package cliente.es.deusto.spq.controller;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

public class AlquilerController{

    private RMIBSPQ19S4ServiceLocator service;

    public AlquilerController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
    }
    
    public boolean alquilarPelicula(String fAlq, int tAlq, String correo, int id){
      return service.getService().alquilarPelicula(fAlq, tAlq, correo, id);
    }
    
}