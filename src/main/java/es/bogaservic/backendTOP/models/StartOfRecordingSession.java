/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.models;

import lombok.Data;

/**
 *
 * @author F.J. BOGA
 */
@Data
public class StartOfRecordingSession {

    String nID;
    String sMachineType;
    int iCenterId;
    int iMachineId;
    String dDate;
    String hTime;
    String sFullTime;
    int iSessionNumber;
    String sEvent;
    int iNiveauExploit;
    String sShift;
    String sExploitationPlan;

    public StartOfRecordingSession() {
    }
    
    
    public StartOfRecordingSession(String nID, String sMachineType, int iCenterId, int iMachineId, String dDate, String hTime, String sFullTime, int iSessionNumber, String sEvent, int iNiveauExploit, String sShift,String sExploitationPlan) {
        this.nID = nID;
        this.sMachineType = sMachineType;
        this.iCenterId = iCenterId;
        this.iMachineId = iMachineId;
        this.dDate = dDate;
        this.hTime = hTime;
        this.sFullTime = sFullTime;
        this.iSessionNumber = iSessionNumber;
        this.sEvent = sEvent;
        this.iNiveauExploit = iNiveauExploit;
        this.sShift=sShift;
        this.sExploitationPlan=sExploitationPlan;
    
    }
    
    

    @Override
    public String toString() {
        return String.format(
                "STARTOFRECORDINGSESSION[nId=%d, sMachineType='%s', iCenterId=%d, iMachineId=%d, dDate='%s', hTime='%s', sFullTime='%s', iSessionNumber=%d, sEvent='%s', iNiveauExploit=%d, sShift='%s', sExploitationPlan='%s']",
                nID, sMachineType, iCenterId, iMachineId, dDate, hTime, sFullTime, iSessionNumber, sEvent, iNiveauExploit, sShift, sExploitationPlan);
    }

}
