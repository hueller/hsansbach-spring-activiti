package de.hsansbach.wif.ebusiness.webshop.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import de.hsansbach.wif.ebusiness.process.ProcessKey;
import de.hsansbach.wif.ebusiness.process.service.ActivitiProcessService;
import de.hsansbach.wif.ebusiness.webshop.NavigationHelper;
import de.hsansbach.wif.ebusiness.webshop.NavigationHelper.NavigationKey;

@Named
@Scope("request")
public class ProcessBean {

	private String processInstanceId;

	@Inject
	private NavigationHelper navigationHelper;

	@Inject
	private ActivitiProcessService activitiProcesService;

	public String startSimpleTestProcess() {
		this.processInstanceId = activitiProcesService.startProcess(ProcessKey.SIMPLE_TEST);
		return navigationHelper.navigateTo(NavigationKey.PROCESS_RESULT);
	}

	public String startUserConfirmationTestProcess() {
		this.processInstanceId = activitiProcesService.startProcess(ProcessKey.USER_CONFIRMATION_TEST);
		return navigationHelper.navigateTo(NavigationKey.PROCESS_RESULT);
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

}