package sit.int204.sampleexception.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

//class 4
@Data //รวม getter setter and to string ไว้ข้างใน
public class SampleData {
//    ห้ามเป็น null และตัวเลข น้อยสุด อยู่ที่ 10001 และมากสุดที่ 99999
    @NotNull  //ฟิวด์ที่จำเป็นต้องมี
    @Min(10001)
    @Max(99999)
    private Integer id;

//    ห้าามใส้ค่าว่างและความยาวไม่เกิน 10
    @NotBlank
    @Size(max = 10)
    private String name;

    @Email
    private String email;

    @Past
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    public void setName(String name){
        this.name = name==null?name:name.trim();
    }

}
