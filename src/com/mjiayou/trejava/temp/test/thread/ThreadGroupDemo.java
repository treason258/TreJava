package com.mjiayou.trejava.temp.test.thread;

public class ThreadGroupDemo {
	public static void main(String args[]) throws Exception {
		ThreadGroup tg = new ThreadGroup("My Group");

		MyThread2 thrd = new MyThread2(tg, "MyThread2 #1");
		MyThread2 thrd2 = new MyThread2(tg, "MyThread2 #2");
		MyThread2 thrd3 = new MyThread2(tg, "MyThread2 #3");

		thrd.start();
		thrd2.start();
		thrd3.start();

		Thread.sleep(1000);

		System.out.println(tg.activeCount() + " threads in thread group.");

		Thread thrds[] = new Thread[tg.activeCount()];
		tg.enumerate(thrds);
		for (Thread t : thrds)
			System.out.println(t.getName());

		thrd.myStop();

		Thread.sleep(1000);

		
		System.out.println(tg.activeCount() + " threads in tg.");
		tg.interrupt();
	}
}

class MyThread2 extends Thread {
	boolean stopped;

	MyThread2(ThreadGroup tg, String name) {
		super(tg, name);
		stopped = false;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " starting.");
		try {
			for (int i = 1; i < 1000; i++) {
				System.out.print(".");
				Thread.sleep(250);
				synchronized (this) {
					if (stopped)
						break;
				}
			}
		} catch (Exception exc) {
			System.out.println(Thread.currentThread().getName() + " interrupted.");
		}
		System.out.println(Thread.currentThread().getName() + " exiting.");
	}

	synchronized void myStop() {
		stopped = true;
	}
}
