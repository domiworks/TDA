
import java.awt.Font;
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
public class LightControlGUI {

    String projectDir;

    private javax.swing.JDialog frame;
    private javax.swing.JPanel addFeatures0;
    private javax.swing.JPanel addFeatures1;
    private javax.swing.JPanel addFeatures2;
    private javax.swing.JButton ambColBtn0;
    private javax.swing.JButton ambColBtn1;
    private javax.swing.JButton ambColBtn2;
    private javax.swing.JLabel ambLbl0;
    private javax.swing.JLabel ambLbl1;
    private javax.swing.JLabel ambLbl2;
    private javax.swing.JSlider ambSlide0;
    private javax.swing.JSlider ambSlide1;
    private javax.swing.JSlider ambSlide2;
    private javax.swing.JTextField ambVal0;
    private javax.swing.JTextField ambVal1;
    private javax.swing.JTextField ambVal2;
    private javax.swing.JButton diffuseColBtn0;
    private javax.swing.JButton diffuseColBtn1;
    private javax.swing.JButton diffuseColBtn2;
    private javax.swing.JLabel diffuseLbl0;
    private javax.swing.JLabel diffuseLbl1;
    private javax.swing.JLabel diffuseLbl2;
    private javax.swing.JSlider diffuseSlide0;
    private javax.swing.JSlider diffuseSlide1;
    private javax.swing.JSlider diffuseSlide2;
    private javax.swing.JTextField diffuseVal0;
    private javax.swing.JTextField diffuseVal1;
    private javax.swing.JTextField diffuseVal2;
    private javax.swing.JButton lightColorBtn0;
    private javax.swing.JButton lightColorBtn1;
    private javax.swing.JButton lightColorBtn2;
    private javax.swing.JPanel panel;
    private javax.swing.JButton specuColBtn0;
    private javax.swing.JButton specuColBtn1;
    private javax.swing.JButton specuColBtn2;
    private javax.swing.JLabel specuLbl0;
    private javax.swing.JLabel specuLbl1;
    private javax.swing.JLabel specuLbl2;
    private javax.swing.JSlider specuSlide0;
    private javax.swing.JSlider specuSlide1;
    private javax.swing.JSlider specuSlide2;
    private javax.swing.JTextField specuVal0;
    private javax.swing.JTextField specuVal1;
    private javax.swing.JTextField specuVal2;
    private javax.swing.JCheckBox togGuideLight0;
    private javax.swing.JCheckBox togGuideLight1;
    private javax.swing.JCheckBox togGuideLight2;
    private javax.swing.JSpinner wValLightBtn0;
    private javax.swing.JSpinner wValLightBtn1;
    private javax.swing.JSpinner wValLightBtn2;
    private javax.swing.JLabel xCoorLbl0;
    private javax.swing.JLabel xCoorLbl1;
    private javax.swing.JLabel xCoorLbl2;
    private javax.swing.JSlider xCoorSlide0;
    private javax.swing.JSlider xCoorSlide1;
    private javax.swing.JSlider xCoorSlide2;
    private javax.swing.JTextField xCoorVal0;
    private javax.swing.JTextField xCoorVal1;
    private javax.swing.JTextField xCoorVal2;
    private javax.swing.JLabel yCoorLbl0;
    private javax.swing.JLabel yCoorLbl1;
    private javax.swing.JLabel yCoorLbl2;
    private javax.swing.JSlider yCoorSlide0;
    private javax.swing.JSlider yCoorSlide1;
    private javax.swing.JSlider yCoorSlide2;
    private javax.swing.JTextField yCoorVal0;
    private javax.swing.JTextField yCoorVal1;
    private javax.swing.JTextField yCoorVal2;
    private javax.swing.JLabel zCoorLbl0;
    private javax.swing.JLabel zCoorLbl1;
    private javax.swing.JLabel zCoorLbl2;
    private javax.swing.JSlider zCoorSlide0;
    private javax.swing.JSlider zCoorSlide1;
    private javax.swing.JSlider zCoorSlide2;
    private javax.swing.JTextField zCoorVal0;
    private javax.swing.JTextField zCoorVal1;
    private javax.swing.JTextField zCoorVal2;

    LightContainer lightSource[];
    
    int skyboxLength;

