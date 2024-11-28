package io.camunda.kam.process_invites;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;

@SpringBootApplication
@Deployment(resources = "classpath:process_invites.bpmn")
public class ProcessInviteApplication implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(ProcessInviteApplication.class);

    @Autowired
    private ZeebeClient zeebeClient;

    public static void main(String[] args) {
        SpringApplication.run(ProcessInviteApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        var bpmnProcessId = "process-invites";
        var event = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(bpmnProcessId)
                .latestVersion()
                .variables(Map.of("total", 10000))
                .send()
                .join();
        LOG.info("started a process instance: {}", event.getProcessInstanceKey());
    }
}
