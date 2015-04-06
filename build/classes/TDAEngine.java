
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Dominikus
 */
public class TDAEngine {

    private float map[][]; //adalah peta utama dalam menampung TDAEngineue TDA
    private boolean[][] mapMarker; //ini ada untuk penanda apakah array sudah pernah diisi atau belum
    private float lowestVertexValue; //nilai paling minimum dalam map[][]
    private float highestVertexValue; //nilai paling maksimum dalam map[][]
    private int lastVertexIdx;
    private int firstVertexIdx;
    private String fileName;
    private String projectDir;

    public TDAEngine(String projectDir) {
        this.projectDir = projectDir;
    }

    public void setIteration(byte n) {
        int size = (int) (Math.pow(2.0, (float) n)); //ukuran dari array penampung nilai vertex selalu 2^n + 1
        this.map = new float[size + 1][size + 1]; //inisialisasi map[][]
        this.mapMarker = new boolean[size + 1][size + 1]; //inisialisasi mapMarker[][]
        this.lowestVertexValue = 0; //inisialisasi minimal value vertex
        this.highestVertexValue = 0; //inisialisasi maksimal value vertex
        this.lastVertexIdx = this.map.length - 1;
        this.firstVertexIdx = 0;
    }

    public void setPojokKiriAtas(float val) {
        this.map[0][0] = val;
        this.mapMarker[0][0] = true;
    }

    public void setPojokKananAtas(float val) {
        this.map[0][lastVertexIdx] = val;
        this.mapMarker[0][lastVertexIdx] = true;
    }

    public void setPojokKiriBawah(float val) {
        this.map[lastVertexIdx][0] = val;
        this.mapMarker[lastVertexIdx][0] = true;
    }

    public void setPojokKananBawah(float val) {
        this.map[lastVertexIdx][lastVertexIdx] = val;
        this.mapMarker[lastVertexIdx][lastVertexIdx] = true;
    }

