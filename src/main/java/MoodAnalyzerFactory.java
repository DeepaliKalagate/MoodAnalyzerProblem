import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory
{
    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass=Class.forName("MoodAnalyzer");
            Constructor moodConstructor=moodAnalyzerClass.getConstructor(String.class);
            Object moodObject=moodConstructor.newInstance(message,message);
            return (MoodAnalyzer) moodObject;
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException("Class name is wrong");
        }
        catch (NoSuchMethodException e)
        {
           throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
