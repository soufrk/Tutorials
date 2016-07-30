package learn.tutorials.chainofresposibilitypattern;

/**
 * Annotation Parser that provides different methods to for the use of custom
 * annotations.
 * 
 * @author KD
 *
 */
public class AnnotationParser {

	/**
	 * If class passed as argument to the Class parameter is annotated
	 * with @JobType return the instance of that class.
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T> T parse(Class<T> clazz) throws Exception {
		if (clazz.isAnnotationPresent(JobType.class)) {
			return clazz.newInstance();
		}
		return null;
	}
}
