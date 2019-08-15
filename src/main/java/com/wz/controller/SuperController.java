package com.wz.controller;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SuperController {


    /**
     * 得到默认的校验工厂
     * @return
     */
    public  ValidatorFactory getValidatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }

    /**
     * 得到校验器
     * @return
     */
    public  Validator  getValidator() {
        return getValidatorFactory().getValidator();
    }

    /**
     * 校验参数的逻辑提取到父类中
     * @param t
     * @param <T>
     * @return
     */
    public  <T> Set<ConstraintViolation<T>> validate(T t) {
        return getValidator().validate(t);
    }
}
