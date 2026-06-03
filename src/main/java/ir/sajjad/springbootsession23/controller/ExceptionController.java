package ir.sajjad.springbootsession23.controller;

import ir.sajjad.springbootsession23.dto.response.ExceptionResponse;
import ir.sajjad.springbootsession23.exception.MyRuleException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ExceptionController {
    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(MyRuleException.class)
    public ResponseEntity<List<ExceptionResponse>> handleMyRuleException(MyRuleException myRuleException){
        return ResponseEntity.status(400).body(Collections.singletonList(mapMyRuleExceptionToExceptionResponse(myRuleException)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.status(400).body(mapMethodArgumentNotValidExceptionToExceptionResponse(methodArgumentNotValidException));
    }

    private ExceptionResponse mapMyRuleExceptionToExceptionResponse(MyRuleException myRuleException){
        return ExceptionResponse.builder().massage(messageSourceAccessor.getMessage(myRuleException.getMessage()))
                .code(myRuleException.getMessage())
                .build();
    }

    private List<ExceptionResponse> mapMethodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException){
       return  methodArgumentNotValidException.getFieldErrors()
                .stream().map(error ->
                        ExceptionResponse.builder()
                                .massage(error.getDefaultMessage())
                                .code(error.getCode())
                                .build()
                ).toList();
    }

}
