package mg.jerryharim.activitytracker.gui.component.root;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import mg.jerryharim.activitytracker.gui.component.base.MVVMView;
import mg.jerryharim.activitytracker.gui.component.base.View;


@MVVMView
public class RootView extends View<RootVM> {
    @FXML private Button closeWindowButton;
    @FXML private StackPane root;
    @FXML private VBox items_container;


    public RootView(RootVM viewModel) {
        super(viewModel);
    }

    @Override
    public void sync_with_view_model() {
        sync_close_window_pressed_state();
        sync_current_popup();
        sync_items_container();
    }


    private void sync_items_container() {
        this.viewModel.items().addListener((ListChangeListener<Node>) change -> {
            update_items_container();
        });
	}

	private void update_items_container() {
        this.items_container.getChildren().setAll(
                this.viewModel.items());
	}

	private void sync_close_window_pressed_state() {
        this.viewModel.pressed_close_button().bind(
            this.closeWindowButton.pressedProperty());
    }

    private void sync_current_popup() {
        this.viewModel.current_popup().addListener((obs, old, current_popup) -> {
                if (current_popup != null) showPopup(current_popup);
                else close_popup();
        });
    }


	private void showPopup(Node current_popup) {
        this.root.getChildren().add(1, current_popup);
	}

	private void close_popup() {
        this.root.getChildren().remove(1);
	}



}
