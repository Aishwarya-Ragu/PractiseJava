package TopInterviewQuestions.Medium.Backtracking;

public class wordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "SFB";
        wordSearch ws = new wordSearch();
        System.out.println(ws.exist(board,word));
    }



    public boolean exist(char[][] board, String word) {
        int len = board.length;
        int hlen = board[0].length;
        for(int j =0;j<len;j++){
            for(int k = 0;k < hlen;k++){
                if(board[j][k] == word.charAt(0)){
                    board[j][k] = '*';
                    return recurse(j,k,board,word,len,hlen,0);
                }
            }
        }
        return false;

    }

    private boolean recurse(int j, int k, char[][] board, String word, int len, int hlen, int wordIndex) {
        if(j < 0 || k < 0 || j >= len || k >= hlen){
            return false;
        }
        if(board[j][k] == word.charAt(wordIndex)){
            char temp = board[j][k];
            board[j][k] = '*';
            if(wordIndex == word.length()-1)
                return true;
            else if(
                 recurse(j-1,k,board,word,len,hlen,wordIndex+1) ||
                        recurse(j+1,k,board,word,len,hlen,wordIndex+1)||
                        recurse(j,k+1,board,word,len,hlen,wordIndex+1)||
                        recurse(j,k-1,board,word,len,hlen,wordIndex+1)){
                return true;
            }

            board[j][k] = temp;

        }
        return false;

    }
}
