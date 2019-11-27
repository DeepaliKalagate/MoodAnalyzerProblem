import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector
{
    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message, message);
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


    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalysisException
    {
        try
        {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException("Define proper Method Name", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalysisException("May be issue with data entry", MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE);
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalysisException("May be issue with data entry", MoodAnalysisException.ExceptionType.NO_ACCESS);
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException
    {
        try
        {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);
        }
        catch (NoSuchFieldException e)
        {
            throw new MoodAnalysisException("Define proper field name", MoodAnalysisException.ExceptionType.NO_SUCH_FIELD);
        }
        catch (IllegalAccessException e)
        {
            throw new MoodAnalysisException("May be issue with data entry", MoodAnalysisException.ExceptionType.NO_ACCESS);
        }
    }
}