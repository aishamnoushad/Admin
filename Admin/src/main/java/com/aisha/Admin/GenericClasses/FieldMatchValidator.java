package com.aisha.Admin.GenericClasses;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;

import com.aisha.Admin.Controllers.UserController;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
        
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        boolean valid = true;
        try{

              Object firstObj = new BeanWrapperImpl(o).getPropertyValue(firstFieldName);
              Object secondObj = new BeanWrapperImpl(o).getPropertyValue(secondFieldName);
              log.info("Password Field " + firstObj);
              log.info("matching Password Field " + secondObj);
              valid = firstObj == null && secondObj == null || firstObj != null && secondObj.equals(firstObj);
              log.info("output of is valid function " + valid);
        }
        catch (Exception ignore){

        }

        if(!valid){
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        log.info("output of is valid function " + valid);
        return valid;
    }
}
