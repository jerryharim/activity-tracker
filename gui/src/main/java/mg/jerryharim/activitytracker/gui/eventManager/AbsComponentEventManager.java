package mg.jerryharim.activitytracker.gui.eventManager;

import mg.jerryharim.activitytracker.gui.componentManager.ComponentOrchestrator;


public abstract class AbsComponentEventManager {

    protected final ComponentOrchestrator component_orchestrator;

    public AbsComponentEventManager( ComponentOrchestrator component_orchestrator) {

        this.component_orchestrator = component_orchestrator;
    }

    abstract void listen_all();

}
