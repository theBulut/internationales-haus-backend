package com.international_house.backend.service;

import com.international_house.backend.domain.Information;
import com.international_house.backend.repos.InformationRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationService {

    private final InformationRepository informationRepository;

    public InformationService(InformationRepository InformationRepository) {
        this.informationRepository = InformationRepository;
    }

    public List<Information> getInformations() {
        return informationRepository.findAll();
    }

    @Transactional
    public Optional<Information> getInformation(String language) {
        return informationRepository.findByLanguage(language);
    }

    @Transactional
    public void updateInformation(String language, Information update) {
        Optional<Information> info = informationRepository.findByLanguage(language);

        if (info.isPresent()) {
            info.get().setContent(update.getContent());
            informationRepository.save(info.get());
        } else {
            update.setLanguage(language);
            informationRepository.save(update);
        }

    }
}
