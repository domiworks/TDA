/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dominikus
 */
public class VertexContainer {

    private float x;
    private float y;
    private float z;
    private float normalX;
    private float normalY;
    private float normalZ;

    public VertexContainer() {
        x = y = z = normalX = normalY = normalZ = 0;
    }

    public float getVertex_x() {
        return x;
    }

    public float getVertex_y() {
        return y;
    }

    public float getVertex_z() {
        return z;
    }

    public void setVertex_x(float x) {
        this.x = x;
    }

    public void setVertex_y(float y) {
        this.y = y;
    }

    public void setVertex_z(float z) {
        this.z = z;
    }

    public float getNormal_x() {
        return normalX;
    }

    public float getNormal_y() {
        return normalY;
    }

    public float getNormal_z() {
        return normalZ;
    }

    public void setNormal_x(float normalX) {
        this.normalX = normalX;
    }

    public void setNormal_y(float normalY) {
        this.normalY = normalY;
    }

    public void setNormal_z(float normalZ) {
        this.normalZ = normalZ;
    }

}
