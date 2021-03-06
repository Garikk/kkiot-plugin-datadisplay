/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.datadisplay;


import kkdev.kksystem.base.classes.plugins.PluginInfo;
import kkdev.kksystem.base.classes.plugins.simple.IPluginInfoRequest;
import kkdev.kksystem.base.constants.PluginConsts;

/**
 *
 * @author blinov_is
 */
public class DataProcessorInfo implements IPluginInfoRequest  {
    @Override
    public PluginInfo getPluginInfo()
    {
        PluginInfo Ret=new PluginInfo();
        Ret.PluginUUID="b5b50412-c02a-4674-a112-ddc5805ea4e5";
        Ret.PluginName="KKDataDisplay";
        Ret.PluginDescription="Data processor for display";
        Ret.PluginVersion=1;
        Ret.Enabled=true;
        Ret.ReceivePins = GetMyReceivePinInfo();
        Ret.TransmitPins = GetMyTransmitPinInfo();
        return Ret;
    }
    
    
    private String[] GetMyReceivePinInfo(){
        // Receive Global system commands
        // Receive ODB2 Data
        // Receive RAW ODB2 Data
        // Receive LED Display Data (Resolution... etc)
        
        String[] Ret=new String[4];
    
        Ret[0]=PluginConsts.KK_PLUGIN_BASE_PIN_COMMAND;
        Ret[1]=PluginConsts.KK_PLUGIN_BASE_ODB2_DATA;
        Ret[2]=PluginConsts.KK_PLUGIN_BASE_ODB2_RAW;
        Ret[3]=PluginConsts.KK_PLUGIN_BASE_LED_DATA;
        
        return Ret;
    }
    private  String[] GetMyTransmitPinInfo(){
        // Transmit commands to ODB2 module
        // Transmit commands to LED Display
        // Transmit processed data to LED Display
        //
        String[] Ret=new String[4];
    
        Ret[0]=PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
        Ret[1]=PluginConsts.KK_PLUGIN_BASE_LED_COMMAND;
        Ret[2]=PluginConsts.KK_PLUGIN_BASE_LED_DATA;
         Ret[3]=PluginConsts.KK_PLUGIN_BASE_NOTIFY_DATA;
        
        return Ret;
    }
    
}
