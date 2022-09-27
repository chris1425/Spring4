package com.example.proyecto3.ControladoresFront;

import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyecto3.Modelo.Empresa;
import com.example.proyecto3.Modelo.Movimientos;
import com.example.proyecto3.Modelo.Usuarios;
import com.example.proyecto3.ServiciosFront.EmpresaServicioFront;
import com.example.proyecto3.ServiciosFront.MovimientosServicioFront;
import com.example.proyecto3.ServiciosFront.UsuarioServicioFront;

@Controller
public class ControladorFront {

    @Autowired
    private EmpresaServicioFront servicioFront;
    @Autowired
    private UsuarioServicioFront usuarioServicio;
    @Autowired
    MovimientosServicioFront servicios;

    public ControladorFront(EmpresaServicioFront servicioFront, UsuarioServicioFront usuarioServicio,
            MovimientosServicioFront servicios) {
        this.servicioFront = servicioFront;
        this.usuarioServicio = usuarioServicio;
        this.servicios = servicios;

    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {

            Usuarios usuario = this.usuarioServicio.getUsuario(principal.getClaims());
            model.addAttribute("usuario", usuario);
        }

        return "index";
    }

    @GetMapping("/entidad")
    public String entidades(Model model) {
        model.addAttribute("listaEmpresa", this.servicioFront.listaEmpresa());

        return "entidad";

    }

    @GetMapping("/entidad/agregar")
    public String agregar(Model model) {
        Empresa empresa = new Empresa();
        model.addAttribute("nuevaEmpresa", empresa);
        return "agregar";
    }

    @PostMapping("/entidad")
    public String guardarEmpresa(@ModelAttribute("nuevaEmpresa") Empresa empresa) {
        servicioFront.guardaEmpresa(empresa);
        return "redirect:/entidad";

    }

    @GetMapping("/entidad/editar/{id}")
    public String mostarEmpresa(@PathVariable Long id, Model model) {
        model.addAttribute("empresa", servicioFront.obtenerEmpresaId(id));
        return "editar";
    }

    @PostMapping("/entidad/editar/{id}")
    public String actualizarEmpresa(@PathVariable Long id, @ModelAttribute("empresa") Empresa empresa, Model model) {
        Empresa empresaExistente = servicioFront.obtenerEmpresaId(id);
        empresaExistente.setId(id);
        empresaExistente.setName(empresa.getName());
        empresaExistente.setDocument(empresa.getDocument());
        empresaExistente.setPhone(empresa.getPhone());
        empresaExistente.setAddress(empresa.getAddress());
        LocalDateTime fechaActual = LocalDateTime.now();
        empresaExistente.setUpdateAt(fechaActual.toLocalDate());

        servicioFront.actualizarEmpresa(empresaExistente);
        return "redirect:/entidad";
    }

    @GetMapping("/entidad/{id}")
    public String eliminarEmpresa(@PathVariable Long id) {

        servicioFront.eliminarEmpresa(id);
        return "redirect:/entidad";

    }

    @GetMapping("/movimiento/agregar")
    public String nuevoMovi(Model model) {
        Movimientos movimiento = new Movimientos();
        model.addAttribute("movimiento", movimiento);
        return "addmovimiento";
    }

    @PostMapping("/movimientos")
    public String guardarMovimiento(@ModelAttribute("movimiento") Movimientos movimientos) {
        this.servicios.guardaMovimientos(movimientos);
        return "redirect:/entidad";

    }

    @GetMapping("/movimiento/{id}")
    public String eliminarMovimiento(@PathVariable Long id) {
        this.servicios.eliminarMovimientos(id);
        return "redirect:/entidad";

    }

    @GetMapping("/movimientos")
    public String listar(Model model) {
        model.addAttribute("listarMov", this.servicios.listaMovimientos());
        model.addAttribute("cantidadMovimientos", this.servicios.listaMovimientos().size());
        System.out.println("hola" + servicios.listaMovimientos());
        
        return "movimientos";
    }

}
