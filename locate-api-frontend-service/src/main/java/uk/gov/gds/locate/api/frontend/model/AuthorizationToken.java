package uk.gov.gds.locate.api.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongojack.ObjectId;

public class AuthorizationToken {

    @JsonProperty("_id")
    @ObjectId
    private String id;

    @JsonProperty("appName")
    private String appName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("organisation")
    private String organisation;

    @JsonProperty("psma")
    private String psma;

    @JsonProperty("token")
    private String token;

    public AuthorizationToken() {
    }

    public AuthorizationToken(String id, String appName, String name, String identifier, String organisation, String psma, String token) {
        this.id = id;
        this.appName = appName;
        this.name = name;
        this.identifier = identifier;
        this.organisation = organisation;
        this.psma = psma;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public String getAppName() {
        return appName;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getPSMA() {
        return psma;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "AuthorizationToken{" +
                "id='" + id + '\'' +
                ", appName='" + appName + '\'' +
                ", name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                ", organisation='" + organisation + '\'' +
                ", psma='" + psma + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}