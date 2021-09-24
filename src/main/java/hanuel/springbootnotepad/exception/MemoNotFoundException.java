package hanuel.springbootnotepad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemoNotFoundException extends RuntimeException{
    public static final String MEMO_NOT_FOUND_MESSAGE = "존재하지 않는 메모입니다.";
    public MemoNotFoundException() {
        super(MEMO_NOT_FOUND_MESSAGE);
    }
}
