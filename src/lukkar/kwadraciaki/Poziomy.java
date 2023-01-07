package lukkar.kwadraciaki;
class Poziomy {
    private int poziom1[][] = {{0,1,0},{1,1,1},{0,1,0}};
    private int poziom2[][] = {{0,1,0,1},{0,1,1,1},{1,0,1,0},{1,0,1,0}};
    private int poziom3[][] = {{0,1,0,1,1},{0,1,1,1,0},{1,0,1,0,1},{1,0,1,0,1,0},{1,0,1,0,1,0}};
    private int poziom4[][];
    private int poziom5[][];
    private int poziom6[][];
    private int poziom7[][];
    private int poziom8[][];
    private int poziom9[][];
    private int poziom10[][] = {
        {0,1,0,1,1,0,1,0,1,1,0,0},
        {0,1,1,1,0,0,1,0,1,1,1,0},
        {1,0,1,0,1,0,1,0,1,1,0,0},
        {1,0,1,0,1,0,0,1,1,1,0,0},
        {1,0,1,0,1,0,0,1,0,1,0,0},
        {0,1,0,1,1,0,1,0,1,1,0,1},
        {0,1,1,1,0,0,1,0,1,1,0,0},
        {1,0,1,0,1,0,1,0,1,1,1,0},
        {1,0,1,0,1,0,0,1,0,1,0,1},
        {1,0,1,0,1,0,0,1,0,1,0,0},
        {1,0,1,0,1,0,0,1,0,1,0,0},
        {1,0,1,0,1,0,0,1,0,1,1,0}
    };

    int[][] wybierzPoziom(int poziom) {
        switch(poziom) {
            case 1:
                return this.poziom1;
            case 2:
                return this.poziom2;
            case 3:
                return this.poziom3;
            case 4:
                return this.poziom4;
            case 5:
                return this.poziom5;
            case 6:
                return this.poziom6;
            case 7:
                return this.poziom7;
            case 8:
                return this.poziom8;
            case 9:
                return this.poziom9;
            case 10:
                return this.poziom10;
            default:
                return null;
        }
    }
}