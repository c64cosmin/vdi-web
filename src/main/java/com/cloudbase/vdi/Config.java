package com.cloudbase.vdi;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    private static String authUrl = null;
    private static String projectDomainName = null;
    private static String projectName = null;
    private static String userDomainName = null;

    public static String getAuthUrl() {
        if (authUrl == null)
            Config.readConfig();
        return Config.authUrl;
    }

    public static String getProjectDomainName() {
        if (projectDomainName == null)
            Config.readConfig();
        return Config.projectDomainName;
    }

    public static String getProjectName() {
        if (projectName == null)
            Config.readConfig();
        return Config.projectName;
    }

    public static String getUserDomainName() {
        if (userDomainName == null)
            Config.readConfig();
        return Config.userDomainName;
    }

    public static void readConfig() {
        JSONObject json = null;
        try {
            json = new JSONObject(Utility.readFile("/etc/vdi-web/vdi-client.json"));
            authUrl = json.getString("auth-url");
            projectName = json.getString("project-name");
            userDomainName = json.getString("user-domain-name");
            projectDomainName = json.getString("project-domain-name");
        } catch (JSONException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
