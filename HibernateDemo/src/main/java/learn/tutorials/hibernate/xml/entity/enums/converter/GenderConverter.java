package learn.tutorials.hibernate.xml.entity.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import learn.tutorials.hibernate.xml.entity.enums.Gender;

@Converter
public class GenderConverter implements AttributeConverter<Gender, Character> {

	public Character convertToDatabaseColumn(Gender value) {
		if (value == null) {
			return null;
		}
		return value.getCode();
	}

	public Gender convertToEntityAttribute(Character value) {
		if (value == null) {
			return null;
		}
		return Gender.fromCode(value);
	}
}
