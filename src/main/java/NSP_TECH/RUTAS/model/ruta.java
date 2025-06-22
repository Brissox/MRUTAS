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
    @Schema(description="aa")
    private Long id_ruta;

    @Column(name="ID_ENVIO",nullable=false ,precision=10)
    @Schema(description="aa")
    private Long id_envio;

    @Column(name="ORIGEN",nullable = false,length = 100)
    @Schema(description="aa")
    private String origen;
    
    @Column(name="DESTINO",nullable = false,length = 100)
    @Schema(description="aa")
    private String destino;
    
    @Column(name="DISTANCIA_KM",nullable = true, precision=10, scale= 2)
    @Schema(description="aa")
    private BigDecimal distancia_km;

    @Column(name="DURACION_ESTIMADA",nullable = false,length = 20)
    @Schema(description="aa")
    private String duracion_estimada;
    
    @Column(name="ESTADO",nullable = false,length = 20)
    @Schema(description="aa")
    private String estado;

}
