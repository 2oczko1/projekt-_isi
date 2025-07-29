package com.systemzarzadzaniaapteka.model;

public class ReportRequest {
    private String type;
    private String parameters; // Mozesz rozbudowac na Map<String, String> jesli potrzeba

    public ReportRequest() {}

    public ReportRequest(String type, String parameters) {
        this.type = type;
        this.parameters = parameters;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getParameters() { return parameters; }
    public void setParameters(String parameters) { this.parameters = parameters; }
}
