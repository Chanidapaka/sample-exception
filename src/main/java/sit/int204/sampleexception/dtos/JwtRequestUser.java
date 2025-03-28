package sit.int204.sampleexception.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
//class 4
@Data
    public class JwtRequestUser {
        private String username;
        @Size(min = 8)
        @NotBlank
        private String password;
    }

