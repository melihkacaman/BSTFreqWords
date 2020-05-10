package screens;

import javax.swing.*;
import java.io.File;

public class ChooseFile {
    private JFileChooser jFileChooser;

    public ChooseFile() {
        this.jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("choosertitle");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);
    }

    public File[] getFiles(){
        File[] files = null;
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            files = jFileChooser.getSelectedFile().listFiles();
            assert files != null;
            System.out.println("The file that you have just chosen size is " + files.length);
        } else {
            System.out.println("No Selection ");
        }

        return files;
    }
}
