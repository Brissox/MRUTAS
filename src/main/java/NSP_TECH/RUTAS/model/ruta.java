package NSP_TECH.RUTAS.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="rutas")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description="Todas las rutas registradas")



public class ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RUTA")
    @Schema(description="identificador de la ruta", example="1")
    private Long id_ruta;

    @Column(name="ID_ENVIO",nullable=false ,precision=10)
    @Schema(description="identificador del envio", example="1")
    private Long id_envio;

    @Column(name="ORIGEN",nullable = false,length = 100)
    @Schema(description="Ubicacion desde donde parte el envio", example="sucursal santiago")
    private String origen;
    
    @Column(name="DESTINO",nullable = false,length = 100)
    @Schema(description="ubicacion de termino del envio", example="siempre viva 123, la florida")
    private String destino;
    
    @Column(name="DISTANCIA_KM",nullable = true, precision=10, scale= 2)
    @Schema(description="distancia del recorrido en kilometros", example="50.52")
    private BigDecimal distancia_km;

    @Column(name="DURACION_ESTIMADA",nullable = false,length = 20)
    @Schema(description="tiempo de demora del envio", example="2horas")
    private String duracion_estimada;
    
    @Column(name="ESTADO",nullable = false,length = 20)
    @Schema(description="Estadp en el cual se encuentra el envio", example="en ruta/en preparacion/entregado")
    private String estado;

}
