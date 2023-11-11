package io.vicarius.backendswdexam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "security-toolkit")
public class SecurityToolkit {

    @Id
    private String id;
    private String firewall;
    private String antivirus;
    private String networkMonitoring;

    public String getId() {
        return id;
    }

    public String getFirewall() {
        return firewall;
    }

    public String getAntivirus() {
        return antivirus;
    }

    public String getNetworkMonitoring() {
        return networkMonitoring;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirewall(String firewall) {
        this.firewall = firewall;
    }

    public void setAntivirus(String antivirus) {
        this.antivirus = antivirus;
    }

    public void setNetworkMonitoring(String networkMonitoring) {
        this.networkMonitoring = networkMonitoring;
    }
}
