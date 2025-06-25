package NSP_TECH.RUTAS.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import NSP_TECH.RUTAS.model.ruta;
import NSP_TECH.RUTAS.repository.rutasRepository;
import NSP_TECH.RUTAS.services.rutaServices;

public class rutasServiceTest {

    
    @Mock
    private rutasRepository rutasrepository;
    
    @InjectMocks
    private rutaServices rutasservices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    
    @Test
    public void testBuscarTodo(){
    java.util.List<ruta> lista = new  ArrayList<>();

    ruta ruta1 = new ruta();
    ruta ruta2 = new ruta();

    ruta1.setId_ruta(11L);
    ruta1.setId_envio(11L);
    ruta1.setOrigen("Santiago");
    ruta1.setDestino("San Jose de Maipo");
    ruta1.setDistancia_km(BigDecimal.valueOf(50.25));
    ruta1.setDuracion_estimada("1h");
    ruta1.setEstado("En camino");

    ruta2.setId_ruta(12L);
    ruta2.setId_envio(12L);
    ruta2.setOrigen("Maipu");
    ruta2.setDestino("San Jose de Maipo");
    ruta2.setDistancia_km(BigDecimal.valueOf(70.00));
    ruta2.setDuracion_estimada("1h 30min");
    ruta2.setEstado("En camino");

    

    lista.add(ruta1);
    lista.add(ruta2);

    when(rutasrepository.findAll()).thenReturn(lista);

    java.util.List<ruta> resultadoBusqueda = rutasservices.BuscarTodoRutas();

    assertEquals(2,resultadoBusqueda.size());
    verify(rutasrepository, times(1)).findAll();

}

    @Test
    public void testBuscarUnaRuta(){
    ruta ruta1 = new ruta();

    ruta1.setId_ruta(11L);
    ruta1.setId_envio(11L);
    ruta1.setOrigen("Santiago");
    ruta1.setDestino("San Jose de Maipo");
    ruta1.setDistancia_km(BigDecimal.valueOf(50.25));
    ruta1.setDuracion_estimada("1h");
    ruta1.setEstado("En camino");

    when(rutasrepository.findById(11L)).thenReturn(Optional.of(ruta1));

    ruta rutaBuscado = rutasservices.BuscarUnaRuta(11L);
    assertEquals(11L,rutaBuscado.getId_ruta());
    verify(rutasrepository, times(1)).findById(11L);

    }



    @Test
    public void testGuardarRuta(){
        ruta r = new ruta();

        r.setId_ruta(11L);
        r.setId_envio(11L);
        r.setOrigen("Santiago");
        r.setDestino("San Jose de Maipo");
        r.setDistancia_km(BigDecimal.valueOf(50.25));
        r.setDuracion_estimada("1h");
        r.setEstado("En camino");
        
        when(rutasrepository.save(any())).thenReturn(r);

        ruta rutaGuardados = rutasservices.GuardarRuta(r);
        assertEquals("En camino", rutaGuardados.getEstado());
        verify(rutasrepository, times(1)).save(r);

    }


/*

    @Test
    public void testEliminarEnvio(){
        Long id = 11L;
        doNothing().when(enviorepository).deleteById(id);

        enviosservices.Eliminar***(id);

        verify(enviosrepository.times(1)).deleteById(id);

    }
*/
}

