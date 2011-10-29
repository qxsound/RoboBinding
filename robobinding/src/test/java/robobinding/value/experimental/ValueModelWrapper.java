package robobinding.value.experimental;

import java.beans.PropertyChangeListener;

import robobinding.property.PropertyValueModel;
import robobinding.utils.Validate;

/**
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 *
 */
public class ValueModelWrapper<T> implements PropertyValueModel<T>
{
	private PropertyValueModel<T> forwarding;
	public ValueModelWrapper(PropertyValueModel<T> source)
	{
		Validate.notNull(source);
		
		this.forwarding = source;
	}
	@Override
	public void addValueChangeListener(PropertyChangeListener listener)
	{
		forwarding.addValueChangeListener(listener);
	}
	@Override
	public T getValue()
	{
		return forwarding.getValue();
	}
	@Override
	public void removeValueChangeListener(PropertyChangeListener listener)
	{
		forwarding.removeValueChangeListener(listener);
	}
	@Override
	public void setValue(T newValue) 
	{
		forwarding.setValue(newValue);
	}
	protected PropertyValueModel<T> getForwarding()
	{
		return forwarding;
	}
}