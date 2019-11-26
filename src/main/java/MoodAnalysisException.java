public class MoodAnalysisException extends Exception
{
    enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY
    }
    ExceptionType type;

    public MoodAnalysisException(String message,ExceptionType type)
    {
        super(message);
        this.type=type;
    }
}
