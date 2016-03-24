package uk.gov.gds.locate.api.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

    @JsonProperty("appName")
    private String appName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("organisation")
    private String organisation;
    @JsonProperty("psma")
    private String psma;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String appName, String name, String email, String organisation, String psma) {
        this.appName = appName;
        this.name = name;
        this.email = email;
        this.organisation = organisation;
        this.psma = psma;
    }

    public String getAppName() {
        return appName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getPSMA() {
        return psma;
    }

}