    public void triangleDivisionAlgorithm(float roughness, int iteration) {
        long startTime = System.nanoTime();
        float r = roughness;
        Random ran = new Random();
        int maxSideLength = ((int) (Math.pow(2.0, iteration))) + 1;
        float Sisi = maxSideLength;
        boolean specialerRow = false;
        boolean specialerCol = false;

        int jumper = lastVertexIdx / 2;

        float k = Sisi / 2;
        float minPertubation = (float) -(Math.pow(k, r));
        float maxPertubation = (float) (Math.pow(k, r));
        float pertubation = (ran.nextFloat() * (2 * maxPertubation) - maxPertubation);

        float kHypo = (float) (Sisi * (Math.sqrt(2)) / 2); //kasus pythagoras
        float minPertubationHypo = (float) -(Math.pow(kHypo, r));
        float maxPertubationHypo = (float) (Math.pow(kHypo, r));
        float pertubationHypo = (ran.nextFloat() * (2 * maxPertubationHypo)) - maxPertubationHypo;

        //default semua pojok
        this.mapMarker[0][0] = true;
        this.mapMarker[0][lastVertexIdx] = true;
        this.mapMarker[lastVertexIdx][0] = true;
        this.mapMarker[lastVertexIdx][lastVertexIdx] = true;

        //algoritma dimulai
       /* System.out.println("START------------------------------------------");
         System.out.println("max idx : " + lastVertexIdx);
         System.out.println("min idx : " + firstVertexIdx);*/
        //showMarked();
        for (int iterate = 0; iterate < iteration; iterate++) {
            /*System.out.println("node jumper at iteration " + iterate + " is " + jumper + "node");
             System.out.println("S(side) ................: " + Sisi);
             System.out.println("k(side/2) ..............: " + k);
             System.out.println("R(roughness) ...........: " + r);
             System.out.println("pertubation ............: " + pertubation);
             System.out.println("check min pertubation ..: " + minPertubation);
             System.out.println("check max pertubation ..: " + maxPertubation);*/

            for (int jumpRow = 0; jumpRow < map.length; jumpRow = jumpRow + jumper) {
                for (int jumpCol = 0; jumpCol < map[jumpRow].length; jumpCol = jumpCol + jumper) {

                    if (specialerRow == false) {//bila current ada di row normal
                        pertubation = (ran.nextFloat() * (2 * maxPertubation)) - maxPertubation;

                        if (mapMarker[jumpRow][jumpCol] == false) {//IF map[jumpStepRow][jumpStepCol] is BELUM PERNAH DIISI
                            map[jumpRow][jumpCol] = ((map[jumpRow][jumpCol + jumper] + map[jumpRow][jumpCol - jumper]) / 2) + pertubation;
                            mapMarker[jumpRow][jumpCol] = true;
                        }

                    } else if (specialerRow == true) {//bila current ada di row SPECIAL
                        if (specialerCol == false) { // bila di row special si col normal
                            pertubation = (ran.nextFloat() * (2 * maxPertubation)) - maxPertubation;

                            if (mapMarker[jumpRow][jumpCol] == false) {//IF map[jumpStepRow][jumpStepCol] is BELUM PERNAH DIISI
                                map[jumpRow][jumpCol] = ((map[jumpRow + jumper][jumpCol] + map[jumpRow - jumper][jumpCol]) / 2) + pertubation;
                                mapMarker[jumpRow][jumpCol] = true;
                            }

                        } else if (specialerCol == true) { // bila di row special si col SPECIAL
                            pertubationHypo = (ran.nextFloat() * (2 * maxPertubationHypo)) - maxPertubationHypo;

                            if (mapMarker[jumpRow][jumpCol] == false) {//IF map[jumpStepRow][jumpStepCol] is BELUM PERNAH DIISI
                                map[jumpRow][jumpCol] = ((map[jumpRow - jumper][jumpCol - jumper] + map[jumpRow + jumper][jumpCol + jumper]) / 2) + pertubationHypo;
                                mapMarker[jumpRow][jumpCol] = true;
                            }
                        }

                        if (specialerCol == true) {
                            specialerCol = false;
                        } else if (specialerCol == false) {
                            specialerCol = true;
                        }
                    }
                }

                if (specialerRow == true) {
                    specialerRow = false;
                    specialerCol = false; //reinisialisasi COL SPECIAL
                } else if (specialerRow == false) {
                    specialerRow = true;
                    specialerCol = false; //reinisialisasi COL SPECIAL
                }
            }

            //reinisialisasi
            jumper /= 2;
            Sisi = k;
            k /= 2;
            minPertubation = (float) -(Math.pow(k, r));
            maxPertubation = (float) (Math.pow(k, r));
            pertubation = (ran.nextFloat() * (2 * maxPertubation)) - maxPertubation;
            kHypo = (float) (Sisi * (Math.sqrt(2)) / 2);
            minPertubationHypo = (float) -(Math.pow(kHypo, r));
            maxPertubationHypo = (float) (Math.pow(kHypo, r));
            pertubationHypo = (ran.nextFloat() * (2 * maxPertubationHypo)) - maxPertubationHypo;
            specialerRow = false;
            specialerCol = false;
            /*System.out.println("-----------------------------------------------");*/
        }
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("TDA proses = " + (((double) elapsedTime) / 1000000000.0) + " detik");
    }

    public double getMinimumVertexValue() {
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

    public double getMaximumVertexValue() {
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

    public void showMap() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                System.out.printf("%8.1f ", this.map[i][j]);
            }
            System.out.println("");
        }
    }

    public float[][] getMap() {
        return this.map;
    }

    public void showMarked() {
        for (int i = 0; i < this.mapMarker.length; i++) {
            for (int j = 0; j < this.mapMarker[i].length; j++) {
                System.out.printf("%1.0f ", this.mapMarker[i][j]);
            }
            System.out.println("");
        }
    }

    public void printToTextFile(String fileName) throws IOException {
        this.fileName = fileName;

        File outputtextfile = new File(projectDir + "output\\" + this.fileName + ".txt");
        PrintWriter printWriter = new PrintWriter(outputtextfile);

        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                printWriter.print(this.map[i][j] + " ");
            }
            printWriter.println();
        }

        printWriter.close();
    }

    public String getFileName() {
        return fileName;
    }

}
