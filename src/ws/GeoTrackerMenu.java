package ws;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class GeoTrackerMenu 
{
	private Display _display = Display.getCurrent();
	private String[] _ids = null;
	
	public void setIds(String[] myIds)
	{
		_ids = myIds;
	}
	public String[] getIds()
	{
		return _ids;
	}
	
	public GeoTrackerMenu(Composite parent) throws RemoteException 
	{
		initLayout(parent);
		
		LocGetIds myIds = new LocGetIds();	
		setIds(myIds.show());
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
		initDateDebutFin(compDate);
		
		// Line 3: Valid, selecteur de date, geoloc
		Composite compValid = newLine(parent, 3);
		initValidButton(compValid);
		
		// Line 4: Tableau
		Composite compTab = newLine(parent, 1);
		initTab(compTab);
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
		Combo idCombo = new Combo(parent, SWT.NONE);
		idCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// Plug to GUI
		if (getIds() != null)
		{
			idCombo.setItems(getIds());
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
		Spinner pointsSpinner = new Spinner(parent, SWT.BORDER);
		// Exemple d'utilisation
		pointsSpinner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		pointsSpinner.setValues(1000, 1, 100000, 0, 1, 100);
	}
	
	/**
	 * Init choix date début et fin
	 * @param parent
	 */
	protected void initDateDebutFin(Composite parent) {
		
		// Init date debut
		Label dateDebutLabel = new Label(parent, SWT.NONE);
		dateDebutLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		dateDebutLabel.setText("Date initiale: ");
		// TODO date -> String
		DateTime dateDebut = new DateTime(parent, SWT.NONE);
		dateDebut.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Calendar today = Calendar.getInstance();
		dateDebut.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)-1);
		dateDebut.setTime(0, 0, 0);
		
		// Init date fin
		Label dateFinLabel = new Label(parent, SWT.NONE);
		dateFinLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		dateFinLabel.setText("Date finale: ");
		// TODO date -> String
		DateTime dateFin = new DateTime(parent, SWT.NONE);
		dateFin.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		dateFin.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
		dateFin.setTime(today.get(Calendar.HOUR), today.get(Calendar.MINUTE), today.get(Calendar.SECOND));
	}
	
	protected void initValidButton(Composite parent) {
		Button validButton = new Button(parent, SWT.PUSH);
		validButton.setText("OK");
		
		// TODO CREER L'ACTION CORRESPONDANTE
	}

	private void initTab(Composite parent) {
		Table table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setLinesVisible (true);
		table.setHeaderVisible (true);
		
		String[] titles = {"No", "Latitude", "Longitude", "Speed", "Heading", "Date"};
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}
		
		
		/*
		TableItem tabItem = new TableItem(table, SWT.BORDER_DASH);
		String[] test = { "item1", "item2", "item3" };
		tabItem.setText(test);
		*/
		
	}
}