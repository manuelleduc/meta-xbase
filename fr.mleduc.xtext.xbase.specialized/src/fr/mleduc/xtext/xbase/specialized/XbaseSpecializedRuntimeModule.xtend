/*
 * generated by Xtext 2.14.0
 */
package fr.mleduc.xtext.xbase.specialized

import fr.mleduc.xtext.xbase.specialized.compiler.XbaseSpecializedCompiler
import fr.mleduc.xtext.xbase.specialized.controlflow.XbaseSpecializedExitComputer
import fr.mleduc.xtext.xbase.specialized.interpreter.XbaseSpecializedInterpreter
import fr.mleduc.xtext.xbase.specialized.types.XbaseSpecializedTypeComputer
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class XbaseSpecializedRuntimeModule extends AbstractXbaseSpecializedRuntimeModule {

	def Class<? extends ITypeComputer> bindITypeComputer() {
		XbaseSpecializedTypeComputer
	}

	def Class<? extends XbaseCompiler> bindXbaseCompiler() {
		XbaseSpecializedCompiler
	}
	
	override bindIExpressionInterpreter() {
		XbaseSpecializedInterpreter
	}
	
	def Class<? extends IEarlyExitComputer> bindIEarlyExitComputer() {
		XbaseSpecializedExitComputer
	}
}
