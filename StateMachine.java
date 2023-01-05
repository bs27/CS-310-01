package ObjectOrientedDesign;

import java.util.Scanner;

// -- state machine for Figure 6.2 of the textbook
public class StateMachine {


    public static boolean stateMachine(String word) {
        int state = 1;  // -- start state
        int cursor = 0; // -- start of input

        // -- process entire input (or until an illegal input comes up)
        while (cursor < word.length() && state != -1) {
            char ch = word.charAt(cursor);
            switch (state) {
                case 1:
                    if ((ch >= 'a' && ch <= 'z')||(ch == '$')||(ch >= 'A' && ch <= 'Z')||(ch == '_')){
                        state = 2;
                    } else if (ch >= '0' && ch <= '9') {
                        state = 4;
                    }else {
                        // -- invalid transition
                        state = -1;
                    }
                    break;
                case 2:
                    if ((ch >= 'a' && ch <= 'z')||(ch == '$')||(ch >= 'A' && ch <= 'Z')||(ch == '_')) {
                        state = 2;
                    }else if (ch >= '0' && ch <= '9') {
                        state = 3;
                    }else if (ch == ' ') {
                        state = 5;
                    }else {
                        // -- invalid transition
                        state = -1;
                    }
                    break;

                case 3:
                    if ((ch >= 'a' && ch <= 'z')||(ch == '$')||(ch >= 'A' && ch <= 'Z')||(ch == '_')) {
                        state = 2;
                    }else if (ch >= '0' && ch <= '9') {
                        state = 3;
                    }else if (ch == ' ') {
                        state = 5;
                    }else {
                        // -- invalid transition
                        state = -1;
                    }
                    break;
                case 4:
                    if (ch >= '0' && ch <= '9')
                        state = 4;
                    break;
                case 5:
                    if(ch ==' ') {
                        state = 5;
                    }else if (((ch >= 'a' && ch <= 'z')||(ch == '$')||(ch >= 'A' && ch <= 'Z')||(ch == '_')||(ch >= '0' && ch <= '9'))) {
                        state = 6;
                    }else {
                        // -- invalid transition
                        state = -1;
                    }
                    break;
                case 6:
                    if(((ch >= 'a' && ch <= 'z')||(ch == '$')||(ch >= 'A' && ch <= 'Z')||(ch == '_')||(ch >= '0' && ch <= '9')||(ch == ' '))) {
                        state = 6;
                    }else {
                        state = -1;


                        // -- invalid transition

                    }
                    break;

            }
            System.out.println("State: " + state);
            ++cursor;
        }

        return ((state == 2)||(state == 3)||(state == 5));
    }


    // -- row is the input (0:a, 1:b)
    // -- col is the state (1, 2, 3, 4)
   /* static int transitionTable[][] =
            {
                    {2, 1, 4, 3}, // a
                    {3, 4, 1, 2}, // b
            };

    // -- state machine matcher for the complex password pattern
    public static boolean stateMachineTable(String word) {
        int state = 1; // -- start state
        int cursor = 0;

        // -- process entire input (or until an illegal input comes up)
        while (cursor < word.length() && state != -1) {
            char ch = word.charAt(cursor);

            try {
                state = transitionTable[ch - 'a'][state - 1];
            }
            catch (ArrayIndexOutOfBoundsException e) {
                // -- invalid transition
                state = -1;
            }
            System.out.println("State: " + state);
            ++cursor;
        }

        return state == 4;
    }*/

    public static void main(String[] args) {
        String[] input = new String[]{"hello", "hello1", "hello world", "1hello", "_hello", "hello_", "$hello", "hello$"};
        for (String string : input){
            System.out.println("Sting Being Tested: " + string);
            System.out.println(stateMachine(string));
        }


    }

}