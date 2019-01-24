// 
// Decompiled by Procyon v0.5.30
// 

package com.unigrative.plugins.reelSupport;

import com.unigrative.plugins.reelSupport.exception.FishbowlException;
import com.unigrative.plugins.reelSupport.fbapi.ApiCaller;
import com.unigrative.plugins.reelSupport.repository.Repository;
import com.unigrative.plugins.reelSupport.util.property.PropertyGetter;
import com.evnt.client.common.EVEManager;
import com.evnt.client.common.EVEManagerUtil;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.fbi.fbo.message.response.ResponseBase;
import com.fbi.fbo.message.request.RequestBase;
import com.fbi.fbo.impl.ApiCallType;

import com.fbi.fbo.impl.dataexport.QueryRow;

import java.util.List;

import com.fbi.sdk.constants.MenuGroupNameConst;
import com.fbi.gui.button.FBMainToolbarButton;

import com.fbi.gui.panel.TitlePanel;
import org.slf4j.Logger;
import com.fbi.plugins.FishbowlPlugin;

public class REELSupportPlugin extends FishbowlPlugin implements PropertyGetter, Repository.RunSql, ApiCaller
{
    private static final String PLUGIN_SETTINGS_PANEL = "pluginSettings";

    private static final Logger LOGGER;
    private Repository repository;

    private JPanel pnlCards;
    private SettingsPanel settingsPanel;
    private JToolBar mainToolBar;
    private FBMainToolbarButton btnSave;

    EVEManager eveManager = EVEManagerUtil.getEveManager(); //get access to eve manager

    private TitlePanel label1;

    public REELSupportPlugin() {

        this.repository = new Repository(this);
        this.setModuleName("REEL Support");

        //this.setMenuListLocation(4);
        this.setMenuGroup(MenuGroupNameConst.INTEGRATIONS);
        this.setMenuListLocation(1000); //bottom of the list
        this.setIconClassPath("/images/customerPlus48.png"); // make sure there is a 24 version in the folder so it can use that for the tabs

        //this.addAccessRight("Import Button");

        LOGGER.info("Ctor done");
    }

    protected void initModule() {
        LOGGER.info("initModule called");

        super.initModule();
        try {
            this.initComponents();
            LOGGER.info("Made it after the InitComponents method");
            this.setMainToolBar(this.mainToolBar);
            this.initLayout();
            LOGGER.info("Made it after the initLayout method");
        }
        catch (Exception e){
            LOGGER.error("Error on init",e);
        }

    }

    private void initLayout() {
        this.settingsPanel = new SettingsPanel(this);
        this.pnlCards.add(this.settingsPanel, PLUGIN_SETTINGS_PANEL);
        this.hideShowPanels();
    }

    public String getModuleTitle() {
        return "<html><center>REEL<br>Support</center></html>";
    }

    public int getObjectId() {
        return 1;
    }
    
    public void loadData(final int objectId) {
//        if (this.pnlBrowserSettings == null) {
//            return;
//        }
//        this.hideShowPanels();
//        this.pnlBrowserSettings.reload();
    }
    

    
    void hideShowPanels() {
        final CardLayout layout = (CardLayout)this.pnlCards.getLayout();

        this.enableControls(true);
        layout.show(this.pnlCards, PLUGIN_SETTINGS_PANEL);
    }
    
    private void enableControls(final boolean enable) {
        this.btnSave.setEnabled(enable);
        //this.btnSync.setEnabled(enable);
        //this.btnBack.setEnabled(enable);
        //this.btnForward.setEnabled(enable);
    }
    

    void saveProperties(final String username, final String password) {
//        try {
//            final String encryptedUsername = CommerceUtil.encrypt(username);
//            final String encryptedPassword = CommerceUtil.encrypt(password);
//            final Map<String, String> properties = new HashMap<String, String>();
//            properties.put(Property.USERNAME.getKey(), encryptedUsername);
//            properties.put(Property.PASS.getKey(), encryptedPassword);
//            this.savePluginProperties((Map)properties);
//        }
//        catch (CommerceException e) {
//            __Plugin.LOGGER.error("Can't save", (Throwable)e);
//            final String message = "Unable to save your ShipExpress integration.";
//            UtilGui.showMessageDialog(message, "Save Error", 1);
//        }
    }


    public String getProperty(final String key) {
        return this.repository.getProperty(key);
    }
    
    public List<QueryRow> executeSql(final String query) {
        return (List<QueryRow>)this.runQuery(query);
    }
    
