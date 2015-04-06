
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
public class SeaColorGUI {

    private javax.swing.JDialog frame;
    private javax.swing.JPanel panel;
    private javax.swing.JButton button;
    private javax.swing.JLabel redLbl;
    private javax.swing.JLabel greenLbl;
    private javax.swing.JLabel blueLbl;
    private javax.swing.JLabel alphaLbl;
    private javax.swing.JSlider redSlider;
    private javax.swing.JSlider greenSlider;
    private javax.swing.JSlider blueSlider;
    private javax.swing.JSlider alphaSlider;
    private javax.swing.JTextField redVal;
    private javax.swing.JTextField greenVal;
    private javax.swing.JTextField blueVal;
    private javax.swing.JTextField alphaVal;
    private javax.swing.JButton toggleSeaVsblty;

    SeaContainer sea;

    public SeaColorGUI(final SeaContainer sea) {
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

        this.sea = sea;

        frame = new javax.swing.JDialog();
        panel = new javax.swing.JPanel();
        redLbl = new javax.swing.JLabel();
        redSlider = new javax.swing.JSlider();
        greenLbl = new javax.swing.JLabel();
        blueLbl = new javax.swing.JLabel();
        alphaLbl = new javax.swing.JLabel();
        alphaSlider = new javax.swing.JSlider();
        blueSlider = new javax.swing.JSlider();
        greenSlider = new javax.swing.JSlider();
        alphaVal = new javax.swing.JTextField();
        redVal = new javax.swing.JTextField();
        greenVal = new javax.swing.JTextField();
        blueVal = new javax.swing.JTextField();
        toggleSeaVsblty = new javax.swing.JButton();

        frame.setAlwaysOnTop(true);
        frame.setBackground(new java.awt.Color(102, 102, 255));
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame.setResizable(false);
        frame.setTitle("Sea Color");

        panel.setBackground(new java.awt.Color(64, 64, 64));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redLbl.setForeground(new java.awt.Color(223, 223, 223));
        redLbl.setText("Red");
        panel.add(redLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 34, 34, 45));

        redSlider.setBackground(new java.awt.Color(64, 64, 64));
        redSlider.setForeground(new java.awt.Color(255, 153, 0));
        redSlider.setMajorTickSpacing(255);
        redSlider.setMaximum(255);
        redSlider.setPaintLabels(true);
        redSlider.setPaintTicks(true);
        redSlider.setValue((int) sea.getSeaRedValue());
        panel.add(redSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 255, -1));

        greenLbl.setForeground(new java.awt.Color(223, 223, 223));
        greenLbl.setText("Green");
        panel.add(greenLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 85, 34, 45));

        blueLbl.setForeground(new java.awt.Color(223, 223, 223));
        blueLbl.setText("Blue");
        panel.add(blueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 136, 34, 45));

        alphaLbl.setForeground(new java.awt.Color(223, 223, 223));
        alphaLbl.setText("Alpha");
        panel.add(alphaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 187, 34, 45));

        alphaSlider.setBackground(new java.awt.Color(64, 64, 64));
        alphaSlider.setForeground(new java.awt.Color(255, 153, 0));
        alphaSlider.setMajorTickSpacing(10);
        alphaSlider.setPaintLabels(true);
        alphaSlider.setPaintTicks(true);
        float seaAlphaInt = sea.getSeaAlphaValue() * 100;
        alphaSlider.setValue((int) seaAlphaInt);
        panel.add(alphaSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 187, 255, -1));

        blueSlider.setBackground(new java.awt.Color(64, 64, 64));
        blueSlider.setForeground(new java.awt.Color(255, 153, 0));
        blueSlider.setMajorTickSpacing(255);
        blueSlider.setMaximum(255);
        blueSlider.setPaintLabels(true);
        blueSlider.setPaintTicks(true);
        blueSlider.setValue((int) sea.getSeaBlueValue());
        panel.add(blueSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 136, 255, -1));

        greenSlider.setBackground(new java.awt.Color(64, 64, 64));
        greenSlider.setForeground(new java.awt.Color(255, 153, 0));
        greenSlider.setMajorTickSpacing(255);
        greenSlider.setMaximum(255);
        greenSlider.setPaintLabels(true);
        greenSlider.setPaintTicks(true);
        greenSlider.setValue((int) sea.getSeaGreenValue());

        redVal.setText(String.valueOf(redSlider.getValue()));
        greenVal.setText(String.valueOf(greenSlider.getValue()));
        blueVal.setText(String.valueOf(blueSlider.getValue()));
        alphaVal.setText(String.valueOf(alphaSlider.getValue()));

        panel.add(greenSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 85, 255, -1));
        panel.add(alphaVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 50, -1));
        panel.add(redVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 50, -1));
        panel.add(greenVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 50, -1));
        panel.add(blueVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 50, -1));

        toggleSeaVsblty.setText("Sea Visibility (O)");
        panel.add(toggleSeaVsblty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redSlider = (javax.swing.JSlider) e.getSource();
                sea.setSeaRedValue((int) redSlider.getValue());
                redVal.setText(String.valueOf(redSlider.getValue()));
            }
        });
        redVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(redVal.getText());
                sea.setSeaRedValue(input);
                redSlider.setValue(input);
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenSlider = (javax.swing.JSlider) e.getSource();
                sea.setSeaGreenValue((int) greenSlider.getValue());
                greenVal.setText(String.valueOf(greenSlider.getValue()));
            }
        });
        greenVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(greenVal.getText());
                sea.setSeaGreenValue(input);
                greenSlider.setValue(input);
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueSlider = (javax.swing.JSlider) e.getSource();
                sea.setSeaBlueValue((int) blueSlider.getValue());
                blueVal.setText(String.valueOf(blueSlider.getValue()));
            }
        });
        blueVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(blueVal.getText());
                sea.setSeaBlueValue(input);
                blueSlider.setValue(input);
            }
        });

        alphaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alphaSlider = (javax.swing.JSlider) e.getSource();
                sea.setSeaAlphaValue((float) alphaSlider.getValue()/ (float) 100);
                alphaVal.setText(String.valueOf(alphaSlider.getValue()));
            }
        });
        alphaVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(alphaVal.getText());
                sea.setSeaAlphaValue((float) input / (float) 100);
                alphaSlider.setValue(input);
            }
        });
        toggleSeaVsblty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sea.toggleSeaVisibility();
            }
        });
    }

}
