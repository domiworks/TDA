
import java.awt.Font;
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
public class LandColorGUI {

    private javax.swing.JDialog frame;
    private javax.swing.JLabel alphaLbl0;
    private javax.swing.JLabel alphaLbl1;
    private javax.swing.JLabel alphaLbl2;
    private javax.swing.JSlider alphaSlide0;
    private javax.swing.JSlider alphaSlide1;
    private javax.swing.JSlider alphaSlide2;
    private javax.swing.JTextField alphaVal0;
    private javax.swing.JTextField alphaVal1;
    private javax.swing.JTextField alphaVal2;
    private javax.swing.JLabel blueLbl0;
    private javax.swing.JLabel blueLbl1;
    private javax.swing.JLabel blueLbl2;
    private javax.swing.JSlider blueSlide0;
    private javax.swing.JSlider blueSlide1;
    private javax.swing.JSlider blueSlide2;
    private javax.swing.JTextField blueVal0;
    private javax.swing.JTextField blueVal1;
    private javax.swing.JTextField blueVal2;
    private javax.swing.JLabel bottomMidLevelLbl;
    private javax.swing.JSlider bottomMidLevelSlide;
    private javax.swing.JTextField bottomMidLevelVal;
    private javax.swing.JLabel greenLbl0;
    private javax.swing.JLabel greenLbl1;
    private javax.swing.JLabel greenLbl2;
    private javax.swing.JSlider greenSlide0;
    private javax.swing.JSlider greenSlide1;
    private javax.swing.JSlider greenSlide2;
    private javax.swing.JTextField greenVal0;
    private javax.swing.JTextField greenVal1;
    private javax.swing.JTextField greenVal2;
    private javax.swing.JPanel hiColoringPanel;
    private javax.swing.JPanel lowColoringPanel;
    private javax.swing.JPanel midColoringPanel;
    private javax.swing.JLabel midHiLevelLbl;
    private javax.swing.JSlider midHiLevelSlide;
    private javax.swing.JTextField midHiLevelVal;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel redLbl0;
    private javax.swing.JLabel redLbl1;
    private javax.swing.JLabel redLbl2;
    private javax.swing.JSlider redSlide0;
    private javax.swing.JSlider redSlide1;
    private javax.swing.JSlider redSlide2;
    private javax.swing.JTextField redVal0;
    private javax.swing.JTextField redVal1;
    private javax.swing.JTextField redVal2;

    LandColoring landColor;

    public LandColorGUI(final LandColoring landColor) {
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
        this.landColor = landColor;
        Font font = new Font("Sans Serif", Font.PLAIN, 9);

        frame = new javax.swing.JDialog();
        frame.setResizable(false);
        frame.setTitle("Landscape Color");

        panel = new javax.swing.JPanel();
        midHiLevelLbl = new javax.swing.JLabel();
        midHiLevelSlide = new javax.swing.JSlider();
        bottomMidLevelLbl = new javax.swing.JLabel();
        bottomMidLevelSlide = new javax.swing.JSlider();
        midHiLevelVal = new javax.swing.JTextField();
        bottomMidLevelVal = new javax.swing.JTextField();
        lowColoringPanel = new javax.swing.JPanel();
        redLbl0 = new javax.swing.JLabel();
        greenLbl0 = new javax.swing.JLabel();
        blueLbl0 = new javax.swing.JLabel();
        alphaLbl0 = new javax.swing.JLabel();
        blueSlide0 = new javax.swing.JSlider();
        greenSlide0 = new javax.swing.JSlider();
        redSlide0 = new javax.swing.JSlider();
        alphaSlide0 = new javax.swing.JSlider();
        redVal0 = new javax.swing.JTextField();
        greenVal0 = new javax.swing.JTextField();
        blueVal0 = new javax.swing.JTextField();
        alphaVal0 = new javax.swing.JTextField();
        midColoringPanel = new javax.swing.JPanel();
        redLbl1 = new javax.swing.JLabel();
        greenLbl1 = new javax.swing.JLabel();
        blueLbl1 = new javax.swing.JLabel();
        alphaLbl1 = new javax.swing.JLabel();
        blueSlide1 = new javax.swing.JSlider();
        greenSlide1 = new javax.swing.JSlider();
        redSlide1 = new javax.swing.JSlider();
        alphaSlide1 = new javax.swing.JSlider();
        redVal1 = new javax.swing.JTextField();
        greenVal1 = new javax.swing.JTextField();
        blueVal1 = new javax.swing.JTextField();
        alphaVal1 = new javax.swing.JTextField();
        hiColoringPanel = new javax.swing.JPanel();
        redLbl2 = new javax.swing.JLabel();
        greenLbl2 = new javax.swing.JLabel();
        blueLbl2 = new javax.swing.JLabel();
        alphaLbl2 = new javax.swing.JLabel();
        blueSlide2 = new javax.swing.JSlider();
        greenSlide2 = new javax.swing.JSlider();
        redSlide2 = new javax.swing.JSlider();
        alphaSlide2 = new javax.swing.JSlider();
        redVal2 = new javax.swing.JTextField();
        greenVal2 = new javax.swing.JTextField();
        blueVal2 = new javax.swing.JTextField();
        alphaVal2 = new javax.swing.JTextField();

        frame.setBackground(new java.awt.Color(102, 102, 255));
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel.setBackground(new java.awt.Color(64, 64, 64));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        midHiLevelLbl.setForeground(new java.awt.Color(223, 223, 223));
        midHiLevelLbl.setText("Mid to Hi");
        panel.add(midHiLevelLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 34, 60, 45));

