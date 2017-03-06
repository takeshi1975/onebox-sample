package es.onebox.rest.utils.validators;

import es.onebox.rest.utils.model.AuthenticationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ParameterNameProvider;
import javax.validation.executable.ExecutableValidator;

/**
 * Validates the autenticatio form.
 *
 * @author Oreste Luci
 */
@Component
public class AutenticationFormValidator extends LocalValidatorFactoryBean {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AuthenticationForm.class);
    }

    @Override
    public void validate(Object target, Errors errors, final Object... validationHints) {

        super.validate(target, errors, validationHints);

        // Custom validation if no errors found
        if (!errors.hasErrors()) {

            AuthenticationForm authenticationForm = (AuthenticationForm)target;

            try {
                int channel = Integer.parseInt(authenticationForm.getChannelId());
            } catch (Exception e) {
                errors.rejectValue("channelId","error.validation.not_number");
            }

            try {
                int pos = Integer.parseInt(authenticationForm.getPos());
            } catch (Exception e) {
                errors.rejectValue("pos","error.validation.not_number");
            }

        }
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }

    @Override
    public ParameterNameProvider getParameterNameProvider() {
        return null;
    }
}
