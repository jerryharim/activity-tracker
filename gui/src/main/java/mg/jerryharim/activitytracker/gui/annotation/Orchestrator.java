package mg.jerryharim.activitytracker.gui.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Defined where et how a component must be
 * displayed. It define also what is the root
 * component.
 */
@Target(ElementType.TYPE)
public @interface Orchestrator {
}
