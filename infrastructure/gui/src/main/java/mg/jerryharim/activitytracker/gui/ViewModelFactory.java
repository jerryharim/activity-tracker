package mg.jerryharim.activitytracker.gui;

import mg.jerryharim.activitytracker.gui.viewModel.WindowViewModelImpl;
import mg.jerryharim.activitytracker.gui.view.window.WindowViewModel;

/**
 * Recupere un singleton d'un viewModel
 */
public class ViewModelFactory {

    private final RepositoryFactory repositoryFactory;
    private WindowViewModel windowViewModel;

    public ViewModelFactory(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }

    public WindowViewModel getWindowViewModel() {
        if (this.windowViewModel == null)
            this.windowViewModel = new WindowViewModelImpl(this.repositoryFactory.getActivityRepository());
        return this.windowViewModel;

    }
}