        midHiLevelSlide.setBackground(new java.awt.Color(64, 64, 64));
        midHiLevelSlide.setForeground(new java.awt.Color(255, 153, 0));
        midHiLevelSlide.setMajorTickSpacing(10);
        midHiLevelSlide.setPaintLabels(true);
        midHiLevelSlide.setPaintTicks(true);
        float midHiLevelSlideInt = landColor.getMidHiLevel() * 100;
        midHiLevelSlide.setValue((int) midHiLevelSlideInt);
        midHiLevelSlide.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        midHiLevelSlide.updateUI();
        panel.add(midHiLevelSlide, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 34, 870, -1));

        bottomMidLevelLbl.setForeground(new java.awt.Color(223, 223, 223));
        bottomMidLevelLbl.setText("Low to Mid");
        panel.add(bottomMidLevelLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 85, 60, 45));

        bottomMidLevelSlide.setBackground(new java.awt.Color(64, 64, 64));
        bottomMidLevelSlide.setForeground(new java.awt.Color(255, 153, 0));
        bottomMidLevelSlide.setMajorTickSpacing(10);
        bottomMidLevelSlide.setPaintLabels(true);
        bottomMidLevelSlide.setPaintTicks(true);
        float bottomMidLevelSlideInt = landColor.getBottomMidLevel() * 100;
        bottomMidLevelSlide.setValue((int) bottomMidLevelSlideInt);
        bottomMidLevelSlide.updateUI();
        bottomMidLevelSlide.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomMidLevelSlide.updateUI();
        panel.add(bottomMidLevelSlide, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 85, 870, -1));
        panel.add(midHiLevelVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 40, -1));
        panel.add(bottomMidLevelVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 40, -1));

        midHiLevelVal.setText(String.valueOf(midHiLevelSlide.getValue() * 0.01));
        bottomMidLevelVal.setText(String.valueOf(bottomMidLevelSlide.getValue() * 0.01));

        lowColoringPanel.setBackground(new java.awt.Color(64, 64, 64));
        lowColoringPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Low Coloring", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        redLbl0.setForeground(new java.awt.Color(223, 223, 223));
        redLbl0.setText("Red");

        greenLbl0.setForeground(new java.awt.Color(223, 223, 223));
        greenLbl0.setText("Green");

        blueLbl0.setForeground(new java.awt.Color(223, 223, 223));
        blueLbl0.setText("Blue");

        alphaLbl0.setForeground(new java.awt.Color(223, 223, 223));
        alphaLbl0.setText("Alpha");

        redSlide0.setBackground(new java.awt.Color(64, 64, 64));
        redSlide0.setForeground(new java.awt.Color(255, 153, 0));
        redSlide0.setMajorTickSpacing(255);
        redSlide0.setMaximum(255);
        redSlide0.setPaintLabels(true);
        redSlide0.setPaintTicks(true);
        float redSlide0Int = landColor.getBottomColor(0) * 255f;
        redSlide0.setValue((int) redSlide0Int);
        redSlide0.updateUI();

        greenSlide0.setBackground(new java.awt.Color(64, 64, 64));
        greenSlide0.setForeground(new java.awt.Color(255, 153, 0));
        greenSlide0.setMajorTickSpacing(255);
        greenSlide0.setMaximum(255);
        greenSlide0.setPaintLabels(true);
        greenSlide0.setPaintTicks(true);
        float greenSlide0Int = landColor.getBottomColor(1) * 255f;
        greenSlide0.setValue((int) greenSlide0Int);
        greenSlide0.updateUI();

        blueSlide0.setBackground(new java.awt.Color(64, 64, 64));
        blueSlide0.setForeground(new java.awt.Color(255, 153, 0));
        blueSlide0.setMajorTickSpacing(255);
        blueSlide0.setMaximum(255);
        blueSlide0.setPaintLabels(true);
        blueSlide0.setPaintTicks(true);
        float blueSlide0Int = landColor.getBottomColor(2) * 255f;
        blueSlide0.setValue((int) blueSlide0Int);
        blueSlide0.updateUI();

        alphaSlide0.setBackground(new java.awt.Color(64, 64, 64));
        alphaSlide0.setForeground(new java.awt.Color(255, 153, 0));
        alphaSlide0.setMajorTickSpacing(255);
        alphaSlide0.setMaximum(255);
        alphaSlide0.setPaintLabels(true);
        alphaSlide0.setPaintTicks(true);
        float alphaSlide0Int = landColor.getBottomColor(3) * 255;
        alphaSlide0.setValue((int) alphaSlide0Int);
        alphaSlide0.updateUI();

        redVal0.setText(String.valueOf(redSlide0.getValue()));
        greenVal0.setText(String.valueOf(greenSlide0.getValue()));
        blueVal0.setText(String.valueOf(blueSlide0.getValue()));
        alphaVal0.setText(String.valueOf(alphaSlide0.getValue()));

        javax.swing.GroupLayout lowColoringPanelLayout = new javax.swing.GroupLayout(lowColoringPanel);
        lowColoringPanel.setLayout(lowColoringPanelLayout);
        lowColoringPanelLayout.setHorizontalGroup(
                lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addComponent(redLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(redSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(redVal0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addComponent(greenLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(greenSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(greenVal0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addComponent(blueLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(blueSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(blueVal0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addComponent(alphaLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(alphaSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(alphaVal0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lowColoringPanelLayout.setVerticalGroup(
                lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(redLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(redSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(redVal0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(greenLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(greenSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(greenVal0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(blueLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(blueSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(blueVal0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lowColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(alphaLbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(alphaSlide0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(lowColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(alphaVal0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.add(lowColoringPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 340, 240));

        midColoringPanel.setBackground(new java.awt.Color(64, 64, 64));
        midColoringPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mid Coloring", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        redLbl1.setForeground(new java.awt.Color(223, 223, 223));
        redLbl1.setText("Red");

        greenLbl1.setForeground(new java.awt.Color(223, 223, 223));
        greenLbl1.setText("Green");

        blueLbl1.setForeground(new java.awt.Color(223, 223, 223));
        blueLbl1.setText("Blue");

        alphaLbl1.setForeground(new java.awt.Color(223, 223, 223));
        alphaLbl1.setText("Alpha");

        redSlide1.setBackground(new java.awt.Color(64, 64, 64));
        redSlide1.setForeground(new java.awt.Color(255, 153, 0));
        redSlide1.setMajorTickSpacing(255);
        redSlide1.setMaximum(255);
        redSlide1.setPaintLabels(true);
        redSlide1.setPaintTicks(true);
        float redSlide1Int = landColor.getMidColor(0) * 255f;
        redSlide1.setValue((int) redSlide1Int);
        redSlide1.updateUI();

        greenSlide1.setBackground(new java.awt.Color(64, 64, 64));
        greenSlide1.setForeground(new java.awt.Color(255, 153, 0));
        greenSlide1.setMajorTickSpacing(255);
        greenSlide1.setMaximum(255);
        greenSlide1.setPaintLabels(true);
        greenSlide1.setPaintTicks(true);
        float greenSlide1Int = landColor.getMidColor(1) * 255f;
        greenSlide1.setValue((int) greenSlide1Int);
        greenSlide1.updateUI();

        blueSlide1.setBackground(new java.awt.Color(64, 64, 64));
        blueSlide1.setForeground(new java.awt.Color(255, 153, 0));
        blueSlide1.setMajorTickSpacing(255);
        blueSlide1.setMaximum(255);
        blueSlide1.setPaintLabels(true);
        blueSlide1.setPaintTicks(true);
        float blueSlide1Int = landColor.getMidColor(2) * 255f;
        blueSlide1.setValue((int) blueSlide1Int);
        blueSlide1.updateUI();

        alphaSlide1.setBackground(new java.awt.Color(64, 64, 64));
        alphaSlide1.setForeground(new java.awt.Color(255, 153, 0));
        alphaSlide1.setMajorTickSpacing(255);
        alphaSlide1.setMaximum(255);
        alphaSlide1.setPaintLabels(true);
        alphaSlide1.setPaintTicks(true);
        float alphaSlide1Int = landColor.getMidColor(3) * 255;
        alphaSlide1.setValue((int) alphaSlide1Int);
        alphaSlide1.updateUI();

        redVal1.setText(String.valueOf(redSlide1.getValue()));
        greenVal1.setText(String.valueOf(greenSlide1.getValue()));
        blueVal1.setText(String.valueOf(blueSlide1.getValue()));
        alphaVal1.setText(String.valueOf(alphaSlide1.getValue()));

        javax.swing.GroupLayout midColoringPanelLayout = new javax.swing.GroupLayout(midColoringPanel);
        midColoringPanel.setLayout(midColoringPanelLayout);
        midColoringPanelLayout.setHorizontalGroup(
                midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(midColoringPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addComponent(redLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(redSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(redVal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addComponent(greenLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(greenSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(greenVal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addComponent(blueLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(blueSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(blueVal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, midColoringPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alphaLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(alphaSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alphaVal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        midColoringPanelLayout.setVerticalGroup(
                midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(midColoringPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(redLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(redSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(redVal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(greenLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(greenSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(greenVal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(blueLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(blueSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(blueVal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(midColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(alphaLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(alphaSlide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(midColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(alphaVal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );

        panel.add(midColoringPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 340, 240));

        hiColoringPanel.setBackground(new java.awt.Color(64, 64, 64));
        hiColoringPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hi Coloring", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));

        redLbl2.setForeground(new java.awt.Color(223, 223, 223));
        redLbl2.setText("Red");

        greenLbl2.setForeground(new java.awt.Color(223, 223, 223));
        greenLbl2.setText("Green");

        blueLbl2.setForeground(new java.awt.Color(223, 223, 223));
        blueLbl2.setText("Blue");

        alphaLbl2.setForeground(new java.awt.Color(223, 223, 223));
        alphaLbl2.setText("Alpha");

        redSlide2.setBackground(new java.awt.Color(64, 64, 64));
        redSlide2.setForeground(new java.awt.Color(255, 153, 0));
        redSlide2.setMajorTickSpacing(255);
        redSlide2.setMaximum(255);
        redSlide2.setPaintLabels(true);
        redSlide2.setPaintTicks(true);
        float redSlide2Int = landColor.getHiColor(0) * 255;
        redSlide2.setValue((int) redSlide2Int);
        redSlide2.updateUI();

        greenSlide2.setBackground(new java.awt.Color(64, 64, 64));
        greenSlide2.setForeground(new java.awt.Color(255, 153, 0));
        greenSlide2.setMajorTickSpacing(255);
        greenSlide2.setMaximum(255);
        greenSlide2.setPaintLabels(true);
        greenSlide2.setPaintTicks(true);
        float greenSlide2Int = landColor.getHiColor(1) * 255;
        greenSlide2.setValue((int) greenSlide2Int);
        greenSlide2.updateUI();

        blueSlide2.setBackground(new java.awt.Color(64, 64, 64));
        blueSlide2.setForeground(new java.awt.Color(255, 153, 0));
        blueSlide2.setMajorTickSpacing(255);
        blueSlide2.setMaximum(255);
        blueSlide2.setPaintLabels(true);
        blueSlide2.setPaintTicks(true);
        float blueSlide2Int = landColor.getHiColor(2) * 255;
        blueSlide2.setValue((int) greenSlide2Int);
        blueSlide2.updateUI();

        alphaSlide2.setBackground(new java.awt.Color(64, 64, 64));
        alphaSlide2.setForeground(new java.awt.Color(255, 153, 0));
        alphaSlide2.setMajorTickSpacing(255);
        alphaSlide2.setMaximum(255);
        alphaSlide2.setPaintLabels(true);
        alphaSlide2.setPaintTicks(true);
        float alphaSlide2Int = landColor.getHiColor(3) * 255;
        alphaSlide2.setValue((int) alphaSlide2Int);
        alphaSlide2.updateUI();

        redVal2.setText(String.valueOf(redSlide2.getValue()));
        greenVal2.setText(String.valueOf(greenSlide2.getValue()));
        blueVal2.setText(String.valueOf(blueSlide2.getValue()));
        alphaVal2.setText(String.valueOf(alphaSlide2.getValue()));

        javax.swing.GroupLayout hiColoringPanelLayout = new javax.swing.GroupLayout(hiColoringPanel);
        hiColoringPanel.setLayout(hiColoringPanelLayout);
        hiColoringPanelLayout.setHorizontalGroup(
                hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addComponent(redLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(redSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(redVal2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addComponent(greenLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(greenSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(greenVal2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addComponent(blueLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(blueSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(blueVal2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addComponent(alphaLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(alphaSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(alphaVal2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hiColoringPanelLayout.setVerticalGroup(
                hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(redLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(redSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(redVal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(greenLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(greenSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(greenVal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(blueLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(blueSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(blueVal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(hiColoringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(alphaLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(alphaSlide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(hiColoringPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(alphaVal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );

        panel.add(hiColoringPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 340, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        midHiLevelSlide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                midHiLevelSlide = (javax.swing.JSlider) e.getSource();
                landColor.setMidHiLevel((float) midHiLevelSlide.getValue() / (float) 100);
                midHiLevelVal.setText(String.valueOf((float) midHiLevelSlide.getValue() / (float) 100));
            }
        });
        midHiLevelVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                float input = Float.parseFloat(midHiLevelVal.getText());
                landColor.setMidHiLevel(input);
                midHiLevelSlide.setValue((int) (input * 100));
            }
        });

        bottomMidLevelSlide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                bottomMidLevelSlide = (javax.swing.JSlider) e.getSource();
                landColor.setBottomMidLevel((float) bottomMidLevelSlide.getValue() / (float) 100);
                bottomMidLevelVal.setText(String.valueOf((float) bottomMidLevelSlide.getValue() / (float) 100));
            }
        });
        bottomMidLevelVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                float input = Float.parseFloat(bottomMidLevelVal.getText());
                landColor.setBottomMidLevel(input);
                bottomMidLevelSlide.setValue((int) (input * 100));
            }
        });

        /*-------------------------------------------------- BOTTOM COLORING SECTION --------------------------------------------------*/
        redSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redSlide0 = (javax.swing.JSlider) e.getSource();
                landColor.setBottomColor(0, (float) redSlide0.getValue());
                redVal0.setText(String.valueOf(redSlide0.getValue()));
            }
        });
        redVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(redVal0.getText());
                landColor.setBottomColor(0, input);
                redSlide0.setValue(input);
            }
        });

        greenSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenSlide0 = (javax.swing.JSlider) e.getSource();
                landColor.setBottomColor(1, (float) greenSlide0.getValue());
                greenVal0.setText(String.valueOf(greenSlide0.getValue()));
            }
        });
        greenVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(greenVal0.getText());
                landColor.setBottomColor(1, input);
                greenSlide0.setValue(input);
            }
        });

        blueSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueSlide0 = (javax.swing.JSlider) e.getSource();
                landColor.setBottomColor(2, (float) blueSlide0.getValue());
                blueVal0.setText(String.valueOf(blueSlide0.getValue()));
            }
        });
        blueVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(blueVal0.getText());
                landColor.setBottomColor(2, input);
                blueSlide0.setValue(input);
            }
        });

        alphaSlide0.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alphaSlide0 = (javax.swing.JSlider) e.getSource();
                landColor.setBottomColor(3, (float) alphaSlide0.getValue());
                alphaVal0.setText(String.valueOf(alphaSlide0.getValue()));
            }
        });
        alphaVal0.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(alphaVal0.getText());
                landColor.setBottomColor(3, input);
                alphaSlide0.setValue(input);
            }
        });

        /*-------------------------------------------------- MID COLORING SECTION --------------------------------------------------*/
        redSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redSlide1 = (javax.swing.JSlider) e.getSource();
                landColor.setMidColor(0, (float) redSlide1.getValue());
                redVal1.setText(String.valueOf(redSlide1.getValue()));
            }
        });
        redVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(redVal1.getText());
                landColor.setMidColor(0, input);
                redSlide1.setValue(input);
            }
        });

        greenSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenSlide1 = (javax.swing.JSlider) e.getSource();
                landColor.setMidColor(1, (float) greenSlide1.getValue());
                greenVal1.setText(String.valueOf(greenSlide1.getValue()));
            }
        });
        greenVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(greenVal1.getText());
                landColor.setMidColor(1, input);
                greenSlide1.setValue(input);
            }
        });

        blueSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueSlide1 = (javax.swing.JSlider) e.getSource();
                landColor.setMidColor(2, (float) blueSlide1.getValue());
                blueVal1.setText(String.valueOf(blueSlide1.getValue()));
            }
        });
        blueVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(blueVal1.getText());
                landColor.setMidColor(2, input);
                blueSlide1.setValue(input);
            }
        });

        alphaSlide1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alphaSlide1 = (javax.swing.JSlider) e.getSource();
                landColor.setMidColor(3, (float) alphaSlide1.getValue());
                alphaVal1.setText(String.valueOf(alphaSlide1.getValue()));
            }
        });
        alphaVal1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(alphaVal1.getText());
                landColor.setMidColor(3, input);
                alphaSlide1.setValue(input);
            }
        });

        /*-------------------------------------------------- HI COLORING SECTION --------------------------------------------------*/
        redSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redSlide2 = (javax.swing.JSlider) e.getSource();
                landColor.setHiColor(0, (float) redSlide2.getValue());
                redVal2.setText(String.valueOf(redSlide2.getValue()));
            }
        });
        redVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(redVal2.getText());
                landColor.setHiColor(0, input);
                redSlide2.setValue(input);
            }
        });

        greenSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenSlide2 = (javax.swing.JSlider) e.getSource();
                landColor.setHiColor(1, (float) greenSlide2.getValue());
                greenVal2.setText(String.valueOf(greenSlide2.getValue()));
            }
        });
        greenVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(greenVal2.getText());
                landColor.setHiColor(1, input);
                greenSlide2.setValue(input);
            }
        });

        blueSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueSlide2 = (javax.swing.JSlider) e.getSource();
                landColor.setHiColor(2, (float) blueSlide2.getValue());
                blueVal2.setText(String.valueOf(blueSlide2.getValue()));
            }
        });
        blueVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(blueVal2.getText());
                landColor.setHiColor(2, input);
                blueSlide2.setValue(input);
            }
        });

        alphaSlide2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alphaSlide2 = (javax.swing.JSlider) e.getSource();
                landColor.setHiColor(3, (float) alphaSlide2.getValue());
                alphaVal2.setText(String.valueOf(alphaSlide2.getValue()));
            }
        });
        alphaVal2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(alphaVal2.getText());
                landColor.setHiColor(3, input);
                alphaSlide2.setValue(input);
            }
        });
    }
}
