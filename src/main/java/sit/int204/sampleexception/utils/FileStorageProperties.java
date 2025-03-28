package sit.int204.sampleexception.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

// คือการบอกให้ Spring นำค่าในไฟล์คอนฟิกที่มี prefix file มาเก็บในคลาสนี้
@ConfigurationProperties(prefix = "file")
@Getter //สร้าง เมธอด getter ให้อัตโนมัติ
@Setter //สร้าง เมธอด  setter ให้อัตโนมัติ
public class FileStorageProperties {
    private String uploadDir; //ใช้เก็บที่อยู่ของไดเรกทอรีในการอัปโหลดไฟล์
    private String[] supportFileTypes; //ใช้เก็บชนิดของไฟล์ที่รองรับ
}


