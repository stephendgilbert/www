import net.sf.webcat.*;
import static net.sf.webcat.ReflectionSupport.*;
import java.lang.reflect.*;
import net.sf.webcat.annotations.*;
import java.util.*;
/**
 *  CS 170 Lecture 2 Test Program.
 *
 *  @author  Stephen Gilbert
 *  @version Summer 2008
 */
public class TicTacToeBoardPrinterTest extends junit.framework.TestCase
{
    private final String className = "TicTacToeBoardPrinter";

    private Class thisClass;
    private Field[] fields;
    private ArrayList<String> fieldNames = new ArrayList<String>();
    private Constructor[] constructors;
    private Method[] methods;
    private ArrayList<String> methodNames = new ArrayList<String>();
    private Object obj;
    
    private PrintStreamWithHistory history = null;
    private static final String EOL = System.getProperty("line.separator");


    /**
     * Creates a new TicTacToeBoardPrinterTest object.
     */
    public TicTacToeBoardPrinterTest()
    {
        try {
            thisClass = Class.forName(className);

            fields = thisClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fieldNames.add(fields[i].getName());
            }

            constructors = thisClass.getDeclaredConstructors();
            methods = thisClass.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                methodNames.add(methods[i].getName());
            }
        }
        catch (ClassNotFoundException e) {
            /* Nothing to catch */
        }
    }

    //~ Methods ...............................................................

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp()
    {
        try {
            obj = create(className);
        }
        catch (Throwable t) {
            /* nothing to do */
        }
        history = SystemIOUtilities.out();
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown()
    {
        SystemIOUtilities.restoreSystemOut();
    }

    /**
     * 1. Test to make sure that the class exists.
     */
    @Hint("You don't seem to have created the " +
        className + " class correctly")
    @ScoringWeight(0.5)
    public void testClassTicTacToeBoardPrinterExists()
    {
        assertNotNull("No TicTacToeBoardPrinter class defined", thisClass);
    }

    /**
     * Class must be public.
     */
    @Hint("Your class must be public.")
    @ScoringWeight(0.5)
    public void testClassIsPublic()
    {
        assertTrue("The class must be public.",
            obj != null && Modifier.isPublic(obj.getClass().getModifiers()));
    }

    /**
     * 2. Make sure that the main method exists and is defined correctly.
     */
    @Hint("You must define a main() method for your class.")
    @ScoringWeight(0.5)
    public void testMainDefined()
    {
        assertTrue("Your class should have a method named main()",
            methods != null && methods.length == 1 
            && methods[0].getName().equals("main"));
    }

    /**
     * Check if main is public.
     */
    @Hint("The main() method must be public.")
    @ScoringWeight(0.5)
    public void testMainIsPublic()
    {
        assertIsPublic(getMethod("main"));
    }

    /**
     * Check if main is void.
     */
    @Hint("The main() method must be void.")
    @ScoringWeight(0.5)
    public void testMainIsVoid()
    {
        assertIsType(getMethod("main"), "void");
    }

    /**
     * Check if main is static.
     */
    @Hint("The main() method must be static.")
    @ScoringWeight(0.5)
    public void testMainIsStatic()
    {
        assertIsStatic(getMethod("main"));
    }
    
    /**
     * Check main parameters.
     */
    @Hint("The main() method must have one String[] parameter.")
    @ScoringWeight(0.5)
    public void testMainParametersCorrectlyDefined()
    {
        Class[] params = {String[].class};
        assertParameters(getMethod("main"), params);
    }
    
    // ------------- BEHAVIOR ---------------------------------------
    /**
     * Check output of main.
     */
    @Hint("The output from the main method is incorrect.")
    @ScoringWeight(1.0)
    public void testMainOutput()
    {
        Object[] params = {new String[]{}};
        invoke(obj, "main", params);
        assertEquals("The output from the main() method is incorrect.",
              "+---+---+---+" + EOL
            + "|   |   |   |" + EOL
            + "+---+---+---+" + EOL
            + "|   |   |   |" + EOL
            + "+---+---+---+" + EOL
            + "|   |   |   |" + EOL
            + "+---+---+---+" + EOL,
            history.getHistory());
    }
    
    /**
     *  Private methods for testing fields.
     *  Returns field given a name.
     */
    private Field getField(String fname) {
        int pos = fieldNames.indexOf(fname);
        return (pos < 0) ? null : fields[pos];
    }

    /**
     * Checks if the field is the correct type.
     */
    private void assertIsType(Field f, String desiredType) {
        assertTrue("Field " + f.getType().getSimpleName() +
                " is not of type " + desiredType,
            f.getType().getSimpleName().equals(desiredType));
    }

    /**
     * Asserts that the field is exists.
     */
    private void assertFieldExists(String fname) {
        assertTrue("Field " + fname + " does not exist.",
            fieldNames.contains(fname));
    }

    /**
     * Asserts that the field is private.
     */
    private void assertIsPrivate(Field f) {
        assertTrue("Field " + f.getName() + " is not private.",
            Modifier.isPrivate(f.getModifiers()));
    }

    /**
     * Asserts that the field is public.
     */
    private void assertIsPublic(Field f) {
        assertTrue("Field " + f.getName() + " is not public.",
            Modifier.isPublic(f.getModifiers()));
    }

    /**
     * Asserts that the field is static.
     */
    private void assertIsStatic(Field f) {
        assertTrue("Field " + f.getName() + " is not static.",
            Modifier.isStatic(f.getModifiers()));
    }

    /**
     * Asserts that the field is final.
     */
    private void assertIsFinal(Field f) {
        assertTrue("Field " + f.getName() + " is not a constant.",
            Modifier.isFinal(f.getModifiers()));
    }

    /**
     *  Private methods for testing methods.
     *  Returns field given a name.
     */
    private Method getMethod(String name) {
        int pos = methodNames.indexOf(name);
        return (pos < 0) ? null : methods[pos];
    }

    /**
     * Checks if the method has the correct return type.
     */
    private void assertIsType(Method m, String desiredType) {
        assertTrue("Method " + m.getName() +
                " does not have return type of " + desiredType,
            m.getReturnType().getSimpleName().equals(desiredType));
    }

    /**
     * Asserts that the method exists.
     */
    private void assertMethodExists(String name) {
        assertTrue("Method " + name + " does not exist.",
            methodNames.contains(name));
    }

    /**
     * Asserts that the method is private.
     */
    private void assertIsPrivate(Method m) {
        assertTrue("Method " + m.getName() + " is not private.",
            Modifier.isPrivate(m.getModifiers()));
    }

    /**
     * Asserts that the method is public.
     */
    private void assertIsPublic(Method m) {
        assertTrue("Method " + m.getName() + " is not public.",
            Modifier.isPublic(m.getModifiers()));
    }

    /**
     * Asserts that the method is static.
     */
    private void assertIsStatic(Method m) {
        assertTrue("Method " + m.getName() + " is not static.",
            Modifier.isStatic(m.getModifiers()));
    }

    /**
     * Asserts that the method is final.
     */
    private void assertIsFinal(Method m) {
        assertTrue("Method " + m.getName() + " is not final.",
            Modifier.isFinal(m.getModifiers()));
    }

    /**
     * Check type of each method parameter.
     */
    private void assertParameters(Method m, Class...specifiedParams)
    {
        Class[] declaredParams = m.getParameterTypes();
        if (specifiedParams.length != declaredParams.length)
            fail("Wrong number of parameters passed");
        else
        {
            for (int i = 0; i < specifiedParams.length; i++)
                assertEquals("Parameter " + i + " should be type " 
                    + specifiedParams[i].getSimpleName()
                    + " but it is actually "
                    + declaredParams[i].getSimpleName(),
                    declaredParams[i].getSimpleName(),
                    specifiedParams[i].getSimpleName());
        }
    }
}
