package ObjectOrientedDesign;

import java.io.IOException;

public class RadixSort {
    public static void main(String[] args) throws IOException {
        int[] unsortedInteger = {1405,975,239,9803,4835,2082,7368,573,804,746,4703,1421,4273,1208,521,2050};
        int lengthInt = unsortedInteger.length;

        String[] unsorted = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
       // String[] unsorted = {"majority", "tin", "construct", "berry","sketch","satellite","uncertainty","refrigerator ","sustain","open","chip","identity","friend","cancel","pudding","enhance","publication","proportion","courtship","dribble"};
       // String[] unsorted = {" blast" , " convulsion" , " mole" , " split" , " cable" , " study" , " exemption" , " requirement" , " respectable" , " zone" , " even" , " self" , " retreat" , " dawn" , " salvation" , " passage" , " sickness" , " season" , " question" , " trap"};
       // String[] unsorted = {" run" , " ex" , " border" , " win" , " steak" , " perforate" , " bill" , " show" , " fix" , " quest" , " tail" , " cake" , " youth" , " hammer" , " isolation" , " preference" , " marketing" , " rebellion" , " arm" , " deep"};
        int lengthString = unsorted.length;
        radixSortInt(unsortedInteger,lengthInt);
        radixSortString(unsorted,lengthString);
        System.out.println("---------------Sorted Number List-------------------");
        for(int i = 0; i < lengthInt; i++){
            System.out.println(unsortedInteger[i]);
        }
        System.out.println("---------------Sorted Word List-------------------");
        for(int i = 0; i < lengthString; i++){
            System.out.println(unsorted[i]);
        }

    }
    // Goal : "eight","eighteen","eleven","fifteen","five","four","fourteen","nine","nineteen","one","seven","seventeen","six","sixteen","ten","thirteen","three","twelve","twenty","two","zero"

