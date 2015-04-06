
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dominikus
 */
public class HeightMapEngine {

    private float map[][]; //adalah peta utama dalam menampung value TDA
    private float lowestVertexValue; //nilai paling minimum dalam map[][]
    private float highestVertexValue; //nilai paling maksimum dalam map[][]
    private int colorScale[][]; //penampung warna yang memiliki range 0-255
    private String fileName;
    private String projectDir;

    public HeightMapEngine(float map[][], String projectDir) {
        this.projectDir = projectDir;
        this.map = map;
        this.colorScale = new int[map.length][map.length]; //inisialisasi colorScale[][]
        this.lowestVertexValue = 0; //inisialisasi minimal value vertex
        this.highestVertexValue = 0; //inisialisasi maksimal value vertex
    }

    private double getMinimumVertexValue() {
        lowestVertexValue = map[0][0];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                if (map[row][col] <= lowestVertexValue) {
                    lowestVertexValue = map[row][col];
                }
            }
        }
        return lowestVertexValue;
    }

    private double getMaximumVertexValue() {
        highestVertexValue = map[0][0];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                if (map[row][col] >= highestVertexValue) {
                    highestVertexValue = map[row][col];
                }
            }
        }
        return highestVertexValue;
    }

    private void convertToColor() {
        double range = getMaximumVertexValue() - getMinimumVertexValue();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                Double setColor = new Double((map[row][col] - lowestVertexValue) / range) * 255;
                int setColorInt = setColor.intValue();
                colorScale[row][col] = setColorInt;
            }
        }
    }

    public void createHeightMap(String fileName) throws IOException {
        long startTime = System.nanoTime();
        this.fileName = fileName;
        convertToColor();
        BufferedImage theImage = new BufferedImage(map.length, map.length, BufferedImage.TYPE_INT_RGB);
        int i90 = 0;
        int j90 = 0;
        for (int col = map.length - 1; col >= 0; col--) {
            for (int row = 0; row < map.length; row++) {
                int color = colorScale[row][col];
                int rgb = new Color(color, color, color).getRGB();
                theImage.setRGB(i90, j90, rgb);
                i90++;
            }
            i90 = 0;
            j90++;
        }
        File outputfile = new File(projectDir + "output\\" + this.fileName + ".png");
        ImageIO.write(theImage, "png", outputfile);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("HM proses = " + (((double)elapsedTime)/ 1000000000.0) + " detik" );
    }

    public void showColorScale() {
        for (int i = 0; i < this.colorScale.length; i++) {
            for (int j = 0; j < this.colorScale[i].length; j++) {
                System.out.print(this.colorScale[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int[][] getColorScale() {
        convertToColor();
        return this.colorScale;
    }

    public String getFileName() {
        return fileName;
    }
}
