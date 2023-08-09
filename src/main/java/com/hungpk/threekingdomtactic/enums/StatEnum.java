package com.hungpk.threekingdomtactic.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatEnum implements CodeEnum {
	STR("STR","Strength", 1),
	DEF("DEF", "Defence", 2),
	INT("INT","Intelligence", 3),
	SPD("SPD","Speed", 4),
	POL("POL","Politics", 5),
	CHA("CHA","Charisma", 6);

	@JsonProperty("value")
	private final String value;
	@JsonProperty("label")
	private final String display;
	@JsonIgnore
	private final int sortOrder;

	StatEnum(String value, String display, int sortOrder) {
		this.value = value;
		this.display = display;
		this.sortOrder = sortOrder;
	}
	public static StatEnum of(String value) {
		return Arrays.stream(StatEnum.values()).filter(c -> value.equalsIgnoreCase(c.getValue())).findFirst()
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
	public static StatEnum ofElseThrow(Object value) {
		if (value instanceof Map) {
			Map<String, String> codeEnum = (Map<String, String>) value;
			return Arrays.stream(StatEnum.values())
					.filter(c -> {
						assert c.getValue() != null;
						return c.getValue().equalsIgnoreCase(codeEnum.get("value"));
					}).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of stat invalid!"));
		} else {
			return Arrays.stream(StatEnum.values()).filter(c -> {
				assert c.getValue() != null;
				return c.getValue().equalsIgnoreCase(value.toString());
			})
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of stat invalid!"));
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
