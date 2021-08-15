package mg.jerryharim.activitytracker.gui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Gere un action issue du vue
 */
@Target(ElementType.METHOD)
public @interface ViewAction {
}
