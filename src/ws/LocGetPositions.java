package ws;

import java.rmi.RemoteException;

import ws.GeoTrackerServiceStub.GetPositions;
import ws.GeoTrackerServiceStub.GetPositionsResponse;
import ws.GeoTrackerServiceStub.PositionLog;

public class LocGetPositions {

	private PositionLog[] _points = null;
	
	private String _iD = null;
	private String _minDate = null;
	private String _maxDate = null;
	private int _maxResponse = 0;
    /**
     * @param args
     * @throws RemoteException
     */
    public LocGetPositions( String pId , String pMinDate, String pMaxDate, int pMaxResponse) throws RemoteException
    {
    	_iD = pId;
    	_minDate = pMinDate;
    	_maxDate = pMaxDate;
    	_maxResponse = pMaxResponse;
    	
    	createLogs();
    }
    
    private void createLogs() throws RemoteException
    {
    	// objet stub pour acceder au web service
        GeoTrackerServiceStub stub = new GeoTrackerServiceStub();

        // on prepare les objets messages
        GetPositions positions = new GetPositions();
        positions.setId(_iD);
        positions.setMinDate(_minDate);
        positions.setMaxDate(_maxDate);
        positions.setMaxResponse(_maxResponse);
        positions.setOnlyMovingPositions(false);

        GetPositionsResponse rPositions = new GetPositionsResponse();
        rPositions = stub.getPositions(positions);

        _points = rPositions.get_return();
    }
    
    public double latitude(int pointNumber)
    {
    	PositionLog myPoint = _points[pointNumber];  	
    	return myPoint.getLatitude();
    }
    public double longitude(int pointNumber)
    {
    	PositionLog myPoint = _points[pointNumber];
    	return myPoint.getLongitude();
    }
    public int speed(int pointNumber)
    {
    	PositionLog myPoint = _points[pointNumber];
    	return myPoint.getSpeed();
    }
    public int heading(int pointNumber)
    {
    	PositionLog myPoint = _points[pointNumber];
    	return myPoint.getHeading();
    }
    public String date(int pointNumber)
    {
    	PositionLog myPoint = _points[pointNumber];
    	return myPoint.getDateString();
    }
}
