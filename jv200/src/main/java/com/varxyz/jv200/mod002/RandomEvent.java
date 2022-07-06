package com.varxyz.jv200.mod002;

public class RandomEvent {

	public static void main(String[] args) {
		// 각각의 이모티콘이 특정 이벤트에서 랜덤하게 화면에 나타난다.
		// 이모티콘의 출현 확률이 다음과 같도록 이모티콘 생성기를 작성
		// 동그라미 -> 70% 삼각형 -> 50% 사각형 -> 30% 오각형 -> 5% 육각형 -> 1% 팔각형 0.5% 별 -> 0.1%
//		System.out.println(randNum);
		randomEmoji();

	}
	
	public static void randomEmoji() {
		String[] emoji = new String[1566];
		
		for (int i=0; i<700; i++) {
			emoji[i]="동그라미";
		}
		for (int i=700; i<1200; i++) {
			emoji[i]="삼각형";
		}
		for (int i=1200; i<1500; i++) {
			emoji[i]="사각형";
		}
		for (int i=1500; i<1550; i++) {
			emoji[i]="오각형";
		}
		for (int i=1550; i<1560; i++) {
			emoji[i]="육각형";
		}
		for (int i=1560; i<1565; i++) {
			emoji[i]="팔각형";
		}
		emoji[1565]="별";
		
		int randNum = (int) (Math.random()*1566);
		System.out.println(emoji[randNum]);
		
	}

}