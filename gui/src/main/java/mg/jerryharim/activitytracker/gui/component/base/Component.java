package mg.jerryharim.activitytracker.gui.component.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;


/**
 * FXML component. T represent a ViewModel.
 * A component regroupe a View, Path of the view and
 * the instance of the node.
 */
public class Component<T> {

    protected final View<T> view;
    protected final String viewPath;
    private Node node;

    public Component(String viewPath, View<T> view) {
        this.viewPath = viewPath;
        this.view = view;
    }


    public void load() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(this.viewPath));
        fxmlLoader.setController(this.view);

        try {
            this.node = fxmlLoader.load();

        } catch (IllegalStateException e) {
            System.err.printf("[ERROR] Location '%s' is not set%n", this.viewPath);
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // getters

    public View<T> getView() {
        return this.view;
    }

    public Node getNode() {
        return this.node;
    }

    public T getViewModel() {
        return this.view.getViewModel();
    }
}

