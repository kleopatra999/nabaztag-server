package net.violet.platform.api.actions.applications;

import net.violet.platform.api.actions.ActionParam;
import net.violet.platform.api.exceptions.APIException;
import net.violet.platform.api.exceptions.InvalidParameterException;
import net.violet.platform.api.exceptions.NoSuchApplicationException;
import net.violet.platform.api.exceptions.NoSuchObjectException;
import net.violet.platform.api.maps.applications.ApplicationInformationMap;
import net.violet.platform.dataobjects.ApplicationData;
import net.violet.platform.util.Constantes;

public class GetInfo extends AbstractApplicationAction {

	/**
	 * Returns information about this application : returned key values are :
	 * id, name, owner, supported_hardware, creation_date
	 * 
	 * @throws NoSuchApplicationException
	 * @throws InvalidParameterException
	 * @throws APIException
	 * @throws NoSuchObjectException if the requested object could not be found.
	 * @see net.violet.platform.api.actions.Action#processRequest(java.util.Map)
	 */
	@Override
	protected Object doProcessRequest(ActionParam inParam) throws InvalidParameterException, NoSuchApplicationException {

		final ApplicationData theApplication = getRequestedApplication(inParam, null);

		return new ApplicationInformationMap(inParam.getCaller(), theApplication);
	}

	/**
	 * Read Only action
	 * 
	 * @see net.violet.platform.api.actions.Action#getType()
	 */
	public ActionType getType() {
		return ActionType.GET;
	}

	/**
	 * YES ! this information may be cached !
	 * 
	 * @see net.violet.platform.api.actions.Action#isCacheable()
	 */
	public boolean isCacheable() {
		return true;
	}

	/**
	 * Cached information expires after one day
	 * 
	 * @see net.violet.platform.api.actions.Action#getExpirationTime()
	 */
	public long getExpirationTime() {
		return Constantes.ONE_DAY_IN_S;
	}
}
