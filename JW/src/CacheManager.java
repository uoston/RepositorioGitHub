import java.util.*;

public class CacheManager {

	private static HashMap cacheHashMap = new HashMap();

	static
	{
		try
		{
			Thread threadCleanerUpper = new Thread(
			new Runnable()
			{
				int milliSecondSleepTime = 10000;
				public void run()
				{
					try
					{
						while (true)
						{
							System.out.println("ThreadCleanerUpper Scanning For	Expired Objects...");
							Set keySet = cacheHashMap.keySet();
							Iterator keys = keySet.iterator();
							while(keys.hasNext())
							{
								Object key = keys.next();
								Cacheable value = (Cacheable)cacheHashMap.get(key);

								if (value.isExpired())
								{
									cacheHashMap.remove(key);
									System.out.println("ThreadCleanerUpper Running.	Found an Expired Object in the Cache.");
								}
							}
							Thread.sleep(this.milliSecondSleepTime);
						}
					} 
					catch (Exception e)
					{
							e.printStackTrace();
					}
						return;
					}
		});
		threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
		threadCleanerUpper.start();
		}
		catch(Exception e)
		{
			System.out.println("CacheManager.Static Block: " + e);
		}
	}
	
	public CacheManager()
	{
	
	}
	
	public static void putCache(Cacheable object)
	{
		cacheHashMap.put(object.getIdentifier(), object);
	}
	
	public static Cacheable getCache(Object identifier)
	{
		Cacheable object = (Cacheable)cacheHashMap.get(identifier);
		if (object == null)
		{
			System.out.println("CacheManager.getCache: Funcion�rio n�o encontrado.");
			return null;
		}
		if (object.isExpired())
		{
			System.out.println("CacheManager.getCache: Seu contrato expirou. Procure o RH.");
			cacheHashMap.remove(identifier);
			return null;
		}
		else
		{
			return object;
		}
	}
}

