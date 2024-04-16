/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.controllers;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.FaultsTwoFields;
import es.bogaservic.backendTOP.models.StartOfRecordingSession;
import es.bogaservic.backendTOP.service.EmptyTrayInsertedFaultService;
import es.bogaservic.backendTOP.service.EtacJamService;
import es.bogaservic.backendTOP.service.StartOfRecordingSessionService;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author F.J. BOGA
 */
@RestController
@RequestMapping("/api")
public class BlastIndexRestController {

    @Autowired
    private StartOfRecordingSessionService SORS_Service;
    
    @Autowired 
    private EmptyTrayInsertedFaultService ETIF_Service;
    
    @Autowired
    private EtacJamService EJ_Service;

    @GetMapping("/sessions")//StartOfRecordingSessions
    List<StartOfRecordingSession> findByCustomSORS(@RequestParam Map<String,String> queryMap) {
       
        return SORS_Service.findByCustom(queryMap.get("center"),queryMap.get("maquina") ,queryMap.get("fecha") ,queryMap.get("hora") ,queryMap.get("turno") ,queryMap.get("programa"));
    }
    
    @GetMapping("/faults/etif")//EmptyTrayInsertedFault
    List<EmptyTrayInsertedFault> findByCustomETIF(@RequestParam Map<String,String> queryMap) {
       
        return ETIF_Service.findEmptyTrayInsertedFaults(queryMap.get("center"),queryMap.get("maquina") ,queryMap.get("fecha") ,queryMap.get("hora") ,queryMap.get("turno") ,queryMap.get("programa"));
    }
    
    @GetMapping("/faults/etifGroupBy")//EmptyTrayInsertedFaultGroupBy
    List<FaultsTwoFields> findByCustomETIFGroupBy(@RequestParam Map<String,String> queryMap) {
       
        return ETIF_Service.findEmptyTrayInsertedFaultsGroupBy(queryMap.get("center"),queryMap.get("maquina") ,queryMap.get("fecha") ,queryMap.get("hora") ,queryMap.get("turno") ,queryMap.get("programa"));
    }


    @GetMapping("/faults/ejGroupBy")//EtacsJamGroupBy
    List<FaultsTwoFields> findByCustomEJGroupBy(@RequestParam Map<String,String> queryMap) {
       
        return EJ_Service.findEtacJamGroupBy(queryMap.get("center"),queryMap.get("maquina") ,queryMap.get("fecha") ,queryMap.get("hora") ,queryMap.get("turno") ,queryMap.get("programa"));
    }

}
