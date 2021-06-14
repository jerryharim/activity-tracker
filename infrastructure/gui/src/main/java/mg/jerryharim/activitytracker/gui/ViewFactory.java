package mg.jerryharim.activitytracker.gui;

import javafx.scene.Node;
import javafx.scene.Parent;
import mg.jerryharim.activitytracker.gui.entity.Activity;

/**
 * Regroupe tous les vues, parfois en unique
 * instance ou bien un instance a chaque appelle
 */
public class ViewFactory {

    private final ViewBuilder viewBuilder;
    private Parent windowView;

    public ViewFactory(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }

//    public Parent getWindowView() {
//        if (this.windowView == null) {
//            this.windowView = this.viewBuilder.createWindowView(this.viewModelFactory.getWindowViewModel());
//        }
//        return this.windowView;
//    }

    public Node createActivityItem(Activity activity) {
        return this.viewBuilder.createActivityItemView(activity);
    }

}
