package learn.tutorials.annotations;

import learn.tutorials.annotations.ClassAnnotation.Priority;

@ClassAnnotation(priority = Priority.HIGH, createdBy = "Saurabh", tags = { "custom annotation", "learning",
		"first example" })
public class CustomAnnotatedClass {

	@MethodAnnotation
	public void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@MethodAnnotation(enabled = false)
	public void testB() {
		if (false)
			throw new RuntimeException("This test alaways passed");
	}

	@MethodAnnotation(enabled = true)
	public void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}
}
