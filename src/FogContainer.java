
import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_NICEST;
import javax.media.opengl.GL2;
import static javax.media.opengl.GL2ES1.GL_EXP;
import static javax.media.opengl.GL2ES1.GL_EXP2;
import static javax.media.opengl.GL2ES1.GL_FOG;
import static javax.media.opengl.GL2ES1.GL_FOG_COLOR;
import static javax.media.opengl.GL2ES1.GL_FOG_DENSITY;
import static javax.media.opengl.GL2ES1.GL_FOG_HINT;
import static javax.media.opengl.GL2ES1.GL_FOG_MODE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class FogContainer {

    private float fogDensity;
    private float fogColor[];
    private boolean togFogVisibility;
    private byte fogType;

    private GL2 gl;

    public FogContainer(GL2 gl) {
        fogDensity = 0.005f;
        fogColor = new float[4];
        fogColor[0] = (128f / 255f);
        fogColor[1] = (128f / 255f);
        fogColor[2] = (128f / 255f);
        fogColor[3] = 0.0f;
        togFogVisibility = false;
        fogType = 0;

        this.gl = gl;
    }

    /*------------*/
    public void setFogVisibility(boolean input) {
        togFogVisibility = input;
    }

    public boolean getFogVisibility() {
        return togFogVisibility;
    }

    public void toggleFogVisibility() {
        if (togFogVisibility == true) {
            togFogVisibility = false;
        } else {
            togFogVisibility = true;
        }
    }


    /*------------*/
    public void setFogType(byte input) {
        fogType = input;
    }

    public byte getFogType() {
        return fogType;
    }

    /*------------*/
    public void setFogColorArray(float red, float green, float blue) {
        fogColor[0] = red;
        fogColor[1] = green;
        fogColor[2] = blue;
        fogColor[3] = 0.0f;
    }

    public float[] getFogColorArray() {
        return fogColor;
    }

    public void setFogColorValue(int index, float input) {
        fogColor[index] = input;
    }

    public float getFogColorValue(int index) {
        return fogColor[index];
    }

    /*------------*/
    public void setFogDensity(float input) {
        fogDensity = input;
    }

    public float getFogDensity() {
        return fogDensity;
    }

    /*------------*/
    public void addFog() {
        if (togFogVisibility == true) {
            gl.glEnable(GL_FOG);
            if (fogType == 0) {
                gl.glFogi(GL_FOG_MODE, GL_EXP);
            } else if (fogType == 1) {
                gl.glFogi(GL_FOG_MODE, GL_EXP2);
            } else if (fogType == 2) {
                gl.glFogi(GL_FOG_MODE, GL_LINEAR);
            }

            gl.glFogfv(GL_FOG_COLOR, fogColor, 0);
            gl.glFogf(GL_FOG_DENSITY, fogDensity);
            gl.glHint(GL_FOG_HINT, GL_NICEST);
        }

    }

}