    private static void radixSortString(String[] unsorted, int lengthString) {
        //Determine Key Size
        int keySize = determineKeySizeString(unsorted);
        String[][] BensBuckets = new String[27][lengthString+1];
        normalize(unsorted, keySize);
        //appending thing

        int starCounter = 0;
        int aCounter = 0;
        int bCounter = 0;
        int cCounter = 0;
        int dCounter = 0;
        int eCounter = 0;
        int fCounter = 0;
        int gCounter = 0;
        int hCounter = 0;
        int iCounter = 0;
        int jCounter = 0;
        int kCounter = 0;
        int lCounter = 0;
        int mCounter = 0;
        int nCounter = 0;
        int oCounter = 0;
        int pCounter = 0;
        int qCounter = 0;
        int rCounter = 0;
        int sCounter = 0;
        int tCounter = 0;
        int uCounter = 0;
        int vCounter = 0;
        int wCounter = 0;
        int xCounter = 0;
        int yCounter = 0;
        int zCounter = 0;
        char bucketchar = '1';
        initalizeBensBuckets(BensBuckets);
        for (int letter = keySize-1; letter >= 0; letter--){
            /*if(letter == (keySize - 2)){
                System.out.println("Check me out");
            }*/
            starCounter = 0;
            aCounter = 0;
            bCounter = 0;
            cCounter = 0;
            dCounter = 0;
            eCounter = 0;
            fCounter = 0;
            gCounter = 0;
            hCounter = 0;
            iCounter = 0;
            jCounter = 0;
            kCounter = 0;
            lCounter = 0;
            mCounter = 0;
            nCounter = 0;
            oCounter = 0;
            pCounter = 0;
            qCounter = 0;
            rCounter = 0;
            sCounter = 0;
            tCounter = 0;
            uCounter = 0;
            vCounter = 0;
            wCounter = 0;
            xCounter = 0;
            yCounter = 0;
            zCounter = 0;
            initalizeBensBuckets(BensBuckets);

            for (int entry = 0; entry < unsorted.length; entry ++) {
                bucketchar = ((unsorted[entry].charAt(letter)));
                //append function
                switch (bucketchar) {

                   /* case 'a':
                        BensBuckets[0][aCounter] = unsorted[entry];
                        aCounter++;
                        break;
                    case 'b' :
                        BensBuckets[1][bCounter] = unsorted[entry];
                        bCounter++;
                        break;
                    case 'c' :
                        BensBuckets[2][cCounter] = unsorted[entry];
                        cCounter++;
                        break;
                    case 'd' :
                        BensBuckets[3][dCounter] = unsorted[entry];
                        dCounter++;
                        break;
                    case 'e' :
                        BensBuckets[4][eCounter] = unsorted[entry];
                        eCounter++;
                        break;
                    case 'f':
                        BensBuckets[5][fCounter] = unsorted[entry];
                        fCounter++;
                        break;
                    case 'g':
                        BensBuckets[6][gCounter] = unsorted[entry];
                        gCounter++;
                        break;
                    case 'h' :
                        BensBuckets[7][hCounter] = unsorted[entry];
                        hCounter++;
                        break;
                    case 'i' :
                        BensBuckets[8][iCounter] = unsorted[entry];
                        iCounter++;
                        break;
                    case 'j' :
                        BensBuckets[9][jCounter] = unsorted[entry];
                        jCounter++;
                        break;
                    case 'k' :
                        BensBuckets[10][kCounter] = unsorted[entry];
                        kCounter++;
                        break;
                    case 'l':
                        BensBuckets[11][lCounter] = unsorted[entry];
                        lCounter++;
                        break;
                    case 'm':
                        BensBuckets[12][mCounter] = unsorted[entry];
                        mCounter++;
                        break;
                    case 'n' :
                        BensBuckets[13][nCounter] = unsorted[entry];
                        nCounter++;
                        break;
                    case 'o' :
                        BensBuckets[14][oCounter] = unsorted[entry];
                        oCounter++;
                        break;
                    case 'p' :
                        BensBuckets[15][pCounter] = unsorted[entry];
                        pCounter++;
                        break;
                    case 'q' :
                        BensBuckets[16][qCounter] = unsorted[entry];
                        qCounter++;
                        break;
                    case 'r':
                        BensBuckets[17][rCounter] = unsorted[entry];
                        rCounter++;
                        break;
                    case 's':
                        BensBuckets[18][sCounter] = unsorted[entry];
                        sCounter++;
                        break;
                    case 't' :
                        BensBuckets[19][tCounter] = unsorted[entry];
                        tCounter++;
                        break;
                    case 'u' :
                        BensBuckets[20][uCounter] = unsorted[entry];
                        uCounter++;
                        break;
                    case 'v' :
                        BensBuckets[21][vCounter] = unsorted[entry];
                        vCounter++;
                        break;
                    case 'w' :
                        BensBuckets[22][wCounter] = unsorted[entry];
                        wCounter++;
                        break;
                    case 'x':
                        BensBuckets[23][xCounter] = unsorted[entry];
                        xCounter++;
                        break;
                    case 'y':
                        BensBuckets[24][yCounter] = unsorted[entry];
                        yCounter++;
                        break;
                    case 'z' :
                        BensBuckets[25][zCounter] = unsorted[entry];
                        zCounter++;
                        break;
                    case '*':
                        BensBuckets[26][starCounter] = unsorted[entry];
                        starCounter++;
                        break;*/

                    case '*':
                        BensBuckets[0][starCounter] = unsorted[entry];
                        starCounter++;
                        break;
                    case 'a':
                        BensBuckets[1][aCounter] = unsorted[entry];
                        aCounter++;
                        break;
                    case 'b' :
                        BensBuckets[2][bCounter] = unsorted[entry];
                        bCounter++;
                        break;
                    case 'c' :
                        BensBuckets[3][cCounter] = unsorted[entry];
                        cCounter++;
                        break;
                    case 'd' :
                        BensBuckets[4][dCounter] = unsorted[entry];
                        dCounter++;
                        break;
                    case 'e' :
                        BensBuckets[5][eCounter] = unsorted[entry];
                        eCounter++;
                        break;
                    case 'f':
                        BensBuckets[6][fCounter] = unsorted[entry];
                        fCounter++;
                        break;
                    case 'g':
                        BensBuckets[7][gCounter] = unsorted[entry];
                        gCounter++;
                        break;
                    case 'h' :
                        BensBuckets[8][hCounter] = unsorted[entry];
                        hCounter++;
                        break;
                    case 'i' :
                        BensBuckets[9][iCounter] = unsorted[entry];
                        iCounter++;
                        break;
                    case 'j' :
                        BensBuckets[10][jCounter] = unsorted[entry];
                        jCounter++;
                        break;
                    case 'k' :
                        BensBuckets[11][kCounter] = unsorted[entry];
                        kCounter++;
                        break;
                    case 'l':
                        BensBuckets[12][lCounter] = unsorted[entry];
                        lCounter++;
                        break;
                    case 'm':
                        BensBuckets[13][mCounter] = unsorted[entry];
                        mCounter++;
                        break;
                    case 'n' :
                        BensBuckets[14][nCounter] = unsorted[entry];
                        nCounter++;
                        break;
                    case 'o' :
                        BensBuckets[15][oCounter] = unsorted[entry];
                        oCounter++;
                        break;
                    case 'p' :
                        BensBuckets[16][pCounter] = unsorted[entry];
                        pCounter++;
                        break;
                    case 'q' :
                        BensBuckets[17][qCounter] = unsorted[entry];
                        qCounter++;
                        break;
                    case 'r':
                        BensBuckets[18][rCounter] = unsorted[entry];
                        rCounter++;
                        break;
                    case 's':
                        BensBuckets[19][sCounter] = unsorted[entry];
                        sCounter++;
                        break;
                    case 't' :
                        BensBuckets[20][tCounter] = unsorted[entry];
                        tCounter++;
                        break;
                    case 'u' :
                        BensBuckets[21][uCounter] = unsorted[entry];
                        uCounter++;
                        break;
                    case 'v' :
                        BensBuckets[22][vCounter] = unsorted[entry];
                        vCounter++;
                        break;
                    case 'w' :
                        BensBuckets[23][wCounter] = unsorted[entry];
                        wCounter++;
                        break;
                    case 'x':
                        BensBuckets[24][xCounter] = unsorted[entry];
                        xCounter++;
                        break;
                    case 'y':
                        BensBuckets[25][yCounter] = unsorted[entry];
                        yCounter++;
                        break;
                    case 'z' :
                        BensBuckets[26][zCounter] = unsorted[entry];
                        zCounter++;
                        break;
                }
            }
 /*           for(int i = 0; i < 27; i++){
                System.out.println("");
                for (int a = 0; a < BensBuckets[0].length; a++){
                    System.out.print(" " + BensBuckets[i][a] + " ");
                }}
            System.out.println("\n");
            System.out.println("___________________________");*/



            //combine Buckets
            int c = 0;
            int count = 0;
            for(int i = 0; i < 27; i++){
                c = 0;
                while (!BensBuckets[i][c].equals("")){
                    //This is the error
                    unsorted[count] = BensBuckets[i][c];
                    c++;
                    count++;
                }

            }

        }
        weirdize(unsorted);
    }

