package mg.jerryharim.activitytracker.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Le pattern repository definit un objet 
 * qui permet de persister les donnees.
 */
 @Target(ElementType.TYPE)
public @interface Repository { }
