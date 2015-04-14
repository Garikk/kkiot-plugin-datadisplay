/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.datadisplay.displaymanager;

import kkdev.kksystem.base.classes.PluginMessage;


/**
 *
 * @author blinov_is
 */
public interface IProcessorConnector {
    
    public void Init();
    public void Connect();
    public void Disconnect();
    public void ExecPIN(PluginMessage PMessage);
            
}