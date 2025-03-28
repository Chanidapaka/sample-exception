package sit.int204.sampleexception.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//class 4 และ 5
// PageDto ต้องมี  ListMapper
@Getter
@Setter
public class PageDto<T> {
    @Schema(description = "List of content")
    private List<T> content;
    private Boolean last;
    private Boolean first;
    @Schema(description = "Total number of pages")
    private Integer totalPages;
    private Integer size;
    @JsonIgnore
    private Integer number;

    public Integer getPageNumber() {
        return number;
    }
}
