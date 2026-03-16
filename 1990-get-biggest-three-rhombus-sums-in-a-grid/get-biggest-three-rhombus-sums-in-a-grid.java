class Solution {
    TreeSet<Integer> set = new TreeSet<>();

    void addSet(int num) {
        set.add(num);
        if(set.size()>3){
            set.pollFirst();
            
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        


        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                addSet(grid[r][c]);
                for(int side=1 ; r-side  >= 0 && r+side<row && c-side>=0 && c+side<col; side++ ){
                    int sum=0;

                    for(int i=0;i<side;i++){
                        sum+=grid[r-side+i][c-i];  // top -> left 
                        sum+=grid[r+i][c-side+i];     // left -> bottom 
                        sum+=grid[r+side-i][c+i];       // bottom -> right 
                        sum+=grid[r-i][c+side-i];  // right -> top
                    }

                    addSet(sum);
                }
            }
        }

int [] ans=new int[set.size()];
    int i=0;
    while(set.size() > 0){
        ans[i++]=set.pollLast();

    }
    return ans;

    }
}