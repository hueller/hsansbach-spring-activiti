package de.hsansbach.wif.ebusiness.process;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hsansbach.wif.ebusiness.process.service.ProcessRuntimeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:process-context.xml")
public class SimpleProcessTest {
    
    private static final Log LOG = LogFactory.getLog(SimpleProcessTest.class);

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private ProcessRuntimeService processRuntimeService;

    @Before
    public void printSomeDebugInformation() {
        LOG.info("About to print some debug information");
        for (ProcessDefinition processDefinition : repositoryService.createProcessDefinitionQuery().list()) {
            LOG.info("Found the process with the id: " + processDefinition.getId());
        }
    }

    @Test
    public void testProcess() {
        processRuntimeService.startSimpleTestProcess();
        
        Assert.assertEquals(0, runtimeService.createProcessInstanceQuery().count());
    }

}