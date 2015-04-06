
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class TextureControlGUI {

    private javax.swing.JDialog frame;
    private javax.swing.JPanel panel = new javax.swing.JPanel();
    private javax.swing.JLabel skyboxLbl = new javax.swing.JLabel();
    private javax.swing.JLabel landTexLbl = new javax.swing.JLabel();
    private javax.swing.JComboBox skyboxCombox;
    private javax.swing.JComboBox landTexCombox;

    private javax.swing.JSlider redSlider;
    private javax.swing.JSlider greenSlider;

    private javax.swing.JLabel greenVal = new javax.swing.JLabel();
    private javax.swing.JLabel blueVal = new javax.swing.JLabel();

    TheCanvas canvas;

    public TextureControlGUI(final TheCanvas canvas) {
        this.canvas = canvas;
        Font font = new Font("Sans Serif", Font.PLAIN, 9);

        frame = new javax.swing.JDialog();
        frame.setResizable(false);
        frame.setTitle("Texture Chooser");

        panel.setPreferredSize(new Dimension(354, 263));
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(64, 64, 64));
        frame.add(panel);

        //SKYBOX
        skyboxLbl.setText("Skybox ");
        skyboxLbl.setBounds(30, 30, 50, 32);
        skyboxLbl.setVisible(true);
        skyboxLbl.setForeground((new java.awt.Color(223, 223, 223)));
        panel.add(skyboxLbl);

        String[] skyboxComboList = {
            "default",//0
            "dark stormy",//1
            "moon",//2
            "sunset",//3
            "thick cloud",//4
            "tropical sunnyday",//5
            "clear sky", //6
            "moonshine", //7
            "rainy day london",//8
            "rainy day middlesbrough",//9
            "semi cloudy afternoon",//10
            "semi cloudy sunset",//11
            "strom is coming",//12
            "sunny day",//13
            "sunrise starry sky",//14
            "ffffff"//14
        };
        skyboxCombox = new javax.swing.JComboBox(skyboxComboList);
        skyboxCombox.setBounds(80, 30, 200, 32);
        skyboxCombox.setForeground((new java.awt.Color(64, 64, 64)));
        skyboxCombox.setVisible(true);
        panel.add(skyboxCombox);

        //GREEN
        landTexLbl.setText("Land ");
        landTexLbl.setBounds(30, 65, 100, 32);
        landTexLbl.setVisible(true);
        landTexLbl.setForeground((new java.awt.Color(223, 223, 223)));
        panel.add(landTexLbl);

        String[] landTextureComboList = {
            "arid 0",//0
            "arid 1",//1
            "sand 0",//2
            "sand 1",//3
            "snow 0",//4
            "snow 1",//5
            "rock 0",//6 
            "rock 1",//7
            "rock 2",//8
            "rock 3",//9
            "grass and rock 0",//10
            "grass and rock 2",//11
            "grass 0",//12 
            "grass 1",//13
            "eeeeee"//14

        };
        landTexCombox = new javax.swing.JComboBox(landTextureComboList);
        landTexCombox.setBounds(80, 65, 200, 32);
        landTexCombox.setForeground((new java.awt.Color(64, 64, 64)));
        landTexCombox.setVisible(true);
        panel.add(landTexCombox);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        skyboxCombox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skyboxCombox = (javax.swing.JComboBox) e.getSource();
                canvas.textureCustomSkyboxInit(skyboxCombox.getSelectedIndex());

            }
        });

        landTexCombox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                landTexCombox = (javax.swing.JComboBox) e.getSource();
                canvas.textureCustomLandInit(landTexCombox.getSelectedIndex());

            }
        });
    }

}
