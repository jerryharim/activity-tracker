package mg.jerryharim.activitytracker.gui.view.window;

import mg.jerryharim.activitytracker.gui.view.FXMLView;

public class WindowFXMLView extends FXMLView {

    public WindowFXMLView(String fxmlPath, WindowViewModel windowViewModel) {
        super(fxmlPath, new WindowController(windowViewModel));
    }
}
