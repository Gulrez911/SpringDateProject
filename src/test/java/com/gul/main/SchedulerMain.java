package com.gul.main;

import java.util.Timer;

public class SchedulerMain {

	public static void main(String[] args) throws InterruptedException {

		int increment = 0;
		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs
//		time.s
		// for demo only.
//		for (int i = 0; i <= 5; i++) {
		for(;;) {
//			System.out.println("Execution in Main Thread...." + i);
			Thread.sleep(1000);
			System.out.println("Testing:::::::::: "+increment++);
//			if (i == 5) {
//				System.out.println("Application Terminates");
//				System.exit(0);
//			}
		}
	}
}
