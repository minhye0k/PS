import java.util.BitSet;
import java.util.Scanner;

public class fanmeeting1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		while (tc-- > 0) {
			int hugCount = 0;
			String strMem = sc.next();
			int lenMem = strMem.length();
			String strFan = sc.next();
			int lenFan = strFan.length();
			
			BitSet mem = new BitSet(lenMem);
			BitSet fan = new BitSet(lenFan);
			
			for (int i = 0; i < lenMem; i++) {
				if (strMem.charAt(i) == 'M') {
					mem.set(i);
				}
			}
			
			for (int i = 0; i < lenFan; i++) {
				if (strFan.charAt(i) == 'M') {
					fan.set(i);
				}
			}
			
			for (int i = 0; i < lenFan - lenMem + 1; i++) {
				BitSet tempFan = fan.get(i, i + lenMem);
				tempFan.and(mem);
				
				if (tempFan.cardinality() == 0) {
					hugCount++;
				}
			}
			
			System.out.println(hugCount);
		}
		
		sc.close();
	}

}