package ch10.unit01;

public class Ex02 {
	public static void main(String[] args) {
		long ms = System.currentTimeMillis();
			// 1970.01.01. 00:00:00.000 시작점으로 현재까지 시간을 계산
			// 밀리초 단위 
		
		long ns = System.nanoTime();
			// 기준 시점에서 경과 시간 측정
			// 개발한 프로그램의 성능 측정을 위해 사용
			// 시스템 시간과 무관
		
		System.out.println("ms : " + ms);
		System.out.println("ns : " + ns);
		
	}
}
