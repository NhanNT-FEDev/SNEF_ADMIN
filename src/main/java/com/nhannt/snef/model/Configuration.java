package com.nhannt.snef.model;

public class Configuration {
    private int configurationId;
    private String configurationName;
    private String configurationValue;

    public Configuration() {
    }

    public Configuration(int configurationId, String configurationName, String configurationValue) {
        this.configurationId = configurationId;
        this.configurationName = configurationName;
        this.configurationValue = configurationValue;
    }

    public Configuration(String configurationName, String configurationValue) {
        this.configurationName  = configurationName;
        this.configurationValue = configurationValue;
    }

    public int getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(int configurationId) {
        this.configurationId = configurationId;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }
}
