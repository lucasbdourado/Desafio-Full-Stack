package br.com.neomind.lucasbdourado.backend.exception;

public class ValidationException extends Exception{
    private static final long serialVersionUID = -7509649433607067138L;

    public ValidationException(String msg) {
        super(msg);
    }
}
