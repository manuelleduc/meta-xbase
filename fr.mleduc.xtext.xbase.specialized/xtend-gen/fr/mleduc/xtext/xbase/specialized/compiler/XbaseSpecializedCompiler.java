package fr.mleduc.xtext.xbase.specialized.compiler;

import com.google.inject.Inject;
import fr.mleduc.xtext.xbase.specialized.interpreter.XbaseSpecializedInterpreter;
import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;

@SuppressWarnings("all")
public class XbaseSpecializedCompiler extends XbaseCompiler {
  @Inject
  private XbaseSpecializedInterpreter interpreter;
  
  @Override
  protected void doInternalToJavaStatement(final XExpression obj, final ITreeAppendable a, final boolean isReferenced) {
    if ((obj instanceof Down)) {
      if ((!isReferenced)) {
        final IEvaluationResult res = this.interpreter.evaluate(((Down)obj).getExpression());
        StringConcatenation _builder = new StringConcatenation();
        Object _result = res.getResult();
        _builder.append(_result);
        a.append(_builder);
      }
    } else {
      super.doInternalToJavaStatement(obj, a, isReferenced);
    }
  }
  
  @Override
  protected boolean internalCanCompileToJavaExpression(final XExpression e, final ITreeAppendable a) {
    boolean _xifexpression = false;
    if ((e instanceof Down)) {
      _xifexpression = true;
    } else {
      _xifexpression = super.internalCanCompileToJavaExpression(e, a);
    }
    return _xifexpression;
  }
  
  @Override
  protected void internalToConvertedExpression(final XExpression obj, final ITreeAppendable a) {
    if ((obj instanceof Down)) {
      final IEvaluationResult res = this.interpreter.evaluate(((Down)obj).getExpression());
      StringConcatenation _builder = new StringConcatenation();
      Object _result = res.getResult();
      _builder.append(_result);
      a.append(_builder);
    } else {
      super.internalToConvertedExpression(obj, a);
    }
  }
}
