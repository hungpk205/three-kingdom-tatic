package com.hungpk.threekingdomtactic.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum QualityEnum implements CodeEnum {
	S("1", "S", 1), A("2", "A", 2), B("3", "B", 3), C("4", "C", 4);

	@JsonProperty("value")
	private final String value;
	@JsonProperty("label")
	private final String display;
	@JsonIgnore
	private final int sortOrder;

	QualityEnum(String value, String display, int sortOrder) {
		this.value = value;
		this.display = display;
		this.sortOrder = sortOrder;
	}
	public static QualityEnum of(String value) {
		return Arrays.stream(QualityEnum.values()).filter(c -> value.equalsIgnoreCase(c.getValue())).findFirst()
				.orElse(null);
	}

	/**
	 * Create enum by value
	 *
	 * @param value Object value
	 * @return Enum or null
	 */
	@SuppressWarnings("unchecked")
	@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
	public static QualityEnum ofElseThrow(Object value) {
		if (value instanceof Map) {
			Map<String, String> codeEnum = (Map<String, String>) value;
			return Arrays.stream(QualityEnum.values())
					.filter(c -> {
						assert c.getValue() != null;
						return c.getValue().equalsIgnoreCase(codeEnum.get("value"));
					}).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of site type invalid!"));
		} else {
			return Arrays.stream(QualityEnum.values()).filter(c -> {
				assert c.getValue() != null;
				return c.getValue().equalsIgnoreCase(value.toString());
			})
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of site type invalid!"));
		}
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String getDisplay() {
		return null;
	}

	@Override
	public int getSortOrder() {
		return 0;
	}
}
