package NSP_TECH.RUTAS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import NSP_TECH.RUTAS.Assembler.rutaModelAssembler;
import NSP_TECH.RUTAS.model.ruta;
import NSP_TECH.RUTAS.services.rutaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/Rutas")

public class rutaController {

    @Autowired
    private rutaServices rutaservices;

    @Autowired
    private rutaModelAssembler assembler;
    
       // ENDPOINT PARA BUSCAR TODAS LAS RUTAS
    @GetMapping

    @Operation(summary = "RUTAS", description = "Operacion que lista todas las rutas")
    @ApiResponses (value = {
        @ApiResponse(responseCode = "200", description = "Se listaron correctamente las rutas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ruta.class))),
        @ApiResponse(responseCode = "404", description = "No se encontro ninguna ruta", content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "No se encuentran Datos")))


    })

    public ResponseEntity<?> ListarTodo(){
        List<ruta> ruta = rutaservices.BuscarTodoRutas();
        if (ruta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran dato");
        } else {
            return ResponseEntity.ok(assembler.toCollectionModel(ruta));
        }
    }

    // ENDPOINT PARA BUSCAR UNA RUTA
    @GetMapping("/{ID_RUTA}")

    @Operation(summary = "RUTA", description = "Operacion que lista una ruta")
    @Parameters (value = {
        @Parameter (name="ID_RUTA", description= "ID de la ruta que se buscara", in = ParameterIn.PATH, required= true)

    })

    @ApiResponses (value = {
        @ApiResponse(responseCode = "200", description = "Se lista correctamente la ruta ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ruta.class))),
        @ApiResponse(responseCode = "404", description = "No se encontro ninguna ruta", content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "No se encuentran Datos")))
    })

    public ResponseEntity<?> BuscarRuta(@PathVariable Long ID_RUTA){

        try {
            ruta rutaBuscada = rutaservices.BuscarUnaRuta(ID_RUTA);
            return ResponseEntity.ok(assembler.toModel(rutaBuscada));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra el reporte");
        }
    }

// ENDPOINT PARA REGISTRAR UNA RUTA
    @PostMapping
    @Operation(summary = "ENDPOINT QUE REGISTRA UNA RUTA", description = "ENDPOINT QUE REGISTRA UNA RUTA",requestBody= @io.swagger.v3.oas.annotations.parameters.RequestBody(description="REPORTE QUE SE VA A REGISTRAR", required = true, content = @Content(schema = @Schema(implementation = ruta.class))))
    @ApiResponses (value = {
        @ApiResponse(responseCode = "200", description = "Se registro correctamente la ruta", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ruta.class))),
        @ApiResponse(responseCode = "500", description = "Indica que no se logro registrar la ruta", content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "No se puede registrar la ruta ")))
    })

    public ResponseEntity<?> GuardarRuta(@RequestBody ruta rutaGuardar){
    try {
            ruta rutaRegistrar = rutaservices.GuardarRuta(rutaGuardar);
            return ResponseEntity.ok(assembler.toModel(rutaGuardar));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede registrar la ruta");
    }
    }


}
