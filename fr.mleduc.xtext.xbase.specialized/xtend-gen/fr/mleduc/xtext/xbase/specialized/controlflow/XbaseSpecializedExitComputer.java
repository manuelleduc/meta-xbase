package fr.mleduc.xtext.xbase.specialized.controlflow;

import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.Down;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.controlflow.DefaultEarlyExitComputer;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;

@SuppressWarnings("all")
public class XbaseSpecializedExitComputer extends DefaultEarlyExitComputer {
  @Override
  public Collection<IEarlyExitComputer.ExitPoint> exitPoints(final XExpression expression) {
    Collection<IEarlyExitComputer.ExitPoint> _xifexpression = null;
    if ((expression instanceof Down)) {
      IEarlyExitComputer.ExitPoint _exitPoint = new IEarlyExitComputer.ExitPoint(expression, false);
      _xifexpression = Collections.<IEarlyExitComputer.ExitPoint>singletonList(_exitPoint);
    } else {
      _xifexpression = super.exitPoints(expression);
    }
    return _xifexpression;
  }
}
