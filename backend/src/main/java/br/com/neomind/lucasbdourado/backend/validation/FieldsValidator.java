package br.com.neomind.lucasbdourado.backend.validation;

import br.com.neomind.lucasbdourado.backend.annotation.FieldValidation;
import br.com.neomind.lucasbdourado.backend.exception.ValidationException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class FieldsValidator <T> {
    public Boolean validateFields(T entity) throws ValidationException {

        Field[] fields = entity.getClass().getDeclaredFields();

        Boolean validation = null;

        for(Field field : fields){

            if (field.isAnnotationPresent(FieldValidation.class)){

                FieldValidation fieldAnnotation = field.getAnnotation(FieldValidation.class);

                String methodName = fieldAnnotation.value();

                try{

                    Method method = entity.getClass().getMethod(methodName);

                    validation = (Boolean) method.invoke(entity);
                } catch (InvocationTargetException e) {
                    throw new ValidationException(e.getCause().getMessage());
                } catch (NoSuchMethodException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (validation == null){
            throw new ValidationException("Método de validação da classe: "+ entity.getClass() + " não encontrada");
        }

        return validation;
    }
}
