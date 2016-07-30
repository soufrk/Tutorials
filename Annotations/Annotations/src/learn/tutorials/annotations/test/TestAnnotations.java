package learn.tutorials.annotations.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import learn.tutorials.annotations.ClassAnnotation;
import learn.tutorials.annotations.CustomAnnotatedClass;
import learn.tutorials.annotations.MethodAnnotation;

/**
 * Use Reflection API to process the custom annotation
 * 
 * @author KD
 *
 */
public class TestAnnotations {

	public static void main(String[] args) {
		System.out.println("Testing ...");

		int passed = 0, failed = 0, count = 0, ignore = 0;

		Class<CustomAnnotatedClass> obj = CustomAnnotatedClass.class;

		// Process @ClassAnnotation
		// Check for the presence of the custom annotation on the class
		if (obj.isAnnotationPresent(ClassAnnotation.class)) {
			// Get the instance of annotation using reflection APIs
			Annotation annotation = obj.getAnnotation(ClassAnnotation.class);
			ClassAnnotation classAnnotation = (ClassAnnotation) annotation;
			// Access all the properties of the annotation
			System.out.println("Priority is : " + classAnnotation.priority());
			System.out.println("Created by : " + classAnnotation.createdBy());
			System.out.println("Tags : " + Arrays.toString(classAnnotation.tags()));
			System.out.println("LastModified : " + classAnnotation.lastModified());
		}

		// Process @MethodAnnotation
		for (Method method : obj.getDeclaredMethods()) {
			// if method is annotated with @MethodAnnotation
			if (method.isAnnotationPresent(MethodAnnotation.class)) {
				Annotation annotation = method.getAnnotation(MethodAnnotation.class);
				MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;

				// if enabled = true (default)
				if (methodAnnotation.enabled()) {
					try {
						method.invoke(obj.newInstance());
						System.out.printf("%s - Test '%s' -- passed %n", ++count, method.getName());
						passed++;
					} catch (Exception ex) {
						System.out.printf("%s - Test '%s' - failed %s %n", ++count, method.getName(), ex.getCause());
						failed++;
					}
				} else {
					System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
					ignore++;
				}
			}
		}
		System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);
	}
}
