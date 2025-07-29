// ProductNotFoundException.java
package com.systemzarzadzaniaapteka.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
