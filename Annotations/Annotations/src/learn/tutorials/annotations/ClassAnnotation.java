package learn.tutorials.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAnnotation {
	
	public enum Priority {
		LOW, MEDIUM, HIGH;
	}

	Priority priority() default Priority.MEDIUM;

	String[] tags() default "";

	String createdBy() default "KD";

	String lastModified() default "30-07-2016";
}
