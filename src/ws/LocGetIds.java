package ws;

import java.rmi.RemoteException;

import ws.GeoTrackerServiceStub.GetIds;
import ws.GeoTrackerServiceStub.GetIdsResponse;

public class LocGetIds {

	private string[] myIDs;
	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public LocGetIds() throws RemoteException 
	{
	}
	
	public String[] show()
	{
		System.out.println("Retrieving Location IDs");
		// TODO Auto-generated method stub
		// objet stub pour acceder au web service 
		GeoTrackerServiceStub stub = new GeoTrackerServiceStub();
		// on prepare les objets messages 
		GetIds ids = new GetIds();
		ids.setUser("");
		ids.setPass("");
		GetIdsResponse rids = new GetIdsResponse();
		// on invoque la methode du web service
		rids = stub.getIds(ids);
		// on utilise la reponse
		
		return rids.get_return();	
	}

}
