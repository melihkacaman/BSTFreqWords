package main;

import screens.ChooseFile;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        ChooseFile chooseFile = new ChooseFile();
        File[] files = chooseFile.getFiles();
    }
}
