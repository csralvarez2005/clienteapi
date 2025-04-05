package clienteapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @Past(message = "La fecha debe ser en el pasado")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @Email(message = "Email inválido") @NotBlank(message = "El email es obligatorio") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email inválido") @NotBlank(message = "El email es obligatorio") String email) {
        this.email = email;
    }

    public @NotBlank(message = "La dirección es obligatoria") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotBlank(message = "La dirección es obligatoria") String direccion) {
        this.direccion = direccion;
    }

    public @Past(message = "La fecha debe ser en el pasado") @NotNull(message = "La fecha de nacimiento es obligatoria") LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(@Past(message = "La fecha debe ser en el pasado") @NotNull(message = "La fecha de nacimiento es obligatoria") LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
