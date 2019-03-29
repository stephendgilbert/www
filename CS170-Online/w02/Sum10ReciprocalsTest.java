import java.lang.reflect.*;
import java.util.*;
import java.io.*;

class Sum10ReciprocalsTest
{
    public static void main(String[] args)
    {
        Sum10ReciprocalsTest test
            = new Sum10ReciprocalsTest();
        test.add("TESTING CLASS STRUCTURE");
        test.add("==================================================");
        test.testClass();

        test.add("\nTESTING METHODS");
        test.testMethods();

        test.add("\nTESTING CLASS BEHAVIOR (10 points)");
        test.add("==================================================");
        test.testBehavior();
        test.dump();
    }

    public void add(String msg, boolean points)
    {
        score += points ? 1 : 0;
        possible++;
        results.add(String.format("%-50s ....  %d", msg, points ? 1 : 0));
    }

    public void add(String msg)
    {
        results.add(msg);
    }

    public void add(String msg, boolean points, int numPoints)
    {
        score += points ? numPoints : 0;
        possible += numPoints;
        results.add(String.format("%-50s ....  %d", msg, points ? numPoints : 0));
    }

    public void dump()
    {
        for (int i = 0; i < results.size(); i++)
            System.out.println(results.get(i));
        System.out.printf("%nTest score: %d/%d points %5.2f%s%n", (int)score, (int)possible,
            score / possible * 100, "%\n");
    }

    /**
     * Tests all the features of the class definition.
     */
    public void testClass()
    {
        testClassExists();
        testClassIsPublic();
    }

    /**
     *  Tests that the main() method is defined correctly.
     */
    public void testMethods()
    {
        testMainDefined();
        testMainIsPublic();
        testMainIsVoid();
        testMainIsStatic();
        testMainParametersCorrectlyDefined();
    }

    /**
     *  Tests that your program produces the correct output.
     */
    public void testBehavior()
    {
        testMainOutput();
    }

    private final String className = "Sum10Reciprocals";

    private Class thisClass;
    private Object obj;
    private Field[] fields;
    private ArrayList<String> fieldNames = new ArrayList<String>();
    private Constructor[] constructors;
    private Method[] methods;
    private ArrayList<String> methodNames = new ArrayList<String>();

    private PrintStream console;
    private static final String EOL = System.getProperty("line.separator");
    private ByteArrayOutputStream bytes;
    private ArrayList<String> results = new ArrayList<String>();

    private double score = 0;
    private double possible = 0;

    /**
     * Creates a new Test object.
     */
    public Sum10ReciprocalsTest()
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
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));

        try {
            obj = thisClass.newInstance();
        }
        catch (Throwable t) {
            /* nothing to do */
        }
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown()
    {
        System.setOut(console);
    }

    /**
     * 1. Test to make sure that the class exists.
     */
    public void testClassExists()
    {
        setUp();
        add("The class is defined correctly", thisClass != null);
        tearDown();
    }

    /**
     * Class must be public.
     */
    public void testClassIsPublic()
    {
        setUp();
        add("The class must be public.",
            obj != null && Modifier.isPublic(obj.getClass().getModifiers()));
        tearDown();
    }

    /**
     * 2. Make sure that the main method exists and is defined correctly.
     */
    public void testMainDefined()
    {
        setUp();
        assertMethodExists("main");
        tearDown();
    }

    /**
     * Check if main is public.
     */
    public void testMainIsPublic()
    {
        setUp();
        assertIsPublic("main");
        tearDown();
    }

    /**
     * Check if main is void.
     */
    public void testMainIsVoid()
    {
        setUp();
        assertIsType("main", "void");
        tearDown();
    }

    /**
     * Check if main is static.
     */
    public void testMainIsStatic()
    {
        setUp();
        assertIsStatic("main");
        tearDown();
    }

    /**
     * Check main parameters.
     */
    public void testMainParametersCorrectlyDefined()
    {
        setUp();
        Class[] params = {String[].class};
        assertParameters("main", params);
        tearDown();
    }

    /**
     * Check output of main.
     */
    public void testMainOutput()
    {
        setUp();
        Object[] params = {new String[]{}};
        Method m = getMethod("main");
        if (m == null)
            add("The output from the main() method is incorrect.", false, 10);
        else
        {
            try {
                m.invoke(null, params);
                add("The output from the main() method is correct.",
                    bytes.toString().equals(
                    "2.9289682539682538" + EOL), 10);
            }
            catch (Exception e)
            {
                add("Ran the main method successfully", false, 10);
            }
        }
        tearDown();
    }

    /**
     *  Private methods for testing methods.
     *  Returns field given a name.
     */
    private Method getMethod(String name)
    {
        int pos = methodNames.indexOf(name);
        return (pos < 0) ? null : methods[pos];
    }

    /**
     * Checks if the method has the correct return type.
     */
    private void assertIsType(String mname, String desiredType) {
        Method m = getMethod(mname);
        add("Method " + mname +
                " has return type of " + desiredType,
            m != null &&
            m.getReturnType().getSimpleName().equals(desiredType));
    }

    /**
     * Asserts that the method exists.
     */
    private void assertMethodExists(String name) {
        add("Method " + name + " exists.",
            methodNames.contains(name));
    }

    /**
     * Asserts that the method is private.
     */
    private void assertIsPrivate(String mname) {
        Method m = getMethod(mname);
        add("Method " + mname + " is private.",
            m != null && Modifier.isPrivate(m.getModifiers()));
    }

    /**
     * Asserts that the method is public.
     */
    private void assertIsPublic(String mname) {
        Method m = getMethod(mname);
        add("Method " + mname + " is public.",
            m != null && Modifier.isPublic(m.getModifiers()));
    }

    /**
     * Asserts that the method is static.
     */
    private void assertIsStatic(String mname) {
        Method m = getMethod(mname);
        add("Method " + mname + " is static.",
            m != null && Modifier.isStatic(m.getModifiers()));
    }

    /**
     * Asserts that the method is final.
     */
    private void assertIsFinal(String mname) {
        Method m = getMethod(mname);
        add("Method " + mname + " is final.",
            m != null && Modifier.isFinal(m.getModifiers()));
    }

    /**
     * Check type of each method parameter.
     */
    private void assertParameters(String mname, Class...specifiedParams)
    {
        Method m = getMethod(mname);
        Class[] declaredParams = m == null? null : m.getParameterTypes();
        if (m == null || specifiedParams.length != declaredParams.length)
            add("Correct number of parameters passed", false);
        else
        {
            for (int i = 0; i < specifiedParams.length; i++)
                add("Parameter " + i + " defined correctly ("
                    + specifiedParams[i].getSimpleName() + ")",
                    declaredParams[i].getSimpleName().equals(
                    specifiedParams[i].getSimpleName()));
        }
    }

}

