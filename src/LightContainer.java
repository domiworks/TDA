
import static javax.media.opengl.GL.GL_FRONT;
import static javax.media.opengl.GL.GL_LINES;
import static javax.media.opengl.GL.GL_LINE_STRIP;
import javax.media.opengl.GL2;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_AMBIENT;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_DIFFUSE;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_LIGHT0;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_LIGHT1;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_LIGHT2;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_LIGHTING;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_POSITION;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_SHININESS;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_SPECULAR;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class LightContainer {

    private float lightPos[]; //arrayIndex x,y,z,w
    private float ambient[]; //arrayIndex rgb
    private float diffuse[]; //arrayIndex rgb
    private float specul[]; //arrayIndex rgb

    private boolean toggleLighting;
    private boolean toggleLightGuide;

    private GL2 gl;

    public LightContainer(GL2 gl) {
        this.gl = gl;
        lightPos = new float[4];
        ambient = new float[4];
        diffuse = new float[4];
        specul = new float[4];

        toggleLighting = true;
        toggleLightGuide = false;
    }

    /*------------*/
    public void setToggleLighting(boolean input) {
        toggleLighting = input;
    }

    public boolean getToggleLighting() {
        return toggleLighting;
    }

    public void setToggleLightGuide(boolean input) {
        toggleLightGuide = input;
    }

    public boolean getToggleLightGuide() {
        return toggleLightGuide;
    }

    public void toggleLighting() {
        if (toggleLighting == true) {
            toggleLighting = false;
        } else {
            toggleLighting = true;
        }
    }

    public void toggleLightGuide() {
        if (toggleLightGuide == true) {
            toggleLightGuide = false;
        } else {
            toggleLightGuide = true;
        }
    }

    /*------------*/
    public void setLightPosition(int arrayIndex, float coordinate) {
        lightPos[arrayIndex] = coordinate;
    }

    public void setAmbientValue(int arrayIndex, float value) {
        ambient[arrayIndex] = value;
    }

    public void setDiffuseValue(int arrayIndex, float value) {
        diffuse[arrayIndex] = value;
    }

    public void setSpecularValue(int arrayIndex, float value) {
        specul[arrayIndex] = value;
    }

    /*------------*/
    public void setLightPositionArray(float x, float y, float z, float w) {
        lightPos[0] = x;
        lightPos[1] = y;
        lightPos[2] = z;
        lightPos[3] = w;
    }

    public void setAmbientArray(float red, float green, float blue) {
        ambient[0] = red;
        ambient[1] = green;
        ambient[2] = blue;
        ambient[3] = 1f;
    }

    public void setDiffuseArray(float red, float green, float blue) {
        diffuse[0] = red;
        diffuse[1] = green;
        diffuse[2] = blue;
        diffuse[3] = 1f;
    }

    public void setSpecularArray(float red, float green, float blue) {
        specul[0] = red;
        specul[1] = green;
        specul[2] = blue;
        specul[3] = 1f;
    }

    /*------------*/
    public float getLightPosition(int arrayIndex) {
        return lightPos[arrayIndex];
    }

    public float getAmbientValue(int arrayIndex) {
        return ambient[arrayIndex];
    }

    public float getDiffuseValue(int arrayIndex) {
        return diffuse[arrayIndex];
    }

    public float getSpecularValue(int arrayIndex) {
        return specul[arrayIndex];
    }

    /*------------*/
    public float[] getLightPosArray() {
        return lightPos;
    }

    public float[] getAmbientArray() {
        return ambient;
    }

    public float[] getDiffuseArray() {
        return diffuse;
    }

    public float[] getSpeculArray() {
        return specul;
    }

    /*------------*/
    public void addLightGuide(float red, float green, float blue) {
        if (toggleLightGuide == true) {
            gl.glBegin(GL_LINES);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], 0);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], lightPos[2]);

            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0] - 3, lightPos[1], lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0] + 3, lightPos[1], lightPos[2] - 3);

            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1] - 3, lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1] + 3, lightPos[2] - 3);
            gl.glEnd();

            gl.glBegin(GL_LINE_STRIP);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], lightPos[2]);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0] - 3, lightPos[1], lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], lightPos[2] - 6);

            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1] - 3, lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], lightPos[2]);

            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0] + 3, lightPos[1], lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], lightPos[2] - 6);

            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1] + 3, lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0] - 3, lightPos[1], lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1] - 3, lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0] + 3, lightPos[1], lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1] + 3, lightPos[2] - 3);
            gl.glColor3f(red, green, blue);
            gl.glVertex3f(lightPos[0], lightPos[1], lightPos[2]);
            gl.glEnd();
        }
    }

    public void addLight(int lightno) {
        if (toggleLighting == true) {
            gl.glMaterialfv(GL_FRONT, GL_SPECULAR, specul, 0);
            gl.glMaterialf(GL_FRONT, GL_SHININESS, 80.0f);
            gl.glEnable(GL_LIGHTING);

            if (lightno == 0) {
                gl.glEnable(GL_LIGHT0);

                gl.glLightfv(GL_LIGHT0, GL_AMBIENT, ambient, 0);
                gl.glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuse, 0);
                gl.glLightfv(GL_LIGHT0, GL_SPECULAR, specul, 0);
                gl.glLightfv(GL_LIGHT0, GL_POSITION, lightPos, 0);
            } else if (lightno == 1) {
                gl.glEnable(GL_LIGHT1);

                gl.glLightfv(GL_LIGHT1, GL_AMBIENT, ambient, 0);
                gl.glLightfv(GL_LIGHT1, GL_DIFFUSE, diffuse, 0);
                gl.glLightfv(GL_LIGHT1, GL_SPECULAR, specul, 0);
                gl.glLightfv(GL_LIGHT1, GL_POSITION, lightPos, 0);
            } else if (lightno == 2) {
                gl.glEnable(GL_LIGHT2);

                gl.glLightfv(GL_LIGHT2, GL_AMBIENT, ambient, 0);
                gl.glLightfv(GL_LIGHT2, GL_DIFFUSE, diffuse, 0);
                gl.glLightfv(GL_LIGHT2, GL_SPECULAR, specul, 0);
                gl.glLightfv(GL_LIGHT2, GL_POSITION, lightPos, 0);
            }

        }
    }
}
