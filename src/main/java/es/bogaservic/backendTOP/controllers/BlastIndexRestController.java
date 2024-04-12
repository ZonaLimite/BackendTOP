/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.controllers;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.StartOfRecordingSession;
import es.bogaservic.backendTOP.service.StartOfRecordingSessionService;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 *
 * @author F.J. BOGA
 */
@RestController
@RequestMapping("/mis")
public class BlastIndexRestController {

    @Autowired
    private StartOfRecordingSessionService SORS_Service;

    @GetMapping("/sessions")
    List<StartOfRecordingSession> findAll() {
        return SORS_Service.findAll();
    }

    @GetMapping("/sessions/custom")
    List<StartOfRecordingSession> findByDate(@RequestParam(name = "fecha") String sFecha) {
        System.out.println("depurada fecha "+ sFecha);
        return SORS_Service.findByDate(sFecha);
    }

    //Configuracon Excepciones
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleNoResourceFoundException(
            Exception exception
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

}