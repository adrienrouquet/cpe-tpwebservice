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
	
	public int getNumberOfPoints()
	{
		int result = 0;
		
		if (_points != null)
		{
			result = _points.length;
		}
		
		return result;
	}
	
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

        if (rPositions != null)
        {
        	_points = rPositions.get_return();
        } 
    }
    
    public double latitude(int pointNumber)
    {
    	double result = 0;
    	
    	if ((_points != null) && (_points.length > pointNumber))
    	{
    		PositionLog myPoint = _points[pointNumber];  	
        	result = myPoint.getLatitude();
    	}
    	
    	return result;
    }
    public double longitude(int pointNumber)
    {
    	double result = 0;
    	
    	if ((_points != null) && (_points.length > pointNumber))
    	{
    		PositionLog myPoint = _points[pointNumber];
        	result = myPoint.getLongitude();
    	}
    	
    	return result;
    }
    public int speed(int pointNumber)
    {
    	int result = 0;
    	
    	if ((_points != null) && (_points.length > pointNumber))
    	{
    		PositionLog myPoint = _points[pointNumber];
        	result = myPoint.getSpeed();  
    	}
    	
    	return result;
    }
    public int heading(int pointNumber)
    {
    	int result = 0;
    	
    	if ((_points != null) && (_points.length > pointNumber))
    	{
    		PositionLog myPoint = _points[pointNumber];
    		result = myPoint.getHeading();
    	}
    	
    	return result;
    }
    public String date(int pointNumber)
    {
    	String result = null;
    	
    	if ((_points != null) && (_points.length > pointNumber))
    	{
	    	PositionLog myPoint = _points[pointNumber];
	    	result = myPoint.getDateString();
    	}
    	
    	return result;
    }
}
