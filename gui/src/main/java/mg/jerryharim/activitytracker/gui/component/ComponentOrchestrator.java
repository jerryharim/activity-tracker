package mg.jerryharim.activitytracker.gui.component;

import mg.jerryharim.activitytracker.gui.annotation.Orchestrator;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentFactory;

@Orchestrator
public class ComponentOrchestrator {
    private ComponentFactory componentFactory = new ComponentFactory();

    public void initialize() {
        this.componentFactory.initialize_route();
    }
}
