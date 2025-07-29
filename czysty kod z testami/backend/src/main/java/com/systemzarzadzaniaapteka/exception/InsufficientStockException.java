// InsufficientStockException.java
package com.systemzarzadzaniaapteka.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
