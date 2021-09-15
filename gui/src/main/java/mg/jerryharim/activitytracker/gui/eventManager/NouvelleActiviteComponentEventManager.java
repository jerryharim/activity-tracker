package mg.jerryharim.activitytracker.gui.eventManager;

import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteVM;
import mg.jerryharim.activitytracker.gui.componentManager.ComponentOrchestrator;


public class NouvelleActiviteComponentEventManager extends AbsComponentEventManager {

    private final NouvelleActiviteVM nouvelleComponentVM;

    public NouvelleActiviteComponentEventManager(
            NouvelleActiviteVM nouvelleComponentVM,
            ComponentOrchestrator component_orchestrator) {

        super(component_orchestrator);
        this.nouvelleComponentVM = nouvelleComponentVM;
    }

    @Override
    public void listen_all() {
        System.out.println("[6]. Initialize event in nouvelle activite component");
        listen_cancel_button_pressed_state();
    }

    private void listen_cancel_button_pressed_state() {
        this.nouvelleComponentVM.button_annuler_pressed().addListener((obs, old, pressed) -> {
            System.out.println("button annuler pressed : " + pressed);
            hide_nouvelle_activite();
        });
    }

    private void hide_nouvelle_activite() {
        this.component_orchestrator.hide_nouvelle_activite();
    }
}
