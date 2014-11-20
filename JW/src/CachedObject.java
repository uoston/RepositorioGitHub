import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable {
	
	 private Date dateofExpiration = null;
	 private Object identifier = null;
	 
	 public Object object = null;
	 
	 public CachedObject(Object obj, ObjectID id, int minutesToLive)
	 {
		 this.object = obj;
		 this.identifier = id;
		 // minutesToLive of 0 means it lives on indefinitely.
		 if (minutesToLive != 0)
		 {
			 dateofExpiration = new Date();
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(dateofExpiration);
			 cal.add(cal.MINUTE, minutesToLive);
			 dateofExpiration = cal.getTime();
		 }
	 }
	 
	 public boolean isExpired()
	 {
		 // Remember if the minutes to live is zero then it lives forever!
		 if (dateofExpiration != null)
		 {
			 // date of expiration is compared.
			 if (dateofExpiration.before(new Date()))
			 {
				 System.out.println("CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: " + dateofExpiration.toString() + " CURRENT TIME: " + (new Date()).toString());
				 return true;
			 }
			 else
			 {
				 System.out.println("CachedResultSet.isExpired:  Expired not from Cache!");
				 return false;
			 }
		 }
		 else // This means it lives forever!
			 return false;
	 }

	 public Object getIdentifier()
	 {
		 return identifier;
	 }

}
