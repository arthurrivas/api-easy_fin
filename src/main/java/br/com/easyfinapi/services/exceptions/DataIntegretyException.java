package br.com.easyfinapi.services.exceptions;

public class DataIntegretyException extends RuntimeException {

    public DataIntegretyException(String msg) {
        super(msg);
    }

    public DataIntegretyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
