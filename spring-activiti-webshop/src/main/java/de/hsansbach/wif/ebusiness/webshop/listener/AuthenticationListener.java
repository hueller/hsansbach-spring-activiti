package de.hsansbach.wif.ebusiness.webshop.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsansbach.wif.ebusiness.webshop.NavigationHelper.NavigationKey;
import de.hsansbach.wif.ebusiness.webshop.bean.UserBean;

public class AuthenticationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationListener.class);

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {
	}

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		FacesContext facesContext = phaseEvent.getFacesContext();
		if (!isRootDirectory(facesContext) && !isUserLoggedIn(facesContext)) {
			// User tries to access a protected directory but is not logged in, so redirect to login page.
			LOG.warn("User is not allowed to view page. Redirecting to '{}'.", NavigationKey.LOGIN.getFileName());
			facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, NavigationKey.LOGIN.getFileName());
		}
	}

	private boolean isRootDirectory(FacesContext facesContext) {
		return facesContext.getViewRoot().getViewId().split("/").length > 2 ? false : true;
	}

	private boolean isUserLoggedIn(FacesContext facesContext) {
		UserBean userBean = (UserBean) facesContext.getApplication().evaluateExpressionGet(facesContext, "#{userBean}", UserBean.class);
		return userBean != null && userBean.getUsername() != null && userBean.getUsername().length() > 0;
	}
	
}