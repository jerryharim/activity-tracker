package mg.jerryharim.activitytracker.gui.component.base;


/**
 * Synchronize and set default state
 * of a component
 */
public interface Synchronizable {

    /**
     * Initialize synchronisation of all properties.
     * For exemple : a property is changed according to the
     * state of an another property.
     *
     * This function must be called before running default
     * action.
     */
    void synchronizeStates();

    void initializeDefaultStates();
}
