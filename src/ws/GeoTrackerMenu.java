import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

public class GeoTrackerMenu 
{
	

	public GeoTrackerMenu(Composite pParentShell) 
	{
		initLayout(pParentShell);
	}
	
	public void initLayout(Composite pParentShell)
	{
		pParentShell.setLayout(new GridLayout(1, false));		
	}

}