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
		
		// Plug
		LocGetIds myIds = new LocGetIds();
		
		setIds(myIds.show());
		
		for(int i = 0; i < getIds().length; i++)
		{
			idCombo.add(getIds()[i]);
		}
//		
//		String[] items = {"Item1","Item2"};
//		idCombo.setItems(items);
//		idCombo.add("Item3");
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
		DateTime dateDebut = new DateTime(parent, SWT.NONE);
		dateDebut.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Calendar today = Calendar.getInstance();
		dateDebut.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH)-1);
		
		// Init date fin
		Label dateFinLabel = new Label(parent, SWT.NONE);
		dateFinLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		dateFinLabel.setText("Date finale: ");
		DateTime dateFin = new DateTime(parent, SWT.NONE);
		dateFin.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		dateFin.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
	}

}