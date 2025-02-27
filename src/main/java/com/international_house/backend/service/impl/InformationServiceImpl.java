package com.international_house.backend.service.impl;

import com.international_house.backend.entity.Information;
import com.international_house.backend.repository.InformationRepository;
import com.international_house.backend.service.InformationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;

    public List<Information> getInformations() {
        return informationRepository.findAll();
    }

    @Transactional
    public Information getInformation(String language) {
        if (informationRepository.findByLanguage(language).isPresent())
            return informationRepository.findByLanguage(language).get();
        else
            return new Information();
    }

    @Transactional
    public void updateInformation(String language, Information update) {
        update.setLanguage(language);
        informationRepository.save(update);
    }
}
