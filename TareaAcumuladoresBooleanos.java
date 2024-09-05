package ejercicioAcumuladores;

public class TareaAcumuladoresBooleanos {

    // ------------------------------ EJERCICIO 1 ------------------------------

    public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
        if (!esMatrizValida(mat, num)) {
            return false;
        }

        for (int i = 0; i < mat.length; i++) {
            if (esFilaTodosMultiplos(mat[i], num)) {
                return true;
            }
        }

        return false;
    }

    
    private boolean esMatrizValida(int[][] mat, int num) {
        return mat != null && mat.length > 0 && num > 0;
    }

    private boolean esFilaTodosMultiplos(int[] fila, int num) {
        for (int j = 0; j < fila.length; j++) {
            if (fila[j] % num != 0) {
                return false;
            }
        }
        return true;
    }

    // ------------------------------ EJERCICIO 2 ------------------------------

    public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {
        if (!sonMatricesValidas(mat1, mat2)) {
            return false;
        }

        for (int i = 0; i < mat1.length; i++) {
            if (!tienenMismaCantidadDeElementos(mat1[i], mat2[i])) {
                return false;
            }
            if (!hayInterseccionEnFila(mat1[i], mat2[i])) {
                return false;
            }
        }

        return true;
    }

    
    private boolean sonMatricesValidas(int[][] mat1, int[][] mat2) {
        return mat1 != null && mat2 != null && mat1.length == mat2.length;
    }

    private boolean tienenMismaCantidadDeElementos(int[] fila1, int[] fila2) {
        return fila1.length == fila2.length;
    }

    private boolean hayInterseccionEnFila(int[] fila1, int[] fila2) {
        for (int j = 0; j < fila1.length; j++) {
            for (int k = 0; k < fila2.length; k++) {
                if (fila1[j] == fila2[k]) {
                    return true;
                }
            }
        }
        return false;
    }

    // ------------------------------ EJERCICIO 3 ------------------------------

    public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
        if (!esMatrizValidaParaColumna(mat, nColum)) {
            return false;
        }

        int sumaColumna = calcularSumaColumna(mat, nColum);

        for (int i = 0; i < mat.length; i++) {
            if (sumaFila(mat[i]) > sumaColumna) {
                return true;
            }
        }

        return false;
    }

    
    private boolean esMatrizValidaParaColumna(int[][] mat, int nColum) {
        return mat != null && mat.length > 0 && nColum >= 0 && nColum < mat[0].length;
    }

    private int calcularSumaColumna(int[][] mat, int nColum) {
        int suma = 0;
        for (int i = 0; i < mat.length; i++) {
            suma += mat[i][nColum];
        }
        return suma;
    }

    private int sumaFila(int[] fila) {
        int suma = 0;
        for (int j = 0; j < fila.length; j++) {
            suma += fila[j];
        }
        return suma;
    }

    // ------------------------------ EJERCICIO 4 ------------------------------

    public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
        if (!sonMatricesValidasPorColumna(mat1, mat2)) {
            return false;
        }

        int numColumnas = mat1[0].length;
        for (int c = 0; c < numColumnas; c++) {
            if (!hayInterseccionEnColumna(mat1, mat2, c)) {
                return false;
            }
        }

        return true;
    }

    
    private boolean sonMatricesValidasPorColumna(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null || mat1.length == 0 || mat2.length == 0) {
            return false;
        }
        if (mat1[0].length != mat2[0].length) {
            return false;
        }
        for (int i = 1; i < mat1.length; i++) {
            if (mat1[i].length != mat1[0].length) {
                return false;
            }
        }
        for (int i = 1; i < mat2.length; i++) {
            if (mat2[i].length != mat2[0].length) {
                return false;
            }
        }
        return true;
    }

    private boolean hayInterseccionEnColumna(int[][] mat1, int[][] mat2, int col) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2.length; j++) {
                if (mat1[i][col] == mat2[j][col]) {
                    return true;
                }
            }
        }
        return false;
    }
}
