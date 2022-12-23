package org.cs202.entity.dto.converter;

import org.cs202.entity.concretes.RoomType;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeConverter {

    public RoomType convert(String roomType){

        if (roomType.equalsIgnoreCase("ONE BED")){
            return RoomType.ONE_BED;
        } else if (roomType.equalsIgnoreCase("TWO BED")) {
            return RoomType.TWO_BED;
        } else if (roomType.equalsIgnoreCase("FAMILY SIZED")) {
            return RoomType.FAMILY_SIZED;
        }else {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
