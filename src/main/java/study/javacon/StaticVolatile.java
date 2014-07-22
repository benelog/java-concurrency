/*
 * @(#)StaticVolatile.java $version 2011. 11. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author benelog
 */
public class StaticVolatile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		ExecutorService exec = Executors.newFixedThreadPool(4);
		
		exec.execute(new Lesson(s1, 20, 100));
		exec.execute(new Lesson(s2, 30, 200));
		exec.execute(new Lesson(s1, 40, 300));
		exec.execute(new Lesson(s1, 50, 400));
		
		System.out.println(s1);
		System.out.println(s2);
	}

	
	static class Student{
		static int maxAge;
		volatile int lastLessonScore;
		
		@Override
		public String toString() {
			return "Student [maxAge=" + maxAge + ", lastLessonScore=" + lastLessonScore + "]";
		}
		
	}
	
	static class Lesson implements Runnable{
		
		private Student student;
		private int maxAge;
		private int score;

		public Lesson(Student student, int maxAge, int score){
			this.student= student;
			this.maxAge = maxAge;
			this.score= score;
		}

		/**
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			student.maxAge = this.maxAge;
			student.lastLessonScore = this.score;
		}
		
	}
}
