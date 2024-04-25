package com.pfe.project.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class ErrorMessage {
    
    String message;
    Date timestamp;
    Integer code ;

}
