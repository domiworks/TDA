
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class FogControlGUI {

    private javax.swing.JDialog frame;
    private javax.swing.JLabel alphaLbl;
    private javax.swing.JSlider alphaSlider;
    private javax.swing.JTextField alphaVal;
    private javax.swing.JLabel blueLbl;
    private javax.swing.JSlider blueSlider;
    private javax.swing.JTextField blueVal;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JComboBox fogComboBox;
    private javax.swing.JLabel fogDensityLbl;
    private javax.swing.JTextField fogDensityVal;
    private javax.swing.JButton fogToggleBtn;
    private javax.swing.JLabel fogTypeLbl;
    private javax.swing.JLabel greenLbl;
    private javax.swing.JSlider greenSlider;
    private javax.swing.JTextField greenVal;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel redLbl;
    private javax.swing.JSlider redSlider;
    private javax.swing.JTextField redVal;

    FogContainer fog;

    public FogControlGUI(final FogContainer fog) {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeaColorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeaColorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeaColorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeaColorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        this.fog = fog;

        frame = new javax.swing.JDialog();

        frame.setAlwaysOnTop(true);
        frame.setBackground(new java.awt.Color(102, 102, 255));
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame.setResizable(false);
        frame.setTitle("Fog Color and Control");

        panel = new javax.swing.JPanel();
        colorPanel = new javax.swing.JPanel();
        redLbl = new javax.swing.JLabel();
        greenLbl = new javax.swing.JLabel();
        blueLbl = new javax.swing.JLabel();
        alphaLbl = new javax.swing.JLabel();
        alphaSlider = new javax.swing.JSlider();
        blueSlider = new javax.swing.JSlider();
        redSlider = new javax.swing.JSlider();
        alphaVal = new javax.swing.JTextField();
        redVal = new javax.swing.JTextField();
        greenVal = new javax.swing.JTextField();
        blueVal = new javax.swing.JTextField();
        greenSlider = new javax.swing.JSlider();
        fogComboBox = new javax.swing.JComboBox();
        fogTypeLbl = new javax.swing.JLabel();
        fogDensityLbl = new javax.swing.JLabel();
        fogDensityVal = new javax.swing.JTextField();
        fogToggleBtn = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(64, 64, 64));

        colorPanel.setBackground(new java.awt.Color(64, 64, 64));
        colorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fog Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));
        colorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redLbl.setForeground(new java.awt.Color(223, 223, 223));
        redLbl.setText("Red");
        colorPanel.add(redLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 34, 45));

        greenLbl.setForeground(new java.awt.Color(223, 223, 223));
        greenLbl.setText("Green");
        colorPanel.add(greenLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 34, 45));

        blueLbl.setForeground(new java.awt.Color(223, 223, 223));
        blueLbl.setText("Blue");
        colorPanel.add(blueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 34, 45));

        alphaLbl.setForeground(new java.awt.Color(223, 223, 223));
        alphaLbl.setText("Alpha");
        //colorPanel.add(alphaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 34, 45));

        alphaSlider.setBackground(new java.awt.Color(64, 64, 64));
        alphaSlider.setForeground(new java.awt.Color(255, 153, 0));
        alphaSlider.setMajorTickSpacing(10);
        alphaSlider.setPaintLabels(true);
        alphaSlider.setPaintTicks(true);
        float alphaSliderVal = this.fog.getFogColorValue(3)* 100;
        alphaSlider.setValue((int) alphaSliderVal);
        alphaVal.setText(String.valueOf(alphaSlider.getValue()));
        //colorPanel.add(alphaSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 255, -1));

        blueSlider.setBackground(new java.awt.Color(64, 64, 64));
        blueSlider.setForeground(new java.awt.Color(255, 153, 0));
        blueSlider.setMajorTickSpacing(255);
        blueSlider.setMaximum(255);
        blueSlider.setPaintLabels(true);
        blueSlider.setPaintTicks(true);
        float blueSliderVal = this.fog.getFogColorValue(2)* 255;
        blueSlider.setValue((int) blueSliderVal);
        blueVal.setText(String.valueOf(blueSlider.getValue()));
        colorPanel.add(blueSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 255, -1));

        redSlider.setBackground(new java.awt.Color(64, 64, 64));
        redSlider.setForeground(new java.awt.Color(255, 153, 0));
        redSlider.setMajorTickSpacing(255);
        redSlider.setMaximum(255);
        redSlider.setPaintLabels(true);
        redSlider.setPaintTicks(true);
        float redSliderVal = this.fog.getFogColorValue(0)* 255;
        redSlider.setValue((int) redSliderVal);
        redVal.setText(String.valueOf(redSlider.getValue()));
        colorPanel.add(redSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 255, -1));
        //colorPanel.add(alphaVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 50, -1));

        colorPanel.add(redVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 50, -1));
        colorPanel.add(greenVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 50, -1));
        colorPanel.add(blueVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 50, -1));

        greenSlider.setBackground(new java.awt.Color(64, 64, 64));
        greenSlider.setForeground(new java.awt.Color(255, 153, 0));
        greenSlider.setMajorTickSpacing(255);
        greenSlider.setMaximum(255);
        greenSlider.setPaintLabels(true);
        greenSlider.setPaintTicks(true);
        float greenSliderVal = this.fog.getFogColorValue(1) * 255;
        greenSlider.setValue((int) greenSliderVal);
        greenVal.setText(String.valueOf(greenSlider.getValue()));
        colorPanel.add(greenSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 255, -1));

        fogComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"GL_EXP", "GL_EXP2", "GL_LINEAR"}));
        fogComboBox.setPreferredSize(new java.awt.Dimension(56, 23));

        fogTypeLbl.setForeground(new java.awt.Color(223, 223, 223));
        fogTypeLbl.setText("Fog Type");

        fogDensityLbl.setForeground(new java.awt.Color(223, 223, 223));
        fogDensityLbl.setText("Fog Density");

        Float fogDensityFloat = this.fog.getFogDensity();
        fogDensityVal.setText(fogDensityFloat.toString());
        fogDensityVal.setPreferredSize(new java.awt.Dimension(59, 23));

        fogToggleBtn.setText("Fog On/Off");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(fogTypeLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fogComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fogDensityLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fogDensityVal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(fogToggleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fogDensityVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fogComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fogDensityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fogToggleBtn))
                                .addComponent(fogTypeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redSlider = (javax.swing.JSlider) e.getSource();
                fog.setFogColorValue(0, redSlider.getValue()/255f);
                redVal.setText(String.valueOf(redSlider.getValue()));
            }
        });
        redVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(redVal.getText());
                fog.setFogColorValue(0, input/255f);
                redSlider.setValue(input);
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenSlider = (javax.swing.JSlider) e.getSource();
                fog.setFogColorValue(1, greenSlider.getValue()/255f);
                greenVal.setText(String.valueOf(greenSlider.getValue()));
            }
        });
        greenVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(greenVal.getText());
                fog.setFogColorValue(1, input/255f);
                greenSlider.setValue(input);
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueSlider = (javax.swing.JSlider) e.getSource();
                fog.setFogColorValue(2, blueSlider.getValue()/255f);
                blueVal.setText(String.valueOf(blueSlider.getValue()));
            }
        });
        blueVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(blueVal.getText());
                fog.setFogColorValue(2, input/255f);
                blueSlider.setValue(input);
            }
        });

        alphaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alphaSlider = (javax.swing.JSlider) e.getSource();
                fog.setFogColorValue(3, alphaSlider.getValue()/100);
                alphaVal.setText(String.valueOf(alphaSlider.getValue()));
            }
        });
        alphaVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(alphaVal.getText());
                fog.setFogColorValue(3, input/100);
                alphaSlider.setValue(input);
            }
        });

        fogComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fogComboBox = (javax.swing.JComboBox) e.getSource();
                fog.setFogType((byte) fogComboBox.getSelectedIndex());

            }
        });
        fogDensityVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                float input = Float.parseFloat(fogDensityVal.getText());
                fog.setFogDensity(input);
            }
        });

        fogToggleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fog.toggleFogVisibility();
            }
        });

    }

}
