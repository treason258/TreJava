package com.mjiayou.trejava.temp.rate;

import java.math.BigDecimal;
import java.util.Calendar;

public class RateCalculator {

    private static final double RATE_YEAR_GJJ = 3.25 / 100;
    private static final double RATE_YEAR_GJJ_1_1 = 3.575 / 100;
    private static final double RATE_YEAR_BUZ = 4.9 / 100;
    private static final double RATE_YEAR_SDD_ME = 10.8 / 100; // 招商银行-闪电贷-me
    private static final double RATE_YEAR_SDD_SS = 9.36 / 100; // 招商银行-闪电贷-shasha

    private static final double RATE_DAY_Ali = 0.04 / 100;
    private static final double RATE_DAY_WX = 0.05 / 100;
    private static final double RATE_DAY_JD = 0.05 / 100;

    /**
     * 贷款本金
     * 还款月数
     * 月利率
     * 已归还本金
     * 剩余贷款本金
     * 还款月序号
     * 每月偿还本金
     * 每月偿还利息
     * 每月偿还本金
     */
    public static void main(String[] args) {
        System.out.println("**************** BEGIN ****************");

        PlatformInfo test = new PlatformInfo(10000 * 3.7, 12 * 2, RATE_YEAR_SDD_SS / 12.0);
        PlatformInfo ali = new PlatformInfo(10000 * 7, 12 * 2, RATE_DAY_Ali * 30.0);
        PlatformInfo wx = new PlatformInfo(10000 * 7, 12 * 2, RATE_DAY_WX * 30.0);
        PlatformInfo jd = new PlatformInfo(10000 * 7, 12 * 2, RATE_DAY_JD * 30.0);
        PlatformInfo gjj = new PlatformInfo(10000 * 7, 12 * 2, RATE_DAY_JD * 30.0);

        PlatformInfo platformInfo = test;
        System.out.println(getInfo(platformInfo));
        System.out.println(getEqualityCorpus(platformInfo));
        System.out.println(getEqualityCorpusAndInterest(platformInfo));
//        System.out.println(getEqualityCorpusForDay(corpusMoney, monthCount, monthRate));

        System.out.println("**************** END ****************");
    }

    public static String getInfo(PlatformInfo platformInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n").append("******** INFO ********").append("\n").append("\n");
        builder.append("corpusMoney = ").append(platformInfo.corpusMoney).append("\n");
        builder.append("monthCount = ").append(platformInfo.monthCount).append("\n");
        builder.append("dayRate = ").append(platformInfo.dayRate.multiply(new BigDecimal(100.0)).setScale(4, BigDecimal.ROUND_HALF_UP)).append("%").append("\n");
        builder.append("monthRate = ").append(platformInfo.monthRate.multiply(new BigDecimal(100.0)).setScale(4, BigDecimal.ROUND_HALF_UP)).append("%").append("\n");
        builder.append("yearRate = ").append(platformInfo.yearRate.multiply(new BigDecimal(100.0)).setScale(4, BigDecimal.ROUND_HALF_UP)).append("%").append("\n");
        return builder.toString();
    }

    /**
     * 等额本金
     * <p>
     * 公式：
     * 每月偿还本金 = 贷款本金÷还款月数
     * 每月偿还利息 = 剩余贷款本金×月利率
     * 每月偿还本息 = 每月偿还本金+每月偿还利息
     */
    public static String getEqualityCorpus(PlatformInfo platformInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n").append("******** getEqualityCorpus ********").append("\n").append("\n");

        BigDecimal sumCorpus = BigDecimal.ZERO;             // 本金总和
        BigDecimal sumInterest = BigDecimal.ZERO;           // 利息总和
        BigDecimal sumCorpusAndInterest = BigDecimal.ZERO;  // 本息总和
        BigDecimal monthCorpus;                             // 每月偿还本金
        BigDecimal monthInterest;                           // 每月偿还利息
        BigDecimal monthCorpusAndInterest;                  // 每月偿还本息
        BigDecimal surplusCorpus = platformInfo.corpusMoney;             // 剩余贷款本金

        // 每月偿还本金 = 贷款本金÷还款月数
        monthCorpus = platformInfo.corpusMoney.divide(platformInfo.monthCount, 4, BigDecimal.ROUND_HALF_UP);
        builder.append("monthCorpus = ").append(monthCorpus).append("\n");

        for (int i = 1; i <= platformInfo.monthCount.intValue(); i++) {
            // 每月偿还利息 = 剩余贷款本金×月利率
            monthInterest = surplusCorpus.multiply(platformInfo.monthRate).setScale(4, BigDecimal.ROUND_HALF_UP);
            // 每月偿还本息 = (贷款本金÷还款月数)+(贷款本金-已归还本金)×月利率
            monthCorpusAndInterest = monthCorpus.add(monthInterest);
            // 剩余贷款本金
            surplusCorpus = surplusCorpus.subtract(monthCorpus);
            // 总和
            sumCorpus = sumCorpus.add(monthCorpus);
            sumInterest = sumInterest.add(monthInterest);
            sumCorpusAndInterest = sumCorpusAndInterest.add(monthCorpusAndInterest);

//            builder.append("").append(i).append(": ").append(monthCorpus).append(" + ").append(monthInterest).append(" = ").append(monthCorpus.add(monthInterest)).append("\n");
        }

        builder.append("sumCorpus = ").append(sumCorpus).append("\n");
        builder.append("sumInterest = ").append(sumInterest).append("\n");
        builder.append("sumCorpusAndInterest = ").append(sumCorpusAndInterest).append("\n");

        return builder.toString();
    }

