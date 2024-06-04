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




<<<<<<< HEAD
    @NotNull(message = "le nom est obligatoire")
=======
>>>>>>> c2f3445d0fd1a9f58c09faae1812c97b825b2596
    private String nom;

    private String email;

    //@NotBlank
    private String password;

  //  @NotNull
   // @Pattern(regexp="^(\\+212|0)([\\-_/]*)([\\d\\-_/]*){9}$", message = "format invalid")
    private String telephone;
}
