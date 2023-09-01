package br.com.neomind.lucasbdourado.backend.validation;

import br.com.neomind.lucasbdourado.backend.annotation.FieldValidation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class FieldsValidator <T> {
    public Boolean validateFields(T entity) throws Exception{

        Field[] fields = entity.getClass().getDeclaredFields();

        Boolean validation = null;

        for(Field field : fields){

            if (field.isAnnotationPresent(FieldValidation.class)){

                FieldValidation fieldAnnotation = field.getAnnotation(FieldValidation.class);

                String methodName = fieldAnnotation.value();

                try{

                    Method method = entity.getClass().getMethod(methodName);

                    validation = (Boolean) method.invoke(entity);
                } catch (Exception e) {

                    throw new Exception(e.getMessage());
                }
            }
        }

        if (validation == null){
            throw new Exception("Método de validação da classe: "+ entity.getClass() + " não encontrada");
        }

        return validation;
    }
}
