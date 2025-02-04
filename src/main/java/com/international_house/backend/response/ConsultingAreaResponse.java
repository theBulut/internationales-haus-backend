package com.international_house.backend.response;
import lombok.Data;
import java.util.List;

@Data
public class ConsultingAreaResponse {
    private String consultingAreaName;
    private List<ConsultationHourResponse> consultationHours;
}
