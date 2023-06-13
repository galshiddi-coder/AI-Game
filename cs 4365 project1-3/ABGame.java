//Ghaida Alshiddi
//AI Project
//3/31/2022
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABGame {


    //used for static estmation eval
    static int num = 0;

    //if number of white pieces on the board is 3
    public static Boolean ThreePieces(char pos[]) {
        ArrayList <char[]> whitePieces = new ArrayList<>();
        for (int i = 0; i < pos.length; i++) {
            if (pos[i]=='W') {
                whitePieces.add(pos);
            } 
        }
        if (whitePieces.size() == 3) {
            return true;
        }
        return false;
    }
    //number of black on the board
    public static int CountBPieces(char [] b) {

        int blackPieces = 0;
        for (int i=0; i< b.length; i++) {
            if(b[i]=='B'){
                blackPieces++;
            }
        }
        return blackPieces;  
    }
    //number of white pieces on the board
    public static int CountWPieces(char [] b) {

        int whitePieces = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i]=='W') {
                whitePieces++;
            } 
        }
        return whitePieces;
    }
    // number of all possible ways B can move throught the board
    public static int numBMove(char [] b) {
        List <char []> L = new ArrayList<>();
        L = BlackMove(b);
        return (L.size());
    }

   //static estmation function used for minimax in midgame and endgame
    public static int StaticEst (char [] board, int depth){

        int blackPieces = CountBPieces(board);
        int whitePieces = CountWPieces(board);
        int numBlackMoves = numBMove(board);
        //if we have 2 or less black pieces left, W won
        if (blackPieces <= 2) {
            return 10000;
        } 
       //if we have 2 or less white pieces left, B won
        else if ( whitePieces <= 2){
            return -10000;
        }
        //if B can't move, W won
        else if (numBlackMoves == 0) {
            return 10000;
        }
        //else get static est of a leaf
        else{
            int estm = (1000*(whitePieces - blackPieces)- numBlackMoves);
            return estm;
        }
     }

       //checks if the current node (board piece) is in mill
     public static Boolean closeMill (int loc, char board[]){
        if(board[loc]=='x'){
            return false;
        }
        char C = board[loc];
        switch (loc){
            //a0
            case 0:
            if(board[2]==C && board[4]==C){
                return true;
            }
            else if (board[6]==C && board[18]==C){
                return true;
            }
            else{
                return false;
            }
            //g0
            case 1:
  
            if(board[3]==C && board[5]==C){
                return true;
            }
            else if (board[11]==C && board[20]==C){
                return true;
            }
            else{
                return false;
            }
            //b1
            case 2:
  
            if(board[0]==C && board[4]==C){
                return true;
            }
            else if (board[7]==C && board[15]==C){
                return true;
            }
            else{
                return false;
            }
            //f1
            case 3:
  
            if(board[5]==C && board[1]==C){
                return true;
            }
            else if (board[10]==C && board[17]==C){
                return true;
            }
            else{
                return false;
            }
            //c2
            case 4:
  
            if(board[0]==C && board[2]==C){
                return true;
            }
            else if (board[8]==C && board[12]==C){
                return true;
            }
            else{
                return false;
            }
  
            //e2
            case 5:
  
            if(board[3]==C && board[1]==C){
                return true;
            }
            else if (board[9]==C && board[14]==C){
                return true;
            }
            else{
                return false;
            }
            //a3
            case 6:
  
            if(board[0]==C && board[18]==C){
                return true;
            }
            else if (board[7]==C && board[8]==C){
                return true;
            }
            else{
                return false;
            }
            //b3
            case 7:
  
            if(board[6]==C && board[8]==C){
                return true;
            }
            else if (board[2]==C && board[15]==C){
                return true;
            }
            else{
                return false;
            }
            //c3
            case 8:
  
            if(board[4]==C && board[12]==C){
                return true;
            }
            else if (board[6]==C && board[7]==C){
                return true;
            }
            else{
                return false;
            }
            //c2
            case 9:
  
            if(board[5]==C && board[14]==C){
                return true;
            }
            else if (board[10]==C && board[11]==C){
                return true;
            }
            else{
                return false;
            }
            //f3
            case 10:
  
            if(board[3]==C && board[17]==C){
                return true;
            }
            else if (board[9]==C && board[11]==C){
                return true;
            }
            else{
                return false;
            }
            //g3
            case 11:
  
            if(board[1]==C && board[20]==C){
                return true;
            }
            else if (board[9]==C && board[10]==C){
                return true;
            }
            else{
                return false;
            }
            //c4
            case 12:
  
            if(board[4]==C && board[8]==C){
                return true;
            }
            else if (board[13]==C && board[14]==C){
                return true;
            }
            else if (board[18]==C && board[15]==C){
                return true;
            }
            else{
                return false;
            }
  
           //d4
            case 13:
  
           if(board[12]==C && board[14]==C){
               return true;
           }
           else if (board[16]==C && board[19]==C){
               return true;
           }
           else{
               return false;
           }
           //e4
            case 14:
  
           if(board[12]==C && board[13]==C){
               return true;
           }
           else if (board[9]==C && board[5]==C){
               return true;
           }
           else if (board[17]==C && board[20]==C){
               return true;
           }
           else{
               return false;
           }
            //b5
            case 15:
  
            if(board[2]==C && board[7]==C){
                return true;
            }
            else if (board[18]==C && board[12]==C){
                return true;
            }
            else if (board[16]==C && board[17]==C){
                return true;
            }
            else{
                return false;
            }
           //d5
            case 16:
  
           if(board[15]==C && board[17]==C){
               return true;
           }
           else if (board[19]==C && board[13]==C){
               return true;
           }
           else{
               return false;
           }
           //f5
            case 17:
  
           if(board[20]==C && board[14]==C){
               return true;
           }
           else if (board[3]==C && board[10]==C){
               return true;
           }
           else if (board[15]==C && board[16]==C){
               return true;
           }
           else{
               return false;
           }
           //a6       
            case 18:
  
           if(board[0]==C && board[6]==C){
               return true;
           }
           else if (board[15]==C && board[12]==C){
               return true;
           }
           else if (board[19]==C && board[20]==C){
               return true;
           }
           else{
               return false;
           } 
           //d6
            case 19:
  
           if(board[18]==C && board[20]==C){
               return true;
           }
           else if (board[16]==C && board[13]==C){
               return true;
           }
           else{
               return false;
           }
           //g6        
            case 20:
  
           if(board[18]==C && board[19]==C){
               return true;
           }
           else if (board[17]==C && board[14]==C){
               return true;
           }
           else if (board[11]==C && board[1]==C){
               return true;
           }
           else{
               return false;
           }
  
        }
        return false;
    }
    
    //get the addresses of the neighboring cells
    public static ArrayList <Integer> getIndex(int loc) {

        ArrayList <Integer> index = new ArrayList<>();
        switch (loc) {
            //a0
            case 0:
                index.add(1);
                index.add(2);
                index.add(6);
    
            //g0
            case 1:
                index.add(0);
                index.add(3);
                index.add( 11);
    
            //b1
            case 2:
                index.add( 0);
                index.add( 4);
                index.add( 3);
                index.add( 7);
    
            //f1
            case 3:
                index.add( 1);
                index.add( 2);
                index.add( 5);
                index.add( 10);
    
            //c2
            case 4:
                index.add( 2);
                index.add( 8);
                index.add( 5);
    
            //e2
            case 5:
                index.add( 4);
                index.add( 9);
                index.add( 3);
    
            //a3
            case 6:
                index.add( 0);
                index.add( 7);
                index.add( 18);
    
            //b3
            case 7:
                index.add( 15);
                index.add( 2);
                index.add( 6);
                index.add( 8);
    
            //c3
            case 8:
                index.add( 4);
                index.add( 12);
                index.add( 7);
    
            //e3
            case 9:
                index.add( 5);
                index.add( 14);
                index.add( 10);
    
            //f3
            case 10:
                index.add( 3);
                index.add( 11);
                index.add( 17);
                index.add( 9);
    
            //g3
            case 11:
                index.add( 1);
                index.add( 10);
                index.add( 20);
                
            //c4
            case 12:
                index.add( 8);
                index.add( 15);
                index.add( 13);
    
            //d4
            case 13:
                index.add(12);
                index.add(16);
                index.add(14);
    
            //e4
            case 14:
                index.add( 13);
                index.add( 17);
                index.add( 9);
    
            //b5
            case 15:
                index.add( 7);
                index.add( 18);
                index.add( 16);
                index.add( 12);
    
            //d5
            case 16:
                index.add( 15);
                index.add( 19);
                index.add( 17);
                index.add(13);
    
            //f5
            case 17:
                index.add(14);
                index.add( 16);
                index.add( 20);
                index.add( 10);
    
            //a6
            case 18:
                index.add( 6);
                index.add( 15);
                index.add( 19);
    
            //d6
            case 19:
                index.add(18);
                index.add( 15);
                index.add( 20);
    
            //g6
            case 20:
                index.add(19);
                index.add(17);
                index.add(11);
    
        }
        return index;
    }
    //returns possible moves of B
    public static List <char []> BlackMove (char pos[]){
        List <char []> L = new ArrayList<>();
        List <char []> L2 = new ArrayList<>();
        char tempb [] =pos.clone();
        //first swap all W to B, and B to W, and call the white move generator
        for (int j=0; j< pos.length; j++) {
            if(pos[j] == 'W'){
                tempb[j] = 'B';
            }
            else if(pos[j]== 'B'){
                tempb[j] = 'W'; 
            }
        }
        //show all possible board options 
        L = GenerateMovesMidgameEndgame(tempb);
        //return W to B snd B to W.
        for (int j = 0; j < L.size(); j++) { 
            char [] current = L.get(j);
           //copy current element into tempb
            tempb =current.clone();
            //loop through each board, and return the pieces W to B and B to W
            for (int n = 0; n < current.length; n++) {
                if (current[n]== 'W') {
                    tempb[n]='B';
                }
                else if(current[n]== 'B'){
                  tempb[n] = 'W'; 
                }
            }
        // add each new board to this list
        L2.add(tempb);
    }
    return L2;
   }

   // remove a black piece(that is not in mill), when white pieces are in mill 
   public static List <char []> generateRemove (char board[], List <char[]> L){
        //a list of the new boards
        L = new ArrayList<>();
        // a second board
        char b [];
        //loop through the current board
        for (int i=0; i< board.length; i++) {
            //copy board element into b
            b = board.clone();
            if(board[i]=='B'){
                //delete if b isn't in a mill
                if (!closeMill(i, board)){
                    b[i] = 'x';
                    //new board
                    L.add(b);
                }
            }
            //if piece isn't black, then add it to the new board
            else{
                L.add(b);
            }    
    } 
    return L;
   }

   //move white piece to the neighboring cells
    public static List <char[]> GenerateMove (char pos[]){
        //list of boards
        ArrayList <char[]> L = new ArrayList<>();
        //a list of the neighboring cells addresses
        List<Integer> neighbor = new ArrayList<>();
        //a second board
        char [] b;
        //lop through the current board
        for (int i = 0; i < pos.length; i++) {
            if (pos[i]== 'W') {
                //get the addresses of the neighboring cells to W
                neighbor = getIndex(i);
                for (Integer c : neighbor) {
                    b = pos.clone();
                    //If a cell is empty then place a W
                    if (pos[c] == 'x') {
                        b[i] = 'x';
                        b[c] = 'W';
                        //if we form a mill, delete B
                        if(closeMill(c, b)){
                            generateRemove(b, L);
                        }
                        //add to the new list of baords
                        else{
                            L.add(b);
                        }
                    }
                }
            }
        }
        return L;
    }
    // execute this when we have 3 white pieces left, can place W at any empty spot in the board
    public static List <char[]> GenerateHopping (char pos[]){
        //a list of boards       
        ArrayList <char []> L = new ArrayList<>();
       // a second board
        char [] b = null;
        //loop through current board
        for (int i = 0; i < pos.length; i++) {
            if (pos[i]=='W') {
                //look for an empty spot to place W
                for (int j = 0; j < pos.length; j++) {
                    b = pos.clone(); 
                    if (pos[j]=='x') {
                        b[i] = 'x';
                        b[j] = 'W';
                        //if we form a mill, delete B
                        if(closeMill(j, b)){
                            generateRemove(b, L);
                        }
                        else{
                            L.add(b);
                        }
                    }
                }
            }
        }
        return L;
    }

    //generates moves based on the number of white pieces
    public static List <char[]> GenerateMovesMidgameEndgame (char pos[]){
        //a list of boards
        List<char []> whitePiecesList = new ArrayList<>();
        //if 3 pieces lef, we are on endgame
        if (ThreePieces(pos)) {
            whitePiecesList = GenerateHopping(pos);
        }
        //if not, then we are in midgame
        else{
            whitePiecesList = GenerateMove(pos);
        }
        return whitePiecesList;
    }
   
    //checks if we reached the leaf node 
    public static Boolean Leaf(int depth) {

        if (depth == 0) {
            return true;
        }
        return false;
    }

   //returns the final board output and writes the board on a file
    public static char [] BoardOutput(ArrayList<char[]> board) {

        char [] output = new char [20];
       //will change until minimax finds the best path
        for (int i = 0; i < board.size(); i++) {
            output = board.get(i);
        }
       //writes the output file
        try {
            FileWriter write = new FileWriter("board6.txt");
            write.write(output);
            write.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output;
    }

 
   //board = child
   //minimizer. choose the least value of the nodes and pass it to MaxMin
   public static int MinMax (char [] board, List <char[]> possibleLoc, int depth, int a, int b){

    int v = 10000;
    //a list the keeps track of the visited nodes
    ArrayList <char[]> output = new ArrayList<>();
    //if the node is leaf return the static estimation func
    if (Leaf(depth)) {

        num++;//each time we reach a leaf nodes increment the # of visited nodes
        return StaticEst(board, depth);
        
    }
    //if node isn't leaf
    else{
         //get the children of the current board
         possibleLoc = new ArrayList<>();
         //the children of white piece (current board) is black piecese (minimizer)
         possibleLoc = BlackMove(board);
         //loop through each child and get their value
         for (char [] c : possibleLoc) {
             
             int eval = MaxMin(c, possibleLoc, depth-1, a, b);
             //if MaxMin value is less than v, then add node to the list
             if(v>eval){
                 output.add(c);
             }
             //assign v to the least value of v or MaxMin
             v = Math.min(v, eval);
             //if alpha is larger than or equal the cuurent value, leave the current board
             if(v <= a){
                 return v;
             } 
             //if not, then assign beta to the min value of v or b
             else{
                 b = Math.min(v, b);
             }
         }
         //get the final board
         BoardOutput(output);
        return v;
    }
}

//maximizer. choose the max value of nodes and pass it to MinMax
public static int MaxMin(char [] board, List <char []> possibleLoc, int depth, int a, int b){

    int v =-10000;
    //a list the keeps track of the visited nodes
    ArrayList <char[]> output = new ArrayList<>();
    //if the node is leaf return the static estimation func
    if (Leaf(depth)) {
         num++;//each time we reach a leaf nodes increment the # of visited nodes
         return StaticEst(board, depth);
        
     }

    //only access once if depth is 2
    //if node isn't leaf
    else{
        //get the children of the current board
        possibleLoc = new ArrayList<>();
         //the children of the inital board, or children of
         //the black piece (current board) is white piecese (maximizer)
        possibleLoc = GenerateMovesMidgameEndgame(board);
        //loop through each child and get their value
        for (char [] c : possibleLoc) {
            int eval = MinMax(c, possibleLoc, depth-1, a, b);
             //if MaxMin value is less than v, then add node to the list
             if(v<eval){
                 output.add(c);
             }
            //assign v to the max value of v or MaxMin
             v = Math.max(v, eval);
             //if v of current node is larger than b, leave the current board
             if (v >= b) {
                 return v;
             } 
             //slse, alpha is equal to the max of v or alpha
             else {
                 a= Math.max(v, a);
             }
         }
         //final result of board
         BoardOutput(output);
        return v;
    }
}

//call in main, returns the final board
public static int MiniMax (char [] board, int depth){
   
   List <char[]> possibleLoc = new ArrayList<>();
   int a=-10000;
   int b = 10000;

    return MaxMin(board, possibleLoc, depth, a, b);
}

    public static void main(String[] args) throws IOException {
        char [] b = new char[20];
        //file name
        String name = "board3.txt";
        File board = new File (name);
        //read file
         try {
            Scanner r = new Scanner(board);
            
            while(r.hasNextLine()){
                //convert data to char[]
                String file = r.nextLine();
                b = file.toCharArray();
                System.out.println("MINIMAX estimate:");
                System.out.println( MiniMax(b, 4));
                System.out.println("Positions evaluated by static estimation: " + num);
            }
        } finally{
 
        }
    }
}
