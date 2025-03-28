package sit.int204.sampleexception.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import sit.int204.sampleexception.exceptions.ItemNotFoundException;
import sit.int204.sampleexception.exceptions.MyErrorResponse;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(IllegalAccessError.class)
    public ResponseEntity<MyErrorResponse> handleIllegalAccessException(
            IllegalArgumentException ex, HttpServletRequest request
    ){
        MyErrorResponse myErrorResponse = new MyErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(myErrorResponse);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<MyErrorResponse> handleItemNotFoundException(
            ItemNotFoundException ex, HttpServletRequest request
    ){
        MyErrorResponse myErrorResponse = new MyErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(myErrorResponse);
    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<MyErrorResponse> handleException(Exception ex, HttpServletRequest request){
//        MyErrorResponse myErrorResponse = new MyErrorResponse(
//                HttpStatus.INTERNAL_SERVER_ERROR.value()
//                ,"Something Wrong, Please contact back-end support"
//                ,request.getRequestURI()
//        );
//        myErrorResponse.setStackTrace(ex.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(myErrorResponse);
//    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<MyErrorResponse> handleHandlerMethodValidationException(
            HandlerMethodValidationException exception, HttpServletRequest request) {
        MyErrorResponse errorResponse = new MyErrorResponse(
                HttpStatus.BAD_REQUEST.value()
                , "Validation error. Check 'errors' field for details."
                , request.getRequestURI());
        List<ParameterValidationResult> paramNames = exception.getParameterValidationResults();
        for (ParameterValidationResult param : paramNames) {
            errorResponse.addValidationError(
                    param.getMethodParameter().getParameterName()
                    , param.getResolvableErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
