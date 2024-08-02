package com.inditex.products.infraestructure.database.springdata.dto;

public enum ErrorEnum {
    OK("COMMON001", "OK"),
    NOT_FOUND_PRODUCT_EXCEPTION("NOTFOUND001", "Product not found"),
    ERROR("ERROR001", "ERROR");
    private String code;

    private String message;

    ErrorEnum(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public static ErrorEnum fromValue(String text) {
        for (ErrorEnum b : ErrorEnum.values()) {
            if (String.valueOf(b.code).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(message);
    }
    }