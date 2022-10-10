package controller;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Joe Shilkaitis - jshilkaitis
 * CIS175 - Fall 2022
 * Oct 8, 2022
 */
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {
	@Override
	public Time convertToDatabaseColumn(LocalTime attribute) {
		// TODO Auto-generated method stub
		return (attribute == null ? null : Time.valueOf(attribute));
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbData) {
		// TODO Auto-generated method stub
		return (dbData == null ? null : dbData.toLocalTime());
	}
}

	

