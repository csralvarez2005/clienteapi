package clienteapi.service;

import clienteapi.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO guardar(ClienteDTO clienteDTO);
    List<ClienteDTO> listar();
    ClienteDTO buscarPorId(Long id);
    ClienteDTO actualizar(Long id, ClienteDTO clienteDTO);
    void eliminar(Long id);
}