  //  int px400 = 400;
    //  int px540_400 = 540 - 400;
    //   int itterate = 0;
    public LightControlGUI(final LightContainer lightSource[], final String projectDir, float skyboxLength) {
        this.projectDir = projectDir;

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

        this.lightSource = lightSource;
        this.skyboxLength = (int) skyboxLength;

        frame = new javax.swing.JDialog();
        frame.setResizable(false);
        frame.setTitle("Light Control");

        panel = new javax.swing.JPanel();
        xCoorLbl0 = new javax.swing.JLabel();
        yCoorLbl0 = new javax.swing.JLabel();
        zCoorLbl0 = new javax.swing.JLabel();
        xCoorSlide0 = new javax.swing.JSlider();
        yCoorSlide0 = new javax.swing.JSlider();
        zCoorSlide0 = new javax.swing.JSlider();
        xCoorVal0 = new javax.swing.JTextField();
        yCoorVal0 = new javax.swing.JTextField();
        zCoorVal0 = new javax.swing.JTextField();
        ambLbl0 = new javax.swing.JLabel();
        diffuseLbl0 = new javax.swing.JLabel();
        specuLbl0 = new javax.swing.JLabel();
        ambSlide0 = new javax.swing.JSlider();
        diffuseSlide0 = new javax.swing.JSlider();
        specuSlide0 = new javax.swing.JSlider();
        ambVal0 = new javax.swing.JTextField();
        diffuseVal0 = new javax.swing.JTextField();
        specuVal0 = new javax.swing.JTextField();
        ambColBtn0 = new javax.swing.JButton();
        diffuseColBtn0 = new javax.swing.JButton();
        specuColBtn0 = new javax.swing.JButton();
        addFeatures0 = new javax.swing.JPanel();
        togGuideLight0 = new javax.swing.JCheckBox();
        lightColorBtn0 = new javax.swing.JButton();
        wValLightBtn0 = new javax.swing.JSpinner();
        xCoorLbl1 = new javax.swing.JLabel();
        yCoorLbl1 = new javax.swing.JLabel();
        zCoorLbl1 = new javax.swing.JLabel();
        xCoorSlide1 = new javax.swing.JSlider();
        yCoorSlide1 = new javax.swing.JSlider();
        zCoorSlide1 = new javax.swing.JSlider();
        xCoorVal1 = new javax.swing.JTextField();
        yCoorVal1 = new javax.swing.JTextField();
        zCoorVal1 = new javax.swing.JTextField();
        ambLbl1 = new javax.swing.JLabel();
        diffuseLbl1 = new javax.swing.JLabel();
        specuLbl1 = new javax.swing.JLabel();
        specuSlide1 = new javax.swing.JSlider();
        diffuseSlide1 = new javax.swing.JSlider();
        ambSlide1 = new javax.swing.JSlider();
        ambVal1 = new javax.swing.JTextField();
        diffuseVal1 = new javax.swing.JTextField();
        specuVal1 = new javax.swing.JTextField();
        ambColBtn1 = new javax.swing.JButton();
        diffuseColBtn1 = new javax.swing.JButton();
        specuColBtn1 = new javax.swing.JButton();
        addFeatures1 = new javax.swing.JPanel();
        togGuideLight1 = new javax.swing.JCheckBox();
        lightColorBtn1 = new javax.swing.JButton();
        wValLightBtn1 = new javax.swing.JSpinner();
        xCoorLbl2 = new javax.swing.JLabel();
        yCoorLbl2 = new javax.swing.JLabel();
        zCoorLbl2 = new javax.swing.JLabel();
        xCoorSlide2 = new javax.swing.JSlider();
        yCoorSlide2 = new javax.swing.JSlider();
        zCoorSlide2 = new javax.swing.JSlider();
        xCoorVal2 = new javax.swing.JTextField();
        yCoorVal2 = new javax.swing.JTextField();
        zCoorVal2 = new javax.swing.JTextField();
        ambLbl2 = new javax.swing.JLabel();
        diffuseLbl2 = new javax.swing.JLabel();
        specuLbl2 = new javax.swing.JLabel();
        ambSlide2 = new javax.swing.JSlider();
        diffuseSlide2 = new javax.swing.JSlider();
        specuSlide2 = new javax.swing.JSlider();
        ambVal2 = new javax.swing.JTextField();
        diffuseVal2 = new javax.swing.JTextField();
        specuVal2 = new javax.swing.JTextField();
        ambColBtn2 = new javax.swing.JButton();
        specuColBtn2 = new javax.swing.JButton();
        diffuseColBtn2 = new javax.swing.JButton();
        addFeatures2 = new javax.swing.JPanel();
        togGuideLight2 = new javax.swing.JCheckBox();
        lightColorBtn2 = new javax.swing.JButton();
        wValLightBtn2 = new javax.swing.JSpinner();

        frame.setAlwaysOnTop(true);
        frame.setBackground(new java.awt.Color(102, 102, 255));
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel.setBackground(new java.awt.Color(64, 64, 64));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xCoorLbl0.setForeground(new java.awt.Color(223, 223, 223));
        xCoorLbl0.setText("Pos 0 X");
        panel.add(xCoorLbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, 45));

