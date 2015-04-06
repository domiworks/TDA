
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
public class LightCustomColorGUI {

    float colorRedTemp;
    float colorGreenTemp;
    float colorBlueTemp;
    float colorAlphaTemp;

    private javax.swing.JDialog frame;
    private javax.swing.JLabel alphaLbl;
    private javax.swing.JSlider alphaSlider;
    private javax.swing.JTextField alphaVal;
    private javax.swing.JLabel blueLbl;
    private javax.swing.JSlider blueSlider;
    private javax.swing.JTextField blueVal;
    private javax.swing.JLabel greenLbl;
    private javax.swing.JSlider greenSlider;
    private javax.swing.JTextField greenVal;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel redLbl;
    private javax.swing.JSlider redSlider;
    private javax.swing.JTextField redVal;

    LightContainer lightSource;

    //final TheCanvas canvas
    public LightCustomColorGUI(final LightContainer lightSource, final int lightControlRow, final int lightNumber, String frameTitle) {
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

        frame = new javax.swing.JDialog();
        panel = new javax.swing.JPanel();
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

        frame.setAlwaysOnTop(true);
        frame.setBackground(new java.awt.Color(102, 102, 255));
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame.setResizable(false);
        frame.setTitle(frameTitle);

        panel.setBackground(new java.awt.Color(64, 64, 64));
        //panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diffuse 0", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redLbl.setForeground(new java.awt.Color(223, 223, 223));
        redLbl.setText("Red");
        panel.add(redLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 34, 34, 45));

