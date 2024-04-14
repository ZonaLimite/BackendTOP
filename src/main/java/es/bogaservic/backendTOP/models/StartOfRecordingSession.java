/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.models;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author F.J. BOGA
 */
@Data
public class StartOfRecordingSession implements Serializable{

    String nid;
    String smachinetype;
    int icenterid;
    int imachineid;
    String ddate;
    String htime;
    String sfulltime;
    int isessionnumber;
    String sevent;
    int iniveauexploit;
    String sshift;
    String sexploitationplan;

    public StartOfRecordingSession() {
    }
    
    
    public StartOfRecordingSession(String nID, String sMachineType, int iCenterId, int iMachineId, String dDate, String hTime, String sFullTime, int iSessionNumber, String sEvent, int iNiveauExploit, String sShift,String sExploitationPlan) {
        this.nid = nID;
        this.smachinetype = sMachineType;
        this.icenterid = iCenterId;
        this.imachineid = iMachineId;
        this.ddate = dDate;
        this.htime = hTime;
        this.sfulltime = sFullTime;
        this.isessionnumber = iSessionNumber;
        this.sevent = sEvent;
        this.iniveauexploit = iNiveauExploit;
        this.sshift=sShift;
        this.sexploitationplan=sExploitationPlan;
    
    }

    @Override
    public String toString() {
        return String.format(
                "STARTOFRECORDINGSESSION[nId=%d, sMachineType='%s', iCenterId=%d, iMachineId=%d, dDate='%s', hTime='%s', sFullTime='%s', iSessionNumber=%d, sEvent='%s', iNiveauExploit=%d, sShift='%s', sExploitationPlan='%s']",
                nid, smachinetype, icenterid, imachineid, ddate, htime, sfulltime, isessionnumber, sevent, iniveauexploit, sshift, sexploitationplan);
    }

}
