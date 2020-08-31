package aop;

import org.aspectj.lang.JoinPoint;

public class Before {
	public void aopBefore(JoinPoint joinPoint) {
		System.out.println("[la]실행 전 전처리기 수행");
	}
}