    /**
     * 等额本息
     * <p>
     * 公式：
     * 每月偿还本息 = [贷款本金 × 月利率 × (1+月利率)^还款月数] ÷ [(1+月利率)^还款月数-1]
     * 每月偿还本金 = [贷款本金 × 月利率 × (1+月利率)^(还款月序号-1)] ÷ [(1+月利率)^还款月数-1]
     * 每月偿还利息 = [剩余贷款本金 x 月利率]
     * // 每月偿还利息 = [贷款本金 × 月利率 × [(1+月利率)^还款月数 - (1+月利率)^(还款月序号-1)]] ÷ [(1+月利率)^还款月数-1]
     */
    public static String getEqualityCorpusAndInterest(PlatformInfo platformInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n").append("******** getEqualityCorpusAndInterest ********").append("\n").append("\n");

        BigDecimal sumCorpus = BigDecimal.ZERO;             // 本金总和
        BigDecimal sumInterest = BigDecimal.ZERO;           // 利息总和
        BigDecimal sumCorpusAndInterest = BigDecimal.ZERO;  // 本息总和
        BigDecimal monthCorpus;                             // 每月偿还本金
        BigDecimal monthInterest;                           // 每月偿还利息
        BigDecimal monthCorpusAndInterest;                  // 每月偿还本息
        BigDecimal surplusCorpus = platformInfo.corpusMoney;             // 剩余贷款本金

        // 固定：每月偿还本息 = [贷款本金 × 月利率 × (1+月利率)^还款月数] ÷ [(1+月利率)^还款月数-1]
        monthCorpusAndInterest =
                platformInfo.corpusMoney
                        .multiply(platformInfo.monthRate)
                        .multiply(new BigDecimal(Math.pow(1 + platformInfo.monthRate.doubleValue(), platformInfo.monthCount.intValue())))
                        .divide(new BigDecimal(Math.pow(1 + platformInfo.monthRate.doubleValue(), platformInfo.monthCount.intValue()) - 1), 4, BigDecimal.ROUND_HALF_UP);
        builder.append("monthCorpusAndInterest = ").append(monthCorpusAndInterest).append("\n");

        for (int i = 1; i <= platformInfo.monthCount.intValue(); i++) {
            // 每月偿还本金 = [贷款本金 × 月利率 × (1+月利率)^(还款月序号-1)] ÷ [(1+月利率)^还款月数-1]
            monthCorpus =
                    platformInfo.corpusMoney
                            .multiply(platformInfo.monthRate)
                            .multiply(new BigDecimal((Math.pow((1 + platformInfo.monthRate.doubleValue()), i - 1))))
                            .divide(new BigDecimal(Math.pow(1 + platformInfo.monthRate.doubleValue(), platformInfo.monthCount.intValue()) - 1), 4, BigDecimal.ROUND_HALF_UP);
            // 每月偿还利息 = [剩余贷款本金 x 月利率]
            monthInterest = surplusCorpus.multiply(platformInfo.monthRate).setScale(4, BigDecimal.ROUND_HALF_UP);
            // 剩余贷款本金
            surplusCorpus = surplusCorpus.subtract(monthCorpus);
            // 总和
            sumCorpus = sumCorpus.add(monthCorpus);
            sumInterest = sumInterest.add(monthInterest);
            sumCorpusAndInterest = sumCorpusAndInterest.add(monthCorpusAndInterest);

//            builder.append("").append(i).append(": ").append(monthCorpus).append(" + ").append(monthInterest).append(" = ").append(monthCorpus.add(monthInterest)).append("\n");
        }

        builder.append("sumCorpus = ").append(sumCorpus).append("\n");
        builder.append("sumInterest = ").append(sumInterest).append("\n");
        builder.append("sumCorpusAndInterest = ").append(sumCorpusAndInterest).append("\n");

        return builder.toString();
    }

    /**
     * 等额本金，按日计息
     * <p>
     * 支付宝网商贷OK，微信微粒贷OK
     * <p>
     * 941.83 - 932.79 - 915 - 914.71 - 903.33 ----- 842.12
     * 0.035% = 0.00035 = 100Y 1T 0.035Y = 10000Y 1T 3.5Y
     * 01-12 = 10000/12 + (10000-0*10000/12)*(31)*(0.035/100) = 833.33 + 108.5=941.83
     * 02-01 = 10000/12 + (10000-1*10000/12)*(31)*(0.035/100) = 833.33 + 99.46=932.79
     * ...
     * 12-11 = 10000/12 + (10000-11*10000/12)*(30)*(0.035/100) = 833.33 + 8.75=842.08
     *
     * @param corpusMoney 贷款本金
     * @param monthCount  还款月数
     * @param monthRate   月利率
     * @return
     */
    public static String getEqualityCorpusForDay(BigDecimal corpusMoney, BigDecimal monthCount, BigDecimal monthRate) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n").append("******** getEqualityCorpusForDay ********").append("\n").append("\n");

