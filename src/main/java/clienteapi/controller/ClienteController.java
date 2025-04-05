package clienteapi.controller;

import clienteapi.dto.ClienteDTO;
import clienteapi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDTO guardar(@Valid @RequestBody ClienteDTO dto) {
        return clienteService.guardar(dto);
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscar(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
        return clienteService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}
