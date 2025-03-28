package sit.int204.sampleexception.dtos;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class SimpleEmployeeDto {
        private Integer employeeNumber;
        @JsonIgnore
        private String firstName;
        @JsonIgnore
        private String lastName;
        public String getName() {
            return firstName + ' '+ lastName;
        }
    }

