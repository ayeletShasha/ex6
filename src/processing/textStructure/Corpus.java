package processing.textStructure;

import processing.parsingRules.IparsingRule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a body of works - anywhere between one and thousands of documents sharing the same
 * structure and that can be parsed by the same parsing rule.
 */
public class Corpus implements Iterable<Entry> {

    private ArrayList<Entry> entries = new ArrayList<>();

    public Corpus(String path, String parserName) throws IOException {
        /*
        check if the path is a folder or file.
        if file - single entry corpus.
        otherwise, recursively scan the directory for all subdirectories and files.
        each entry in a corpus should hold the folder from which the file came. ## how to implement?
         */
        //TODO implement me!!!
        try {
            File corpus = new File(path);
            if (corpus.isFile()) {
            } else {
                getEntries(corpus);
            }
        } catch (NullPointerException e) { // bad path
            System.err.println("Error: bad corpus path");
        }
    }


    /**
     * Return the parsing rule used for this corpus
     *
     * @return
     */
    public IparsingRule getParsingRule() {
        //TODO implement me!!!
    }

    /**
     * Iterate over Entry objects in the Corpus
     *
     * @return An Entry iterator
     */
    @Override
    public Iterator<Entry> iterator() {
        //TODO implement me!!!
    }

    /**
     * Return the checksum of the entire corpus.
     * Can be calculated by getting the checksum of each file, then concating them to one string and
     * returning the checksum of that string.
     *
     * @return
     */
    public String getChecksum() {
        //TODO implement me!!!
    }

    /**
     * recursive method that scans a folder to get all of it's files, including files in subfolders
     *
     * @param path - the path we're scanning
     */
    private void getEntries(File path) {
        for (File file : path.listFiles()) {
            if (file.isFile()) {
                this.entries.add(new Entry(file.getPath(), getParsingRule()));
            }
            if (file.isDirectory()) {
                getEntries(file);
            }
        }
    }
}
