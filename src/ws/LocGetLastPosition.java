//TP Web Service
//Adrien Rouquet
//Henri Lahoud
//Loic Ortola
//5ETI
package ws;

import java.rmi.RemoteException;

import ws.GeoTrackerServiceStub.GetLastPosition;
import ws.GeoTrackerServiceStub.GetLastPositionResponse;
import ws.GeoTrackerServiceStub.PositionLog;

public class LocGetLastPosition {

	private PositionLog _rLastPositionLog = null;
	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public String getDate() 
	{
		return _rLastPositionLog.getDateString();
	}
	
	public int getAltitude() 
	{
		return _rLastPositionLog.getAltitude();
	}
	
	public Double getLatitude() 
	{
		return _rLastPositionLog.getLatitude();
	}
	
	public Double getLongitude() 
	{
		return _rLastPositionLog.getLongitude();
	}

	public int getSpeed() 
	{
		return _rLastPositionLog.getSpeed();
	}
	
	public int getHeading() 
	{
		return _rLastPositionLog.getHeading();
	}	
	

	public LocGetLastPosition( String pId ) throws RemoteException 
	{
		System.out.println("Retrieving Last Position of ID " + pId );
		// TODO Auto-generated method stub
		// objet stub pour acceder au web service 
		GeoTrackerServiceStub stub = new GeoTrackerServiceStub();
		// on prepare les objets messages 
		GetLastPosition lastPosition = new GetLastPosition();
		lastPosition.setId(pId);
		
		GetLastPositionResponse rLastPosition = new GetLastPositionResponse();
		rLastPosition = stub.getLastPosition(lastPosition);
		
		_rLastPositionLog = rLastPosition.get_return();
	}
}
