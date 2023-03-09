package com.hungpk.threekingdomtactic.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TargetTypeEnum implements CodeEnum {
	SELF("1","SELF", 1), ALLY("2", "ALLY", 2),
	ENEMY("3","ENEMY", 3);

	@JsonProperty("value")
	private final String value;
	@JsonProperty("label")
	private final String display;
	@JsonIgnore
	private final int sortOrder;

	TargetTypeEnum(String value, String display, int sortOrder) {
		this.value = value;
		this.display = display;
		this.sortOrder = sortOrder;
	}
	public static TargetTypeEnum of(String value) {
		return Arrays.stream(TargetTypeEnum.values()).filter(c -> value.equalsIgnoreCase(c.getValue())).findFirst()
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
	public static TargetTypeEnum ofElseThrow(Object value) {
		if (value instanceof Map) {
			Map<String, String> codeEnum = (Map<String, String>) value;
			return Arrays.stream(TargetTypeEnum.values())
					.filter(c -> {
						assert c.getValue() != null;
						return c.getValue().equalsIgnoreCase(codeEnum.get("value"));
					}).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of target type invalid!"));
		} else {
			return Arrays.stream(TargetTypeEnum.values()).filter(c -> {
				assert c.getValue() != null;
				return c.getValue().equalsIgnoreCase(value.toString());
			})
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of target type invalid!"));
		}
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getDisplay() {
		return this.display;
	}

	@Override
	public int getSortOrder() {
		return 0;
	}
}
