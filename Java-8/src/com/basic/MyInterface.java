package com.basic;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface MyInterface {

	static enum COLORS {
		RED(1), BLUE(2), GREEN(3);
		int code;

		COLORS(int code) {
			this.code = code;
		}
	};
	public COLORS getColour();
	public static void viewColours() {
		System.out.println("RED "+ COLORS.RED.code);
		System.out.println("BLUE "+ COLORS.BLUE.code);
		System.out.println("GREEN "+ COLORS.GREEN.code);
		Set<COLORS> cSet = EnumSet.allOf(COLORS.class);
		System.out.println(cSet);
		Set<COLORS> cSet2 = EnumSet.range(COLORS.RED, COLORS.BLUE);
		System.out.println(cSet2);
	}
	public static void main(String[] args) {
		viewColours();
	}
}
