package com.neomodeon.mailtracker.controllers;

import com.neomodeon.mailtracker.entities.MailShipment;
import com.neomodeon.mailtracker.services.MailShipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mailshipments")
public class MailShipmentController {
    private final MailShipmentService mailShipmentService;


    public MailShipmentController(MailShipmentService mailShipmentService) {
        this.mailShipmentService = mailShipmentService;
    }

    @PostMapping("/createmailshipment")
    public ResponseEntity<MailShipment> registerMailShipment(@RequestBody MailShipment mailShipment) {
        MailShipment createdMailShipment = mailShipmentService.registerMailShipment(mailShipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMailShipment);
    }

    @PutMapping("/{shipmentId}/arrival/{postOfficeId}")
    public ResponseEntity<MailShipment> arrivalAtPostOffice(
            @PathVariable("shipmentId") Long shipmentId,
            @PathVariable("postOfficeId") Long postOfficeId
    ) {
        MailShipment updateMailShipment = mailShipmentService.arrivalAtPostOffice(shipmentId, postOfficeId);
        return ResponseEntity.ok(updateMailShipment);
    }

    @PutMapping("/{shipmentId}/departure")
    public ResponseEntity<MailShipment> departureFromPostOffice(
            @PathVariable("shipmentId") Long shipmentId
    ) {
        MailShipment updateMailShipment = mailShipmentService.departureFromPostOffice(shipmentId);
        return  ResponseEntity.ok(updateMailShipment);
    }

    @PutMapping("/{shipmentId}/receive")
    public ResponseEntity<MailShipment> receiveMailShipment(
            @PathVariable("shipmentId") Long shipmentId
    ) {
        MailShipment updateMailShipment = mailShipmentService.receiveMailShipment(shipmentId);
        return ResponseEntity.ok(updateMailShipment);
    }

}
