package fr.mleduc.xtext.xbase.specialized.types

import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer

class XbaseSpecializedTypeComputer extends XbaseTypeComputer {

	override computeTypes(XExpression down, ITypeComputationState state) {
		if (down instanceof Down) {
			val res = state.withNonVoidExpectation.computeTypes(down.expression)
			state.acceptActualType(res.actualExpressionType)
		} else {
			super.computeTypes(down, state)
		}
	}
}
