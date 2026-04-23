package com.erp.erp.ExceptionGeneralSistema;

/**
 *
 * @author piti_
 */
public class ExceptionGeneralSistema extends RuntimeException {

    public ExceptionGeneralSistema(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }

}
