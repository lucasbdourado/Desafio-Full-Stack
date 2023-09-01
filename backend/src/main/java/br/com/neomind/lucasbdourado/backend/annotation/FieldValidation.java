package br.com.neomind.lucasbdourado.backend.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FieldValidation {

    String value();
}
