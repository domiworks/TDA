
import javax.media.opengl.GL2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class LandColoring {

    private float bottomMidLevel;
    private float midHiLevel;
    private float bottomLandColor[];
    private float midLandColor[];
    private float hiLandColor[];
    private int colorScale[][];

    private GL2 gl;

    public LandColoring(GL2 gl, int colorScale[][]) {
        bottomMidLevel = 0.6f;
        midHiLevel = 0.9f;
        bottomLandColor = new float[4];
        midLandColor = new float[4];
        hiLandColor = new float[4];
        bottomLandColor[0] = (213f / 255f);
        bottomLandColor[1] = (189f / 255f);
        bottomLandColor[2] = (143f / 255f);
        bottomLandColor[3] = 1.0f;
        midLandColor[0] = (188f / 255f);
        midLandColor[1] = 1f;
        midLandColor[2] = (230f / 255f);
        midLandColor[3] = 1.0f;
        hiLandColor[0] = 1f;
        hiLandColor[1] = 1f;
        hiLandColor[2] = 1f;
        hiLandColor[3] = 1.0f;

        this.colorScale = colorScale;
        this.gl = gl;
    }

    public void coloring(int i, int j) {
        float valueC = (float) (((double) colorScale[j][i] / 255) * 1.0f);

        if (valueC < bottomMidLevel) {
            gl.glColor4f(bottomLandColor[0], bottomLandColor[1], bottomLandColor[2], bottomLandColor[3]); //is light green
        } else if (valueC <= midHiLevel && valueC >= bottomMidLevel) {
            gl.glColor4f(midLandColor[0], midLandColor[1], midLandColor[2], midLandColor[3]);
        } else if (valueC > midHiLevel) {
            gl.glColor4f(hiLandColor[0], hiLandColor[1], hiLandColor[2], hiLandColor[3]);
        }

    }

    public void setMidHiLevel(float input) {
        midHiLevel = input;
    }

    public float getMidHiLevel() {
        return midHiLevel;
    }

    public void setBottomMidLevel(float input) {
        bottomMidLevel = input;
    }

    public float getBottomMidLevel() {
        return bottomMidLevel;
    }

    public void setBottomColor(int arrayPos, float val) {
        bottomLandColor[arrayPos] = val / 255f;
    }

    public float getBottomColor(int arrayPos) {
        return bottomLandColor[arrayPos];
    }

    public void setMidColor(int arrayPos, float val) {
        midLandColor[arrayPos] = val / 255f;
    }

    public float getMidColor(int arrayPos) {
        return midLandColor[arrayPos];
    }

    public void setHiColor(int arrayPos, float val) {
        hiLandColor[arrayPos] = val / 255f;
    }

    public float getHiColor(int arrayPos) {
        return hiLandColor[arrayPos];
    }


}
