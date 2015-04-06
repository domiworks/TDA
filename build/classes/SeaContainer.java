
import static javax.media.opengl.GL.GL_CCW;
import static javax.media.opengl.GL.GL_CW;
import javax.media.opengl.GL2;
import static javax.media.opengl.GL2GL3.GL_QUADS;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class SeaContainer {

    private float seaLevel;
    private float seaRed;
    private float seaGreen;
    private float seaBlue;
    private float seaAlpha;
    private boolean toggleSeaVisibility;

    private GL2 gl;

    public SeaContainer(GL2 gl) {
        seaLevel = 0f;
        seaRed = 4f;
        seaGreen = 80f;
        seaBlue = 221f;
        seaAlpha = 0.8f;
        toggleSeaVisibility = true;

        this.gl = gl;
    }

    /*------------*/
    public void setSeaVisibility(boolean input) {
        toggleSeaVisibility = input;
    }

    public boolean getSeaVisibility() {
        return toggleSeaVisibility;
    }

    public void toggleSeaVisibility() {
        if (toggleSeaVisibility == true) {
            toggleSeaVisibility = false;
        } else {
            toggleSeaVisibility = true;
        }
    }

    /*------------*/
    public float getSeaLevel() {
        return seaLevel;
    }

    /*------------*/
    public float getSeaRedValue() {
        return seaRed;
    }

    public float getSeaGreenValue() {
        return seaGreen;
    }

    public float getSeaBlueValue() {
        return seaBlue;
    }

    public float getSeaAlphaValue() {
        return seaAlpha;
    }

    /*------------*/
    public void setSeaRedValue(float input) {
        seaRed = (float) input;
    }

    public void setSeaGreenValue(float input) {
        seaGreen = (float) input;
    }

    public void setSeaBlueValue(float input) {
        seaBlue = (float) input;
    }

    public void setSeaAlphaValue(float input) {
        seaAlpha = (float) input;
    }

    /*------------*/
    public void raiseSeaLevel() {
        seaLevel += 0.2f;
    }

    public void lowerSeaLevel() {
        seaLevel -= 0.2f;
    }

    public void addSea(float skyboxLength) {
        if (toggleSeaVisibility == true) {
            gl.glPushMatrix();

            /*---------------------------------------------------------------------------------------SEA LEVEL -------------------------------*/
            gl.glFrontFace(GL_CCW);
            gl.glTranslatef(-(skyboxLength / 2), -(skyboxLength / 2), seaLevel);

            gl.glBegin(GL_QUADS);

            gl.glNormal3f(1, 1, 1);
            gl.glVertex3f(skyboxLength, skyboxLength, seaLevel);
            gl.glColor4f((seaRed / 255f), (seaGreen / 255f), (seaBlue / 255f), seaAlpha);

            gl.glNormal3f(1, 1, 1);
            gl.glVertex3f(0, skyboxLength, seaLevel);
            gl.glColor4f((seaRed / 255f), (seaGreen / 255f), (seaBlue / 255f), seaAlpha);

            gl.glNormal3f(1, 1, 1);
            gl.glVertex3f(0, 0, 0);
            gl.glColor4f((seaRed / 255f), (seaGreen / 255f), (seaBlue / 255f), seaAlpha);

            gl.glNormal3f(1, 1, 1);
            gl.glVertex3f(skyboxLength, 0, seaLevel);
            gl.glColor4f((seaRed / 255f), (seaGreen / 255f), (seaBlue / 255f), seaAlpha);

            gl.glEnd();

            gl.glPopMatrix();
            gl.glFrontFace(GL_CW);
        }

    }
}
