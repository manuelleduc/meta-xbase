package fr.mleduc.xtext.xbase.specialized.compiler

import com.google.inject.Inject
import fr.mleduc.xtext.xbase.specialized.interpreter.XbaseSpecializedInterpreter
import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class XbaseSpecializedCompiler extends XbaseCompiler {

	@Inject XbaseSpecializedInterpreter interpreter

	override protected doInternalToJavaStatement(XExpression obj, ITreeAppendable a, boolean isReferenced) {
		if (obj instanceof Down) {
			if (!isReferenced) {
				val res = interpreter.evaluate(obj.expression)
				a.append('''«res.result»''')

			}
		} else {
			super.doInternalToJavaStatement(obj, a, isReferenced)
		}
	}

	override protected internalCanCompileToJavaExpression(XExpression e, ITreeAppendable a) {
		if (e instanceof Down) {
			true
		} else {
			super.internalCanCompileToJavaExpression(e, a)
		}
	}

	override protected internalToConvertedExpression(XExpression obj, ITreeAppendable a) {
		if (obj instanceof Down) {
			val res = interpreter.evaluate(obj.expression)
			a.append('''«res.result»''')
		} else {
			super.internalToConvertedExpression(obj, a)
		}
	}
}
