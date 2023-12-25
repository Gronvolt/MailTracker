package com.neomodeon.mailtracker.services;

import com.neomodeon.mailtracker.entities.MailShipment;
import com.neomodeon.mailtracker.repositories.MailShipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MailShipmentService {
    private final MailShipmentRepository mailShipmentRepository;


    public MailShipmentService(MailShipmentRepository mailShipmentRepository) {
        this.mailShipmentRepository = mailShipmentRepository;
    }

    public MailShipment registerMailShipment(MailShipment mailShipment) {
        //Регистрация почтового отправления
        return mailShipmentRepository.save(mailShipment);
    }

    public MailShipment arrivalAtPostOffice(Long shipmentId, Long postOfficeId) {
        //его прибытие в промежуточное почтовое отделение
        Optional<MailShipment> optionalMailShipment = mailShipmentRepository.findById(shipmentId);
        if (optionalMailShipment.isPresent()) {
            MailShipment mailShipment = optionalMailShipment.get();
            mailShipment.setStatus("Прибыло в почтовое отделение - " + postOfficeId);
            return mailShipmentRepository.save(mailShipment);
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Почтовое отправление с указанным ID не найдено");
            return null;
        }
    }

    public MailShipment departureFromPostOffice(Long shipmentId) {
        //его убытие из почтового отделении
        Optional<MailShipment> optionalMailShipment = mailShipmentRepository.findById(shipmentId);
        if (optionalMailShipment.isPresent()) {
            MailShipment mailShipment = optionalMailShipment.get();
            mailShipment.setStatus("Убыло из почтового отделения");
            return mailShipmentRepository.save(mailShipment);

        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Почтовое отправление с указанным ID не найдено");
            return null;
        }
    }

    public MailShipment receiveMailShipment (Long shipmentId) {
        //его получение адресатом
        Optional<MailShipment> optionalMailShipment = mailShipmentRepository.findById(shipmentId);
        if (optionalMailShipment.isPresent()) {
            MailShipment mailShipment = optionalMailShipment.get();
            mailShipment.setStatus("Получено адресатом.");
            return mailShipmentRepository.save(mailShipment);

        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Почтовое отправление с указанным ID не найдено");
            return null;
        }

    }
}
