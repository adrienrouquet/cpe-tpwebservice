package ws;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class GeoTrackerMenu 
{
	Display _display = Display.getCurrent();
	

	public GeoTrackerMenu(Composite parent) 
	{
		initLayout(parent);
	}
	
	public void initLayout(Composite parent)
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
		Composite compDate = newLine(parent, 2);
		
		// Init date debut
		Composite compDateDebut = new Composite(compDate, SWT.BORDER);
		compDateDebut.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compDateDebut.setLayout(new GridLayout(2, true));
		Label dateDebutLabel = new Label(compDateDebut, SWT.NONE);
		dateDebutLabel.setText("Date initiale: ");
	}
	
	protected Composite newLine(Composite parent, int numCol) {
		Composite newLine = new Composite(parent, SWT.BORDER);
		newLine.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		newLine.setLayout(new GridLayout(numCol, true));
		return newLine;
	}
	
	protected void initId(Composite parent) {
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		parent.setLayout(new GridLayout(2, true));
		Label idLabel = new Label(parent, SWT.NONE);
		idLabel.setText("ID: ");
		Combo idCombo = new Combo(parent, SWT.NONE);
		idCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));		
		// Exemple d'utilisation
		String[] items = {"Item1","Item2"};
		idCombo.setItems(items);
		idCombo.add("Item3");
	}
	
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

}