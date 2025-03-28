package sit.int204.sampleexception.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import sit.int204.sampleexception.dtos.PageDto;

import java.util.List;

//ListMapper ต้องมี PageDto
public class ListMapper {
    private static final ListMapper listMapper = new ListMapper();

    private ListMapper() {
    }

    //แปลง List<S> เป็น List<T> โดยใช้ ModelMapper
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).toList();
    }

    //ใช้เพื่อคืนค่าตัวเดียว (Singleton) ของคลาส ListMapper ที่ถูกสร้างไว้แล้วในโปรแกรม.
    public static ListMapper getInstance() {
        return listMapper;
    }

    //แปลง Page<S> เป็น PageDto<T> โดยแปลงแต่ละรายการใน content ของ Page เป็น DTO
    public <S, T> PageDto<T> toPageDTO(Page<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        PageDto<T> page = modelMapper.map(source, PageDto.class);
        page.setContent(mapList(source.getContent(), targetClass, modelMapper));
        return page;
    }
}
