/**
 * generated by Xtext 2.14.0
 */
package fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.impl;

import fr.mleduc.xtext.xbase.specialized.xbaseSpecialized.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XbaseSpecializedFactoryImpl extends EFactoryImpl implements XbaseSpecializedFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XbaseSpecializedFactory init()
  {
    try
    {
      XbaseSpecializedFactory theXbaseSpecializedFactory = (XbaseSpecializedFactory)EPackage.Registry.INSTANCE.getEFactory(XbaseSpecializedPackage.eNS_URI);
      if (theXbaseSpecializedFactory != null)
      {
        return theXbaseSpecializedFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XbaseSpecializedFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XbaseSpecializedFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case XbaseSpecializedPackage.MODEL: return createModel();
      case XbaseSpecializedPackage.DOWN: return createDown();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Down createDown()
  {
    DownImpl down = new DownImpl();
    return down;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XbaseSpecializedPackage getXbaseSpecializedPackage()
  {
    return (XbaseSpecializedPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XbaseSpecializedPackage getPackage()
  {
    return XbaseSpecializedPackage.eINSTANCE;
  }

} //XbaseSpecializedFactoryImpl