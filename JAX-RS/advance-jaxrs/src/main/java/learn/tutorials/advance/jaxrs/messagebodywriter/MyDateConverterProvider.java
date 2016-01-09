package learn.tutorials.advance.jaxrs.messagebodywriter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import learn.tutorials.advance.jaxrs.model.MyDate;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		if (rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar requestedDate = Calendar.getInstance();
					if("tommorow".equalsIgnoreCase(value))
						requestedDate.add(Calendar.DATE, 1);
					else if("today".equalsIgnoreCase(value))
						requestedDate.add(Calendar.DATE, 0);
					else if("yesterday".equalsIgnoreCase(value))
						requestedDate.add(Calendar.DATE, -1);
					
					MyDate date = new MyDate();
					date.setDate(requestedDate.get(Calendar.DATE));
					date.setMonth(requestedDate.get(Calendar.MONTH));
					date.setYear(requestedDate.get(Calendar.YEAR));
					
					return rawType.cast(date);
				}

				@Override
				public String toString(T value) {
					if(value == null)
						return null;
					else
						return value.toString();
				}

			};
		}
		return null;
	}

}
