//TP Web Service
//Adrien Rouquet
//Henri Lahoud
//Loic Ortola
//5ETI
package ws;

import java.rmi.RemoteException;

import ws.GeoTrackerServiceStub.GetLastPosition;
import ws.GeoTrackerServiceStub.GetLastPositionResponse;
import ws.GeoTrackerServiceStub.GetMaxSpeed;
import ws.GeoTrackerServiceStub.GetMaxSpeedResponse;
import ws.GeoTrackerServiceStub.SpeedLog;

public class LocGetMaxSpeed {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public LocGetMaxSpeed( String pId ) throws RemoteException 
	{
		System.out.println("Retrieving Maximum speed of ID " + pId );
		// TODO Auto-generated method stub
		// objet stub pour acceder au web service 
		GeoTrackerServiceStub stub = new GeoTrackerServiceStub();
		// on prepare les objets messages 
		GetMaxSpeed maxSpeed = new GetMaxSpeed();
		maxSpeed.setId(pId);
		
		GetMaxSpeedResponse rMaxSpeed = new GetMaxSpeedResponse();
		rMaxSpeed = stub.getMaxSpeed(maxSpeed);
		
		System.out.println(rMaxSpeed.get_return().getSpeed());
		
	}

}
