package mg.jerryharim.activitytracker.gui.component;

import mg.jerryharim.activitytracker.gui.component.base.Component;
import mg.jerryharim.activitytracker.gui.component.base.ViewModel;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentName;

import java.util.HashMap;

public class Route extends HashMap<ComponentName, Component> {

    public void buildAll() {
        values().forEach(component -> {
            component.load();
            component.getView().sync_with_view_model();
            ((ViewModel) component.getView().getViewModel()).synchronizeStates();
            ((ViewModel) component.getView().getViewModel()).initializeDefaultStates();

//            if (component.getView() instanceof ParentController) {
//                ((ParentController) component.getController()).syncCurrentChildren();
//            }
        });
    }

}
