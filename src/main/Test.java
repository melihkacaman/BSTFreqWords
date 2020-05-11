package main;

import screens.ChooseFile;
import wft.WordFrequencyTree;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        WordFrequencyTree tree = new WordFrequencyTree();

        Scanner scanner = new Scanner(System.in);

        ChooseFile chooseFile = new ChooseFile();
        File[] files = chooseFile.getFiles();

        if (files != null) {
            for (File f : files) {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String s = null;
                String fileName = f.getName();
                while ((s = br.readLine()) != null) {
                    for (String word : s.split(" ")) {
                        tree.insert(word, fileName);
                    }
                }
                fr.close();
            }
            System.out.println("WORD FREQ TREE IS DONE!");

            while (true) {
                System.out.print("What do you want to search? Please, give it: ");
                String query = scanner.nextLine();
                if (query.toCharArray()[0] == '-')
                    break;
                tree.query(query);
                System.out.println("If you don't want to search anymore, you should give the - character.");
            }
        }
    }
}
