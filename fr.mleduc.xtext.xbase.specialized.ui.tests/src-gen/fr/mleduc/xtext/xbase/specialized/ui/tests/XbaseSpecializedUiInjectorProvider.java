/*
 * generated by Xtext 2.14.0
 */
package fr.mleduc.xtext.xbase.specialized.ui.tests;

import com.google.inject.Injector;
import fr.mleduc.xtext.xbase.specialized.ui.internal.SpecializedActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class XbaseSpecializedUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return SpecializedActivator.getInstance().getInjector("fr.mleduc.xtext.xbase.specialized.XbaseSpecialized");
	}

}
