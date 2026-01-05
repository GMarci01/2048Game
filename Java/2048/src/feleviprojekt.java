import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class feleviprojekt {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int[] tomb = new int[11];
        int[][] matrix = new int[4][4];
        int score = 0;
        int bestscore = 0;

        int belerak = 1;

        for (int i = 0; i < 11; i++) {
            tomb[i] = belerak *= 2;
        }

        try {

            BufferedReader br = new BufferedReader(new FileReader("data_2048.txt"));
            String Line = "";
            while ((Line = br.readLine()) != null) {
                bestscore = Integer.valueOf(Line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //kezdés
        int[] kezdox = new int[2];
        int[] kezdoy = new int[2];

        for (int i = 0; i < 2; i++) {
            int kezdox1 = rnd.nextInt(4);
            int kezdoy1 = rnd.nextInt(4);
            if (String.valueOf(matrix[kezdox1][kezdoy1]).equals("0")){
                matrix[kezdox1][kezdoy1] = 2;
            }
            else{
                i--;
            }
        }



        System.out.println("Score: " + score + ", BestScore: " + bestscore);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (String.valueOf(matrix[i][j]).equals("0")){
                    System.out.print("[ ]");
                }
                else{
                    System.out.print("[" + matrix[i][j] + "]");
                }


            }
            System.out.println();
        }




        ArrayList<Integer> uresx = new ArrayList<>();
        ArrayList<Integer> uresy = new ArrayList<>();

        boolean kilep = false;
        int nemlephetszam = 0;
        while (!kilep || nemlephetszam!=16){
            nemlephetszam = 0;
            int nulladb= 0;
            for(int i = 0;i<4;i++){
                for (int j = 0;j<4;j++){
                    if (String.valueOf(matrix[i][j]).equals("0")){
                        nulladb++;
                    }
                }
            }

             if (nulladb==0){

                for(int i = 0;i<4;i++){
                    for (int j = 0;j<4;j++){
                        if (i == 0 && j == 0){
                            if(matrix[i][j] != matrix[i][j+1] && matrix[i][j] != matrix[i+1][j]){
                                   nemlephetszam++;
                            }
                        }
                        else if(i==0 && j==3){
                            if(matrix[i][j] != matrix[i][j-1] && matrix[i][j] != matrix[i+1][j]){
                                nemlephetszam++;
                            }
                        }
                        else if(i==3 && j==0){
                            if(matrix[i][j] != matrix[i-1][j] && matrix[i][j] != matrix[i][j+1]){
                                nemlephetszam++;
                            }
                        }
                        else if(i==3 && j==3){
                            if(matrix[i][j] != matrix[i-1][j] && matrix[i][j] != matrix[i][j-1]){
                                nemlephetszam++;
                            }
                        }
                        else if(i==0 && j==1 || i==0 && j==2){
                            if(matrix[i][j] != matrix[i][j-1] && matrix[i][j] != matrix[i][j+1] && matrix[i][j] != matrix[i+1][j]) {
                                nemlephetszam++;
                            }
                        }
                        else if(i==1 && j==3 || i==2 && j==3){
                            if(matrix[i][j] != matrix[i-1][j] && matrix[i][j] != matrix[i+1][j] && matrix[i][j] != matrix[i][j-1]) {
                                nemlephetszam++;
                            }

                        }
                        else if(i==3 && j==1 || i==3 && j==2){
                            if(matrix[i][j] != matrix[i][j-1] && matrix[i][j] != matrix[i][j+1] && matrix[i][j] != matrix[i-1][j]) {
                                nemlephetszam++;
                            }

                        }
                        else if(i==1 && j==0 || i==2 && j==0){
                            if(matrix[i][j] != matrix[i-1][j] && matrix[i][j] != matrix[i+1][j] && matrix[i][j] != matrix[i][j+1]) {
                                nemlephetszam++;
                            }

                        }
                        else if((i==1 && j==1 || i==1 && j==2) || (i==2 && j==1 || i==2 && j==2)){
                            if(matrix[i][j] != matrix[i-1][j] && matrix[i][j] != matrix[i][j+1] && matrix[i][j] != matrix[i+1][j] && matrix[i][j] != matrix[i][j-1]) {
                                nemlephetszam++;
                            }
                        }
                    }
                }

            }






            int regis = score;
            if (nemlephetszam!=16){
                System.out.println("Kérek egy inputot: ");
                String input = sc.next();

                if (input.equalsIgnoreCase("w")) {
                    score = moveUp(matrix,score);
                    if (nulladb==0){
                        if(regis!=score){
                            kiir(matrix,score);
                        }
                        else{
                            System.out.println("Erre már nem lehet lépni");
                            score=regis;
                        }
                    }
                    else{
                        kiir(matrix,score);
                    }

                }
                else if (input.equalsIgnoreCase("s")) {
                    score = moveDown(matrix,score);
                    if (nulladb==0){
                        if(regis!=score){
                            kiir(matrix,score);
                        }
                        else{
                            System.out.println("Erre már nem lehet lépni");
                            score=regis;
                        }
                    }
                    else{
                        kiir(matrix,score);
                    }
                }
                else if (input.equalsIgnoreCase("a")) {
                    score = moveLeft(matrix,score);
                    if (nulladb==0){
                        if(regis!=score){
                            kiir(matrix,score);
                        }
                        else{
                            System.out.println("Erre már nem lehet lépni");
                            score=regis;
                        }
                    }
                    else{
                        kiir(matrix,score);
                    }
                }
                else if (input.equalsIgnoreCase("d")) {
                    score = moveRight(matrix,score);
                    if (nulladb==0){
                        if(regis!=score){
                            kiir(matrix,score);
                        }
                        else{
                            System.out.println("Erre már nem lehet lépni");
                            score=regis;
                        }
                    }
                    else{
                        kiir(matrix,score);
                    }
                }
                else if (input.equalsIgnoreCase("kilep")){
                    kilep = true;
                }
                else{
                    System.out.println("Ez nem egy lépés irány");
                }
            }
            else{
                System.out.println("Vesztettél!");
                kilep = true;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (String.valueOf(matrix[i][j]).equals("2048")){
                        System.out.println("Gratulálok megnyerted a játékot!");
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("data_2048.txt"));
                            bw.write(String.valueOf(score));

                            bw.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        kilep = true;
                    }
                }
            }

        }






    }

