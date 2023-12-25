package com.neomodeon.mailtracker.services;

import com.neomodeon.mailtracker.entities.PostOffice;
import com.neomodeon.mailtracker.repositories.PostOfficeRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;


    public PostOfficeService(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    public List<PostOffice> getAllPostOffices() {
        return postOfficeRepository.findAll();
    }

    public PostOffice getPostOfficeById(Long postOfficeId) {
        return postOfficeRepository.findById(postOfficeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Почтовое отделение с ID: " + postOfficeId + " не найдено!"
                ));
    }

    public PostOffice createPostOffice(PostOffice postOffice) {
        return postOfficeRepository.save(postOffice);
    }
}
