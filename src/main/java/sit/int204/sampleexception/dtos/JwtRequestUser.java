package sit.int204.sampleexception.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
    public class JwtRequestUser {
        private String username;
        @Size(min = 8)
        @NotBlank
        private String password;
    }

