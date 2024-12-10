import java.util.*;

public class mineSweeper {
    int rowNum,colNum,size;
    int[][] map;
    int[][] board;
    boolean isGame = true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    mineSweeper(int row,int col){
        this.rowNum=row;
        this.colNum=col;
        this.map=new int[row][col];
        this.board=new int[row][col];
        this.size=(row * col);
    }

    void prepareGame(){
        int count = 0 , randRow , randCol;
        while (count!=size/4){
            randRow = rand.nextInt(rowNum);
            randCol = rand.nextInt(colNum);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    void print (int[][]arr){
        for (int i = 0 ; i< arr.length; i++){
            for (int j = 0 ; j< arr[0].length;j++){
                if (arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void checkMine(int r,int c){
        if (map[r][c] == 0){
            if ((c<colNum-1) && (map[r][c+1] == -1)){
                board[r][c]++;
            }
            if ((r<rowNum-1) && (map[r+1][c] == -1)){
                board[r][c]++;
            }
            if ((c>0) &&(map[r][c-1] == -1)){
                board[r][c]++;
            }
            if ((r>0) && (map[r-1][c] == -1)){
                board[r][c]++;
            }
            if ((r<rowNum-1) && (c<colNum-1) && (map[r+1][c+1] == -1)){
                board[r][c]++;
            }
            if ((r>0) && (c<colNum-1) && (map[r-1][c+1] == -1)){
                board[r][c]++;
            }
            if ((r>0) && (c>0) && (map[r-1][c-1] == -1)){
                board[r][c]++;
            }
            if ((r<rowNum-1) && (c>0) && (map[r+1][c-1] == -1)){
                board[r][c]++;
            }
            if (board[r][c]==0){
                board[r][c]=-2;
            }
        }
    }

    void run(){
        prepareGame();
        int row,col,success=0;
        System.out.println("Mayın tarlasına hoşgeldiniz !");
        System.out.println();
        print(map);
        System.out.println();
        System.out.println();
        print(board);

        while(isGame){
            System.out.print("Row : ");
            row = (input.nextInt())-1;
            System.out.print("Column : ");
            col = (input.nextInt())-1;

            if (row<0 || row>rowNum){
                System.out.println("Geçersiz koordinat ! ");
                continue;
            }
            if (col<0 || col>colNum){
                System.out.println("Geçersiz koordinat ! ");
                continue;
            }

            if (map[row][col] != -1){
                checkMine(row,col);
                success++;
                if (success==(size-(size/4))){
                    print(map);
                    System.out.println("TEBRİKLER HİÇBİR MAYINA BASMADAN OYUNU KAZANDINIZ !");
                    break;
                }
            }
            else {
                isGame = false;
                System.out.println();
                System.out.println("Maalesef mayına bastınız ! ");
                System.out.println();
            }
            print(board);
        }

        System.out.println();
        System.out.println("Mayın haritası üstte görüldüğü gibiydi..");
        System.out.println("(1 = Mayın , 0 = Temiz Bölge)");
    }
}