package vn.shippo.demomywork.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.shippo.demomywork.model.User;
import vn.shippo.demomywork.service.UserService;

public class UserValidator implements Validator{


    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    private UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String email = user.getEmail();
        String name = user.getName();
        String password = user.getPassword();

        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");

        if(userService.existEmail(email)) {
            errors.rejectValue("email", "email.exists" );
        }

//        if(email.matches(EMAIL_REGEX)){
//            errors.rejectValue("email", "email.error" );
//        }

        if (password.length() < 5 || password.length() > 20){
            errors.rejectValue("password", "password.length");
        }
    }
}

