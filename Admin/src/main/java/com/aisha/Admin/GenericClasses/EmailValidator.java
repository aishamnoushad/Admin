package com.aisha.Admin.GenericClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aisha.Admin.Controllers.UserController;





public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private Pattern pattern;
    private Matcher theMatcher;
    private final static String EMAIL_PATTERN =  "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        pattern = Pattern.compile(EMAIL_PATTERN);
        log.info("the imail validation pattern " + pattern);
        if (email == null) {
            return false;
        }
        theMatcher = pattern.matcher(email);
        log.info("the imail validation: " + theMatcher.matches());
        return theMatcher.matches();


    }
}