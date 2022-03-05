public interface Util {
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public static String fillString(String s)
    {
        int letters = 10;
        char c = ' ';
        int amount = letters-s.length();
        StringBuilder build = new StringBuilder(s);

        for(int i = 0; i < amount; i++)
        {
            build.append(c);
        }
        return build.toString();
    }
}
