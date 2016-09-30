import java.io.*;
import java.util.*;

public class Cipher {
    public static void main(String[] args){
        String[] nonThreat;
        String[] threat;
        
        try {
            Scanner in = new Scanner(new File("input.txt"));
            String dump = in.nextLine();
            //System.out.println(dump);
            
            //Scan until the end of the file.
            while(in.hasNextLine()){
                int nonThreatCount = in.nextInt();
                //System.out.println(nonThreatCount);
                nonThreat = new String[nonThreatCount];
                dump = in.nextLine();
                for (int i = 0; i < nonThreatCount; i++){
                    nonThreat[i] = in.nextLine();
                    //System.out.println(nonThreat[i]);
                }
                
                int threatCount = in.nextInt();
                //System.out.println(threatCount);
                dump = in.nextLine();
                threat = new String[threatCount];
                for (int i = 0; i < threat.length; i++){
                    threat[i] = in.nextLine();
                    //System.out.println(threat[i]);
                }
                String encrypted = in.nextLine();
                decrypt(encrypted, threat, nonThreat);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void decrypt(String encrypted, String[] threat, String[] nonThreat){
        /***
         * Logic:
         * Shift the function once.
         * Compare non threat words.
         * Compare threat words.
         * Get percentage.
         * Store the sum of those percentages
         * Shift it again
         * Do the same and if the sum of those percentages is bigger
         * Then store it as such
         * And store the most convenient shift
         */
         //System.out.println(encrypted);
         String encryptedTemp = encrypted;
         int shiftCount = 1;
         double maxThreatPercent = 0;
         double maxNonThreatPercent = 0;
         int universalShift = 0;
         double maxPercent = 0;
         boolean unable = false;
         while(shiftCount != 26){
             encryptedTemp = shiftBy(encrypted, shiftCount);
             //System.out.println("Threats");
             double threatPercent = compareWords(encryptedTemp, threat);
             //System.out.println("Non Threats");
             double nonThreatPercent = compareWords(encryptedTemp, nonThreat);

             if (threatPercent > maxThreatPercent){
                maxThreatPercent = threatPercent;
             }

             if (nonThreatPercent > maxNonThreatPercent){
                maxNonThreatPercent = nonThreatPercent;
                
             }

             if ((maxThreatPercent + maxNonThreatPercent) > maxPercent){
                maxPercent = maxThreatPercent + maxNonThreatPercent;
                universalShift = shiftCount;
             } else if ((maxThreatPercent + maxNonThreatPercent) == maxPercent){
                unable = true;
             }
             shiftCount++;
         }

         if(maxNonThreatPercent > 0 && !unable){
            System.out.println("Deciphered: " + encrypted + " into this by shifting " + universalShift);
            System.out.println(shiftByAll(encrypted, universalShift));
            //System.out.println(shiftBy(encrypted, universalShift));
            System.out.println("Shift: " + universalShift +  " Match: " + ( Math.round((maxNonThreatPercent + maxThreatPercent) * 100)) + "%  Threat: " + Math.round((maxThreatPercent * 100)) + "%");
            System.out.println("----------------------------------------");
         } else {
            System.out.println("Unable to decipher.");
            System.out.println("----------------------------------------");
         }
    }

    public static double compareWords(String sentence, String[] wordList){
        String[] sentenceWords = sentence.split(" ");
        double denum = sentenceWords.length;
        double num = 0;
        for(int i = 0; i < sentenceWords.length; i++){
            for(int j = 0; j < wordList.length; j++){
                if(sentenceWords[i].equalsIgnoreCase(wordList[j])){
                    //System.out.println(sentenceWords[i] + " " + wordList[j]);
                    //System.out.println(sentenceWords[i]);
                    num++;
                } else {
                    //System.out.println(sentenceWords[i] + " didnt match " + wordList[j]);
                }
            }
        }
        return num / (denum - 1);
    }

    public static String shiftBy(String sentence, int shift){
        char[] encryptedChars = sentence.toCharArray();
        for(int i = 0; i < encryptedChars.length; i++){
            if(Character.isLetter(encryptedChars[i])){
                if(Character.isLowerCase(encryptedChars[i])){
                    encryptedChars[i] -= shift;
                    if(encryptedChars[i] < 97){
                        encryptedChars[i] += 26;
                    }
                } else {
                    encryptedChars[i] -= shift;
                    if(encryptedChars[i] < 65){
                        encryptedChars[i] += 26;
                    }
                }
            } else {
                encryptedChars[i] = ' ';
            }
        }

        return String.valueOf(encryptedChars);
    }

    public static String shiftByAll(String sentence, int shift){
        //System.out.println(sentence);
        char[] encryptedChars = sentence.toCharArray();
        //System.out.println(String.valueOf(encryptedChars));
        for(int i = 0; i < encryptedChars.length; i++){
            if(Character.isLetter(encryptedChars[i])){
                if(Character.isLowerCase(encryptedChars[i])){
                    encryptedChars[i] -= shift;
                    if(encryptedChars[i] < 97){
                        encryptedChars[i] += 26;
                    }
                } else {
                    encryptedChars[i] -= shift;
                    if(encryptedChars[i] < 65){
                        encryptedChars[i] += 26;
                    }
                }
            }
        }
        //System.out.println(String.valueOf(encryptedChars));
        return String.valueOf(encryptedChars);
    }
}