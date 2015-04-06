
import java.awt.event.*;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import static javax.media.opengl.GL2.*;

/**
 * JOGL 2.0 Example 2: RotextureContainerObjatextureContainerObjing 3D Shapes
 * (GLCanvas)
 */
@SuppressWarnings("serial")
public class TheCanvas extends GLCanvas implements GLEventListener, KeyListener {

    String projectDir;

    protected VertexContainer vertex[][];
    protected LightContainer lightSource[];
    protected Camera camera;
    protected SeaContainer sea;
    protected FogContainer fog;
    protected LandColoring landColor;

    /*------------------------------------------------------------------------------------------------------------------------------- TEXTURE variables ---------------*/
    private int textureContainer[] = new int[7];
    private Texture textureObj[] = new Texture[7];
    private File textureFile[] = new File[7];

    /*------------------------------------------------------------------------------------------------------------------------------------ GL variables ---------------*/
    private GLU glu;  // for the GL Utility
    private GL2 gl;

    /*------------------------------------------------------------------------------------------------------------------------- TDA LANDSCAPE variables ---------------*/
    private float map[][];
    private int colorScale[][];
    private float x, y, z;
    private float xyCoordScaler = 1f;
    private float zCoordScaler = 0.25f;
    private float map_size;
    private byte primitives;
    protected float skyboxLength;
    private float scale = 1.0f;
    private float rotate = 0.0f;

    /*------------------------------------------------------------------------------------------------------------------- CONTROLABLE variables default ---------------*/
    private boolean toggleWireframe = true;
    private boolean toggleNormalGuide = false;
    private boolean toggleZeroGuide = true;
    private boolean toggleSeaLighting = true;

    /*------------------------------------------------------------------------------------------------------------------------ VERTEX counter variables ---------------*/
    private int vertexCount;

