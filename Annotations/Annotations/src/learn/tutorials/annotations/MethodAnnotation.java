package learn.tutorials.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target annotation specifies the level at which you can use this annotation.
@Target(ElementType.METHOD)
// @Retention annotation indicates how long annotations with the annotated type
// are to be retained. If no Retention annotation is present on an annotation
// type declaration, the retention policy defaults to RetentionPolicy.CLASS.
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
	public boolean enabled() default true;
}