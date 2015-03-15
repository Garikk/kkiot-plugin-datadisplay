/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.datadisplay.displaymanager;

import java.util.HashMap;
import kkdev.kksystem.base.classes.PluginMessage;
import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.DisplayConstants.KK_DISPLAY_COMMAND;
import kkdev.kksystem.base.classes.display.DisplayConstants.KK_DISPLAY_DATA;
import kkdev.kksystem.base.classes.display.DisplayInfo;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.plugin.datadisplay.KKPlugin;

/**
 *
 * @author blinov_is
 */
public abstract class DisplayManager {
   
    static KKPlugin Connector;
      
    public  static void  InitDisplayManager(KKPlugin Conn)
    {
        Connector=Conn;
        //
    }
    
    public static void Start()
    {
        ActivateDisplayPage("MAIN");   
    }
  
    public static void debug_SendWelcomeText(String PageID, String text)
    {
        String[] Txt=new String[1];
        Txt[0]=text;
        //
        PinLedData PD=new PinLedData();
        PD.DataType=DisplayConstants.KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT;
        PD.TargetPage=PageID;
        PD.DisplayText=Txt;
        //
        
       Connector.SendPluginMessageData(KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT,PD); 
    }
    
    
    private static void ActivateDisplayPage(String PageID)
    {
        // In the future, these functions must be implemented scripts
        //
        String[] Data_S=new String[1];
        Data_S[0]=PageID;
        //
        //Init main page
       Connector.SendPluginMessageCommand(KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_INIT, Data_S, null, null);
       // Set page to active
       Connector.SendPluginMessageCommand(KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE, Data_S, null, null);
       // Send Hello world
       debug_SendWelcomeText(PageID,"Hello World!");
    }
    ///////////////////
    ///////////////////
    public static void RecivePin(PluginMessage Msg)
    {
        switch (Msg.PinName)
        { case PluginConsts.KK_PLUGIN_PIN_LED_COMMAND:
                PinLedCommand CMD;
                CMD=(PinLedCommand)Msg.PinData;
                ProcessCommand(CMD);
                break;
            case PluginConsts.KK_PLUGIN_PIN_LED_DATA:
                PinLedData DAT;
                DAT=(PinLedData)Msg.PinData;
                ProcessData(DAT);
                break;
        }
    }
    ///////////////////
    ///////////////////
    public static void ProcessCommand(PinLedCommand Command)
    {
        
    }
    public static void ProcessData(PinLedData Data)
    {
        
        switch (Data.DataType)
        {
            case DISPLAY_KKSYS_DISPLAY_STATE:
               // UpdateDisplayState(Data.DisplayState);
                break;
        }
    }
}