package mg.jerryharim.activitytracker.gui.viewModel;

import javafx.event.EventHandler;
import mg.jerryharim.activitytracker.gui.ActionHandler;
import mg.jerryharim.activitytracker.gui.view.window.WindowViewModel;

public class WindowViewModelImpl extends WindowViewModel {

    private ActivityRepository activityRepository;
    private ActionHandler actionHandler;

    public WindowViewModelImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void updateItems() {
        this.actionHandler.
//        this.activityRepository.getActivities().addListener((ListChangeListener<Activity>) change -> {
//            while (change.next())  {
//                if (change.wasAdded()) change.getAddedSubList().forEach(this::addActivity);
//            }
//        });
    }



//    private void addActivity(Activity activity) {
//        super.activities.add(this.viewFactory.createActivityItem(activity));
//    }
}
