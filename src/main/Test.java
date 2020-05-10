package main;

import screens.ChooseFile;
import wft.WordFrequencyTree;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        WordFrequencyTree tree = new WordFrequencyTree();

        ChooseFile chooseFile = new ChooseFile();
        File[] files = chooseFile.getFiles();
        for(File f: files){
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String s=null;
            String fileName = f.getName();
            while((s=br.readLine())!=null)
            {
                for(String word: s.split(" ")){
                    tree.insert(word, fileName);
                }
            }
            fr.close();
        }
        System.out.println();
    }
}
