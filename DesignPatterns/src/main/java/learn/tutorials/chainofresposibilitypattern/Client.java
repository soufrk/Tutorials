package learn.tutorials.chainofresposibilitypattern;

import java.lang.annotation.Annotation;
import java.util.Set;

import org.reflections.Reflections;

public class Client {

	public static void main(String[] args) throws Exception {
		JobHandlerType jobHandlerType = JobHandlerType.TYPE2;
		AbstractHandler handler = null;

		// Get the instance of a class based on its job-type
		Reflections reflections = new Reflections(Client.class.getPackage().getName());
		Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(JobType.class);
		for (Class<?> clazz : classSet) {
			Annotation annotation = clazz.getAnnotation(JobType.class);
			JobType jobType = (JobType) annotation;
			if (jobType.jobHandlerType() == jobHandlerType) {
				handler = (AbstractHandler) new AnnotationParsing().parse(clazz);
			}
		}
		handler.handleRequest();
	}

}
