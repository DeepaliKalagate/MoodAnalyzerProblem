import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {
    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalysisException {
        try {
            Class moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message, message);
            return (MoodAnalyzer) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Class name is wrong");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(Class<?> ... param) throws  MoodAnalysisException
    {
        try
        {
            Class<?> moodAnalyserClass = Class.forName("MoodAnalyzer");
            return moodAnalyserClass.getConstructor(param);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException(e.getMessage(), MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(e.getMessage(), MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object ... message) throws MoodAnalysisException {
        try
        {
            return constructor.newInstance(message);
        }
        catch (InstantiationException | InvocationTargetException e)
        {
            throw new MoodAnalysisException(e, MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalysisException(e, MoodAnalysisException.ExceptionType.NO_ACCESS);
        }
    }
}