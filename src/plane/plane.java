package plane;

public class plane {
    public static void main(String[] args) {
        Node[][] mat = new Node[4][4];

        mat[0][0] = new Node(1, 3);
        mat[0][1] = new Node(8, 4);
        mat[0][2] = new Node(3, 8);
        mat[0][3] = new Node(-1, 4);
        mat[1][0] = new Node(2, 5);
        mat[1][1] = new Node(5, 11);
        mat[1][2] = new Node(3, 1);
        mat[1][3] = new Node(-1, 2);
        mat[2][0] = new Node(4, 10);
        mat[2][1] = new Node(3, 1);
        mat[2][2] = new Node(1, 4);
        mat[2][3] = new Node(-1, 8);
        mat[3][0] = new Node(2, -1);
        mat[3][1] = new Node(3, -1);
        mat[3][2] = new Node(5, -1);
        mat[3][3] = new Node(-1, -1);
        buildMat(mat);
        for(int i=0;i<mat.length;i++){
            for (int j=0;j<mat.length;j++){
                System.out.print(" "+mat[i][j].getPrice());
            }
            System.out.println();
        }

    }
public static void buildMat(Node[][] mat){
        mat[0][0].setPrice(0);
        for (int i=1;i<mat.length;i++){
            mat[0][i].setPrice(mat[0][i-1].getPrice()+mat[0][i-1].getX());
        }
        for(int i=1;i<mat[0].length;i++){
            mat[i][0].setPrice(mat[i-1][0].getPrice()+mat[i-1][0].getY());
        }
        for (int i=1;i<mat.length;i++){
            for (int j=1;j<mat[0].length;j++){
                mat[i][j].setPrice(Math.min(mat[i][j-1].getPrice()+mat[i][j-1].getX(),mat[i-1][j].getPrice()+mat[i-1][j].getY()));
            }
        }
}



}
