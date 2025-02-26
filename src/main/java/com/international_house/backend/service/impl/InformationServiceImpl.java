package com.international_house.backend.service.impl;

import com.international_house.backend.entity.Information;
import com.international_house.backend.repository.InformationRepository;
import com.international_house.backend.service.InformationService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;

    public List<Information> getInformations() {
        return informationRepository.findAll();
    }

    @Transactional
    public Information getInformation(String language) {
        return informationRepository.findByLanguage(language)
                .orElseThrow(() -> new EntityNotFoundException("Information not found with language: " + language));
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
