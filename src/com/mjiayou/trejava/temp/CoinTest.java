package com.mjiayou.trejava.temp;

import java.util.ArrayList;
import java.util.List;

import com.mjiayou.trejava.temp.entity.Coin;

public class CoinTest {
	
	private static List<Coin> mList = new ArrayList<Coin>();
	private static List<List<Coin>> mExList;
	
	public static void main(String[] args) {
		System.out.println("test");

		mList = getFakeData();
		mExList = orderListByTime(mList);
		System.out.println(mExList.size());
	}
	
	/**
     * 根据日期分类
     */
	public static List<List<Coin>> orderListByTime(List<Coin> list) {
        List<List<Coin>> mList = new ArrayList<List<Coin>>();
        List<Coin> temp = new ArrayList<Coin>();
        String timePre;
        String time;
        
        for (int i=0; i<list.size(); i++) {
        	time = list.get(i).getTime();
        	if(i == 0) {
        		timePre = time;
        	} else {
        		timePre = list.get(i-1).getTime();
        	}
        	
            if(time.equals(timePre)) {
                temp.add(list.get(i));
            } else {
            	mList.add(temp);
            	temp = new ArrayList<Coin>();
            	temp.add(list.get(i));
            }
        }
        mList.add(temp);
        return mList;
    }
	
	
	/**
     * 假数据
     */
    public static List<Coin> getFakeData() {
    	List<Coin> mList = new ArrayList<Coin>();
        Coin m;

        m = new Coin();
        m.setTime("2014-12-16");
        m.setReason("测试1");
        m.setNum("11");
        mList.add(m);

        m = new Coin();
        m.setTime("2014-12-16");
        m.setReason("测试2");
        m.setNum("12");
        mList.add(m);

        m = new Coin();
        m.setTime("2014-12-16");
        m.setReason("测试3");
        m.setNum("13");
        mList.add(m);

        m = new Coin();
        m.setTime("2014-12-15");
        m.setReason("测试4");
        m.setNum("14");
        mList.add(m);

        m = new Coin();
        m.setTime("2014-12-14");
        m.setReason("测试5");
        m.setNum("15");
        mList.add(m);

        m = new Coin();
        m.setTime("2014-12-14");
        m.setReason("测试6");
        m.setNum("16");
        mList.add(m);
        
        return mList;
    }
}
