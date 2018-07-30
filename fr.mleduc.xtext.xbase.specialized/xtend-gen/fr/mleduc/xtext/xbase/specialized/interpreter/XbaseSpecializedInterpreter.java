package fr.mleduc.xtext.xbase.specialized.interpreter;

import com.google.inject.Inject;
import fr.mleduc.xtext.xbase.specialized.compiler.XbaseSpecializedCompiler;
import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class XbaseSpecializedInterpreter extends XbaseInterpreter {
  @Inject
  private XbaseSpecializedCompiler compiler;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Inject
  @Extension
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private JvmTypeReferenceBuilder.Factory typeRefBuilderFactory;
  
  @Override
  public Object doEvaluate(final XExpression expression, final IEvaluationContext context, final CancelIndicator indicator) {
    Object _xifexpression = null;
    if ((expression instanceof Down)) {
      ITreeAppendable _xblockexpression = null;
      {
        final LightweightTypeReference tps = this.typeResolver.resolveTypes(expression).getActualType(expression);
        final TreeAppendable tree = new TreeAppendable(null, null, this.locationProvider, this.jvmModelAssociations, expression, "  ", "\n");
        _xblockexpression = this.compiler.compile(expression, tree, tps);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.doEvaluate(expression, context, indicator);
    }
    return _xifexpression;
  }
}
