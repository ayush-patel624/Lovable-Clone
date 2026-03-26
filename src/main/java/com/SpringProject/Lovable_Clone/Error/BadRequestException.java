package com.SpringProject.Lovable_Clone.Error;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
@Getter
public class BadRequestException extends RuntimeException {
    String message;
}
