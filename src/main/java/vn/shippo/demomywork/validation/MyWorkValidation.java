package vn.shippo.demomywork.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.shippo.demomywork.model.MyWork;
import vn.shippo.demomywork.service.MyWorkService;

@Component
public class MyWorkValidation implements Validator {

    private MyWorkService myWorkService;

    @Autowired
    public MyWorkValidation(MyWorkService myWorkService){
        this.myWorkService = myWorkService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MyWorkValidation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        MyWork myWork = (MyWork) target;

        String name = myWork.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");

        if (myWorkService.existName(name)) {
            errors.rejectValue("name", "name.exists");
        }

    }
}
