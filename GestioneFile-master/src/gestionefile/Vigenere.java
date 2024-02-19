/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionefile;

public class Vigenere implements Runnable{

    private int ir;
    private int fr;
    private int ic;
    private int fc;
    private Matrice matrix;

    public Vigenere(int ir, int fr, int ic, int fc, Matrice matrix) {
        this.ir = ir;
        this.fr = fr;
        this.ic = ic;
        this.fc = fc;
        this.matrix = matrix;
    }

    @Override
    public void run() {
        popola();
    }

    private void popola(){
        int c,r,car;
        for(r=ir; r<fr; r++) {
            for(c=ic; c<fc; c++) {
                car = r + c + 65;
                if(car>90) {
                    car = car - 26;
                }
                this.matrix.setElemento(r, c, car);
            }
        }
    }
}