//mukodik
    public static int moveUp(int[][] m,int s) {


        int nulladb= 0;
        for(int i = 0;i<4;i++){
            for (int j = 0;j<4;j++){
                if (String.valueOf(m[i][j]).equals("0")){
                    nulladb++;
                }
            }
        }

        int regis = s;
        int matrixhosssz = m.length;

            for (int oszlop = 0; oszlop < matrixhosssz; oszlop++) {

                int[] ideiglenes = new int[matrixhosssz];
                int sorindex = 0;

                for (int sor = 0; sor < matrixhosssz; sor++) {
                    if (m[sor][oszlop] != 0) {
                        ideiglenes[sorindex++] = m[sor][oszlop];
                    }
                }

                for (int i = 0; i < matrixhosssz - 1; i++) {
                    if (ideiglenes[i] != 0 && ideiglenes[i] == ideiglenes[i+1]) {
                        ideiglenes[i] *= 2;
                        s += ideiglenes[i];
                        ideiglenes[i + 1] = 0;
                        i++;
                    }
                }

                int[] ujoszlop = new int[matrixhosssz];
                int oszlopindex = 0;

                for (int i = 0; i < matrixhosssz; i++) {
                    if (ideiglenes[i] != 0) {
                        ujoszlop[oszlopindex++] = ideiglenes[i];
                    }
                }
                for (int sor = 0; sor < matrixhosssz; sor++) {
                    m[sor][oszlop] = ujoszlop[sor];
                }








            }



        return s;
    }
