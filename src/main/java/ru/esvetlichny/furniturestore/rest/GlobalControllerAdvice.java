package ru.esvetlichny.furniturestore.rest;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.esvetlichny.furniturestore.exception.EntityNotExistsException;
import ru.esvetlichny.furniturestore.exception.RelationNotExistsException;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyReferenceException.class)
    public HashMap<String, String> queryParamExceptionHandler(PropertyReferenceException e) {
        return body("Введены некорректные параметры запроса HTTP", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> entityExceptionHandler(EntityNotExistsException e) {
        return body(e.getMessage(), null);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> relationExceptionHandler(RelationNotExistsException e) {
        return body(e.getMessage(), null);
    }

    private static HashMap<String, String> body(@NonNull String message, @Nullable String details) {
        return new HashMap<String, String>() {{
            put("message", message);
            if (details != null) {
                put("details", details);
            }
        }};
    }

}
