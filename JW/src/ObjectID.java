public class ObjectID {
	
	private int id;
	
	ObjectID(int id_){
		
		if (id_<100 || id_>999)
		{
			System.out.println("ObjectID:  ObjectID inválido. ");
			//return null;
		}
		else 
		{
			//ObjectID objid = new ObjectID(id_);
			this.id = id_;
			//return objid;
		}
		
	}
	
	public int getID(){
		return id;
	}
	
	/*public ObjectID createID(int id_){
		
	
	}*/
	
}
