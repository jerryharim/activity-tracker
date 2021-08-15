package mg.jerryharim.activitytracker.gui.componentManager;

import mg.jerryharim.activitytracker.gui.component.Route;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteComponent;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteVM;
import mg.jerryharim.activitytracker.gui.component.nouvelleActivite.NouvelleActiviteView;
import mg.jerryharim.activitytracker.gui.component.root.RootComponent;
import mg.jerryharim.activitytracker.gui.component.root.RootVM;
import mg.jerryharim.activitytracker.gui.component.root.RootView;


public class ComponentFactory {
    private final Route route = new Route();


    /**
     * Initialize routing table content
     */
    public void initialize_route() {
        init_root_component();
        init_nouvelle_activite_component();
    }

    public void init_root_component() {
        this.route.put(ComponentName.ROOT, new RootComponent(
                "/fxml/liste_activite.fxml",
                new RootView(new RootVM())
        ));
    }

    public void init_nouvelle_activite_component() {
        this.route.put(ComponentName.NOUVELLE_ACTIVITE, new NouvelleActiviteComponent(
                "/fxml/nouvelle-activite.fxml",
                new NouvelleActiviteView(new NouvelleActiviteVM())
        ));
    }

	public void build_all() {
        this.route.buildAll();
	}

	public void initialize_view_model_synchronisations() {
        this.route.values().forEach(component -> {
            component.getView().sync_with_view_model();
        });
	}


    // getters

    public Route getRoute() {
        return route;
    }


}
