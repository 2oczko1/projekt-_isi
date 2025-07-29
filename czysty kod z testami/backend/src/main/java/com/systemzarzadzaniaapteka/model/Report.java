package com.systemzarzadzaniaapteka.model;

import java.time.LocalDateTime;

public class Report {
    private Long id;
    private String type;
    private String content;
    private LocalDateTime generatedAt;

    public Report() {}

    public Report(Long id, String type, String content, LocalDateTime generatedAt) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.generatedAt = generatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
