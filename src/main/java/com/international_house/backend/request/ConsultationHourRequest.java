package com.international_house.backend.request;

import lombok.*;

import java.time.LocalDateTime;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class ConsultationHourRequest {
    private String areaName;             // Refers to ConsultingArea by name
    private LocalDateTime startTime;     // Start time of consultation
    private LocalDateTime endTime;       // End time of consultation
    private String explanation;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    // Optional description/explanation
}
