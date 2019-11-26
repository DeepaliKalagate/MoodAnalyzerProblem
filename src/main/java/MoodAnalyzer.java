public class MoodAnalyzer
{
    private  String message;
    public MoodAnalyzer()
    {
    }

    public  MoodAnalyzer(String message)
    {
        this.message=message;
    }

    public String analyzeMood(String message) throws MoodAnalysisException
    {
        this.message=message;
        return analyzeMood();
    }
    public String analyzeMood() throws MoodAnalysisException
    {
        try
        {
            if (message.contains("Happy"))
                return "SAD";
            return "Happy";
        }
        catch(NullPointerException e)
        {
            throw new MoodAnalysisException("Please enter Proper Message");
        }
    }
}
