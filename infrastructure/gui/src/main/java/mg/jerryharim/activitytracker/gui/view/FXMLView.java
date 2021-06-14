package mg.jerryharim.activitytracker.gui.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import mg.jerryharim.activitytracker.gui.view.Controller;

import java.io.IOException;

public class FXMLView {
    private Node node;
    private final String fxmlPath;
    private final Controller controller;

    public FXMLView(String fxmlPath, Controller controller) {
        this.fxmlPath = fxmlPath;
        this.controller = controller;
    }

    /**
     * Load a view and put it to node property
     * @throws IOException:
     */
    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setController(controller);
        this.node = loader.load();
    }

    public Node getNode() {
        return node;
    }

    public  Controller getController() {
        return controller;
    }
}

