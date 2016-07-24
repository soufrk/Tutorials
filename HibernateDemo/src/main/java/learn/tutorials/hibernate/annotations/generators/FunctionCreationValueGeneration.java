package learn.tutorials.hibernate.annotations.generators;

import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

import learn.tutorials.hibernate.annotations.FunctionalCreationTimestamp;

public class FunctionCreationValueGeneration implements AnnotationValueGeneration<FunctionalCreationTimestamp> {

	private static final long serialVersionUID = 1L;

	@Override
	public GenerationTiming getGenerationTiming() {
		// will generate new value at the time of insert only
		return GenerationTiming.INSERT;
	}

	@Override
	public ValueGenerator<?> getValueGenerator() {
		// return null because value is generated by database itself
		return null;
	}

	@Override
	public boolean referenceColumnInSql() {
		return true;
	}

	@Override
	public String getDatabaseGeneratedReferencedColumnValue() {
		return "current_timestamp";
	}

	@Override
	public void initialize(FunctionalCreationTimestamp annotation, Class<?> propertyType) {
	}
}
