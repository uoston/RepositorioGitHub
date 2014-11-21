import java.util.Scanner;

public class CacheManagerTestProgram {
	
	public CacheManagerTestProgram() {
	
	}
	
	public static void main(String[] args) {
	
		CacheManagerTestProgram cacheManagerTestProgram1 = new CacheManagerTestProgram();
		Scanner ent = new Scanner(System.in);
		
		System.out.println("Digite seu ID: ");
		String s1 = ent.nextLine();
		CachedObject o = (CachedObject)CacheManager.getCache(s1);
		
		System.out.println("Digite a frase a ser guardada na cache: ");
		//String s = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String s2 = ent.nextLine();
		
		System.out.println("Digite um identificador para sua frase: ");
		int i1 = ent.nextInt();
		
		System.out.println("Digite quanto tempo deve ficar na cache antes de ser removido (em minutos): ");
		int i2 = ent.nextInt();
		
		CachedObject co = new CachedObject(s2, new ObjectID(i1), i2);
		
		CacheManager.putCache(co);
		CachedObject o = (CachedObject)CacheManager.getCache(123);
		
		if (o == null) System.out.println("CacheManagerTestProgram.Main:  Não existe objeto na cache com este ID.");
		else System.out.println("CacheManagerTestProgram.Main:  Objeto existe na Cache: " + ((String)o.object).toString());
	}
}