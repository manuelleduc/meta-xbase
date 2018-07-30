package fr.mleduc.xtext.xbase.specialized.interpreter

import com.google.inject.Inject
import fr.mleduc.xtext.xbase.specialized.compiler.XbaseSpecializedCompiler
import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

class XbaseSpecializedInterpreter extends XbaseInterpreter {

	@Inject XbaseSpecializedCompiler compiler
	@Inject IJvmModelAssociations jvmModelAssociations
	@Inject ILocationInFileProvider locationProvider
	@Inject extension IBatchTypeResolver typeResolver
	@Inject JvmTypeReferenceBuilder.Factory typeRefBuilderFactory

	override doEvaluate(XExpression expression, IEvaluationContext context, CancelIndicator indicator) {
		if (expression instanceof Down) {
			val tps = typeResolver.resolveTypes(expression).getActualType(expression)
			val tree = new TreeAppendable(null, null, locationProvider, jvmModelAssociations, expression, "  ", "\n")
			compiler.compile(expression, tree, tps)
		} else {
			super.doEvaluate(expression, context, indicator)
		}
	}
}
