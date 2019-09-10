package com.wz.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 自定义的时间格式校验器，可以放到方法参数，或者成员变量中
 */
public class DateTimeValidate implements ConstraintValidator<DateTime,String>{

    private DateTime dateTime;

    @Override
    public void initialize(DateTime constraintAnnotation) {
        this.dateTime = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }
        String format = dateTime.format();
        if(value.length() != format.length()) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
             simpleDateFormat.parse(value);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
