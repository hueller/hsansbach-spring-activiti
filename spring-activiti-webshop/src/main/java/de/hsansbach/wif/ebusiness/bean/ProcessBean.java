package de.hsansbach.wif.ebusiness.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import de.hsansbach.wif.ebusiness.bean.NavigationBean.NavigationKey;
import de.hsansbach.wif.ebusiness.process.ProcessKey;
import de.hsansbach.wif.ebusiness.process.service.ActivitiProcessService;

@Named
@RequestScoped
public class ProcessBean {
	
	private String processInstanceId;
	
	@Autowired
	private NavigationBean navigationBean;

	@Autowired
	private ActivitiProcessService activitiProcesService;
	
	public String startSimpleTestProcess() {
		this.processInstanceId = activitiProcesService.startProcess(ProcessKey.SIMPLE_TEST);
		return navigationBean.navigateTo(NavigationKey.PROCESS_RESULT);
	}
	
	public String startUserConfirmationTestProcess() {
		this.processInstanceId = activitiProcesService.startProcess(ProcessKey.USER_CONFIRMATION_TEST);
		return navigationBean.navigateTo(NavigationKey.PROCESS_RESULT);
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

}