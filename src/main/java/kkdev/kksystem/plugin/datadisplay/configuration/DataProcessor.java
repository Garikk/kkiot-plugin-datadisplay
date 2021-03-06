/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.datadisplay.configuration;

import kkdev.kksystem.plugin.datadisplay.displaymanager.IProcessorConnector;

/**
 *
 * @author blinov_is
 */
public class DataProcessor {
    public enum DATADISPLAY_DATAPROCESSORS
    {
        PROC_BASIC_ODB2_DISPLAY,
        PROC_BASIC_ODB2_DEBUG,
        PROC_BASIC_ODB2_CEREADER,
        PROC_BASIC_ODB2_WAIT,
        PROC_BASIC_ODB2_ERROR
    }
    
    public String ProcessorName;
    public DATADISPLAY_DATAPROCESSORS ProcessorType;
    public IProcessorConnector Processor;
    public InfoPage[] Pages;
}