        BigDecimal sumCorpus = BigDecimal.ZERO;             // 本金总和
        BigDecimal sumInterest = BigDecimal.ZERO;           // 利息总和
        BigDecimal sumCorpusAndInterest = BigDecimal.ZERO;  // 本息总和
        BigDecimal monthCorpus;                             // 每月偿还本金
        BigDecimal monthInterest;                           // 每月偿还利息
        BigDecimal monthCorpusAndInterest;                  // 每月偿还本息
        BigDecimal surplusCorpus = corpusMoney;             // 剩余贷款本金

        BigDecimal dayRate = monthRate.divide(new BigDecimal(30.0), 4, BigDecimal.ROUND_HALF_UP); // 日利率
        Calendar calendar;
        int yearIndex;
        int monthIndex;
        int dayCount;

        for (int i = 1; i <= monthCount.intValue(); i++) {
            calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, i - 1); // 当前月份不算，需要减1
            yearIndex = calendar.get(Calendar.YEAR);
            monthIndex = calendar.get(Calendar.MONTH);
            dayCount = calendar.getActualMaximum(Calendar.DATE);

            // 每月偿还本金 = 贷款本金 / 还款月数;
            // 每月应还利息 = (贷款本金 - (i - 1) * 每月偿还本金) * 还款日数 * 日利率;
            // 每月偿还本息 = 每月偿还本金 + 每月偿还本息
            monthCorpus = corpusMoney.divide(new BigDecimal(monthCount.intValue()), 4, BigDecimal.ROUND_HALF_UP);
            monthInterest =
                    corpusMoney
                            .subtract(new BigDecimal(i - 1).multiply(monthCorpus))
                            .multiply(new BigDecimal(dayCount))
                            .multiply(dayRate)
                            .setScale(4, BigDecimal.ROUND_HALF_UP);
            monthCorpusAndInterest = monthCorpus.add(monthInterest).setScale(4, BigDecimal.ROUND_HALF_UP);

            sumCorpus = sumCorpus.add(monthCorpus).setScale(4, BigDecimal.ROUND_HALF_UP);
            sumInterest = sumInterest.add(monthInterest).setScale(4, BigDecimal.ROUND_HALF_UP);
            sumCorpusAndInterest = sumCorpusAndInterest.add(monthCorpusAndInterest).setScale(4, BigDecimal.ROUND_HALF_UP);

            // 月份从0开始，需要加1
            builder.append(i < 10 ? "0" + i : i);
            builder.append(" : ").append(yearIndex);
            builder.append("-").append((monthIndex + 1) < 10 ? "0" + (monthIndex + 1) : (monthIndex + 1));
            builder.append("-").append(dayCount);
            builder.append(" : ").append(monthCorpus);
            builder.append(" + ").append(monthInterest);
            builder.append(" = ").append(monthCorpusAndInterest);
            builder.append("\n");
//            builder.append("第" + i + "月偿还本息： " + monthCorpus + " + " + monthInterest + " = " + (monthCorpus.add(monthInterest))).append("\n");

        }

        builder.append("sumCorpus = ").append(sumCorpus).append("\n");
        builder.append("sumInterest = ").append(sumInterest).append("\n");
        builder.append("sumCorpusAndInterest = ").append(sumCorpusAndInterest).append("\n");

        return builder.toString();
    }

    /**
     * 平台信息
     */
    private static class PlatformInfo {

        private BigDecimal corpusMoney;  // 贷款本金
        private BigDecimal monthCount; // 还款月数
        private BigDecimal monthRate; // 月利率
        private BigDecimal dayRate; // 日利率
        private BigDecimal yearRate; // 年利率

        /**
         * @param corpusMoney 贷款本金
         * @param monthCount  还款月数
         * @param monthRate   月利率
         */
        public PlatformInfo(BigDecimal corpusMoney, BigDecimal monthCount, BigDecimal monthRate) {
            this.corpusMoney = corpusMoney;
            this.monthCount = monthCount;
            this.monthRate = monthRate;
            this.dayRate = monthRate.divide(new BigDecimal(30.0), 6, BigDecimal.ROUND_HALF_UP);
            this.yearRate = monthRate.multiply(new BigDecimal(12.0));

        }

        public PlatformInfo(double corpusMoneyNum, int monthCountNum, double monthRateNum) {
            this(new BigDecimal(corpusMoneyNum), new BigDecimal(monthCountNum), new BigDecimal(monthRateNum));
        }
    }
}
