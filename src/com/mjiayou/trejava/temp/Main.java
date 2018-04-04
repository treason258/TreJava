package com.mjiayou.trejava.temp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("test");

		String aaa = "a";
		String bbb = "b";
		String ccc = "c";

		StringBuilder abversionSB = new StringBuilder();
		if (aaa != null && !aaa.equals("")) {
			if(!abversionSB.toString().equals("")) {
				abversionSB.append(".");
			}
			abversionSB.append(aaa);
		}
		if (bbb != null && !bbb.equals("")) {
			if(!abversionSB.toString().equals("")) {
				abversionSB.append(".");
			}
			abversionSB.append(bbb);
		}
		if (ccc != null && !ccc.equals("")) {
			if(!abversionSB.toString().equals("")) {
				abversionSB.append(".");
			}
			abversionSB.append(ccc);
		}

		System.out.println("abversion -> " + abversionSB.toString());
	}
}
