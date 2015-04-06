
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class MainGUI {

    //stylesheet
    static private Toolkit toolkit = Toolkit.getDefaultToolkit();

    static private int cntrlPnlW = (int) toolkit.getScreenSize().getWidth();
    static private int cntrlPnlH = 106;
    static private int toolPnlW = 50;

    static private int disPnlW = cntrlPnlW - toolPnlW;

    static private int disPnlH = (int) toolkit.getScreenSize().getHeight() - cntrlPnlH;
    static private int toolPnlH = disPnlH;

    static private Color buttonColor = new Color(0x7d7d7d);
    static private Color liteBrdr = new Color(0x636363);
    static private Color darkBrdr = new Color(0x2a2a2a);
    static private Color fontColor = new Color(0xdfdfdf);
    static private Color bgColor = new Color(0x444444);//new Color(0x707070);

    static private int toolBtnW, toolBtnH = 50;

    // Define constants for the top-level container /* JFRAME Section------------------------------------------------------------------------------------------------ */
    //static GUIStyleSheet ss = new GUIStyleSheet();
    static String TITLE = "TDA Landscape Generator";  // window's title

    static int FPS = 1000; // animator's target frames per second
    static javax.swing.JFrame frame = new javax.swing.JFrame(); // Swing's JFrame or AWT's Frame
    static String projectDir = new File("").getAbsolutePath() + "\\";
   // static String projectDir = "E:\\Dominikus\\Projects\\Dropbox\\private\\Tugas_Akhir\\Code\\JOGLTest_3.7_Landscape\\";
   // static String basePath = new File("").getAbsolutePath();
   

    static javax.swing.JPanel controlPnl;
    static javax.swing.JPanel controlPnl00;
    static javax.swing.JPanel controlPnl01;
    static javax.swing.JPanel displayPnl;
    static javax.swing.JButton generateBtn;
    static javax.swing.JRadioButton gl_quads_rad;
    static javax.swing.JRadioButton gl_traingle_strip_rad;
    static javax.swing.JRadioButton gl_traingles_rad;
    static javax.swing.ButtonGroup groupDrawRadio;
    static javax.swing.JLabel iterationLbl;
    static javax.swing.JTextField iterationTxt;
    static javax.swing.JPanel jPanel1;
    static javax.swing.JLabel roughnessLbl;
    static javax.swing.JTextField roughnessTxt;
    static javax.swing.JLabel saveArrayLbl;
    static javax.swing.JTextField saveArrayTxt;
    static javax.swing.JSeparator separator00;
    static javax.swing.JSeparator separator01;
    static javax.swing.JSeparator separator02;
    static javax.swing.JButton showColorLvlBtn;
    static javax.swing.JButton showFogCtrlBtn;
    static javax.swing.JButton showLightCtrlBtn;
    static javax.swing.JButton showSeaCtrlBtn;
    static javax.swing.JButton showTexCtrlBtn;
    static javax.swing.JButton stopBtn;
    static javax.swing.JTabbedPane tabbedPane;
    static javax.swing.JPanel toolPnl;
    static javax.swing.JLabel zLeftBottomLbl;
    static javax.swing.JTextField zLeftBottomTxt;
    static javax.swing.JLabel zLeftTopLbl;
    static javax.swing.JTextField zLeftTopTxt;
    static javax.swing.JLabel zRightBottomLbl;
    static javax.swing.JTextField zRightBottomTxt;
    static javax.swing.JLabel zRightTopLbl;
    static javax.swing.JTextField zRightTopTxt;

    static boolean isAnimationRunning = false;
    static TheCanvas canvas = null;
    static FPSAnimator animator = null;

    // static GridLayout layout = new GridLayout();
    static TDAEngine tda;
    static HeightMapEngine hm;

    /**
     * The enlandTexObjry main() melandTexObjhod landTexObjo selandTexObjup
     * landTexObjhe landTexObjop-level conlandTexObjainer and
     * anlandTexFilealandTexObjor
     */
    public static void main(String[] args) {

        // Run the GUI codes in the event-dispatching thread for thread safety
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                // Create the top-level container
                frame.setLayout(new BorderLayout());
                frame.setResizable(false);
                frame.setTitle(TITLE);
                frame.setBackground(bgColor);

                groupDrawRadio = new javax.swing.ButtonGroup();
                displayPnl = new javax.swing.JPanel();
                toolPnl = new javax.swing.JPanel();
                showSeaCtrlBtn = new javax.swing.JButton();
                showColorLvlBtn = new javax.swing.JButton();
                showLightCtrlBtn = new javax.swing.JButton();
                showTexCtrlBtn = new javax.swing.JButton();
                showFogCtrlBtn = new javax.swing.JButton();
                controlPnl = new javax.swing.JPanel();
                tabbedPane = new javax.swing.JTabbedPane();
                controlPnl00 = new javax.swing.JPanel();
                iterationLbl = new javax.swing.JLabel();
                roughnessLbl = new javax.swing.JLabel();
                iterationTxt = new javax.swing.JTextField();
                roughnessTxt = new javax.swing.JTextField();
                separator00 = new javax.swing.JSeparator();
                zLeftTopLbl = new javax.swing.JLabel();
                zLeftBottomLbl = new javax.swing.JLabel();
                zLeftTopTxt = new javax.swing.JTextField();
                zLeftBottomTxt = new javax.swing.JTextField();
                zRightTopTxt = new javax.swing.JTextField();
                zRightBottomTxt = new javax.swing.JTextField();
                zRightTopLbl = new javax.swing.JLabel();
                zRightBottomLbl = new javax.swing.JLabel();
                separator01 = new javax.swing.JSeparator();
                jPanel1 = new javax.swing.JPanel();
                gl_traingle_strip_rad = new javax.swing.JRadioButton();
                gl_traingles_rad = new javax.swing.JRadioButton();
                gl_quads_rad = new javax.swing.JRadioButton();
                separator02 = new javax.swing.JSeparator();
                saveArrayLbl = new javax.swing.JLabel();
                saveArrayTxt = new javax.swing.JTextField();
                generateBtn = new javax.swing.JButton();
                stopBtn = new javax.swing.JButton();
                controlPnl01 = new javax.swing.JPanel();

                groupDrawRadio.add(gl_traingle_strip_rad);
                groupDrawRadio.add(gl_traingles_rad);
                groupDrawRadio.add(gl_quads_rad);

                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                frame.setResizable(false);

                displayPnl.setBackground(new java.awt.Color(126, 126, 126));
                displayPnl.setPreferredSize(new Dimension(disPnlW, disPnlH));

                toolPnl.setBackground(new java.awt.Color(64, 64, 64));
                toolPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                toolPnl.setMinimumSize(new Dimension(toolPnlW, toolPnlH));
                toolPnl.setPreferredSize(new Dimension(toolPnlW, toolPnlH));
                toolPnl.setLayout(null);

                showSeaCtrlBtn.setBackground(new java.awt.Color(64, 64, 64));
                showSeaCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\sea00.png")); // NOI18N
                showSeaCtrlBtn.setToolTipText("Sea Color");
                showSeaCtrlBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                showSeaCtrlBtn.setFocusPainted(false);
                showSeaCtrlBtn.setEnabled(isAnimationRunning);
                toolPnl.add(showSeaCtrlBtn);
                showSeaCtrlBtn.setBounds(0, 0, 50, 50);

                showColorLvlBtn.setBackground(new java.awt.Color(64, 64, 64));
                showColorLvlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\color00.png")); // NOI18N
                showColorLvlBtn.setToolTipText("Land Color");
                showColorLvlBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                showColorLvlBtn.setFocusPainted(false);
                showColorLvlBtn.setEnabled(isAnimationRunning);
                toolPnl.add(showColorLvlBtn);
                showColorLvlBtn.setBounds(0, 50, 50, 50);

                showLightCtrlBtn.setBackground(new java.awt.Color(64, 64, 64));
                showLightCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\light00.png")); // NOI18N
                showLightCtrlBtn.setToolTipText("Light Control");
                showLightCtrlBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                showLightCtrlBtn.setFocusPainted(false);
                showLightCtrlBtn.setEnabled(isAnimationRunning);
                toolPnl.add(showLightCtrlBtn);
                showLightCtrlBtn.setBounds(0, 100, 50, 50);

                showTexCtrlBtn.setBackground(new java.awt.Color(64, 64, 64));
                showTexCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\wire00.png")); // NOI18N
                showTexCtrlBtn.setToolTipText("Texture Chooser");
                showTexCtrlBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                showTexCtrlBtn.setFocusPainted(false);
                showTexCtrlBtn.setEnabled(isAnimationRunning);
                toolPnl.add(showTexCtrlBtn);
                showTexCtrlBtn.setBounds(0, 150, 50, 50);

                showFogCtrlBtn.setBackground(new java.awt.Color(64, 64, 64));
                showFogCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\fog00.png")); // NOI18N
                showFogCtrlBtn.setToolTipText("Fog Control");
                showFogCtrlBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                showFogCtrlBtn.setFocusPainted(false);
                showFogCtrlBtn.setEnabled(isAnimationRunning);
                toolPnl.add(showFogCtrlBtn);
                showFogCtrlBtn.setBounds(0, 200, 50, 50);

                javax.swing.GroupLayout displayPnlLayout = new javax.swing.GroupLayout(displayPnl);
                displayPnl.setLayout(displayPnlLayout);
                displayPnlLayout.setHorizontalGroup(
                        displayPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(toolPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                displayPnlLayout.setVerticalGroup(
                        displayPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(toolPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                );

                toolPnl.setBounds(0, 0, toolPnlW, toolPnlH);

                frame.getContentPane().add(displayPnl, java.awt.BorderLayout.CENTER);

                controlPnl.setBackground(new java.awt.Color(64, 64, 64));
                controlPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                controlPnl.setPreferredSize(new Dimension(cntrlPnlW, cntrlPnlH));

                tabbedPane.setBackground(new java.awt.Color(64, 64, 64));
                tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
                tabbedPane.setOpaque(true);

                controlPnl00.setBackground(new java.awt.Color(64, 64, 64));
                controlPnl00.setPreferredSize(new Dimension(cntrlPnlW, 106));

                iterationLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                iterationLbl.setForeground(new java.awt.Color(223, 223, 223));
                iterationLbl.setText("Set Iteration:");

                roughnessLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                roughnessLbl.setForeground(new java.awt.Color(223, 223, 223));
                roughnessLbl.setText("Set Roughness:");

                iterationTxt.setText("8");

                roughnessTxt.setText("1");

                separator00.setBackground(new java.awt.Color(91, 91, 91));
                separator00.setForeground(new java.awt.Color(44, 44, 44));
                separator00.setOrientation(javax.swing.SwingConstants.VERTICAL);

                zLeftTopLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                zLeftTopLbl.setForeground(new java.awt.Color(223, 223, 223));
                zLeftTopLbl.setText("z Left, Top:");

                zLeftBottomLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                zLeftBottomLbl.setForeground(new java.awt.Color(223, 223, 223));
                zLeftBottomLbl.setText("z Left, Bottom:");

                zLeftTopTxt.setText("0");

                zLeftBottomTxt.setText("0");

                zRightTopTxt.setText("0");

                zRightBottomTxt.setText("0");

                zRightTopLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                zRightTopLbl.setForeground(new java.awt.Color(223, 223, 223));
                zRightTopLbl.setText(":z Right, Top");

                zRightBottomLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                zRightBottomLbl.setForeground(new java.awt.Color(223, 223, 223));
                zRightBottomLbl.setText(":z Right, Bottom");

                separator01.setBackground(new java.awt.Color(91, 91, 91));
                separator01.setForeground(new java.awt.Color(44, 44, 44));
                separator01.setOrientation(javax.swing.SwingConstants.VERTICAL);

                jPanel1.setBackground(new java.awt.Color(64, 64, 64));
                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primitives", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.lightGray));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                gl_traingle_strip_rad.setBackground(new java.awt.Color(64, 64, 64));
                gl_traingle_strip_rad.setForeground(new java.awt.Color(223, 223, 223));
                gl_traingle_strip_rad.setSelected(true);
                gl_traingle_strip_rad.setText("Triangle Strip");
                jPanel1.add(gl_traingle_strip_rad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 16));

                gl_traingles_rad.setBackground(new java.awt.Color(64, 64, 64));
                gl_traingles_rad.setForeground(new java.awt.Color(223, 223, 223));
                gl_traingles_rad.setText("Triangles");
                jPanel1.add(gl_traingles_rad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 16));

                gl_quads_rad.setBackground(new java.awt.Color(64, 64, 64));
                gl_quads_rad.setForeground(new java.awt.Color(223, 223, 223));
                gl_quads_rad.setText("Quads");
                jPanel1.add(gl_quads_rad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 16));

                separator02.setBackground(new java.awt.Color(91, 91, 91));
                separator02.setForeground(new java.awt.Color(44, 44, 44));
                separator02.setOrientation(javax.swing.SwingConstants.VERTICAL);

                saveArrayLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                saveArrayLbl.setForeground(new java.awt.Color(223, 223, 223));
                saveArrayLbl.setText("Save Array Name");

                generateBtn.setText("Start");

                stopBtn.setText("Stop");

                javax.swing.GroupLayout controlPnl00Layout = new javax.swing.GroupLayout(controlPnl00);
                controlPnl00.setLayout(controlPnl00Layout);
                controlPnl00Layout.setHorizontalGroup(
                        controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(iterationLbl))
                                        .addComponent(roughnessLbl))
                                .addGap(14, 14, 14)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(iterationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roughnessTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(separator00, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(zLeftTopLbl))
                                        .addComponent(zLeftBottomLbl))
                                .addGap(15, 15, 15)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(zLeftTopTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(zLeftBottomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(zRightTopTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(zRightBottomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(zRightTopLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(zRightBottomLbl))
                                .addGap(20, 20, 20)
                                .addComponent(separator01, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(separator02, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(saveArrayLbl)
                                        .addComponent(saveArrayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                );
                controlPnl00Layout.setVerticalGroup(
                        controlPnl00Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(iterationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(roughnessLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(iterationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(roughnessTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(separator00, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(zLeftTopLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(zLeftBottomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(zLeftTopTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(zLeftBottomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(zRightTopTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(zRightBottomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(zRightTopLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(zRightBottomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(separator01, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(separator02, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(saveArrayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(saveArrayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(controlPnl00Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                generateBtn.setBounds(cntrlPnlW - 240, 35, 100, 50);
                stopBtn.setEnabled(isAnimationRunning);

                tabbedPane.addTab("New", controlPnl00);

                controlPnl01.setBackground(new java.awt.Color(64, 64, 64));
                controlPnl01.setPreferredSize(new Dimension(cntrlPnlW, cntrlPnlH));

                javax.swing.GroupLayout controlPnl01Layout = new javax.swing.GroupLayout(controlPnl01);
                controlPnl01.setLayout(controlPnl01Layout);
                controlPnl01Layout.setHorizontalGroup(
                        controlPnl01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1015, Short.MAX_VALUE)
                );
                controlPnl01Layout.setVerticalGroup(
                        controlPnl01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 98, Short.MAX_VALUE)
                );

                //tabbedPane.addTab("Load", controlPnl01);
                javax.swing.GroupLayout controlPnlLayout = new javax.swing.GroupLayout(controlPnl);
                controlPnl.setLayout(controlPnlLayout);
                controlPnlLayout.setHorizontalGroup(
                        controlPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, Short.MAX_VALUE)
                );
                controlPnlLayout.setVerticalGroup(
                        controlPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPnlLayout.createSequentialGroup()
                                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                frame.getContentPane().add(controlPnl, java.awt.BorderLayout.PAGE_END);

                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setExtendedState(frame.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);

                // Create the OpenGL rendering canvas
                generateBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //run Triangle Division Algorithm and HeightMap

                        byte immediateMode = 0;
                        if (gl_traingle_strip_rad.isSelected()) {
                            immediateMode = 0;
                        } else if (gl_traingles_rad.isSelected()) {
                            immediateMode = 1;
                        } else if (gl_quads_rad.isSelected()) {
                            immediateMode = 2;
                        }

                        byte iteration = Byte.parseByte(iterationTxt.getText());
                        float roughness = Float.parseFloat(roughnessTxt.getText());
                        float kiriAtas = Float.parseFloat(zLeftTopTxt.getText());
                        float kananAtas = Float.parseFloat(zRightTopTxt.getText());
                        float kananBawah = Float.parseFloat(zRightBottomTxt.getText());
                        float kiriBawah = Float.parseFloat(zLeftBottomTxt.getText());
                        try {
                            runTDAandHM(iteration, roughness, kiriAtas, kananAtas, kananBawah, kiriBawah);
                        } catch (IOException ex) {
                            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        isAnimationRunning = true;
                        stopBtn.setEnabled(isAnimationRunning);
                        showSeaCtrlBtn.setEnabled(isAnimationRunning);
                        showColorLvlBtn.setEnabled(isAnimationRunning);
                        showLightCtrlBtn.setEnabled(isAnimationRunning);
                        showTexCtrlBtn.setEnabled(isAnimationRunning);
                        showFogCtrlBtn.setEnabled(isAnimationRunning);
                        generateBtn.setEnabled(!isAnimationRunning);
                        iterationTxt.setEnabled(!isAnimationRunning);
                        roughnessTxt.setEnabled(!isAnimationRunning);
                        zLeftTopTxt.setEnabled(!isAnimationRunning);
                        zRightTopTxt.setEnabled(!isAnimationRunning);
                        zLeftBottomTxt.setEnabled(!isAnimationRunning);
                        zRightBottomTxt.setEnabled(!isAnimationRunning);
                        gl_quads_rad.setEnabled(!isAnimationRunning);
                        gl_traingle_strip_rad.setEnabled(!isAnimationRunning);
                        gl_traingles_rad.setEnabled(!isAnimationRunning);
                        saveArrayTxt.setEnabled(!isAnimationRunning);

                        //Execute when button is pressed
                        try {
                            canvas = new TheCanvas(tda.getMap(), hm.getColorScale(), immediateMode, projectDir);
                        } catch (IOException ex) {
                            Logger.getLogger(TheCanvas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        canvas.setBounds(50, 0, disPnlW, disPnlH);

                        // Create a animator that drives canvas' display() at the specified FPS.
                        displayPnl.add(canvas);
                        displayPnl.updateUI();
                        animator = new FPSAnimator(canvas, FPS, true);
                        animator.start(); // start the animation loop
                    }
                });

                stopBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //run Triangle Division Algorithm and HeightMap

                        animator.stop(); // start the animation loop
                        displayPnl.remove(canvas);
                        displayPnl.updateUI();

                        isAnimationRunning = false;
                        stopBtn.setEnabled(isAnimationRunning);
                        showSeaCtrlBtn.setEnabled(isAnimationRunning);
                        showColorLvlBtn.setEnabled(isAnimationRunning);
                        showLightCtrlBtn.setEnabled(isAnimationRunning);
                        showTexCtrlBtn.setEnabled(isAnimationRunning);
                        showFogCtrlBtn.setEnabled(isAnimationRunning);
                        generateBtn.setEnabled(!isAnimationRunning);
                        iterationTxt.setEnabled(!isAnimationRunning);
                        roughnessTxt.setEnabled(!isAnimationRunning);
                        zLeftTopTxt.setEnabled(!isAnimationRunning);
                        zRightTopTxt.setEnabled(!isAnimationRunning);
                        zLeftBottomTxt.setEnabled(!isAnimationRunning);
                        zRightBottomTxt.setEnabled(!isAnimationRunning);
                        gl_quads_rad.setEnabled(!isAnimationRunning);
                        gl_traingle_strip_rad.setEnabled(!isAnimationRunning);
                        gl_traingles_rad.setEnabled(!isAnimationRunning);
                        saveArrayTxt.setEnabled(!isAnimationRunning);
                    }
                });

                showSeaCtrlBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SeaColorGUI seaControl = new SeaColorGUI(canvas.sea);
                    }
                });
                showSeaCtrlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        showSeaCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\sea01.png"));

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        showSeaCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\sea00.png"));

                    }
                });

                showColorLvlBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LandColorGUI landColor = new LandColorGUI(canvas.landColor);
                    }
                });
                showColorLvlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        showColorLvlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\color01.png"));

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        showColorLvlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\color00.png"));

                    }
                });

                showLightCtrlBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LightControlGUI lightColor = new LightControlGUI(canvas.lightSource, projectDir, canvas.skyboxLength);
                    }
                });
                showLightCtrlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        showLightCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\light01.png"));

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        showLightCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\light00.png"));

                    }
                });

                showTexCtrlBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TextureControlGUI textureControl = new TextureControlGUI(canvas);
                    }
                });
                showTexCtrlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        showTexCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\wire01.png"));

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        showTexCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\wire00.png"));

                    }
                });

                showFogCtrlBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FogControlGUI fogControl = new FogControlGUI(canvas.fog);
                    }
                });
                showFogCtrlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        showFogCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\fog01.png"));

                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        showFogCtrlBtn.setIcon(new javax.swing.ImageIcon(projectDir + "img\\fog00.png"));

                    }
                });
            }

            public void runTDAandHM(byte iteration, float roughness, float kiriAtas, float kananAtas, float kananBawah, float kiriBawah) throws IOException {
                tda = new TDAEngine(projectDir);

                tda.setIteration(iteration);
                tda.setPojokKiriAtas(kiriAtas); 
                tda.setPojokKananAtas(kananAtas);
                tda.setPojokKananBawah(kananBawah);
                tda.setPojokKiriBawah(kiriBawah);

                tda.triangleDivisionAlgorithm(roughness, iteration);// 02. start the engine
                try {
                    tda.printToTextFile(saveArrayTxt.getText() + "_" + "i" + iteration + "-r" + roughness + "-" + kiriAtas + "-" + kananAtas + "-" + kananBawah + "-" + kiriBawah);// 03. print to file
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                hm = new HeightMapEngine(tda.getMap(), projectDir);
                hm.createHeightMap(saveArrayTxt.getText() + "_" + "i" + iteration + "-r" + roughness + "-" + kiriAtas + "-" + kananAtas + "-" + kananBawah + "-" + kiriBawah);

            }

            private String Color(int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
