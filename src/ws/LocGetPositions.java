package ws;

import java.rmi.RemoteException;

import ws.GeoTrackerServiceStub.GetPositions;
import ws.GeoTrackerServiceStub.GetPositionsResponse;
import ws.GeoTrackerServiceStub.PositionLog;

public class LocGetPositions {

	private PositionLog[] _points = null;
    /**
     * @param args
     * @throws RemoteException
     */
    public LocGetPositions( String pId , String pMinDate, String pMaxDate, int pMaxResponse) throws RemoteException
    {
        System.out.println("Retrieving route of vehicle " + pId );
        // TODO Auto-generated method stub
        // objet stub pour acceder au web service
        GeoTrackerServiceStub stub = new GeoTrackerServiceStub();

        // on prepare les objets messages
        GetPositions positions = new GetPositions();
        positions.setId(pId);
        positions.setMinDate(pMinDate);
        positions.setMaxDate(pMaxDate);
        positions.setMaxResponse(pMaxResponse);
        positions.setOnlyMovingPositions(false);


        GetPositionsResponse rPositions = new GetPositionsResponse();
        rPositions = stub.getPositions(positions);

        _points = rPositions.get_return();

        for (int i = 0; i < Math.min(_points.length, pMaxResponse) ; i++)
        {
            System.out.println("Position " + (i+1));
            System.out.println("Latitude:" + _points[i].getLatitude());
            System.out.println("Longitude:" + _points[i].getLongitude());
            System.out.println("Cap:" + _points[i].getHeading());
            System.out.println("Date:" + _points[i].getDateString());
            System.out.println();
        }
       
    }

}