    private void btnSaveActionPerformed() {
        this.settingsPanel.saveSettings();

    }
    
//    private void createScheduledTask(final String name, final Class clazz, final String cron) {
//        try {
//            if (this.getScheduledTask(name) == null) {
//                final FBSchedule schedule = this.createSchedule(name, "DO NOT DELETE", clazz, "", cron);
//                this.updateScheduledTask(schedule);
//            }
//        }
//        catch (Exception e) {
//            CustomerAddonsPlugin.LOGGER.error(e.getMessage(), (Throwable)e);
//            throw new IllegalStateException(e);
//        }
//    }

    
//    private ImportRequest createImportRequest(final Map<String, List<String>> servicesToAdd, final List<QueryRow> carriersAndServices, final String fbFedEx, final String fbFedExDesc, final String fbUsps, final String fbUspsDesc, final String fbUps, final String fbUpsDesc) {
//        final ArrayList<String> importRows = new ArrayList<String>();
//        final StringRowData headerRow = new StringRowData(IECarrierImpl.defaultHeader);
//        importRows.add(headerRow.toString());
//        Integer carrierId = carriersAndServices.get(0).getInt("carrierId");
//        for (final Map.Entry<String, List<String>> entry : servicesToAdd.entrySet()) {
//            for (final String service : entry.getValue()) {
//                final StringRowData dataRow = new StringRowData(IECarrierImpl.defaultHeader);
//                dataRow.setColumnNames(headerRow);
//                dataRow.set("Name", this.getCarrierName(entry.getKey(), fbFedEx, fbUsps, fbUps));
//                dataRow.set("ServiceName", service);
//
//                final String s = "ServiceCode";
//
//                final String carrierName = entry.getKey();
//                final Integer n = carrierId;
//                ++carrierId;
//                dataRow.set(s, this.getServiceCode(service, carrierName, n));
//                dataRow.set("Active", Boolean.TRUE.toString());
//                dataRow.set("ServiceActive", Boolean.TRUE.toString());
//                Compatibility.setCarrierDescription(this.repository, dataRow, entry.getKey(), fbFedExDesc, fbUspsDesc, fbUpsDesc);
//                importRows.add(dataRow.toString());
//            }
//        }
//        final ImportRequest importRequest = (ImportRequest)new ImportRequestImpl();
//        importRequest.setImportType("ImportCarriers");
//        importRequest.setRows((ArrayList)importRows);
//        return importRequest;
//    }

    
//    void enableBack(final boolean browserIsShowing) {
//        this.btnBack.setEnabled(browserIsShowing);
//    }
//
//    void enableForward(final boolean browserIsShowing) {
//        this.btnForward.setEnabled(browserIsShowing);
//    }

    public ResponseBase call(final ApiCallType requestType, final RequestBase requestBase) throws FishbowlException {
        try {
            return this.runApiRequest(requestType, requestBase);
        }
        catch (Exception e) {
            throw new FishbowlException(e);
        }
    }

    private void initComponents() {
        try {
            this.label1 = new TitlePanel();
            this.pnlCards = new JPanel();
            this.mainToolBar = new JToolBar();
            this.btnSave = new FBMainToolbarButton();

            this.setName("this");
            this.setLayout((LayoutManager) new GridBagLayout());
            ((GridBagLayout) this.getLayout()).columnWidths = new int[]{0, 0};
            ((GridBagLayout) this.getLayout()).rowHeights = new int[]{0, 0, 0};
            ((GridBagLayout) this.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
            ((GridBagLayout) this.getLayout()).rowWeights = new double[]{0.0, 1.0, 1.0E-4};
            this.label1.setModuleIcon((Icon) new ImageIcon(this.getClass().getResource("/images/customerPlus32.png")));
            this.label1.setModuleTitle("REEL Support");
            this.label1.setBackground(new Color(44, 94, 140));
            this.label1.setName("label1");
            this.add((Component) this.label1, (Object) new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
            this.pnlCards.setName("pnlCards");
            this.pnlCards.setLayout(new CardLayout());
            this.add((Component) this.pnlCards, (Object) new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
            this.mainToolBar.setFloatable(false);
            this.mainToolBar.setRollover(true);
            this.mainToolBar.setName("mainToolBar");

            this.btnSave.setIcon((Icon) new ImageIcon(this.getClass().getResource("/icon24/filesystem/disks/disk_gold.png")));
            this.btnSave.setText("Save");
            this.btnSave.setToolTipText("Save your REEL Support settings.");
            this.btnSave.setHorizontalTextPosition(0);
            this.btnSave.setIconTextGap(0);
            this.btnSave.setMargin(new Insets(0, 2, 0, 2));
            this.btnSave.setName("btnSave");
            this.btnSave.setVerticalTextPosition(3);
            this.btnSave.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    REELSupportPlugin.this.btnSaveActionPerformed();
                }
            });
            this.mainToolBar.add((Component) this.btnSave);
        }
        catch (Exception e){
            LOGGER.error("Error in init",e);
        }
        LOGGER.info("init done");
        }


    static {
        LOGGER = LoggerFactory.getLogger((Class)REELSupportPlugin.class);
    }
}
