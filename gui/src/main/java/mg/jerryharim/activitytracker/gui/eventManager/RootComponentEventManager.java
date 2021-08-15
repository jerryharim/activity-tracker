package mg.jerryharim.activitytracker.gui.eventManager;

import mg.jerryharim.activitytracker.gui.component.root.RootComponent;
import mg.jerryharim.activitytracker.gui.component.root.RootVM;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentOrchestrator;

public class RootComponentEventManager {

    private final RootVM rootComponentVM;
    private final ComponentOrchestrator componentOrchestrator;

    public RootComponentEventManager(
            RootVM rootVM,
            ComponentOrchestrator componentOrchestrator) {

        this.rootComponentVM = rootVM;
        this.componentOrchestrator = componentOrchestrator;
    }


    public void listen_all() {
        listen_add_button();
    }

    private void listen_add_button() {
        this.rootComponentVM.pressed_add_button().addListener((obs, old, pressed) -> {
            System.out.println("add button pressed");
            this.componentOrchestrator.show_add_new_activity_component();
        });
    }

}