    /*------------------------------------------------------------------------------------------------------------------------------------- CONSTRUCTOR ---------------*/
    public TheCanvas(float[][] map, int[][] colorScale, byte primitives, String projectDir) throws IOException {

        /*----Set Project Directory---*/
        this.projectDir = projectDir;

        /*----Add Listener---*/
        this.addGLEventListener(this);
        this.addKeyListener(this);

        /*----Set Map From TDA---*/
        this.map = map;
        this.colorScale = colorScale;
        this.primitives = primitives;
        this.map_size = this.map.length * xyCoordScaler;
        skyboxLength = (map.length * xyCoordScaler) * 16;

        /*----Initialize Additional Effect---*/
        camera = new Camera();
        vertex = new VertexContainer[map.length][map[0].length];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex[0].length; j++) {
                vertex[i][j] = new VertexContainer();
            }
        }

        System.out.println("Canvas is Running");

        vertexCount = 0;
    }

    /* ------ Implement methods declared in GLEventListener ------
     /**
     * * Called back textureContainerFilemediatextureContainerObjely
     * aftextureContainerObjer textureContainerObjhe OpenGL
     * contextureContainerObjextextureContainerObj is
     * initextureContainerObjialized. Can be used textureContainerObjo perform
     * one-textureContainerObjtextureContainerFilee
     * initextureContainerObjializatextureContainerObjion. Run only once.
     * -------- INIT ---------------
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
        glu = new GLU();                         // get GL Utilities
        gl.glClearColor(0.15f, 0.15f, 0.15f, 1.0f); // set background (clear) color
        gl.glClearDepth(1.0f);      // set clear depth value to farthest

        sea = new SeaContainer(gl);
        fog = new FogContainer(gl);
        landColor = new LandColoring(gl, colorScale);
        lightSource = new LightContainer[3];
        lightSource[0] = new LightContainer(gl);
        lightSource[1] = new LightContainer(gl);
        lightSource[2] = new LightContainer(gl);
        lightSource[0].setLightPositionArray(1000f, 1000f, 300f, 1f);
        lightSource[0].setAmbientArray((0f / 255f), (0f / 255f), (0f / 255f));
        lightSource[0].setDiffuseArray((255f / 255f), (255f / 255f), (255f / 255f));
        lightSource[0].setSpecularArray((255f / 255f), (255f / 255f), (255f / 255f));
        lightSource[1].setLightPositionArray(500f, 500f, 300f, 10f);
        lightSource[1].setAmbientArray((0f / 255f), (0f / 255f), (0f / 255f));
        lightSource[1].setDiffuseArray((255f / 255f), (255f / 255f), (255f / 255f));
        lightSource[1].setSpecularArray((255f / 255f), (255f / 255f), (255f / 255f));
        lightSource[2].setLightPositionArray(100f, 100f, 300f, 10f);
        lightSource[2].setAmbientArray((0f / 255f), (0f / 255f), (0f / 255f));
        lightSource[2].setDiffuseArray((255f / 255f), (255f / 255f), (255f / 255f));
        lightSource[2].setSpecularArray((255f / 255f), (255f / 255f), (255f / 255f));

        gl.glEnable(GL_DEPTH_TEST); // enables depth testing
        gl.glDepthFunc(GL_LEQUAL);  // the type of depth test to do
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); // best perspective correction
        gl.glHint(GL_POLYGON_SMOOTH_HINT, GL_NICEST); // best perspective correction
        gl.glHint(GL_LINE_SMOOTH_HINT, GL_NICEST); // best perspective correction
        gl.glShadeModel(GL_SMOOTH); // blends colors nicely, and smoothes out lighting

        textureDefaultInit();
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        gl.glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
        gl.glGenerateMipmap(GL_TEXTURE_2D);
        calculateVertexAndNormals();

    }

    /**
     * * Call-back handler for window re-size eventextureContainerObj. Also
     * called when textureContainerObjhe drawable is firstextureContainerObj
     * setextureContainerObj textureContainerObjo visible.
     * ---------------------------------- RESHAPE ---------------
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

        if (height == 0) {
            height = 1;   // prevent divide by zero
        }
        float aspect = (float) width / height;
        // Set the view port (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL_PROJECTION);  // choose projection matrix
        gl.glLoadIdentity();             // reset projection matrix
        glu.gluPerspective(camera.getFOVy(), aspect, 1, 70000.0 * xyCoordScaler); // fovy, aspect, zNear, zFar

        // Enable the model-view transform
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
    }

    private void textureDefaultInit() {
        try {
            textureFile[0] = new File(projectDir + "img\\textures\\lands_all\\0.png");
            textureFile[1] = new File(projectDir + "img\\textures\\sky_0\\1.png");
            textureFile[2] = new File(projectDir + "img\\textures\\sky_0\\2.png");
            textureFile[3] = new File(projectDir + "img\\textures\\sky_0\\3.png");
            textureFile[4] = new File(projectDir + "img\\textures\\sky_0\\4.png");
            textureFile[5] = new File(projectDir + "img\\textures\\sky_0\\5.png");
            textureFile[6] = new File(projectDir + "img\\textures\\sky_0\\6.png");
            for (int i = 0; i < textureFile.length; i++) {
                textureObj[i] = TextureIO.newTexture(textureFile[i], true);
                textureContainer[i] = textureObj[i].getTextureObject(gl);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void textureCustomSkyboxInit(int i) {
        gl.getContext().makeCurrent();
        try {
            textureFile[1] = new File(projectDir + "img\\textures\\sky_" + i + "\\1.png");
            textureObj[1] = TextureIO.newTexture(textureFile[1], true);
            textureContainer[1] = textureObj[1].getTextureObject(gl);

            textureFile[2] = new File(projectDir + "img\\textures\\sky_" + i + "\\2.png");
            textureObj[2] = TextureIO.newTexture(textureFile[2], true);
            textureContainer[2] = textureObj[2].getTextureObject(gl);

            textureFile[3] = new File(projectDir + "img\\textures\\sky_" + i + "\\3.png");
            textureObj[3] = TextureIO.newTexture(textureFile[3], true);
            textureContainer[3] = textureObj[3].getTextureObject(gl);

            textureFile[4] = new File(projectDir + "img\\textures\\sky_" + i + "\\4.png");
            textureObj[4] = TextureIO.newTexture(textureFile[4], true);
            textureContainer[4] = textureObj[4].getTextureObject(gl);

            textureFile[5] = new File(projectDir + "img\\textures\\sky_" + i + "\\5.png");
            textureObj[5] = TextureIO.newTexture(textureFile[5], true);
            textureContainer[5] = textureObj[5].getTextureObject(gl);

            textureFile[6] = new File(projectDir + "img\\textures\\sky_" + i + "\\6.png");
            textureObj[6] = TextureIO.newTexture(textureFile[6], true);
            textureContainer[6] = textureObj[6].getTextureObject(gl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void textureCustomLandInit(int i) {
        gl.getContext().makeCurrent();
        try {
            textureFile[0] = new File(projectDir + "img\\textures\\lands_all\\" + i + ".png");
            textureObj[0] = TextureIO.newTexture(textureFile[0], true);
            textureContainer[0] = textureObj[0].getTextureObject(gl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void skyboxDraw() {
        //FRONT DONE
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[1]);
        gl.glBegin(GL_QUADS);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0, skyboxLength, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(skyboxLength, skyboxLength, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(skyboxLength, skyboxLength, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(0, skyboxLength, 0 + sea.getSeaLevel());

        gl.glEnd();
        gl.glDisable(GL_TEXTURE_2D);

        //LEFT DONE
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[4]);
        gl.glBegin(GL_QUADS);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(0, 0, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0, 0, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0, skyboxLength, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0, skyboxLength, 0 + sea.getSeaLevel());

        gl.glEnd();
        gl.glDisable(GL_TEXTURE_2D);

        //BACK  
        gl.glFrontFace(GL_CCW);
        gl.glPushMatrix();
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[3]);
        gl.glBegin(GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0, 0, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(skyboxLength, 0, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(skyboxLength, 0, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0, 0, 0 + sea.getSeaLevel());

        gl.glEnd();
        gl.glDisable(GL_TEXTURE_2D);
        gl.glPopMatrix();
        gl.glFrontFace(GL_CW);

        //RIGHT DONE
        gl.glFrontFace(GL_CCW);
        gl.glPushMatrix();
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[2]);
        gl.glBegin(GL_QUADS);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(skyboxLength, 0, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(skyboxLength, 0, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(skyboxLength, skyboxLength, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(skyboxLength, skyboxLength, 0 + sea.getSeaLevel());

        gl.glEnd();
        gl.glDisable(GL_TEXTURE_2D);
        gl.glPopMatrix();
        gl.glFrontFace(GL_CW);

        //BOTTOM
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[6]);
        gl.glBegin(GL_QUADS);

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(0, 0, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(0, skyboxLength, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(skyboxLength, skyboxLength, 0 + sea.getSeaLevel());

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(skyboxLength, 0, 0 + sea.getSeaLevel());

        gl.glEnd();
        gl.glDisable(GL_TEXTURE_2D);

        //TOP 
        gl.glFrontFace(GL_CCW);
        gl.glPushMatrix();
        gl.glEnable(GL_TEXTURE_2D);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[5]);

        gl.glBegin(GL_QUADS);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(0, 0, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(0, skyboxLength, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(skyboxLength, skyboxLength, skyboxLength + sea.getSeaLevel());

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(skyboxLength, 0, skyboxLength + sea.getSeaLevel());

        gl.glEnd();
        gl.glDisable(GL_TEXTURE_2D);
        gl.glPopMatrix();
        gl.glFrontFace(GL_CW);
    }

    private void triangleStripDraw() {
        gl.glEnable(GL_NORMALIZE);
        gl.glBegin(GL_TRIANGLE_STRIP); // !IMPORTANT ORDERED
        for (int row = 0; row < this.map.length - 1; row++) {
            if ((row == 0) || (row % 2 != 0)) {
                for (int col = 0; col < this.map.length; col++) {

                    // (1,0)
                    x = row + 1;
                    y = col;
                    z = this.map[(int) x][(int) y];
                    gl.glTexCoord4f((x / this.map_size), (y / this.map_size), 0, 1f);
                    landColor.coloring((int) y, (int) x);
                    float x00 = vertex[row + 1][col].getVertex_x();
                    float y00 = vertex[row + 1][col].getVertex_y();
                    float z00 = vertex[row + 1][col].getVertex_z();
                    gl.glNormal3f(vertex[row + 1][col].getNormal_x(), vertex[row + 1][col].getNormal_y(), vertex[row + 1][col].getNormal_z());
                    gl.glVertex3f(x00, y00, z00);
                    vertexCount++;

                    // (0,0)
                    x = row;
                    y = col;
                    z = this.map[(int) x][(int) y];
                    gl.glTexCoord4f((x / this.map_size), (y / this.map_size), 0, 1f);
                    landColor.coloring((int) y, (int) x);
                    float x10 = vertex[row][col].getVertex_x();
                    float y10 = vertex[row][col].getVertex_y();
                    float z10 = vertex[row][col].getVertex_z();
                    gl.glNormal3f(vertex[row][col].getNormal_x(), vertex[row][col].getNormal_y(), vertex[row][col].getNormal_z());
                    gl.glVertex3f(x10, y10, z10);
                    vertexCount++;

                }
            } else {
                for (int col = this.map.length - 1; col >= 0; col--) {

                    // (0,0)
                    x = row;
                    y = col;
                    z = this.map[(int) x][(int) y];
                    gl.glTexCoord4f((x / this.map_size), (y / this.map_size), 0, 1f);
                    landColor.coloring((int) y, (int) x);
                    float x10 = vertex[row][col].getVertex_x();
                    float y10 = vertex[row][col].getVertex_y();
                    float z10 = vertex[row][col].getVertex_z();
                    gl.glNormal3f(vertex[row][col].getNormal_x(), vertex[row][col].getNormal_y(), vertex[row][col].getNormal_z());
                    gl.glVertex3f(x10, y10, z10);
                    vertexCount++;

                    // (1,0)
                    x = row + 1;
                    y = col;
                    z = this.map[(int) x][(int) y];
                    gl.glTexCoord4f((x / this.map_size), (y / this.map_size), 0, 1f);
                    landColor.coloring((int) y, (int) x);
                    float x00 = vertex[row + 1][col].getVertex_x();
                    float y00 = vertex[row + 1][col].getVertex_y();
                    float z00 = vertex[row + 1][col].getVertex_z();
                    gl.glNormal3f(vertex[row + 1][col].getNormal_x(), vertex[row + 1][col].getNormal_y(), vertex[row + 1][col].getNormal_z());
                    gl.glVertex3f(x00, y00, z00);
                    vertexCount++;

                }
            }

        }

        gl.glEnd(); // !IMPORTANT ORDERED

    }

    private void trianglesDraw() {
        gl.glEnable(GL_NORMALIZE);
        gl.glBegin(GL_TRIANGLES); // !IMPORTANT ORDERED
        for (int row = 0; row < this.map.length - 1; row += 1) {
            for (int col = 0; col < this.map[0].length - 1; col += 1) {

                // First Triangle   
                // (0,0)
                x = row; //0
                y = col; //0
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x00 = vertex[row][col].getVertex_x();
                float y00 = vertex[row][col].getVertex_y();
                float z00 = vertex[row][col].getVertex_z();
                gl.glNormal3f(vertex[row][col].getNormal_x(), vertex[row][col].getNormal_y(), vertex[row][col].getNormal_z());
                gl.glVertex3f(x00, y00, z00);
                vertexCount++;

                // (0,1)
                x = row; //0
                y = col + 1; //1
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x01 = vertex[row][col + 1].getVertex_x();
                float y01 = vertex[row][col + 1].getVertex_y();
                float z01 = vertex[row][col + 1].getVertex_z();
                gl.glNormal3f(vertex[row][col + 1].getNormal_x(), vertex[row][col + 1].getNormal_y(), vertex[row][col + 1].getNormal_z());
                gl.glVertex3f(x01, y01, z01);
                vertexCount++;

                // (1,1)
                x = row + 1; //1
                y = col + 1; //1
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x11 = vertex[row + 1][col + 1].getVertex_x();
                float y11 = vertex[row + 1][col + 1].getVertex_y();
                float z11 = vertex[row + 1][col + 1].getVertex_z();
                gl.glNormal3f(vertex[row + 1][col + 1].getNormal_x(), vertex[row + 1][col + 1].getNormal_y(), vertex[row + 1][col + 1].getNormal_z());
                gl.glVertex3f(x11, y11, z11);
                vertexCount++;

                //Second Triangle
                // (1,1)
                x = row + 1; //1
                y = col + 1; //1
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                x11 = vertex[row + 1][col + 1].getVertex_x();
                y11 = vertex[row + 1][col + 1].getVertex_y();
                z11 = vertex[row + 1][col + 1].getVertex_z();
                gl.glNormal3f(vertex[row + 1][col + 1].getNormal_x(), vertex[row + 1][col + 1].getNormal_y(), vertex[row + 1][col + 1].getNormal_z());
                gl.glVertex3f(x11, y11, z11);
                vertexCount++;

                // (1,0)
                x = row + 1; //1
                y = col; //0
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x10 = vertex[row + 1][col].getVertex_x();
                float y10 = vertex[row + 1][col].getVertex_y();
                float z10 = vertex[row + 1][col].getVertex_z();
                gl.glNormal3f(vertex[row + 1][col].getNormal_x(), vertex[row + 1][col].getNormal_y(), vertex[row + 1][col].getNormal_z());
                gl.glVertex3f(x10, y10, z10);
                vertexCount++;

                // (0,0)
                x = row; //0
                y = col; //0
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                x00 = vertex[row][col].getVertex_x();
                y00 = vertex[row][col].getVertex_y();
                z00 = vertex[row][col].getVertex_z();
                gl.glNormal3f(vertex[row][col].getNormal_x(), vertex[row][col].getNormal_y(), vertex[row][col].getNormal_z());
                gl.glVertex3f(x00, y00, z00);
                vertexCount++;
            }
        }
        gl.glEnd();
    }

    private void quadsDraw() {
        gl.glEnable(GL_NORMALIZE);
        gl.glBegin(GL_QUADS); // !IMPORTANT ORDERED
        for (int row = 0; row < this.map.length - 1; row += 1) {
            for (int col = 0; col < this.map[0].length - 1; col += 1) { //clockwise

                // (0,0)
                x = row; //0
                y = col; //0
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x00 = vertex[row][col].getVertex_x();
                float y00 = vertex[row][col].getVertex_y();
                float z00 = vertex[row][col].getVertex_z();
                gl.glNormal3f(vertex[row][col].getNormal_x(), vertex[row][col].getNormal_y(), vertex[row][col].getNormal_z());
                gl.glVertex3f(x00, y00, z00);
                vertexCount++;

                // (0,1)
                x = row; //0
                y = col + 1; //1
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x01 = vertex[row][col + 1].getVertex_x();
                float y01 = vertex[row][col + 1].getVertex_y();
                float z01 = vertex[row][col + 1].getVertex_z();
                gl.glNormal3f(vertex[row][col + 1].getNormal_x(), vertex[row][col + 1].getNormal_y(), vertex[row][col + 1].getNormal_z());
                gl.glVertex3f(x01, y01, z01);
                vertexCount++;

                // (1,1)
                x = row + 1; //1
                y = col + 1; //1
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x11 = vertex[row + 1][col + 1].getVertex_x();
                float y11 = vertex[row + 1][col + 1].getVertex_y();
                float z11 = vertex[row + 1][col + 1].getVertex_z();
                gl.glNormal3f(vertex[row + 1][col + 1].getNormal_x(), vertex[row + 1][col + 1].getNormal_y(), vertex[row + 1][col + 1].getNormal_z());
                gl.glVertex3f(x11, y11, z11);
                vertexCount++;

                // (1,0)
                x = row + 1; //1
                y = col; //0
                z = this.map[(int) x][(int) y];
                gl.glTexCoord2f((x / this.map_size), (y / this.map_size));
                landColor.coloring((int) y, (int) x);
                float x10 = vertex[row + 1][col].getVertex_x();
                float y10 = vertex[row + 1][col].getVertex_y();
                float z10 = vertex[row + 1][col].getVertex_z();
                gl.glNormal3f(vertex[row + 1][col].getNormal_x(), vertex[row + 1][col].getNormal_y(), vertex[row + 1][col].getNormal_z());
                gl.glVertex3f(x10, y10, z10);
                vertexCount++;

            }
        }
        gl.glEnd();
    }

    /**
     * * Called back by textureContainerObjhe
     * antextureContainerFileatextureContainerObjor textureContainerObjo perform
     * rendering.--------------------------------------------------------------------------------------
     * DISPLAY ---------------
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void display(GLAutoDrawable drawable) {

        gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear color and depth buffers   

        /*- camera operation start -*/
        camera.cameraOperate();
        /*- camera operation end -*/

        gl.glLoadIdentity();// reset the model-view matrix !IMPORTANT ORDERED

        glu.gluLookAt(camera.getXPlayerAt(), camera.getYPlayerAt(), camera.getZPlayerAt(),
                camera.getXLookAt(), camera.getYLookAt(), camera.getZLookAt(),
                0, 0, 1);// This Determines Where The Camera's Position And View Is !IMPORTANT ORDERED

        gl.glPolygonMode(GL_BACK, GL_LINE);
        if (toggleWireframe == true) {
            gl.glPolygonMode(GL_FRONT, GL_FILL);
        } else {
            gl.glPolygonMode(GL_FRONT, GL_LINE);
        }
        gl.glFrontFace(GL_CW);
        gl.glEnable(GL_CULL_FACE);
        gl.glCullFace(GL_BACK);

        gl.glEnable(GL_BLEND);
        gl.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        gl.glEnable(GL_SHADE_MODEL);
        gl.glShadeModel(GL_SMOOTH);

        gl.glPushMatrix();

        // Enable/Disable features
        gl.glPushAttrib(GL_ENABLE_BIT);

        gl.glScalef(scale, scale, scale);
        gl.glTranslatef(-(skyboxLength / 2), -(skyboxLength / 2), -(skyboxLength / 2) + sea.getSeaLevel());

        gl.glColor4f(1, 1, 1, 1);

        /*- skybox start -*/
        skyboxDraw();
        /*- skybox end -*/

        // ----- Render the Landscape -----
        gl.glPopMatrix();
        gl.glPushMatrix();

        gl.glScalef(scale, scale, scale);
        gl.glTranslated(-(this.map.length * xyCoordScaler) / 2, -(this.map.length * xyCoordScaler) / 2, 0);

        /*----Add Fog---*/
        fog.addFog();

        /*----Add Light Guide---*/
        lightSource[0].addLightGuide(1, 0, 0);
        lightSource[1].addLightGuide(0, 1, 0);
        lightSource[2].addLightGuide(0, 0, 1);

        gl.glEnable(GL_COLOR_MATERIAL);

        /*----Add Light---*/
        lightSource[0].addLight(0);
        lightSource[1].addLight(1);
        lightSource[2].addLight(2);

        gl.glEnable(GL_TEXTURE_2D);
        gl.glActiveTexture(GL_TEXTURE0);
        gl.glBindTexture(GL_TEXTURE_2D, textureContainer[0]);

        /*- drawing mode start -*/
        gl.glRotatef(rotate, 0, 0, 1);
        if (primitives == 0) { //trianle strip
            triangleStripDraw();
        } else if (primitives == 1) { //triangle
            trianglesDraw();
        } else if (primitives == 2) { //guad
            quadsDraw();
        } else {
            System.out.println("No Geometric Primitive Choosen!");
        }
        /*- drawing mode end -*/

        gl.glDisable(GL_TEXTURE_2D);
        gl.glPopMatrix();

        if (toggleSeaLighting == false) {
            gl.glDisable(GL_LIGHT0);
            gl.glDisable(GL_LIGHT1);
            gl.glDisable(GL_LIGHT2);
            gl.glDisable(GL_LIGHTING);
        }

        /*----Add Sea---*/
        sea.addSea(skyboxLength);

        if (toggleSeaLighting == true) {
            gl.glDisable(GL_LIGHT0);
            gl.glDisable(GL_LIGHT1);
            gl.glDisable(GL_LIGHT2);
            gl.glDisable(GL_LIGHTING);
        }
        gl.glDisable(GL_FOG);
        gl.glPushMatrix();

        gl.glScalef(scale, scale, scale);
        gl.glTranslated(-(this.map.length * xyCoordScaler) / 2, -(this.map.length * xyCoordScaler) / 2, 0);

        if (toggleZeroGuide == true) {
            gl.glBegin(GL_LINES);//!IMPORTANT ORDERED
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(120, 0, 0); //x is red
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(-20f, 0f, 0f);

            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3d(0, 120, 0); //y is blue
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(0f, -20f, 0f);

            gl.glColor3f(0.0f, 1.0f, 0.0f);
            gl.glVertex3f(0f, 0f, 120f); //z is green
            gl.glColor3f(0.0f, 1.0f, 0.0f);
            gl.glVertex3f(0f, 0f, -20f);
            gl.glEnd();
        }

        if (toggleNormalGuide == true) {
            for (int i = 1; i < vertex.length - 1; i++) {
                for (int j = 1; j < vertex[0].length - 1; j++) {
                    gl.glBegin(GL_LINES);//!IMPORTANT ORDERED
                    gl.glColor3f(1.0f, 0.0f, 0.0f);
                    gl.glVertex3f(vertex[i][j].getVertex_x(), vertex[i][j].getVertex_y(), vertex[i][j].getVertex_z()); //x is red
                    gl.glColor3f(1.0f, 0.0f, 0.0f);
                    gl.glVertex3f(
                            vertex[i][j].getNormal_x() + vertex[i][j].getVertex_x(),
                            vertex[i][j].getNormal_y() + vertex[i][j].getVertex_y(),
                            vertex[i][j].getNormal_z() + vertex[i][j].getVertex_z());
                    gl.glEnd();
                }
            }
        }
        gl.glPopMatrix();
        // System.out.println("Vertex Land = " + vertexLandCount + " | " + "Vetex Skybox = 24 | " + "Vetex Sea = 4");
        vertexCount = 0;
        //  vertexSkyCount = 0;
    }

    /**
     * * Called back before textureContainerObjhe OpenGL
     * contextureContainerObjextextureContainerObj is
     * destextureContainerObjroyed. Release resource such as buffers.
     * ------------------------------------------------- DISPOSE ---------------
     */
    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    private void calculateVertexAndNormals() {
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex[0].length; j++) {

                float x = i * xyCoordScaler;
                float y = j * xyCoordScaler;
                float z = this.map[(int) i][(int) j] * zCoordScaler;
                vertex[(int) i][(int) j].setVertex_x(x);
                vertex[(int) i][(int) j].setVertex_y(y);
                vertex[(int) i][(int) j].setVertex_z(z);

            }
        }
        float v1X, v1Y, v1Z, v2X, v2Y, v2Z, v3X, v3Y, v3Z, v4X, v4Y, v4Z = 0;
        float vh0X, vh0Y, vh0Z,
                vh1X, vh1Y, vh1Z = 0;
        float cross12X, cross12Y, cross12Z,
                cross23X, cross23Y, cross23Z,
                cross34X, cross34Y, cross34Z,
                cross41X, cross41Y, cross41Z = 0;
        float cross1h1X, cross1h1Y, cross1h1Z,
                cross2h1X, cross2h1Y, cross2h1Z = 0;
        float distance12, distance23, distance34, distance41,
                distance1h1, distance2h1 = 0;

        for (int row = 0; row < vertex.length; row++) {
            for (int col = 0; col < vertex[0].length; col++) {
                if (row == 0 && col == 0) { //00
                    v1X = vertex[row][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    vh1X = vertex[row + 1][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    vh1Y = vertex[row + 1][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    vh1Z = vertex[row + 1][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row + 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row + 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row + 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    cross1h1X = v1Y * vh1Z - v1Z * vh1Y;
                    cross1h1Y = v1Z * vh1X - v1X * vh1Z;
                    cross1h1Z = v1X * vh1Y - v1Y * vh1X;

                    cross2h1X = v2Y * vh1Z - v2Z * vh1Y;
                    cross2h1Y = v2Z * vh1X - v2X * vh1Z;
                    cross2h1Z = v2X * vh1Y - v2Y * vh1X;

                    distance1h1 = (float) Math.sqrt(Math.pow(cross1h1X, 2) + Math.pow(cross1h1Y, 2) + Math.pow(cross1h1Z, 2));
                    distance2h1 = (float) Math.sqrt(Math.pow(cross2h1X, 2) + Math.pow(cross2h1Y, 2) + Math.pow(cross2h1Z, 2));

                    vertex[row][col].setNormal_x(
                            ((cross1h1X / distance1h1) + (cross2h1X / distance2h1)) / 2
                    );
                    vertex[row][col].setNormal_y(
                            ((cross1h1Y / distance1h1) + (cross2h1Y / distance2h1)) / 2
                    );
                    vertex[row][col].setNormal_z(
                            ((cross1h1Z / distance1h1) + (cross2h1Z / distance2h1)) / 2
                    );

                } else if (row == 0 && col == vertex[0].length - 1) { //01
                    v1X = vertex[row][col - 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row][col - 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row][col - 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row + 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row + 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row + 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));

                    vertex[row][col].setNormal_x((cross12X / distance12));
                    vertex[row][col].setNormal_y((cross12Y / distance12));
                    vertex[row][col].setNormal_z((cross12Z / distance12));

                } else if (row == vertex.length - 1 && col == vertex[0].length - 1) { //11
                    v1X = vertex[row][col - 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row][col - 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row][col - 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row - 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row - 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row - 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));

                    vertex[row][col].setNormal_x((cross12X / distance12));
                    vertex[row][col].setNormal_y((cross12Y / distance12));
                    vertex[row][col].setNormal_z((cross12Z / distance12));

                } else if (row == vertex.length - 1 && col == 0) { //10
                    v1X = vertex[row][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row - 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row - 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row - 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));

                    vertex[row][col].setNormal_x((cross12X / distance12));
                    vertex[row][col].setNormal_y((cross12Y / distance12));
                    vertex[row][col].setNormal_z((cross12Z / distance12));

                } else if (row == 0) {
                    v1X = vertex[row][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row + 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row + 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row + 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v3X = vertex[row][col - 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v3Y = vertex[row][col - 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v3Z = vertex[row][col - 1].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    cross23X = v2Y * v3Z - v2Z * v3Y;
                    cross23Y = v2Z * v3X - v2X * v3Z;
                    cross23Z = v2X * v3Y - v2Y * v3X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));
                    distance23 = (float) Math.sqrt(Math.pow(cross23X, 2) + Math.pow(cross23Y, 2) + Math.pow(cross23Z, 2));

                    vertex[row][col].setNormal_x((((cross12X / distance12) + (cross23X / distance23)) / 2));
                    vertex[row][col].setNormal_y(vertex[row][col].getVertex_y() + (((cross12Y / distance12) + (cross23Y / distance23)) / 2));
                    vertex[row][col].setNormal_z((((cross12Z / distance12) + (cross23Z / distance23)) / 2));

                } else if (col == vertex[0].length - 1) {
                    v1X = vertex[row - 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row - 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row - 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row + 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row + 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row + 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v3X = vertex[row][col - 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v3Y = vertex[row][col - 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v3Z = vertex[row][col - 1].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    cross23X = v2Y * v3Z - v2Z * v3Y;
                    cross23Y = v2Z * v3X - v2X * v3Z;
                    cross23Z = v2X * v3Y - v2Y * v3X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));
                    distance23 = (float) Math.sqrt(Math.pow(cross23X, 2) + Math.pow(cross23Y, 2) + Math.pow(cross23Z, 2));

                    vertex[row][col].setNormal_x((((cross12X / distance12) + (cross23X / distance23)) / 2));
                    vertex[row][col].setNormal_y((((cross12Y / distance12) + (cross23Y / distance23)) / 2));
                    vertex[row][col].setNormal_z((((cross12Z / distance12) + (cross23Z / distance23)) / 2));

                } else if (row == vertex.length - 1) {
                    v1X = vertex[row - 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row - 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row - 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v3X = vertex[row][col - 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v3Y = vertex[row][col - 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v3Z = vertex[row][col - 1].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    cross23X = v2Y * v3Z - v2Z * v3Y;
                    cross23Y = v2Z * v3X - v2X * v3Z;
                    cross23Z = v2X * v3Y - v2Y * v3X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));
                    distance23 = (float) Math.sqrt(Math.pow(cross23X, 2) + Math.pow(cross23Y, 2) + Math.pow(cross23Z, 2));

                    vertex[row][col].setNormal_x((((cross12X / distance12) + (cross23X / distance23)) / 2));
                    vertex[row][col].setNormal_y((((cross12Y / distance12) + (cross23Y / distance23)) / 2));
                    vertex[row][col].setNormal_z((((cross12Z / distance12) + (cross23Z / distance23)) / 2));

                } else if (col == 0) {
                    v1X = vertex[row - 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row - 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row - 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v3X = vertex[row + 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v3Y = vertex[row + 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v3Z = vertex[row + 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    cross23X = v2Y * v3Z - v2Z * v3Y;
                    cross23Y = v2Z * v3X - v2X * v3Z;
                    cross23Z = v2X * v3Y - v2Y * v3X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));
                    distance23 = (float) Math.sqrt(Math.pow(cross23X, 2) + Math.pow(cross23Y, 2) + Math.pow(cross23Z, 2));

                    vertex[row][col].setNormal_x((((cross12X / distance12) + (cross23X / distance23)) / 2));
                    vertex[row][col].setNormal_y((((cross12Y / distance12) + (cross23Y / distance23)) / 2));
                    vertex[row][col].setNormal_z((((cross12Z / distance12) + (cross23Z / distance23)) / 2));

                } else {
                    v1X = vertex[row - 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v1Y = vertex[row - 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v1Z = vertex[row - 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v2X = vertex[row][col - 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v2Y = vertex[row][col - 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v2Z = vertex[row][col - 1].getVertex_z() - vertex[row][col].getVertex_z();

                    v3X = vertex[row + 1][col].getVertex_x() - vertex[row][col].getVertex_x();
                    v3Y = vertex[row + 1][col].getVertex_y() - vertex[row][col].getVertex_y();
                    v3Z = vertex[row + 1][col].getVertex_z() - vertex[row][col].getVertex_z();

                    v4X = vertex[row][col + 1].getVertex_x() - vertex[row][col].getVertex_x();
                    v4Y = vertex[row][col + 1].getVertex_y() - vertex[row][col].getVertex_y();
                    v4Z = vertex[row][col + 1].getVertex_z() - vertex[row][col].getVertex_z();

                    cross12X = v1Y * v2Z - v1Z * v2Y;
                    cross12Y = v1Z * v2X - v1X * v2Z;
                    cross12Z = v1X * v2Y - v1Y * v2X;

                    cross23X = v2Y * v3Z - v2Z * v3Y;
                    cross23Y = v2Z * v3X - v2X * v3Z;
                    cross23Z = v2X * v3Y - v2Y * v3X;

                    cross34X = v3Y * v4Z - v3Z * v4Y;
                    cross34Y = v3Z * v4X - v3X * v4Z;
                    cross34Z = v3X * v4Y - v3Y * v4X;

                    cross41X = v4Y * v1Z - v4Z * v1Y;
                    cross41Y = v4Z * v1X - v4X * v1Z;
                    cross41Z = v4X * v1Y - v4Y * v1X;

                    distance12 = (float) Math.sqrt(Math.pow(cross12X, 2) + Math.pow(cross12Y, 2) + Math.pow(cross12Z, 2));
                    distance23 = (float) Math.sqrt(Math.pow(cross23X, 2) + Math.pow(cross23Y, 2) + Math.pow(cross23Z, 2));
                    distance34 = (float) Math.sqrt(Math.pow(cross34X, 2) + Math.pow(cross34Y, 2) + Math.pow(cross34Z, 2));
                    distance41 = (float) Math.sqrt(Math.pow(cross41X, 2) + Math.pow(cross41Y, 2) + Math.pow(cross41Z, 2));

                    vertex[row][col].setNormal_x((((cross12X / distance12) + (cross23X / distance23) + (cross34X / distance34) + (cross41X / distance41)) / 4));
                    vertex[row][col].setNormal_y((((cross12Y / distance12) + (cross23Y / distance23) + (cross34Y / distance34) + (cross41Y / distance41)) / 4));
                    vertex[row][col].setNormal_z((((cross12Z / distance12) + (cross23Z / distance23) + (cross34Z / distance34) + (cross41Z / distance41)) / 4));

                }
            }
        }
    }

    public float getSkyboxLength() {
        return skyboxLength;
    }

    /*------------------------------------------------------------------------------------------------------------------------------- WIREFRAME PUBLIC METHOD ---------------*/
    public void toggleWireframe() {
        if (toggleWireframe == true) {
            toggleWireframe = false;
        } else {
            toggleWireframe = true;
        }
    }


    /*---------------------------------------------------------------------------------------------------------------------------------------- KEYTYPING ---------------*/
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        //camera keys
        if (keyCode == KeyEvent.VK_D) {
            if (e.isControlDown()) {
                camera.trackRight();
            } else {
                camera.rotateRight();
            }
        } else if (keyCode == KeyEvent.VK_A) {
            if (e.isControlDown()) {
                camera.trackLeft();
            } else {
                camera.rotateLeft();
            }
        } else if (keyCode == KeyEvent.VK_S) {
            if (e.isControlDown()) {
                camera.tiltUp();
            } else if (e.isAltDown()) {
                camera.trackDown();
            } else {
                camera.dollyOut();
            }
        } else if (keyCode == KeyEvent.VK_W) {
            if (e.isControlDown()) {
                camera.tiltDown();
            } else if (e.isAltDown()) {
                camera.trackUp();
            } else {
                camera.dollyIn();
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            xyCoordScaler -= 0.1f;
            skyboxLength = (map.length * xyCoordScaler) * 16;
            calculateVertexAndNormals();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            xyCoordScaler += 0.1f;
            skyboxLength = (map.length * xyCoordScaler) * 16;
            calculateVertexAndNormals();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            zCoordScaler -= 0.01f;
            calculateVertexAndNormals();
        } else if (keyCode == KeyEvent.VK_UP) {
            zCoordScaler += 0.01f;
            calculateVertexAndNormals();
        } else if (keyCode == KeyEvent.VK_I) {
            if (toggleWireframe == true) {
                toggleWireframe = false;
            } else {
                toggleWireframe = true;
            }
        } else if (keyCode == KeyEvent.VK_P) {
            if (toggleNormalGuide == true) {
                toggleNormalGuide = false;
            } else {
                toggleNormalGuide = true;
            }
        } else if (keyCode == KeyEvent.VK_O) {
            sea.toggleSeaVisibility();
        } else if (keyCode == KeyEvent.VK_PAGE_UP) {
            sea.raiseSeaLevel();
        } else if (keyCode == KeyEvent.VK_PAGE_DOWN) {
            sea.lowerSeaLevel();
        } else if (keyCode == KeyEvent.VK_Y) {
            if (toggleZeroGuide == true) {
                toggleZeroGuide = false;
            } else {
                toggleZeroGuide = true;
            }
        } else if (keyCode == KeyEvent.VK_L) {
            if (toggleSeaLighting == true) {
                toggleSeaLighting = false;
            } else {
                toggleSeaLighting = true;
            }
        } else if (keyCode == KeyEvent.VK_1) {
            lightSource[0].toggleLighting();
        } else if (keyCode == KeyEvent.VK_2) {
            lightSource[1].toggleLighting();
        } else if (keyCode == KeyEvent.VK_3) {
            lightSource[2].toggleLighting();
        } else if (keyCode == KeyEvent.VK_PERIOD) {
            rotate += 10f;
        } else if (keyCode == KeyEvent.VK_COMMA) {
            rotate -= 10f;
        } else if (keyCode == KeyEvent.VK_F) {
            fog.toggleFogVisibility();
        }
    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
