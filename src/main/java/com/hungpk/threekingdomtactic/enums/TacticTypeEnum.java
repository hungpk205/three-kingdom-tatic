package com.hungpk.threekingdomtactic.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;

public enum TacticTypeEnum implements CodeEnum {
	COMMAND("1","COMMAND", 1), ACTIVE("2", "ACTIVE", 2),
	STRIKE("3","STRIKE", 3), PASSIVE("4","PASSIVE", 4),
	TYPE("5","TYPE", 5), FORMATION("6","FORMATION", 6),
	CIVIC("7","CIVIC", 7);

	@JsonProperty("value")
	private final String value;
	@JsonProperty("label")
	private final String display;
	@JsonIgnore
	private final int sortOrder;

	TacticTypeEnum(String value, String display, int sortOrder) {
		this.value = value;
		this.display = display;
		this.sortOrder = sortOrder;
	}
	public static TacticTypeEnum of(String value) {
		return Arrays.stream(TacticTypeEnum.values()).filter(c -> value.equalsIgnoreCase(c.getValue())).findFirst()
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
	public static TacticTypeEnum ofElseThrow(Object value) {
		if (value instanceof Map) {
			Map<String, String> codeEnum = (Map<String, String>) value;
			return Arrays.stream(TacticTypeEnum.values())
					.filter(c -> {
						assert c.getValue() != null;
						return c.getValue().equalsIgnoreCase(codeEnum.get("value"));
					}).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of tactic type invalid!"));
		} else {
			return Arrays.stream(TacticTypeEnum.values()).filter(c -> {
				assert c.getValue() != null;
				return c.getValue().equalsIgnoreCase(value.toString());
			})
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("[" + value + "] of tactic type invalid!"));
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