//mukodik
    public static int moveDown(int[][] m,int s) {

        int matrixhosssz = m.length;

        for (int oszlop = 0; oszlop < matrixhosssz; oszlop++) {

            int[] ideiglenes = new int[matrixhosssz];
            int sorindex = matrixhosssz-1;

            for (int sor = matrixhosssz-1; sor >=0; sor--) {
                if (m[sor][oszlop] != 0) {
                    ideiglenes[sorindex--] = m[sor][oszlop];
                }
            }

            for (int i = matrixhosssz-1;i>0 ;i--) {
                if (ideiglenes[i] != 0 && ideiglenes[i] == ideiglenes[i-1]) {
                    ideiglenes[i] *= 2;
                    s += ideiglenes[i];
                    ideiglenes[i-1] = 0;
                    i--;
                }
            }

            int[] ujoszlop = new int[matrixhosssz];
            int oszlopindex = 3;

            for (int i = matrixhosssz-1; i>=0; i--) {
                if (ideiglenes[i] != 0) {
                    ujoszlop[oszlopindex--] = ideiglenes[i];
                }
            }

            for (int sor = 0; sor < matrixhosssz; sor++) {
                m[sor][oszlop] = ujoszlop[sor];
            }


        }

        return s;
    }


    public static int moveLeft(int[][] m,int s) {

        int matrixhosssz = m.length;

        for (int sor = 0; sor < matrixhosssz; sor++) {

            int[] ideiglenes = new int[matrixhosssz];
            int index = 0;

            for (int oszlop = 0; oszlop < matrixhosssz; oszlop++) {
                if (m[sor][oszlop] != 0) {
                    ideiglenes[index++] = m[sor][oszlop];
                }
            }

            for (int i = 0; i < matrixhosssz - 1; i++) {
                if (ideiglenes[i] != 0 && ideiglenes[i] == ideiglenes[i+1]) {
                    ideiglenes[i] *= 2;
                    s += ideiglenes[i];
                    ideiglenes[i + 1] = 0;
                    i++;
                }
            }

            int[] ujoszlop = new int[matrixhosssz];
            int sorindex = 0;

            for (int i = 0; i < matrixhosssz; i++) {
                if (ideiglenes[i] != 0) {
                    ujoszlop[sorindex++] = ideiglenes[i];
                }
            }

            for (int oszlop = 0; oszlop < matrixhosssz; oszlop++) {
                m[sor][oszlop] = ujoszlop[oszlop];
            }


        }

        return s;
    }
    public static int moveRight(int[][] m,int s){

            int matrixhosssz = m.length;

            for (int sor = 0; sor < matrixhosssz; sor++) {

                int[] ideiglenes = new int[matrixhosssz];
                int oszlopindex = matrixhosssz-1;

                for (int oszlop = matrixhosssz-1; oszlop >=0; oszlop--) {
                    if (m[sor][oszlop] != 0) {
                        ideiglenes[oszlopindex--] = m[sor][oszlop];
                    }
                }

                for (int i = matrixhosssz-1;i>0 ;i--) {
                    if (ideiglenes[i] != 0 && ideiglenes[i] == ideiglenes[i-1]) {
                        ideiglenes[i] *= 2;
                        s += ideiglenes[i];
                        ideiglenes[i-1] = 0;
                        i--;
                    }
                }

                int[] ujoszlop = new int[matrixhosssz];
                int sorindex = 3;

                for (int i = matrixhosssz-1; i>=0; i--) {
                    if (ideiglenes[i] != 0) {
                        ujoszlop[sorindex--] = ideiglenes[i];
                    }
                }

                for (int oszlop = 0; oszlop < matrixhosssz; oszlop++) {
                    m[sor][oszlop] = ujoszlop[oszlop];
                }


            }

            return s;
    }

    public static void kiir(int[][] m,int s) {
        Random rnd = new Random();
        boolean igen = false;
        while (!igen) {
            int kezdox1 = rnd.nextInt(4);
            int kezdoy1 = rnd.nextInt(4);
            int negyes = rnd.nextInt(10);
            if (m[kezdox1][kezdoy1]==0){
                if (negyes!=4){
                    m[kezdox1][kezdoy1] = 2;
                    igen = true;
                }
                else if(negyes==4){
                    m[kezdox1][kezdoy1] = 4;
                    igen = true;
                }
            }

        }

        System.out.println("Score: "+s);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (String.valueOf(m[i][j]).equals("0")){
                    System.out.print("[ ]");
                }

                else{
                    System.out.print("[" + m[i][j] + "]");
                }
            }
            System.out.println();
        }

    }



}


