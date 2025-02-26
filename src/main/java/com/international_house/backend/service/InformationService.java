package com.international_house.backend.service;

import com.international_house.backend.entity.Information;
import jakarta.transaction.Transactional;

import java.util.List;

public interface InformationService {
    @Transactional
    Information getInformation(String language);

    List<Information> getInformations();

    @Transactional
    void updateInformation(String language, Information update);
}
