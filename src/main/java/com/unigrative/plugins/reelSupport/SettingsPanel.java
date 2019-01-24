package com.unigrative.plugins.reelSupport;

import com.unigrative.plugins.reelSupport.util.property.Property;
import com.fbi.gui.misc.IconTitleBorderPanel;
import com.jidesoft.swing.JideTabbedPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SettingsPanel extends JPanel{

    private static final Logger LOGGER;
    private REELSupportPlugin plugin;
    private JideTabbedPane tbPnlInfo;
    private JTextField txtSqlConnectionUrl  ;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton testConnectionButton;

    public SettingsPanel(final REELSupportPlugin REELSupportPlugin){
        plugin = REELSupportPlugin;
        initComponents();

        this.loadSettings();

    }

    private void loadSettings() {
        LOGGER.info("Loading Settings");
        this.txtSqlConnectionUrl.setText(Property.SQL_CONNECTION_URL.get(this.plugin));
        LOGGER.info(Property.SQL_CONNECTION_URL.get(this.plugin));
        this.txtUsername.setText(Property.USERNAME.get(this.plugin));
        this.txtPassword.setText(Property.PASSWORD.get(this.plugin));

        LOGGER.info("Settings Loaded");

    }

    protected void saveSettings(){
        LOGGER.info("Saving settings");

        final Map<String, String> properties = new HashMap<>();

        properties.put(Property.USERNAME.getKey(), txtUsername.getText());
        properties.put(Property.PASSWORD.getKey(), txtPassword.getText());
        properties.put(Property.SQL_CONNECTION_URL.getKey(), txtSqlConnectionUrl.getText());

        this.plugin.savePluginProperties(properties);


        LOGGER.info("Settings Saved");
    }

    private void testConnectionActionPerformed(){




    }

    private void initComponents() {
        //this.createUIComponents();
        this.tbPnlInfo = new JideTabbedPane();
        final JPanel pnlSettings = new JPanel();
        final IconTitleBorderPanel pnlSqlLoginSettings = new IconTitleBorderPanel();
        final JPanel pnlLoginSettingsContent = new JPanel();

        this.setName("this");
        this.setLayout(new GridBagLayout());
        ((GridBagLayout)this.getLayout()).columnWidths = new int[] { 0, 0 };
        ((GridBagLayout)this.getLayout()).rowHeights = new int[] { 0, 0 };
        ((GridBagLayout)this.getLayout()).columnWeights = new double[] { 1.0, 1.0E-4 };
        ((GridBagLayout)this.getLayout()).rowWeights = new double[] { 1.0, 1.0E-4 };
        this.tbPnlInfo.setFocusable(false);
        this.tbPnlInfo.setRequestFocusEnabled(false);
        this.tbPnlInfo.setVerifyInputWhenFocusTarget(false);
        this.tbPnlInfo.setTabShape(10);
        this.tbPnlInfo.setBoldActiveTab(true);
        this.tbPnlInfo.setMinimumSize(new Dimension(502, 330));
        this.tbPnlInfo.setPreferredSize(new Dimension(502, 330));
        this.tbPnlInfo.setMaximumSize(new Dimension(502, 330));
        this.tbPnlInfo.setName("tbPnlInfo");
//        this.tbPnlInfo.addChangeListener((ChangeListener)new ChangeListener() {
//            @Override
//            public void stateChanged(final ChangeEvent e) {
//                PluginSettingsPanel.this.tbPnlInfoStateChanged();
//            }
//        });
//        this.pnlBrowser.setName("pnlBrowser");

        pnlSettings.setName("pnlSettings");
        pnlSettings.setLayout(new GridBagLayout());
        ((GridBagLayout)pnlSettings.getLayout()).columnWidths = new int[] { 478, 0 };
        ((GridBagLayout)pnlSettings.getLayout()).rowHeights = new int[] { 0, 0, 0 };
        ((GridBagLayout)pnlSettings.getLayout()).columnWeights = new double[] { 0.0, 1.0E-4 };
        ((GridBagLayout)pnlSettings.getLayout()).rowWeights = new double[] { 0.0, 0.0, 1.0E-4 };
        pnlSqlLoginSettings.setTitle("General Settings");
        pnlSqlLoginSettings.setType(IconTitleBorderPanel.IconConst.Details);
        pnlSqlLoginSettings.setIcon((Icon)new ImageIcon(this.getClass().getResource("/icon24/arrowsandnavigation/navigation2/navigate_up2.png")));
        pnlSqlLoginSettings.setName("pnlSqlLoginSettings");
        pnlSqlLoginSettings.setLayout((LayoutManager)new GridBagLayout());
        ((GridBagLayout)pnlSqlLoginSettings.getLayout()).columnWidths = new int[] { 0, 0 };
        ((GridBagLayout)pnlSqlLoginSettings.getLayout()).rowHeights = new int[] { 0, 0 };
        ((GridBagLayout)pnlSqlLoginSettings.getLayout()).columnWeights = new double[] { 1.0, 1.0E-4 };
        ((GridBagLayout)pnlSqlLoginSettings.getLayout()).rowWeights = new double[] { 0.0, 1.0E-4 };
        pnlLoginSettingsContent.setName("pnlLoginSettingsContent");
        pnlLoginSettingsContent.setLayout(new GridBagLayout());
        ((GridBagLayout)pnlLoginSettingsContent.getLayout()).columnWidths = new int[] { 0, 0 };
        ((GridBagLayout)pnlLoginSettingsContent.getLayout()).rowHeights = new int[] { 0, 0 };
        ((GridBagLayout)pnlLoginSettingsContent.getLayout()).columnWeights = new double[] { 1.0, 1.0E-4 };
        ((GridBagLayout)pnlLoginSettingsContent.getLayout()).rowWeights = new double[] { 0.0, 1.0E-4 };


        LOGGER.info("Base layout finished");

        pnlLoginSettingsContent.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        label1.setText("SQL Connection URL");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 4;
        pnlLoginSettingsContent.add(label1, gbc);
        txtSqlConnectionUrl = new JTextField();
        txtSqlConnectionUrl.setPreferredSize(new Dimension(300, 24));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlLoginSettingsContent.add(txtSqlConnectionUrl, gbc);
        txtUsername = new JTextField();
        txtUsername.setPreferredSize(new Dimension(150, 24));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlLoginSettingsContent.add(txtUsername, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 4;
        pnlLoginSettingsContent.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 4;
        pnlLoginSettingsContent.add(label3, gbc);
        txtPassword = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlLoginSettingsContent.add(txtPassword, gbc);
        testConnectionButton = new JButton();
        testConnectionButton.setText("Test Connection");
        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SettingsPanel.this.testConnectionActionPerformed();
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlLoginSettingsContent.add(testConnectionButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlLoginSettingsContent.add(spacer1, gbc);


        pnlLoginSettingsContent.add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
        pnlSqlLoginSettings.add((Component)pnlLoginSettingsContent, (Object)new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 10, 1, new Insets(5, 5, 5, 5), 0, 0));
        pnlSettings.add((Component)pnlSqlLoginSettings, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 10, 1, new Insets(10, 10, 5, 0), 0, 0));

        this.tbPnlInfo.addTab("Plugin Settings", (Component)pnlSettings);
        this.add((Component)this.tbPnlInfo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, 10, 1, new Insets(10, 10, 10, 10), 0, 0));


    }

    static {
        LOGGER = LoggerFactory.getLogger((Class)REELSupportPlugin.class);
    }
}
