package ws;

import org.eclipse.swt.widgets.*;

import java.rmi.RemoteException;

import ws.GeoTrackerServiceStub.GetIds;
import ws.GeoTrackerServiceStub.GetIdsResponse;


public class Core {

	private static Display _display;
	
	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException 
	{
		Shell shell = initShell();
		
		new GeoTrackerMenu(shell);
		
		runAndClose(shell);
	}
	
	protected static Shell initShell() {
		if (_display == null)
		{
			_display = new Display();
		}
		else
		{
			_display = Display.getCurrent();
		}
		return new Shell(_display);
	}
	
	protected static void runAndClose(Shell shell) {
		shell.open();
		while (!shell.isDisposed()) {
			if (!_display.readAndDispatch())
				_display.sleep();
		}
	}
		
		
}

