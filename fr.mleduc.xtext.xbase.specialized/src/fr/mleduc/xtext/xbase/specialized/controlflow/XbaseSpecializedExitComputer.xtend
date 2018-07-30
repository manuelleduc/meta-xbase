package fr.mleduc.xtext.xbase.specialized.controlflow

import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down
import java.util.Collection
import java.util.Collections
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.controlflow.DefaultEarlyExitComputer

class XbaseSpecializedExitComputer extends DefaultEarlyExitComputer {
	override Collection<ExitPoint> exitPoints(XExpression expression) {
		if (expression instanceof Down) {
			Collections.singletonList(new ExitPoint(expression, false))
		} else {
			super.exitPoints(expression)
		}
	}
}
