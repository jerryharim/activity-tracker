package mg.jerryharim.activitytracker.gui.eventManager;

import javafx.application.Platform;
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
        System.out.println("[5]. Initialize event in root component");
        listen_add_button_pressed_state();
        listen_close_button_pressed_state();
    }

    private void listen_add_button_pressed_state() {
        this.rootComponentVM.pressed_add_button().addListener((obs, old, pressed) -> {
            System.out.println("[INFO] Event triggerd : Add button pressed");
            this.componentOrchestrator.show_add_new_activity_component();
        });
    }

    private void listen_close_button_pressed_state() {
        this.rootComponentVM.pressed_close_button().addListener((obs, old, pressed) -> {
            System.out.println("[INFO] Event triggerd : Close button pressed");
            Platform.exit();
        });
    }


}
