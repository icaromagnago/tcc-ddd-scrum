package br.icc.ddd.scrum.domain;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

/**
 * Annotation para validação de Email.
 *
 */
@Documented
@Retention(RUNTIME)
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Target({ FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
public @interface Email {
	String message() default "Email com formato inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
