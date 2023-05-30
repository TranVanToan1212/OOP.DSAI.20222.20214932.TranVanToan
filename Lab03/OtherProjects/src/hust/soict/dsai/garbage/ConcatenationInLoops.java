package hust.soict.dsai.garbage;


public class ConcatenationInLoops {
	public static void main(String[] args) {
		String text = "hehe";
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 10000; i++) 
			s += text;
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) 
			sb.append(text);
		System.out.println(System.currentTimeMillis() - start);
	}
}