        yCoorLbl0.setForeground(new java.awt.Color(223, 223, 223));
        yCoorLbl0.setText("Pos 0 Y");
        panel.add(yCoorLbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 45));

        zCoorLbl0.setForeground(new java.awt.Color(223, 223, 223));
        zCoorLbl0.setText("Pos 0 Z");
        panel.add(zCoorLbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 139, 60, 45));

        xCoorSlide0.setBackground(new java.awt.Color(64, 64, 64));
        xCoorSlide0.setForeground(new java.awt.Color(255, 153, 0));
        xCoorSlide0.setMaximum((int) (skyboxLength / 4));
        xCoorSlide0.setMinimum((int) (-skyboxLength / 4));
        xCoorSlide0.setMajorTickSpacing((int) (skyboxLength / 8));
        xCoorSlide0.setPaintLabels(true);
        xCoorSlide0.setPaintTicks(true);
        xCoorSlide0.setValue((int) lightSource[0].getLightPosition(0));
        xCoorVal0.setText(String.valueOf(xCoorSlide0.getValue()));
        xCoorSlide0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(xCoorSlide0, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 37, 350, -1));

        yCoorSlide0.setBackground(new java.awt.Color(64, 64, 64));
        yCoorSlide0.setForeground(new java.awt.Color(255, 153, 0));
        yCoorSlide0.setMaximum((int) (skyboxLength / 4));
        yCoorSlide0.setMinimum((int) (-skyboxLength / 4));
        yCoorSlide0.setMajorTickSpacing((int) (skyboxLength / 8));
        yCoorSlide0.setPaintLabels(true);
        yCoorSlide0.setPaintTicks(true);
        yCoorSlide0.setValue((int) lightSource[0].getLightPosition(1));
        yCoorVal0.setText(String.valueOf(yCoorSlide0.getValue()));
        yCoorSlide0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(yCoorSlide0, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 88, 350, -1));

        zCoorSlide0.setBackground(new java.awt.Color(64, 64, 64));
        zCoorSlide0.setForeground(new java.awt.Color(255, 153, 0));
        zCoorSlide0.setMaximum(500);
        zCoorSlide0.setMinimum(-500);
        zCoorSlide0.setMajorTickSpacing(500);
        zCoorSlide0.setPaintLabels(true);
        zCoorSlide0.setPaintTicks(true);
        zCoorSlide0.setValue((int) lightSource[0].getLightPosition(2));
        zCoorVal0.setText(String.valueOf(zCoorSlide0.getValue()));
        zCoorSlide0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(zCoorSlide0, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 139, 350, -1));
        panel.add(xCoorVal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 40, -1));
        panel.add(yCoorVal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 40, -1));
        panel.add(zCoorVal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 40, -1));

        ambLbl0.setForeground(new java.awt.Color(223, 223, 223));
        ambLbl0.setText("Ambient 0");
        panel.add(ambLbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 60, 45));

        diffuseLbl0.setForeground(new java.awt.Color(223, 223, 223));
        diffuseLbl0.setText("Diffuse 0");
        panel.add(diffuseLbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 60, 45));

        specuLbl0.setForeground(new java.awt.Color(223, 223, 223));
        specuLbl0.setText("Specular 0");
        panel.add(specuLbl0, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 60, 45));

        ambSlide0.setBackground(new java.awt.Color(64, 64, 64));
        ambSlide0.setForeground(new java.awt.Color(255, 153, 0));
        ambSlide0.setMajorTickSpacing(85);
        ambSlide0.setMaximum(255);
        ambSlide0.setPaintLabels(true);
        ambSlide0.setPaintTicks(true);
        float ambSlide0val = lightSource[0].getAmbientValue(0) * 255f;
        ambSlide0.setValue((int) ambSlide0val);
        ambVal0.setText(String.valueOf(ambSlide0.getValue()));
        ambSlide0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(ambSlide0, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 180, -1));

        diffuseSlide0.setBackground(new java.awt.Color(64, 64, 64));
        diffuseSlide0.setForeground(new java.awt.Color(255, 153, 0));
        diffuseSlide0.setMajorTickSpacing(85);
        diffuseSlide0.setMaximum(255);
        diffuseSlide0.setPaintLabels(true);
        diffuseSlide0.setPaintTicks(true);
        float diffuseSlide0val = lightSource[0].getDiffuseValue(0) * 255f;
        diffuseSlide0.setValue((int) diffuseSlide0val);
        diffuseVal0.setText(String.valueOf(diffuseSlide0.getValue()));
        diffuseSlide0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(diffuseSlide0, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 180, -1));

        specuSlide0.setBackground(new java.awt.Color(64, 64, 64));
        specuSlide0.setForeground(new java.awt.Color(255, 153, 0));
        specuSlide0.setMajorTickSpacing(85);
        specuSlide0.setMaximum(255);
        specuSlide0.setPaintLabels(true);
        specuSlide0.setPaintTicks(true);
        float specuSlide0val = lightSource[0].getSpecularValue(0) * 255f;
        specuSlide0.setValue((int) specuSlide0val);
        specuVal0.setText(String.valueOf(specuSlide0.getValue()));
        specuSlide0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(specuSlide0, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 180, -1));
        panel.add(ambVal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 30, -1));
        panel.add(diffuseVal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 30, -1));
        panel.add(specuVal0, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 30, -1));

        ambColBtn0.setBackground(new java.awt.Color(64, 64, 64));
        ambColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        ambColBtn0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(ambColBtn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 40, 20));

        diffuseColBtn0.setBackground(new java.awt.Color(64, 64, 64));
        diffuseColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        diffuseColBtn0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(diffuseColBtn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 40, 20));

        specuColBtn0.setBackground(new java.awt.Color(64, 64, 64));
        specuColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        specuColBtn0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(specuColBtn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 40, 20));

        addFeatures0.setBackground(new java.awt.Color(64, 64, 64));
        addFeatures0.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Additional Features", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        togGuideLight0.setText("Guideline");
        if (lightSource[0].getToggleLightGuide() == true) {
            togGuideLight0.setSelected(true);
        }
        togGuideLight0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        togGuideLight0.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lightColorBtn0.setText("Light On/Off");

        wValLightBtn0.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(lightSource[0].getLightPosition(3)), null, null, Float.valueOf(0.1f)));

        javax.swing.GroupLayout addFeatures0Layout = new javax.swing.GroupLayout(addFeatures0);
        addFeatures0.setLayout(addFeatures0Layout);
        addFeatures0Layout.setHorizontalGroup(
                addFeatures0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addFeatures0Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addFeatures0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lightColorBtn0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(togGuideLight0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wValLightBtn0))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addFeatures0Layout.setVerticalGroup(
                addFeatures0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addFeatures0Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(togGuideLight0)
                        .addGap(14, 14, 14)
                        .addComponent(lightColorBtn0)
                        .addGap(18, 18, 18)
                        .addComponent(wValLightBtn0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
        );

        panel.add(addFeatures0, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 130, 150));

        xCoorLbl1.setForeground(new java.awt.Color(223, 223, 223));
        xCoorLbl1.setText("Pos 1 X");
        panel.add(xCoorLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 60, 45));

        yCoorLbl1.setForeground(new java.awt.Color(223, 223, 223));
        yCoorLbl1.setText("Pos 1 Y");
        panel.add(yCoorLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 60, 45));

        zCoorLbl1.setForeground(new java.awt.Color(223, 223, 223));
        zCoorLbl1.setText("Pos 1 Z");
        panel.add(zCoorLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 60, 45));

        xCoorSlide1.setBackground(new java.awt.Color(64, 64, 64));
        xCoorSlide1.setForeground(new java.awt.Color(255, 153, 0));
        xCoorSlide1.setMaximum((int) (skyboxLength / 4));
        xCoorSlide1.setMinimum((int) (-skyboxLength / 4));
        xCoorSlide1.setMajorTickSpacing((int) (skyboxLength / 8));
        xCoorSlide1.setPaintLabels(true);
        xCoorSlide1.setPaintTicks(true);
        xCoorSlide1.setValue((int) lightSource[1].getLightPosition(0));
        xCoorVal1.setText(String.valueOf(xCoorSlide1.getValue()));
        xCoorSlide1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(xCoorSlide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 350, -1));

        yCoorSlide1.setBackground(new java.awt.Color(64, 64, 64));
        yCoorSlide1.setForeground(new java.awt.Color(255, 153, 0));
        yCoorSlide1.setMaximum((int) (skyboxLength / 4));
        yCoorSlide1.setMinimum((int) (-skyboxLength / 4));
        yCoorSlide1.setMajorTickSpacing((int) (skyboxLength / 8));
        yCoorSlide1.setPaintLabels(true);
        yCoorSlide1.setPaintTicks(true);
        yCoorSlide1.setValue((int) lightSource[1].getLightPosition(1));
        yCoorVal1.setText(String.valueOf(yCoorSlide1.getValue()));
        yCoorSlide1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(yCoorSlide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 350, -1));

        zCoorSlide1.setBackground(new java.awt.Color(64, 64, 64));
        zCoorSlide1.setForeground(new java.awt.Color(255, 153, 0));
        zCoorSlide1.setMaximum(500);
        zCoorSlide1.setMinimum(-500);
        zCoorSlide1.setMajorTickSpacing(500);
        zCoorSlide1.setPaintLabels(true);
        zCoorSlide1.setPaintTicks(true);
        zCoorSlide1.setValue((int) lightSource[1].getLightPosition(2));
        zCoorVal1.setText(String.valueOf(zCoorSlide1.getValue()));
        zCoorSlide1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(zCoorSlide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 350, -1));
        panel.add(xCoorVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 40, -1));
        panel.add(yCoorVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 40, -1));
        panel.add(zCoorVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 40, -1));

        ambLbl1.setForeground(new java.awt.Color(223, 223, 223));
        ambLbl1.setText("Ambient 1");
        panel.add(ambLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 60, 45));

        diffuseLbl1.setForeground(new java.awt.Color(223, 223, 223));
        diffuseLbl1.setText("Diffuse 1");
        panel.add(diffuseLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 60, 45));

        specuLbl1.setForeground(new java.awt.Color(223, 223, 223));
        specuLbl1.setText("Specular 1");
        panel.add(specuLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 60, 45));

        specuSlide1.setBackground(new java.awt.Color(64, 64, 64));
        specuSlide1.setForeground(new java.awt.Color(255, 153, 0));
        specuSlide1.setMajorTickSpacing(85);
        specuSlide1.setMaximum(255);
        specuSlide1.setPaintLabels(true);
        specuSlide1.setPaintTicks(true);
        float specuSlide1val = lightSource[1].getSpecularValue(0) * 255f;
        specuSlide1.setValue((int) specuSlide1val);
        specuVal1.setText(String.valueOf(specuSlide1.getValue()));
        specuSlide1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(specuSlide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 180, -1));

        diffuseSlide1.setBackground(new java.awt.Color(64, 64, 64));
        diffuseSlide1.setForeground(new java.awt.Color(255, 153, 0));
        diffuseSlide1.setMajorTickSpacing(85);
        diffuseSlide1.setMaximum(255);
        diffuseSlide1.setPaintLabels(true);
        diffuseSlide1.setPaintTicks(true);
        float diffuseSlide1val = lightSource[1].getDiffuseValue(0) * 255f;
        diffuseSlide1.setValue((int) diffuseSlide1val);
        diffuseVal1.setText(String.valueOf(diffuseSlide1.getValue()));
        diffuseSlide1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(diffuseSlide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 180, -1));

        ambSlide1.setBackground(new java.awt.Color(64, 64, 64));
        ambSlide1.setForeground(new java.awt.Color(255, 153, 0));
        ambSlide1.setMajorTickSpacing(85);
        ambSlide1.setMaximum(255);
        ambSlide1.setPaintLabels(true);
        ambSlide1.setPaintTicks(true);
        float ambSlide1val = lightSource[1].getAmbientValue(0) * 255f;
        ambSlide1.setValue((int) ambSlide1val);
        ambVal1.setText(String.valueOf(ambSlide1.getValue()));
        ambSlide1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(ambSlide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 180, -1));
        panel.add(ambVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 30, -1));
        panel.add(diffuseVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, 30, -1));
        panel.add(specuVal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 30, -1));

        ambColBtn1.setBackground(new java.awt.Color(64, 64, 64));
        ambColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        ambColBtn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(ambColBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, 40, 20));

        diffuseColBtn1.setBackground(new java.awt.Color(64, 64, 64));
        diffuseColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        diffuseColBtn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(diffuseColBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 40, 20));

        specuColBtn1.setBackground(new java.awt.Color(64, 64, 64));
        specuColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        specuColBtn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(specuColBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 40, 20));

        addFeatures1.setBackground(new java.awt.Color(64, 64, 64));
        addFeatures1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Additional Features", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        togGuideLight1.setText("Guideline");
        if (lightSource[1].getToggleLightGuide() == true) {
            togGuideLight1.setSelected(true);
        }
        togGuideLight1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        togGuideLight1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        togGuideLight1.setPreferredSize(new java.awt.Dimension(93, 23));

        lightColorBtn1.setText("Light On/Off");

        wValLightBtn1.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(lightSource[1].getLightPosition(3)), null, null, Float.valueOf(0.1f)));

        javax.swing.GroupLayout addFeatures1Layout = new javax.swing.GroupLayout(addFeatures1);
        addFeatures1.setLayout(addFeatures1Layout);
        addFeatures1Layout.setHorizontalGroup(
                addFeatures1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addFeatures1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addFeatures1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(togGuideLight1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(lightColorBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wValLightBtn1))
                        .addContainerGap())
        );
        addFeatures1Layout.setVerticalGroup(
                addFeatures1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addFeatures1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(togGuideLight1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(lightColorBtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(wValLightBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        panel.add(addFeatures1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, 130, 150));

        xCoorLbl2.setForeground(new java.awt.Color(223, 223, 223));
        xCoorLbl2.setText("Pos 2 X");
        panel.add(xCoorLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 60, 45));

        yCoorLbl2.setForeground(new java.awt.Color(223, 223, 223));
        yCoorLbl2.setText("Pos 2 Y");
        panel.add(yCoorLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 45));

        zCoorLbl2.setForeground(new java.awt.Color(223, 223, 223));
        zCoorLbl2.setText("Pos 2 Z");
        panel.add(zCoorLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 60, 45));

        xCoorSlide2.setBackground(new java.awt.Color(64, 64, 64));
        xCoorSlide2.setForeground(new java.awt.Color(255, 153, 0));
        xCoorSlide2.setMaximum((int) (skyboxLength / 4));
        xCoorSlide2.setMinimum((int) (-skyboxLength / 4));
        xCoorSlide2.setMajorTickSpacing((int) (skyboxLength / 8));
        xCoorSlide2.setPaintLabels(true);
        xCoorSlide2.setPaintTicks(true);
        xCoorSlide2.setValue((int) lightSource[2].getLightPosition(0));
        xCoorVal2.setText(String.valueOf(xCoorSlide2.getValue()));
        xCoorSlide2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(xCoorSlide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 350, -1));

        yCoorSlide2.setBackground(new java.awt.Color(64, 64, 64));
        yCoorSlide2.setForeground(new java.awt.Color(255, 153, 0));
        yCoorSlide2.setMaximum((int) (skyboxLength / 4));
        yCoorSlide2.setMinimum((int) (-skyboxLength / 4));
        yCoorSlide2.setMajorTickSpacing((int) (skyboxLength / 8));
        yCoorSlide2.setPaintLabels(true);
        yCoorSlide2.setPaintTicks(true);
        yCoorSlide2.setValue((int) lightSource[2].getLightPosition(1));
        yCoorVal2.setText(String.valueOf(yCoorSlide2.getValue()));
        yCoorSlide2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(yCoorSlide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 350, -1));

        zCoorSlide2.setBackground(new java.awt.Color(64, 64, 64));
        zCoorSlide2.setForeground(new java.awt.Color(255, 153, 0));
        zCoorSlide2.setMaximum(500);
        zCoorSlide2.setMinimum(-500);
        zCoorSlide2.setMajorTickSpacing(500);
        zCoorSlide2.setPaintLabels(true);
        zCoorSlide2.setPaintTicks(true);
        zCoorSlide2.setValue((int) lightSource[2].getLightPosition(2));
        zCoorVal2.setText(String.valueOf(zCoorSlide2.getValue()));
        zCoorSlide2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(zCoorSlide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 350, -1));
        panel.add(xCoorVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 40, -1));
        panel.add(yCoorVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 40, -1));
        panel.add(zCoorVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 40, -1));

        ambLbl2.setForeground(new java.awt.Color(223, 223, 223));
        ambLbl2.setText("Ambient 2");
        panel.add(ambLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 60, 45));

        diffuseLbl2.setForeground(new java.awt.Color(223, 223, 223));
        diffuseLbl2.setText("Diffuse 2");
        panel.add(diffuseLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 60, 45));

        specuLbl2.setForeground(new java.awt.Color(223, 223, 223));
        specuLbl2.setText("Specular 2");
        panel.add(specuLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 60, 45));

        ambSlide2.setBackground(new java.awt.Color(64, 64, 64));
        ambSlide2.setForeground(new java.awt.Color(255, 153, 0));
        ambSlide2.setMajorTickSpacing(85);
        ambSlide2.setMaximum(255);
        ambSlide2.setPaintLabels(true);
        ambSlide2.setPaintTicks(true);
        float ambSlide2val = lightSource[2].getAmbientValue(0) * 255f;
        ambSlide2.setValue((int) ambSlide2val);
        ambVal2.setText(String.valueOf(ambSlide2.getValue()));
        ambSlide2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(ambSlide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 180, -1));

        diffuseSlide2.setBackground(new java.awt.Color(64, 64, 64));
        diffuseSlide2.setForeground(new java.awt.Color(255, 153, 0));
        diffuseSlide2.setMajorTickSpacing(85);
        diffuseSlide2.setMaximum(255);
        diffuseSlide2.setPaintLabels(true);
        diffuseSlide2.setPaintTicks(true);
        float diffuseSlide2val = lightSource[2].getDiffuseValue(0) * 255f;
        diffuseSlide2.setValue((int) diffuseSlide2val);
        diffuseVal2.setText(String.valueOf(diffuseSlide2.getValue()));
        diffuseSlide2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(diffuseSlide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 180, -1));

        specuSlide2.setBackground(new java.awt.Color(64, 64, 64));
        specuSlide2.setForeground(new java.awt.Color(255, 153, 0));
        specuSlide2.setMajorTickSpacing(85);
        specuSlide2.setMaximum(255);
        specuSlide2.setPaintLabels(true);
        specuSlide2.setPaintTicks(true);
        float specuSlide2val = lightSource[2].getSpecularValue(0) * 255f;
        specuSlide2.setValue((int) specuSlide2val);
        specuVal2.setText(String.valueOf(specuSlide2.getValue()));
        specuSlide2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(specuSlide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 180, -1));
        panel.add(ambVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 30, -1));
        panel.add(diffuseVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 30, -1));
        panel.add(specuVal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 30, -1));

        ambColBtn2.setBackground(new java.awt.Color(64, 64, 64));
        ambColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        ambColBtn2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(ambColBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 40, 20));

        specuColBtn2.setBackground(new java.awt.Color(64, 64, 64));
        specuColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        specuColBtn2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(specuColBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 40, 20));

        diffuseColBtn2.setBackground(new java.awt.Color(64, 64, 64));
        diffuseColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png")); // NOI18N
        diffuseColBtn2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.add(diffuseColBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, 40, 20));

        addFeatures2.setBackground(new java.awt.Color(64, 64, 64));
        addFeatures2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Additional Features", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        togGuideLight2.setText("Guideline");
        if (lightSource[2].getToggleLightGuide() == true) {
            togGuideLight2.setSelected(true);
        }
        togGuideLight2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        togGuideLight2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lightColorBtn2.setText("Light On/Off");

        wValLightBtn2.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(lightSource[2].getLightPosition(3)), null, null, Float.valueOf(0)));

        javax.swing.GroupLayout addFeatures2Layout = new javax.swing.GroupLayout(addFeatures2);
        addFeatures2.setLayout(addFeatures2Layout);
        addFeatures2Layout.setHorizontalGroup(
                addFeatures2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addFeatures2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addFeatures2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lightColorBtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addComponent(togGuideLight2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wValLightBtn2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addFeatures2Layout.setVerticalGroup(
                addFeatures2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addFeatures2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(togGuideLight2)
                        .addGap(14, 14, 14)
                        .addComponent(lightColorBtn2)
                        .addGap(18, 18, 18)
                        .addComponent(wValLightBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
        );

        panel.add(addFeatures2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, 130, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        xCoorSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                xCoorSlide0 = (javax.swing.JSlider) e.getSource();
                lightSource[0].setLightPosition(0, (float) xCoorSlide0.getValue());
                xCoorVal0.setText(String.valueOf(xCoorSlide0.getValue()));
            }
        });
        xCoorVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(xCoorVal0.getText());
                lightSource[0].setLightPosition(0, input);
                xCoorSlide0.setValue(input);
            }
        });

        yCoorSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                yCoorSlide0 = (javax.swing.JSlider) e.getSource();
                lightSource[0].setLightPosition(1, (float) yCoorSlide0.getValue());
                yCoorVal0.setText(String.valueOf(yCoorSlide0.getValue()));
            }
        });
        yCoorVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(yCoorVal0.getText());
                lightSource[0].setLightPosition(1, input);
                yCoorSlide0.setValue(input);
            }
        });

        zCoorSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                zCoorSlide0 = (javax.swing.JSlider) e.getSource();
                lightSource[0].setLightPosition(2, (float) zCoorSlide0.getValue());
                zCoorVal0.setText(String.valueOf(zCoorSlide0.getValue()));
            }
        });
        zCoorVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(zCoorVal0.getText());
                lightSource[0].setLightPosition(2, input);
                zCoorSlide0.setValue(input);
            }
        });

        /*---*/
        xCoorSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                xCoorSlide1 = (javax.swing.JSlider) e.getSource();
                lightSource[1].setLightPosition(0, (float) xCoorSlide1.getValue());
                xCoorVal1.setText(String.valueOf(xCoorSlide1.getValue()));
            }
        });
        xCoorVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(xCoorVal1.getText());
                lightSource[1].setLightPosition(0, input);
                xCoorSlide1.setValue(input);
            }
        });

        yCoorSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                yCoorSlide1 = (javax.swing.JSlider) e.getSource();
                lightSource[1].setLightPosition(1, (float) yCoorSlide1.getValue());
                yCoorVal1.setText(String.valueOf(yCoorSlide1.getValue()));
            }
        });
        yCoorVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(yCoorVal1.getText());
                lightSource[1].setLightPosition(1, input);
                yCoorSlide1.setValue(input);
            }
        });

        zCoorSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                zCoorSlide1 = (javax.swing.JSlider) e.getSource();
                lightSource[1].setLightPosition(2, (float) zCoorSlide1.getValue());
                zCoorVal1.setText(String.valueOf(zCoorSlide1.getValue()));
            }
        });
        zCoorVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(zCoorVal1.getText());
                lightSource[1].setLightPosition(2, input);
                zCoorSlide1.setValue(input);
            }
        });

        /*---*/
        xCoorSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                xCoorSlide2 = (javax.swing.JSlider) e.getSource();
                lightSource[2].setLightPosition(0, (float) xCoorSlide2.getValue());
                xCoorVal2.setText(String.valueOf(xCoorSlide2.getValue()));
            }
        });
        xCoorVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(xCoorVal2.getText());
                lightSource[2].setLightPosition(0, input);
                xCoorSlide2.setValue(input);
            }
        });

        yCoorSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                yCoorSlide2 = (javax.swing.JSlider) e.getSource();
                lightSource[2].setLightPosition(1, (float) yCoorSlide2.getValue());
                yCoorVal2.setText(String.valueOf(yCoorSlide2.getValue()));
            }
        });
        yCoorVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(yCoorVal2.getText());
                lightSource[2].setLightPosition(1, input);
                yCoorSlide2.setValue(input);
            }
        });

        zCoorSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                zCoorSlide2 = (javax.swing.JSlider) e.getSource();
                lightSource[2].setLightPosition(2, (float) zCoorSlide2.getValue());
                zCoorVal2.setText(String.valueOf(zCoorSlide2.getValue()));
            }
        });
        zCoorVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(zCoorVal2.getText());
                lightSource[2].setLightPosition(2, input);
                zCoorSlide2.setValue(input);
            }
        });

        /*--- ambient, diffuse, specular ---*/
        /* 0 */
        ambSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ambSlide0 = (javax.swing.JSlider) e.getSource();
                lightSource[0].setAmbientValue(0, (float) ambSlide0.getValue() / 255f);
                lightSource[0].setAmbientValue(1, (float) ambSlide0.getValue() / 255f);
                lightSource[0].setAmbientValue(2, (float) ambSlide0.getValue() / 255f);
                ambVal0.setText(String.valueOf(ambSlide0.getValue()));
            }
        });

        diffuseSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                diffuseSlide0 = (javax.swing.JSlider) e.getSource();
                lightSource[0].setDiffuseValue(0, (float) diffuseSlide0.getValue() / 255f);
                lightSource[0].setDiffuseValue(1, (float) diffuseSlide0.getValue() / 255f);
                lightSource[0].setDiffuseValue(2, (float) diffuseSlide0.getValue() / 255f);
                diffuseVal0.setText(String.valueOf(diffuseSlide0.getValue()));
            }
        });

        specuSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                specuSlide0 = (javax.swing.JSlider) e.getSource();
                lightSource[0].setSpecularValue(0, (float) specuSlide0.getValue() / 255f);
                lightSource[0].setSpecularValue(1, (float) specuSlide0.getValue() / 255f);
                lightSource[0].setSpecularValue(2, (float) specuSlide0.getValue() / 255f);
                specuVal0.setText(String.valueOf(specuSlide0.getValue()));
            }
        });

        ambSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ambSlide1 = (javax.swing.JSlider) e.getSource();
                lightSource[1].setAmbientValue(0, (float) ambSlide1.getValue() / 255f);
                lightSource[1].setAmbientValue(1, (float) ambSlide1.getValue() / 255f);
                lightSource[1].setAmbientValue(2, (float) ambSlide1.getValue() / 255f);
                ambVal1.setText(String.valueOf(ambSlide1.getValue()));
            }
        });

        diffuseSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                diffuseSlide1 = (javax.swing.JSlider) e.getSource();
                lightSource[1].setDiffuseValue(0, (float) diffuseSlide1.getValue() / 255f);
                lightSource[1].setDiffuseValue(1, (float) diffuseSlide1.getValue() / 255f);
                lightSource[1].setDiffuseValue(2, (float) diffuseSlide1.getValue() / 255f);
                diffuseVal1.setText(String.valueOf(diffuseSlide1.getValue()));
            }
        });

        specuSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                specuSlide1 = (javax.swing.JSlider) e.getSource();
                lightSource[1].setSpecularValue(0, (float) specuSlide1.getValue() / 255f);
                lightSource[1].setSpecularValue(1, (float) specuSlide1.getValue() / 255f);
                lightSource[1].setSpecularValue(2, (float) specuSlide1.getValue() / 255f);
                specuVal1.setText(String.valueOf(specuSlide1.getValue()));
            }
        });

        ambSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ambSlide2 = (javax.swing.JSlider) e.getSource();
                lightSource[2].setAmbientValue(0, (float) ambSlide2.getValue() / 255f);
                lightSource[2].setAmbientValue(1, (float) ambSlide2.getValue() / 255f);
                lightSource[2].setAmbientValue(2, (float) ambSlide2.getValue() / 255f);
                ambVal2.setText(String.valueOf(ambSlide2.getValue()));
            }
        });

        diffuseSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                diffuseSlide2 = (javax.swing.JSlider) e.getSource();
                lightSource[2].setDiffuseValue(0, (float) diffuseSlide2.getValue() / 255f);
                lightSource[2].setDiffuseValue(1, (float) diffuseSlide2.getValue() / 255f);
                lightSource[2].setDiffuseValue(2, (float) diffuseSlide2.getValue() / 255f);
                diffuseVal2.setText(String.valueOf(diffuseSlide2.getValue()));
            }
        });

        specuSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                specuSlide2 = (javax.swing.JSlider) e.getSource();
                lightSource[2].setSpecularValue(0, (float) specuSlide2.getValue() / 255f);
                lightSource[2].setSpecularValue(1, (float) specuSlide2.getValue() / 255f);
                lightSource[2].setSpecularValue(2, (float) specuSlide2.getValue() / 255f);
                specuVal2.setText(String.valueOf(specuSlide2.getValue()));
            }
        });

        togGuideLight0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightSource[0].toggleLightGuide();
            }
        });
        togGuideLight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightSource[1].toggleLightGuide();
            }
        });
        togGuideLight2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightSource[2].toggleLightGuide();
            }
        });

        lightColorBtn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightSource[0].toggleLighting();
            }
        });
        lightColorBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightSource[1].toggleLighting();
            }
        });
        lightColorBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lightSource[2].toggleLighting();
            }
        });

        wValLightBtn0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wValLightBtn0 = (javax.swing.JSpinner) e.getSource();
                lightSource[0].setLightPosition(3, (float) wValLightBtn0.getValue());
            }
        });
        wValLightBtn1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wValLightBtn1 = (javax.swing.JSpinner) e.getSource();
                lightSource[1].setLightPosition(3, (float) wValLightBtn1.getValue());
            }
        });
        wValLightBtn2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wValLightBtn2 = (javax.swing.JSpinner) e.getSource();
                lightSource[2].setLightPosition(3, (float) wValLightBtn2.getValue());
            }
        });

        ambColBtn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI ambCustom0 = new LightCustomColorGUI(lightSource[0], 0, 0, "Custom Ambient 0");
            }
        });
        diffuseColBtn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI diffuseCustom0 = new LightCustomColorGUI(lightSource[0], 1, 0, "Custom Diffuse 0");
            }
        });
        specuColBtn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI specuCustom0 = new LightCustomColorGUI(lightSource[0], 2, 0, "Custom Specular 0");
            }
        });
        ambColBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI ambCustom1 = new LightCustomColorGUI(lightSource[1], 0, 1, "Custom Ambient 1");
            }
        });
        diffuseColBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI diffuseCustom1 = new LightCustomColorGUI(lightSource[1], 1, 1, "Custom Diffuse 1");
            }
        });
        specuColBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI specuCustom1 = new LightCustomColorGUI(lightSource[1], 2, 1, "Custom Specular 1");
            }
        });
        ambColBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI ambCustom0 = new LightCustomColorGUI(lightSource[2], 0, 2, "Custom Ambient 2");
            }
        });
        diffuseColBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI diffuseCustom0 = new LightCustomColorGUI(lightSource[2], 1, 2, "Custom Diffuse 2");
            }
        });
        specuColBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightCustomColorGUI specuCustom0 = new LightCustomColorGUI(lightSource[2], 2, 2, "Custom Specular 2");
            }
        });

        //
        ambColBtn0.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ambColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ambColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        diffuseColBtn0.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diffuseColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diffuseColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        specuColBtn0.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                specuColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                specuColBtn0.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        ambColBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ambColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ambColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        diffuseColBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diffuseColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diffuseColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        specuColBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                specuColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                specuColBtn1.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        ambColBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ambColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ambColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        diffuseColBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diffuseColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                diffuseColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });
        specuColBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                specuColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick01.png"));

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                specuColBtn2.setIcon(new javax.swing.ImageIcon(projectDir + "img\\colpick00.png"));

            }
        });

    }

}
