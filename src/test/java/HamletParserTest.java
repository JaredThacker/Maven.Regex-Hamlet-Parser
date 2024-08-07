import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String test = "hamlet";
        String expected = "leon";

        Pattern p = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(test);

        String actual = m.replaceAll(expected);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String test = "horatio";
        String expected = "tariq";

        Pattern p = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(test);

        String actual = m.replaceAll(expected);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        String test = "is horatio here?";
        Pattern p = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(test);

        Assert.assertTrue(m.find());
    }

    @Test
    public void testFindHamlet() {
        String test = "is hamlet in this txt";
        Pattern p = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(test);

        Assert.assertTrue(m.find());
    }
}