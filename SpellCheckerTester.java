package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tester class for the Spell Checker Class
 * 
 * @author Max Barker and Josi Gac
 * @version 10/21/25
 */
public class SpellCheckerTester {
    private SpellChecker spellChecker;
    private File dictionaryFile;
    private File helloWorldFile;
    private File goodLuckFile;

    @BeforeEach
    public void setUp() throws IOException {
        dictionaryFile = new File("dictionary.txt");
        helloWorldFile = new File("hello_world.txt");
        goodLuckFile = new File("good_luck.txt");
        
        spellChecker = new SpellChecker(dictionaryFile);
    }

    @Test
    public void testAddToDictionaryNewWord() {
    	spellChecker.addToDictionary("otter");
        List<String> result = spellChecker.spellCheck(dictionaryFile);
        assertFalse(result.contains("otter"));
    }

    @Test
    public void testAddToDictionaryDuplicateWord() {
    	spellChecker.addToDictionary("course"); 
        List<String> result = spellChecker.spellCheck(dictionaryFile);
        assertFalse(result.contains("course"));
    }

    @Test
    public void testRemoveFromDictionaryExistingWord() {
    	spellChecker.removeFromDictionary("racehorse");
        List<String> result = spellChecker.spellCheck(dictionaryFile);
        assertTrue(result.contains("racehorse"));
    }

    @Test
    public void testRemoveFromDictionaryNonexistentWord() {
    	spellChecker.removeFromDictionary("nonexistentword");
        List<String> result = spellChecker.spellCheck(dictionaryFile);
        assertFalse(result.contains("nonexistentword"));
    }
    
    @Test
    public void testSpellCheckGoodLuck() {
        List<String> result = spellChecker.spellCheck(goodLuckFile);
        assertFalse(result.contains("luck"));
    }

    @Test
    public void testSpellCheckCaseInsensitive() {
    	spellChecker.addToDictionary("Hello");
        List<String> result = spellChecker.spellCheck(helloWorldFile);
        assertFalse(result.contains("hello"));
    }
}