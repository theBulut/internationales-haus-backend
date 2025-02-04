package com.international_house.backend.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultationHourResponse {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String explanation;
}
