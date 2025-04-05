package clienteapi.service;

import clienteapi.dto.ClienteDTO;
import clienteapi.entity.Cliente;
import clienteapi.exception.RecursoNoEncontradoException;
import clienteapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO guardar(ClienteDTO dto) {
        Cliente cliente = dtoToEntity(dto);
        return entityToDto(clienteRepository.save(cliente));
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id " + id));
        return entityToDto(cliente);
    }

    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con id " + id));
        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente.setDireccion(dto.getDireccion());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        return entityToDto(clienteRepository.save(cliente));
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente dtoToEntity(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setId(dto.getId());
        c.setNombre(dto.getNombre());
        c.setEmail(dto.getEmail());
        c.setDireccion(dto.getDireccion());
        c.setFechaNacimiento(dto.getFechaNacimiento());
        return c;
    }

    private ClienteDTO entityToDto(Cliente c) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setEmail(c.getEmail());
        dto.setDireccion(c.getDireccion());
        dto.setFechaNacimiento(c.getFechaNacimiento());
        return dto;
    }
}
