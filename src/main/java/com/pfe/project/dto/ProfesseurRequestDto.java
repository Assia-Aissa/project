package com.pfe.project.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurRequestDto {





    @NotNull(message = "le nom est obligatoire")
<<<<<<< HEAD

=======
>>>>>>> 11e97d626cfca60cf634e02b5bd12e9ef5793e94
    private String nom;

    private String email;

    //@NotBlank
    private String password;

    @NotNull
    @Pattern(regexp="^(\\+212|0)([\\-_/]*)([\\d\\-_/]*){9}$", message = "format invalid")
    private String telephone;
}
