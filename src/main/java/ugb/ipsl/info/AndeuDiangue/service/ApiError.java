package ugb.ipsl.info.AndeuDiangue.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Getter
public class ApiError extends Exception {

    private final int code;
    private final String msg;

    public ResponseEntity getResponse(){
        return ResponseEntity.status(code).body(msg);
    }
}
