package NSP_TECH.RUTAS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import NSP_TECH.RUTAS.model.ruta;
import NSP_TECH.RUTAS.repository.rutasRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class rutaServices {

    @Autowired
    private rutasRepository rutarepository;

    public List<ruta> BuscarTodoRutas(){
        return rutarepository.findAll();
    }
        public ruta BuscarUnaRuta(Long id_ruta){
        return rutarepository.findById(id_ruta).get();
    }

    public ruta GuardarRuta(ruta ruta){
        return rutarepository.save(ruta);

    }

    public void  EliminarRuta(Long id_ruta){
        rutarepository.deleteById(id_ruta);
    }

}
