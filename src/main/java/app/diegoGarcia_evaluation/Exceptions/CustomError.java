package app.diegoGarcia_evaluation.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private int HttpCode;
    private String mensaje;

}
