package mg.jerryharim.activitytracker.gui.viewModel;

import javafx.beans.binding.Bindings;
import mg.jerryharim.activitytracker.gui.entity.Activity;
import mg.jerryharim.activitytracker.gui.view.activityItem.ActivityItemViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityItemViewModelImpl extends ActivityItemViewModel {

    public ActivityItemViewModelImpl(Activity activity) {
        super.title.bind(activity.titleProperty());
    }
}
