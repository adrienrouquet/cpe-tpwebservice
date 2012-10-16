package ws;

import java.rmi.RemoteException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import ws.GeoTrackerServiceStub.PositionLog;


public class GeoTrackerMenu 
{
	private Composite _shell = null;
	private Display _display = Display.getCurrent();
	
	private Combo _idCombo = null;
	private Spinner _maxResponseLabel = null;
	private Text _minDate = null;
	private Text _maxDate = null;
	private Table _table = null;
	
	private String[] _ids = null;
	private String _selId = null;
	private String _selMinDate = null;
	private String _selMaxDate = null;
	private int _selMaxResponse = 0;
//	if (_table.getColumnCount() != 0)
//	{
//		
//	}
	
	public GeoTrackerMenu(Composite parent) throws RemoteException 
	{
		_shell = parent;
		
		LocGetIds myIds = new LocGetIds();	
		_ids = myIds.show();
	
		initLayout(_shell);
	}
	
	public void initLayout(Composite parent) throws RemoteException
	{
		parent.setLayout(new GridLayout(1, false));
		
		// Ligne 1: ID et Points
		Composite compIdAndPoints = newLine(parent, 2);
		
		// Init ID
		Composite compId = new Composite(compIdAndPoints, SWT.NONE);
		initId(compId);
		
		// Init Points
		Composite compPoints = new Composite(compIdAndPoints, SWT.NONE);
		initPoints(compPoints);
		
		// Ligne 2: Date debut et fin
		Composite compDate = newLine(parent, 4);
		initMinDate(compDate);
		initMaxDate(compDate);
		
		// Line 3: Valid, selecteur de date, geoloc
		Composite compValid = newLine(parent, 3);
		initValidButton(compValid);
		
		// Line 4: Tableau
		Composite compTab = newLine(parent, 1);
		
		compTab.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initTab(compTab);
		

		// Line 5: Browser
		Composite compBrowser = newLine(parent, 1);
		compBrowser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initBrowser(compBrowser);
	}
	
	/**
	 * Nouvelle ligne d'interface
	 * @param parent
	 * @param numCol
	 * @return
	 */
	protected Composite newLine(Composite parent, int numCol) {
		Composite newLine = new Composite(parent, SWT.BORDER);
		newLine.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		newLine.setLayout(new GridLayout(numCol, true));
		return newLine;
	}
	
	/**
	 * Init ID
	 * @param parent
	 * @throws RemoteException 
	 */
	protected void initId(Composite parent) throws RemoteException {
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		parent.setLayout(new GridLayout(2, true));
		Label idLabel = new Label(parent, SWT.NONE);
		idLabel.setText("ID: ");
		_idCombo = new Combo(parent, SWT.NONE);
		_idCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// Plug to GUI
		if (_ids != null)
		{
			_idCombo.setItems(_ids);
		}
	}
	
	/**
	 * Init points max
	 * @param parent
	 */
	protected void initPoints(Composite parent) {
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		parent.setLayout(new GridLayout(2, true));
		Label pointsLabel = new Label(parent, SWT.NONE);
		pointsLabel.setText("Nb max points: ");
		
		_maxResponseLabel = new Spinner(parent, SWT.BORDER);
		_maxResponseLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		_maxResponseLabel.setValues(1000, 1, 100000, 0, 1, 100);
	}
	
	/**
	 * Init choix date début et fin
	 * @param parent
	 */
	protected void initMinDate(Composite parent) {
		
		// Init date debut
		Label minDateLabel = new Label(parent, SWT.NONE);
		minDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		minDateLabel.setText("Date initiale: ");
		
		_minDate = new Text(parent,SWT.NONE);
		_minDate.setText("28/03/2008:00:00:00");
	}
	
	protected void initMaxDate(Composite parent)
	{
		Label maxDateLabel = new Label(parent, SWT.NONE);
		maxDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		maxDateLabel.setText("Date finale: ");

		_maxDate = new Text(parent,SWT.NONE);
		_maxDate.setText("30/03/2008:23:59:59");
	}
	
	protected void initValidButton(Composite parent) {
		Button validButton = new Button(parent, SWT.PUSH);
		validButton.setText("OK");
		
		validButton.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event event)
			{
				_selId = _idCombo.getText();
				_selMinDate = _minDate.getText();
				_selMaxDate = _maxDate.getText();
				_selMaxResponse = _maxResponseLabel.getSelection();
				
				try
				{
					LocGetPositions myPositions = new LocGetPositions(_selId, _selMinDate, _selMaxDate, _selMaxResponse);
					fillTable(myPositions);
				}
				catch (RemoteException e)
				{
					// TODO Auto-generated catch block
					System.out.println("Error in initValidButton" + e.getMessage());
					//e.printStackTrace();
				}
			}
		});
	}
	
	private void fillTable(LocGetPositions positions)
	{
		_table.clearAll();
		_table.removeAll();
		
		if ((positions != null) && (positions.getNumberOfPoints() > 0))
		{
			int bound = positions.getNumberOfPoints();
					
			for(int i = 0; i < Math.min(bound, _selMaxResponse); i++)
			{
				TableItem tabItem = new TableItem(_table, SWT.BORDER);
				// No
				tabItem.setText(0, String.valueOf(i + 1));
				// Latitude
				tabItem.setText(1, String.valueOf(positions.latitude(i)));
				// Longitude
				tabItem.setText(2, String.valueOf(positions.longitude(i)));
				//Speed
				tabItem.setText(3, String.valueOf(positions.speed(i)));
				// Heading
				tabItem.setText(4, String.valueOf(positions.heading(i)));
				// Date
				tabItem.setText(5, positions.date(i));	
			}
				
			for (int j=0; j<_table.getColumnCount(); j++) 
			{
				_table.getColumn(j).pack();
			}
		}
	}
	
	private void initTab(Composite parent) {
		_table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		_table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		_table.setLinesVisible (true);
		_table.setHeaderVisible (true);
		
		initColumns();
	}
	
	private void initColumns()
	{
		String[] titles = {"No", "Latitude", "Longitude", "Speed", "Heading", "Date"};
		for (int i=0; i < titles.length; i++)
		{
			TableColumn column = new TableColumn (_table, SWT.NONE);
			column.setText (titles [i]);
			column.setMoveable(false);
			column.setResizable(true);
			column.pack();
		}
	}
	
	protected void initBrowser(Composite parent) {
		Browser browser = new Browser(parent, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		browser.setUrl(ws.Core.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "../../WebContent/map.html");
	}
}
