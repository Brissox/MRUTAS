package NSP_TECH.RUTAS.Assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import NSP_TECH.RUTAS.controller.rutaController;
import NSP_TECH.RUTAS.model.ruta;

@Component
public class rutaModelAssembler implements RepresentationModelAssembler<ruta, EntityModel<ruta>>{

    @Override
    public EntityModel<ruta> toModel(ruta r) {
        return EntityModel.of(
            r,
            linkTo(methodOn(rutaController.class).BuscarRuta(r.getId_ruta())).withRel("LINKS"),
            linkTo(methodOn(rutaController.class).ListarTodo()).withRel("todas-las-rutas")
        );
    }

}