        greenLbl.setForeground(new java.awt.Color(223, 223, 223));
        greenLbl.setText("Green");
        panel.add(greenLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 85, 34, 45));

        blueLbl.setForeground(new java.awt.Color(223, 223, 223));
        blueLbl.setText("Blue");
        panel.add(blueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 136, 34, 45));

        alphaLbl.setForeground(new java.awt.Color(223, 223, 223));
        alphaLbl.setText("Alpha");
        //panel.add(alphaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 187, 34, 45));

        alphaSlider.setBackground(new java.awt.Color(64, 64, 64));
        alphaSlider.setForeground(new java.awt.Color(255, 153, 0));
        alphaSlider.setMajorTickSpacing(10);
        alphaSlider.setPaintLabels(true);
        alphaSlider.setPaintTicks(true);
        if (lightControlRow == 0) {
            colorAlphaTemp = lightSource.getAmbientValue(3) * 255f;
        } else if (lightControlRow == 1) {
            colorAlphaTemp = lightSource.getDiffuseValue(3) * 255f;
        } else if (lightControlRow == 2) {
            colorAlphaTemp = lightSource.getSpecularValue(3) * 255f;
        }
        alphaSlider.setValue((int) colorAlphaTemp);
        alphaVal.setText(String.valueOf(alphaSlider.getValue()));
        //panel.add(alphaSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 187, 255, -1));

        blueSlider.setBackground(new java.awt.Color(64, 64, 64));
        blueSlider.setForeground(new java.awt.Color(255, 153, 0));
        blueSlider.setMajorTickSpacing(255);
        blueSlider.setMaximum(255);
        blueSlider.setPaintLabels(true);
        blueSlider.setPaintTicks(true);
        if (lightControlRow == 0) {
            colorBlueTemp = lightSource.getAmbientValue(2) * 255f;
        } else if (lightControlRow == 1) {
            colorBlueTemp = lightSource.getDiffuseValue(2) * 255f;
        } else if (lightControlRow == 2) {
            colorBlueTemp = lightSource.getSpecularValue(2) * 255f;
        }
        blueSlider.setValue((int) colorBlueTemp);
        blueVal.setText(String.valueOf(blueSlider.getValue()));
        panel.add(blueSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 136, 255, -1));

        redSlider.setBackground(new java.awt.Color(64, 64, 64));
        redSlider.setForeground(new java.awt.Color(255, 153, 0));
        redSlider.setMajorTickSpacing(255);
        redSlider.setMaximum(255);
        redSlider.setPaintLabels(true);
        redSlider.setPaintTicks(true);
        if (lightControlRow == 0) {
            colorRedTemp = lightSource.getAmbientValue(0) * 255f;
        } else if (lightControlRow == 1) {
            colorRedTemp = lightSource.getDiffuseValue(0) * 255f;
        } else if (lightControlRow == 2) {
            colorRedTemp = lightSource.getSpecularValue(0) * 255f;
        }
        redSlider.setValue((int) colorRedTemp);
        redVal.setText(String.valueOf(redSlider.getValue()));
        panel.add(redSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 255, -1));
        //panel.add(alphaVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 50, -1));
        panel.add(redVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 50, -1));
        panel.add(greenVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 50, -1));
        panel.add(blueVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 50, -1));

        greenSlider.setBackground(new java.awt.Color(64, 64, 64));
        greenSlider.setForeground(new java.awt.Color(255, 153, 0));
        greenSlider.setMajorTickSpacing(255);
        greenSlider.setMaximum(255);
        greenSlider.setPaintLabels(true);
        greenSlider.setPaintTicks(true);
        if (lightControlRow == 0) {
            colorGreenTemp = lightSource.getAmbientValue(1) * 255f;
        } else if (lightControlRow == 1) {
            colorGreenTemp = lightSource.getDiffuseValue(1) * 255f;
        } else if (lightControlRow == 2) {
            colorGreenTemp = lightSource.getSpecularValue(1) * 255f;
        }
        greenSlider.setValue((int) colorGreenTemp);
        greenVal.setText(String.valueOf(greenSlider.getValue()));
        panel.add(greenSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 85, 255, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );

        //float seaAlphaInt = canvas.getSeaAlpha()*100;
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redSlider = (javax.swing.JSlider) e.getSource();
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(0, (float) redSlider.getValue() / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(0, (float) redSlider.getValue() / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(0, (float) redSlider.getValue() / 255f);
                }
                //canvas.setSeaRedClr((int)redSlider.getValue());
                redVal.setText(String.valueOf(redSlider.getValue()));
            }
        });
        redVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(redVal.getText());
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(0, (float) input / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(0, (float) input / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(0, (float) input / 255f);
                }
                //canvas.setSeaRedClr(input);
                redSlider.setValue(input);
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenSlider = (javax.swing.JSlider) e.getSource();
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(1, (float) greenSlider.getValue() / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(1, (float) greenSlider.getValue() / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(1, (float) greenSlider.getValue() / 255f);
                }
                //canvas.setSeaGreenClr((int)greenSlider.getValue());
                greenVal.setText(String.valueOf(greenSlider.getValue()));
            }
        });
        greenVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(greenVal.getText());
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(1, (float) input / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(1, (float) input / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(1, (float) input / 255f);
                }
                //canvas.setSeaGreenClr(input);
                greenSlider.setValue(input);
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueSlider = (javax.swing.JSlider) e.getSource();
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(2, (float) blueSlider.getValue() / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(2, (float) blueSlider.getValue() / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(2, (float) blueSlider.getValue() / 255f);
                }
                //canvas.setSeaBlueClr((int)blueSlider.getValue());
                blueVal.setText(String.valueOf(blueSlider.getValue()));
            }
        });
        blueVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(blueVal.getText());
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(2, (float) input / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(2, (float) input / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(2, (float) input / 255f);
                }
                //canvas.setSeaBlueClr(input);
                blueSlider.setValue(input);
            }
        });

        alphaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alphaSlider = (javax.swing.JSlider) e.getSource();
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(3, (float) alphaSlider.getValue() / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(3, (float) alphaSlider.getValue() / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(3, (float) alphaSlider.getValue() / 255f);
                }
                //canvas.setSeaAlpha((float)alphaSlider.getValue());
                alphaVal.setText(String.valueOf(alphaSlider.getValue()));
            }
        });
        alphaVal.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int input = Integer.parseInt(alphaVal.getText());
                if (lightControlRow == 0) {
                    lightSource.setAmbientValue(3, (float) input / 255f);
                } else if (lightControlRow == 1) {
                    lightSource.setDiffuseValue(3, (float) input / 255f);
                } else if (lightControlRow == 2) {
                    lightSource.setSpecularValue(3, (float) input / 255f);
                }
                //canvas.setSeaAlpha(input);
                alphaSlider.setValue(input);
            }
        });

    }

}
