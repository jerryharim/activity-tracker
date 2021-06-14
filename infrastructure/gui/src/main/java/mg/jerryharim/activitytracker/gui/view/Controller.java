package mg.jerryharim.activitytracker.gui.view;

/**
 * Super classe de tous les controlleurs
 */
public class Controller {

    private final ViewModel viewModel;

    public Controller(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }
}
