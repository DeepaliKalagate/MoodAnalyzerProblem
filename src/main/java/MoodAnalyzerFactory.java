import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory
{
    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalysisException {
        try
        {
            Class moodAnalyzerClass=Class.forName("MoodAnalyzer1");
            Constructor moodConstructor=moodAnalyzerClass.getConstructor(String.class);
            Object moodObject=moodConstructor.newInstance(message);
            return (MoodAnalyzer) moodObject;
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException("Class name is wrong");
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
