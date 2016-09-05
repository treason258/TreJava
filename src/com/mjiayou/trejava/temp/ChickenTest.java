package com.mjiayou.trejava.temp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChickenTest {

	public static void main(String[] a) {
		// 时间格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

		System.out.println("“鸡兔同笼”,共有头100个,脚316只,问鸡和兔各有多少只？");
		System.out.println("开始计算：" + simpleDateFormat.format(new Date(System.currentTimeMillis())));
		for (int chick = 0; chick <= 100; chick++) {
			for (int rabbit = 0; rabbit <= 100 - chick; rabbit++) {
				int heads = chick + rabbit;
				int legs = chick * 2 + rabbit * 4;
				if (heads == 100 && legs == 316) {
					System.out.println("鸡：" + chick + "只；兔子：" + rabbit + "只");
				}
			}
		}
		System.out.println("计算完成：" + simpleDateFormat.format(new Date(System.currentTimeMillis())));

		System.out.println("");
		System.out.println("“百鸡问题”：公鸡一只值5元钱，母鸡一只值3元钱，小鸡3只值一元钱，请写出求解100元钱买100只鸡的程序。");
		System.out.println("开始计算：" + simpleDateFormat.format(new Date(System.currentTimeMillis())));
		for (int cock = 0; cock <= 100 / 5; cock++) {
			for (int hen = 0; hen <= 100 / 3; hen++) {
				for (int chick = 0; chick <= 100 - cock - hen; chick++) {
					int price = cock * 5 + hen * 3 + chick / 3;
					int number = cock + hen + chick;
					if (price == 100 && number == 100) {
						System.out.println("公鸡：" + cock + "只；母鸡：" + hen + "只，小鸡：" + chick + "只");
					}
				}
			}
		}
		System.out.println("计算完成：" + simpleDateFormat.format(new Date(System.currentTimeMillis())));
	}
}
