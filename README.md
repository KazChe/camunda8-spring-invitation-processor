
inspired by Get Started with Started Camunda 8 Docs
https://docs.camunda.io/docs/next/guides/getting-started-java-spring/

JDK 21
Spring Boot latest non-snapshot
Camunda Modeler
Camunda Run
used `camunda8-run-8.7.0-alpha1-darwin-x86_64.tar.gz` for local install of Camunda Run 8.7.0-alpha1
- took a while to find the right version

```bash
c8run % ./start.sh 
```

should see the following output:

```bash
Camunda has successfully been started.

-------------------------------------------
Access each component at the following urls:

Operate:                     http://localhost:8080/operate
Tasklist:                    http://localhost:8080/tasklist
Zeebe Cluster Endpoint:      http://localhost:26500
Inbound Connectors Endpoint: http://localhost:8085

When using the Desktop Modeler, Authentication may be set to None.
```

[When COnfiguring the Zeenbe client](https://docs.camunda.io/docs/next/guides/getting-started-java-spring/#configure-the-zeebe-client)
```yaml
camunda:
  client:
    mode: self-managed
    zeebe:
      enabled: true
      grpc-address: http://127.0.0.1:26500
      rest-address: http://127.0.0.1:8080
```

and using a .properties file insteadof yaml then use:

```
camunda.client.mode=selfmanaged
camunda.client.zeebe.enabled=true
camunda.client.zeebe.grpc-address=http://127.0.0.1:26500
camunda.client.zeebe.rest-address=http://127.0.0.1:8080
```
