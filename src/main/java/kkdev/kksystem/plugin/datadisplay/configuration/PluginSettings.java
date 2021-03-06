/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.datadisplay.configuration;

import kkdev.kksystem.base.classes.plugins.simple.SettingsManager;

/**
 *
 * @author blinov_is
 */
public abstract class PluginSettings  {

    public static String DATADISPLAY_CONF;
    public static DataDisplayConfig MainConfiguration;
  
    public static void InitSettings(String GlobalConfigUID,String MyUID)
    {
        DATADISPLAY_CONF=GlobalConfigUID+"_"+MyUID+".json";

        SettingsManager settings = new SettingsManager(DATADISPLAY_CONF, DataDisplayConfig.class);
        
        MainConfiguration=(DataDisplayConfig) settings.loadConfig();
        
        if (MainConfiguration==null)
        {
            System.out.println("[DataDisplay][CONFIG] Error, create default config");
            settings.saveConfig(kk_DefaultConfig.MakeDefaultConfig());
            System.out.println("[DataDisplay][CONFIG] Load default config");
             MainConfiguration=(DataDisplayConfig) settings.loadConfig();
        }
        if (MainConfiguration==null)
        {
            System.out.println("[DataDisplay][CONFIG] Config load error, fatal");
            return;
        }

    }
}
