package mg.jerryharim.activitytracker.gui.component;

import mg.jerryharim.activitytracker.gui.component.activiteComponent.ActiviteComponent;
import mg.jerryharim.activitytracker.gui.component.base.Component;
import mg.jerryharim.activitytracker.gui.component.base.ViewModel;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentFactory;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentName;

import java.util.HashMap;


/**
 * Create a component or associate it component
 * with a ComponentName object if the instance is uniq
 */
public class Route extends HashMap<ComponentName, Component> {

    ComponentFactory componentFactory = new ComponentFactory();


    /**
     * Initialize routing table content
     */
    public void initialize() {
        init_root_component();
        init_nouvelle_activite_component();
    }

    private void init_root_component() {
        put(ComponentName.ROOT,
                this.componentFactory.create_root_component());
    }

    private void init_nouvelle_activite_component() {
        put(ComponentName.NOUVELLE_ACTIVITE,
                this.componentFactory.create_nouvelle_activite_component());
    }

    public ActiviteComponent create_activite_component() {
        return this.componentFactory.create_activite_component();
    }


    public void load_all_components() {
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