    private static void print(String[] unsorted) {
        for (String s : unsorted) {
            System.out.println(s);
        }
    }

    private static void weirdize(String[] unsorted) {
        int indexOfString = 0;
        int indexOfLetter;
        for (String string : unsorted){
            indexOfLetter = 0;
            if(string.contains("*")) {
                while ((string.charAt(indexOfLetter) != '*')) {
                    indexOfLetter++;
                }
                unsorted[indexOfString] = (String) unsorted[indexOfString].subSequence(0, (indexOfLetter));
            }
            indexOfString++;
        }
    }

    private static void normalize(String[] unsorted, int keySize) {
        String additiveString = "";
        int index = 0;
        for (String string : unsorted){
            additiveString = "";
            if(string.length() < keySize){
                int deficit = (keySize - string.length());
                for(int num = 1; num <= deficit; num++){
                    additiveString = additiveString + "*";
                }
                unsorted[index] = string + additiveString;

            }
            index++;


        }
    }

    private static void radixSortInt(int[] unsortedInteger, int lengthInt) {

        int keySize = determineKeySize(unsortedInteger);

        //appending thing
        int zeroCounter = 0;
        int oneCounter = 0;
        int twoCounter = 0;
        int threeCounter = 0;
        int fourCounter = 0;
        int fiveCounter = 0;
        int sixCounter = 0;
        int sevenCounter = 0;
        int eightCounter = 0;
        int nineCounter = 0;

        int bucketNumber = -1;
        int[][] BensBuckets = new int[10][lengthInt];
        initalizeBensBuckets(BensBuckets);
        int shift = 1;
        for (int digit = 1; digit <= keySize; digit++){
            initalizeBensBuckets(BensBuckets);
            zeroCounter = 0;
            oneCounter = 0;
            twoCounter = 0;
            threeCounter = 0;
            fourCounter = 0;
            fiveCounter = 0;
            sixCounter = 0;
            sevenCounter = 0;
            eightCounter = 0;
            nineCounter = 0;
            for (int entry = 0; entry < unsortedInteger.length; entry ++) {
                bucketNumber = ((unsortedInteger[entry] / shift) % 10);
                //append function
                switch (bucketNumber) {
                    case 0 -> {
                        BensBuckets[bucketNumber][zeroCounter] = unsortedInteger[entry];
                        zeroCounter++;

                    }
                    case 1 -> {
                        BensBuckets[bucketNumber][oneCounter] = unsortedInteger[entry];
                        oneCounter++;
                    }
                    case 2 -> {
                        BensBuckets[bucketNumber][twoCounter] = unsortedInteger[entry];
                        twoCounter++;
                    }
                    case 3 -> {
                        BensBuckets[bucketNumber][threeCounter] = unsortedInteger[entry];
                        threeCounter++;
                    }
                    case 4 -> {
                        BensBuckets[bucketNumber][fourCounter] = unsortedInteger[entry];
                        fourCounter++;
                    }
                    case 5 -> {
                        BensBuckets[bucketNumber][fiveCounter] = unsortedInteger[entry];
                        fiveCounter++;
                    }
                    case 6 -> {
                        BensBuckets[bucketNumber][sixCounter] = unsortedInteger[entry];
                        sixCounter++;
                    }
                    case 7 -> {
                        BensBuckets[bucketNumber][sevenCounter] = unsortedInteger[entry];
                        sevenCounter++;
                    }
                    case 8 -> {
                        BensBuckets[bucketNumber][eightCounter] = unsortedInteger[entry];
                        eightCounter++;
                    }
                    case 9 -> {
                        BensBuckets[bucketNumber][nineCounter] = unsortedInteger[entry];
                        nineCounter++;
                    }
                }
            }
            /*for(int i = 0; i < 10; i++){
                System.out.println("");
                for (int a = 0; a < BensBuckets[0].length; a++){
                    System.out.print(" " + BensBuckets[i][a] + " ");
                }}
            System.out.println("\n");
            System.out.println("___________________________");*/



                //combine Buckets
                int c = 0;
                int count = 0;
                for(int i = 0; i < 10; i++){
                    c = 0;
                    while (BensBuckets[i][c] != 0){
                        unsortedInteger[count] = BensBuckets[i][c];
                        c++;
                        count++;



                }

            }
                shift = shift * 10;
        }

    }

    private static void initalizeBensBuckets(int[][] BensBuckets) {
        for(int i = 0; i < BensBuckets.length; i++){
            for (int a = 0; a < BensBuckets[0].length; a++){
                BensBuckets[i][a] = 0;
            }

        }
    }
    private static void initalizeBensBuckets(String [][] BensBuckets) {
        for(int i = 0; i < BensBuckets.length; i++){
            for (int a = 0; a < BensBuckets[0].length; a++){
                BensBuckets[i][a] = "";
            }

        }
    }

    private static int determineKeySize(int[] unsortedInteger) {
        int shift = 1;
        int keysize = -1;
        int keyCount;
        for (int value : unsortedInteger) {
            keyCount = 0;
            shift = 1;
            while ((value % shift) != value) {
                shift = shift * 10;
                keyCount++;
            }
            if (keyCount > keysize) {
                keysize = keyCount;
            }
        }
       return keysize;
    }
    private static int determineKeySizeString(String[] unsortedString) {
        int keysize = 0;
        for(String string : unsortedString){
            if(keysize < string.length()){
                keysize = string.length();
            }

        }
        return keysize;
    }
}


