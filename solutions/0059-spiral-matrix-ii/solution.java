class Solution {
    public int[][] generateMatrix(int n) {
            int row=0,col=0;
            int r =0;
            int c =1;
            int k=0;
            int[][] res=new int[n][n];
            boolean t=false;
            for(int i=1;i<=n*n;i++){
                res[row][col]=i;
                row+= r;
                col+= c;
                if(col==n-k){       // right boundary
                    row++;
                    col--;
                    c =0;
                    r =1;
                }
                if(row==n-k){       // bottom boundary
                    row--;
                    col--;
                    r =0;
                    c =-1;
                }
                if(col<k){          // left boundary
                    col++;
                    row--;
                    c =0;
                    r =-1;
                    t=true;
                }
                if(t && row==k) {   // top boundary
                    r = 0;
                    c = 1;
                    row++;
                    col++;
                    k++;
                    t = false;
                }
            }
        return res;
    }
}
