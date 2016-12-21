package com.mjiayou.trejava;

import java.util.Calendar;

public class RateCalculator {

	public static void main(String[] args) {
		System.out.println("**************** BEGIN ****************");

		double moneyCount = 5000; // 元
		int monthCount = 12; // 月
		double dayRate = 0.035 / 100; // Alipay=0.035%; JD=0.04%; WX=0.05%;
		System.out.println(getInterestInfo(moneyCount, monthCount, dayRate));

		System.out.println("**************** END ****************");
	}

	public static String getInterestInfo(double moneyCount, int monthCount, double dayRate) {

		// 941.83-932.79-915-914.71-903.33-----842.12
		// 0.035% = 0.00035 = 100Y1T0.035Y =10000Y1T3.5Y
		// 01-12 = 10000/12 + (10000-0*10000/12)*(31)*(0.035/100)=833.33 + 108.5=941.83
		// 02-01 = 10000/12 + (10000-1*10000/12)*(31)*(0.035/100)=833.33 + 99.46=932.79
		// ...
		// 12-11 = 10000/12 + (10000-11*10000/12)*(30)*(0.035/100)=833.33 + 8.75=842.08

		Calendar calendar;
		int yearIndex;
		int monthIndex;
		int dayCount;

		double principal;
		double interest;
		double total;

		double principalTotal = 0;
		double interestTotal = 0;
		double totalTotle = 0;

		StringBuilder builder = new StringBuilder();
		builder.append("getInterestInfo()").append("\n");
		builder.append("moneyCount = " + moneyCount).append("\n");
		builder.append("monthCount = " + monthCount).append("\n");
		builder.append("rate = " + dayRate * 100 + "%").append("\n");
		for (int i = 1; i <= monthCount; i++) {
			calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, i - 1); // 当前月份不算，需要减1
			yearIndex = calendar.get(Calendar.YEAR);
			monthIndex = calendar.get(Calendar.MONTH);
			dayCount = calendar.getActualMaximum(Calendar.DATE);

			principal = moneyCount / monthCount;
			interest = (moneyCount - (i - 1) * principal) * dayCount * dayRate;
			total = principal + interest;

			principalTotal += principal;
			interestTotal += interest;
			totalTotle += total;

			// 月份从0开始，需要加1

			builder.append(i < 10 ? "0" + i : i);
			builder.append("-").append(yearIndex);
			builder.append("-").append((monthIndex + 1) < 10 ? "0" + (monthIndex + 1) : (monthIndex + 1));
			builder.append("-").append(dayCount);
			builder.append(" : ").append(principal);
			builder.append(" + ").append(interest);
			builder.append(" = ").append(total);
			builder.append("\n");
		}
		builder.append("principalTotal = " + principalTotal).append("\n");
		builder.append("interestTotal = " + interestTotal).append("\n");
		builder.append("totalTotle = " + totalTotle).append("\n");

		return builder.toString();
	}
}
