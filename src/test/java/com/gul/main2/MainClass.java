package com.gul.main2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainClass {

	int count = 0;
	Timer t = new Timer();
	TimerTask task = new TimerTask() {
		@Override
		public void run() {

			System.out.println("Time is: " + new Date());
			System.out.println("Counter::: "+count++);
		}
	};

	public void start() {
		
		t.schedule(task, 0, 1000);
	}

	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.start();
	}
}
