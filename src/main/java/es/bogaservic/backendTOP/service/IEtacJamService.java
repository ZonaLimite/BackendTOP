/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.service;

import java.util.List;

import es.bogaservic.backendTOP.models.FaultsTwoFields;

/**
 *
 * @author DevelopePC
 */
interface IEtacJamService {
    public List<FaultsTwoFields> findEtacJamGroupBy(String center, String maquina, String fecha, String hora, String turno, String programa);
}
