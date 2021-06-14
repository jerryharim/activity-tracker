package mg.jerryharim.activitytracker.gui.data;

import mg.jerryharim.activitytracker.gui.entity.Activity;
import mg.jerryharim.activitytracker.gui.viewModel.ActivityRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilise un simple liste pour stoquer les activites
 */
public class SimpleActivityRepository  {

    public List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("my new Activity", LocalDateTime.now().minusHours(4), LocalDateTime.now()));
        activities.add(new Activity("my new Activity", LocalDateTime.now().minusHours(4), LocalDateTime.now()));
        return activities;
    }
}
