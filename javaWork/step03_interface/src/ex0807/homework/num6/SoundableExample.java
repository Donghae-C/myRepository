package ex0807.homework.num6;

public class SoundableExample {
	public static void PrintSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		PrintSound(new Cat());
		PrintSound(new Dog());
	}
}
