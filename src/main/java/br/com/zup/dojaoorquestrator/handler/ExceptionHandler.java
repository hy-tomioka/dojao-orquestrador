package br.com.zup.dojaoorquestrator.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    private List<ErroDeRequestDTO> handle(MethodArgumentNotValidException exception) {
        List<ErroDeRequestDTO> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String menssagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeRequestDTO erro = new ErroDeRequestDTO(e.getField(), menssagem);
            dto.add(erro);
        });

        return dto;
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityException.class)
    private ErroDeRequestDTO handle(EntityException exception) {

        return new ErroDeRequestDTO(exception.getAttribute(), exception.getErro());
    }
}
