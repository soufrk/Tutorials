package learn.tutorials.chainofresposibilitypattern;

public class AnnotationParser {

	public <T> T parse(Class<T> clazz) throws Exception {
		if (clazz.isAnnotationPresent(JobType.class)) {
			return clazz.newInstance();
		}
		return null;
	}
}
