package mg.jerryharim.activitytracker.gui;

import mg.jerryharim.activitytracker.gui.viewModel.ActivityRepository;

public class RepositoryFactory {
    private final ActivityRepository activityRepository;

    public RepositoryFactory() {
        this.activityRepository = new ActivityRepository();
    }

    public ActivityRepository getActivityRepository() {
        return this.activityRepository;
    }
}
