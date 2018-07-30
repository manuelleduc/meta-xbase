package fr.mleduc.xtext.xbase.specialized.types;

import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;

@SuppressWarnings("all")
public class XbaseSpecializedTypeComputer extends XbaseTypeComputer {
  @Override
  public void computeTypes(final XExpression down, final ITypeComputationState state) {
    if ((down instanceof Down)) {
      final ITypeComputationResult res = state.withNonVoidExpectation().computeTypes(((Down)down).getExpression());
      state.acceptActualType(res.getActualExpressionType());
    } else {
      super.computeTypes(down, state);
    }
  }
}
